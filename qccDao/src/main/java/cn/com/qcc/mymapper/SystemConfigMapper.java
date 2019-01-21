package cn.com.qcc.mymapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.qcc.pojo.Percent;

public interface SystemConfigMapper {
	
	/**
	 * 查询系统设定的百分比
	 * **/
	List<Percent> searchpercent(@Param("type") Integer type);

}
