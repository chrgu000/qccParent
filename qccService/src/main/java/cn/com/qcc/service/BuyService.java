package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Buy;
import cn.com.qcc.pojo.Detaileaddress;
import cn.com.qcc.queryvo.BuyCustomer;

public interface BuyService {
	
	
	/**发布求购信息
	 * @param Detailes : 详情地址
	 * @param userid : 用户ID
	 * @param code : 街道CODE
	 * @param phone : 电话号码
	 * @param picture : 图片
	 * @param head : 标题
	 * @param qiuzuid : 求租的ID 如果有ID 则是编辑处理
	 * **/ 
	public ResultMap addBuy(Buy buy);

	/**
	 * 我的求购
	 * @param userid : 用户ID
	 */
	public List<BuyCustomer> findBuyByUserid(Long userid);

	/**
	 * 修改的求购的状态
	 * @param buystatus :   0冻结  1上架 2下架
	 * @param buyid : 求购的ID
	 **/
	public void updateBuyStatus(Buy buy);

	
	/**根据求购ID查询一条求购信息
	 * @param buyid : 求购ID
	 * 
	 * **/
	public BuyCustomer findOneById(Long buyid);

	/**
	 *  更新求购的信息
	 * **/
	public void updateBuy(Buy buy);
	
	/**发布求购信息
	 * @param Detailes : 详情地址
	 * @param userid : 用户ID
	 * @param code : 街道CODE
	 * @param phone : 电话号码
	 * @param picture : 图片
	 * @param head : 标题
	 * @param qiuzuid : 求租的ID 如果有ID 则是编辑处理
	 * **/ 
	public void insertorupdatebuy(Buy buy,Detaileaddress detaileaddress);
}
