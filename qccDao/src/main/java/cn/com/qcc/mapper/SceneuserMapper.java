package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Sceneuser;
import cn.com.qcc.pojo.SceneuserExample;
import cn.com.qcc.queryvo.WeiCustomer;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SceneuserMapper {
    int countByExample(SceneuserExample example);

    int deleteByExample(SceneuserExample example);

    int deleteByPrimaryKey(Integer sceneid);

    int insert(Sceneuser record);

    int insertSelective(Sceneuser record);

    List<Sceneuser> selectByExample(SceneuserExample example);

    Sceneuser selectByPrimaryKey(Integer sceneid);

    int updateByExampleSelective(@Param("record") Sceneuser record, @Param("example") SceneuserExample example);

    int updateByExample(@Param("record") Sceneuser record, @Param("example") SceneuserExample example);

    int updateByPrimaryKeySelective(Sceneuser record);

    int updateByPrimaryKey(Sceneuser record);
    
    Integer maxSceneId();

	List<WeiCustomer> getalluser(Integer sceneid);

	List<WeiCustomer> getAllForverCode();
}