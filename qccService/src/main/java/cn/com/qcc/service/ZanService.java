package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.pojo.Zan;
import cn.com.qcc.queryvo.ZanCustomer;

public interface ZanService {
	
	/**查看赞的数量
	 * @param userid : 用户ID
	 * **/ 
	int findzanfollowCount(Long userid);

	/** 查询zan 的列表
	 * @param userid : 用户ID
	 * **/ 
	List<ZanCustomer> findzanfollow(Long userid ,PageQuery pagequery);

	/**查看是否被赞过
	 * @param type : 业务类型
	 * @param otherid : 物品主键
	 * @param zanid : 当前对象主键
	 * @param userid : 用户ID主键
	 * 
	 * **/ 
	Zan findisZan(Zan zan, Integer type);

	/** 给某一个对象添加。点赞
	 * @param type : 业务类型
	 * @param userid : 用户ID 
	 * @param otherid : 操作的物品主键
	 * @param zanid : zan的唯一主键
	 * 
	 * **/ 
	void addzan(Zan zan, Integer type);

	/**取消赞
	 * @param type : 操作传对象类型
	 * @param userid : 操作人ID
	 * @param state :  0 表示取消点赞
	 * @param otherid : 对象主键
	 * **/ 
	void removezan(Zan zan, Integer type);

}
