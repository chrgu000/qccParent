package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Buildinglandlord;
import cn.com.qcc.pojo.BuildinglandlordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BuildinglandlordMapper {
    int countByExample(BuildinglandlordExample example);

    int deleteByExample(BuildinglandlordExample example);

    int insert(Buildinglandlord record);

    int insertSelective(Buildinglandlord record);

    List<Buildinglandlord> selectByExample(BuildinglandlordExample example);

    int updateByExampleSelective(@Param("record") Buildinglandlord record, @Param("example") BuildinglandlordExample example);

    int updateByExample(@Param("record") Buildinglandlord record, @Param("example") BuildinglandlordExample example);
}