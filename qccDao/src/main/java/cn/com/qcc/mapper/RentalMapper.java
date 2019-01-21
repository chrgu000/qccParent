package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Rental;
import cn.com.qcc.pojo.RentalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RentalMapper {
    int countByExample(RentalExample example);

    int deleteByExample(RentalExample example);

    int deleteByPrimaryKey(Long code);

    int insert(Rental record);

    int insertSelective(Rental record);

    List<Rental> selectByExample(RentalExample example);

    Rental selectByPrimaryKey(Long code);

    int updateByExampleSelective(@Param("record") Rental record, @Param("example") RentalExample example);

    int updateByExample(@Param("record") Rental record, @Param("example") RentalExample example);

    int updateByPrimaryKeySelective(Rental record);

    int updateByPrimaryKey(Rental record);
}