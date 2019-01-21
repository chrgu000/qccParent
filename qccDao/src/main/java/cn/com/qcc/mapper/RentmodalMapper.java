package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Rentmodal;
import cn.com.qcc.pojo.RentmodalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RentmodalMapper {
    int countByExample(RentmodalExample example);

    int deleteByExample(RentmodalExample example);

    int deleteByPrimaryKey(Long rentmodalid);

    int insert(Rentmodal record);

    int insertSelective(Rentmodal record);

    List<Rentmodal> selectByExample(RentmodalExample example);

    Rentmodal selectByPrimaryKey(Long rentmodalid);

    int updateByExampleSelective(@Param("record") Rentmodal record, @Param("example") RentmodalExample example);

    int updateByExample(@Param("record") Rentmodal record, @Param("example") RentmodalExample example);

    int updateByPrimaryKeySelective(Rentmodal record);

    int updateByPrimaryKey(Rentmodal record);
}