package weixin.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class WbChat extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public WbChat() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 这里没有对发送信息者进行验证，直接返回了，要加验证的话自己去百度吧
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String echo = request.getParameter("echostr");
		echo = new String(echo.getBytes("ISO-8859-1"), "UTF-8");
		pw.println(echo);
		// 当你提交成为开发者的URL和Token时，微信服务器将发送GET请求到填写的URL上，
		// 只有你返回参数echostr时，他才会认为你这个接口是通的，才会提交成功
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 当你用微信给平台发送信息时就会到这里
		// 回复音乐和图文消息，我都写死了，自己可以根据自己的需要加相应的处理
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		String wxMsgXml = IOUtils.toString(request.getInputStream(), "utf-8");
		RequestTextMessage textMsg = null;
		try {
			textMsg = getRequestTextMessage(wxMsgXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
		StringBuffer replyMsg = new StringBuffer();
		String receive = textMsg.getContent().trim();
		String returnXml = null;

		if (textMsg != null && !receive.equals("")) {
			if (receive.equals("？") || receive.equals("?")) {

				replyMsg.append("欢迎使用微信平台！");
				replyMsg.append("\r\n1、当前时间");
				replyMsg.append("\r\n2、听音乐");
				replyMsg.append("\r\n3、看图文");
				replyMsg.append("\r\n其他、回音壁请直接输入文字信息");

				returnXml = getReplyTextMessage(replyMsg.toString(), textMsg.getFromUserName(),
						textMsg.getToUserName());

			} else if (receive.equals("2")) {

				// 回复音乐信息
				//returnXml = getReplyMusicMessage(textMsg.getFromUserName(), textMsg.getToUserName());

			} else if (receive.equals("3")) {

				// 回复图文
				//returnXml = getReplyTuwenMessage(textMsg.getFromUserName(), textMsg.getToUserName());

			} else if (receive.equals("1")) {

				// 回复时间
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

				replyMsg.append("当前时间\r\n" + df.format(new Date()));
				returnXml = getReplyTextMessage(replyMsg.toString(), textMsg.getFromUserName(),
						textMsg.getToUserName());

			} else {

				replyMsg.append("收到： " + textMsg.getContent());
				returnXml = getReplyTextMessage(replyMsg.toString(), textMsg.getFromUserName(),
						textMsg.getToUserName());

			}
		} else {

			replyMsg.append("别闹了，这谁看得懂啊！");
			returnXml = getReplyTextMessage(replyMsg.toString(), textMsg.getFromUserName(), textMsg.getToUserName());

		}
		pw.println(returnXml);
	}

	// 获取推送文本消息
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
