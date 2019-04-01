package cn.com.qcc.mymapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.qcc.pojo.Finance;
import cn.com.qcc.pojo.Historymeter;
import cn.com.qcc.pojo.Housepay;
import cn.com.qcc.pojo.Landbuilding;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.HistorymeterCustomer;
import cn.com.qcc.queryvo.HistorymeterVo;
import cn.com.qcc.queryvo.HydCoalCustomer;
import cn.com.qcc.queryvo.HydCoalVo;
import cn.com.qcc.queryvo.PayexpertCustomer;
import cn.com.qcc.queryvo.ReckoningCustomer;

public interface HydCoalCustomerMapper {
	
	//查询配置的价格
	List<HydCoalCustomer> defaultprices(String houseid);
	
	//查询配置的初始值
	List<HistorymeterCustomer> beforemeter(HydCoalVo hydCoalVo);
	
	//查询抄表的楼栋
	List<BuildingCustomer> meterbuilding(Long userid);

	Landbuilding syncbuildingprices(@Param("houseid")Long houseid, @Param("financeid") Long financeid);
	
	///获取水表电表头部
	List<Finance> unitname(Landbuilding landbuilding);
	
	///获取水表电表头部获取历史抄表的统计数量
	int meterdetailCount(HistorymeterVo historymeterVo);
	
	///获取水表电表头部获取历史抄表的总记录
	List<HistorymeterCustomer> meterdetail(HistorymeterVo historymeterVo);
	
	//查询待生成账单的楼栋集合
	List<BuildingCustomer> unitbuilding(Long userid);
	
	//查询待生成账单 的列表集合
	List<HistorymeterCustomer> meterbuils(HistorymeterCustomer historymeterCustomer);
	
	//根据房子ID查分期账单
	List<PayexpertCustomer> payexpbyhouseid(Long houseid);
	
	//查询抄表详情
	HistorymeterCustomer hismeterdetail(Long historymeterid);
	
	//根据查询条件查询账本
	List<ReckoningCustomer> reckoning(HydCoalVo hydCoalVo);

	int reckoningCount(HydCoalVo hydCoalVo);
	
	//查询所有类目的金额
	List<ReckoningCustomer> reckbuil(HydCoalVo hydCoalVo);

	List<Finance> addfinancelist();
	
	//查询该数据是否已经超过表
	Historymeter checkmeter(Historymeter historymeter);
	
	//校验添加的账单是否存在
	List<Housepay> checkpaybuilexist(Housepay housepay);
	
	//查询抄表月份的水初始和末
	List<Historymeter> mothermeterdetails(HydCoalVo hydCoalVo);
	
	//通过城市查询code
	String getcodebycity(String city);
}