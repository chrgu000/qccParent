package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Housepaydetail;
import cn.com.qcc.pojo.HousepaydetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HousepaydetailMapper {
    int countByExample(HousepaydetailExample example);

    int deleteByExample(HousepaydetailExample example);

    int deleteByPrimaryKey(String ordernum);

    int insert(Housepaydetail record);

    int insertSelective(Housepaydetail record);

    List<Housepaydetail> selectByExample(HousepaydetailExample example);

    Housepaydetail selectByPrimaryKey(String ordernum);

    int updateByExampleSelective(@Param("record") Housepaydetail record, @Param("example") HousepaydetailExample example);

    int updateByExample(@Param("record") Housepaydetail record, @Param("example") HousepaydetailExample example);

    int updateByPrimaryKeySelective(Housepaydetail record);

    int updateByPrimaryKey(Housepaydetail record);
}