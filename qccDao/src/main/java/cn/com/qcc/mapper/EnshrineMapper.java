package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Enshrine;
import cn.com.qcc.pojo.EnshrineExample;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.ZanCustomer;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnshrineMapper {
    int countByExample(EnshrineExample example);

    int deleteByExample(EnshrineExample example);

    int deleteByPrimaryKey(Long enshrineid);

    int insert(Enshrine record);

    int insertSelective(Enshrine record);

    List<Enshrine> selectByExample(EnshrineExample example);

    Enshrine selectByPrimaryKey(Long enshrineid);

    int updateByExampleSelective(@Param("record") Enshrine record, @Param("example") EnshrineExample example);

    int updateByExample(@Param("record") Enshrine record, @Param("example") EnshrineExample example);

    int updateByPrimaryKeySelective(Enshrine record);

    int updateByPrimaryKey(Enshrine record);
    
    
    List<ZanCustomer> findEnshfollow(HouseVo houseVo);

	int findEnshfollowCount(HouseVo houseVo);
}