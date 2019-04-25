package cn.com.qcc.tenement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.com.qcc.common.CentFileSend;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.ParamUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.UsercentMapper;
import cn.com.qcc.mess.util.SendMessUtil;
import cn.com.qcc.pojo.Usercent;
import cn.com.qcc.pojo.UsercentExample;
import cn.com.qcc.queryvo.HouseOrderCustomer;
import cn.com.qcc.service.HouseService;

/**
 * 此方法专门做微信退款用。
 */
@Controller
public class WeiXinPayRefund {

	@Autowired
	private HouseService houseService;
	@Autowired
	private UsercentMapper usercentMapper;
	@Resource  
	private Destination houseTuiKuan;
	@Autowired 
	private JmsTemplate jmsTemplate;

	/**
	 * 预定房源退款操作
	 * @param : houseorderid 预定订单Id
	 **/
	@RequestMapping(method = RequestMethod.POST, value = "/houseorderrefund")
	@Transactional
	@ResponseBody
	public ResultMap refund(String houseorderid, HttpServletRequest request, Long userid, String refundmess) {
		if (houseorderid == null || "".equals(houseorderid) || userid == null) {
			return ResultMap.build(400, "检查订单/参数");
		}

		HouseOrderCustomer houseorder = houseService.searchorderpay(Long.valueOf(houseorderid));
		if (houseorder == null) {
			return ResultMap.build(400, "检查订单");
		}
		// 校验当前订单是否可以退
		if (houseorder.getPaystate() == 6) {
			return ResultMap.build(400, "该订单已退款");
		} else if (houseorder.getPaystate() == 2) {
			return ResultMap.build(400, "未支付不可退款");
		} else if (houseorder.getPaystate() == 5) {
			return ResultMap.build(400, "已入住不可退款");
		} else if (houseorder.getPaystate() == 1 || houseorder.getPaystate() == 4) {
			// 如果是用户发起的退款判断当前用户
			if (houseorder.getSenduserid() == userid.longValue() || houseorder.getUserid() == userid.longValue()) {
				if (houseorder.getUserid() == userid) {
					if (houseorder.isFlag() == false) {
						return ResultMap.build(400, "订单退款超时");
					}
				}
				
				// 判断是否有租约关系
				List<Usercent> usercents = checkHaseCent(houseorder.getUserid() , houseorder.getHouseid());
				if (CheckDataUtil.checkNotEmpty(usercents)) {
					return ResultMap.build(400, "当前房源有待处理租约");
				}
				
				
				// 退款金额
				String account = houseorder.getPrices() * 100 + "";
				account = account.substring(0, account.lastIndexOf("."));
				// 退款订单号
				String outTradeNo = houseorder.getWeixinorder();
				System.out.println(account + "=============" + outTradeNo); 
				// 通过参数请求形成 xml 数据
				String xmlparam = ParamUtil.getRefundParam(account, outTradeNo);
				// 执行证书请求 和 xml 数据执行证书请求
				String xml = CentFileSend.house_refund(xmlparam);
				// 通过调用工具判断解析的xml最终数据
				ResultMap checkmap = ParamUtil.checkxmlpres(xml);
				// 说明微信操作成功
				if (checkmap.getCode() == 200) {
					// 如果退款成功执行相关业务逻辑
					houseService.updatehouseorder(houseorder.getUserid(), Long.valueOf(houseorderid), 6, refundmess);
					String sendData  = houseorderid;
					SendMessUtil.sendData(jmsTemplate, houseTuiKuan, sendData);
				}
				return checkmap;
			} else {
				return ResultMap.build(400,"请不要退款别人的订单");
			}
			
		} else {
			return ResultMap.build(400, "错误的订单状态");
		}
	}

	private List<Usercent> checkHaseCent(Long userid, Long houseid) {
		UsercentExample example = new UsercentExample();
		UsercentExample.Criteria criteria = example.createCriteria();
		criteria.andUsercentidEqualTo(userid);
		criteria.andHouseidEqualTo(houseid);
		List<Integer> values = new ArrayList<>();
		values.add(1);
		values.add(2);
		criteria.andCentstateIn(values );
		List<Usercent> list = usercentMapper.selectByExample(example);
		return list;
	}

	

}
