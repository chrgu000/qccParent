package cn.com.qcc.mymapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.qcc.pojo.Payexpert;
import cn.com.qcc.queryvo.HousepayCustomer;
import cn.com.qcc.queryvo.PayexpertCustomer;
import cn.com.qcc.queryvo.UserCentCustomer;
import cn.com.qcc.queryvo.UserRoomCustomer;

public interface UserRoomCustomerMapper {
	
	/**查询房东的登录信息**/
	UserRoomCustomer getLandMess(Long telephone);

	/**查询管理员的登录信息**/
	UserRoomCustomer getManagerMess(Long telephone);
	
	/**租约详情的价格**/ 
	public UserCentCustomer usercentdetailprices(String usercentnum);
	
	/**  查询租约详情信息 **/
	public UserCentCustomer usercentdetail(String usercentnum);
	
	/**  租约详情的 账单 **/
	public List<UserCentCustomer> usercentdetaillist(String usercentnum);
	
	/** 根据租约编号查询财务信息 **/ 
	public List<UserCentCustomer> financialbycentnum(String usercentnum);
	
	/**这里是查询押金列表**/ 
	public List<UserCentCustomer> yacentsbycentnum(String usercentnum);
	
	/** 根据租约ID查询分期信息 **/ 
	public List<UserCentCustomer> centpayexbyid(Long usercentid);
	
	/** 查询基本费用**/ 
	public List<UserCentCustomer> firstpay(Long usercentid);
	
	
	/*** 根据分期ID查询账单信息  **/ 
	public List<UserCentCustomer> housepaylistbyid(Long payexpertid);
	
	/**查询分期信息**/
	List<PayexpertCustomer> getPayExpertByuserCentIds(@Param("idsList")List<Long> expertIds);
	
	/**根据分期id查询所有的账单信息**/
	List<HousepayCustomer> getHousePayByCentIds(@Param("idsList") List<Long> userCentIds);
	
	/**根据租户id查询租约id**/
	List<UserCentCustomer> getUserCentsByUserId(Long userid);
	

}
