package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Bdmanager;
import cn.com.qcc.queryvo.UserRoomCustomer;

public interface BDService {
	
	/**添加编辑BD用户**/
	ResultMap addOrUpdate(Bdmanager bdmanager);

	/**查询BD列表**/
	ResultMap listBD();

	/**查询一个BD**/
	ResultMap findOne(String bdid);
	
	
	/**禁用和开启BD**/
	ResultMap changeState(String bdid);

	/**根据电话号码或者id 查询BD**/
	Bdmanager searchBDByPhoneOrId(String account);

	/**BD修改登录密码**/
	ResultMap changePassword(Long telephone, String bdid, String password);

	/**查询想要添加的房东**/
	List<UserRoomCustomer> searchUserToLand(String searchWhere);
	
	/**BD添加房东**/
	ResultMap addLand(String bdid, Long userid , String address , Long code);

	ResultMap getBdidByToken(String bD_ACCTOKEN);

}
