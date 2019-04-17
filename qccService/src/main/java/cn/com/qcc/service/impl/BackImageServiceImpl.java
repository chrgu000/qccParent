package cn.com.qcc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.mapper.BackimageMapper;
import cn.com.qcc.mymapper.BackImageCustoermMapper;
import cn.com.qcc.pojo.Backimage;
import cn.com.qcc.service.BackImageService;


@Service
public class BackImageServiceImpl implements BackImageService{

	@Autowired
	BackImageCustoermMapper backImageCustoermMapper;
	@Autowired
	BackimageMapper backimageMapper;
	
	public Backimage searchDefaultByType (int i ) {
		return backImageCustoermMapper.searchDefaultByType(i);
	}
	
	
	
	public List<Backimage> searchAll (int i) {
		
		return backImageCustoermMapper.searchAllByType(i);
	}



	@Override
	public Backimage createBackImage(String descname , int type) {
		Long backimageid = backImageCustoermMapper.searchNextId();
		String backimageUrl = "https://www.zzw777.com/Tenement/img/" + backimageid + ".png";
		Backimage inserData = new Backimage();
		inserData.setBackimageid(backimageid);
		inserData.setBackimageUrl(backimageUrl);
		inserData.setCreatetime(new Date());
		inserData.setDescname(descname);
		inserData.setType(type);
		inserData.setDescname(descname);
		backimageMapper.insertSelective(inserData);
		return inserData ; 
		
	}
}
