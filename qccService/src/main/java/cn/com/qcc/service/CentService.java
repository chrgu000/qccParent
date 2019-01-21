package cn.com.qcc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Finance;
import cn.com.qcc.pojo.Housepersion;
import cn.com.qcc.pojo.Mycent;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.UserCentCustomer;
import cn.com.qcc.queryvo.UserCentVo;


public interface CentService {

	/**
	 *	根据传过来的IDS 手动收款
	 * @param housepayids : 前台传过来的housepayid 的集合。
	 **/
	ResultMap gathering(String housepayids);
	
	
	/**
	 *	添加入驻人
	 * @param usercentnum : 合同编号 [必填]。
	 * @param username : 姓名 [必填]
	 * @param sex : 性别 [必填]
	 **/
	ResultMap addhousepersion(Housepersion housepersion ,Long userid);

	/**
	 *	删除入驻人
	 * @param housepersionid : 入驻人主键
	 * @param type : type -delete 删除 。type - out 搬离
	 **/
	ResultMap deletehousepersionbyid(Long housepersionid ,String type);

	/**
	 *	查询租客列表
	 * @param houseVo : 
	 **/
	List<UserCentCustomer> housepersionlist(HouseVo houseVo);
	int housepersionlistCount(HouseVo houseVo);

	
	/**
	 *	根据房源ID查询历史租客
	 * @param houseid : 房源ID
	 **/
	List<Housepersion> historyhouserpersion(Long houseid);

	/**
	 *	根据租客详情id查询租客详情信息
	 * @param housepersionid : 租客详情主键
	 **/
	Housepersion searchhousepersionbyid(Long housepersionid);

	/**
	 *	根据租约编号查询租客信息
	 * @param usercentnum : 根据租约编号查询租客信息
	 **/
	List<Housepersion> gethouserpersionbycentnum(String usercentnum);

	
	/**
	 *	根据账单ID查询账单详情
	 * @param housepayid : 当前账单id
	 **/
	UserCentCustomer gethousepaybyid(Long housepayid);

	/**
	 *	根据租约编号查询承租人信息
	 * @param usercentnum : 租约编号
	 **/
	Housepersion getcentuserbyCentnum(String usercentnum);

	
	/**
	 *	催单发送短信
	 * @param rentphone : 租户电话号码
	 *  @param content : 短信内容
	 *  @param landphone : 房东或者管理电话
	 *   @param state : 'yes'表示给自己发
	 **/
	ResultMap sendmess(Long rentphone, String content, 
			HttpServletRequest request, Long landphone, String state);

	/**
	 *	根据账单编号查询租客短信信息
	 * @param housepayid : 账单编号
	 **/
	UserCentCustomer messdetail(Long housepayid);

	/**
	 *	根据userid 和查询条件查询营业报表
	 * @param userid : 用户的ID
	 **/
	List<UserCentCustomer> statement(UserCentVo userCentVo);
	int statementCount(UserCentVo userCentVo);


	/**
	 *	统计待收总计和没有收总计
	 * @param userid : 用户的ID
	 **/
	UserCentCustomer totalbil(UserCentVo userCentVo);

	/**
	 * 根据查询条件查询营业报表实收房租和其他费用
	 * **/
	UserCentCustomer totalbilreal(UserCentVo userCentVo);

	/**
	 *	根据房号分组查询营业报表 COUNT
	 * @param userid : 用户的ID
	 **/
	int bussinessCount(UserCentVo userCentVo);

	
	
	/**
	 *	根据房东的ID查询小区列表
	 * @param userid : 用户的ID
	 **/
	List<BuildingCustomer> villagesbylanduserid(Long userid);

	/**
	 *	根据房东ID。查账单列表
	 * @param userid : 用户的ID
	 **/
	List<UserCentCustomer> bilelist(UserCentVo userCentVo);
	int bilelistCount(UserCentVo userCentVo);

	/**
	 *	账单的二级联动条件之第一级
	 **/
	List<Finance> financebiles(Long financeid);

	/**
	 *	总账单统计整体数据
	 **/
	HouseCustomer bilelisttotal(UserCentVo userCentVo);

	/**
	 *	查询交易流水
	 **/
	List<UserCentCustomer> builnum(UserCentVo userCentVo);
	int builnumCount(UserCentVo userCentVo);

	/**
	 *	查询交易流水统计进出账
	 **/
	UserCentCustomer builnumdetail(UserCentVo userCentVo);
	

	
	

	/**
	 *	房东查询租户合同
	 **/
	List<UserCentCustomer> landsearchusercent(HouseVo houseVo);
	int landsearchusercentCount(HouseVo houseVo);

	/**
	 *	查询合同管理
	 *@param userid : 用户ID
	 **/
	List<Mycent> mycentlist(Long userid);

	/**
	 *	编辑合同的查询
	 **/
	Mycent editsearchmycent(Mycent mycent);

	/**
	 *	编辑合同
	 **/
	void editmycent(Mycent mycent);

	/**
	 *	删除合同
	 **/
	void deletemycent(Long mycentid);


}
