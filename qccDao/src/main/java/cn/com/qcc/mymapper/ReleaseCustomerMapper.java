package cn.com.qcc.mymapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.qcc.pojo.Delivery;
import cn.com.qcc.pojo.Myorder;
import cn.com.qcc.pojo.Parametype;
import cn.com.qcc.pojo.Releasetable;
import cn.com.qcc.pojo.Transmitsend;
import cn.com.qcc.queryvo.ReleaseCustomer;
import cn.com.qcc.queryvo.ReleaseVo;
import cn.com.qcc.queryvo.UserCustomer;

public interface ReleaseCustomerMapper {
	/**
	 * 获取物品的规格参数
	 **/
	List<Parametype> gettypename( @Param("idsList") String[] ids);
	
	//获取物品的规格参数
	List<Parametype> getcodename(Long typeid);
	
	//主页最新商品的count
	int getnewreleaseCount(ReleaseVo releaseVo);
	
	//查询主页加载的最新商品
	List<ReleaseCustomer> getnewrelease(ReleaseVo releaseVo);
	
	//获得物品的标签和规格参数
	List<Parametype> findtypenameandcodename(@Param("idsList") String[] ids);
	
	//我的收货地址列表
	List<Delivery> mydelivery(Long userid);
	
	//获得物品的基本参数
	ReleaseCustomer getsimpledetail(Releasetable releasetable);

	List<Parametype> getnames(@Param("idsList") String[] ids);

	UserCustomer getbalanceandphone(Myorder order);
	
	//第一步获得街道的名称
	Delivery getTrandname(Long code);
	
	//获得市一级和区一级
	Delivery getquname(Long tracode);
	//获得省一级地址
	Delivery getcityname(Long citycode);
	
	//获得所有的规格参数
	List<Parametype> allarticle(Integer fatherid);

	
	/**查询一级分类的名称**/
	List<ReleaseCustomer> searchFirstTypeName(@Param("idsList")String[] codeid);
	/**查询二级分类的名称**/
	List<Parametype> searchSecondTypeName(@Param("idsList")String[] codeid);

	void updateTrans(Transmitsend check);

	Transmitsend searchTrans(Transmitsend send);
   
}