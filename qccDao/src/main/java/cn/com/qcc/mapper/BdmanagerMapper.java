package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Bdmanager;
import cn.com.qcc.pojo.BdmanagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BdmanagerMapper {
    int countByExample(BdmanagerExample example);

    int deleteByExample(BdmanagerExample example);

    int deleteByPrimaryKey(String bdid);

    int insert(Bdmanager record);

    int insertSelective(Bdmanager record);

    List<Bdmanager> selectByExample(BdmanagerExample example);

    Bdmanager selectByPrimaryKey(String bdid);

    int updateByExampleSelective(@Param("record") Bdmanager record, @Param("example") BdmanagerExample example);

    int updateByExample(@Param("record") Bdmanager record, @Param("example") BdmanagerExample example);

    int updateByPrimaryKeySelective(Bdmanager record);

    int updateByPrimaryKey(Bdmanager record);

	Bdmanager searchBDByPhoneOrId(String account);
}