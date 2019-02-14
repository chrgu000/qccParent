package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Bargaindetail;
import cn.com.qcc.pojo.BargaindetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BargaindetailMapper {
    int countByExample(BargaindetailExample example);

    int deleteByExample(BargaindetailExample example);

    int insert(Bargaindetail record);

    int insertSelective(Bargaindetail record);

    List<Bargaindetail> selectByExample(BargaindetailExample example);

    int updateByExampleSelective(@Param("record") Bargaindetail record, @Param("example") BargaindetailExample example);

    int updateByExample(@Param("record") Bargaindetail record, @Param("example") BargaindetailExample example);
}