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

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WangYiUtil.WangYiCommon;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.DateUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.SendMessage;
import cn.com.qcc.common.XwpfTUtil;
import cn.com.qcc.mapper.FurnitureMapper;
import cn.com.qcc.mapper.HistorycentMapper;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mapper.HousepayMapper;
import cn.com.qcc.mapper.MycentMapper;
import cn.com.qcc.mapper.PayexpertMapper;
import cn.com.qcc.mapper.PaymodalMapper;
import cn.com.qcc.mapper.ProfileMapper;
import cn.com.qcc.mapper.RentmodalMapper;
import cn.com.qcc.mapper.UsercentMapper;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.mymapper.HouseRoomCustomerMapper;
import cn.com.qcc.mymapper.UserCustomerMapper;
import cn.com.qcc.pojo.Furniture;
import cn.com.qcc.pojo.Historycent;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.Housepay;
import cn.com.qcc.pojo.Mycent;
import cn.com.qcc.pojo.Payexpert;
import cn.com.qcc.pojo.Paymodal;
import cn.com.qcc.pojo.Profile;
import cn.com.qcc.pojo.ProfileExample;
import cn.com.qcc.pojo.Rentmodal;
import cn.com.qcc.pojo.User;
import cn.com.qcc.pojo.Usercent;
import cn.com.qcc.pojo.UsercentExample;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HouseRoomCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.UserCentCustomer;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.HouseRoomService;

@Service
public class HouseRoomServiceImpl implements HouseRoomService{
	
	@Autowired HouseRoomCustomerMapper houseRoomCustomerMapper;
	@Autowired UsercentMapper usercentMapper;
	@Autowired UserCustomerMapper userCustomerMapper;
	@Autowired ProfileMapper profileMapper;
	@Autowired PaymodalMapper paymodalMapper;
	@Autowired RentmodalMapper rentmodalMapper;
	@Autowired HousepayMapper housepayMapper;
	@Autowired MycentMapper mycentMapper;
	@Autowired HouseMapper houseMapper;
	@Autowired PayexpertMapper payexpertMapper;
	@Autowired HistorycentMapper historycentMapper;
	@Autowired HouseCustomerMapper houseCustomerMapper;
	@Autowired FurnitureMapper furnitureMapper;
	
	


	/**查询房态图**/
	public List<HouseRoomCustomer> roompattern(HouseVo houseVo) {
		// 第一步,查询出基本的房源信息列表
		List<HouseRoomCustomer> houseList = houseRoomCustomerMapper.roompattern(houseVo);
		
		// 第二步,根据租约id查询housepay 支付情况表
		List<String> idList = new ArrayList<>();
		
		for (int i = 0; i < houseList.size(); i++) {// 从第一个数开始，到最后一个数-1次循环
			if (CheckDataUtil.checkNotEmpty( houseList.get(i).getUsercentid() ));
			idList.add( houseList.get(i).getUsercentid().toString() );
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
		
		
		List<Housepay> payList = new ArrayList<>();
		if (CheckDataUtil.checkNotEmpty(idList)) 
			payList = 	houseRoomCustomerMapper.getPayModel(idList);
		
		// 第三步,计算各种金额数据给前台
		for (HouseRoomCustomer house : houseList) {
			//其他费用没有支付
			double otherpricesnotpay = 0;
			//其他费用支付
			double otherpricespay = 0 ;
			// 取出没有支付的最小日期
			for (Housepay pay : payList) {
				// 当是 同一条租约时候开始计算数据
				if (house.getUsercentid().longValue()== pay.getUsercentid().longValue()) {
					//如果是 29 租金
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
							//判断时间
							Long current = new Date().getTime();
							Long shouKuan = pay.getCreate_time().getTime();
							// 如果当前时间比 收款时间大 说明其他费用逾期
							if (current > shouKuan) 
								otherpricesnotpay += pay.getCentprices();
						}
							
						//其他费用已经支付本月 1 yue 12 -   2  - 12  2 9 
						if ( pay.getPaystate().longValue() == 2) {
							Long current = new Date().getTime();
							Long yishou = 0L;
							if (CheckDataUtil.checkNotEmpty(pay.getUpdate_time())) {
								yishou = pay.getUpdate_time().getTime();
							}
									
							//计算距离收款日前后15 
							if (current > yishou && current < (yishou + 1296000000 * 2) ) 
								otherpricespay +=pay.getCentprices();
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
		return list.size() == 0 ||  list.isEmpty();
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
				Housepay housepay = new Housepay();
				Calendar calendar = Calendar.getInstance();
				payexpert.setStart_time(start_time); // 分期的开始日期 [也即使账单的开始日期]
				calendar.setTime(start_time);
				if (i == 0) {
					pertname = "首期";
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
				payexpert.setState(1); // 没有推送账单
				payexpert.setEnd_time(start_time);
				payexpertMapper.insertSelective(payexpert);
				// 在生产分期账单
				housepay.setPayexpertid(payexpert.getPayexpertid());
				housepay.setHouseid(usercent.getHouseid());
				// 这里设置需要交房租时间
				housepay.setPaystate(1);// 未支付状态
				housepay.setCurrentstate(1);// 当前租期
				housepay.setUsercentid(usercent.getUsercentid()); // 租客登记的唯一约束
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
	
	
	
	
	
	/**
	 * 租客登记时候必须要填写的资料.
	 * @param houseid     : 登记的房子ID
	 * @param landuserid  :设置用户的ID，方便管家推送账号和管理
	 * @param Yaprices    : 当前房间的押金
	 * @param centfromid  : 租客来源的ID
	 * @param mycentid    : 合同模板ID
	 * @param start_time  : 租约开始时间
	 * @param end_time    : 租约结束时间
	 * @param pricestype  :其他一次性费用
	 * @param othermore   : 其他补充合同
	 * @param islinecent  : yes 表示线上合同
	 **/
	public ResultMap usercent(Usercent usercent, Mycent mycent, HttpServletRequest request, String othermore,
			String payid, String paycentid, String pricestype, String othermoreid1, String othermoreid2,
			String islinecent) {
		
		// 先判断该房源是否可以租客 0-返回true 表示 没有签约的房子
		boolean falg = checkUsercent(usercent);
		if (falg == false ) return ResultMap.build(400, "该房源已经登记");
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
		// 当前房源的押金
		if (num == 1 && usercent.getYaprices() == null) {
			return ResultMap.build(201, "输入押金");
		}
		// 建立管家即是子账号
		if (usercent.getLanduserid() == null) {
			usercent.setLanduserid(-1L);
		}
		if (usercent.getUserid() == null) {
			return ResultMap.build(204, "操作需要登录");
		}
		// 建立关系的房源ID，不可以少。
		if (usercent.getHouseid() == null) {
			return ResultMap.build(203,  "选择一个房源");
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
		if (profile == null || profile.getSignstate() !=2) {
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

		/** 
		 * 添加历史租客和设置房源为已租的状态。
		 * 在返回之前设置房子状态为已经租的状态
		 */
		House house = new House();
		house.setHouseid(usercent.getHouseid());
		house.setHousestatus("2");
		houseMapper.updateByPrimaryKeySelective(house);
		
		// 发送短信告诉租客
		String content ="";
		String phone = profile.getTelephone().toString();
		String modelId = WangYiCommon.LAND_CENT_PUSH;
		SendMessage.sendNoticMess(content, phone, modelId);
		return ResultMap.IS_200(map);
	}

}
