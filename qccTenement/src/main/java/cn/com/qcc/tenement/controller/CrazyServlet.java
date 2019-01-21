package cn.com.qcc.tenement.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpay.ext.kit.HttpKit;
import com.jpay.ext.kit.PaymentKit;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import cn.com.qcc.common.PayCommonConfig;
import cn.com.qcc.detailcommon.CommonUtil;
import cn.com.qcc.mapper.VipcountMapper;
import cn.com.qcc.pojo.Vipcount;
import cn.com.qcc.pojo.Weixinuserinfo;
import cn.com.qcc.queryvo.UserCustomer;
import cn.com.qcc.service.InteService;
import cn.com.qcc.service.ScanuserService;
import cn.com.qcc.service.UserService;
import cn.com.qcc.service.VipCountService;
import net.sf.json.JSONObject;
import weixin.util.MD5Util;
import weixin.util.ReplyTextMessage;
import weixin.util.RequestTextMessage;
import weixin.util.SignUtil;

@Controller
public class CrazyServlet extends HttpServlet {

	@Autowired
	ScanuserService scanuserService;
	@Autowired
	UserService userService;
	@Autowired
	InteService inteService;
	@Autowired
	VipCountService vipCountService;
	@Autowired
	VipcountMapper vipcountMapper;

	private static final long serialVersionUID = 5021188348833856475L;

	@RequestMapping("/crazyservlet")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("html/text;charset=utf-8");
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");
		PrintWriter out = response.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
		// out.close();
		// out = null;

		// 处理二维码扫描后事件
		docodescanke(request, response);
	}

	/*
	 * 取消关注 ： 微信二维码扫描后返回的FromUserName------->oYQk1xOU_re4F2bIbTfRvSgTh42k
	 * 微信二维码扫描后返回的CreateTime------->1514424885 微信二维码扫描后返回的MsgType------->event
	 * 微信二维码扫描后返回的EventKey-------> 微信二维码扫描后返回的Ticket------->null
	 * 微信二维码扫描后返回的Event------->unsubscribe 关注
	 * ：微信二维码扫描后返回的FromUserName------->oYQk1xOU_re4F2bIbTfRvSgTh42k
	 * 微信二维码扫描后返回的CreateTime------->1514424924 微信二维码扫描后返回的MsgType------->event
	 * 微信二维码扫描后返回的EventKey------->qrscene_1514 微信二维码扫描后返回的Ticket------->
	 * gQHi7zwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyWlR0MTRzeDljUjQxc0NiSGhxMWIAAgQmPkRaAwQAjScA
	 * 微信二维码扫描后返回的Event------->subscribe 再次关注：
	 * 微信二维码扫描后返回的FromUserName------->oYQk1xOU_re4F2bIbTfRvSgTh42k
	 * 微信二维码扫描后返回的CreateTime------->1514424983 微信二维码扫描后返回的MsgType------->event
	 * 微信二维码扫描后返回的EventKey------->1514 微信二维码扫描后返回的Ticket------->
	 * gQHi7zwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyWlR0MTRzeDljUjQxc0NiSGhxMWIAAgQmPkRaAwQAjScA
	 * 微信二维码扫描后返回的Event------->SCAN
	 */
	private void docodescanke(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String xmlMsg = HttpKit.readData(request);
		PrintWriter out = response.getWriter();
		Map<String, String> params = PaymentKit.xmlToMap(xmlMsg);
		// String FromUserName = params.get("FromUserName");
		// String CreateTime = params.get("CreateTime");
		String MsgType = params.get("MsgType");
		String fromUserName = params.get("FromUserName");
		String toUserName = params.get("ToUserName");
		String Content = params.get("Content");
		String Event = params.get("Event");
		String EventKey = params.get("EventKey");
		String code_str = "";
		String return_str = getReplyTextMessage(code_str, fromUserName, toUserName);
		if ("event".equals(MsgType)) {
			String accessToken = MD5Util.getAccessToken(PayCommonConfig.qcc_gzhappid, PayCommonConfig.qcc_gzhsecret);
			Weixinuserinfo user = getUserInfo(accessToken, fromUserName);
			String Ticket = params.get("Ticket");
			// 通过微信用户的唯一标识拿到userid
			UserCustomer checksearch = userService.getusermessbyunionid(user.getUnionid());
			user.setTicket(Ticket);
			// 这里说明是取消关注或者是没有关注
			if (EventKey == null || "".equals(EventKey)){
				if ("unsubscribe".equals(Event)) {
					user.setSubscribe(0);
					scanuserService.saveorupdateweixinuser(user);
				}
			}
			
			
			// 这里说明是关注公众号
			if (!"".equals(EventKey) && EventKey != "") {
				// 关注纵号
				if ("subscribe".equals(Event)) {
					// 保存或者刷新用户信息
					if (user.getOpenId() != null && !"".equals(user.getOpenId())) {
						scanuserService.saveorupdateweixinuser(user);
					}

					if (checksearch != null) {
						// 判断 是否已经通过关注获取积分事件
						boolean flag = inteService.isgetjinbibyevent( 9L ,checksearch.getUserid());
						// 如果是false 表示没有
						if (flag == false) {
							inteService.managebranch(9l, checksearch.getUserid() ,checksearch.getUserid()
									);
						}
					}

					code_str = "房东直租平台 ：\n 1,点击左下角\"附近房源\". \n 2,或点开网址：https://www.zzw777.com. "
							+ "\n 3,或直接打电话  :13714038879 ";
					return_str = getReplyTextMessage(code_str, fromUserName, toUserName);

				}
				// 再次进入公众号
				if ("SCAN".equals(Event)) {
					code_str = "房东直租平台 ：\n 1,点击左下角\"附近房源\". \n 2,或点开网址：https://www.zzw777.com. "
							+ "\n 3,或直接打电话  :13714038879 ";
					return_str = getReplyTextMessage(code_str, fromUserName, toUserName);
				}
				// 处理点击事件
				if ("CLICK".equals(Event)) {
					// 点击客服电话
					if ("32".equals(EventKey)) {
						code_str = "客服电话是： 137140338879";
						String str = new String(code_str.getBytes(), "utf-8");
						return_str = getReplyTextMessage(str, fromUserName, toUserName);
					}

					// 招聘信息
					if ("31".equals(EventKey)) {
						code_str = "物业管理员.\n 商务销售. \n 房产中介. \n 储备干部. \n 网站运营总监. \n 电子邮箱：wylsz800@sohu.com.\n招聘电话:13714559748  ";
						return_str = getReplyTextMessage(code_str, fromUserName, toUserName);
					}
					if ("33".equals(EventKey)) {
						code_str = "绑定失败,请先授权!";
						if (checksearch != null) {
							// 说明查到的信息。在判断是否绑定了提现账号
							if (checksearch.getWeixinaccount() != null && !"".equals(checksearch.getWeixinaccount())) {
								code_str = "当前微信已绑定：" + checksearch.getTelephone() + "为手机号," + "若要修改绑定信息。请先解绑!";
							} else {
								// 这是第一次做绑定
								Vipcount update = new Vipcount();
								update.setUser_id(checksearch.getUserid());
								update.setWeixinaccount(fromUserName);
								vipCountService.updateVipSelective(update);
								code_str = "恭喜绑定成功,手机号：" + checksearch.getTelephone();
							}

						}
						return_str = getReplyTextMessage(code_str, fromUserName, toUserName);
					}

				}
			}
		}

		// 关键字文本回复
		if ("text".equals(MsgType)) {
			if ("1".equals(Content)) {
				// 最新房源
				code_str = "https://www.zzw777.com/";
				return_str = getReplyTextMessage(code_str, fromUserName, toUserName);
			}
			if ("2".equals(Content)) {
				// 二手房
				code_str = "https://www.zzw777.com/pages/erShouHouse.html";
				return_str = getReplyTextMessage(code_str, fromUserName, toUserName);
			} else {
				code_str = "https://www.zzw777.com/pages/findHouseMan.html";
				return_str = getReplyTextMessage(code_str, fromUserName, toUserName);
			}

		}
		out.println(return_str);
	}

	@SuppressWarnings("unused")
	private Weixinuserinfo getUserInfo(String accessToken, String openId) {
		Weixinuserinfo weixinUserInfo = null;
		// 拼接请求地址
		String requestUrl = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID";
		requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		// 获取用户信息
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		if (null != jsonObject) {
			try {
				weixinUserInfo = new Weixinuserinfo();
				// 用户的标识
				weixinUserInfo.setOpenId(jsonObject.getString("openid"));
				weixinUserInfo.setUnionid(jsonObject.getString("unionid"));
				// 用户的标识
				// weixinUserInfo
				// jsonObject.getString("unionid"));
				// 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
				weixinUserInfo.setSubscribe(jsonObject.getInt("subscribe"));
				// 用户关注时间
				// weixinUserInfo.setSubscribeTime(jsonObject.getString("subscribe_time"));
				// 昵称
				weixinUserInfo.setNickname(jsonObject.getString("nickname"));
				// 用户的性别（1是男性，2是女性，0是未知）
				weixinUserInfo.setSex(jsonObject.getInt("sex"));
				// 用户所在国家
				weixinUserInfo.setCountry(jsonObject.getString("country"));
				// 用户所在省份
				weixinUserInfo.setProvince(jsonObject.getString("province"));
				// 用户所在城市
				weixinUserInfo.setCity(jsonObject.getString("city"));
				// 用户的语言，简体中文为zh_CN
				weixinUserInfo.setLanguage(jsonObject.getString("language"));
				// 用户头像
				weixinUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
			} catch (Exception e) {
				if (weixinUserInfo != null) {
					if (weixinUserInfo.getSubscribe() != null) {
						if (0 == weixinUserInfo.getSubscribe()) {
							// log.error("用户{}已取消关注",
							// weixinUserInfo.getOpenId());
						}
					}
				} else {
					int errorCode = jsonObject.getInt("errcode");
					String errorMsg = jsonObject.getString("errmsg");
					// log.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode,
					// errorMsg);
				}
			}
		}
		
		return weixinUserInfo;
	}

	// 获取推送文本消息
	@SuppressWarnings("unused")
	private RequestTextMessage getRequestTextMessage(String xml) {

		XStream xstream = new XStream(new DomDriver());

		xstream.alias("xml", RequestTextMessage.class);
		xstream.aliasField("ToUserName", RequestTextMessage.class, "toUserName");
		xstream.aliasField("FromUserName", RequestTextMessage.class, "fromUserName");
		xstream.aliasField("CreateTime", RequestTextMessage.class, "createTime");
		xstream.aliasField("MsgType", RequestTextMessage.class, "messageType");
		xstream.aliasField("Content", RequestTextMessage.class, "content");
		xstream.aliasField("MsgId", RequestTextMessage.class, "msgId");

		RequestTextMessage requestTextMessage = (RequestTextMessage) xstream.fromXML(xml);
		return requestTextMessage;
	}

	// 回复文本消息
	public String getReplyTextMessage(String content, String fromUserName, String toUserName) {

		ReplyTextMessage we = new ReplyTextMessage();
		we.setMessageType("text");
		we.setFuncFlag("0");
		we.setCreateTime(new Long(new Date().getTime()).toString());
		we.setContent(content);
		we.setToUserName(fromUserName);
		we.setFromUserName(toUserName);
		XStream xstream = new XStream(new DomDriver());
		xstream.alias("xml", ReplyTextMessage.class);
		xstream.aliasField("ToUserName", ReplyTextMessage.class, "toUserName");
		xstream.aliasField("FromUserName", ReplyTextMessage.class, "fromUserName");
		xstream.aliasField("CreateTime", ReplyTextMessage.class, "createTime");
		xstream.aliasField("MsgType", ReplyTextMessage.class, "messageType");
		xstream.aliasField("Content", ReplyTextMessage.class, "content");
		xstream.aliasField("FuncFlag", ReplyTextMessage.class, "funcFlag");
		String xml = xstream.toXML(we);
		return xml;
	}

}
