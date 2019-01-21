package cn.com.qcc.mymapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.pojo.Qiuzu;
import cn.com.qcc.queryvo.AuthCustomer;
import cn.com.qcc.queryvo.BuyCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.QiuzuCustomer;

public interface QiuZuCustomerMapper {
	// 求租列表
	List<QiuzuCustomer> qiuzuaddtosolr(@Param("pagequery")PageQuery pagequery);

	// 求租列表 的数目
	int findQiuzuListCount(HouseVo houseVo);

	// 求租详情
	QiuzuCustomer qiuzuDetail(@Param("qiuzuid") Long qiuzuid);

	// 我的求租
	List<QiuzuCustomer> findQiuzuByUserid(HouseVo houseVo);

	// 我的求购
	List<BuyCustomer> findBuyByUserid(@Param("userid") Long userid);

	// 我的委托
	List<AuthCustomer> findmyauthorize(@Param("userid") Long userid);

	// 求租发布的统计
	List<QiuzuCustomer> qiuzutotal(Qiuzu code);

	Integer totalcout(Qiuzu qiuzu);
	
	/**查询一条求租信息加入索引库**/
	QiuzuCustomer getoneqiuzutosolr(long qizuId);
	
	List<QiuzuCustomer> getmyqiuzutosolr(Qiuzu qiuzu);

	BuyCustomer findOneById( @Param("buyid") Long buyid);
	
	///后台查询所有的发布委托
	List<AuthCustomer> getallauth(HouseVo houseVo);

	int findQiuzuByUseridCount(HouseVo houseVo);
	
	//后台查询所有发布委托的count
	int getallauthCount(HouseVo houseVo);

	List<QiuzuCustomer> sendmess(QiuzuCustomer qiuzuCustomer);

	


}
