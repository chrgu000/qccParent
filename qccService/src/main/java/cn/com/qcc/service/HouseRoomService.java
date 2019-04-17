package cn.com.qcc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Mycent;
import cn.com.qcc.pojo.Usercent;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HouseRoomCustomer;
import cn.com.qcc.queryvo.HouseVo;

public interface HouseRoomService {
	
	/**房态图列表**/
	List<HouseRoomCustomer> roompattern(HouseVo houseVo);
	int roompatternCount(HouseVo houseVo);
	
	
	/**
	 * 进行退房操作
	 * @param houseid  : houseid
	 **/
	ResultMap roomout(Long houseid , Long userid);
	
	/**
	 * 根据房源ID 和userid 发起退房操作 退房结账
	 * @param houseid : 当前房源ID
	 **/
	HouseCustomer roomoutsearch(Long houseid);
	
	
	/**
	 * 租客登记时候必须要填写的资料.
	 * @param houseid    : 登记的房子ID
	 * @param landuserid :设置用户的ID，方便管家推送账号和管理
	 * @param prices     : 当前房间的押金
	 * @param centfromid : 租客来源的ID
	 * @param centid     :租约ID
	 * @param start_time :租约开始时间
	 * @param end_time   :租约结束时间
	 * @param otherprices :首期一次费用
	 * @param islinecent  :yes 表示线上合同
	 * @param othermore :更多合同补充
	 **/
	public ResultMap createusercent(Usercent usercent, Mycent mycent, HttpServletRequest request, String othermore,
			String payid, String paycentid, String pricestype, String othermoreid1, String othermoreid2,
			String islinecent);
	
	
	/**
	 * 根据房东ID 查询出对应的区域分组
	 **/
	List<BuildingCustomer> getlandareaname(BuildingCustomer buildingCustomer);
	
	/**
	 * 根据房东ID查询房东房源对应的楼栋
	 */
	List<BuildingCustomer> getlandbuildingname(BuildingCustomer buildingCustomer);
	
	/**根据订单id查询需要支付的金额**/
	HouseRoomCustomer getpayMonery(String housepayIds);
	
	/**交房租成功的回调
	 * @param out_trade_no : 订单号
	 * @param total_amount : 订单总金额
	 * **/
	String housepaySuccess(String out_trade_no, String total_amount);
	
	/**查询所有的Inids**/
	String getInUserIds(Long userid);
	
	/**用户作废账单
	 * @param userid : 作废人
	 * @param housepayIds : 订单的集合
	 * **/
	ResultMap deletehousebile(Long userid, String housepayIds);

}
