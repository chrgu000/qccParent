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
import org.apache.http.ParseException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import WangYiUtil.WangYiUtil;
import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.DateUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.MyJsonUtil;
import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.XwpfTUtil;
import cn.com.qcc.detailcommon.JedisClient;
import cn.com.qcc.mapper.AccessMapper;
import cn.com.qcc.mapper.BrandMapper;
import cn.com.qcc.mapper.BranduserMapper;
import cn.com.qcc.mapper.BrokerMapper;
import cn.com.qcc.mapper.CodeMapper;
import cn.com.qcc.mapper.ConsumeMapper;
import cn.com.qcc.mapper.FurnitureMapper;
import cn.com.qcc.mapper.HistorycentMapper;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mapper.HousepayMapper;
import cn.com.qcc.mapper.InteconnMapper;
import cn.com.qcc.mapper.InviteMapper;
import cn.com.qcc.mapper.LandlordMapper;
import cn.com.qcc.mapper.LucreMapper;
import cn.com.qcc.mapper.MaillistMapper;
import cn.com.qcc.mapper.MycentMapper;
import cn.com.qcc.mapper.PayexpertMapper;
import cn.com.qcc.mapper.PaymodalMapper;
import cn.com.qcc.mapper.ProfileMapper;
import cn.com.qcc.mapper.RentmodalMapper;
import cn.com.qcc.mapper.RongconnMapper;
import cn.com.qcc.mapper.SystemstateMapper;
import cn.com.qcc.mapper.UserMapper;
import cn.com.qcc.mapper.UserRoleMapper;
import cn.com.qcc.mapper.UsercentMapper;
import cn.com.qcc.mapper.UserconnMapper;
import cn.com.qcc.mapper.VipcountMapper;
import cn.com.qcc.mess.util.SendMessUtil;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.mymapper.UserCustomerMapper;
import cn.com.qcc.pojo.Access;
import cn.com.qcc.pojo.AccessExample;
import cn.com.qcc.pojo.Area;
import cn.com.qcc.pojo.Brand;
import cn.com.qcc.pojo.BrandExample;
import cn.com.qcc.pojo.Branduser;
import cn.com.qcc.pojo.BranduserExample;
import cn.com.qcc.pojo.Broker;
import cn.com.qcc.pojo.Code;
import cn.com.qcc.pojo.CodeExample;
import cn.com.qcc.pojo.Furniture;
import cn.com.qcc.pojo.Historycent;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.Housepay;
import cn.com.qcc.pojo.Inteconn;
import cn.com.qcc.pojo.Invite;
import cn.com.qcc.pojo.InviteExample;
import cn.com.qcc.pojo.Landlord;
import cn.com.qcc.pojo.Lucre;
import cn.com.qcc.pojo.Maillist;
import cn.com.qcc.pojo.MaillistExample;
import cn.com.qcc.pojo.Mycent;
import cn.com.qcc.pojo.Payexpert;
import cn.com.qcc.pojo.Paymodal;
import cn.com.qcc.pojo.Profile;
import cn.com.qcc.pojo.ProfileExample;
import cn.com.qcc.pojo.Rentmodal;
import cn.com.qcc.pojo.Rongconn;
import cn.com.qcc.pojo.RongconnExample;
import cn.com.qcc.pojo.Ronggroup;
import cn.com.qcc.pojo.User;
import cn.com.qcc.pojo.UserExample;
import cn.com.qcc.pojo.Usercent;
import cn.com.qcc.pojo.UsercentExample;
import cn.com.qcc.pojo.Userconn;
import cn.com.qcc.pojo.UserconnExample;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.service.UserService;
import io.rong.models.TokenResult;
import io.rong.util.RongCloud;
import sun.misc.BASE64Decoder;
import cn.com.qcc.queryvo.CentFromCustomer;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.MailCustomer;
import cn.com.qcc.queryvo.MailVo;
import cn.com.qcc.queryvo.UserCentCustomer;
import cn.com.qcc.queryvo.UserCentVo;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.queryvo.UserVo;

@SuppressWarnings("restriction")
@Service
public class UserServiceImpl implements UserService {
	@Autowired RongconnMapper rongconnMapper;
	@Autowired UserconnMapper userconnMapper;
	@Autowired UserRoleMapper userRoleMapper;
	@Autowired VipcountMapper vipcountMapper;
	@Autowired ProfileMapper profileMapper;
	@Autowired PaymodalMapper paymodalMapper;
	@Autowired PayexpertMapper payexpertMapper;
	@Autowired CodeMapper codeMapper;
	@Autowired UserMapper userMapper;
	@Autowired JedisClient jedisClient;
	@Autowired LandlordMapper landlordMapper;
	@Autowired UserCustomerMapper userCustomerMapper;
	@Autowired MycentMapper mycentMapper;
	@Autowired HistorycentMapper historycentMapper;
	@Autowired UsercentMapper usercentMapper;
	@Autowired HousepayMapper housepayMapper;
	@Autowired RentmodalMapper rentmodalMapper;
	@Autowired HouseCustomerMapper houseCustomerMapper;
	@Autowired FurnitureMapper furnitureMapper;
	@Autowired HouseMapper houseMapper;
	@Autowired MaillistMapper maillistMapper;
	@Autowired BrandMapper brandMapper;
	@Autowired SystemstateMapper systemstateMapper;
	@Autowired InteconnMapper inteconnMapper;
	@Autowired InviteMapper inviteMapper;
	@Autowired LucreMapper lucreMapper;
	@Autowired ConsumeMapper consumeMapper;
	@Autowired BranduserMapper branduserMapper;
	@Autowired BrokerMapper brokerMapper;
	@Autowired AccessMapper accessMapper;
	@Resource  Destination userUpdate;
	@Autowired JmsTemplate jmsTemplate;
	private final static String appkey = "8w7jv4qb8ckny";
	private final static String secret = "1S7NZ4qxFM";

	// 根据短信密码登录
	public ResultMap codeLogin(Long telephone, String code, HttpServletRequest request) {

		// 获取验证码 type =3表示更改手机号码
		if (telephone == null) {
			return ResultMap.build(100,"输入电话号码");
		}
		Code code_search = getcheckcode("3", telephone);
		if (code_search == null) {
			return ResultMap.build(101, "验证码失效");
		}
		String code_get = "";
		if (code != null && !"".equals(code)) {
			code_get = getBASE64(code);
		}
		if (!code_search.getCode().equals(code_get)) {
			return ResultMap.build(102,"验证码错误");
		}
		// 查询用户的基本信息根据基本信息判断去哪个页面
		UserCustomer userCustomer = userCustomerMapper.getUserMessage(telephone);
		if (userCustomer == null) {
			return ResultMap.build(500, "请先成为我们的用户");
		}
		// 如果用户正常登陆查询出所有权限的集合
		// String[] urls = userCustomer.getAccessurlid().split(",");
		// List<Access> accesses = userCustomerMapper.getallurls(urls);
		// userCustomer.setAccess(accesses);
		userCustomer.setPassword("");
		return ResultMap.IS_200(userCustomer);
	}

	@Override
	public UserCustomer getUserAccessToken(String token) {
		// 如果用户正常登陆查询出所有权限的集合
		UserCustomer userCustomer = userCustomerMapper.getUserByToken(token);
		return userCustomer;
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
	 *            租客来源的ID
	 * @param mycentid
	 *            合同模板ID
	 * @param start_time
	 *            租约开始时间
	 * @param end_time
	 *            租约结束时间
	 * @param pricestype
	 *            其他一次性费用
	 * @param othermore
	 *            其他补充合同
	 * @param islinecent
	 *            yes 表示线上合同
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

		// 校验租户是否已经实名
		Profile profile = checkprofile(usercent.getUserid());
		if (profile == null) {
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
		return ResultMap.IS_200(map);
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

	private Profile checkprofile(Long userid) {
		ProfileExample example = new ProfileExample();
		ProfileExample.Criteria criteria = example.createCriteria();
		criteria.andUser_idEqualTo(userid);
		criteria.andSignstateEqualTo(2);
		List<Profile> profiles = profileMapper.selectByExample(example);
		if (!profiles.isEmpty() && profiles.size() > 0) {
			return profiles.get(0);
		}
		return null;
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

	private String getDateString(Long start) {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		long lt = new Long(start);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
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

	public ResultMap regiestland(Landlord landlord, Long telephone) {
		// 数据的合法性校验
		if (telephone == null) {
			return ResultMap.build(400, "检查你的手机号");
		}
		if (landlord.getIdentity() == null || "".equals(landlord.getIdentity())) {
			return ResultMap.build(400, "身份证号码不能为空");
		}
		if (landlord.getRealname() == null || "".equals(landlord.getRealname())) {
			return ResultMap.build(400, "请输入真实姓名");
		}
		if (landlord.getIdpictures() == null || "".equals(landlord.getIdpictures())) {
			return ResultMap.build(400, "请输入身份证照片");
		}
		User user = GetUserByTelephone(telephone);
		if (user == null) {
			return ResultMap.build(400, "请先成为我们的用户");
		}
		Landlord lan_search = searchLandUserByUserId(user.getUserid());

		if (lan_search != null) {
			if (lan_search.getLandstate() == 3) { // 如果是之前申请过没有通过再次申请执行更新
				// 这里需要做时间差计算
				return ResultMap.build(400, "最近一次审核未通过，请稍后提交申请!");
			}
			if (lan_search.getLandstate() == 2) {
				return ResultMap.build(300, "已经是我们的房东");
			}
			if (lan_search.getLandstate() == 1) {
				return ResultMap.build(300, "审核中...");
			}
		} else { // 第一次申请的时候数据库是空的
			landlord.setUpdate_time(new Date());// 最近一次申请时间
			// 查询房东入驻的默认状态码
			Integer searchstate = systemstateMapper.selectByPrimaryKey(3).getDefaultstate();
			landlord.setLandstate(searchstate);
			// 申请加入。等待我们审核。
			landlord.setLanduserid(user.getUserid());// 当前申请人ID
			landlordMapper.insertSelective(landlord);
		}
		return ResultMap.build(200, "你的资料已经提交等待我们审核");
	}

	public  Landlord searchLandUserByUserId(Long userid) {
		Landlord landlord = landlordMapper.selectByPrimaryKey(userid);
		return landlord;
	}

	private User GetUserByTelephone(Long telephone) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andTelephoneEqualTo(telephone);
		List<User> users = userMapper.selectByExample(example);
		if (users.size() > 0 && !users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public Map<String, Object> removenotlike(String userid, String msgid, String time, String fromuserid) {

		Map<String, Object> map = null;
		if (userid == null || "".equals(userid) || msgid == null || "".equals(msgid) || time == null
				|| "".equals(time)) {
			return map;
		}
		try {
			map = WangYiUtil.removenotlike(userid, msgid, time, fromuserid);
			return map;
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public ResultMap getrealnamebyphone(String telephone) {
		if (telephone == null || "".equals(telephone)) {
			return ResultMap.build(400, "电话号码空");
		}
		UserCustomer userCustomer = userCustomerMapper.getrealnamebyphone(telephone);
		if (userCustomer == null) {
			return ResultMap.build(400, "未实名租户"); // 是否自动建立租户
		}
		return ResultMap.build(200, "查询到的信息...", userCustomer);
	}

	@Override
	public List<CentFromCustomer> centfromlist() {
		List<CentFromCustomer> cents = userCustomerMapper.centfromlist();
		// 去除多余的父名称
		for (int i = 0; i < cents.size(); i++) {
			for (int j = cents.size() - 1; j > i; j--) {// 从最后一个数开始到i+1
				if (cents.get(i).getFid().equals(cents.get(j).getFid())) {
					cents.get(j).setFname("");
				}
			}
		}
		return cents;
	}

	@Override
	public List<UserCentCustomer> paylistshowbecent(Long usercentid) {
		UserCentCustomer userCentCustomer = new UserCentCustomer();
		userCentCustomer.setUsercentid(usercentid);

		List<UserCentCustomer> list = userCustomerMapper.paylistshowbecent(userCentCustomer);
		return list;
	}

	@Override
	public ResultMap usercentdetail(String usercentnum) {
		Map<String, Object> map = new HashMap<>();
		// 这里是查询房屋押金
		UserCentCustomer centprices = userCustomerMapper.usercentdetailprices(usercentnum);
		UserCentCustomer userCentCustomer = userCustomerMapper.usercentdetail(usercentnum);
		List<UserCentCustomer> cents = userCustomerMapper.usercentdetaillist(usercentnum);
		String payname = ""; // 付款方式 QTC153058298916062
		for (UserCentCustomer cent : cents) {
			String[] ids = cent.getPaystyleid().split(",");
			Paymodal pa1 = paymodalMapper.selectByPrimaryKey(Long.valueOf(ids[0]));
			Paymodal pa2 = paymodalMapper.selectByPrimaryKey(Long.valueOf(ids[1]));
			payname = pa1.getTypename() + pa2.getTypename();
			cent.setPaystylename(payname);
			payname = "";
			// 查询费用集合
			List<UserCentCustomer> pays = userCustomerMapper.firstpay(cent.getUsercentid());
			cent.setUsercents(pays);
			String countName = IDUtils.foematInteger(cent.getCenttimes());
			cent.setCountName("第" + countName + "次签约");
		}
		// 设置总押金
		userCentCustomer.setCurrentprices(centprices.getCentprices());
		// 计算租约时间长度
		String datalong = IDUtils.datecompany(userCentCustomer.getEnd_time(), userCentCustomer.getStart_time());
		userCentCustomer.setCountName(datalong);
		map.put("usercent", userCentCustomer);
		map.put("centlist", cents);
		return ResultMap.IS_200(map);
	}

	@Override
	public ResultMap financialbycentnum(String usercentnum) {
		Map<String, Object> map = new HashMap<>();
		List<UserCentCustomer> cents = userCustomerMapper.financialbycentnum(usercentnum);
		List<UserCentCustomer> yacents = userCustomerMapper.yacentsbycentnum(usercentnum);
		for (UserCentCustomer cent : cents) { // 第一层查询租约分组。
			List<UserCentCustomer> centpayex = userCustomerMapper.centpayexbyid(cent.getUsercentid());
			// 查询费用集合
			String countName = IDUtils.foematInteger(cent.getCenttimes());
			cent.setCountName("第" + countName + "次签约");
			for (UserCentCustomer payex : centpayex) {
				// 查询详情
				List<UserCentCustomer> list = userCustomerMapper.housepaylistbyid(payex.getPayexpertid());
				for (UserCentCustomer centlist : list) {
					// 计算逾期时间
					if (centlist.getPaystate() == 1) {
						int needoutday = DateUtil.daysBetween(new Date(), centlist.getNeedpaytime());
						centlist.setNeedoutday(needoutday);
					}
				}
				payex.setUsercents(list);
			}
			cent.setUsercents(centpayex);
		}
		for (UserCentCustomer yacent : yacents) {
			if (yacent.getPaystate() == 1) {
				int needoutday = DateUtil.daysBetween(new Date(), yacent.getNeedpaytime());
				yacent.setNeedoutday(needoutday);
			}
		}
		map.put("financialist", cents);
		map.put("yacents", yacents);
		return ResultMap.IS_200(map);
	}

	public ResultMap syncmail(List<Maillist> mails, Long userid) {
		if (mails.isEmpty() && mails.size() < 0) {
			return ResultMap.build(400, "同步数据不存在");
		}
		if (userid == null) {
			return ResultMap.build(400, "同步ID不存在");
		}
		// 同步之前删除之前的数据
		MaillistExample example = new MaillistExample();
		MaillistExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		maillistMapper.deleteByExample(example);
		for (Maillist mail : mails) {
			// 先判断是否有电话号码
			String phone = IDUtils.replacePhoneKongGe(mail.getPhoneNumbers());
			if (CheckDataUtil.checkNotEmpty(phone)) {
				mail.setUserid(userid);
				mail.setPhoneNumbers(phone);
				try {
					if (mail.getDisplayName() == null) {
						mail.setDisplayName("");
					}
					maillistMapper.insertSelective(mail);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return ResultMap.build(200, "同步成功");
	}

	@Override
	public int mailsbyuseridCount(MailVo mailVo) {
		// TODO Auto-generated method stub
		return userCustomerMapper.mailsbyuseridCount(mailVo);
	}

	@Override
	public List<MailCustomer> mailsbyuserid(MailVo mailVo) {
		
		// 先查询userid 大于 0 的
		List<MailCustomer> list =  userCustomerMapper.mailsbyuserid(mailVo);
		//如果查不到数据
		if (CheckDataUtil.checkNotEmpty(list)) {
			for (MailCustomer mail : list) {
				String fansMess = "邀请";
				// 如果userid存在
				if (mail.getUserid() > 0) {
					if (CheckDataUtil.checkisEqual(mail.getFansState(), 0)) 
						fansMess = "+关注";
					if (CheckDataUtil.checkisEqual(mail.getFansState(), 1)) 
						fansMess = "已关注";
				}
				if (CheckDataUtil.checkisEmpty(mail.getAvatar())) {
					mail.setAvatar("http://www.hadoop.zzw777.com/d7b6b65a-5ee1-4d6f-9f18-5a6fbc589387");
				}
				mail.setFansMess(fansMess);
			}
		}
		return list;
	}

	@Override
	public UserCentCustomer backlog(UserCentVo userCentVo) {
		// TODO Auto-generated method stub
		return userCustomerMapper.backlog(userCentVo);
	}

	// 续租查询租户信息
	public UserCentCustomer xuzusearch(String usercentnum) {
		return userCustomerMapper.xuzusearch(usercentnum);
	}

	@Override
	public void insertprofile(Profile profile) {
		profileMapper.insertSelective(profile);
	}

	@Override
	public void updateprofile(Profile profile) {
		profileMapper.updateByPrimaryKeySelective(profile);
	}

	@Override
	public void insertuser(User user) {
		userMapper.insertSelective(user);
	}

	@Override
	public void insertuservip(Vipcount vipcount) {
		vipcountMapper.insertSelective(vipcount);
	}

	public ResultMap userReg(User user, Profile profile, Code code) {
		// 校验本系统中是否已经有该手机号的注册
		User user_s = checktelephoneexixt(user.getTelephone());
		if (user_s != null) {
			return ResultMap.build(400, "该号码已经注册过。");
		}
		// 获取验证码 type =3表示更改手机号码
		Code code_search = getcheckcode("3", user.getTelephone());
		if (code_search == null) {
			return ResultMap.build(400, "验证码失效");
		}
		String code_get = "";
		if (code.getCode() != null && !"".equals(code.getCode())) {
			code_get = getBASE64(code.getCode());
		}
		if (!code_search.getCode().equals(code_get)) {
			return ResultMap.build(500, "验证码错误");
		}
		userMapper.insertSelective(user);
		profile.setUser_id(user.getUserid());
		profileMapper.insert(profile);
		// 新用户赠送200次求租次数
		Vipcount vipcount = new Vipcount();
		vipcount.setUser_id(user.getUserid());
		vipcount.setBalance(0.0D);
		vipcount.setCount(200);
		vipcount.setCretime_time(new Date());
		vipcount.setIs_vip(0);
		vipcount.setAccount(0.0D);
		vipcountMapper.insertSelective(vipcount);
		// 新用户赠送50个金币
		Inteconn inteconn = new Inteconn();
		inteconn.setUserid(user.getUserid());
		inteconn.setCount(50L);
		inteconn.setUpdate_time(new Date());
		inteconn.setGrand(1);
		inteconnMapper.insertSelective(inteconn);
		return ResultMap.IS_200(user.getUserid());
	}

	public User findUserid(User user) {
		// TODO Auto-generated method stub
		return findUserid(user);
	}



	// 用户根据密码登录
	public User loginByPwd(User user) {
		UserExample example = new UserExample();
		UserExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andTelephoneEqualTo(user.getTelephone());
		List<User> listUser = userMapper.selectByExample(example);
		if (!listUser.isEmpty() && listUser.size() > 0) {
			User user1 = listUser.get(0);
			return user1;
		} else {
			return null;
		}
	}

	public ResultMap updatePwd(long userId, String newPwd, String oldPwd) {
		User user = userMapper.selectByPrimaryKey(userId);
		if (!oldPwd.equals(user.getPassword())) {
			return ResultMap.build(400, "原始密码错误！");
		}
		user.setPassword(newPwd);
		userMapper.updateByPrimaryKeySelective(user);
		return ResultMap.build(200, "恭喜你修改密码成功！");
	}

	public void updateTel(User user) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKeySelective(user);
	}

	public User findPwdByUserid(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateAccesstoken(User user) {
		// TODO Auto-generated method stub

	}

	public User getUserInfoByTel(User user) {
		// TODO Auto-generated method stub
		// userMapper.toString();
		UserExample example = new UserExample();
		UserExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andTelephoneEqualTo(15989894717l);
		User user1 = userMapper.selectByExample(example).get(0);
		return user1;
	}

	public User getUserByUserid(long userid) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(userid);
	}

	public User getUserByUserid1(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateUsertype(User user) {
		// TODO Auto-generated method stub

	}

	// 根据短信密码登录
	public ResultMap codeLogin(User user, Code code) {

		// 获取验证码 type =3表示更改手机号码
		Code code_search = getcheckcode("3", user.getTelephone());
		if (code_search == null) {
			return ResultMap.build(400, "验证码失效");
		}
		String code_get = "";
		if (code.getCode() != null && !"".equals(code.getCode())) {
			code_get = getBASE64(code.getCode());
		}
		if (!code_search.getCode().equals(code_get)) {
			return ResultMap.build(500, "验证码错误");
		}

		UserExample example = new UserExample();
		UserExample.Criteria createCriteria = example.createCriteria();
		createCriteria.andTelephoneEqualTo(user.getTelephone());
		List<User> user1 = userMapper.selectByExample(example);
		if (user1.isEmpty() || user1.size() == 0) {
			return ResultMap.build(200, null);
		}
		
		// 如果有经纬度同步经纬度
		if (user.getLatitude() > 0 && user.getLongitude() > 0 ) {
			User update = user1.get(0);
			update.setLatitude(user.getLatitude());
			update.setLongitude(user.getLongitude());
			userMapper.updateByPrimaryKeySelective(update);
		}
		
		return ResultMap.IS_200(user1.get(0));
	}

	// 通过手机号修改密码
	public ResultMap findPwdByTel(User user, Code code) {

		// 获取验证码 type =3表示更改手机号码
		Code code_search = getcheckcode("3", user.getTelephone());
		if (code_search == null) {
			return ResultMap.build(400, "验证码失效");
		}
		String code_get = "";
		if (code.getCode() != null && !"".equals(code.getCode())) {
			code_get = getBASE64(code.getCode());
		}
		if (!code_search.getCode().equals(code_get)) {
			return ResultMap.build(500, "验证码错误");
		}
		User user_id = getUserByphone(user.getTelephone());
		user.setUserid(user_id.getUserid());
		userMapper.updateByPrimaryKeySelective(user);
		return ResultMap.IS_200();
	}

	public User getUserByphone(Long telephone) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andTelephoneEqualTo(telephone);
		List<User> selectByExample = userMapper.selectByExample(example);
		if (!selectByExample.isEmpty() && selectByExample.size() > 0) {
			return selectByExample.get(0);
		}
		return null;
	}

	// 根据用户ID获取房子信息
	public List<HouseCustomer> singleablum(Integer userid ,PageQuery pagequery) {
		// 查询个人发布的物品或者部落
		List<HouseCustomer> tribeList = houseCustomerMapper.singleablum(userid ,pagequery);
		return tribeList;
	}
	
	public Integer singleablumCount(Integer userid) {
		return houseCustomerMapper.singleablumCount(userid);
	};

	@Override
	public UserCustomer getUserAndProfile(Long userid) {
		UserCustomer userCustomer = null;
		if (userid == null) {return userCustomer;}
		userCustomer = userCustomerMapper.getUserAndProfileByUserid(userid);
		if (userCustomer !=null) {
			userCustomer.setPassword("");
		}
		return userCustomer;
	}

	// 更改用户名
	public void updateUserName(Long userid, String username) {
		Profile profile = new Profile();
		profile.setUser_id(userid);
		profile.setUser_name(username);
		userCustomerMapper.updateUserName(profile);
	}

	// 更改邮箱
	public void updateMail(Long userid, String mail) {
		Profile profile = new Profile();
		profile.setUser_id(userid);
		profile.setMail(mail);
		userCustomerMapper.updateMail(profile);
	}

	public String addRongToken(Long userid, String user_name, String atavr) throws Exception {
		RongCloud rongCloud = RongCloud.getInstance(appkey, secret);
		TokenResult token1 = rongCloud.user.getToken(userid + "", user_name, atavr);
		this.updateToken(userid, token1.getToken());
		return token1.getToken();

	}

	private void updateToken(Long userid, String token1) {
		User user = new User();
		user.setUserid(userid);
		user.setToken(token1);
		userCustomerMapper.updateToken(user);
	}

	// 找房东
	public List<UserCustomer> findland(UserVo userVo) {
		// TODO Auto-generated method stub
		return userCustomerMapper.findland(userVo);
	}

	@Override
	public Integer findlandCount(UserVo userVo) {
		// TODO Auto-generated method stub
		return userCustomerMapper.findlandCount(userVo);
	}

	@Override
	public List<UserCustomer> getuserinfo(String[] user_ids) {
		// TODO Auto-generated method stub
		return userCustomerMapper.getuserinfo(user_ids);
	}

	@Override
	public ResultMap getUserByToken(String token) {
		// 根据token到redis中取用户信息
		String json = jedisClient.get("user:" + token);
		// 取不到用户信息，登录已经过期，返回登录过期
		if ("".equals(json) || json == null) {
			return ResultMap.build(201, "用户登录已经过期");
		}
		// 取到用户信息更新token的过期时间
		jedisClient.expire("user:" + token, 3600);
		// 返回结果，E3Result其中包含TbUser对象
		User user = MyJsonUtil.jsonToPojo(json, User.class);
		return ResultMap.IS_200(user);
	}

	@Override
	public ResultMap updateAvatat(Long userid, String filePath) {
		if (userid == null) {
			return ResultMap.build(400, "请先登录");
		}
		if (filePath == null || "".equals(filePath)) {
			return ResultMap.build(400, "请输入一张图片");
		}
		Profile profile = new Profile();
		profile.setUser_id(userid);
		profile.setAvatar(filePath);
		userCustomerMapper.updateAvatar(profile);
		return ResultMap.build(200, "修改头像成！");
	}

	// 直接加对方好友
	public ResultMap befriend(Userconn userconn) {
		if (userconn.getUserid() == null) {
			return ResultMap.build(404, "未知登录状态");
		}
		if (userconn.getFollowuserid() == null) {
			return ResultMap.build(400, "你需要添加的好友不存在");
		}
		// 检查对方是否在我的控制表中有数据
		Userconn my_user = checkUser(userconn);
		// 查询自己在对方的状态
		Userconn you_user = getUser(userconn);
		if (you_user.getState() == 4) {return ResultMap.build(400, "对方把你拉黑");}
		if (my_user == null) {
			// 建立好友状态
			userconn.setState(3);
			userconn.setUpdate_time(new Date());
			userconnMapper.insertSelective(userconn);
			return ResultMap.build(200, "添加成功");
		}
		//判断是否已经是好友关系
		if (my_user.getState() == 3) {return ResultMap.build(400, "已是好友");}
		userconn.setState(3);
		userconn.setUpdate_time(new Date());
		userconn.setUserconnid(my_user.getUserconnid());
		userconnMapper.updateByPrimaryKeySelective(userconn);
		return ResultMap.build(200, "添加成功");
	}
	
	/**获取自己在别人好友中的状态**/
	private Userconn getUser(Userconn userconn) {
		UserconnExample example = new UserconnExample();
		UserconnExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userconn.getFollowuserid());
		criteria.andFollowuseridEqualTo(userconn.getUserid());
		List<Userconn> connlist = userconnMapper.selectByExample(example);
		if (!connlist.isEmpty() && connlist.size() > 0) {
			return connlist.get(0);
		}
		// 建立非好友状态
		Userconn insertUser = new Userconn();
		insertUser.setFollowuserid(userconn.getUserid());
		insertUser.setUserid(userconn.getFollowuserid());
		insertUser.setState(5);
		insertUser.setUpdate_time(new Date());
		//插入数据库
		userconnMapper.insertSelective(insertUser);
		return insertUser;
	}
	
	/**检查自己是否添加了别人为好友**/
	private Userconn checkUser(Userconn userconn) {
		UserconnExample example = new UserconnExample();
		UserconnExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userconn.getUserid());
		criteria.andFollowuseridEqualTo(userconn.getFollowuserid());
		List<Userconn> connlist = userconnMapper.selectByExample(example);
		if (!connlist.isEmpty() && connlist.size() > 0) {
			return connlist.get(0);
		}
		return null;
	}

	// 改变用户 的状态 /移除黑名单 / 删除好友 / 拉入黑名单
	public ResultMap romoveblack(Userconn userconn) {
		userCustomerMapper.romoveblack(userconn);
		if (userconn.getState() == 3) {
			Long userid = userconn.getUserid();
			Long follid = userconn.getFollowuserid();
			userconn.setFollowuserid(userid);
			userconn.setUserid(follid);
			userCustomerMapper.romoveblack(userconn);
		}
		// 如果是删除好友和拉入黑名单时候还需要设置自己在对方的状态
		if (userconn.getState() == 4 || userconn.getState() == 5) {
			// 当前用户ID也是自己 的ID
			Long userid = userconn.getUserid();
			// 你拉黑的那个人的ID
			Long followuserid = userconn.getFollowuserid();
			// 检查自己在对方的状态
			userconn.setFollowuserid(userid);
			userconn.setUserid(followuserid);
			Userconn search = checkUser(userconn);
			// 说明对方吧我拉黑了
			if (search.getState() == 4) {
				// 就设置我在对方的状态为黑名单状态
				userconn.setState(4);
			} else {
				// 设置我在对方的状态为移除
				userconn.setState(5);
			}
			userCustomerMapper.romoveblack(userconn);
		}
		return ResultMap.IS_200();
	}

	// 我的好友 --申请列表 --- 黑名单
	public ResultMap myfriend(Userconn userconn) {
		List<UserCustomer> userlist = userCustomerMapper.myfriend(userconn);

		// 如果是申请列表，需要加入申请的群列表
		if (userconn.getState() == 1) {
			List<UserCustomer> grouplist = userCustomerMapper.mygrouplist(userconn);
			userlist.addAll(grouplist);
		}
		return ResultMap.IS_200(userlist);
	}

	// 查询想要加好友的对象
	public ResultMap searchadd(UserCustomer userCustomer) {
		if (userCustomer.getUserid() == null) {
			return ResultMap.build(404, "未知登录！");
		}
		List<UserCustomer> userlist = userCustomerMapper.searchadd(userCustomer);
		for (int i = 0; i < userlist.size(); i++) {
			
			if (userCustomer.getUserid().equals(userlist.get(i).getUserid())) {
				userlist.remove(i);
			}
			
		}
		return ResultMap.IS_200(userlist);
	}

	// 查看是否是好友
	public String findIsFriend(Long userid, Long followUserId) {
		String str = "加好友";
		Userconn userconn = new Userconn();
		userconn.setUserid(userid);
		userconn.setFollowuserid(followUserId);
		Userconn search = checkUser(userconn);
		if (search != null) {
			if (search.getState() == 3) {
				str = "好友";
			}
		}
		return str;
	}

	@Override
	public ResultMap inviting(Ronggroup ronggroup) {
		List<UserCustomer> userlist = userCustomerMapper.inviting(ronggroup);
		return ResultMap.IS_200(userlist);
	}

	@Override
	public ResultMap invitefriend(Rongconn conn) {
		if (conn.getIds().length == 0) {
			return ResultMap.build(400, "邀请人的ID不存在");
		}
		if (conn.getGroupid() == null) {
			return ResultMap.build(404, "群ID不存在");
		}
		Long groupid = conn.getGroupid();
		for (int i = 0; i < conn.getIds().length; i++) {
			Long followuserid = Long.valueOf(conn.getIds()[i]);
			Rongconn search = checkRongconn(followuserid, groupid);
			// 判断在控制表中是否有数据 如果控制表中么得数据需要加入数据
			if (search == null) {
				// 设置状态码，表示邀请加入
				conn.setState(4);
				conn.setUserid(followuserid);
				conn.setUpdate_time(new Date());
				rongconnMapper.insertSelective(conn);
			}
			if (search != null) {
				if (search.getState() != 1 && search.getState() != 3) {
					search.setState(4);
					rongconnMapper.updateByPrimaryKeySelective(search);
				}
			}
		}
		return ResultMap.IS_200();
	}

	private Rongconn checkRongconn(Long followuserid, Long groupid) {
		RongconnExample example = new RongconnExample();
		RongconnExample.Criteria criteria = example.createCriteria();
		criteria.andGroupidEqualTo(groupid);
		criteria.andUseridEqualTo(followuserid);
		List<Rongconn> list = rongconnMapper.selectByExample(example);
		if (!list.isEmpty() && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void juquejoingroup(String userid, String groupid) {
		RongconnExample example = new RongconnExample();
		RongconnExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(Long.valueOf(userid));
		criteria.andGroupidEqualTo(Long.valueOf(groupid));
		List<Rongconn> list = rongconnMapper.selectByExample(example);
		if (!list.isEmpty() && list.size() > 0) {
			Rongconn conn = list.get(0);
			if (conn.getState() != 1 && conn.getState() != 3) {
				conn.setState(2);
				conn.setUpdate_time(new Date());
				rongconnMapper.updateByPrimaryKeySelective(conn);
			}
		} else {
			Rongconn insert = new Rongconn();
			insert.setUpdate_time(new Date());
			// 表示退出拒绝
			insert.setState(2);
			insert.setGroupid(Long.valueOf(groupid));
			insert.setUserid(Long.valueOf(userid));
			rongconnMapper.insertSelective(insert);
		}
	}

	@Override
	public boolean CheckUserAccess(HttpServletRequest request, String accseeurl) {

		UserCustomer user = (UserCustomer) request.getSession().getAttribute("userback");
		if (user == null) {
			return false;
		}
		List<Access> accesses = user.getAccess();
		if (accesses.isEmpty() || accesses.size() == 0) {
			return false;
		}
		for (Access acc : accesses) {
			if (accseeurl.equals(acc.getAccessurl())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 根据用户的ID,查询用户的角色ID 和角色名称 
	 * @param userid : 用户ID
	 * **/
	public UserCustomer getRoleName(User user) {
		// TODO Auto-generated method stub
		return userCustomerMapper.getRoleName(user);
	}

	@Override
	public void updateweixinmess(Profile profile) {
		// TODO Auto-generated method stub
		userCustomerMapper.updateweixinmess(profile);
	}

	@Override
	public ResultMap updateUser(UserCustomer userCustomer, 
			String codes, HttpServletRequest request ,String mysign) {
		// 先校验用户是否登录
		if (CheckDataUtil.checkisEmpty(userCustomer.getUserid())
				|| CheckDataUtil.checkisEmpty(userCustomer.getTelephone())) {
			return ResultMap.build(400, "检查电话号码");
		}
		// 查询用户的电话号码，判断是否修改手机号码
		User user = userMapper.selectByPrimaryKey(userCustomer.getUserid());
		Profile profile = getprofile(userCustomer);
		if (CheckDataUtil.checkisEmpty(profile) 
				||CheckDataUtil.checkisEmpty(user) ) {
			return ResultMap.build(400, "你修改的账号不存在");
		}
		// 这里做修改手机号码处理
		if (CheckDataUtil.checkNotEqual(user.getTelephone(), userCustomer.getTelephone())) {
			// 校验本系统中是否已经有该手机号的注册
			User user_s = checktelephoneexixt(userCustomer.getTelephone());
			if (CheckDataUtil.checkNotEmpty(user_s)) {
				return ResultMap.build(400, "该手机号已经注册，无法修改。");
			}
			// 获取验证码 type =3表示更改手机号码
			Code code = getcheckcode("3", userCustomer.getTelephone());
			if (CheckDataUtil.checkisEmpty(code)) {
				return ResultMap.build(400, "验证码失效");
			}
			String code_get = "";
			if (CheckDataUtil.checkNotEmpty(userCustomer.getCode())) {
				code_get = getBASE64(userCustomer.getCode());
			}
			if (CheckDataUtil.checkNotEqual(code.getCode(), code_get)) {
				return ResultMap.build(500, "验证码错误");
			}
			user.setTelephone(userCustomer.getTelephone());
			userMapper.updateByPrimaryKeySelective(user);
		}
		
		if (CheckDataUtil.checkNotEmpty(userCustomer.getSex())) {
			profile.setSex(userCustomer.getSex());
		}
		if (CheckDataUtil.checkNotEmpty(mysign)) {
			profile.setMysign(mysign);
		}
		if (CheckDataUtil.checkNotEmpty(userCustomer.getUser_name())) {
			profile.setUser_name(userCustomer.getUser_name());
		}
		if (CheckDataUtil.checkIsEmaile(userCustomer.getMail())) {
			profile.setMail(userCustomer.getMail());
		}else {
			profile.setMail("");
		}
		if (CheckDataUtil.checkNotEmpty(userCustomer.getAvatar())) {
			profile.setAvatar(userCustomer.getAvatar());
		}
		if (CheckDataUtil.checkNotEmpty(codes)) {
			Broker broker = brokerMapper.selectByPrimaryKey(userCustomer.getUserid());
			if (CheckDataUtil.checkNotEmpty(broker)) {
				broker.setCodes(codes);
				brokerMapper.updateByPrimaryKey(broker);
			}
		}
		profileMapper.updateByPrimaryKeySelective(profile);
		
		//发送消息用户修改了信息
		String sendData = userCustomer.getUserid().toString();
		SendMessUtil.sendData(jmsTemplate, userUpdate, sendData);
		
		return ResultMap.build(200, "编辑成功");
	}

	public User checktelephoneexixt(Long telephone) {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andTelephoneEqualTo(telephone);
		List<User> user = userMapper.selectByExample(example);
		if (user.size() > 0 && !user.isEmpty()) {
			return user.get(0);
		}
		return null;
	}

	// 将 s 进行 BASE64 编码
	public static String getBASE64(String s) {
		if (s == null)
			return null;
		return (new sun.misc.BASE64Encoder()).encode(s.getBytes());
	}

	// 将 BASE64 编码的字符串 s 进行解码
	public static String getFromBASE64(String s) {
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b);
		} catch (Exception e) {
			return null;
		}
	}

	private Profile getprofile(UserCustomer userCustomer) {
		ProfileExample example = new ProfileExample();
		ProfileExample.Criteria criteria = example.createCriteria();
		criteria.andUser_idEqualTo(userCustomer.getUserid());
		List<Profile> profi = profileMapper.selectByExample(example);
		if (profi.size() > 0 && !profi.isEmpty()) {
			return profi.get(0);
		}
		return null;
	}

	@Override
	public ResultMap insertcheckcode(String code, Long telephone, String type) {
		Code insert_code = new Code();
		insert_code.setUpdate_time(new Date());
		insert_code.setCreate_time(new Date());
		insert_code.setType(type);
		insert_code.setTelephone(telephone);
		insert_code.setCode(code);
		CodeExample example = new CodeExample();
		CodeExample.Criteria criteria = example.createCriteria();
		criteria.andTelephoneEqualTo(telephone);
		List<Code> code_search = codeMapper.selectByExample(example);
		if (code_search.size() > 0 && !code_search.isEmpty()) {
			insert_code.setCodeid(code_search.get(0).getCodeid());
			codeMapper.updateByPrimaryKeySelective(insert_code);
			return ResultMap.IS_200();
		}
		codeMapper.insertSelective(insert_code);
		return ResultMap.IS_200();
	}

	@Override
	public Code getcheckcode(String type, Long telephone) {
		Date current = new Date();
		Date before = new Date(current.getTime() - 300000);
		Date after = new Date(current.getTime() + 300000);
		CodeExample example = new CodeExample();
		CodeExample.Criteria criteria = example.createCriteria();
		criteria.andTelephoneEqualTo(telephone);
		criteria.andTypeEqualTo(type);
		criteria.andUpdate_timeBetween(before, after);
		List<Code> code_search = codeMapper.selectByExample(example);
		if (code_search.size() > 0 && !code_search.isEmpty()) {
			return code_search.get(0);
		}
		return null;
	}

	// 根据主键更新对象
	public void updateUserByUserId(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public ResultMap searchlikename(String likename, String userid) {
		if (likename == null || "".equals(likename)) {
			return ResultMap.build(400, "请输入查询的关键字");
		}
		if (userid == null || "".equals(userid)) {
			return ResultMap.build(400, "请先登录");
		}
		List<UserCustomer> users = userCustomerMapper.searchlikeuser(likename, userid);
		return ResultMap.IS_200(users);
	}

	@Override
	public void addinvite(Invite invite) {
		inviteMapper.insertSelective(invite);
	}

	@Override
	public ResultMap addinvitebalance(Long userid, Double account) {
		// 查询谁邀请了我
		InviteExample example = new InviteExample();
		InviteExample.Criteria criteria = example.createCriteria();
		criteria.andFollowuseridEqualTo(userid);// 当前的我是followuserid
		List<Invite> firstfloors = inviteMapper.selectByExample(example);
		// 说明这个是推荐我的人
		if (firstfloors.size() == 0) {
			// 说明没有人推荐我进来
			return ResultMap.build(400, "我的上级不存在");
		}
		// 遍历所有的上级。
		Double ticheng = 0.0d;
		String descname = "充值" + account + "元获取收益:";
		for (Invite invi : firstfloors) {
			// 这里是指数上级提成 20%
			if (invi.getLevel() == 1) {
				ticheng = 0.2;
				setaddaccount(invi, userid, account * ticheng, descname);
			}
			// 如果是间接上级提成是5%
			if (invi.getLevel() == 2) {
				ticheng = 0.05;
				setaddaccount(invi, userid, account * ticheng, descname);
			}

		}
		return ResultMap.IS_200();
	}

	private void setaddaccount(Invite invite, Long userid, Double account, String descname) {
		// 查询充值用户信息
		User user = userMapper.selectByPrimaryKey(userid);
		// 第一步同步邀请的金额
		invite.setAccount(invite.getAccount() + account);
		inviteMapper.updateByPrimaryKeySelective(invite);
		// 第二步同步钱包收益余额
		/*Vipcount vipcount = vipcountMapper.selectByPrimaryKey(invite.getUserid());
		vipcount.setAccount(vipcount.getAccount() + account);
		vipcountMapper.updateByPrimaryKeySelective(vipcount);*/
		// 充值记录插入一条记录
		Lucre lurce = new Lucre();
		lurce.setUpdate_time(new Date());
		lurce.setAccount(account);
		String telp = (user.getTelephone() + "").substring(0, 4) + "**";
		descname = "队员" + telp + descname;
		lurce.setDescname(descname);
		lurce.setState(1); // 1为正常
		lurce.setUserid(invite.getUserid());
		lucreMapper.insertSelective(lurce);
	}

	@Override
	public List<User> getall() {
		// TODO Auto-generated method stub
		List<User> users = userMapper.selectByExample(null);
		Integer success = 0;
		Integer error = 0;
		for (User us : users) {
			Vipcount vipcount = new Vipcount();
			vipcount.setBalance(0.0D);
			vipcount.setUser_id(us.getUserid());
			vipcount.setCount(100);
			vipcount.setCretime_time(new Date());
			vipcount.setIs_vip(0);
			try {
				vipcountMapper.insertSelective(vipcount);
				success++;
			} catch (Exception e) {
				error++;
			}
		}
		return users;
	}

	@Override
	public Invite getinvitefather(Long userid) {
		// 查询推荐人的上一级。两个条件 level 1 ，followuserid
		InviteExample example = new InviteExample();
		InviteExample.Criteria criteria = example.createCriteria();
		criteria.andLevelEqualTo(1);
		criteria.andFollowuseridEqualTo(userid);
		List<Invite> invites = inviteMapper.selectByExample(example);
		if (!invites.isEmpty() && invites.size() > 0) {
			return invites.get(0);
		}
		return null;
	}

	@Override
	public Map<String, Object> myteam(Long userid) {
		Map<String, Object> map = new HashMap<>();
		List<UserCustomer> userCustomers =  userCustomerMapper.myteam(userid);
		List<Integer> sons = new ArrayList<>();
		List<UserCustomer> teamSons = new ArrayList<>();
		if (CheckDataUtil.checkNotEmpty(userCustomers)) {
			for (UserCustomer user : userCustomers) {
				sons.add(user.getFollowUserId());
			}
		}
		if (CheckDataUtil.checkNotEmpty(sons)) {
			teamSons = userCustomerMapper.allteamson(userid , sons );
		}
		map.put("firstTeam", userCustomers);
		map.put("secondTeam", teamSons);
		return map;
	}

	@Override
	public List<UserCustomer> myteamson(UserCustomer userCustomer) {
		return userCustomerMapper.myteamson(userCustomer);
	}

	@Override
	public List<Lucre> mylurnce(UserVo userVo) {
		return userCustomerMapper.mylurnce(userVo);
	}

	@Override
	public Invite istwolevel(Long userid) {
		InviteExample example = new InviteExample();
		InviteExample.Criteria criteria = example.createCriteria();
		criteria.andFollowuseridEqualTo(userid);
		criteria.andLevelEqualTo(2);
		List<Invite> list = inviteMapper.selectByExample(example);
		if (!list.isEmpty() && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	// 根据userid 查询当前用户是第几级用户
	public Invite getmaxuserlevel(Long userid) {
		return userCustomerMapper.getmaxuserlevel(userid);
	}

	@Override
	public Map<String, Object> addconnectionlevel(Long returnuserid, Long userid) {
		// 这里判断是不是别人邀请过来的 如果是建立一级关系
		Map<String, Object> map = new HashMap<>();
		String returnstr = "old";
		Long returnid = 0L;
		// 如果没有推荐人直接返回
		if (returnuserid == null) {
			map.put("mess", returnstr);
			return map;
		}

		// 这里是查询的推荐人的level ---最高级别的上级
		Invite invite_search = userCustomerMapper.getmaxuserlevel(returnuserid);
		// 说明推荐的用户就是第一级用户。需要和新用户建立一级关系就可以了。
		Integer level = invite_search.getLevel();
		if (level == 0) {
			// 这里直接和新用户建立一级绑定关系
			Invite invite = new Invite();
			invite.setAccount(0.00);
			invite.setFollowuserid(userid); // 新用户
			invite.setUserid(returnuserid); // 推荐人ID
			invite.setLevel(1); // 建立一级关系
			this.addinvite(invite);
			returnstr = "new";
			map.put("mess", returnstr);
			
			return map;
		}
		// 说明推荐的用户是第二级用户。需要和他上面的用户和新用户建立关系
		if (level == 1) {
			// 这里先和新用户建立一级关系
			Invite invite = new Invite();
			invite.setAccount(0.00);
			invite.setFollowuserid(userid); // 新用户
			invite.setUserid(returnuserid); // 推荐人ID
			invite.setLevel(1); // 建立一级关系
			this.addinvite(invite);

			// 除此之外还要和推荐人上级形成二级关系
			Invite follow = new Invite();
			follow.setAccount(0.0);
			follow.setFollowuserid(userid); // 新用户
			follow.setUserid(invite_search.getUserid()); // 当前推荐人的上一级
			follow.setLevel(2); // 新用户和推荐人的上一级形成二级关系
			this.addinvite(follow);
			returnstr = "erjinew";
			returnid = invite_search.getUserid(); // 当前推荐人的上一级
			map.put("mess", returnstr);
			map.put("userid", returnid);
			return map;
		}
		// 说明是第三级用户需要和下面的用户建立level为3的绑定都没有收益
		if (level == 2 || level == 3) {
			// 这里先和新用户建立一级关系
			Invite invite = new Invite();
			invite.setAccount(0.00);
			invite.setFollowuserid(userid); // 新用户
			invite.setUserid(returnuserid); // 推荐人ID
			invite.setLevel(3); // 建立三级级关系没有收益
			this.addinvite(invite);
			returnstr = "erjinew";
			map.put("userid", returnuserid);
			map.put("mess", returnstr);
			return map;
		}
		return map;

	}

	@Override
	public List<Area> getjiyin(String[] code) {
		return userCustomerMapper.getjiyin(code);
	}



	/**
	 * 创建品牌
	 * @param Onepicture : 图片
	 * @param Userid : 用户ID
	 * @param Brand : 品牌名称
	 * @param Description : 描述
	 * @param Codes : 区域
	 * **/
	public ResultMap createbrand(Brand brand) {
		if (brand.getOnepicture() == null || "".equals(brand.getOnepicture())) {
			return ResultMap.build(400, "请插入图片");
		}
		if (brand.getUserid() == null) {
			return ResultMap.build(400, "请登录！");
		}
		if (brand.getBrand() == null || "".equals(brand.getBrand())) {
			return ResultMap.build(400, "品牌名称");
		}
		if (brand.getDescription() == null || "".equals(brand.getDescription())) {
			return ResultMap.build(400, "描述");
		}
		if (brand.getCodes() == null || "".equals(brand.getCodes())) {
			return ResultMap.build(400,"选择区域");
		}
		Brand check = checkbrand(brand);
		if (check != null) {
			return ResultMap.build(300, "品牌占用");
		}

		brand.setUpdate_time(new Date());
		// 查询品牌的默认状态码 此处需要审核
		Integer state = systemstateMapper.selectByPrimaryKey(1).getDefaultstate();
		brand.setState(state);
		brandMapper.insertSelective(brand);

		// 建立品牌和用户之间的关系
		Branduser user = new Branduser();
		user.setBrandid(brand.getBrandid());
		user.setUserstate(1);
		;// 品牌的拥有者
		user.setUpdate_time(new Date());
		user.setUserid(brand.getUserid());
		branduserMapper.insert(user);
		return ResultMap.build(200, "创建成功");
	}

	/**查询我的品牌
	 * @param userid : 用户ID
	 * @param currentpage : 当前页面
	 * @param pagesize : 每页显示的条数
	 * **/
	public List<Brand> getmybranduser(UserVo userVo) {
		// TODO Auto-generated method stub
		return userCustomerMapper.getmybranduser(userVo);
	}

	/**
	 * 根据品牌ID 查询哪些用户在这个品牌下
	 * @param brandid : 品牌ID
	 * **/
	public List<UserCustomer> followbrand(Long brandid) {
		return userCustomerMapper.followbrand(brandid);
	}

	/**查询需要添加的用户
	 * @param searchwhere : 输入的查询条件
	 * @param brandid : 品牌ID
	 * **/
	public List<UserCustomer> searchaddbranduser(UserCustomer userCustomer) {
		return userCustomerMapper.searchaddbranduser(userCustomer);
	}

	/**更新用户状态
	 * @param Brandid : 品牌ID
	 * @param Userid  : 用户ID
	 * @param Userstate : 在品牌中状态
	 * **/
	public ResultMap updatebranduser(Branduser branduser) {
		if (branduser.getBrandid() == null) {
			return ResultMap.build(300, "数据不全");
		}
		if (branduser.getUserid() == null) {
			return ResultMap.build(300, "数据不全");
		}
		if (branduser.getUserstate() == null && branduser.getUserstate() != 3 && branduser.getUserstate() != 2) {
			return ResultMap.build(300, "数据不全");
		}
		// 这里是移除
		if (branduser.getUserstate() == 3) {
			branduserMapper.changeusertype(branduser);
			return ResultMap.build(200, "操作成功");
		}
		// 如果是添加
		Branduser check = checkbranduser(branduser);
		if (check != null) {
			check.setUserstate(2);
			branduserMapper.changeusertype(check);
			return ResultMap.build(200, "操作成功");
		}
		branduser.setUpdate_time(new Date());
		branduserMapper.insertSelective(branduser);
		return ResultMap.build(200, "操作成功");
	}

	private Branduser checkbranduser(Branduser branduser) {
		BranduserExample example = new BranduserExample();
		BranduserExample.Criteria criteria = example.createCriteria();
		criteria.andBrandidEqualTo(branduser.getBrandid());
		criteria.andUseridEqualTo(branduser.getUserid());
		List<Branduser> users = branduserMapper.selectByExample(example);
		if (!users.isEmpty() && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	/**删除我的品牌
	 * @param brandid : 品牌ID
	 * **/
	public ResultMap deletemybrand(Long brandid) {
		Brand brand = new Brand();
		brand.setBrandid(brandid);
		brand.setState(3);
		brandMapper.updateByPrimaryKeySelective(brand);
		return ResultMap.build(200, "操作成功");
	}

	/** 编辑的查询
	 * @param brandid : 品牌ID
	 * **/
	public Brand searcheditbrand(Long brandid) {
		Brand brand = brandMapper.selectByPrimaryKey(brandid);

		return brand;
	}

	/**
	 * 编辑品牌
	 * @param Onepicture : 图片
	 * @param brandid : 品牌id
	 * @param Brand : 品牌名称
	 * @param Description : 描述
	 * @param Codes : 区域
	 * **/
	public ResultMap updatemybrand(Brand brand) {
		if (brand.getOnepicture() == null || "".equals(brand.getOnepicture())) {
			return ResultMap.build(400, "请插入图片");
		}
		if (brand.getUserid() == null) {
			return ResultMap.build(400, "请登录！");
		}
		if (brand.getBrand() == null || "".equals(brand.getBrand())) {
			return ResultMap.build(400, "品牌名称");
		}
		if (brand.getDescription() == null || "".equals(brand.getDescription())) {
			return ResultMap.build(400, "描述");
		}
		if (brand.getBrandid() == null) {
			return ResultMap.build(300, "数据不全");
		}

		// 校验是否有重名
		Brand search = checkbrand(brand);
		if (search != null) {
			return ResultMap.build(300, "品牌占用");
		}

		brand.setState(2);
		brandMapper.updateByPrimaryKey(brand);
		return ResultMap.build(200, "操作成功");
	}

	private Brand checkbrand(Brand brand) {
		BrandExample example = new BrandExample();
		BrandExample.Criteria criteria = example.createCriteria();
		criteria.andBrandEqualTo(brand.getBrand());
		if (brand.getBrandid() != null) {
			criteria.andBrandidNotEqualTo(brand.getBrandid());
		}
		criteria.andStateNotEqualTo(3);
		List<Brand> LIST = brandMapper.selectByExample(example);
		if (!LIST.isEmpty() && LIST.size() > 0) {
			return LIST.get(0);
		}
		return null;
	}

	
	public UserCustomer getusermessbyunionid(String unionid) {
		return userCustomerMapper.getusermessbyunionid(unionid);
	}

	// 我的收益count
	public int mylurnceCount(UserVo userVo) {
		return userCustomerMapper.mylurnceCount(userVo);
	}

	// 根据token校验用户是否存在
	public String checkaccesstoken(String token) {
		if (!"".equals(token) && token != null) {
			// 根据token 查询用户userid
			String userCustomer = userCustomerMapper.getuseridbytoken(token);
			return userCustomer;
		}
		return null;
	}

	/**根据城市查询查询我的品牌
	 * @param city : 城市名称
	 * @param userid : 用户主键
	 * **/
	public List<Brand> getmybranduserbycity(HouseVo houseVo) {
		return userCustomerMapper.getmybranduserbycity(houseVo);
	}

	@Override
	public UserCustomer getuserdetailbyphone(Long telephone) {
		UserCustomer userCustomer = userCustomerMapper.getUserMessage(telephone);
		// 如果用户压根儿不存在
		if (userCustomer == null) {
			if ((telephone + "").length() == 11) {
				// 我们可以自动建立平台用户
				User user = new User();
				user.setLatitude(0.1);
				user.setLongitude(0.1);
				user.setUpdate_time(new Date());
				user.setUserstatus("1");
				user.setPassword("1111");
				user.setTelephone(telephone);
				user.setCreate_time(new Date());
				insertuser(user);
				// userMapper.insertSelective(user);
				// 建立profile表数据
				Profile profile = new Profile();
				profile.setUser_name("qtc");
				profile.setAvatar("");
				profile.setUser_id(user.getUserid());
				profile.setCreate_time(new Date());
				insertprofile(profile);
				// profileMapper.insertSelective(profile);
				Vipcount vipcount = new Vipcount();
				vipcount.setUser_id(user.getUserid());
				vipcount.setBalance(0.0D);
				vipcount.setCount(200);
				vipcount.setCretime_time(new Date());
				vipcount.setIs_vip(0);
				vipcount.setAccount(0.0D);
				insertuservip(vipcount);
			}
			return userCustomerMapper.getUserMessage(telephone);
		}
		return userCustomer;
	}

	@Override
	public int getmybranduserCount(UserVo userVo) {
		// TODO Auto-generated method stub
		return userCustomerMapper.getmybranduserCount(userVo);
	}

	@Override
	public String getaccessurl_name(String url) {
		// TODO Auto-generated method stub
		AccessExample example = new AccessExample();
		AccessExample.Criteria criteria = example.createCriteria();
		criteria.andAccessurlEqualTo(url);
		List<Access> list = accessMapper.selectByExample(example);
		if (list.size() == 1) {
			return list.get(0).getAccessname();
		}
		return "";
	}

	@Override
	public List<User> searchalluser() {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(null);
	}


	@Override
	public UserCustomer getusermessbypassword(Long telephone) {
		// TODO Auto-generated method stub
		return userCustomerMapper.getUserMessage(telephone);
	}

	@Override
	public ResultMap changeloginword(String password, Long telephone, String code) {
		// 获取验证码 type =3表示更改手机号码
		if (telephone == null) {
			return ResultMap.build(100,"输入电话号码");
		}
		Code code_search = getcheckcode("3", telephone);
		if (code_search == null) {
			return ResultMap.build(101, "验证码失效");
		}
		String code_get = "";
		if (code != null && !"".equals(code)) {
			code_get = getBASE64(code);
		}
		if (!code_search.getCode().equals(code_get)) {
			return ResultMap.build(102,"验证码错误");
		}
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		criteria.andTelephoneEqualTo(telephone);
		List<User> usersearch = userMapper.selectByExample(example);
		if (usersearch.isEmpty() || usersearch.size() < 0) {return ResultMap.build(400, "用户不存在");}
		User userupdate = usersearch.get(0);
		userupdate.setPassword(password);
		userMapper.updateByPrimaryKeySelective(userupdate);
		return ResultMap.build(200, "修改成功");	
	}

	/**查询提现的信息**/
	public UserCustomer checkcash(Long userid) {
		// TODO Auto-generated method stub
		if (userid == null) {return null;}
		return userCustomerMapper.checkcash(userid);
	}

	@Override
	public void updateUserSelective(User userupdate) {
		// TODO Auto-generated method stub
		userMapper.updateByPrimaryKeySelective(userupdate);
	}


	


}
