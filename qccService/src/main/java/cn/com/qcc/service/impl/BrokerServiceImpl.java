package cn.com.qcc.service.impl;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.common.HttpSign;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.BrokerMapper;
import cn.com.qcc.mapper.CodeMapper;
import cn.com.qcc.mapper.LandloadBrokerMapper;
import cn.com.qcc.mapper.ProfileMapper;
import cn.com.qcc.mapper.SystemstateMapper;
import cn.com.qcc.mymapper.BrokerCustomerMapper;
import cn.com.qcc.mymapper.HydCoalCustomerMapper;
import cn.com.qcc.mymapper.UserCustomerMapper;
import cn.com.qcc.pojo.Broker;
import cn.com.qcc.pojo.LandloadBroker;
import cn.com.qcc.pojo.LandloadBrokerExample;
import cn.com.qcc.pojo.Profile;
import cn.com.qcc.queryvo.UserCentVo;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.UserVo;
import cn.com.qcc.service.BrokerService;
import weixin.util.XiaoChengXuCodeUtil;
@Service
public class BrokerServiceImpl implements BrokerService{
	@Autowired CodeMapper codeMapper;
	@Autowired BrokerMapper brokerMapper;
	@Autowired ProfileMapper profileMapper;
	@Autowired HydCoalCustomerMapper hydCoalCustomerMapper;
	@Autowired UserCustomerMapper userCustomerMapper;
	@Autowired BrokerCustomerMapper brokerCustomerMapper;
	@Autowired LandloadBrokerMapper landloadBrokerMapper;
	@Autowired SystemstateMapper systemstateMapper;
	
	
	/**
	 * 经纪人入驻
	 * **/
	public ResultMap bebroker(Broker broker) {
		//判断用户是否已经入住
		Broker search = brokerMapper.selectByPrimaryKey(broker.getUserid());
		if (search !=null) {return ResultMap.build(200, "已经是经纪人");}
		//已经是经纪人
		broker.setState(2);
		String xpx_qcc = XiaoChengXuCodeUtil.make_qcc_xcxqcode(broker.getUserid(), "brokerdetail");
		String xpx_gzf = XiaoChengXuCodeUtil.make_gzf_xcxqcode(broker.getUserid(), "brokerdetail");
		broker.setXcxpicture(xpx_qcc +"," + xpx_gzf);
		broker.setUpdate_time(new Date());
		brokerMapper.insertSelective(broker);
		return ResultMap.build(200,"申请成功");
	}


	/**
	 * 实名认证
	 * **/
	public ResultMap brokeruser(Profile profile) {
		//校验用户是否实名过
		UserCustomer userCustomer = userCustomerMapper.getcommonusermess(profile.getUser_id());
		if (userCustomer == null) {return ResultMap.build(900, "用户不存在!");}
		if (userCustomer.getSignstate() == 2) {return ResultMap.build(200,"已实名");}
		boolean flag  =  HttpSign.checkuserrealmessage(profile.getReal_name(), profile.getIdentity());
		Integer signstate = 1; //默认是实名未通过
		String message = "实名失败!";
		Integer code = 300;
		if (flag == true) {
			signstate =2;
			code = 200;
			message = "实名成功!";
		}
		if (signstate == 2) {
			profile.setSignstate(signstate);
			profile.setProfileid(userCustomer.getProfileid());
			profileMapper.updateByPrimaryKeySelective(profile);
		}
		return ResultMap.build(code, message,userCustomer.getUserid());
	}


	/**
	 * 找经纪人
	 * **/
	public List<UserCustomer> searchbroker(UserCentVo user) {
		//找经纪人
		return userCustomerMapper.searchbroker(user);
	}


	@Override
	public int searchbrokerCount(UserCentVo userCentVo) {
		// TODO Auto-generated method stub
		return userCustomerMapper.searchbrokerCount(userCentVo);
	}


	/**通过城市查询code
	 * @param city : 城市的名称
	 * **/
	public String getcodebycity(String city) {
		// TODO Auto-generated method stub
		return hydCoalCustomerMapper.getcodebycity(city);
	}


	/**
	 * 查询我的房东
	 * **/
	public List<UserCustomer> searchmylandload(UserVo userVo) {
		return brokerCustomerMapper.searchmylandload(userVo);
	}
	public int searchmylandloadCount(UserVo userVo) {
		return brokerCustomerMapper.searchmylandloadCount(userVo);
	}


	public int searchmylandloadnewcount(UserVo userVo) {
		return brokerCustomerMapper.searchmylandloadnewcount(userVo);
	}


	/**
	 * 查询我的的经济人
	 * **/ 
	public List<UserCustomer> searchmybroker(UserVo userVo) {
		return brokerCustomerMapper.searchmybroker(userVo);
	}
	//查询我的经济人COUNT
	public int searchmybrokerCount(UserVo userVo) {
		return brokerCustomerMapper.searchmybrokerCount(userVo);
	}


	//查询 哪些经济人申请加入我这个房东
	public int searchmybrokernewcount(UserVo userVo) {
		return brokerCustomerMapper.searchmybrokernewcount(userVo);
	}


	/**
	 * 根据条件查询类似经纪人
	 * **/
	public List<UserCustomer> searchlikebroker(UserCustomer search) {
		// TODO Auto-generated method stub
		return brokerCustomerMapper.searchlikebroker(search);
	}


	/**
	 * 根据userid 查询经纪人
	 * **/
	public Broker searchbrokeruserbyid(Long userid) {
		return brokerMapper.selectByPrimaryKey(userid);
	}


	/**
	 * 查询想要添加的房东
	 * **/
	public List<UserCustomer> searchlikeaddlandlord(UserCustomer search) {
		return brokerCustomerMapper.searchlikeaddlandlord(search);
	}


	/**房东添加经纪人
	 * @param landuserid : 房东的userid
	 * @param brokeruserid : 经纪人的userid
	 * **/
	public ResultMap landaddbroker(Long landuserid, Long brokeruserid) {
		// 先校验控制表是否有数据
		LandloadBrokerExample example = new LandloadBrokerExample();
		LandloadBrokerExample.Criteria criteria = example.createCriteria();
		criteria.andLanduseridEqualTo(landuserid);
		criteria.andBrokeruseridEqualTo(brokeruserid);
		List<LandloadBroker> list = landloadBrokerMapper.selectByExample(example);
		Long defaultstate = 1L;
		if (! list.isEmpty() && list.size() > 0) {
			//说明之前已经建立过关系了
			LandloadBroker search = list.get(0);
			if (search.getState() == 4) {
				brokerCustomerMapper.updatelandaddbroker(landuserid , brokeruserid ,defaultstate );
				return ResultMap.build(200, "操作成功");
			}else {
				return ResultMap.build(400, "申请中...");
			}
		}
		//获取经纪人的默认状态
		Integer searchdata = systemstateMapper.selectByPrimaryKey(2).getDefaultstate();
		//查询默认状态
		if (searchdata != 3) { searchdata = Integer.parseInt(defaultstate+""); }
		LandloadBroker insert = new LandloadBroker();
		insert.setBrokeruserid(brokeruserid);
		insert.setState(searchdata);
		insert.setLanduserid(landuserid);
		insert.setUpdate_time(new Date());
		landloadBrokerMapper.insert(insert);
		return ResultMap.build(200, "操作成功");
	}


	/**经纪人添加房东
	 * @param landuserid : 房东的userid
	 * @param brokeruserid : 经纪人的userid
	 * **/
	public ResultMap brokerandland(Long landuserid, Long brokeruserid) {
		LandloadBrokerExample example = new LandloadBrokerExample();
		LandloadBrokerExample.Criteria criteria = example.createCriteria();
		criteria.andLanduseridEqualTo(landuserid);
		criteria.andBrokeruseridEqualTo(brokeruserid);
		List<LandloadBroker> list = landloadBrokerMapper.selectByExample(example);
		Long defaultstate = 2L;
		if (! list.isEmpty() && list.size() > 0) {
			//说明之前已经建立过关系了
			LandloadBroker search = list.get(0);
			if (search.getState() == 4) {
				brokerCustomerMapper.updatelandaddbroker(landuserid , brokeruserid ,defaultstate );
				return ResultMap.build(200, "操作成功");
			}else {
				return ResultMap.build(400, "申请中...");
			}
		}
		//获取经纪人房东添加的默认参数
		Integer searchstate = systemstateMapper.selectByPrimaryKey(2).getDefaultstate();
		if (searchstate !=3) {
			searchstate = Integer.parseInt(defaultstate+"");
		}
		LandloadBroker insert = new LandloadBroker();
		insert.setBrokeruserid(brokeruserid);
		insert.setState(searchstate);
		insert.setLanduserid(landuserid);
		insert.setUpdate_time(new Date());
		landloadBrokerMapper.insert(insert);
		return ResultMap.build(200, "操作成功");
	}


	/**
	 * 房东查询经纪人的申请
	 * @param landuserid : 房东的userid
	 * **/
	public List<UserCustomer> landsearchbrokerapply(Long userid) {
		return brokerCustomerMapper.landsearchbrokerapply(userid);
	}


	/**经纪人查询房东的申请列表
	 * @param brokeruserid : 经纪人的userid
	 * **/
	public List<UserCustomer> brokersearchlandapply(Long userid) {
		return brokerCustomerMapper.brokersearchlandapply(userid);
	}


	/**
	 * 根据当前userid 和查询的userid i 校验数据是否存在
	 * **/
	public LandloadBroker checklandbroker(Long userid, Long searchuserid) {
		LandloadBrokerExample example = new LandloadBrokerExample();
		LandloadBrokerExample.Criteria criteria = example.createCriteria();
		criteria.andLanduseridEqualTo(userid);
		criteria.andBrokeruseridEqualTo(searchuserid);
		List<LandloadBroker> list = landloadBrokerMapper.selectByExample(example);
		if (! list.isEmpty() && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}


	/**更新 房东和经纪的状态
	 * @param userid : 当前的用户userid 也就是房东id
	 * @param searchuserid ：更新的经纪人的userid
	 * @param state ：更新的状态码
	 * **/ 
	public ResultMap landapprovebroker(Long userid, Long searchuserid, Long state) {
		// 房东id,经济人ID , 申请状态
		if (state ==null || ( state !=3 && state != 4) ){
			return ResultMap.build(400, "参数错误");
		}
		LandloadBroker search = checklandbroker(userid , searchuserid );
		//房东处理经纪人 2-经纪人申请 3-正常关系
		if (search == null || (search.getState() !=3 && search.getState()!=2)) {
			return ResultMap.build(401,"参数错误");
		}
		brokerCustomerMapper.updatelandaddbroker(userid, searchuserid, state);
		return ResultMap.build(200, "申请成功");
	}


	/**经济人处理房东 的 申请
	 * @param userid : 当前用户的userid 经纪人的 userid
	 * @param searchuserid : 更新的房东的userid
	 * @param state : 更新的状态码
	 * ***/
	public ResultMap brokerapproveland(Long userid, Long searchuserid, Long state) {
		// TODO Auto-generated method stub [ 经济人处理房东申请 ]
		// 房东id,经济人ID , 申请状态
		if (state ==null || (state !=3 && state != 4) ) {
			return ResultMap.build(400, "参数错误");
		}
		LandloadBroker search = checklandbroker(searchuserid , userid );
		//如果是移除方法 state = 3 如果是添加方法 state = 1
		if (search == null || (search.getState() !=1 && search.getState() !=3) ) {
			return ResultMap.build(401, "参数错误");
		}
		brokerCustomerMapper.updatelandaddbroker(searchuserid, userid, state);
		return ResultMap.build(200, "操作成功");
	}
	
	
	

}
