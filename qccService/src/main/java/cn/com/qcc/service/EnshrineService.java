package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.pojo.Enshrine;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.ZanCustomer;

public interface EnshrineService {

	/**添加收藏
	 * @param type : 1-房源，2-出租，3-出售，4-其他 (type)
	 * @param userid : 用户ID
	 * **/ 
	void addenshrine(Enshrine enshrine, Integer type);

	/**
	 * 取消收藏
	 * **/ 
	void removeenshrine(Enshrine enshrine, Integer type);


	/**
	 * 判断房子的收藏状态
	 * * 1-房源，2-出租，3-出售，4-其他 (type)
	 * @param userid : 用户ID
	 * @param otherid : 物品主键
	 * **/ 
	Enshrine enshriexist(Enshrine enshrine, Integer type);

	/** 查询我的收藏
	 * @param userid : 用户ID
	 * **/
	List<ZanCustomer> findMyEnshList(HouseVo houseVo);
	int findMyEnshListCount(HouseVo houseVo);

}
