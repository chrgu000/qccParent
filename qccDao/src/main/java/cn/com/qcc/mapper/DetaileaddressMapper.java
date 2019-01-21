package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Detaileaddress;
import cn.com.qcc.pojo.DetaileaddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DetaileaddressMapper {
    int countByExample(DetaileaddressExample example);

    int deleteByExample(DetaileaddressExample example);

    int deleteByPrimaryKey(Long detailid);

    int insert(Detaileaddress record);

    int insertSelective(Detaileaddress record);

    List<Detaileaddress> selectByExample(DetaileaddressExample example);

    Detaileaddress selectByPrimaryKey(Long detailid);

    int updateByExampleSelective(@Param("record") Detaileaddress record, @Param("example") DetaileaddressExample example);

    int updateByExample(@Param("record") Detaileaddress record, @Param("example") DetaileaddressExample example);

    int updateByPrimaryKeySelective(Detaileaddress record);

    int updateByPrimaryKey(Detaileaddress record);
}