package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Living;
import cn.com.qcc.pojo.LivingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LivingMapper {
    int countByExample(LivingExample example);

    int deleteByExample(LivingExample example);

    int deleteByPrimaryKey(Long livingid);

    int insert(Living record);

    int insertSelective(Living record);

    List<Living> selectByExample(LivingExample example);

    Living selectByPrimaryKey(Long livingid);

    int updateByExampleSelective(@Param("record") Living record, @Param("example") LivingExample example);

    int updateByExample(@Param("record") Living record, @Param("example") LivingExample example);

    int updateByPrimaryKeySelective(Living record);

    int updateByPrimaryKey(Living record);
    
	List<Living> searchByTypeId(Long typeid);

	Integer getOrder(Living livng);

	List<Living> searchAllByTypeId(Long typeid);
}