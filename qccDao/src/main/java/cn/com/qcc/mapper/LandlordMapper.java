package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Landlord;
import cn.com.qcc.pojo.LandlordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LandlordMapper {
    int countByExample(LandlordExample example);

    int deleteByExample(LandlordExample example);

    int deleteByPrimaryKey(Long landuserid);

    int insert(Landlord record);

    int insertSelective(Landlord record);

    List<Landlord> selectByExample(LandlordExample example);

    Landlord selectByPrimaryKey(Long landuserid);

    int updateByExampleSelective(@Param("record") Landlord record, @Param("example") LandlordExample example);

    int updateByExample(@Param("record") Landlord record, @Param("example") LandlordExample example);

    int updateByPrimaryKeySelective(Landlord record);

    int updateByPrimaryKey(Landlord record);
}