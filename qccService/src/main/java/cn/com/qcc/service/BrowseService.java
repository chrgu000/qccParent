package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.pojo.Browse;
import cn.com.qcc.queryvo.BrowerCustomer;
import cn.com.qcc.queryvo.HouseVo;

public interface BrowseService {

	
	/**
	 * 查询我的浏览
	 * @param type : 浏览的type类型
	 * **/ 
	List<Browse> BrowseList(Browse browse, Integer type);
	
	/**
	 * 判断浏览的类型是否已经存在
	 * **/
	Browse Browsexixt(Long otherid ,Long userid, Integer type);
	
	/**
	 * 插入浏览量
	 * @param type : 浏览的类型
	 * **/
	void addBrowse(Long otherid ,Long userid, Integer type);

	
	/**
	 * 查询 这个浏览的总计
	 * **/ 
	Integer count(Long userid, Integer type);

	/**
	 * 当前物品的浏览量
	 * @param otherid : 物品主键
	 * @param type : 类目类型
	 * **/ 
	BrowerCustomer countone(Integer type, Long otherid);

	/** 查询我的浏览列表
	 * @param userid : 用户ID
	 * **/
	List<BrowerCustomer> findmyBrowList(HouseVo houseVo);
	int findmyBrowListCount(HouseVo houseVo);
	
	/**删除查看也就是更新状态
	 * @param userid : 用户ID
	 * @param statue  : 1,正常，2停用
	 * **/ 
	void updatestate(Browse browse);
	

	

}
