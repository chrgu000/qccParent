package cn.com.qcc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.AuthorizeMapper;
import cn.com.qcc.mapper.DetaileaddressMapper;
import cn.com.qcc.mymapper.QiuZuCustomerMapper;
import cn.com.qcc.pojo.Authorize;
import cn.com.qcc.pojo.AuthorizeExample;
import cn.com.qcc.pojo.Detaileaddress;
import cn.com.qcc.pojo.DetaileaddressExample;
import cn.com.qcc.queryvo.AuthCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired AuthorizeMapper authorizeMapper;
	@Autowired QiuZuCustomerMapper qiuZuCustomerMapper;
	@Autowired DetaileaddressMapper detaileaddressMapper;

	/**发布添加委托
	 * @param code : 区域CODE
	 * @param userid : 用户ID
	 * @param title : 委托标题
	 * @param housetype : 户型
	 * @param classification : 分类
	 * @param site : 地址
	 * @param prices : 价格
	 * @param area : 面积
	 * @param metroid : 地铁ID
	 * @param linkman : 联系人
	 * @param linkphone : 联系电话
	 * @param describes : 描述
	 * @param state : 0-冻结，1-上架，2-下架，3-移除
	 * @param update_time : 创建时间
	 * @param create_time : 更新时间
	 * @param authorizeid : 委托ID 如果有ID 表示编辑
	 * **/
	public ResultMap insertorupdateauthorize(Authorize authorize,Detaileaddress detaileaddress) {
		
		if (detaileaddress.getDetailes() == null || "".equals(detaileaddress.getDetailes())) {
			return ResultMap.build(400, "请检查你的详情地址！");
		}
		if (authorize.getMetroid() == null) {
			authorize.setMetroid(-1L);
		}
		Long detailid = -1L;
		detailid = Long.valueOf(checkeDetailaAddressExists(detaileaddress));
		if (detailid == -1) {
			detaileaddressMapper.insertSelective(detaileaddress);
			detailid = Long.valueOf(detaileaddress.getDetailid());
		}
		if(!"".equals(authorize.getAuthorizeid()) && authorize.getAuthorizeid() !=null){
			authorize.setDetailid(detailid);
			authorize.setState(1);
			authorize.setUpdate_time(new Date());
			authorizeMapper.updateByPrimaryKeySelective(authorize);
			return ResultMap.IS_200();
		}else{
			authorize.setDetailid(detailid);
			authorize.setCreate_time(new Date());
			authorize.setUpdate_time(new Date());
			// 0-冻结，1-上架，2-下架，3-移除
			authorize.setState(1);
			authorizeMapper.insertSelective(authorize);
			return ResultMap.IS_200();
		}
	}

	/**  查询我的委托
	 *   @param userid : 用户ID
	 * **/
	public List<Authorize> myauthorize(Long userid) {
		AuthorizeExample example = new AuthorizeExample();
		AuthorizeExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		// 删除
		criteria.andStateNotEqualTo(3);
		List<Authorize> authList = authorizeMapper.selectByExample(example);
		return authList;
	}

	/** 更新我的委托的状态
	 * * @param state : 0-冻结，1-上架，2-下架，3-移除
	 * * @param authorizeid : 委托ID
	 * **/ 
	public void changemyAuth(Authorize authorize) {
		authorize.setUpdate_time(new Date());
		authorizeMapper.updateByPrimaryKeySelective(authorize);
	}

	/** 编辑委托的查询
	* * @param authorizeid : 委托ID
	 * **/
	public Authorize getauthbyid(Long authorizeid) {
		return authorizeMapper.selectByPrimaryKey(authorizeid);
	}

	
	// 检查详情地址是否存在
		public Long checkeDetailaAddressExists(Detaileaddress detaileaddress) {
			DetaileaddressExample example = new DetaileaddressExample();
			DetaileaddressExample.Criteria criteria = example.createCriteria();
			if (!"".equals(detaileaddress.getDetailes()) && detaileaddress.getDetailes() != null) {
				criteria.andDetailesEqualTo(detaileaddress.getDetailes());
			}
			if (!"".equals(detaileaddress.getLatitude()) && detaileaddress.getLatitude() != null) {
				criteria.andLatitudeEqualTo(detaileaddress.getLatitude());
			}
			if (!"".equals(detaileaddress.getLongitude()) && detaileaddress.getLongitude() != null) {
				criteria.andLongitudeEqualTo(detaileaddress.getLongitude());
			}
			List<Detaileaddress> selectByExample = detaileaddressMapper.selectByExample(example);
			if (!selectByExample.isEmpty() || selectByExample.size() > 0) {
				Detaileaddress detail_search = selectByExample.get(0);
				return detail_search.getDetailid();
			} else {
				return -1L;
			}

		}

		/**后台查询所有的委托
		 * @param currentpage : 当前页码
		 * @param pagesize : 每页多少数据
		 * **/
		public List<AuthCustomer> getallauth(HouseVo houseVo) {
			// TODO Auto-generated method stub
			return qiuZuCustomerMapper.getallauth(houseVo);
		}
		public int getallauthCount(HouseVo houseVo) {
			// TODO Auto-generated method stub
			return qiuZuCustomerMapper.getallauthCount(houseVo);
		}

}
