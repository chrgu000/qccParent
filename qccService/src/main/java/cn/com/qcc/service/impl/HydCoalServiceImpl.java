package cn.com.qcc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.qcc.common.DateUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.HistorymeterHousepayMapper;
import cn.com.qcc.mapper.HistorymeterMapper;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mapper.HousepayMapper;
import cn.com.qcc.mapper.HydcoalMapper;
import cn.com.qcc.mapper.LandbuildingMapper;
import cn.com.qcc.mapper.PayexpertMapper;
import cn.com.qcc.mapper.UserMapper;
import cn.com.qcc.mapper.UsercentMapper;
import cn.com.qcc.mymapper.HydCoalCustomerMapper;
import cn.com.qcc.pojo.Finance;
import cn.com.qcc.pojo.Historymeter;
import cn.com.qcc.pojo.HistorymeterExample;
import cn.com.qcc.pojo.HistorymeterHousepayExample;
import cn.com.qcc.pojo.HistorymeterHousepayKey;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.Housepay;
import cn.com.qcc.pojo.Hydcoal;
import cn.com.qcc.pojo.HydcoalExample;
import cn.com.qcc.pojo.Landbuilding;
import cn.com.qcc.pojo.Payexpert;
import cn.com.qcc.pojo.User;
import cn.com.qcc.pojo.Usercent;
import cn.com.qcc.pojo.UsercentExample;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.HistorymeterCustomer;
import cn.com.qcc.queryvo.HistorymeterVo;
import cn.com.qcc.queryvo.HydCoalCustomer;
import cn.com.qcc.queryvo.HydCoalVo;
import cn.com.qcc.queryvo.ReckoningCustomer;
import cn.com.qcc.service.HydCoalService;

@Service
@Transactional
public class HydCoalServiceImpl implements HydCoalService{
	
	@Autowired
	UsercentMapper  usercentMapper;
	@Autowired
	UserMapper userMapper;
	@Autowired
	HydCoalCustomerMapper hydCoalCustomerMapper;
	@Autowired
	HydcoalMapper hydcoalMapper;
	@Autowired
	HistorymeterMapper historymeterMapper;
	@Autowired
	LandbuildingMapper landbuildingMapper;
	@Autowired
	HouseMapper houseMapper;
	@Autowired
	PayexpertMapper payexpertMapper;
	@Autowired
	HousepayMapper housepayMapper;
	@Autowired
	HistorymeterHousepayMapper historymeterHousepayMapper;

	//根据传过来的参数批量配置房源单价
	public ResultMap createhydprices(List<HydCoalCustomer> hydcoals) {
		if (hydcoals.isEmpty() || hydcoals.size() == 0) {
			return ResultMap.build(300, "房源ID空");
		}
		//先判断单价 --> 在判断housids 
		for (HydCoalCustomer hyd : hydcoals) {
			//如果传过来了单价
			if (hyd.getUnitprice() !=null) {
				//拆分房源ids
				String houseids = hyd.getHouseids();
				if (houseids!=null && !"".equals(houseids)) {
					String [] houseid = houseids.split(",");
					for (int i=0;i<houseid.length;i++) {
						Long id =  Long.valueOf(houseid[i]);
						//这里要校验之前是否配置
						Hydcoal check = checkHydcoalexist(id , hyd.getFinanceid());
						
						//同步该房东下配置的楼栋的单价
						syncbuildingprices(id , hyd);
						
						//如果之前没有配置过
						if (check == null) {
							Hydcoal inserthyd = new Hydcoal();
							inserthyd.setFinanceid(hyd.getFinanceid());
							inserthyd.setHouseid(id);
							inserthyd.setUnitprice(hyd.getUnitprice());
							inserthyd.setUpdate_time(new Date());
							hydcoalMapper.insertSelective(inserthyd);
						}
						//如果之前配置过执行更新
						else {
							check.setUnitprice(hyd.getUnitprice());
							check.setUpdate_time(new Date());
							hydcoalMapper.updateByPrimaryKeySelective(check);
						}
						
					}
				}
			}
		}
		return ResultMap.build(200, "配置成功");
	}

	private String syncbuildingprices(Long houseid, HydCoalCustomer historymeter) {
		//先通过房源ID 拿到userid 和buildingid
		House house = houseMapper.selectByPrimaryKey(houseid);
		if (house == null) {
			return "" ;
		}
		//先判断该楼下，该ID下面是否曾经配置过
		Landbuilding building = hydCoalCustomerMapper.syncbuildingprices(houseid ,Long.valueOf(historymeter.getFinanceid()));
		
		//说明之前没配置过需要配置
		if (building == null) {
			building = new Landbuilding();
			building.setBuildingid(house.getBuildingid());
			building.setFinanceid( Long.valueOf(historymeter.getFinanceid()) );
			building.setState(historymeter.getState());
			building.setUpdate_time(new Date());
			building.setUnitprice(historymeter.getUnitprice());
			building.setUserid(house.getUser_id());
			landbuildingMapper.insertSelective(building);
			return "";
		}
		//如果之前配置过执行update
		building.setUnitprice(historymeter.getUnitprice());
		building.setState(historymeter.getState());
		landbuildingMapper.updateByPrimaryKeySelective(building);
		return "";
		
	}

	private Hydcoal checkHydcoalexist(Long houseid, Long financeid) {
		HydcoalExample example = new HydcoalExample();
		HydcoalExample.Criteria criteria = example.createCriteria();
		criteria.andFinanceidEqualTo(financeid);
		criteria.andHouseidEqualTo(houseid);
		List<Hydcoal> list = hydcoalMapper.selectByExample(example);
		if (list.size() >0 && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	
	/**
	 *	查询默认的配置价格
	 * @param houseids : 前台传过来的房子的IDS
	 **/
	public List<HydCoalCustomer> defaultprices(String houseids) {
		if (houseids == null || "".equals(houseids)) {
			return null;
		}
		String [] houseid = houseids.split(",");
		List<HydCoalCustomer> hyds = hydCoalCustomerMapper.defaultprices(houseid[0]);
		
		return hyds;
	}

	/**
	 *	根据userid 和buildingid 查询每个月抄表的初始值
	 * @param userid : 用户id。房东的id
	 * @param buildingid : 当前楼栋 的id
	 * 。
	 **/
	public List<HistorymeterCustomer> beforemeter(HydCoalVo hydCoalVo) {
		List<HistorymeterCustomer> historymeters =   hydCoalCustomerMapper.beforemeter(hydCoalVo);
		for (HistorymeterCustomer historymeter:historymeters) {
			// 先计算出没有抄表的
			if (historymeter.getUpdate_time() == null) {
				historymeter.setState(1);  // 1 --表示没有抄表 。2 表示已经抄表
			} else {
				Date date = new Date();
				Long current = historymeter.getUpdate_time().getTime();
				Long begin = DateUtil.getMonthBegin(date);
				Long end  = DateUtil.getMonthEnd(date);
				//说明这个月已经抄表了
				if (current >=begin && current <=end) {
					historymeter.setState(2);
				} else {
					historymeter.setState(1);
				}
			}
		}
		return historymeters;
	}

	
	/**
	 *	当页面失去焦点时候同步缓存
	 * @param userid : 用户id。房东的id
	 * @param buildingid : 当前楼栋 的id
	 **/
	public Integer syncmeter(List<Historymeter> historymeter ,Long userid) {
		Integer count = 0 ;
		if (userid == null) {
			return count;
		}
		User user = userMapper.selectByPrimaryKey(userid);
		if (user == null) {
			return count;
		}
		for (Historymeter meter:historymeter) {
			//如果填写了后面的值
			if (meter.getAftercount() !=null && meter.getBeforecount() !=null 
			&& meter.getFinanceid() !=null && meter.getHouseid() !=null	) {
				//如果后面的值比前面的值大
				if (meter.getBeforecount() < meter.getAftercount()) {
					//这里需要执行抄表操作
					meter.setUpdate_time(new Date());
					meter.setState(1); //待生成账单
					meter.setUserid(userid);
					
					//这里检查没有生成账单的最新一条记录.执行update 
					Historymeter history_new = getnewhistorymeter(meter);
					if (history_new !=null ) {
						//执行update
						history_new.setBeforecount(meter.getBeforecount());
						history_new.setAftercount(meter.getAftercount());
						history_new.setUpdate_time(new Date());
						historymeterMapper.updateByPrimaryKeySelective(history_new);
					} else {
						//否则插入一条新的记录
						historymeterMapper.insertSelective(meter);
					}
					
					
					count++;
				}
			}
		}
		
		return count;
	}

	private Historymeter getnewhistorymeter(Historymeter meter) {
		HistorymeterExample example = new HistorymeterExample();
		HistorymeterExample.Criteria criteria  = example.createCriteria();
		criteria.andFinanceidEqualTo(meter.getFinanceid());
		criteria.andHouseidEqualTo(meter.getHouseid());
		criteria.andStateEqualTo(1);
		List<Historymeter> his = historymeterMapper.selectByExample(example);
		if (! his.isEmpty() && his.size() >0) {
			return his.get(0);
		}
		return null;
	}

	//查询可以抄表的楼栋
	public List<BuildingCustomer> meterbuilding(Long userid) {
		if (userid == null) {
			return null;
		}
		// TODO Auto-generated method stub
		return hydCoalCustomerMapper.meterbuilding(userid);
	}

	/**
	 *	获取电表水表头部
	 * @param userid : 用户id。房东的id
	 **/
	public List<Finance> unitname(Landbuilding landbuilding) {
		// TODO Auto-generated method stub
		List<Finance> list =  hydCoalCustomerMapper.unitname(landbuilding);
		for (Finance fin : list) {
			if (fin.getFinanceid() == 19) {fin.setCategoryname("水表");}
			if (fin.getFinanceid() == 20) {fin.setCategoryname("电表");}
			if (fin.getFinanceid() == 21) {fin.setCategoryname("煤气表");}
			if (fin.getFinanceid() == 22) {fin.setCategoryname("冷水表");}
			if (fin.getFinanceid() == 23) {fin.setCategoryname("热水表");}
		}
		return list;
	}

	
	/**
	 *	获取历史抄表的总记录 count
	 * @param userid : 用户id。房东的id
	 * @param financeid : 财务ID
	 * 。
	 **/
	public List<HistorymeterCustomer> meterdetail(HistorymeterVo historymeterVo) {
		return hydCoalCustomerMapper.meterdetail(historymeterVo);
	}
	public int meterdetailCount(HistorymeterVo historymeterVo) {
		return hydCoalCustomerMapper.meterdetailCount(historymeterVo);
	}

	/**
	 *	查询待生成账单的楼栋
	 * @param userid : 用户id。房东的id
	 **/
	public List<BuildingCustomer> unitbuilding(Long userid) {
		return hydCoalCustomerMapper.unitbuilding(userid);
	}
	
	

	/**
	 *	根据当前userid -- 楼栋id 财务ID查询可以生成账单 的列表
	 * @param userid : 用户id。房东的id
	 **/
	public List<HistorymeterCustomer> meterbuils(HistorymeterCustomer historymeterCustomer) {
		List<HistorymeterCustomer> meterbuils = new ArrayList<>();
		if (historymeterCustomer.getUserid() == null) {
			return meterbuils;
		}
		if (historymeterCustomer.getBuildingid() == null) {
			return meterbuils;
		}
		
		meterbuils = hydCoalCustomerMapper.meterbuils(historymeterCustomer);
		for (HistorymeterCustomer meter:meterbuils) {
			Double totalcount = meter.getAftercount() - meter.getBeforecount();
			//这里需要查询出单价 
			Hydcoal buildprices = getlandbuildingprices (meter);
			//非法数据需要移除
			if (totalcount <=0 ) {
				meter.setState(3);
				historymeterMapper.updateByPrimaryKeySelective(meter);
			}
			
			if (buildprices !=null && buildprices.getUnitprice() >0) {
				Double account = totalcount * (buildprices.getUnitprice() );
				meter.setSingleprice(account);
				meter.setUnitprice(buildprices.getUnitprice());
			}
			
			
			
		}
		return meterbuils;
	}

	private Hydcoal getlandbuildingprices(HistorymeterCustomer meter) {
		HydcoalExample example = new HydcoalExample();
		HydcoalExample.Criteria criteria = example.createCriteria();
		criteria.andHouseidEqualTo(meter.getHouseid());
		criteria.andFinanceidEqualTo(Long.valueOf(meter.getFinanceid()) );
		List<Hydcoal> list = hydcoalMapper.selectByExample(example);
		if (!list.isEmpty() && list.size() >0) 
		{
			return list.get(0);
		}
		
		return null;
	}

	//根据房子ID查询分期账单
	public List<Payexpert> payexpbyhouseid(Long houseid) {
		// TODO Auto-generated method stub
		return hydCoalCustomerMapper.payexpbyhouseid(houseid);
	}

	/**
	 *	根据主键查询当前想起
	 * @param houseid : 当前房子ID
	 **/
	public HistorymeterCustomer hismeterdetail(Long historymeterid) {
		HistorymeterCustomer historymeterCustomer =  hydCoalCustomerMapper.hismeterdetail(historymeterid);
		Double total = historymeterCustomer.getAftercount() - historymeterCustomer.getBeforecount();
		Double prices = total * historymeterCustomer.getUnitprice();
		historymeterCustomer.setSingleprice(prices);
		return historymeterCustomer;
	}

	/**
	 * 作废抄表
	 * **/
	public ResultMap deletemeter(Long historymeterid) {
		if (historymeterid == null) {
			return ResultMap.build(300, "主键不存在");
		}
		Historymeter historymeter = new Historymeter();
		historymeter.setHistorymeterid(historymeterid);
		historymeter.setState(3);
		historymeterMapper.updateByPrimaryKeySelective(historymeter);
		return ResultMap.IS_200();
	}

	/**
	 *	水电煤气生成账单
	 * @param historymeterid :抄表主键
	 * @param payexpertid :分期账单主键
	 * @param unitprice :单价
	 **/
	public ResultMap hydbuil(Long historymeterid, Long payexpertid, Double unitprice) {
		//抄表之前先校验数据完整性
		if (historymeterid == null) {return ResultMap.build(300,"数据不全");}
		if (payexpertid == null) {return ResultMap.build(300, "数据不全");}
		Historymeter historymeter = historymeterMapper.selectByPrimaryKey(historymeterid);
		if (historymeter == null) {return ResultMap.build(300, "数据不全");}
		Payexpert payexpert = payexpertMapper.selectByPrimaryKey(payexpertid);
		if (payexpert == null) {return ResultMap.build(300, "数据不全");}
		Double count = historymeter.getAftercount() - historymeter.getBeforecount(); //抄表头部
		Usercent usercent = getUsercent(historymeter.getHouseid());
		if (usercent == null) {return ResultMap.build(300,"数据不全");}
		
		// 先校验下当前类目下是否有账单
		Historymeter checkmeter = CheckmeterExist(historymeter);
		if (checkmeter !=null) {return ResultMap.build(300,"操作失败,勿重复抄表！"); }
		
		//生成账单之前绑定数据
		Housepay housepay = new Housepay();
		housepay.setPayexpertid(payexpertid);       //设置分期ID
		housepay.setCurrentstate(1);                //当前账单
		housepay.setFinanceid( Long.valueOf(historymeter.getFinanceid()) ); //设置类目ID
		housepay.setHouseid(historymeter.getHouseid()); //设置房间ID
		housepay.setPaystate(1);                    //当前未支付
		housepay.setUsercentid(usercent.getUsercentid()); //设置租约ID
		housepay.setDescription("单价：" + unitprice);
		housepay.setCentprices(unitprice * count); //设置当前价格
		housepay.setCreate_time(payexpert.getStart_time()); //租约开始时间就是交房租时间
		housepayMapper.insertSelective(housepay);
		
		//同步抄表为已经抄表状态。
		historymeter.setState(2);
		historymeterMapper.updateByPrimaryKeySelective(historymeter);
		
		//查询返回的buildingid
		House hosue = houseMapper.selectByPrimaryKey(historymeter.getHouseid()); 
		
		//建立抄水表 和账单表之间的关系
		HistorymeterHousepayKey key = new HistorymeterHousepayKey();
		key.setHistorymeterid(historymeterid);
		key.setHousepayid(housepay.getHousepayid());
		historymeterHousepayMapper.insertSelective(key);
		return ResultMap.build(200, "操作成功" ,hosue.getBuildingid() );
	}


	private Historymeter CheckmeterExist(Historymeter historymeter) {
		
		return hydCoalCustomerMapper.checkmeter(historymeter);
	}

	private Usercent getUsercent(Long houseid) {
		UsercentExample example = new UsercentExample();
		UsercentExample.Criteria criteria = example.createCriteria();
		criteria.andHouseidEqualTo(houseid);
		criteria.andCentstateEqualTo(1); //当前租约下
		List<Usercent> usercents = usercentMapper.selectByExample(example);
		if (usercents.size() == 1) {
			return usercents.get(0);
		}
		return null;
	}

	/**
	 *	根据抄表主键获取housepayid
	 * @param historymeterid :抄表主键
	 **/
	public ResultMap searchhousepayid(Long historymeterid) {
		HistorymeterHousepayExample example = new HistorymeterHousepayExample();
		HistorymeterHousepayExample.Criteria criteria = example.createCriteria();
		criteria.andHistorymeteridEqualTo(historymeterid);
		List<HistorymeterHousepayKey> KEY = historymeterHousepayMapper.selectByExample(example);
		if (KEY.size() == 1) {
			return ResultMap.IS_200(KEY.get(0).getHousepayid());
		}
		return ResultMap.build(300,"数据异常！");
	}


	/**
	 *	根据查询条件查询账本。
	 **/
	public List<ReckoningCustomer> reckoning(HydCoalVo hydCoalVo) {
		List<ReckoningCustomer> recks = hydCoalCustomerMapper.reckoning(hydCoalVo); 
		
		if (recks.isEmpty() || recks.size() == 0 ) {
			return recks;
		}
		
		//去除多余的楼层
		for (int i = 0; i < recks.size() ; i++) {// 从第一个数开始，到最后一个数-1次循环
			Double total = 0.0;
			//先加入押金的总计
			total = total +Double.valueOf(recks.get(i).getYajin());
			//重新加入查询条件
			hydCoalVo.setHouseid(recks.get(i).getHouseid());
			//设置其他费用的价格
			List<ReckoningCustomer> reckbuil = hydCoalCustomerMapper.reckbuil(hydCoalVo);
			for (ReckoningCustomer buil :reckbuil) {
				if (buil.getCentprices() !=null && !"".equals(buil.getCentprices())) {
					total = total +  Double.valueOf(buil.getCentprices()) ;
				}
				if (buil.getFinanceid() == 29) {//租金
					recks.get(i).setZujin(buil.getCentprices());
				}
				if (buil.getFinanceid() == 28) { //换房费
					recks.get(i).setHuanfangfei(buil.getCentprices());
				}
				if (buil.getFinanceid() == 27) { //垃圾费
					recks.get(i).setLajifei(buil.getCentprices());
				}
				if (buil.getFinanceid() == 26) { //管理费
					recks.get(i).setGuanlifei(buil.getCentprices());
				}
				if (buil.getFinanceid() == 25) { //卫生费
					recks.get(i).setWeishenfei(buil.getCentprices());
				}
				if (buil.getFinanceid() == 23) { //热水费
					recks.get(i).setReshuifei(buil.getCentprices());
				}
				if (buil.getFinanceid() == 22) { //冷水费
					recks.get(i).setLenshuifeifei(buil.getCentprices());
				}
				if (buil.getFinanceid() == 21) { //煤气费
					recks.get(i).setMeiqifei(buil.getCentprices());
				}
				if (buil.getFinanceid() == 20) { //电费
					recks.get(i).setDianfei(buil.getCentprices());
				}
				if (buil.getFinanceid() == 19) {//水费
					recks.get(i).setShuifei(buil.getCentprices());
				}
				if (buil.getFinanceid() == 31) { // 电梯费
					recks.get(i).setDiantifei(buil.getCentprices());
				}
				if (buil.getFinanceid() == 32) { //宽带
					recks.get(i).setKuandai(buil.getCentprices());
				}
				if (buil.getFinanceid() ==33) { //有线
					recks.get(i).setYouxian(buil.getCentprices());
				}
			}
			recks.get(i).setTotal(total);
			//这里是查询抄表月份的水初始值
			List<Historymeter> historymeters = hydCoalCustomerMapper.mothermeterdetails(hydCoalVo);
			for (Historymeter meter :historymeters) {
				if (meter.getFinanceid() == 19) { //水初始和末
					recks.get(i).setShuichu(meter.getBeforecount()+"");
					recks.get(i).setShuimo(meter.getAftercount()+"");
				}
				if (meter.getFinanceid() == 20) { //电初始和末
					recks.get(i).setDianchu(meter.getBeforecount()+"");
					recks.get(i).setDianmo(meter.getAftercount()+"");
				}
				if (meter.getFinanceid() == 21) { //煤气初始和末
					recks.get(i).setMeiqichu(meter.getBeforecount()+"");
					recks.get(i).setMeiqimo(meter.getAftercount()+"");
				}
				if (meter.getFinanceid() ==22) { //冷水初始和末
					recks.get(i).setLengshuichu(meter.getBeforecount()+"");
					recks.get(i).setLengshuimo(meter.getAftercount()+"");
				}
				if (meter.getFinanceid() == 23) { //热水初始和末
					recks.get(i).setReshuichu(meter.getBeforecount()+"");
					recks.get(i).setReshuimo(meter.getAftercount()+"");
					
				}
			}
			
			for (int j = recks.size() - 1; j > i; j--) {// 从最后一个数开始到i+1
				Long buil1 = recks.get(i).getBuildingid();
				Long buil2 = recks.get(j).getBuildingid();
				Long buil_end = buil1-buil2;
				Long folr1 = recks.get(i).getFloor();
				Long folr2 = recks.get(j).getFloor();
				Long folr_end = folr1 - folr2 ;
				if (buil_end==0 && folr_end==0 ) {
					recks.get(j).setFloor(-1L);
				}
				if (buil_end ==0) {
					recks.get(j).setTrading("");
				}
			}
			
			
		}
		return recks;
	}
	public int reckoningCount(HydCoalVo hydCoalVo) {
		return hydCoalCustomerMapper.reckoningCount(hydCoalVo);
	}

	//查询添加账单的类目
	public List<Finance> addfinancelist() {
		return hydCoalCustomerMapper.addfinancelist();
	}

	/**
	 * 添加其他账单
	 * **/
	public ResultMap addotherbuil(Housepay housepay) {
		if (housepay.getPayexpertid() == null) {return ResultMap.build(300, "数据异常");}
		if (housepay.getCentprices() == null) {return ResultMap.build(300, "数据异常");}
		if (housepay.getHouseid() == null) {return ResultMap.build(300, "数据异常"); }
		if (housepay.getFinanceid() == null) { return ResultMap.build(300,"数据异常");}
		Payexpert payexpert = payexpertMapper.selectByPrimaryKey(housepay.getPayexpertid());
		if (payexpert == null) {return ResultMap.build(300, "数剧异常");}
		Usercent usercent = getUsercent(housepay.getHouseid());
		if (usercent == null) {return ResultMap.build(300,"抄表异常");}
		//校验当前账单是否已经存在
		Housepay checkhousepay = checkpaybuilexist(housepay);
		if (checkhousepay !=null) {
			return ResultMap.build(300,"勿重复添加账单");
		}
		housepay.setCreate_time(payexpert.getStart_time());
		housepay.setCurrentstate(1);
		housepay.setPaystate(1);  
		housepay.setUsercentid(usercent.getUsercentid());
		housepayMapper.insertSelective(housepay);
		return ResultMap.build(200, "添加成功");
	}

	private Housepay checkpaybuilexist(Housepay housepay) {
		List<Housepay> list = hydCoalCustomerMapper.checkpaybuilexist(housepay);
		if (! list.isEmpty() && list.size() >0) {
			return list.get(0);
		}
		return null;
	}

	
	

}
