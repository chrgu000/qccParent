package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.pojo.Backimage;

public interface BackImageService {
	
	public Backimage searchDefaultByType (int i ) ;
	
	public List<Backimage> searchAll (int i);
	
	// 上传背景图片
	public Backimage createBackImage(String descname , int type);

}
