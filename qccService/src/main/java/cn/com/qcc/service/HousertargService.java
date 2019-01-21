package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.pojo.Housetag;
import cn.com.qcc.pojo.Pararule;
import cn.com.qcc.queryvo.HouseCustomer;


public interface HousertargService {

	
	/**
	 * 发布房屋提取公用设施给前台 
	 * @param category_name : 房源基础设置名称
	 * @return
	 */
	List<Housetag> getHousetagByCategory(String category_name);

	/**
	 * 根据type获取房子属性的ID
	 * **/ 
	String getHousetagByType(String type);

	/**
	 *  根据房子ID查询性别的标签
	 * **/
	List<Housetag> getHousetagsofSex(Integer houseid);

	/**根据房子ID查询独立的标签
	 * @param houseid : 房源ID
	 * **/ 
	List<Housetag> getHousetagsofalone(Integer houseid);

	/**根据房子ID查询公共的标签
	 * @param houseid : 房源ID 
	 * **/ 
	List<Housetag> getHousetagsofcommon(Integer houseid);
	
	/**
	 * 根据category 查询房源设备信息
	 * **/
	List<Housetag> getTargBycategory(String category);
	
	/**根据类型查询traname
	 * **/
	String getTraName(long houseid);

	/**根据ID 查询租客规则
	 * @param pararuleid
	 * @return
	 */
	Pararule searchpararulebyid(Integer pararuleid);

	/***
	 * 查询规则参数列表
	 * */
	List<Pararule> searchpararuleList();
	
	/** 
	 * 编辑规则参数
	 * **/
	void updateparaule(Pararule pararule);
	
	/**根据housetag_id查询类型**/
	List<Housetag> getTargByHouseTargId(String housetag_id);

	List<HouseCustomer> getpayListBybuilid(Long buildingid);

	List<HouseCustomer> getredecoraListBybuilid(Long buildingid);

	List<HouseCustomer> getproperListBybuilid(Long buildingid);

	List<HouseCustomer> getapartmentnameListBybuilid(Long buildingid);

	List<HouseCustomer> getCountAndpricesBybuilid(Long buildingid);

}
