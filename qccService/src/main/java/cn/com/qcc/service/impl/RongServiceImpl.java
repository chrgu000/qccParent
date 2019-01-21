package cn.com.qcc.service.impl;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import WangYiUtil.WangYiUtil;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.DetaileaddressMapper;
import cn.com.qcc.mapper.GroupaddressMapper;
import cn.com.qcc.mapper.GrouptypeMapper;
import cn.com.qcc.mapper.RongMapper;
import cn.com.qcc.mapper.RongconnMapper;
import cn.com.qcc.mapper.RonggroupMapper;
import cn.com.qcc.mapper.TribetypeMapper;
import cn.com.qcc.mapper.UserMapper;
import cn.com.qcc.mymapper.RongCustomerMapper;
import cn.com.qcc.pojo.Groupaddress;
import cn.com.qcc.pojo.GroupaddressExample;
import cn.com.qcc.pojo.Grouptype;
import cn.com.qcc.pojo.GrouptypeExample;
import cn.com.qcc.pojo.Rong;
import cn.com.qcc.pojo.RongExample;
import cn.com.qcc.pojo.Rongconn;
import cn.com.qcc.pojo.RongconnExample;
import cn.com.qcc.pojo.Ronggroup;
import cn.com.qcc.pojo.Tribetype;
import cn.com.qcc.pojo.TribetypeExample;
import cn.com.qcc.pojo.User;
import cn.com.qcc.queryvo.AddressCustomer;
import cn.com.qcc.queryvo.ArticleDetailCustomer;
import cn.com.qcc.queryvo.GroupVo;
import cn.com.qcc.queryvo.RongCustomer;
import cn.com.qcc.queryvo.TribeVo;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.VillageeVo;
import cn.com.qcc.service.RongService;
@Service
public class RongServiceImpl implements RongService {

	@Autowired
	RongMapper rongMapper;
	@Autowired
	RonggroupMapper ronggroupMapper;
	@Autowired
	DetaileaddressMapper detaileaddressMapper;
	@Autowired
	TribetypeMapper tribetypeMapper;
	@Autowired
	RongconnMapper rongconnMapper;
	@Autowired
	RongCustomerMapper rongCustomerMapper;
	@Autowired
	GrouptypeMapper grouptypeMapper;
	@Autowired
	GroupaddressMapper groupaddressMapper;
	@Autowired
	UserMapper userMapper;

	@Override
	public void insert(Long userid, Long followUserId) {
		Rong rong_u = this.exist(userid, followUserId);
		if (rong_u != null) {
			rong_u.setUpdate_time(new Date());
			rong_u.setStatue(1);
			rongMapper.updateByPrimaryKeySelective(rong_u);
		} else {
			Rong rong = new Rong();
			rong.setUserid(userid);
			rong.setFollowUserId(followUserId);
			rong.setCreate_time(new Date());
			rong.setUpdate_time(new Date());
			rong.setFollowstatue(1);
			rong.setStatue(1);
			rongMapper.insert(rong);
		}

		Rong rong_f = this.existfollow(userid, followUserId);
		if (rong_f != null) {
			rong_f.setUpdate_time(new Date());
			rong_f.setStatue(1);
			rongMapper.updateByPrimaryKeySelective(rong_f);
		} else {
			Rong rong = new Rong();
			rong.setUserid(followUserId);
			rong.setFollowUserId(userid);
			rong.setCreate_time(new Date());
			rong.setUpdate_time(new Date());
			rong.setFollowstatue(1);
			rong.setStatue(1);
			rongMapper.insert(rong);
		}
	}

	// 判断当前的会话是否存在
	public Rong exist(Long userid, Long followUserId) {
		RongExample example = new RongExample();
		RongExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		criteria.andFollowUserIdEqualTo(followUserId);
		List<Rong> rongList = rongMapper.selectByExample(example);
		if (rongList.size() > 0 && !rongList.isEmpty()) {
			return rongList.get(0);
		} else {
			return null;
		}
	}

	// 判断被当前的会话是否存在
	public Rong existfollow(Long userid, Long followUserId) {
		RongExample example = new RongExample();
		RongExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(followUserId);
		criteria.andFollowUserIdEqualTo(userid);
		List<Rong> rongList = rongMapper.selectByExample(example);
		if (rongList.size() > 0 && !rongList.isEmpty()) {
			return rongList.get(0);
		} else {
			return null;
		}
	}

	// 查询我联系了谁的列表
	public List<Rong> rongList(Long userid) {
		List<Rong> rongList = rongMapper.selectRongList(userid);
		return rongList;
	}

	// 查询谁联系了我的列表
	public List<Rong> selectbetouch(Long userid) {
		return rongMapper.selectbetouch(userid);
	}

	// 移除聊天记录
	public void romovebetouch(Rong rong) {
		rong.setStatue(0);
		rongMapper.updateByPrimaryKeySelective(rong);
	}

	// 创建群组
	public ResultMap creategroup(Ronggroup rongroup, Groupaddress detaileaddress, Tribetype tribetype , 
			String otherids) {
		if (CheckDataUtil.checkisEmpty(rongroup.getUserid())) {
			return ResultMap.build(404, "请登录后在创建群组");
		}
		if (CheckDataUtil.checkisEmpty(rongroup.getName())) {
			return ResultMap.build(400, "请输入群组名称");
		}
		if (CheckDataUtil.checkisEmpty(rongroup.getDescription())) {
			return ResultMap.build(400, "请输入群描述");
		}
		if (CheckDataUtil.checkisEmpty(rongroup.getPicture())) {
			return ResultMap.build(400, "请为你的群组插入图片");
		}
		if (CheckDataUtil.checkNotEqual(rongroup.getState(), 1)
				&& CheckDataUtil.checkNotEqual(rongroup.getState(), 3)) 
			{ return ResultMap.build(400, "建立还是讨论组");}
		
		if (CheckDataUtil.checkisEmpty(detaileaddress.getDetailes())
				|| CheckDataUtil.checkisEmpty(detaileaddress.getLatitude())
				|| CheckDataUtil.checkisEmpty(rongroup.getAddressname())) {
			return ResultMap.build(400,"检查群地址");
		}
		String tid = "";  
		try {
			tid = WangYiUtil.createGroup(rongroup.getName(), 
					rongroup.getUserid(),rongroup.getDescription() , 
					rongroup.getPicture(),otherids);
		} catch (Exception e) {
			e.printStackTrace();
		}	
		if (CheckDataUtil.checkNotEmpty(tid)) {
			rongroup.setGroupid(Long.valueOf(tid));
			Long detailid = getGroupDetailid(detaileaddress);
			// 设置加入群模式
			rongroup.setJointype(0);
			rongroup.setInvitemode(1);
			rongroup.setBeinvitemode(1);
			rongroup.setDetailid(detailid); 
			rongroup.setUptinfomode(0);
			// 获取部落的ID
			rongroup.setUpdate_time(new Date());
			ronggroupMapper.insertSelective(rongroup);
			// 给控制表也同时插入一条记录
			Rongconn rongconn = new Rongconn();
			// 部落首领的唯一标识
			rongconn.setState(4);
			rongconn.setUserid(rongroup.getUserid());
			rongconn.setUpdate_time(new Date());
			rongconn.setGroupid(rongroup.getGroupid());
			rongconnMapper.insertSelective(rongconn);
			
			if (CheckDataUtil.checkNotEmpty(otherids)) {
				String [] userids = otherids.split(",");
				Rongconn insert = new Rongconn();
				for (int i = 0 ; i< userids.length;i++) {
					insert.setState(1);
					insert.setGroupid(Long.valueOf(tid));
					insert.setUpdate_time(new Date());
					insert.setUserid(Long.valueOf(userids[i]));
					rongconnMapper.insertSelective(insert);
					//每次插入后需要把主键置空
					insert.setConnid(null);
				}
			}
			
			return ResultMap.build(200, "创建成功" , tid);
		}
		return ResultMap.build(400, "创建群失败");
	}
	
	
	// 拉人进群
	public ResultMap laren(Long groupid, String otherids ,Long userid) {
		
		if (CheckDataUtil.checkisEmpty(groupid) || 
				CheckDataUtil.checkisEmpty(otherids)) {
			return ResultMap.build(400,"少参数");
		}
		Ronggroup group  = ronggroupMapper.selectByPrimaryKey(groupid);
		if (CheckDataUtil.checkisEmpty(group) ||
				CheckDataUtil.checkisEqual(2,group.getState())) {
			return ResultMap.build(400,"该群不存在");
		}
		
		// 或者拉人的code
		Integer magree = group.getBeinvitemode();
		Integer code = 0 ;
		try {
			code = WangYiUtil.larenGroup(groupid , group.getUserid(), magree , otherids);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// 如果返回的code不是200 说明拉入失败
		if (CheckDataUtil.checkNotEqual(code, 200)) 
		return ResultMap.build(400, "拉入失败请检查参数");
		// 0-需要同意(默认),1-不需要同意。
		if (CheckDataUtil.checkisEqual(magree, 0))
		return ResultMap.build(200, "操作成功等待对方回应");
		
		// 建立和其他成员的关系
		if (CheckDataUtil.checkisEmpty(otherids)) {
			try {
				String [] otherid = otherids.split(",");
				for (int i =0;i<otherid.length;i++) {
					Rongconn follow = new Rongconn();
					follow.setState(1);
					follow.setUserid(Long.valueOf( otherid[i]  ) );
					follow.setUpdate_time(new Date());
					follow.setGroupid(groupid);
					rongconnMapper.insertSelective(follow);
					follow.setConnid(null);
				}
			} catch (Exception e) {
				System.out.println("群成员格式错误");
				e.printStackTrace();
			}
		}
		
		return ResultMap.build(200, "对方已经拉入群组中");
	};


	// 检查详情地址是否存在
	private Long getGroupDetailid(Groupaddress detaileaddress) {
		GroupaddressExample example = new GroupaddressExample();
		GroupaddressExample.Criteria criteria = example.createCriteria();
		if (!"".equals(detaileaddress.getDetailes()) && detaileaddress.getDetailes() != null) {
			criteria.andDetailesEqualTo(detaileaddress.getDetailes());
		}
		if (!"".equals(detaileaddress.getLatitude()) && detaileaddress.getLatitude() != null) {
			criteria.andLatitudeEqualTo(detaileaddress.getLatitude());
		}
		if (!"".equals(detaileaddress.getLongitude()) && detaileaddress.getLongitude() != null) {
			criteria.andLongitudeEqualTo(detaileaddress.getLongitude());
		}
		List<Groupaddress> selectByExample = groupaddressMapper.selectByExample(example);
		if (!selectByExample.isEmpty() && selectByExample.size() > 0) {
			return selectByExample.get(0).getDetailid();
		} else {
			groupaddressMapper.insertSelective(detaileaddress);
			return detaileaddress.getDetailid();
		}
	}


	// 加入群组
	public ResultMap joingroup(Long  userid, Long groupId ,Integer state) {
		if (CheckDataUtil.checkisEmpty(userid)
				|| CheckDataUtil.checkisEmpty(groupId)) {
			return ResultMap.build(400, "少参数");
		}
		String mess = "state参数错误";
		if (CheckDataUtil.checkisEqual(state, 1)) {
			mess = "同意加入";
		} else if (CheckDataUtil.checkisEqual(state, 2)) {
			mess= "拒绝加入";
		} else {
			return ResultMap.build(400, mess);
		}
		//先校验群信息
		Ronggroup searchGroup = ronggroupMapper.selectByPrimaryKey(groupId);
		if (CheckDataUtil.checkisEmpty(searchGroup)
				|| CheckDataUtil.checkisEqual(searchGroup.getState(), 2)) {
			return ResultMap.build(400, "该群不存在");
		}
		//判断用户在群组中位置
		Rongconn conn = getUserConnGroupState(userid ,groupId);
		if (CheckDataUtil.checkisEqual(conn.getState(),1)
				|| CheckDataUtil.checkisEqual(conn.getState(),3) 
				|| CheckDataUtil.checkisEqual(conn.getState(),4)) {
			return ResultMap.build(400, "已经是群成员");
		}
		conn.setState(state);
		rongconnMapper.updateByPrimaryKeySelective(conn);
		return ResultMap.build(200, mess);
	}



	@Override
	public List<Ronggroup> getgrouplist(TribeVo tribeVo) {
		// TODO Auto-generated method stub
		return rongMapper.getgrouplist(tribeVo);
	}

	@Override
	public Integer getgrouplistcount(TribeVo tribeVo) {
		// TODO Auto-generated method stub
		return rongMapper.getgrouplistcount(tribeVo);
	}

	@Override
	public List<RongCustomer> mygroup(Long userid) {
		// TODO Auto-generated method stub
		return rongMapper.mygroup(userid);
	}

	@Override
	public List<RongCustomer> enjorygroup(TribeVo tribeVo) {
		// TODO Auto-generated method stub
		return rongMapper.enjorygroup(tribeVo);
	}

	@Override
	public Integer enjorygroupcount(TribeVo tribeVo) {
		// TODO Auto-generated method stub
		return rongMapper.enjorygroupcount(tribeVo);
	}

	@Override
	public RongCustomer groupdetail(Long groupid) {
		// TODO Auto-generated method stub
		if (groupid == null) {
			return null;
		}
		return rongMapper.groupdetail(groupid);
	}

	@Override
	public List<UserCustomer> hortuser(TribeVo tribeVo) {
		return rongMapper.hortuser(tribeVo);
	}

	@Override
	public Integer hortusercount(Long userid) {
		return rongMapper.hortusercount(userid);
	}

	@Override
	public List<RongCustomer> hortgroup(TribeVo tirbevo) {
		// TODO Auto-generated method stub
		return rongMapper.hortgroup(tirbevo);
	}

	@Override
	public Integer hortgroupcount(TribeVo tirbevo) {
		// TODO Auto-generated method stub
		return rongMapper.hortgroupcount(tirbevo);
	}

	@Override
	public List<RongCustomer> groupuser(Long groupid) {
		// TODO Auto-generated method stub
		return rongMapper.groupuser(groupid);
	}

	@Override
	public ResultMap quit(Long userid, Long groupid) {
		if (CheckDataUtil.checkisEmpty(userid)
				&& CheckDataUtil.checkisEmpty(groupid)) {
			return ResultMap.build(400, "信息不全");
		}
		try {
			WangYiUtil.levelGroup(groupid, userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 更新两个表的状态 1-控制表
		Rongconn conn = getUserConnGroupState(userid, groupid);
		// 聊天表
		conn.setState(2);
		rongconnMapper.updateByPrimaryKeySelective(conn);
		return ResultMap.build(200, "退出成功！");
	}

	@Override
	public ResultMap syncUser(Long groupid , Long userid ,Integer type) {
		if (CheckDataUtil.checkisEmpty(groupid)
				|| CheckDataUtil.checkisEmpty(userid)
				|| CheckDataUtil.checkisEmpty(type)) {
			return ResultMap.build(400, "少参数");
		}
		// type 类型 只能为 1 普通用户 2退出群组 3 管理员 
		if (CheckDataUtil.checkNotEqual(type, 1)
				&& CheckDataUtil.checkNotEqual(type, 2)
				&& CheckDataUtil.checkNotEqual(type, 3)) {
			return ResultMap.build(400, "type类型错误");
		}
		
		Rongconn conn = getUserConnGroupState(userid, groupid);
		conn.setState(type);
		rongconnMapper.updateByPrimaryKeySelective(conn);
		return ResultMap.build(200, "同步完成");
	}

	@Override
	public ResultMap syncpcmsg(Rong rong) {
		if (rong.getContent() == null || "".equals(rong.getContent())) {
			return ResultMap.build(400, "同步内容不能为空！");
		}
		if (rong.getUserid() == null || rong.getFollowUserId() == null) {
			return ResultMap.build(400, "同步角色不能为空！");
		}
		Rong search = checkrongtuch(rong);
		if (search == null) {
			return ResultMap.build(400, "同步角色信息不存在！");
		}
		search.setContent(rong.getContent());
		rongMapper.updateByPrimaryKeySelective(search);
		return ResultMap.IS_200();
	}

	private Rong checkrongtuch(Rong rong) {
		RongExample example = new RongExample();
		RongExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(rong.getUserid());
		criteria.andFollowUserIdEqualTo(rong.getFollowUserId());
		List<Rong> list = rongMapper.selectByExample(example);
		return list == null ? null : list.get(0);
	}

	@Override
	public ResultMap syncgrmsg(Long groupid, String content) {
		if ("".equals(content) || content == null) {
			return ResultMap.build(400, "无群组内容");
		}
		if (groupid == null) {
			return ResultMap.build(400, "群组不存在");
		}
		Ronggroup gRonggroup = new Ronggroup();
		gRonggroup.setGroupid(groupid);
		return ResultMap.IS_200();
	}

	@Override
	public ResultMap aboutgroup(Ronggroup ronggroup) {
		if (ronggroup.getUserid() == null) {
			ronggroup.setUserid(1L);
		}
		List<RongCustomer> group = rongMapper.aboutgroup(ronggroup);
		return ResultMap.IS_200(group);
	}

	@Override
	public ResultMap single(Ronggroup ronggroup) {
		// TODO Auto-generated method stub
		List<RongCustomer> gourp = rongMapper.single(ronggroup);
		return ResultMap.IS_200(gourp);
	}

	@Override
	public ResultMap editgroup(Ronggroup group) {
		System.out.println("进入群编辑..." + group.getBeinvitemode());
		if (CheckDataUtil.checkisEmpty(group.getGroupid())
				|| CheckDataUtil.checkisEmpty(group.getUserid())) {
			return ResultMap.build(400, "少参数");
		}
		Ronggroup searchupdate = ronggroupMapper.selectByPrimaryKey(group.getGroupid());
		if (CheckDataUtil.checkisEmpty(searchupdate)
				|| CheckDataUtil.checkNotEqual(searchupdate.getState(), 1)) 
			{ return ResultMap.build(400, "编辑的群不存在");}
		
		// 判断用户在群组中的地位 如果是1或者
		Rongconn conn = getUserConnGroupState(group.getUserid() , group.getGroupid());
		// 编辑的群名字只有管理员才可以编辑
		String teanName = searchupdate.getName();
		//miaos 
		String deascName = searchupdate.getDescription();
		// 编辑群的头像值有管理员才可以编辑
		String icon = searchupdate.getPicture();
		//成员加入模式只有管理员才可以编辑
		Integer jointype = searchupdate.getJointype();
		Integer invitemode = searchupdate.getInvitemode();
		Integer beinvitemode = searchupdate.getBeinvitemode();
		// 如果是管理员可以编辑群组
		if (CheckDataUtil.checkNotEqual(conn.getState(), 3)
				&& CheckDataUtil.checkNotEqual(conn.getState(), 4)) {
			return ResultMap.build(400, "非群主或者管理");
		}
		// 设置群参数
		if (CheckDataUtil.checkNotEmpty(group.getName())) 
				teanName = group.getName();
		if (CheckDataUtil.checkNotEmpty(group.getInvitemode())) 
				invitemode = group.getInvitemode();
		if (CheckDataUtil.checkNotEmpty(group.getDescription())) 
				deascName = group.getDescription();
		if (CheckDataUtil.checkNotEmpty(group.getPicture())) 
				icon = group.getPicture();
		if (CheckDataUtil.checkNotEmpty(group.getJointype())) 
				jointype = group.getJointype();
		if (CheckDataUtil.checkNotEqual(jointype, 0)
				&& CheckDataUtil.checkNotEqual(jointype, 1)
				&& CheckDataUtil.checkNotEqual(jointype, 2)) {
			return ResultMap.build(400,"jointype错误");
		}
		if (CheckDataUtil.checkNotEmpty(group.getBeinvitemode())) 
				beinvitemode = group.getBeinvitemode();
		int code = 0;
		try {
			code = WangYiUtil.editGroup(group.getGroupid(), 
					searchupdate.getUserid(), teanName, deascName, icon, jointype , invitemode , beinvitemode);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.build(400, "网易云异常");
		}
		if (CheckDataUtil.checkisEqual(code, 200)) {
			Ronggroup update = new Ronggroup();
			update.setDescription(deascName);
			update.setGroupid(group.getGroupid());
			update.setJointype(jointype);
			update.setPicture(icon);
			update.setBeinvitemode(beinvitemode);
			update.setInvitemode(invitemode);
			update.setName(teanName);
			ronggroupMapper.updateByPrimaryKeySelective(update);
			return ResultMap.build(200, "编辑成功");
		}
		return ResultMap.build(400, "编辑失败");
	}
	
	

	private Rongconn  getUserConnGroupState (Long userid ,Long groupid) {
		RongconnExample conn = new RongconnExample();
		RongconnExample.Criteria criteria = conn.createCriteria();
		criteria.andUseridEqualTo(userid);
		criteria.andGroupidEqualTo(groupid);
		List<Rongconn> connList = rongconnMapper.selectByExample(conn);
		if (CheckDataUtil.checkisEmpty(connList)) {
			Rongconn insert = new Rongconn();
			insert.setGroupid(groupid);
			insert.setState(2);
			insert.setUserid(userid);
			insert.setUpdate_time(new Date());
			rongconnMapper.insertSelective(insert);
			return insert;
		}
		return connList.get(0);
	};

	/**查询想要加入的群组**/
	public List<RongCustomer> searchjoingroup(GroupVo groupVo) {
		return rongCustomerMapper.searchjoingroup(groupVo);
	}
	public int searchjoingroupCount(GroupVo groupVo ) {
		return rongCustomerMapper.searchjoingroupCount(groupVo );
	}

	/**申请加入群组**/
	public ResultMap applyjoin(Long groupid, Long userid) {
		if (CheckDataUtil.checkisEmpty(groupid) 
				|| CheckDataUtil.checkisEmpty(userid)) 
			{ return ResultMap.build(400,"少参数");}
		// 先判断群组类型
		Ronggroup group  = ronggroupMapper.selectByPrimaryKey(groupid);
		if (CheckDataUtil.checkisEmpty(group) 
				|| CheckDataUtil.checkisEqual(group.getState(), 2)) 
			{ return ResultMap.build(400, "查无此群");}
		// 获取用户在群组中状态
		Rongconn conn = getUserConnGroupState(userid, groupid);
		// 如果是需要群主同意 需要验证
		if (CheckDataUtil.checkisEqual(group.getJointype(), 1)) {
			// 判断用户是否在群组中
			if (CheckDataUtil.checkisEqual(conn.getState(), 1)
					|| CheckDataUtil.checkisEqual(conn.getState(), 3)
					|| CheckDataUtil.checkisEqual(conn.getState(), 4)) {
				return ResultMap.build(400, "已经在群组中");
			}
			// 需要把用户设置成申请状态
			conn.setState(0);
			rongconnMapper.updateByPrimaryKeySelective(conn);
			return ResultMap.build(200, "你的申请已提交等待管理同意");
		} else if (CheckDataUtil.checkisEqual(group.getJointype(), 0)) {
			//否则是不需要群组同意
			conn.setState(1);
			rongconnMapper.updateByPrimaryKeySelective(conn);
			return ResultMap.build(200,"加入成功");
		}
		return ResultMap.build(400, "不准用户加入");
	}

	
	
	/**根据用户id查询用户加入的群组**/
	public List<Ronggroup> searchgroupbyuser(Long userid, PageQuery pagequery) {
		return rongCustomerMapper.searchgroupbyuser(userid,pagequery);
	}
	public int searchgroupbyuserCount(Long userid) {
		return rongCustomerMapper.searchgroupbyuserCount(userid);
	}

	// 根据兴趣部落一级分类id查询二级分离
	public List<Tribetype> searchAvocationbytribetypeid(Integer tribetypeid) {
		TribetypeExample example = new TribetypeExample();
		TribetypeExample.Criteria criteria = example.createCriteria();
		criteria.andTypecodeEqualTo(tribetypeid);
		List<Tribetype> list = tribetypeMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<Grouptype> getGroupTypge(Long grouptypeid) {
		GrouptypeExample example = new GrouptypeExample();
		GrouptypeExample.Criteria criteria = example.createCriteria();
		criteria.andFatheridEqualTo(grouptypeid);
		return grouptypeMapper.selectByExample(example);
	}

	@Override
	public List<RongCustomer> searchAddgroupbyAddressName(GroupVo groupVo) {
		return rongCustomerMapper.searchAddgroupbyAddressName(groupVo);
	}

	@Override
	public int searchAddgroupbyAddressNameCount(GroupVo groupVo) {
		return rongCustomerMapper.searchAddgroupbyAddressNameCount(groupVo);
	}

	// 根据详情地址的ids集合查询群组的信息
	public List<RongCustomer> searchGroupbyIds(List<Long> detailids , Long userid) {
		return rongCustomerMapper.searchGroupbyIds(detailids ,userid);
	}

	/// 查询群详情
	public ResultMap searchgroupdetail(GroupVo groupVo) {
		if (CheckDataUtil.checkisEmpty(groupVo.getGroupid()) ) {
			return ResultMap.build(400, "缺乏参数");
		}
		
		RongCustomer rongCustomer = rongCustomerMapper.searchgroupdetail(groupVo);
		
		if (CheckDataUtil.checkisEmpty(rongCustomer)) {
			return ResultMap.build(400, "找不到群信息");
		} 
		return ResultMap.IS_200(rongCustomer);
	}

	/**解散群组**/
	public ResultMap deleteGroup(Long userid, Long groupid) {
		if (CheckDataUtil.checkisEmpty(userid)
				|| CheckDataUtil.checkisEmpty(groupid)) {
			return ResultMap.build(400, "少参数");
		}
		//获取用户在群组中地位
		Ronggroup group = ronggroupMapper.selectByPrimaryKey(groupid);
		if (CheckDataUtil.checkisEmpty(group)
				|| CheckDataUtil.checkNotEqual(userid, group.getUserid())) {
			return ResultMap.build(400, "非群主用户");
		}
		try {
			WangYiUtil.deleteGroup(groupid, userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 清空数据
		rongCustomerMapper.deleteGroup(groupid);
		rongCustomerMapper.deleteGroupConn(groupid);
		return ResultMap.build(200, "解散成功");
	}

	@Override
	public List<ArticleDetailCustomer> nearpersion(VillageeVo userVo) {
		
		// 判断有没有传入经纬度
		AddressCustomer addressCustomer = userVo.getAddressCustomer();
		// 如果传入了经纬度则同步经纬度
		PageQuery pagequery = userVo.getPagequery();
		//如果是第一页数据同步用户当前经纬度
		if (pagequery.getCurrentpage() == 1 
				&& CheckDataUtil.checkNotEmpty(addressCustomer.getNearLatude())
				&& CheckDataUtil.checkNotEmpty(userVo.getUserid())) {
			//同步用户当前经纬度
			User update = new User();
			update.setUserid(userVo.getUserid());
			update.setLatitude(Double.valueOf( addressCustomer.getNearLatude() ));
			update.setLongitude(Double.valueOf( addressCustomer.getNearLongitude() ));
			userMapper.updateByPrimaryKeySelective(update);
		}
		
		if (CheckDataUtil.checkisEmpty(addressCustomer.getNearLatude())
				&& CheckDataUtil.checkNotEmpty(userVo.getUserid())) {
			User user = userMapper.selectByPrimaryKey(userVo.getUserid());
			addressCustomer.setNearLatude(user.getLatitude().toString());
			addressCustomer.setNearLongitude(user.getLongitude().toString());
			userVo.setAddressCustomer(addressCustomer);
		}
		
		// 查询附近的人列表
		List<ArticleDetailCustomer> userList = rongCustomerMapper.nearpersion(userVo);
		// 如果没有传入设置typeid 0 
		if (CheckDataUtil.checkNotEmpty(userList)) {
			for (ArticleDetailCustomer detail : userList) {
				if (CheckDataUtil.checkisEmpty(detail.getArticletypeid())) {
					detail.setArticletypeid(0);
					detail.setArticledetailid(-1L);
					detail.setDetailname("");
				}
			}
		}
		
		return userList;
	}

	public int nearpersionCount(VillageeVo villageVo) {
		return rongCustomerMapper.nearpersionCount(villageVo);
	}



}
