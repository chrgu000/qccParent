package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Reportdetail;
import cn.com.qcc.pojo.ReportdetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReportdetailMapper {
    int countByExample(ReportdetailExample example);

    int deleteByExample(ReportdetailExample example);

    int deleteByPrimaryKey(Integer reportdetailid);

    int insert(Reportdetail record);

    int insertSelective(Reportdetail record);

    List<Reportdetail> selectByExample(ReportdetailExample example);

    Reportdetail selectByPrimaryKey(Integer reportdetailid);

    int updateByExampleSelective(@Param("record") Reportdetail record, @Param("example") ReportdetailExample example);

    int updateByExample(@Param("record") Reportdetail record, @Param("example") ReportdetailExample example);

    int updateByPrimaryKeySelective(Reportdetail record);

    int updateByPrimaryKey(Reportdetail record);
}