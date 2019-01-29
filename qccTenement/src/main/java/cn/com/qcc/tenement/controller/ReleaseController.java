package cn.com.qcc.tenement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.jpay.ext.kit.IpKit;
import com.jpay.ext.kit.PaymentKit;
import com.jpay.weixin.api.WxPayApi;
import com.jpay.weixin.api.WxPayApiConfig;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.PayCommonConfig;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Articletype;
import cn.com.qcc.pojo.Delivery;
import cn.com.qcc.pojo.Myorder;
import cn.com.qcc.pojo.Parametype;
import cn.com.qcc.pojo.Releasetable;
import cn.com.qcc.pojo.Transmitsend;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.queryvo.ReleaseCustomer;
import cn.com.qcc.queryvo.ReleaseVo;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.InteService;
import cn.com.qcc.service.ReleaseService;
import cn.com.qcc.service.UserService;
import weixin.util.H5ScencInfo;
import weixin.util.H5ScencInfo.H5;
import weixin.util.MD5Util;

@Controller
public class ReleaseController {

	@Autowired
	ReleaseService releaseService;
	@Autowired
	InteService inteService;
	@Autowired
	UserService userService;
	
	public static WxPayApiConfig getApiConfig() {
		return WxPayApiConfig.New().setAppId(PayCommonConfig.qcc_gzhappid)
				.setMchId(PayCommonConfig.qcc_gzh_mchid).setPaternerKey(PayCommonConfig.qcc_gzh_partnerKey)
				.setPayModel(WxPayApiConfig.PayModel.BUSINESSMODEL);
	}
	
	// 查询待发布商品的规格参数
	@RequestMapping("/articledetail/searchparam")
	@ResponseBody
	public ResultMap searchParamTypeNmae(String codeids) {
		// 通过传过来的参数查询商品的规格参数
		if (CheckDataUtil.checkNotMatrhNumber(codeids, ",")) {return ResultMap.build(400, "非法参数");}
		String [] codeid = codeids.split(",");
		
		// 查询一级的规格参数
		List<ReleaseCustomer> releaseList = releaseService.searchFirstTypeName(codeid);
		//查询二级的规格参数
		List<Parametype> paramList = releaseService.searchSecondTypeName(codeid);
		//合并参数
		setParamFirstAndNext(releaseList , paramList );
		return ResultMap.IS_200(releaseList);
	}
	
	
	/**合并参数**/
	private void setParamFirstAndNext(List<ReleaseCustomer> releaseList, List<Parametype> paramList) {
		for (ReleaseCustomer paramfirst : releaseList) {
			List<Parametype> addList = new ArrayList<>();
			for (Parametype paramnext : paramList) {
				// 说明这个佣金在房子上面
				if (CheckDataUtil.checkisEqual(paramfirst.getCodeid(), paramnext.getFatherid())) {
					addList.add(paramnext);
				}
			}
			paramfirst.setParamList(addList);
		}
		
	}

	// 部落发布物品
	@RequestMapping("/release/pushdetail")
	@ResponseBody
	public ResultMap pushdetail(ReleaseCustomer releaseCustomer) {
		
		if (releaseCustomer.getPrices() == null) {
			return ResultMap.build(404, "请输入价格");
		}
		if (releaseCustomer.getPicture() == null || "".equals(releaseCustomer.getPicture())) {
			return ResultMap.build(404, "请插入图片");
		}
		
		ResultMap resultMap = releaseService.pushdetail(releaseCustomer);
	
		return resultMap;
	}

	// 通过typeid查询对应的type
	@RequestMapping("/release/typename")
	@ResponseBody
	public ResultMap gettypename(String typeid) {
		ResultMap resultMap = releaseService.gettypename(typeid);
		return resultMap;
	}

	// 通过type的id查询对应的code和name
	@RequestMapping("/release/codename")
	@ResponseBody
	public ResultMap getcodename(Long typeid) {
		ResultMap resultMap = releaseService.getcodename(typeid);
		return resultMap;
	}

	// 批量发布物品
	@RequestMapping("/release/batch")
	@ResponseBody
	public ResultMap batch(ReleaseVo releaseVo) {
		ResultMap resultMap = releaseService.batch(releaseVo);
		return resultMap;
	}

	// 商城首页需要加载的数据
	@RequestMapping("/release/shopindex")
	@ResponseBody
	public ResultMap shopindex(ReleaseVo releaseVo, @RequestParam(defaultValue = "0") String currentpage,
			int pagesize) {

		Map<String, Object> map = new HashMap<>();
		// 获取所有物品的总分类
		List<Articletype> articlelist = releaseService.getarticlelist();

		// 主页显示，最新的商品。
		PageQuery pagequery = new PageQuery();
		int infoCount = releaseService.getnewreleaseCount(releaseVo);
		pagequery.setPageParams(infoCount, pagesize, Integer.parseInt(currentpage));
		releaseVo.setPagequery(pagequery);
		List<ReleaseCustomer> releaselist = releaseService.getnewrelease(releaseVo);
		// 拼接串
		montage(releaselist);
		map.put("pagequery", pagequery);
		map.put("releaselist", releaselist);
		map.put("articlelist", articlelist);
		return ResultMap.IS_200(map);
	}

	private void montage(List<ReleaseCustomer> releaselist) {
		for (ReleaseCustomer list : releaselist) {
			if (list.getCityname() != null && !"".equals(list.getCityname())) {
				list.setCityname("来自:" + list.getCityname());
			}
			if (list.getTribename() != null && !"".equals(list.getTribename())) {
				list.setTribename("部落|" + list.getTribename());
			}
		}
	}

	// 点击我想要，进入物品规格参数页面
	@RequestMapping("/release/Iwant")
	@ResponseBody
	private ResultMap Iwant(Long articledetailid) {
		ResultMap resultMap = releaseService.getypeidbyarticleid(articledetailid);
		return resultMap;
	}

	// 根据物品的参数集合和物品详情的ID查询物品的价格和库存
	@RequestMapping("/release/simpledetail")
	@ResponseBody
	private ResultMap getsimpledetail(Releasetable releasetable) {
		ResultMap resultMap = releaseService.getsimpledetail(releasetable);
		return resultMap;
	}

	// 查询用户的收货地址
	@RequestMapping("/release/mydelivery")
	@ResponseBody
	private ResultMap mydelivery(Long userid) {
		List<Delivery> deliveries = releaseService.mydelivery(userid);
		return ResultMap.IS_200(deliveries);
	}

	// 支付宝支付，生成订单
	@RequestMapping("/release/orderzfb")
	@ResponseBody
	private ResultMap orderzfb(Myorder order, String returnstr, HttpServletRequest request) {

		// 判断用户七彩币是否有足够的余额
		Vipcount vipcount = releaseService.getuserbalance(order);

		// 首先创建一个支付订单
		if (vipcount.getBalance() > order.getTotalprices()) {
			ResultMap resultMap = releaseService.createorder(order);
			return resultMap;
		}
		String str = "";
		String msg = "";
		if ("zfb".equals(returnstr)) {
			order.setOrderstr(IDUtils.genItemId() + "sc" + order.getUserid());
			String url = PayCommonConfig.zfb_consume_recharge;
			str = generateZFB(order, url);
			msg = "zfb";
		}
		if ("h5".equals(returnstr)) {
			String notify_url = PayCommonConfig.consumepayreturn;
			str = generateWXh5(order, notify_url, request);
			msg = "h5";
		}
		return ResultMap.build(400, msg, str);

	}

	private String generateWXh5(Myorder order, String notify_url, HttpServletRequest request) {
		String ip = IpKit.getRealIp(request);
		if (com.jpay.ext.kit.StrKit.isBlank(ip)) {
			ip = "127.0.0.1";
		}
		String conId = IDUtils.genItemId();
		String total_count = order.getTotalprices() + "";
		String total_monery = MD5Util.getMoney(total_count);
		String out_trade_no = conId + "sc" + order.getUserid();
		H5ScencInfo sceneInfo = new H5ScencInfo();
		H5 h5_info = new H5();
		h5_info.setType("Wap");
		// 此域名必须在商户平台--"产品中心"--"开发配置"中添加
		h5_info.setWap_url(PayCommonConfig.mainqccweb);
		h5_info.setWap_name("腾讯充值");
		sceneInfo.setH5_info(h5_info);
		// WxPayApiConfig wxPayApiConfig=getApiConfig();
		Map<String, String> params = WxPayApiConfig.New().setAppId(PayCommonConfig.qcc_gzhappid).
				setMchId(PayCommonConfig.qcc_gzh_mchid).setBody("七彩巢充值")
				.setSpbillCreateIp(ip).setTotalFee(total_monery).setTradeType(WxPayApi.TradeType.MWEB)
				.setNotifyUrl(notify_url).setPaternerKey(PayCommonConfig.qcc_gzh_partnerKey)// String.valueOf(System.currentTimeMillis())
				.setOutTradeNo(out_trade_no)
				.setSceneInfo(
						"{\"h5_info\": {\"type\":\"IOS\",\"app_name\": \"mtgg\",\"package_name\": \"com.tencent.tmgp.sgame\"}}")
				.setAttach("七彩巢充值").build();
		String xmlResult = WxPayApi.pushOrder(false, params);
		Map<String, String> result = PaymentKit.xmlToMap(xmlResult);

		String return_code = result.get("return_code");
		String return_msg = result.get("return_msg");
		if (!PaymentKit.codeIsOK(return_code)) {
			//log.error("return_code>" + return_code + " return_msg>" + return_msg);
			throw new RuntimeException(return_msg);
		}
		String result_code = result.get("result_code");
		if (!PaymentKit.codeIsOK(result_code)) {
			throw new RuntimeException(return_msg);
		}
		//String prepay_id = result.get("prepay_id");
		String mweb_url = result.get("mweb_url");
		return mweb_url;
	}

	private String generateZFB(Myorder order, String returnUrl) {
		// 支付宝网关固定值不需要修改
		String URL = PayCommonConfig.qcc_zfb_zfwg;
		// APPID即创建应用后生成
		String APP_ID = PayCommonConfig.qcc_zfb_appid;
		// 开发者应用私钥，由开发者自己生成
		String APP_PRIVATE_KEY = PayCommonConfig.qcc_zfb_partnerKey;
		// 数据返回格式
		String FORMAT = "json";
		// 请求和签名使用的字符编码格式，支持GBK和UTF-8
		String CHARSET = "utf-8";
		// 支付宝公钥，由支付宝生成
		String ALIPAY_PUBLIC_KEY = PayCommonConfig.qcc_zfb_publicKey;
		// 商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2
		String SIGN_TYPE = "RSA";
		AlipayClient alipayClient = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET,
				ALIPAY_PUBLIC_KEY, SIGN_TYPE); // 获得初始化的AlipayClient
		AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();// 创建API对应的requestalipayRequest
		alipayRequest.setReturnUrl("https://www.zzw777.com/pages/PaymentSuccess.html");
		alipayRequest.setNotifyUrl(returnUrl);// 在公共参数中设置回跳和通知地址
		alipayRequest.setBizContent("{" + " \"out_trade_no\":\"" + order.getOrderstr() + "\"," + " \"total_amount\":\""
				+ order.getTotalprices() + "\"," + " \"subject\":\"" + "商品购买" + "\","
				+ " \"product_code\":\"QUICK_WAP_PAY\"" + " }");// 填充业务参数
		String form = "";
		try {
			form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
		} catch (Exception e) {
			e.printStackTrace();
		}
		return form;
	}

	@RequestMapping("/release/checkmonery")
	@ResponseBody
	private ResultMap checkmonery(Myorder order) {
		// 判断用户七彩币是否有足够的余额
		UserCustomer vipcount = releaseService.getbalanceandphone(order);
		// 首先创建一个支付订单
		if (vipcount.getBalance() > order.getTotalprices()) {
			ResultMap resultMap = releaseService.createorder(order);
			return resultMap;
		}
		return ResultMap.build(500, "可用余额小于购买金额", vipcount);
	}

	// 本系统支付成功后的回调
	@RequestMapping("/release/payreturn")
	@ResponseBody
	private ResultMap payreturn(Myorder myorder, String payword, Releasetable releasetable) {
		ResultMap resultMap = releaseService.payreturn(myorder, payword, releasetable);
		return resultMap;
	}

	// 获得所有的规格参数
	@RequestMapping("/release/searchparamtype")
	@ResponseBody
	private ResultMap allarticle(HttpServletRequest request , Integer fatherid) {
		List<Parametype> parametypes = releaseService.allarticle(fatherid);
		return ResultMap.IS_200(parametypes);
	}

	// 添加规格参数
	@RequestMapping("/release/addarticle")
	@ResponseBody
	private ResultMap addarticle(Parametype parametype) {
		ResultMap resultMap = releaseService.addarticle(parametype);
		return resultMap;
	}

	// 修改分类名称
	@RequestMapping("/release/editarticle")
	@ResponseBody
	private ResultMap editarticle(Parametype parametype) {
		ResultMap resultMap = releaseService.editarticle(parametype);
		return resultMap;
	}

	// 修改分类名称
	@RequestMapping("/release/getcodenamebytypeid")
	@ResponseBody
	private ResultMap getcodenamebytypeid(Parametype parametype) {
		ResultMap resultMap = releaseService.getcodenamebytypeid(parametype);
		return resultMap;
	}

	// 修改分类名称
	@RequestMapping("/release/editcodenamebycodeid")
	@ResponseBody
	private ResultMap editcodenamebycodeid(Parametype parametype) {
		ResultMap resultMap = releaseService.editcodenamebycodeid(parametype);
		return resultMap;
	}

	// 添加分类
	@RequestMapping("/release/addtypename")
	@ResponseBody
	private ResultMap addtypename(HttpServletRequest request, Parametype parametype) {

		ResultMap resultMap = releaseService.addtypename(parametype);
		return resultMap;
	}
	
	
	// 检查发射频率
	@RequestMapping("/mess/checkSendFlag")
	@ResponseBody
	private ResultMap checkIsSend (Transmitsend send) {
		ResultMap resultMap = releaseService.checkIsSend(send);
		return resultMap;
	}
}
