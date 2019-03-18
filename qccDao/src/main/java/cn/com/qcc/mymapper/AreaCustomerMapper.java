package cn.com.qcc.mymapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.qcc.pojo.Area;

public interface AreaCustomerMapper {
	
	//根据城市名称获取到code
	Long getcodebycity(String city);
	
	Area getmaxareacode(Long code);

	List<Area> searchAreaByCodeIds(@Param("code") String codeIds);

	List<Area> getAreaByParentId( @Param("code") String parentId);

}
