package cn.com.qcc.service;

import cn.com.qcc.pojo.Price;

public interface PriceService {
	
	// 发布插入数据
	public Integer insertPrice(Price price);

	// 查询最新发布价格的id
	public int findPriceid(Price price);
}
