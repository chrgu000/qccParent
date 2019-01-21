package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Transmitsend;
import cn.com.qcc.pojo.TransmitsendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransmitsendMapper {
    int countByExample(TransmitsendExample example);

    int deleteByExample(TransmitsendExample example);

    int insert(Transmitsend record);

    int insertSelective(Transmitsend record);

    List<Transmitsend> selectByExample(TransmitsendExample example);

    int updateByExampleSelective(@Param("record") Transmitsend record, @Param("example") TransmitsendExample example);

    int updateByExample(@Param("record") Transmitsend record, @Param("example") TransmitsendExample example);
}