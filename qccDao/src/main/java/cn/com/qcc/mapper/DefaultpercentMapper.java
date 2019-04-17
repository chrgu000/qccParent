package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Defaultpercent;
import cn.com.qcc.pojo.DefaultpercentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DefaultpercentMapper {
    int countByExample(DefaultpercentExample example);

    int deleteByExample(DefaultpercentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Defaultpercent record);

    int insertSelective(Defaultpercent record);

    List<Defaultpercent> selectByExample(DefaultpercentExample example);

    Defaultpercent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Defaultpercent record, @Param("example") DefaultpercentExample example);

    int updateByExample(@Param("record") Defaultpercent record, @Param("example") DefaultpercentExample example);

    int updateByPrimaryKeySelective(Defaultpercent record);

    int updateByPrimaryKey(Defaultpercent record);
    
    /**  房东没有设置佣金平台抽取租金的百分比   ***/
    public double centNumIsZeroNetGet();
    /**  砍价最多百分比  [在佣金基础上 砍价 ]    ***/
    public double canJiaNum();
    /**  专职 [佣金基础上]   ***/
    public double zhuanzhiNum();
    /**  兼职 [佣金基础上]   ***/
    public double jianzhiNum();
    /**  在房东没有设置佣金时候订金的百分比   ***/
    public double centNumIsZeroDingjinGet();
    
    
    
    
}