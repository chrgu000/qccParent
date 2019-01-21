package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Detaileaddress;
import cn.com.qcc.pojo.Metro;
import cn.com.qcc.pojo.Qiuzu;
import cn.com.qcc.queryvo.QiuzuCustomer;
import cn.com.qcc.queryvo.SearchResult;

public interface QiuzuService {
	// 求租列表
	/*List<QiuzuCustomer> findQiuzuList(HouseVo houseVo);*/
	/*int findQiuzuListCount(HouseVo houseVo);*/

	// 查询求租详情
	QiuzuCustomer qiuzuDetail(Long qiuzuid,Long userid ,Integer type);
	
	// 求租列表
	SearchResult testSolr(Metro metro , QiuzuCustomer qiuzuCustomer  , PageQuery pagequery);

	/**
	 * 我的求租列表
	 * **/ 
	SearchResult findQiuzuByUserid(Long userid ,PageQuery pagequery);
	//int findQiuzuByUseridCount(HouseVo houseVo);
	
	
	

	// 更改求租的状态
	ResultMap updateqiuzustatues(Qiuzu qiuzu);


	// 编辑求租
	void updateqiuzu(Qiuzu qiuzu);

	/**发布求购信息
	 * @param Detailes : 详情地址
	 * @param userid : 用户ID
	 * @param code : 街道CODE
	 * @param phone : 电话号码
	 * @param picture : 图片
	 * @param head : 标题
	 * @param qiuzuid : 求租的ID 如果有ID 则是编辑处理
	 * **/ 
	ResultMap insertorupdateqiuzu(Qiuzu qiuzu ,Detaileaddress detaileaddress);

	/**
	 * 求租发布的统计
	 * **/ 
	List<QiuzuCustomer> qiuzutotal(Qiuzu code);
	
	/**
	 * 求租一键导入索引库
	 * **/
	ResultMap qiuzuaddtosolr(PageQuery pagequery);
	
	
	/**
	 * 给求租用户群发短信
	 * **/
	List<QiuzuCustomer> sendmess(QiuzuCustomer qiuzuCustomer);
	
	
	/**
	 * 根据求租的主键查询
	 * @param qiuzuid : 求租主键
	 * **/
	QiuzuCustomer getqiuzutui(Long qiuzuid);

	
	/**通过索引库查询求租列表**/
	SearchResult searchQiuzuListBySolr(Metro metro, QiuzuCustomer qiuzuCustomer, PageQuery pagequery);

	

}
