package cn.com.qcc.tenement.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import cn.com.qcc.common.DateUtil;
import cn.com.qcc.common.PayCommonConfig;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.service.PosterCreateService;
import cn.com.qcc.service.SmallRoutineService;
import cn.com.qcc.service.solrdao.HouseSolrDao;
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
	
	
	@RequestMapping("/mess")
	public void send (String openid ,String formid) {
		String temid = PayCommonConfig.QCC_PAY_SUCCESS_TEMID;
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
		String date =DateUtil.DateToStr(DateUtil.yyyy_MM_dd_HH_mm, current);
		keyword3.setValue(date);
		m.put("keyword3", keyword3); 
		wxMssVo.setData(m);
		smallRoutineService.pushOneUser(openid, formid, temid , wxMssVo , type, restTemplate);
		
	}
	
	/*public static void main(String[] args) {
        //封装了推送实体类，别问我为什么一直封装，java三特性 继承 封装 多态
        wxsmallTemplate tem = new wxsmallTemplate();
        tem.setTemplateId("_yPJaTTc7zmPliitwUm0VY4wjRRvuVOdk57tA1Nggw0");
        //推送给哪位神仙。 这个是openId 不是UnionID 如果是unionId肯定推送不过去。
        tem.setToUser("oHi8u5dZc6whcGp8DpUv7h-iM12g");
        //fromId 这个炒鸡重要，没有他百分百推送不成功，fromId+openId 才能推送
        tem.setForm_id("679293f4f93c31e15d1f14dcf3f77d5a");
        //用户点击之后调到小程序哪个页面 找你们前段工程师提供即可
        tem.setPage("pages/welcome/welcome");
        //有封装了一个实体类 哈哈哈 这个是模板消息参数
        List<wxsmallTemplateParam> paras = new ArrayList<wxsmallTemplateParam>();
        //这个是满参构造 keyword1代表的第一个提示  红包已到账这是提示 #DC143C这是色值不过废弃了
        wxsmallTemplateParam templateParam = new wxsmallTemplateParam(
                "keyword1", "红包已到账", "#DC143C");
        //装进小参数结合中
        paras.add(templateParam);
        //我就不嘚瑟了 省点劲直接扔进去算了哈哈哈哈哈~~~~
        paras.add(new wxsmallTemplateParam("keyword2", "刘骞", ""));
        paras.add(new wxsmallTemplateParam("keyword3", "0.02元", "#DC143C"));
        paras.add(new wxsmallTemplateParam("keyword4", "成功成为您店铺的会员", ""));
        paras.add(new wxsmallTemplateParam("keyword5", "卓志海", ""));
        paras.add(new wxsmallTemplateParam("keyword6", "暂无推荐店铺", ""));
        paras.add(new wxsmallTemplateParam("keyword7", "红包已到您app账户，请尽快查询", "#0000FF"));
 
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date temp = new Date();
        String str = "";
        str = sdf.format(temp);
        paras.add(new wxsmallTemplateParam("keyword8", str, ""));
        //然后把所有参数扔到大的模板中
        tem.setTemplateParamList(paras);
        //模板需要放大的关键词，不填则默认无放大
        tem.setEmphasis_keyword("keyword1.DATA");
        //获取token凭证。
        //Token token = com.jiaewo.house.wxxcx.util.CommonUtil.getToken();
       
	}
	
	@RequestMapping("/tts")
	@ResponseBody
	public ResultMap testtoke(String openid) throws SolrServerException {
		jedisClient.set("ddd:", "aaaaaa");
		jedisClient.incr("ddd:") ;
		//senMsg( openid);
		houseSolrDao.queryAll();
		return ResultMap.IS_200();
	}

	static void senMsg(String openId) {
		// 用户是否订阅该公众号标识 (0代表此用户没有关注该公众号 1表示关注了该公众号)
		Integer state = WX_UserUtil.subscribeState(openId);
		if (state == 1) {
			// 绑定了微信并且关注了服务号的用户 , 注册成功-推送注册短信
			Map<String, TemplateData> param = new HashMap<>();
			param.put("first", new TemplateData("尊敬的用户你预定的房号1074房东已经确认,请合理的安排入住时间。", "#696969"));
			param.put("keyword1", new TemplateData("1074A", "#696969"));
			param.put("keyword2", new TemplateData("2017年05月06日", "#696969"));
			param.put("remark", new TemplateData("祝投生活愉快！", "#696969"));
			// 注册的微信-模板Id
			//openId = "o3AMB0c5QVaqTKVp6XOHMC9BYcUE";
			String regTempId = "q3P5tKU7dmHGQWMqerQXpwlDreyZ2ceftcxovZJd6rI";
			// 调用发送微信消息给用户的接口
			WX_TemplateMsgUtil.sendWechatMsgToUser(openId, regTempId, "", "#000000", packJsonmsg(param));
			
		}
		
		
	}

	*//**
	 * 封装模板详细信息
	 * 
	 * @return
	 *//*
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

	
	*//**
	public static void main(String[] args) {

		try {
			
			//1、创建一个连接工厂对象，需要指定服务的ip及端口。
			ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://120.24.43.56:8020");
			//2、使用工厂对象创建一个Connection对象。
			Connection connection = connectionFactory.createConnection();
			//3、开启连接，调用Connection对象的start方法。
			connection.start();
			//4、创建一个Session对象。
			//第一个参数：是否开启事务。如果true开启事务，第二个参数无意义。一般不开启事务false。
			//第二个参数：应答模式。自动应答或者手动应答。一般自动应答。
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			//5、使用Session对象创建一个Destination对象。两种形式queue、topic，现在应该使用queue
			Queue queue = session.createQueue("test-queue");
			//6、使用Session对象创建一个Producer对象。
			MessageProducer producer = session.createProducer(queue);
			//7、创建一个Message对象，可以使用TextMessage。
			/*TextMessage textMessage = new ActiveMQTextMessage();
			textMessage.setText("hello Activemq");
			TextMessage textMessage = session.createTextMessage("hello activemq");
			//8、发送消息
			producer.send(textMessage);
			//9、关闭资源
			producer.close();
			session.close();
			connection.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		**//*
	
	
	

	
	*//** 自定义进制（选择你想要的进制数，不能重复且最好不要0、1这些容易混淆的字符） *//*
    private static final char[] r=new char[]{'q', 'w', 'e', '8', 's', '2', 'd', 'z', 'x', '9', 'c', '7', 'p', '5', 'k', '3', 'm', 'j', 'u', 'f', 'r', '4', 'v', 'y', 't', 'n', '6', 'b', 'g', 'h'};
 
    *//** 定义一个字符用来补全邀请码长度（该字符前面是计算出来的邀请码，后面是用来补全用的） *//*
    private static final char b='a';
 
    *//** 进制长度 *//*
    private static final int binLen=r.length;
 
    *//** 邀请码长度 *//*
    private static final int s=6;
 
    *//**
     * 根据ID生成随机码
     * @param id ID
     * @return 随机码
     *//*
    public static String toSerialCode(long id) {
        char[] buf=new char[32];
        int charPos=32;
 
        while((id / binLen) > 0) {
            int ind=(int)(id % binLen);
            buf[--charPos]=r[ind];
            id /= binLen;
        }
        buf[--charPos]=r[(int)(id % binLen)];
        String str=new String(buf, charPos, (32 - charPos));
        // 不够长度的自动随机补全
        if(str.length() < s) {
            StringBuilder sb=new StringBuilder();
            sb.append(b);
            Random rnd=new Random();
            for(int i=1; i < s - str.length(); i++) {
            sb.append(r[rnd.nextInt(binLen)]);
            }
            str+=sb.toString();
        }
        return str;
    }
    
    
    public static void main (String [] args) {
    	List<String> list = new ArrayList<>() ; 
    	long begin = 80000000;
    	long end =   99999999;
    	
    	
    		String serialCode = toSerialCode(begin);
        	System.out.println(serialCode);
    
    	
    }
 
    *//**
     * 根据随机码生成ID
     * @param 随机码
     * @return ID
     *//*
    public static long codeToId(String code) {
        char chs[]=code.toCharArray();
        long res=0L;
        for(int i=0; i < chs.length; i++) {
            int ind=0;
            for(int j=0; j < binLen; j++) {
                if(chs[i] == r[j]) {
                    ind=j;
                    break;
                }
            }
            if(chs[i] == b) {
                break;
            }
            if(i > 0) {
                res=res * binLen + ind;
            } else {
                res=ind;
            }
        }
        return res;
    }

	
	*/
			
	@Autowired
	PosterCreateService posterCreateService;
	@RequestMapping("/tts")
	@ResponseBody
	public ResultMap testtoke(String filePath , String onePicture , Long houseid){
		String serialCode = "推荐码:GTASXG";
		String username="午行ベ缺氺™";
		String avatar = "https://wx.qlogo.cn/mmopen/vi_32/2KMbJq7nTZVtWHwGOUhSTa6kg2Hta7wKRtQHSdSYSWpILbMjgpS47UTD7sR8hR3yI9GVkic1XnibS4OH6FmLliaiaw/132";
		String backimageUrl = "https://www.zzw777.com/Tenement/img/backimage100001.png";
		
		String prices = "1800元/月";
		String apartmentname = "三室二厅";
		//String onePicture = "";
		//Long houseid = 7347l;
		try {
			//SimpleUpload.loadFileByFileUrl(filePath);
			//PosterUtils.createPoster(posterTitle, scene, moneyReward, username);
			//posterCreateService.createUserPoster(username, avatar, serialCode , backimageUrl);
			String detailName = "housedetail";
			posterCreateService.createHousePoster(prices, apartmentname, onePicture, houseid , detailName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResultMap.IS_200();
	}
	
	

}
