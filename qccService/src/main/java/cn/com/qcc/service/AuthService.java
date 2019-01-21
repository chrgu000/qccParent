package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Authorize;
import cn.com.qcc.pojo.Detaileaddress;
import cn.com.qcc.queryvo.AuthCustomer;
import cn.com.qcc.queryvo.HouseVo;

/**
 * 发布委托
 **/
public interface AuthService {

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
	ResultMap insertorupdateauthorize(Authorize authorize,Detaileaddress detaileaddress);
	
	
	/**  查询我的委托
	 *   @param userid : 用户ID
	 * **/
	List<Authorize> myauthorize(Long userid);
	
	
	/** 更新我的委托的状态
	 * * @param state : 0-冻结，1-上架，2-下架，3-移除
	 * * @param authorizeid : 委托ID
	 * **/ 
	void changemyAuth(Authorize authorize);

	/** 编辑委托的查询
	* * @param authorizeid : 委托ID
	 * **/
	Authorize getauthbyid(Long authorizeid);
	
	
	/**后台查询所有的委托
	 * @param currentpage : 当前页码
	 * @param pagesize : 每页多少数据
	 * **/
	List<AuthCustomer> getallauth(HouseVo houseVo);
	
	/**后台查询所有的委托
	 * @param currentpage : 当前页码
	 * @param pagesize : 每页多少数据
	 * **/
	int getallauthCount(HouseVo houseVo);

}
