package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Browse;
import cn.com.qcc.pojo.BrowseExample;
import cn.com.qcc.queryvo.BrowerCustomer;
import cn.com.qcc.queryvo.HouseVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrowseMapper {
    int countByExample(BrowseExample example);

    int deleteByExample(BrowseExample example);

    int deleteByPrimaryKey(Long browseid);

    int insert(Browse record);

    int insertSelective(Browse record);

    List<Browse> selectByExample(BrowseExample example);

    Browse selectByPrimaryKey(Long browseid);

    int updateByExampleSelective(@Param("record") Browse record, @Param("example") BrowseExample example);

    int updateByExample(@Param("record") Browse record, @Param("example") BrowseExample example);

    int updateByPrimaryKeySelective(Browse record);

    int updateByPrimaryKey(Browse record);
    
    
	// 查询浏览的总量
	Integer selectount(@Param("userid") Long userid, @Param("type") Integer type);

	// 查询单个物品的浏览量
	BrowerCustomer selectountone(@Param("type") Integer type, @Param("otherid") Long otherid);

	// 查询我的列表
	List<BrowerCustomer> mybrowList( HouseVo houseVo);
	//我的访客的数目
	int findmyBrowListCount(HouseVo houseVo);
	
	/**根据type 类型 查询最近10天的id**/
	List<Long> searchIdnearTenDays(int type);
}