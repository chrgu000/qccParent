package cn.com.qcc.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.jms.Destination;
import javax.servlet.http.HttpServletRequest;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.DateUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.JsonUtils;
import cn.com.qcc.common.RedisUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.XwpfTUtil;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mapper.BargainMapper;
import cn.com.qcc.mapper.BrokerMapper;
import cn.com.qcc.mapper.DefaultpercentMapper;
import cn.com.qcc.mapper.FurnitureMapper;
import cn.com.qcc.mapper.HistorycentMapper;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mapper.HouseorderMapper;
import cn.com.qcc.mapper.HousepayMapper;
import cn.com.qcc.mapper.HousepaydetailMapper;
import cn.com.qcc.mapper.LandlordManagerMapper;
import cn.com.qcc.mapper.LandlordMapper;
import cn.com.qcc.mapper.LucreMapper;
import cn.com.qcc.mapper.MycentMapper;
import cn.com.qcc.mapper.PayexpertMapper;
import cn.com.qcc.mapper.PaymodalMapper;
import cn.com.qcc.mapper.ProfileMapper;
import cn.com.qcc.mapper.RentmodalMapper;
import cn.com.qcc.mapper.UsercentMapper;
import cn.com.qcc.mapper.VipcountMapper;
import cn.com.qcc.mess.util.SendMessUtil;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.mymapper.HouseRoomCustomerMapper;
import cn.com.qcc.mymapper.UserCustomerMapper;
import cn.com.qcc.mymapper.UserRoomCustomerMapper;
import cn.com.qcc.pojo.Bargain;
import cn.com.qcc.pojo.Broker;
import cn.com.qcc.pojo.Furniture;
import cn.com.qcc.pojo.Historycent;
import cn.com.qcc.pojo.Houseorder;
import cn.com.qcc.pojo.Housepay;
import cn.com.qcc.pojo.Housepaydetail;
import cn.com.qcc.pojo.Landlord;
import cn.com.qcc.pojo.LandlordManager;
import cn.com.qcc.pojo.LandlordManagerExample;
import cn.com.qcc.pojo.Lucre;
import cn.com.qcc.pojo.Mycent;
import cn.com.qcc.pojo.Payexpert;
import cn.com.qcc.pojo.Paymodal;
import cn.com.qcc.pojo.Rentmodal;
import cn.com.qcc.pojo.Usercent;
import cn.com.qcc.pojo.UsercentExample;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.queryvo.BuildingCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HousePayJsonModel;
import cn.com.qcc.queryvo.HouseRoomCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.HousepayCustomer;
import cn.com.qcc.queryvo.UserCentCustomer;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.HouseRoomService;

@Service
@Transactional
public class HouseRoomServiceImpl implements HouseRoomService {

	@Autowired
	HouseRoomCustomerMapper houseRoomCustomerMapper;
	@Autowired
	UsercentMapper usercentMapper;
	@Autowired
	UserCustomerMapper userCustomerMapper;
	@Autowired
	ProfileMapper profileMapper;
	@Autowired
	PaymodalMapper paymodalMapper;
	@Autowired
	RentmodalMapper rentmodalMapper;
	@Autowired
	HousepayMapper housepayMapper;
	@Autowired
	MycentMapper mycentMapper;
	@Autowired
	HouseMapper houseMapper;
	@Autowired
	PayexpertMapper payexpertMapper;
	@Autowired
	HistorycentMapper historycentMapper;
	@Autowired
	HouseCustomerMapper houseCustomerMapper;
	@Autowired
	FurnitureMapper furnitureMapper;
	@Resource
	Destination userCentCreate;
	@Autowired
	JmsTemplate jmsTemplate;
	@Autowired
	LandlordMapper landlordMapper;
	@Autowired
	LandlordManagerMapper landlordManagerMapper;
	@Autowired
	JedisClient jedisClient;
	@Autowired
	UserRoomCustomerMapper userRoomCustomerMapper;
	@Autowired
	HousepaydetailMapper housepaydetailMapper;
	@Autowired
	VipcountMapper vipcountMapper;
	@Resource  
	Destination userPayHouseAccount;
	@Autowired
	BargainMapper bargainMapper;
	@Autowired
	HouseorderMapper houseorderMapper;
	@Autowired BrokerMapper brokerMapper;
	@Autowired LucreMapper lucreMapper;
	@Resource  Destination roomOut;
	@Autowired DefaultpercentMapper defaultpercentMapper;
	/** 查询房态图 **/
	public List<HouseRoomCustomer> roompattern(HouseVo houseVo) {

		// 第一步,查询出基本的房源信息列表
		List<HouseRoomCustomer> houseList = houseRoomCustomerMapper.roompattern(houseVo);

		// 第二步,根据租约id查询housepay 支付情况表
		List<String> idList = new ArrayList<>();

		for (int i = 0; i < houseList.size(); i++) {// 从第一个数开始，到最后一个数-1次循环
			if (CheckDataUtil.checkNotEmpty(houseList.get(i).getUsercentid()))
				;
			idList.add(houseList.get(i).getUsercentid().toString());

			for (int j = houseList.size() - 1; j > i; j--) {// 从最后一个数开始到i+1
				Long buil1 = houseList.get(i).getBuildingid();
				Long buil2 = houseList.get(j).getBuildingid();
				Long buil_end = buil1 - buil2;
				Integer folr1 = houseList.get(i).getFloor();
				Integer folr2 = houseList.get(j).getFloor();
				Integer folr_end = folr1 - folr2;
				if (buil_end == 0 && folr_end == 0) {
					houseList.get(j).setFloor(-1);
				}
				if (buil_end == 0) {
					houseList.get(j).setTrading("");
				}
			}

		}

		List<HousepayCustomer> payList = new ArrayList<>();
		if (CheckDataUtil.checkNotEmpty(idList))
			payList = houseRoomCustomerMapper.getPayModel(idList);

		// 第三步,计算各种金额数据给前台
		for (HouseRoomCustomer house : houseList) {
			// 其他费用没有支付
			double otherpricesnotpay = 0;
			// 其他费用支付
			double otherpricespay = 0;
			// 取出没有支付的最小日期
			for (HousepayCustomer pay : payList) {
				// 当是 同一条租约时候开始计算数据
				if (house.getUsercentid().longValue() == pay.getUsercentid().longValue()) {
					// 如果是 29 租金
					if (pay.getFinanceid().longValue() == 29) {
						// 设置租金状态
						house.setCentstate(pay.getPaystate());
						// 设置租金金额
						house.setCentprices(pay.getCentprices());
					}
					// 如果是30 计算押金
					else if (pay.getFinanceid().longValue() == 30) {
						house.setManagerstate(pay.getPaystate());
						house.setMarginprices(pay.getCentprices());
					} else {
						// 计算其他费用分两类 支付的和 没有支付
						if (pay.getPaystate().longValue() == 1) {
							// 判断时间
							Long current = new Date().getTime();
							Long shouKuan = pay.getCreate_time().getTime();
							// 如果当前时间比 收款时间大 说明其他费用逾期
							if (current > shouKuan)
								otherpricesnotpay += pay.getCentprices();
						}

						// 其他费用已经支付本月 1 yue 12 - 2 - 12 2 9
						if (pay.getPaystate().longValue() == 2) {
							Long current = new Date().getTime();
							Long yishou = 0L;
							if (CheckDataUtil.checkNotEmpty(pay.getUpdate_time())) {
								yishou = pay.getUpdate_time().getTime();
							}

							// 计算距离收款日前后15
							if (current > yishou && current < (yishou + 1296000000 * 2))
								otherpricespay += pay.getCentprices();
						}

					}
				}
			}
			house.setOtherpricespay(otherpricespay);
			house.setOtherpricesnotpay(otherpricesnotpay);

			if (house.getNeedpaytime() != null) {
				int needoutday = DateUtil.daysBetween(new Date(), house.getNeedpaytime());
				house.setNeedoutday(needoutday);
			}
			if (house.getCententtime() != null) {
				int centenoutday = DateUtil.daysBetween(new Date(), house.getCententtime());
				house.setCentenoutday(centenoutday);
			}
			if ("1".equals(house.getHousestatus())) {
				if (house.getUpdate_time() != null) {
					int notcentday = DateUtil.daysBetween(house.getUpdate_time(), new Date());
					house.setNotcentday(notcentday);
				}
			}
		}
		return houseList;
	}

	@Override
	public int roompatternCount(HouseVo houseVo) {
		return houseRoomCustomerMapper.roompatternCount(houseVo);
	}

	private boolean checkUsercent(Usercent usercent) {
		UsercentExample example = new UsercentExample();
		UsercentExample.Criteria criteria = example.createCriteria();
		criteria.andHouseidEqualTo(usercent.getHouseid());
		List<Integer> values = new ArrayList<>();
		values.add(1);
		values.add(2);
		criteria.andCentstateIn(values);
		List<Usercent> list = usercentMapper.selectByExample(example);
		return list.size() == 0 || list.isEmpty();
	}

	private File CheckMyCentExist(Mycent my_search) {
		String url = my_search.getCenturl();
		url = url.substring(url.lastIndexOf("/"));
		String filepath = "/root/apache-tomcat-7.0.79/webapps/upload/bailcent" + url;
		File f = new File(filepath);
		if (!f.exists()) {
			// 文件不存在
			return null;
		}
		// 文件存在
		return f;
	}

	private String InSerentHistoryCent(Usercent usercent, String newPath) {
		Historycent historycent = new Historycent();
		historycent.setUpdate_time(new Date());
		historycent.setUsercentid(usercent.getUsercentid());
		historycent.setDescname("XXXX");
		historycent.setHistorycenturl(newPath);
		historycentMapper.insertSelective(historycent);
		return historycent.getHistorycenturl();
	}

	private String ConsumeCent(Usercent usercent, File file, Integer times) throws IOException {
		Map<String, Object> params = new HashMap<String, Object>();
		// 设置参数
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date start = usercent.getStart_time();
		Date end = usercent.getEnd_time();
		String datelong = IDUtils.datecompany(end, start);// 计算期数长Id

		// 租约相关设置
		params.put("租约起止日期", simpleDateFormat.format(start) + "到" + simpleDateFormat.format(end));
		params.put("租约开始日期", simpleDateFormat.format(start));
		params.put("租约期长", datelong);

		// <根据租户的ID获取租户的基本信息>
		UserCustomer centuser = userCustomerMapper.getcommonusermess(usercent.getUserid());
		String phonepicture = ""; // 租客证件照片
		params.put("承租人/乙方姓名", centuser.getRealname());// 租客真实姓名
		params.put("租客性别", centuser.getSex());
		params.put("租客证件号", centuser.getIdentity());
		params.put("租客手机号", centuser.getTelephone());
		params.put("租客证件类型", "身份证");
		params.put("租客姓名", centuser.getRealname());
		params.put("租客证件照片", phonepicture);
		// 根据房源ID 获取房东的基本信息
		HouseCustomer landuser = userCustomerMapper.getlandusermess(usercent.getHouseid());
		params.put("房东/甲方姓名", landuser.getRealname()); // 房东真实姓名
		params.put("房源地址", landuser.getDetailes() + "(" + landuser.getHouse_number() + ")");
		params.put("房源面积", landuser.getArea());
		params.put("租客（乙方）地址", landuser.getDetailes() + "(" + landuser.getHouse_number() + ")");// 租赁起始日期
		params.put("房东（甲方）地址", landuser.getLandaddress());

		UserCentCustomer userCentCustomer = new UserCentCustomer();
		userCentCustomer.setUsercentid(usercent.getUsercentid());
		List<UserCentCustomer> usercents = userCustomerMapper.paylistshowbecent(userCentCustomer);
		// 通过查询出来的参数封装合同
		Integer qicount = 0;
		Double totalyaprices = 0.0; // 总押金
		String yapricesmingxi = ""; // 押金
		Double centprices = 0.0;// 房屋租金
		String centcategoryname = "";// 租金包含类目
		Double firstpay = 0.0; // 首期一次费用
		String firstpaycategoryname = "";// 首期一次性明细
		Double monthdaypay = 0.0;
		String monthdaypaycatory = "";
		String jiaozutimes = "";
		for (int i = 0; i < usercents.size() - 1; i++) {// 从第一个数开始，到最后一个数-1次循环
			if (!jiaozutimes.contains(simpleDateFormat.format(usercents.get(i).getNeedpaytime()))) {
				jiaozutimes = jiaozutimes + "," + simpleDateFormat.format(usercents.get(i).getNeedpaytime());
				qicount++;
			}
			// 这里计算每个月周期费用
			if ("二期".equals(usercents.get(i).getPayexpertname())) {
				if (usercents.get(i).getFinanceid() != 29) {
					monthdaypay = monthdaypay + usercents.get(i).getCentprices();
					monthdaypaycatory = monthdaypaycatory + usercents.get(i).getCategoryname()
							+ usercents.get(i).getCentprices() + ",";
				}
			}
			// 房屋租金
			if (usercents.get(i).getFinanceid() == 29) {
				centprices = usercents.get(i).getCentprices();
			}
			// 这里计算押金明细
			if (usercents.get(i).getFid() == 6) {
				totalyaprices = totalyaprices + usercents.get(i).getCentprices();
				yapricesmingxi = yapricesmingxi + usercents.get(i).getCategoryname() + usercents.get(i).getCentprices()
						+ ",";
			}
			// 这里计算租金明细
			if (usercents.get(i).getFid() == 5) {
				// centprices = centprices + usercents.get(i).getCentprices();
				centcategoryname = centcategoryname + usercents.get(i).getCategoryname()
						+ usercents.get(i).getCentprices() + ",";
			}
			if ("首期".equals(usercents.get(i).getPayexpertname())) {
				firstpay = firstpay + usercents.get(i).getCentprices();
				firstpaycategoryname = firstpaycategoryname + usercents.get(i).getCategoryname()
						+ usercents.get(i).getCentprices() + ",";
			}

		}
		String danwei = "元";
		params.put("期数", qicount);// 租赁起始日期
		params.put("押金总额（含其他押金）", totalyaprices);// 租赁起始日期
		params.put("押金明细（含其他押金）", " (" + yapricesmingxi + ")");// 押金金额
		params.put("押金总额（含其他押金）大写", IDUtils.formatbigDecimal(totalyaprices) + danwei);// 租金金额
		params.put("每月房租金额", centprices);// 租金金额
		params.put("每月房租金额大写", IDUtils.formatbigDecimal(centprices) + danwei);

		params.put("首期一次性费用总额", firstpay);// 每月周期费用sex
		params.put("首期一次性费用总额大写", IDUtils.formatbigDecimal(firstpay) + danwei);// 每月周期费用sex
		params.put("首期一次性费用明细", " (" + firstpaycategoryname + ")");// 每月周期费用sex
		params.put("每月周期性费用总额", monthdaypay);// 每月周期费用sex
		params.put("每月周期性费用总额大写", IDUtils.formatbigDecimal(monthdaypay) + danwei);// 每月周期费用sex

		params.put("每月周期性费用明细", " (" + monthdaypaycatory + ")");// 每月周期费用sex
																// detailaddress

		// 租金包含费用
		String otherids = usercent.getOthermoreid();
		// 如果其他费用存在
		String[] strs = null;
		String centcont = ""; //// 租金包含的费用
		String housecont = "";
		if (!"".equals(otherids)) {
			strs = otherids.split("❤"); // 【0】-家具清单 【1】-租金包含费用
			if (strs != null) {
				if (strs.length > 1) {
					centcont = strs[1]; // 租金包含的费用
				}
				if (strs.length > 0) {
					housecont = strs[0]; // 【0】-家具清单
				}
			}
		}
		// 如果租金包含了其他费用
		String zujincont = "无";
		if (!"".equals(centcont)) {
			String[] centconts = centcont.split(","); // 租金包含费用IDS
			List<Furniture> funs = houseCustomerMapper.furnituresbyids(centconts);
			if (funs.isEmpty()) {
				zujincont = "无";
			} else {
				for (Furniture fun : funs) {
					zujincont = zujincont + fun.getCategoryname() + ",";
				}
			}
		}
		params.put("租金包含费用类目", zujincont);// 承租人
		params.put("合同补充条款", usercent.getOthermore());
		HouseCustomer rentmodal = houseCustomerMapper.rentpaymodal(usercent.getRentmodalid());
		String[] paystys = usercent.getPaystyleid().split(",");
		Paymodal pay1 = paymodalMapper.selectByPrimaryKey(Long.valueOf(paystys[0]));
		Paymodal pay2 = paymodalMapper.selectByPrimaryKey(Long.valueOf(paystys[1]));
		params.put("租金付款方式", pay1.getTypename() + pay2.getTypename());// 租赁起始日期
		params.put("交租日规则", rentmodal.getFname() + rentmodal.getRentname() + "号");// 每月周期费用sex
		params.put("每期交租日明细", jiaozutimes);

		String[] qingdanlist = null;
		// 家具清单存在的情况下
		if (!"".equals(housecont) && housecont != null) {
			qingdanlist = housecont.split(","); /// 家具清单 1-4，4-4 前面ID后面是数量
		}
		String commonlist = "";
		String houselist = "";
		if (qingdanlist != null) {
			for (int i = 0; i < qingdanlist.length; i++) {
				String[] sss = qingdanlist[i].split("-"); // ID
				String num = "1";
				if (sss.length >= 2) {
					num = sss[1]; // ID
				}
				String id = sss[0];
				Furniture furniture = furnitureMapper.selectByPrimaryKey(Long.valueOf(id));
				if (furniture.getFatherid() == 2) { // 房间家具清单
					houselist = houselist + furniture.getCategoryname() + "-" + num + ",";
				}
				if (furniture.getFatherid() == 1) {// 公共家具清单
					commonlist = commonlist + furniture.getCategoryname() + "-" + num + ",";
				}
			}
		}
		params.put("房间家具清单", houselist);
		params.put("公共家具清单", commonlist);
		InputStream is = new FileInputStream(file);
		XWPFDocument doc = new XWPFDocument(is);
		XwpfTUtil xpt = new XwpfTUtil();
		xpt.replaceInPara(doc, params);
		xpt.replaceInTable(doc, params);
		// 重新命名
		String newName = usercent.getUserid() + "_" + IDUtils.genItemId();
		String filepath = "/root/apache-tomcat-7.0.79/webapps/upload/bailcent/" + newName + ".docx";

		OutputStream os = new FileOutputStream(filepath);
		doc.write(os);
		/*
		 * try { String outpath =
		 * "/root/apache-tomcat-7.0.79/webapps/upload/bailcent/" + newName +
		 * ".html"; Word2Html.docxToHtml(filepath, outpath); // 转换完成后删除模板 ...
		 * File delete = new File(filepath); if (delete.exists()) {
		 * delete.delete(); } } catch (Exception e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */

		return newName + ".docx";

	}

	private String getDateString(Long start) {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		long lt = new Long(start);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}

	// 这里只生成房屋押金。
	private List<Payexpert> CreatePayExpert(Usercent usercent, String paycentid, String pricestype, Integer num) {
		
		Long houseid = usercent.getHouseid();
		
		// 查询houseorder
		Houseorder houseorder  = getHouseOrderIsPay(houseid , usercent.getUserid());
		
		Long rentmodalid = usercent.getRentmodalid();
		String[] str = null;
		if (pricestype != null && !"".equals(pricestype)) {
			str = pricestype.split(",");
		}
		Paymodal paymodal = paymodalMapper.selectByPrimaryKey(Long.valueOf(paycentid));
		Integer multi = 1; // 这是设置交租的周期几个月一交。
		Double centprices = usercent.getCentprices();// 租金
		if (paymodal != null) {
			// 这里是付的 付几查询对应的月数
			if (paymodal.getState() == 1) {
				multi = paymodal.getMultiple();
				// 如果是付几的话需要重新算租金
				centprices = centprices * multi;
			}
		}

		Rentmodal rentmodal = rentmodalMapper.selectByPrimaryKey(rentmodalid);
		Integer befroday = -1; // 每个月提前的天数
		Integer gudi = -1; // 每个月固定的天数
		if (rentmodal != null) {
			// 每期提前多少天
			if (rentmodal.getFatherid() == 1) {
				befroday = Integer.parseInt(rentmodal.getRentname());
			}
			// 每期提前一个月
			if (rentmodal.getFatherid() == 3) {
				befroday = Integer.parseInt(rentmodal.getRentname()) + 30;
			}
			if (rentmodal.getFatherid() == 2) {
				gudi = Integer.parseInt(rentmodal.getRentname());
			}
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Long start = usercent.getStart_time().getTime(); // 开始的时间戳
		Long end = usercent.getEnd_time().getTime();// 结束的时间戳
		Date start_time = usercent.getStart_time(); // 开始的日期
		for (int i = 0; i < 1000; i++) {
			if (start < end) {
				String pertname = "";
				Payexpert payexpert = new Payexpert();
				payexpert.setState(1); // 没有推送账单
				Housepay housepay = new Housepay();
				Calendar calendar = Calendar.getInstance();
				payexpert.setStart_time(start_time); // 分期的开始日期 [也即使账单的开始日期]
				calendar.setTime(start_time);
				if (i == 0) {
					pertname = "首期";
					// 如果是首期的话.需要推送账单
					payexpert.setState(2);
					// 首期可以忽视收租日期
					housepay.setCreate_time(start_time);
					// 首期需要su
				} else {
					pertname = IDUtils.foematInteger(i + 1) + "期";
					if (befroday >= 0) {
						Long current = start - (long) (1000 * 60 * 60 * 24 * befroday);
						String tts = getDateString(current);
						try {
							housepay.setCreate_time(format.parse(tts));
						} catch (java.text.ParseException e) {
							e.printStackTrace();
						}
					}

					if (gudi >= 0) {
						Calendar other = Calendar.getInstance();
						other.setTime(start_time);
						other.set(Calendar.DAY_OF_MONTH, gudi);
						Long teg = other.getTimeInMillis();
						String ret = getDateString(teg);
						try {
							housepay.setCreate_time(format.parse(ret));
						} catch (java.text.ParseException e) {
							e.printStackTrace();
						}
					}

				}
				calendar.add(Calendar.MONTH, multi);// 根据付几设置几个月一交
				start = calendar.getTimeInMillis() + 1;
				// 这里需要重置开始的时间
				String ss = getDateString(start);
				try {
					start_time = format.parse(ss); // 这里是结束的时间也是下一次循环开始的时间
				} catch (java.text.ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// 这里要生产分期
				payexpert.setPayexpertname(pertname);
				payexpert.setEnd_time(start_time);
				payexpert.setUsercentid(usercent.getUsercentid());
				payexpertMapper.insertSelective(payexpert);
				// 在生产分期账单
				housepay.setPayexpertid(payexpert.getPayexpertid());
				housepay.setHouseid(houseid);
				// 这里设置需要交房租时间
				housepay.setPaystate(1);// 未支付状态
				housepay.setCurrentstate(1);// 当前租期
				// housepay.setUsercentid(usercent.getUsercentid()); //
				// 租客登记的唯一约束
				if (i == 0) {
					// 这里是算其他的价格
					if (str != null) {
						for (int u = 0; u < str.length; u++) {
							String[] str2 = str[u].split("-");
							if ("4".equals(str2[1]) || "2".equals(str2[1])) { // 这里说明是首期费用有几条需要插入几天数据库
								housepay.setCentprices(Double.valueOf(str2[2]));
								housepay.setFinanceid(Long.valueOf(str2[0]));
								housepayMapper.insertSelective(housepay);
								housepay.setHousepayid(null);
							}
						}
					}
					
					/** 这里计算优惠金额 
					 * 35  砍价优惠
					 * 36  房源订金
					 * 37 租客付佣金
					 * ***/
					if (CheckDataUtil.checkNotEmpty(houseorder)) {
						// 房源订金
						housepay.setCentprices(0-houseorder.getPrices());
						housepay.setFinanceid(36L);
						housepayMapper.insertSelective(housepay);
						housepay.setHousepayid(null);
						
						// 租客付佣金
						if (houseorder.getCentpercentnum() >  0 ) {
							housepay.setCentprices(houseorder.getCentpercentnum() * centprices );
							housepay.setFinanceid(37L);
							housepayMapper.insertSelective(housepay);
							housepay.setHousepayid(null);
						}
						
						// 查询砍价的金额
						if (CheckDataUtil.checkNotEmpty(houseorder.getBarginid())) {
							Bargain bargin =  bargainMapper.selectByPrimaryKey(houseorder.getBarginid());
							double kanjia  = bargin.getTotalbanalce() - bargin.getLessbalance();
							if (kanjia > 0)  {
								housepay.setCentprices( 0-kanjia);
								housepay.setFinanceid(35L);
								housepayMapper.insertSelective(housepay);
								housepay.setHousepayid(null);
							}
							
						}
						
					}
					
					
					
					// 只有第一次签约加入房屋押金
					if (num == 1) {
						// 首期需要额外加入 房屋押金 id [30] [只在首期加入]
						housepay.setCentprices(usercent.getYaprices());
						housepay.setFinanceid(30L);
						housepayMapper.insertSelective(housepay);
						housepay.setHousepayid(null);
					}
				}
				if (str != null) {
					// 这里是算其他的价格
					for (int u = 0; u < str.length; u++) {
						String[] str2 = str[u].split("-");
						if ("3".equals(str2[1])) { // 这里表示周期费用随着周期加而加
							housepay.setCentprices(Double.valueOf(str2[2]));
							housepay.setFinanceid(Long.valueOf(str2[0]));
							housepayMapper.insertSelective(housepay);
							housepay.setHousepayid(null);
						}
					}
				}
				// 这里算租金 [租金每个月都要算]
				housepay.setCentprices(centprices); // 租金每个月都要算
				housepay.setFinanceid(29L);// 29表示房租租金
				housepayMapper.insertSelective(housepay);
			}
		}
		return null;
	}

	private Houseorder getHouseOrderIsPay(Long houseid , Long userid) {
		if (CheckDataUtil.checkisEmpty(houseid)
				|| CheckDataUtil.checkisEmpty(userid)) {
			return null; 
		}
		return houseRoomCustomerMapper.getHouseOrderIsPay(houseid , userid);
	}

	/**
	 * 租客登记时候必须要填写的资料.
	 * 
	 * @param houseid
	 *            : 登记的房子ID
	 * @param landuserid
	 *            :设置用户的ID，方便管家推送账号和管理
	 * @param Yaprices
	 *            : 当前房间的押金
	 * @param centfromid
	 *            : 租客来源的ID
	 * @param mycentid
	 *            : 合同模板ID
	 * @param start_time
	 *            : 租约开始时间
	 * @param end_time
	 *            : 租约结束时间
	 * @param pricestype
	 *            :其他一次性费用
	 * @param othermore
	 *            : 其他补充合同
	 * @param islinecent
	 *            : yes 表示线上合同
	 **/
	public ResultMap createusercent(Usercent usercent, Mycent mycent, HttpServletRequest request, String othermore,
			String payid, String paycentid, String pricestype, String othermoreid1, String othermoreid2,
			String islinecent) {

		
		// 租客来源
		if (usercent.getCentfromid() == null) {
			usercent.setCentfromid(1L);
		}
		if (payid == null) {
			payid = "";
		}
		if (paycentid == null) {
			paycentid = "";
		}
		if (usercent.getOthermore() == null) {
			usercent.setOthermore("");
		}

		if (usercent.getUsercentnum() == "" || usercent.getUsercentnum() == null) {
			usercent.setUsercentnum(IDUtils.getCentNum());
		}
		// 查询租约登记的最大次数
		Integer num = userCustomerMapper.getCentTimes(usercent.getUsercentnum());
		// 如果是第一次签约。 
		if (num == 1 ) {
			if (usercent.getYaprices() == null) 
				return ResultMap.build(201, "输入押金");
			// 先判断该房源是否可以租客 0-返回true 表示 没有签约的房子
			boolean falg = checkUsercent(usercent);
			if (falg == false)
				return ResultMap.build(400, "该房源已经登录或者该租客有待处理租约");
		}
		// 设置管理
		if (CheckDataUtil.checkisEmpty(usercent.getManageruserid())) {
			return ResultMap.build(400, "请设置管家");
		}

		// 获取房东的userid
		Long landUserid = getLandUserId(usercent.getManageruserid());
		if (CheckDataUtil.checkisEmpty(landUserid)) {
			return ResultMap.build(400, "找不到房东不可发布租约");
		}

		// 设置房东的id
		usercent.setLanduserid(landUserid);

		if (usercent.getUserid() == null) {
			return ResultMap.build(204, "请选择一个用户");
		}
		// 建立关系的房源ID，不可以少。
		if (usercent.getHouseid() == null) {
			return ResultMap.build(203, "选择一个房源");
		}
		// 租约的开始日期不能少
		if (usercent.getStart_time() == null) {
			return ResultMap.build(400, "租约开始日期不能为空！");
		}
		// 租约的结束日期不能少
		if (usercent.getEnd_time() == null) {
			return ResultMap.build(400, "租约结束日期不能为空！");
		}
		if ("yes".equals(islinecent) && mycent.getMycentid() == null) {
			return ResultMap.build(300, "选择合同样板");
		}
		if (usercent.getCentprices() == null) {
			return ResultMap.build(400, "租金不能为空");
		}
		if ("".equals(othermoreid1) || othermoreid1 == null) {
			othermoreid1 = "";
		}
		if ("".equals(othermoreid2) || othermoreid2 == null) {
			othermoreid2 = "";
		}

		// 获取用户实名信息
		UserCustomer profile = userCustomerMapper.searchUserSign(usercent.getUserid());
		if (profile == null || profile.getSignstate() != 2) {
			return ResultMap.build(400, "未实名");
		}

		usercent.setCenttimes(num);
		usercent.setPaystyleid(payid + "," + paycentid);
		usercent.setOthermoreid(othermoreid1 + "❤" + othermoreid2);
		usercent.setCentstate(1); // 未签约 -- [用户支付后同意租约更改成签约用户 ]
		usercent.setUserstete(1); // 签约用户
		// 登记租客形成数据
		usercentMapper.insertSelective(usercent);

		// 建立分期账单 [分期账单需要根据租约日期，和收租的日期。来计算]
		CreatePayExpert(usercent, paycentid, pricestype, num);
		Map<String, Object> map = new HashMap<>();
		// 如果是电子合同
		if ("yes".equals(islinecent)) {

			// 生成电子合同租约
			Mycent my_search = mycentMapper.selectByPrimaryKey(mycent.getMycentid());
			if (my_search == null) {
				return ResultMap.build(400, "模板不存在");
			}
			File file = CheckMyCentExist(my_search);
			if (file == null) {
				return ResultMap.build(400, "模板销毁");
			}
			String newName = "";
			// 2, 如果模板存在需要生产租赁合同
			try {
				newName = ConsumeCent(usercent, file, num);
			} catch (IOException e) {
				e.printStackTrace();
			}
			// 构建新的文件路径
			String newPath = "https://www.zzw777.com/upload/bailcent/" + newName;
			// 向历史合同表插入数据。
			String url = InSerentHistoryCent(usercent, newPath);
			map.put("centurl", url);
		}
		map.put("usercentid", usercent.getUsercentid());
		// 发送模板消息 如果建立了租约 需要 发短信 。下架房源之内的在消息里面完成
		String sendData = usercent.getUsercentid().toString();
		SendMessUtil.sendData(jmsTemplate, userCentCreate, sendData);
		return ResultMap.IS_200(map);
	}

	/** 通过管家的userid查询房东的userid **/
	private Long getLandUserId(Long manageruserid) {
		// 1- 判断是不是房东用户
		Landlord landlord = landlordMapper.selectByPrimaryKey(manageruserid);
		// 如果是房东直接返回
		if (CheckDataUtil.checkNotEmpty(landlord) && landlord.getLandstate().intValue() == 2) {
			return landlord.getLanduserid();
		}

		// 通过管家查询房东
		LandlordManager manager = landlordManagerMapper.selectByPrimaryKey(manageruserid);
		// 如果是房东直接返回
		if (CheckDataUtil.checkNotEmpty(manager) && manager.getState().intValue() == 2) {
			return manager.getLanduserid();
		}
		return null;
	}

	/**
	 * 退房不结账
	 * 
	 * @param houseid
	 *            : houseid
	 **/
	public ResultMap roomout(Long houseid , Long userid) {
		if (houseid == null) {
			return ResultMap.build(300, "选择房子");
		}
		
		// 校验数据
		UsercentExample example = new UsercentExample();
		UsercentExample.Criteria criteria = example.createCriteria();
		criteria.andHouseidEqualTo(houseid);
		List<Integer> values = new ArrayList<>();
		values.add(1);
		values.add(2);
		criteria.andCentstateIn(values);
		List<Usercent> centList = usercentMapper.selectByExample(example);
		if (CheckDataUtil.checkisEmpty(centList)) {
			return ResultMap.build(400, "当前房源无须退房,没有相关租约!!");
		}
		Usercent cent = centList.get(0);
		
		if (CheckDataUtil.checkNotEqual(cent.getManageruserid(), userid)
				&& CheckDataUtil.checkNotEqual(cent.getLanduserid(), userid)) {
			return ResultMap.build(400, "只有房东和管理员才可以退房");
		}
		
		// 第一步当前租约改为历史租约
		houseCustomerMapper.usercentbehistory(houseid);
		// 第二步设置 房子账单为历史账单
		houseCustomerMapper.housepaybehistory(houseid);
		// 第三步发送退房的模板消息
		String sendData = houseid + "-" + cent.getUsercentnum() ; 
		SendMessUtil.sendData(jmsTemplate, roomOut, sendData);
		return ResultMap.build(200, "操作成功");
	}

	/**
	 * 根据房源ID 和userid 发起退房操作
	 * 
	 * @param houseid
	 *            : 当前房源ID
	 **/
	public HouseCustomer roomoutsearch(Long houseid) {

		// 第一步，查询当前租约已经交过的所有押金
		Double sumcentprices = houseCustomerMapper.centpricespay(houseid);

		// 第二步 ，查询本月或者之前 是否有没有交 的费用总和
		HouseCustomer search = new HouseCustomer();
		search.setHouseid(houseid);
		search.setCurrentday(new Date());
		Double notpayprices = houseCustomerMapper.centpricesnotpay(search);
		if (notpayprices == null) {
			notpayprices = 0.0D;
		}
		// 这里查询大于本期的已经支付的金额
		Double duoshou = houseCustomerMapper.centpricespayout(search);

		// 第三步，计算最近一次房租的情况
		HouseCustomer houseCustomer = houseCustomerMapper.centpricesnow(search);
		if (houseCustomer == null) {
			houseCustomer = new HouseCustomer();
		}
		houseCustomer.setMarginprices(sumcentprices + "");
		houseCustomer.setOtherpricesnotpay(notpayprices + ""); // 其他费用没有交的
		houseCustomer.setDuoshou(duoshou);
		// 计算超出天数
		Double payprices = 0.0D;

		if (houseCustomer.getCreate_time() != null) {
			int totalday = DateUtil.daysBetween(houseCustomer.getCreate_time(), houseCustomer.getUpdate_time());
			int intday = DateUtil.daysBetween(houseCustomer.getCreate_time(), new Date());
			if (houseCustomer.getPayexstate() != null && houseCustomer.getPayexstate() == 1) {
				payprices = sumcentprices - notpayprices
						- Double.valueOf(houseCustomer.getCentprices()) * intday / totalday;
				;
			}
			if (houseCustomer.getPayexstate() != null && houseCustomer.getPayexstate() == 2) {
				payprices = sumcentprices - notpayprices;
			}
		}
		houseCustomer.setTotalprices(payprices + duoshou);
		return houseCustomer;
	}

	/**
	 * 根据房东ID 查询出对应的区域分组
	 **/
	public List<BuildingCustomer> getlandareaname(BuildingCustomer buildingCustomer) {
		// 如果是房东查询所有 
		String inUserIds = getInUserIds(buildingCustomer.getUserid());
		
		// 根据userid 查询相应的街道code集合
		String [] codes = houseRoomCustomerMapper.searchTradingList(inUserIds);
		
		if (CheckDataUtil.checkisEmpty(codes)) {
			return new ArrayList<>();
		}
		
		// 在根据codes集合查询区域
		List<BuildingCustomer> landareaname = houseRoomCustomerMapper.getlandareaname(codes);
		return landareaname;
	}

	/**
	 * 根据房东ID查询房东房源对应的楼栋
	 */
	public List<BuildingCustomer> getlandbuildingname(BuildingCustomer buildingCustomer) {
		
		// 如果是房东查询所有 
		String inUserIds = getInUserIds(buildingCustomer.getUserid());
		
		// 根据用户id查询楼栋id集合
		String [] buildingids = houseRoomCustomerMapper.searchBuildingids(inUserIds);
		
		if (CheckDataUtil.checkisEmpty(buildingids)) {
			return new ArrayList<>();
		}
		
		List<BuildingCustomer> buils = houseRoomCustomerMapper.getlandbuildingname(buildingCustomer.getCode()
				,buildingids);
		String strbuil = "";
		for (BuildingCustomer buil : buils) {
			strbuil = buil.getDetailes();
			strbuil = strbuil.substring(strbuil.indexOf("市") + 1, strbuil.length());
			buil.setDetailes(strbuil);
		}
		return buils;
	}

	/// 根据订单id的集合查询需要支付的金额
	public HouseRoomCustomer getpayMonery(String housepayIds) {
		if (CheckDataUtil.checkisEmpty(housepayIds)) {
			return new HouseRoomCustomer();
		}
		String[] split = housepayIds.split(",");
		return houseRoomCustomerMapper.getpayMonery(split);
	}

	// 支付成功后需要做的事情
	public String housepaySuccess(String out_trade_no, String total_amount) {
		String jsonData = jedisClient.get(RedisUtil.HOUSEPAY_FIRST_KEY + out_trade_no);
		if (CheckDataUtil.checkisEmpty(jsonData)) {
			return "fail";
		}
		HouseRoomCustomer house = JsonUtils.jsonToPojo(jsonData, HouseRoomCustomer.class);
		
		// 1 - 需要把租约修改为已经签约状态
		UsercentExample example = new UsercentExample();
		UsercentExample.Criteria criteria = example.createCriteria();
		criteria.andUsercentnumEqualTo(house.getUsercentnum());
		criteria.andCentstateEqualTo(1);
		List<Usercent> list =  usercentMapper.selectByExample(example);
		
		// 房东需要减去的佣金
		double deleteMonery =0;
		// 需要加的订金
		double orderPrcies = 0 ;
		// 是否是第一次签约 
		if (CheckDataUtil.checkNotEmpty(list)) {
			// 如果是第一次签约
			Usercent updateCent = list.get(0);
			updateCent.setCentstate(2);
			usercentMapper.updateByPrimaryKeySelective(updateCent);
			// 查询houseorder
			Houseorder houseorder  = getHouseOrderIsPay(house.getHouseid() , house.getUserid());
			if (CheckDataUtil.checkNotEmpty(houseorder)) {
				double landNum = 0 ; // 房东付佣金
				double centNum = 0 ; // 租客付佣金
				// 查询租金
				double centPrices =  houseRoomCustomerMapper.searchCentPay(house.getPayIds());
				// 如果房东付佣金 不存在时候 
				if(CheckDataUtil.checkisEmpty(houseorder.getLandpercentnum()  )
						|| houseorder.getLandpercentnum() == 0) {
					landNum = defaultpercentMapper.centNumIsZeroNetGet() ;
				}else {
					landNum = houseorder.getLandpercentnum();
				}
				// 判断租客付佣金
				if (CheckDataUtil.checkNotEmpty(houseorder.getCentpercentnum())) {
					centNum = houseorder.getCentpercentnum();
				}
				
				// 房东最终减去的佣金钱 是   租客付佣金 + 房东付佣金
				deleteMonery = centPrices *  landNum  + centPrices * centNum; 
				// 计算分享者的佣金
				Long brokeruserid = houseorder.getBrokeruserid();
				if (CheckDataUtil.checkNotEmpty(brokeruserid)) {
					double brokerMonery = getBrokerMoner(brokeruserid , deleteMonery );
					String descname = house.getBuilding() + " [" + house.getHouse_number() +" ]";
					Lucre record = lucreMapper.selectByPrimaryKey(houseorder.getHouseorderid());
					if (CheckDataUtil.checkNotEmpty(record)) {
						record.setAccount(brokerMonery);
						record.setDescname(descname);
						record.setState(1); //正常
						record.setUpdate_time(new Date());
						lucreMapper.updateByPrimaryKeySelective(record);
					}
					
					/***
					if (brokerMonery > 0) {
						Lucre record = new Lucre();
						record.setAccount(brokerMonery); // 佣金金额
						record.setLucreid( houseorder.getHouseorderid() );
						record.setDescname(descname);  // 描述
						record.setState(1); //  1-正常,2-非正常,3-已添加到佣金
						record.setType(1); // 0-收益 1-佣金
						record.setUpdate_time(new Date());
						record.setUserid(brokeruserid);
						lucreMapper.updateByPrimaryKeySelective(record);
					}
					**/ 
				}
				orderPrcies = houseorder.getPrices();
				// 修改预订单位已经入住状态
				houseorder.setPaystate(5);
				houseorderMapper.updateByPrimaryKey(houseorder);
				
				
			}
			
		}
		
		
		
		// 2 - 插入交租记录表
		// 获取到订单的列表
		String payIds = house.getPayIds();
		String[] housePayIds = payIds.split(",");
		// 第三步 根据 分期id查询所有账单
		List<HousePayJsonModel> payList = userRoomCustomerMapper.getHousePayByHousePayIds(housePayIds);
		// 查询房源的基本信息
		HouseCustomer details = houseCustomerMapper.findHouseDetails(house.getHouseid());
		String housedetails = details.getVillagename() + "-" +
				details.getBuilding() + "-" +
				details.getHouse_number() +"(号房)";
		// 查询支付用户的基本信息
		UserCustomer centUser = userCustomerMapper.getCommonUserDetailMess(house.getUserid());
		//查询管理员的基本信息
		UserCustomer managerUser = userCustomerMapper.getCommonUserDetailMess(house.getManageruserid());
		String objectToJson = JsonUtils.objectToJson(payList);
		Housepaydetail insertData = new Housepaydetail();
		insertData.setDetailcontent(objectToJson);
		insertData.setManagerphone(managerUser.getTelephone().toString());
		insertData.setManagerusername(managerUser.getRealname());
		insertData.setPayusername(centUser.getRealname());
		insertData.setPayuserphone(centUser.getTelephone().toString());
		insertData.setHouseid(house.getHouseid());
		insertData.setHousedetails(housedetails);
		insertData.setOrdernum(out_trade_no);
		insertData.setPaytime(new Date());
		insertData.setTotalprices(house.getCentprices());
		insertData.setUsercentnum(house.getUsercentnum());
		insertData.setUserid(house.getUserid());
		insertData.setLanduserid(house.getLanduserid());
		insertData.setManageruserid(house.getManageruserid());
		housepaydetailMapper.insertSelective(insertData);

		
		
		
		
		// 3- 给房东钱包加入金额
		Vipcount vipaccount = vipcountMapper.selectByPrimaryKey(house.getLanduserid());
		// 房东最终入账 为 租客交的金额 +订金 - 经纪人和平台分摊的钱
		vipaccount.setHouseaccount( vipaccount.getHouseaccount() +
				house.getCentprices() -deleteMonery + orderPrcies  );
		vipcountMapper.updateByPrimaryKeySelective(vipaccount);
		
		// 4 - 修改订单为已支付
		houseRoomCustomerMapper.updateHousePayIsPay(housePayIds);
		
		// 发送短信消息
		String sendData = house.getHouseid() + "-" + house.getUserid() + "-" + house.getLanduserid()
		+ "-" + house.getManageruserid() + "-" + out_trade_no + "-" + house.getCentprices() ;
		SendMessUtil.sendData(jmsTemplate, userPayHouseAccount, sendData);
				

		return "success";
	}
	
	/**
	 * brokeruserid : 经纪人
	 * yongjin      : 总计的佣金
	 * **/
	private double getBrokerMoner(Long brokeruserid, double yongjin ) {
		// 这个是比例
		Broker broker = brokerMapper.selectByPrimaryKey(brokeruserid);
		if (CheckDataUtil.checkNotEmpty(broker)) {
			// 专职
			if (broker.getType() == 0) {
			 	return yongjin * defaultpercentMapper.zhuanzhiNum();
			}
			// 兼职
			if (broker.getType() == 1) {
				return yongjin * defaultpercentMapper.jianzhiNum();
			}
		}
		
		// 如果不是经纪人的情况下 按照 兼职的算
		return  yongjin * defaultpercentMapper.jianzhiNum();
	}

	@Override
	public String getInUserIds(Long userid) {
		// 判断当前用户是不是房东
		Landlord landlord = landlordMapper.selectByPrimaryKey(userid);
		String inUserIds = "";
		if (CheckDataUtil.checkNotEmpty(landlord) && landlord.getLandstate().intValue() == 2) {
			LandlordManagerExample example = new LandlordManagerExample();
			LandlordManagerExample.Criteria criteria = example.createCriteria();
			criteria.andLanduseridEqualTo(userid);
			List<LandlordManager> selectByExample = landlordManagerMapper.selectByExample(example);
			if (CheckDataUtil.checkNotEmpty(selectByExample)) {
				for (LandlordManager manager : selectByExample) {
					inUserIds += manager.getManageruserid() + ",";
				}
				inUserIds = inUserIds + userid;
			} else {
				inUserIds = userid.toString();
			}
			return inUserIds;
		} 
		LandlordManager manager = landlordManagerMapper.selectByPrimaryKey(userid);
		if (CheckDataUtil.checkNotEmpty(manager) && manager.getState().intValue() == 2) {
			inUserIds = userid.toString();
		}
		return inUserIds;
	}

	@Override
	public ResultMap deletehousebile(Long userid, String housepayIds) {
		
		if (CheckDataUtil.checkisEmpty(userid)
				|| CheckDataUtil.checkisEmpty(housepayIds)) {
			return ResultMap.build(400, "缺少参数");
		}
		
		try {
			
			String[] split = housepayIds.split(",");
			// 通过housepayids查询租约的信息
			Usercent usercent = houseRoomCustomerMapper.searchUserCentByHousePayIds(split);
			// 如果查不到说明有问题
			if (CheckDataUtil.checkisEmpty(usercent)) {
				return ResultMap.build(400,"检查账单,未知的租约。或者多份租约");
			}
			//如果不是房东也不是管理员则不可以移除
			if (CheckDataUtil.checkNotEqual(usercent.getManageruserid(), userid)
					&& CheckDataUtil.checkNotEqual(usercent.getLanduserid(), userid)) {
				return ResultMap.build(400, "只有房东和管理员才可废弃账单");
			}
			
			// 判断是否有已经支付过的账单
			int count = houseRoomCustomerMapper.counthousepayIsPay(split);
			
			if (count > 0) {
				return ResultMap.build(400, "请选择未支付的订单");
			}
			
			// 这里做更新操作
			houseRoomCustomerMapper.updateHousePayIsDelete(split);
			
			return ResultMap.build(200, "操作成功");
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResultMap.build(400,"请选择,一份租约的账单");
		}
		
	}
	
			

}
