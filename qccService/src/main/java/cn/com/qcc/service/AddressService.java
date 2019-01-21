package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Area;
import cn.com.qcc.pojo.Brand;
import cn.com.qcc.pojo.Delivery;
import cn.com.qcc.pojo.Metro;
import cn.com.qcc.queryvo.AreaCustomer;
import cn.com.qcc.queryvo.MetroCustomer;

/*
 * 地址service
 * */
public interface AddressService {


	
	/**   根据上一级地址查询下一级地址
	 *    @param code  : 其中的code
	 * **/
	List <AreaCustomer> getnextareabycode(String []  code);
	
	/** 根据区域的ID编辑区域
	 *  @param id : 区域主键
	 *  @param name : 区域名称
	 * **/
	void updatename(Area area);
	
	
	/**
	 * 新增 四级联动地址
	 * **/
	ResultMap add(Area area ,String submitname);
	
	/**根据CODE 查询区域的详情
	 * @param code : 区域CODE
	 * **/
	Area areadetail(Long code);
	
	/**地铁   新增/ 编辑
	 * @param Finalstop  : 地铁站点
	 * @param Name       : 地铁名称
	 * @param metroid    : 地铁ID
	 * @param code       : 地铁所属区域
	 * **/ 
	ResultMap metroadd(Metro metro);
	
	/**
	 * 地铁查询
	 * @param code : 区域code
	 * @param currentpage : 当前页面
	 * @param pagesize    : 每页查询数目
	 * **/ 
	List<MetroCustomer> mertrosearch(Long code ,PageQuery pagequery);
	int mertrosearchCount(Long code);
	
	
	
	
	/**地铁删除
	 *  @param metroid : 地铁ID
	 * **/ 
	ResultMap metrodelete(Metro metro);
	
	/*** 根据站点查询地铁 
	 *  @param finalstop : 地铁站点
	 *  @param code : 地铁所属区域
	 * **/ 
	ResultMap searchbycodeandfinalstop(Metro metro);
	
	/** 查询地铁的线路
	 * @param name : 地铁线路名称
	 * **/ 
	ResultMap metrobyname(Metro metro);
	
	/**
	 * 地铁详情
	 * **/
	ResultMap metrodetail(Metro metro);
	
	/**新增收货地址 
	 * @param deliveryphone : 联系人电话
	 * @param code : 街道CODE
	 * @param deliveryname  : 联系人姓名、
	 * @param deliveryaddress : 详情地址
	 * @param userid : 发布人ID
	 * **/
	ResultMap adddDeli(Delivery delivery);
	
	
	/**编辑收货地址 
	 * @param deliveryphone : 联系人电话
	 * @param deliveryid : 详情地址主键
	 * @param code : 街道CODE
	 * @param deliveryname  : 联系人姓名、
	 * @param deliveryaddress : 详情地址
	 * @param userid : 发布人ID
	 * **/
	ResultMap editdelivery(Delivery delivery);

	/** 编辑收货地址 的查询
	 * @param Deliveryid : 收货地址ID
	 * **/
	ResultMap searchdeliverybyid(Delivery delivery);
	
	/** 根据城市查询类似的品牌
	 * @param city : 城市名称
	 * @param likename : 输入的品牌名称
	 * @param code : 城市code
	 * **/
	List<Brand> getlikebrand(String likename,String likecode);

	

}
