package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Centfrom;
import cn.com.qcc.pojo.CentfromExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CentfromMapper {
    int countByExample(CentfromExample example);

    int deleteByExample(CentfromExample example);

    int deleteByPrimaryKey(Long centfromid);

    int insert(Centfrom record);

    int insertSelective(Centfrom record);

    List<Centfrom> selectByExample(CentfromExample example);

    Centfrom selectByPrimaryKey(Long centfromid);

    int updateByExampleSelective(@Param("record") Centfrom record, @Param("example") CentfromExample example);

    int updateByExample(@Param("record") Centfrom record, @Param("example") CentfromExample example);

    int updateByPrimaryKeySelective(Centfrom record);

    int updateByPrimaryKey(Centfrom record);
}