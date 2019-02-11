package cn.com.qcc.service;

import java.util.List;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Groupaddress;
import cn.com.qcc.pojo.Grouptype;
import cn.com.qcc.pojo.Rong;
import cn.com.qcc.pojo.Ronggroup;
import cn.com.qcc.pojo.Tribetype;
import cn.com.qcc.queryvo.ArticleDetailCustomer;
import cn.com.qcc.queryvo.GroupVo;
import cn.com.qcc.queryvo.RongCustomer;
import cn.com.qcc.queryvo.TribeVo;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.VillageeVo;

public interface RongService {

	/**创建群组
	 * @param Ronggroup : 群组相关信息
	 * @param detailaddress : 详情地址
	 * @param tribetype : 部落类型
	 * @param otherids : 创建群组时候啦的人
	 * **/
	ResultMap creategroup(Ronggroup rongroup, Groupaddress detaileaddress, Tribetype tribetype , String otherids);
	
	/**加入群组
	 * @param userid : 用户id
	 * @param groupid : 群组id
	 * **/
	ResultMap joingroup(Long userid, Long groupId ,Integer state);

	// 群列表
	List<Ronggroup> getgrouplist(TribeVo tribeVo);

	Integer getgrouplistcount(TribeVo tribeVo);

	// 我加入的群
	List<RongCustomer> mygroup(Long userid);

	// 有兴趣的群
	List<RongCustomer> enjorygroup(TribeVo tribeVo);

	// 有兴趣的群
	Integer enjorygroupcount(TribeVo tribeVo);

	// 群详情
	RongCustomer groupdetail(Long groupid);

	// 明星群主
	List<UserCustomer> hortuser(TribeVo tribeVo);

	// 明星群主
	Integer hortusercount(Long userid);

	// 人气群
	List<RongCustomer> hortgroup(TribeVo tirbevo);

	// 人气群
	Integer hortgroupcount(TribeVo tirbevo);

	// 群成员
	List<RongCustomer> groupuser(Long groupid);
	
	//退出群组方法
	ResultMap quit(Long userid, Long groupid);
	
	//消息同步
	ResultMap syncUser(Long groupid , Long userid ,Integer type);
	
	//同步个人消息
	ResultMap syncpcmsg(Rong rong);
	//同步群组信息
	ResultMap syncgrmsg(Long groupid, String content);
	
	//相关的群
	ResultMap aboutgroup(Ronggroup ronggroup);
	
	//获取群成员
	ResultMap single(Ronggroup ronggroup);

	ResultMap editgroup(Ronggroup ronggoup);
	
	/**拉入进群
	 * @param groupid : 群组id
	 * @param otherids : 拉入的人的id
	 * @param userid : 操作人id
	 * **/
	ResultMap laren(Long groupid, String otherids ,Long userid);
	
	/**查询**/
	List<RongCustomer> searchjoingroup(GroupVo groupVo );
	int searchjoingroupCount(GroupVo groupVo);
	
	/**申请加入群组**/
	ResultMap applyjoin(Long groupid, Long userid);
	
	/**根据用户id查询用户加入的群组**/
	List<Ronggroup> searchgroupbyuser(Long userid, PageQuery pagequery);
	int searchgroupbyuserCount(Long userid);
	
	/**根据兴趣部落一级分类id查询二级分离**/
	List<Tribetype> searchAvocationbytribetypeid(Integer tribetypeid);
	
	/**根据群组id查询分类**/
	List<Grouptype> getGroupTypge(Long grouptypeid);
	
	/**查询分组信息**/
	List<RongCustomer> searchAddgroupbyAddressName(GroupVo groupVo);
	int searchAddgroupbyAddressNameCount(GroupVo groupVo);

	List<RongCustomer> searchGroupbyIds(List<Long> detailids , Long userid);
	
	/**查群详情的信息**/
	ResultMap searchgroupdetail(GroupVo groupVo);
	
	/**解散群组**/
	ResultMap deleteGroup(Long userid, Long groupid);

	/**查询附近的人**/
	List<ArticleDetailCustomer> nearpersion(VillageeVo userVo);
	int nearpersionCount(VillageeVo villageVo);
	
	

}
