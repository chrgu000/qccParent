package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Finance;
import cn.com.qcc.pojo.Historymeter;
import cn.com.qcc.pojo.Housepay;
import cn.com.qcc.pojo.Landbuilding;
import cn.com.qcc.pojo.Payexpert;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.HistorymeterCustomer;
import cn.com.qcc.queryvo.HistorymeterVo;
import cn.com.qcc.queryvo.HydCoalCustomer;
import cn.com.qcc.queryvo.HydCoalVo;
import cn.com.qcc.queryvo.ReckoningCustomer;


public interface HydCoalService {
	
	/**
	 *	根据传过来的参数批量配置房源单价
	 * @param hydcoals : 前台传过来的集合。
	 **/
	ResultMap createhydprices(List<HydCoalCustomer> historymeter);

	
	/**
	 *	查询默认的配置价格
	 * @param houseids : 前台传过来的房子的IDS
	 * 。
	 **/
	List<HydCoalCustomer> defaultprices(String houseids);

	
	/**
	 *	根据userid 和buildingid 查询每个月抄表的初始值
	 * @param userid : 用户id。房东的id
	 * @param buildingid : 当前楼栋 的id
	 * 。
	 **/
	List<HistorymeterCustomer> beforemeter(HydCoalVo hydCoalVo);

	
	/**
	 *	当页面失去焦点时候同步缓存
	 * @param userid : 用户id。房东的id
	 * @param buildingid : 当前楼栋 的id
	 * 。
	 **/
	Integer syncmeter(List<Historymeter> historymeter ,Long userid);

	/**
	 *	查询可以抄表的楼栋
	 * @param userid : 用户id。房东的id
	 * 。
	 **/
	List<BuildingCustomer> meterbuilding(Long userid);

	/**
	 *	获取电表水表头部
	 * @param userid : 用户id。房东的id
	 * 。
	 **/
	List<Finance> unitname(Landbuilding landbuilding);


	

	/**
	 *	获取历史抄表的总记录
	 * @param userid : 用户id。房东的id
	 * @param financeid : 财务ID
	 * 。
	 **/
	List<HistorymeterCustomer> meterdetail(HistorymeterVo historymeterVo);
	int meterdetailCount(HistorymeterVo historymeterVo);

	/**
	 *	查询待生成账单的楼栋
	 * @param userid : 用户id。房东的id
	 * 。
	 **/
	List<BuildingCustomer> unitbuilding(Long userid);

	/**
	 *	根据当前userid -- 楼栋id 财务ID查询可以生成账单 的列表
	 * @param userid : 用户id。房东的id
	 **/
	List<HistorymeterCustomer> meterbuils(HistorymeterCustomer historymeterCustomer);
	
	/**
	 *	根据房子ID。查询分期账单
	 * @param houseid : 当前房子ID
	 **/
	List<Payexpert> payexpbyhouseid(Long houseid);

	/**
	 *	根据主键查询当前想起
	 * @param houseid : 当前房子ID
	 **/
	HistorymeterCustomer hismeterdetail(Long historymeterid);

	/**
	 * 作废抄表
	 * **/
	ResultMap deletemeter(Long historymeterid);

	/**
	 *	水电煤气生成账单
	 * @param historymeterid :抄表主键
	 * @param payexpertid :分期账单主键
	 * @param unitprice :单价
	 **/
	ResultMap hydbuil(Long historymeterid, Long payexpertid, Double unitprice);

	/**
	 *	根据抄表主键获取housepayid
	 * @param historymeterid :抄表主键
	 **/
	ResultMap searchhousepayid(Long historymeterid);

	/**
	 *	根据查询条件查询账本。
	 **/
	List<ReckoningCustomer> reckoning(HydCoalVo hydCoalVo);
	int reckoningCount(HydCoalVo hydCoalVo);

	
	/**
	 *	查询添加账单的类目
	 **/
	List<Finance> addfinancelist();

	/**
	 * 添加其他账单
	 * **/
	ResultMap addotherbuil(Housepay housepay);


	

}
