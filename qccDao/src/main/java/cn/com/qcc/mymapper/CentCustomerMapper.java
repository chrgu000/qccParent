package cn.com.qcc.mymapper;

import java.util.List;

import cn.com.qcc.pojo.Housepersion;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.UserCentCustomer;
import cn.com.qcc.queryvo.UserCentVo;

public interface CentCustomerMapper {
	
	//根据房源ID查询历史租客
	List<Housepersion> historyhouserpersion(Long houseid);

	//根据账单ID查询账单的详情
	UserCentCustomer gethousepaybyid(Long housepayid);
	
	//根据租约编号查询承租人信息
	Housepersion getcentuserbyCentnum(String usercentnum);
	
	//通过账单ID查询出发送短信的租户信息
	UserCentCustomer messdetailrent(Long housepayid);
	
	//根据查询条件查询营业报表
	List<UserCentCustomer> statement(UserCentVo userCentVo);
	
	//根据查询条件查询营业报表
	List<UserCentCustomer> bussiness(UserCentVo userCentVo);
	
	//根据查询条件查询营业报表待收款和未收款
	UserCentCustomer totalbil(UserCentVo userCentVo);
	
	//根据查询条件查询营业报表实收房租和其他费用
	UserCentCustomer totalbilreal(UserCentVo userCentVo);
	
	//查询分页参数
	int bussinessCount(UserCentVo userCentVo);
	
	//查询分页参数
	int statementCount(UserCentVo userCentVo);
	
	//根据房东的userid 查询小区列表
	List<BuildingCustomer> villagesbylanduserid(Long userid);
	
	//根据房东ID 查询账单列表
	List<UserCentCustomer> bileist(UserCentVo userCentVo);
	
	//根据房东ID 查询账单列表count
	int bilelistCount(UserCentVo userCentVo);
	
	//统计整体数据
	HouseCustomer bilelisttotal(UserCentVo userCentVo);
	
	//这里查询交易流水
	List<UserCentCustomer> builnum(UserCentVo userCentVo);
	
	//这里查询交易流水统计
	int builnumCount(UserCentVo userCentVo);
	
	//这里查询交易流水统计总账
	UserCentCustomer builnumdetail(UserCentVo userCentVo);
	
	//房东查询租户合同统计
	int landsearchusercentCount(HouseVo houseVo);
	
	//房东查询租户合同
	List<UserCentCustomer> landsearchusercent(HouseVo houseVo);


}
