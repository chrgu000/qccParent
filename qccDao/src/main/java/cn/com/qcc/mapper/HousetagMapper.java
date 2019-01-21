package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Housetag;
import cn.com.qcc.pojo.HousetagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HousetagMapper {
    int countByExample(HousetagExample example);

    int deleteByExample(HousetagExample example);

    int deleteByPrimaryKey(Long housetagid);

    int insert(Housetag record);

    int insertSelective(Housetag record);

    List<Housetag> selectByExample(HousetagExample example);

    Housetag selectByPrimaryKey(Long housetagid);

    int updateByExampleSelective(@Param("record") Housetag record, @Param("example") HousetagExample example);

    int updateByExample(@Param("record") Housetag record, @Param("example") HousetagExample example);

    int updateByPrimaryKeySelective(Housetag record);

    int updateByPrimaryKey(Housetag record);
    
    
    // 根据house的ID查询当前房子的性别的基础设施
 	List<Housetag> getHousetagsSexbyId(Integer houseid);

 	// 根据house的ID查询当前独立设施
 	List<Housetag> getHousetagsalonebyId(Integer houseid);

 	// 根据house的ID查询当前公共设施
 	List<Housetag> getHousetagscommonbyId(Integer houseid);

}