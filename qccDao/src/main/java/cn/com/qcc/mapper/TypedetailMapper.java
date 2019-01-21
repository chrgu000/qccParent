package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Typedetail;
import cn.com.qcc.pojo.TypedetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypedetailMapper {
    int countByExample(TypedetailExample example);

    int deleteByExample(TypedetailExample example);

    int deleteByPrimaryKey(Long typedetailid);

    int insert(Typedetail record);

    int insertSelective(Typedetail record);

    List<Typedetail> selectByExample(TypedetailExample example);

    Typedetail selectByPrimaryKey(Long typedetailid);

    int updateByExampleSelective(@Param("record") Typedetail record, @Param("example") TypedetailExample example);

    int updateByExample(@Param("record") Typedetail record, @Param("example") TypedetailExample example);

    int updateByPrimaryKeySelective(Typedetail record);

    int updateByPrimaryKey(Typedetail record);
}