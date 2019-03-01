package cn.com.qcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.qcc.mapper.ApartmentMapper;
import cn.com.qcc.pojo.Apartment;
import cn.com.qcc.pojo.ApartmentExample;
import cn.com.qcc.service.ApartmentService;

@Service
@Transactional
public class ApartmentServiceImpl implements ApartmentService {

	@Autowired
	ApartmentMapper apartmentMapper;

	// 根据几室几厅的名称查询对应的ID
	public Integer selectIdByApartmentName(String apartmentname) {
		ApartmentExample example = new ApartmentExample();
		ApartmentExample.Criteria criteria = example.createCriteria();
		criteria.andApartmentnameEqualTo(apartmentname);
		List<Apartment> apartments = apartmentMapper.selectByExample(example);
		if (!apartments.isEmpty() && apartments.size() > 0) {
			return apartments.get(0).getApartmentid();
		}
		return null;
	}
}
