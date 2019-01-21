package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Tribenotice;
import cn.com.qcc.pojo.TribenoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TribenoticeMapper {
    int countByExample(TribenoticeExample example);

    int deleteByExample(TribenoticeExample example);

    int deleteByPrimaryKey(Long tribenoticeid);

    int insert(Tribenotice record);

    int insertSelective(Tribenotice record);

    List<Tribenotice> selectByExample(TribenoticeExample example);

    Tribenotice selectByPrimaryKey(Long tribenoticeid);

    int updateByExampleSelective(@Param("record") Tribenotice record, @Param("example") TribenoticeExample example);

    int updateByExample(@Param("record") Tribenotice record, @Param("example") TribenoticeExample example);

    int updateByPrimaryKeySelective(Tribenotice record);

    int updateByPrimaryKey(Tribenotice record);
}