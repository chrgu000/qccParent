package cn.com.qcc.service.impl;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.mapper.PriceMapper;
import cn.com.qcc.pojo.Price;
import cn.com.qcc.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	PriceMapper priceMapper;

	public int findPriceid(Price price) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Integer insertPrice(Price price) {
		price.setCreate_time(new Date());
		price.setUpdate_time(new Date());
		int insert = priceMapper.insert(price);
		return insert;
	}

}