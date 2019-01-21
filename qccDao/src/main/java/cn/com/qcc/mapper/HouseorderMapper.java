package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Houseorder;
import cn.com.qcc.pojo.HouseorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HouseorderMapper {
    int countByExample(HouseorderExample example);

    int deleteByExample(HouseorderExample example);

    int deleteByPrimaryKey(Long houseorderid);

    int insert(Houseorder record);

    int insertSelective(Houseorder record);

    List<Houseorder> selectByExample(HouseorderExample example);

    Houseorder selectByPrimaryKey(Long houseorderid);

    int updateByExampleSelective(@Param("record") Houseorder record, @Param("example") HouseorderExample example);

    int updateByExample(@Param("record") Houseorder record, @Param("example") HouseorderExample example);

    int updateByPrimaryKeySelective(Houseorder record);

    int updateByPrimaryKey(Houseorder record);
}