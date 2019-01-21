package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Articletype;
import cn.com.qcc.pojo.Delivery;
import cn.com.qcc.pojo.Myorder;
import cn.com.qcc.pojo.Parametype;
import cn.com.qcc.pojo.Releasetable;
import cn.com.qcc.pojo.Transmitsend;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.queryvo.ReleaseCustomer;
import cn.com.qcc.queryvo.ReleaseVo;
import cn.com.qcc.queryvo.UserCustomer;

public interface ReleaseService {
	
	//发布规格参数物品
	ResultMap pushdetail(ReleaseCustomer releaseCustomer);
	
	//通过typeid获得标签
	ResultMap gettypename(String typeid);
	
	//通过typeid查询code和name
	ResultMap getcodename(Long typeid);
	
	//批量发布物品
	ResultMap batch(ReleaseVo releaseVo);
	
	//获得所有物品总分类
	List<Articletype> getarticlelist();
	
	//主页加载最新的几个商品
	List<ReleaseCustomer> getnewrelease(ReleaseVo releaseVo);
	
	//主页加载最新的几个商品的count
	int getnewreleaseCount(ReleaseVo releaseVo);
	
	//点击我想要，获得物品规格参数
	ResultMap getypeidbyarticleid(Long articledetailid);
	
	//根据物品的参数集合和物品详情的ID查询物品的价格和库存
	ResultMap getsimpledetail(Releasetable releasetable);
	
	//查询用户的收货地址
	List<Delivery> mydelivery(Long userid);
	
	//创建一个订单
	ResultMap createorder(Myorder order);
	
	

	//查询用户于额是否够
	Vipcount getuserbalance(Myorder order);
	
	//支付成功
	void paysuccess(Myorder order);
	
	//本系统支付的回调
	ResultMap payreturn(Myorder myorder,String payword,Releasetable releasetable);


	UserCustomer getbalanceandphone(Myorder order);
	
	//获得所有的规格参数
	List<Parametype> allarticle(Integer fatherid);
	
	//添加规格参数
	ResultMap addarticle(Parametype parametype);
	
	//修改分类名称
	ResultMap editarticle(Parametype parametype);
	
	ResultMap getcodenamebytypeid(Parametype parametype);

	ResultMap editcodenamebycodeid(Parametype parametype);

	ResultMap addtypename(Parametype parametype);
	
	
	//查询商品的规格参数
	List<ReleaseCustomer> searchFirstTypeName(String[] codeid);
	List<Parametype> searchSecondTypeName(String[] codeid);
	/**校验是否可以发搜**/
	ResultMap checkIsSend(Transmitsend send);

}
