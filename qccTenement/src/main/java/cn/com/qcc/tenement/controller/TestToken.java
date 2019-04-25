package cn.com.qcc.tenement.controller;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.Group;
import org.apache.solr.client.solrj.response.GroupCommand;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import cn.com.qcc.common.DateUtil;
import cn.com.qcc.common.IDUtils;
import cn.com.qcc.common.KeyWordUtil;
import cn.com.qcc.common.PayCommonConfig;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.common.SendGongZongUtil;
import cn.com.qcc.common.WxTemplate;
import cn.com.qcc.detailcommon.WX_UserUtil;
import cn.com.qcc.mymapper.UserCustomerMapper;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.service.PosterCreateService;
import cn.com.qcc.service.SmallRoutineService;
import cn.com.qcc.service.solrdao.HouseSolrDao;
import net.sf.json.JSONObject;
import weixin.util.MD5Util;
import weixin.util.MyX509TrustManager;
import weixin.util.TemplateData;
import weixin.util.WxMssVo;

@Controller
public class TestToken {

	@Autowired
	HouseSolrDao houseSolrDao;
	@Autowired
	SmallRoutineService smallRoutineService;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	UserCustomerMapper userCustomerMapper;

	public static void main (String [] args) 
	{
		String openid = "oYQk1xOU_re4F2bIbTfRvSgTh42k";
		String template_id = "-zFaBpcCPoHNSmJSPzLkrhKHIH5-rPSLU9bwrV7ebNA";
		String url = "https://www.zzw777.com/download.html";
		WxTemplate template = new WxTemplate();
		template.setTemplate_id(template_id);
		template.setTouser(openid);
		KeyWordUtil keyWordUtil = new KeyWordUtil();
		keyWordUtil.setKeyword1("1");
		keyWordUtil.setKeyword2("2");
		keyWordUtil.setKeyword3("3");
		keyWordUtil.setKeyword4("4");
		keyWordUtil.setTitle("title");
		keyWordUtil.setRemark("remark");
		SendGongZongUtil.SendMess(template, keyWordUtil);
		//senMsg(openid);
	}
	
	@RequestMapping("/mess")
	public  void send(String openid, String formid) {
		String sendUserids = "10001765";
		List<String> list = userCustomerMapper.getWeixinOpendId(sendUserids);
		for (String string : list) {
			System.out.println(string);
		}
		/*String temid = PayCommonConfig.QCC_PAY_SUCCESS_TEMID;
		String type = "qcc";
		WxMssVo wxMssVo = new WxMssVo();
		wxMssVo.setTouser(openid);// 用户openid
		wxMssVo.setTemplate_id(temid);// 模版id
		wxMssVo.setForm_id(formid);// formid
		// 添加数据集合
		Map<String, TemplateData> m = new HashMap<>();

		TemplateData keyword1 = new TemplateData();
		keyword1.setValue("110111");
		m.put("keyword1", keyword1);

		TemplateData keyword2 = new TemplateData();
		keyword2.setValue("700");
		m.put("keyword2", keyword2);
		wxMssVo.setData(m);

		TemplateData keyword3 = new TemplateData();
		Date current = new Date();
		String date = DateUtil.DateToStr(DateUtil.yyyy_MM_dd_HH_mm, current);
		keyword3.setValue(date);
		m.put("keyword3", keyword3);
		wxMssVo.setData(m);
		smallRoutineService.pushOneUser(openid, formid, temid, wxMssVo, type, restTemplate);*/

	}

	
	
	
	
	
	public static void senMsg(String openId ) { 
		String ACCESS_TOKEN = MD5Util.getAccessToken(PayCommonConfig.qcc_gzhappid, PayCommonConfig.qcc_gzhsecret);// 获取AccessToken
		Integer state = WX_UserUtil.subscribeState(openId  ,ACCESS_TOKEN);
		String temid = "-zFaBpcCPoHNSmJSPzLkrhKHIH5-rPSLU9bwrV7ebNA";
		WxTemplate template= new WxTemplate();
		template.setUrl("https://www.zzw777.com/download.html");
		template.setTouser(openId);
		template.setTopcolor("#000000");
		template.setTemplate_id(temid);
		Map<String,TemplateData> m = new HashMap<String,TemplateData>();
		TemplateData first = new TemplateData();
		first.setColor("#8B8378");
		String title = "尊敬的用户你好,你位于植物园路 337 的房间 已在线被预订 <image src='http://www.hadoop.zzw777.com/154285959284445.png'/>";
		first.setValue(title);
		m.put("first", first);
		TemplateData name = new TemplateData();
		name.setColor("#000000");
		name.setValue("2014A [号房]");
		m.put("keyword1", name);
		TemplateData qixian = new TemplateData();
		qixian.setColor("#000000");
		qixian.setValue("半年起租");
		m.put("keyword2", qixian);
		TemplateData zujin = new TemplateData();
		zujin.setColor("#000000");
		zujin.setValue("1200元/月");
		m.put("keyword3", zujin);
		TemplateData dingjin = new TemplateData();
		dingjin.setColor("#000000");
		dingjin.setValue(" 500元");
		m.put("keyword4", dingjin);
		TemplateData remark = new TemplateData();
		remark.setColor("blue");
		remark.setValue("租户联系方式：18316999864,请前往房东APP.发布租约");
		//remark.setKeyword("keyword2");
		m.put("remark", remark);
		template.setData(m);
		//JSONObject.fromObject(t).toString()); //此处你应该代入自己的template
		JSONObject jsonobj = httpRequest("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+ACCESS_TOKEN+"", "POST",
				JSONObject.fromObject(template).toString());
		System.out.println(jsonobj);
	}

	public static JSONObject packJsonmsg(Map<String, TemplateData> param) {
		JSONObject json = new JSONObject();
		for (Map.Entry<String, TemplateData> entry : param.entrySet()) {
			JSONObject keyJson = new JSONObject();
			TemplateData dta = entry.getValue();
			keyJson.put("value", dta.getValue());
			keyJson.put("color", dta.getColor());
			json.put(entry.getKey(), keyJson);
		}
		return json;
	}

	/**
	 * 封装模板详细信息
	 * 
	 * @return
	 */
	/*
	 * public static JSONObject packJsonmsg(Map<String, TemplateData> param) {
	 * JSONObject json = new JSONObject(); for (Map.Entry<String, TemplateData>
	 * entry : param.entrySet()) { JSONObject keyJson = new JSONObject();
	 * TemplateData dta = entry.getValue(); keyJson.put("value",
	 * dta.getValue()); keyJson.put("color", dta.getColor());
	 * json.put(entry.getKey(), keyJson); } return json; }
	 * 
	 * 
	 *//**
		 * public static void main(String[] args) {
		 * 
		 * try {
		 * 
		 * //1、创建一个连接工厂对象，需要指定服务的ip及端口。 ConnectionFactory connectionFactory =
		 * new ActiveMQConnectionFactory("tcp://120.24.43.56:8020");
		 * //2、使用工厂对象创建一个Connection对象。 Connection connection =
		 * connectionFactory.createConnection();
		 * //3、开启连接，调用Connection对象的start方法。 connection.start();
		 * //4、创建一个Session对象。 //第一个参数：是否开启事务。如果true开启事务，第二个参数无意义。一般不开启事务false。
		 * //第二个参数：应答模式。自动应答或者手动应答。一般自动应答。 Session session =
		 * connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		 * //5、使用Session对象创建一个Destination对象。两种形式queue、topic，现在应该使用queue Queue
		 * queue = session.createQueue("test-queue");
		 * //6、使用Session对象创建一个Producer对象。 MessageProducer producer =
		 * session.createProducer(queue); //7、创建一个Message对象，可以使用TextMessage。
		 * /*TextMessage textMessage = new ActiveMQTextMessage();
		 * textMessage.setText("hello Activemq"); TextMessage textMessage =
		 * session.createTextMessage("hello activemq"); //8、发送消息
		 * producer.send(textMessage); //9、关闭资源 producer.close();
		 * session.close(); connection.close();
		 * 
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 **/
	/*
	
	
	
	
	
	*//** 自定义进制（选择你想要的进制数，不能重复且最好不要0、1这些容易混淆的字符） */
	/*
	 * private static final char[] r=new char[]{'q', 'w', 'e', '8', 's', '2',
	 * 'd', 'z', 'x', '9', 'c', '7', 'p', '5', 'k', '3', 'm', 'j', 'u', 'f',
	 * 'r', '4', 'v', 'y', 't', 'n', '6', 'b', 'g', 'h'};
	 * 
	 *//** 定义一个字符用来补全邀请码长度（该字符前面是计算出来的邀请码，后面是用来补全用的） */
	/*
	 * private static final char b='a';
	 * 
	 *//** 进制长度 */
	/*
	 * private static final int binLen=r.length;
	 * 
	 *//** 邀请码长度 */
	/*
	 * private static final int s=6;
	 * 
	 *//**
		 * 根据ID生成随机码
		 * 
		 * @param id
		 *            ID
		 * @return 随机码
		 */

	/*
	 * public static String toSerialCode(long id) { char[] buf=new char[32]; int
	 * charPos=32;
	 * 
	 * while((id / binLen) > 0) { int ind=(int)(id % binLen);
	 * buf[--charPos]=r[ind]; id /= binLen; } buf[--charPos]=r[(int)(id %
	 * binLen)]; String str=new String(buf, charPos, (32 - charPos)); //
	 * 不够长度的自动随机补全 if(str.length() < s) { StringBuilder sb=new StringBuilder();
	 * sb.append(b); Random rnd=new Random(); for(int i=1; i < s - str.length();
	 * i++) { sb.append(r[rnd.nextInt(binLen)]); } str+=sb.toString(); } return
	 * str; }
	 * 
	 * 
	 * public static void main (String [] args) { List<String> list = new
	 * ArrayList<>() ; long begin = 80000000; long end = 99999999;
	 * 
	 * 
	 * String serialCode = toSerialCode(begin); System.out.println(serialCode);
	 * 
	 * 
	 * }
	 * 
	 *//**
		 * 根据随机码生成ID
		 * 
		 * @param 随机码
		 * @return ID
		 *//*
		 * public static long codeToId(String code) { char
		 * chs[]=code.toCharArray(); long res=0L; for(int i=0; i < chs.length;
		 * i++) { int ind=0; for(int j=0; j < binLen; j++) { if(chs[i] == r[j])
		 * { ind=j; break; } } if(chs[i] == b) { break; } if(i > 0) { res=res *
		 * binLen + ind; } else { res=ind; } } return res; }
		 * 
		 * 
		 */

	@Autowired
	PosterCreateService posterCreateService;
	@Resource
	private SolrServer houseSolrServer;

	@RequestMapping("/tts")
	@ResponseBody
	public ResultMap testtoke(String filePath, String onePicture, Long houseid) throws SolrServerException {

		// 创建solrQuery对象
		SolrQuery query = new SolrQuery();
		query.set("q", "*:*");
		/* 分组 */
		// 是否分组
		query.setParam("group", true);
		// 分组的字段，不可以是多值字段
		query.setParam("group.field", "buildingid");
		// 分组中每个组的上限数量，默认为1
		query.setParam("group.limit", "1");
		// 分布式模式使用分组，并返回分组数量
		query.setParam("group.ngroups", "true");
		// 设置start，开始的组
		query.setStart(0);
		// 设置rows，返回多少组
		query.setRows(1000);
		// 执行搜索，返回response对象
		QueryResponse rq = houseSolrServer.query(query);
		// 从response中获取想要的结果，因为结构与正常搜索的结构不一致，所以取数据时与普通搜索获取数据不一样
		GroupResponse groupResponse = rq.getGroupResponse();
		List<GroupCommand> groupCommandList = groupResponse.getValues();
		SolrDocumentList solrDocumentList = new SolrDocumentList();
		long count = 0;
		long groupNum = 0;
		// 判断是否为空
		if (groupCommandList != null && groupCommandList.size() > 0) {
			// 匹配出的结果总数
			count = groupCommandList.get(0).getMatches();
			// 分组总数
			groupNum = groupCommandList.get(0).getNGroups();
			List<Group> groupList = groupCommandList.get(0).getValues();
			// 遍历返回的每个分组
			for (Group group : groupList) {
				// 若为普通搜索的结果则只有一条；若为分组详情则只有一组，将一组全部放入
				for (SolrDocument solrDocument : group.getResult()) {
					// 将分组中的数放入最后一个参数
					solrDocument.addField("numFound", group.getResult().getNumFound());
					// 每个分组只取第一个
					solrDocumentList.add(solrDocument);
				}
			}
		}

		List<HouseCustomer> itemList = new ArrayList<>();
		for (SolrDocument solrDocument : solrDocumentList) {
			HouseCustomer item = new HouseCustomer();
			// id 主键
			item.setHouseid((Long) solrDocument.get("houseid"));
			// 距离
			/*
			 * item.setJuli(IDUtils.doubletoint((double)
			 * solrDocument.get("juli"), 1000));
			 */

			// 一张图片
			item.setOnepicture((String) solrDocument.get("onepicture"));
			// 地铁路线
			item.setMetroname((String) solrDocument.get("metroname"));
			// 地铁站点
			item.setFinalstop((String) solrDocument.get("finalstop"));
			// 价格
			item.setPrices(IDUtils.doubletoint((Double) solrDocument.get("prices"), 1) + "");
			item.setPricetype((String) solrDocument.get("pricetype"));
			// 价格单位
			item.setAvatar((String) solrDocument.get("avatar"));
			// 是否可以预定...
			item.setSchedule(Integer.parseInt((String) solrDocument.get("schedule")));
			// 品牌名称
			item.setBrand((String) solrDocument.get("brand"));
			// 品牌名称
			item.setUpdate_time((Date) solrDocument.get("update_time"));
			System.out.println(solrDocument.get("buildingid"));
			// 用户id
			item.setUserid((Long) solrDocument.get("userid") + "");
			item.setUser_id((Long) solrDocument.get("userid"));
			item.setBuilding((String) solrDocument.get("building"));
			item.setVillagename((String) solrDocument.get("villagename"));
			item.setArea((Double) solrDocument.get("area"));
			item.setApartmentname((String) solrDocument.get("apartmentname"));
			itemList.add(item);
		}

		return ResultMap.IS_200(itemList);

	}
	
	
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
		// 创建SSLContext对象，并使用我们指定的信任管理器初始化
		TrustManager[] tm = { new MyX509TrustManager() };
		SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
		sslContext.init(null, tm, new java.security.SecureRandom());
		// 从上述SSLContext对象中得到SSLSocketFactory对象
		SSLSocketFactory ssf = sslContext.getSocketFactory();

		URL url = new URL(requestUrl);
		HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
		httpUrlConn.setSSLSocketFactory(ssf);

		httpUrlConn.setDoOutput(true);
		httpUrlConn.setDoInput(true);
		httpUrlConn.setUseCaches(false);
		// 设置请求方式（GET/POST）
		httpUrlConn.setRequestMethod(requestMethod);

		if ("GET".equalsIgnoreCase(requestMethod))
		httpUrlConn.connect();

		// 当有数据需要提交时
		if (null != outputStr) {
		OutputStream outputStream = httpUrlConn.getOutputStream();
		// 注意编码格式，防止中文乱码
		outputStream.write(outputStr.getBytes("UTF-8"));
		outputStream.close();
		}

		// 将返回的输入流转换成字符串
		InputStream inputStream = httpUrlConn.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
		buffer.append(str);
		}
		bufferedReader.close();
		inputStreamReader.close();
		// 释放资源
		inputStream.close();
		inputStream = null;
		httpUrlConn.disconnect();
		jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
		ce.printStackTrace();
		} catch (Exception e) {
		e.printStackTrace();
		}
		return jsonObject;
		}

}
