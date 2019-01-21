package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Storeconn;
import cn.com.qcc.pojo.StoreconnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StoreconnMapper {
    int countByExample(StoreconnExample example);

    int deleteByExample(StoreconnExample example);

    int deleteByPrimaryKey(Long storeconnid);

    int insert(Storeconn record);

    int insertSelective(Storeconn record);

    List<Storeconn> selectByExample(StoreconnExample example);

    Storeconn selectByPrimaryKey(Long storeconnid);

    int updateByExampleSelective(@Param("record") Storeconn record, @Param("example") StoreconnExample example);

    int updateByExample(@Param("record") Storeconn record, @Param("example") StoreconnExample example);

    int updateByPrimaryKeySelective(Storeconn record);

    int updateByPrimaryKey(Storeconn record);
}