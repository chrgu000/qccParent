package cn.com.qcc.service.impl;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.qcc.common.DateUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.mapper.FinanceMapper;
import cn.com.qcc.mapper.HousepayMapper;
import cn.com.qcc.mapper.HousepersionMapper;
import cn.com.qcc.mapper.MycentMapper;
import cn.com.qcc.mapper.UserMapper;
import cn.com.qcc.mymapper.CentCustomerMapper;
import cn.com.qcc.mymapper.UserCustomerMapper;
import cn.com.qcc.pojo.Finance;
import cn.com.qcc.pojo.FinanceExample;
import cn.com.qcc.pojo.Housepay;
import cn.com.qcc.pojo.Housepersion;
import cn.com.qcc.pojo.HousepersionExample;
import cn.com.qcc.pojo.Mycent;
import cn.com.qcc.pojo.MycentExample;
import cn.com.qcc.pojo.User;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.UserCentCustomer;
import cn.com.qcc.queryvo.UserCentVo;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.CentService;

@Service
@Transactional
public class CentServiceImpl implements CentService {
	@Autowired
	FinanceMapper financeMapper;
	@Autowired
	HousepayMapper housepayMapper;
	@Autowired
	HousepersionMapper housepersionMapper;
	@Autowired
	UserCustomerMapper userCustomerMapper;
	@Autowired
	CentCustomerMapper centCustomerMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	MycentMapper mycentMapper;

	/**
	 *	根据传过来的IDS 手动收款
	 * @param housepayids : 前台传过来的housepayid 的集合。
	 **/
	public ResultMap gathering(String housepayids) {
	
		if ("".equals(housepayids) || housepayids == null) {
			return ResultMap.build(400,"没有选中!");
		}
		//收款注意的操作 1，收款时间。2，收款方式，3，状态为收款状态.
		Housepay housepay = new Housepay();
		String [] ids  =  housepayids.split(","); 
		for (int i = 0;i<ids.length;i++) {
			housepay.setUpdate_time(new Date()); //设置收款时间
			housepay.setPaystate(2);            //修改状态为已经收款
			housepay.setHousepayid(Long.valueOf(ids[i])); //设置主键
			housepay.setCurrentstate(2);       //当前账单为历史账单
			housepayMapper.updateByPrimaryKeySelective(housepay); //执行操作
		}
		return ResultMap.IS_200();
	}

	/**
	 *	添加入驻人
	 * @param usercentnum : 合同编号 [必填]。
	 * @param username : 姓名 [必填]
	 * @param sex : 性别 [必填]
	 **/
	public ResultMap addhousepersion(Housepersion housepersion ,Long userid) {
		
		String jinjiphone = housepersion.getJinjitelephone();
		housepersion.setJinjilanname(jinjiphone);
		
		if (housepersion.getUsercentnum() == null || "".equals(housepersion.getUsercentnum())) {
			return ResultMap.build(400, "合同编号空");
		}
		housepersion.setState(1); //在住
		housepersion.setCentstate(2); //入驻人
		if (userid == null || userid < 0 ) {
			if (housepersion.getSex() == null || "".equals(housepersion.getSex())) {
				return ResultMap.build(400, "性别不能为空");
			}
			if (housepersion.getRealname() == null || "".equals(housepersion.getRealname())) {
				return ResultMap.build(400, "真实姓名空");
			}
			housepersionMapper.insertSelective(housepersion);
			return ResultMap.build(200, "添加成功");
		} 
		UserCustomer user = userCustomerMapper.getcommonusermess(userid);
		if (user == null) {return ResultMap.build(400, "签约用户不存在");}
		housepersion.setRealname(user.getRealname());
		housepersion.setSex(user.getSex());
		housepersion.setCentstate(1); //承租人
		housepersion.setIdentity(user.getIdentity());
		housepersion.setPictures(user.getIdpictures());
		housepersion.setTelephone(user.getTelephone()+"");
		housepersionMapper.insertSelective(housepersion);
		return ResultMap.build(200, "添加成功");
		
	}

	/**
	 *	删除入驻人
	 * @param housepersionid : 入驻人主键
	 * @param type : type -delete 删除 。type - out 搬离
	 **/
	public ResultMap deletehousepersionbyid(Long housepersionid  ,String type ) {
		if (housepersionid == null) {
			return ResultMap.build(300, "入驻人未选择");
		}
		if ("delete".equals(type)) {
			housepersionMapper.deleteByPrimaryKey(housepersionid);
			return ResultMap.build(200, "删除成功");
		}else if ("out".equals(type)) {
			Housepersion pHousepersion = new Housepersion();
			pHousepersion.setHousepersionid(housepersionid);
			pHousepersion.setState(2);//搬离
			housepersionMapper.updateByPrimaryKeySelective(pHousepersion);
			return ResultMap.build(200, "搬离成功");
		}
		
		return ResultMap.build(400, "type类型不对");
	}

	
	/**
	 *	查询租客列表
	 * @param houseVo : 
	 **/
	public List<UserCentCustomer> housepersionlist(HouseVo houseVo) {
		List <UserCentCustomer> housepersionlist  = userCustomerMapper.housepersionlist(houseVo);
		// 去除多余的父名称
		for (int i = 0; i < housepersionlist.size(); i++) {
			for (int j = housepersionlist.size() - 1; j > i; j--) {// 从最后一个数开始到i+1
				Long builid1 = housepersionlist.get(i).getBuildingid();
				Long builid2 = housepersionlist.get(j).getBuildingid();
				Long houseid1 = housepersionlist.get(i).getHouseid();
				Long houseid2 = housepersionlist.get(j).getHouseid();
				if (houseid1 - houseid2==0) {
					housepersionlist.get(j).setHouse_number("-1");
				}
				if (builid1 - builid2==0) {
					housepersionlist.get(j).setBuilding("");
					housepersionlist.get(j).setVillagename("");
					Integer floor1 = housepersionlist.get(i).getFloor();
					Integer floor2 = housepersionlist.get(j).getFloor();
					if (floor1-floor2==0) {
						housepersionlist.get(j).setFloor(-1);
						
					}
				}
				
			}
		}
		
		return housepersionlist;
	}
	public int housepersionlistCount(HouseVo houseVo) {
		return userCustomerMapper.housepersionlistCount(houseVo);
	}

	
	
	
	

	/**
	 *	根据房源ID查询历史租客
	 * @param houseid : 房源ID
	 **/
	public List<Housepersion> historyhouserpersion(Long houseid) {
		return centCustomerMapper.historyhouserpersion(houseid);
	}
	

	//根据租客ID详情租客详情信息
	public Housepersion searchhousepersionbyid(Long housepersionid) {
		if (housepersionid == null) {
			return null;
		}
		return housepersionMapper.selectByPrimaryKey(housepersionid);
	}

	//根据租约编号查询租客信息
	public List<Housepersion> gethouserpersionbycentnum(String usercentnum) {
		if ("".equals(usercentnum) || usercentnum == null) {
			return null;
		}
		HousepersionExample example = new HousepersionExample();
		HousepersionExample.Criteria criteria = example.createCriteria();
		criteria.andUsercentnumEqualTo(usercentnum);
		List<Housepersion> returnlist = housepersionMapper.selectByExample(example);
		return returnlist;
	}

	//根据账单ID，查询账单详情信息
	public UserCentCustomer gethousepaybyid(Long housepayid) {
		UserCentCustomer returnuser =  centCustomerMapper.gethousepaybyid(housepayid);
		//如果是未支付计算逾期时间
		if (returnuser.getPaystate() == 1 ) {
			int needoutday = DateUtil.daysBetween(new Date(), returnuser.getNeedpaytime());
			returnuser.setNeedoutday(needoutday);
		}
		return returnuser;
	}

	//根据租约编号查询承租人信息
	public Housepersion getcentuserbyCentnum(String usercentnum) {
		
		return centCustomerMapper.getcentuserbyCentnum(usercentnum);
	}

	//通过账单ID查询出发送短信的租户信息
	public UserCentCustomer messdetail(Long housepayid) {
		UserCentCustomer usercent =  centCustomerMapper.messdetailrent(housepayid);
		//这里查询房东信息
		User user = userMapper.selectByPrimaryKey(usercent.getUserid());
		usercent.setLandphone(user.getTelephone()+"");
		return usercent;
	}

	/**
	 *	催单发送短信
	 * @param rentphone : 租户电话号码
	 *  @param content : 短信内容
	 *  @param landphone : 房东或者管理电话
	 *   @param state : 'yes'表示给自己发
	 **/
	public ResultMap sendmess(Long rentphone, String content, HttpServletRequest request, Long landphone,
			String state) {
		if (rentphone == null ) {
			return ResultMap.build(400, "发送人电话不能为空");
		}
		if ("".equals(content) || content == null) {
			return ResultMap.build(400, "发送内容不能为空");
		}
		if (landphone == null) {
			return ResultMap.build(400, "管理或者房东电话空");
		}
		
		
		try {
			//这里是否需要校验发送的短信条数....
			
			//这里表示要给自己发
			if ("yes".equals(state)){
				SendMessage.qunfa(landphone, content, request);
			}
			SendMessage.qunfa(rentphone, content, request);
		} catch (Exception e) {
		}
		
	
		return ResultMap.build(200, "发送成功");
	}

	/**
	 *	根据userid 和查询条件查询营业报表
	 * @param userid : 用户的ID
	 **/
	public List<UserCentCustomer> statement(UserCentVo userCentVo) {
		Long sta = userCentVo.getStart().getTime()-100;
		Date date = new Date();
        date.setTime(sta);
		userCentVo.setStart(date);
		if (userCentVo.getUserid() == null) {
			return null;
		}
		//如果是根据时间分组
		if ("searchtime".equals(userCentVo.getSerachwhere())) {
			List<UserCentCustomer> cents =  centCustomerMapper.statement(userCentVo);
			for (UserCentCustomer cent :cents) {
				String str [] = cent.getCategoryname().split("-");
				cent.setCategoryname(str[1]+"."+str[2]);
			}
			return cents;
		}
		if ("searchhouse".equals(userCentVo.getSerachwhere())) {
			return centCustomerMapper.bussiness(userCentVo);
		}
		return null;
	}
	public int statementCount(UserCentVo userCentVo) {
		return centCustomerMapper.statementCount(userCentVo);
	}
	
	
	
	

	/**
	 *	统计待收总计和没有收总计
	 * @param userid : 用户的ID
	 **/
	public UserCentCustomer totalbil(UserCentVo userCentVo) {
		return centCustomerMapper.totalbil(userCentVo);
	}

	/**
	 * 根据查询条件查询营业报表实收房租和其他费用
	 * **/
	public UserCentCustomer totalbilreal(UserCentVo userCentVo) {
		return centCustomerMapper.totalbilreal(userCentVo);
	}

	/**
	 *	根据房号分组查询营业报表 COUNT
	 * @param userid : 用户的ID
	 **/
	public int bussinessCount(UserCentVo userCentVo) {
		return centCustomerMapper.bussinessCount(userCentVo);
	}

	

	/**
	 * 根据房东的userid 查询小区列表
	 * **/
	public List<BuildingCustomer> villagesbylanduserid(Long userid) {
		return centCustomerMapper.villagesbylanduserid(userid);
	}

	/**
	 *	根据房东ID。查账单列表
	 * @param userid : 用户的ID
	 **/
	public List<UserCentCustomer> bilelist(UserCentVo userCentVo) {
		List<UserCentCustomer> list =  centCustomerMapper.bileist(userCentVo);
		for (UserCentCustomer cent : list) {
			//如果是未支付计算逾期时间
			if (cent.getPaystate()  == 1 && cent.getNeedpaytime() !=null) {
					int needoutday = DateUtil.daysBetween(new Date(), cent.getNeedpaytime());
					cent.setNeedoutday(needoutday);
			}
		}
		return list;
	}
	public int bilelistCount(UserCentVo userCentVo) {
		return centCustomerMapper.bilelistCount(userCentVo);
	}

	
	/**
	 *	账单的二级联动条件之第一级
	 **/
	public List<Finance> financebiles(Long financeid) {
		FinanceExample example = new FinanceExample();
		FinanceExample.Criteria criteria = example.createCriteria();
		criteria.andFatheridEqualTo(financeid);
		return financeMapper.selectByExample(example);
	}
	
	

	/**
	 *	总账单统计整体数据
	 **/
	public HouseCustomer bilelisttotal(UserCentVo userCentVo) {
		return centCustomerMapper.bilelisttotal(userCentVo);
	}

	/**
	 *	查询交易流水统计进出账
	 **/
	public List<UserCentCustomer> builnum(UserCentVo userCentVo) {
		List<UserCentCustomer> list =  centCustomerMapper.builnum(userCentVo);
		// 去除多余的父名称
		for (int i = 0; i < list.size(); i++) {
			for (int j = list.size() - 1; j > i; j--) {// 从最后一个数开始到i+1
				String updatename1 = list.get(i).getUpdateTime();
				String updatename2 = list.get(j).getUpdateTime();
				if (updatename1.equals(updatename2)) {
					list.get(j).setUpdateTime("");
					list.get(j).setCurrentprices(-1.0);
					list.get(j).setOtherprices(-1);
				}
			}
		}
		return list;
	}
	public int builnumCount(UserCentVo userCentVo) {
		return centCustomerMapper.builnumCount(userCentVo);
	}


	/**
	 *	查询交易流水统计进出账
	 **/
	public UserCentCustomer builnumdetail(UserCentVo userCentVo) {
		return centCustomerMapper.builnumdetail(userCentVo);
	}

	

	/**
	 *	房东查询租户合同的统计
	 **/
	public List<UserCentCustomer> landsearchusercent(HouseVo houseVo) {
		return centCustomerMapper.landsearchusercent( houseVo);
	}
	public int landsearchusercentCount(HouseVo houseVo) {
		return centCustomerMapper.landsearchusercentCount(houseVo);
	}

	
	
	/**
	 *	查询合同管理
	 *@param userid : 用户ID
	 **/
	public List<Mycent> mycentlist(Long userid) {
		MycentExample example = new MycentExample();
		MycentExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		List<Mycent> cents = mycentMapper.selectByExample(example);
		return cents;
	}

	
	
	/**
	 *	编辑合同的查询
	 **/
	public Mycent editsearchmycent(Mycent mycent) {
		return mycentMapper.selectByPrimaryKey(mycent.getMycentid());
	}

	/**
	 *	编辑合同
	 **/
	public void editmycent(Mycent mycent) {
		mycent.setUpdate_time(new Date());
		mycentMapper.updateByPrimaryKeySelective(mycent);
	}

	/**
	 *	删除合同
	 **/
	public void deletemycent(Long mycentid) {
		mycentMapper.deleteByPrimaryKey(mycentid);
	}


}
