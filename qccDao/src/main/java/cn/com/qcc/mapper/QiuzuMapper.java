package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Qiuzu;
import cn.com.qcc.pojo.QiuzuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QiuzuMapper {
    int countByExample(QiuzuExample example);

    int deleteByExample(QiuzuExample example);

    int deleteByPrimaryKey(Long qiuzuid);

    int insert(Qiuzu record);

    int insertSelective(Qiuzu record);

    List<Qiuzu> selectByExample(QiuzuExample example);

    Qiuzu selectByPrimaryKey(Long qiuzuid);

    int updateByExampleSelective(@Param("record") Qiuzu record, @Param("example") QiuzuExample example);

    int updateByExample(@Param("record") Qiuzu record, @Param("example") QiuzuExample example);

    int updateByPrimaryKeySelective(Qiuzu record);

    int updateByPrimaryKey(Qiuzu record);
}