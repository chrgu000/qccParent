package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Sugges;
import cn.com.qcc.pojo.SuggesExample;
import cn.com.qcc.queryvo.SuggesCustomer;
import cn.com.qcc.queryvo.VillageeVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SuggesMapper {
    int countByExample(SuggesExample example);

    int deleteByExample(SuggesExample example);

    int deleteByPrimaryKey(Long suggesid);

    int insert(Sugges record);

    int insertSelective(Sugges record);

    List<Sugges> selectByExample(SuggesExample example);

    Sugges selectByPrimaryKey(Long suggesid);

    int updateByExampleSelective(@Param("record") Sugges record, @Param("example") SuggesExample example);

    int updateByExample(@Param("record") Sugges record, @Param("example") SuggesExample example);

    int updateByPrimaryKeySelective(Sugges record);

    int updateByPrimaryKey(Sugges record);
    
    
 // 已经反馈列表
 	List<SuggesCustomer> suggeslist(VillageeVo villageeVo);

 	// 已经反馈列表
 	Integer suggescount(VillageeVo villageeVo);

 	// 反馈的详情
 	SuggesCustomer searchbyid(Long suggesid);
}