package cn.com.qcc.mapper;

import cn.com.qcc.pojo.Rong;
import cn.com.qcc.pojo.RongExample;
import cn.com.qcc.pojo.Ronggroup;
import cn.com.qcc.queryvo.RongCustomer;
import cn.com.qcc.queryvo.TribeVo;
import cn.com.qcc.queryvo.UserCustomer;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RongMapper {
    int countByExample(RongExample example);

    int deleteByExample(RongExample example);

    int deleteByPrimaryKey(Long rid);

    int insert(Rong record);

    int insertSelective(Rong record);

    List<Rong> selectByExample(RongExample example);

    Rong selectByPrimaryKey(Long rid);

    int updateByExampleSelective(@Param("record") Rong record, @Param("example") RongExample example);

    int updateByExample(@Param("record") Rong record, @Param("example") RongExample example);

    int updateByPrimaryKeySelective(Rong record);

    int updateByPrimaryKey(Rong record);
    
    
 // 查询聊天记录的集合
  	List<Rong> selectRongList(@Param("userid") Long userid);

  	// 查询谁联系我的列表
  	List<Rong> selectbetouch(@Param("userid") Long userid);

  	// 群列表
  	List<Ronggroup> getgrouplist(TribeVo tribeVo);

  	Integer getgrouplistcount(TribeVo tribeVo);

  	// 我加入的群
  	List<RongCustomer> mygroup(@Param("userid") Long userid);

  	// 有兴趣的群
  	List<RongCustomer> enjorygroup(TribeVo tribeVo);

  	// 有兴趣的群
  	Integer enjorygroupcount(TribeVo tribeVo);

  	// 群详情
  	RongCustomer groupdetail(Long groupid);

  	// 明星群主
  	List<UserCustomer> hortuser(TribeVo tirbevo);

  	// 明星群主
  	Integer hortusercount(Long userid);

  	// 人气群
  	List<RongCustomer> hortgroup(TribeVo tirbevo);

  	// 人气群
  	Integer hortgroupcount(TribeVo tirbevo);

  	//	群成员
  	List<RongCustomer> groupuser(Long groupid);
  	
  	//退出群组
  	void quit( @Param("userid")String userid, @Param("groupid") String groupid);
  	
  	void qutirong(@Param("userid")  String userid, @Param("groupid")  String groupid);
  	//同步
  	void groupsync(Long groupid);
  	//相关的群
 	List<RongCustomer> aboutgroup(Ronggroup ronggroup);
 	
 	//获取群成员
 	List<RongCustomer> single(Ronggroup ronggroup);
}