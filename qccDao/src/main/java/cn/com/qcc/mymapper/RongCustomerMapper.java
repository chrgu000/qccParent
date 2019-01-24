package cn.com.qcc.mymapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.pojo.Ronggroup;
import cn.com.qcc.queryvo.ArticleDetailCustomer;
import cn.com.qcc.queryvo.GroupVo;
import cn.com.qcc.queryvo.RongCustomer;
import cn.com.qcc.queryvo.VillageeVo;

public interface RongCustomerMapper {
	
	/**查询想要加入的群组**/
	List<RongCustomer> searchjoingroup(GroupVo groupVo);
	int searchjoingroupCount( GroupVo groupVo);
	
	
	/**根据用户id查询用户所有的群组**/
	int searchgroupbyuserCount(Long userid);
	List<Ronggroup> searchgroupbyuser(@Param("userid") Long userid
			, @Param("pagequery")PageQuery pagequery);
	
	/**分组查询群组**/
	List<RongCustomer> searchAddgroupbyAddressName(GroupVo groupVo);
	int searchAddgroupbyAddressNameCount(GroupVo groupVo);
	
	/**根据详情地址id查询群组数据**/
	List<RongCustomer> searchGroupbyIds( @Param("idsList")List<Long> detailids , @Param("userid") Long userid);
	
	/**查询群详情信息**/
	RongCustomer searchgroupdetail(GroupVo groupVo);
	
	
	/** 清空对应的数据**/
	void deleteGroup(Long groupid);
	void deleteGroupConn(Long groupid);
	
	/**查询附近的人**/
	List<ArticleDetailCustomer> nearpersion(VillageeVo userVo);
	int nearpersionCount(VillageeVo villageVo);
	
}