package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Weixinuserinfo;
import cn.com.qcc.pojo.WeixinuserinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeixinuserinfoMapper {
    int countByExample(WeixinuserinfoExample example);

    int deleteByExample(WeixinuserinfoExample example);

    int deleteByPrimaryKey(String openId);

    int insert(Weixinuserinfo record);

    int insertSelective(Weixinuserinfo record);

    List<Weixinuserinfo> selectByExample(WeixinuserinfoExample example);

    Weixinuserinfo selectByPrimaryKey(String openId);

    int updateByExampleSelective(@Param("record") Weixinuserinfo record, @Param("example") WeixinuserinfoExample example);

    int updateByExample(@Param("record") Weixinuserinfo record, @Param("example") WeixinuserinfoExample example);

    int updateByPrimaryKeySelective(Weixinuserinfo record);

    int updateByPrimaryKey(Weixinuserinfo record);
}