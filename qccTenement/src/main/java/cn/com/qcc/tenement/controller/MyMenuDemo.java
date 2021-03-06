package cn.com.qcc.tenement.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;

import cn.com.qcc.common.PayCommonConfig;
import weixin.util.FatherButton;
import weixin.util.MD5Util;
import weixin.util.MatchRule;
import weixin.util.Menu;
import weixin.util.SonButton;

/**
 * @author 高远</n> 邮箱：wgyscsf@163.com</n> 博客 http://blog.csdn.net/wgyscsf</n>
 *         编写时期 2016-4-6 下午8:44:43
 */
/*
 * 该类测试了直接获取Access_token和保存后判断Access_token存活时间后再获取两种方式【使用时，使用后者】。
 */
/*
 * 使用：createCommMenu()//常见自定义菜单；createSpecialMenuJson()//创建个性化菜单
 */
@Controller
public class MyMenuDemo {
	


	/*
	 * 创建自定义菜单。
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/menu")
	public void createCommMenu() {
		String ACCESS_TOKEN = MD5Util.getAccessToken(PayCommonConfig.qcc_gzhappid, PayCommonConfig.qcc_gzhsecret);// 获取AccessToken，AccessTokenUtils是封装好的类
		// 拼接api要求的httpsurl链接
		String urlString = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + ACCESS_TOKEN;
		try {
			// 创建一个url
			URL reqURL = new URL(urlString);
			// 拿取链接
			HttpsURLConnection httpsConn = (HttpsURLConnection) reqURL.openConnection();
			httpsConn.setDoOutput(true);
			// 取得该连接的输出流，以读取响应内容
			OutputStreamWriter osr = new OutputStreamWriter(httpsConn.getOutputStream());

			osr.write(getMenuJson());// 使用本类外部方法getMenuJson()
			osr.close();

			// 返回结果
			InputStreamReader isr = new InputStreamReader(httpsConn.getInputStream());
			// 读取服务器的响应内容并显示
			char[] chars = new char[1024];
			String reslut = "";
			int len;
			while ((len = isr.read(chars)) != -1) {
				reslut += new String(chars, 0, len);
			}
			isr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getMenuJson() {
		/*
		 * 任务（注释：“m-0”表示父按钮；“m-n”表示第m个父按钮，第n个子按钮（m,n≠0））：1-0：名字：click，响应点击事件：
		 * 点击推事件 。2-0：名
		 * 字:父按钮2。2-1：名字：view,响应事件：跳转网页；2-2：名字：scancode_push，响应事件：扫码推事件；2-
		 * 3：名字：scancode_waitmsg
		 * ，响应事件：扫码推事件且弹出“消息接收中”提示框；2-4：名字：pic_sysphoto，响应事件
		 * ：弹出系统拍照发图。2-5：名字：pic_photo_or_album，响应事件：弹出拍照或者相册发图。3-0：名
		 * 字:父按钮3。3-1：名字
		 * ：pic_weixin,响应事件：弹出微信相册发图器；3-2：名字：location_select，响应事件：弹出地理位置选择器
		 * ；3-3：名字：media_id
		 * ，响应事件：下发消息（除文本消息）；3-4：名字：view_limited，响应事件：跳转图文消息url。
		 */
		Gson gson = new Gson();// json处理工具

		Menu menu = new Menu();// 菜单类
		List<FatherButton> fatherButtons = new ArrayList<FatherButton>();// 菜单中的父按钮集合
		// -----------
		/*父按钮1
		FatherButton fb1 = new FatherButton();
		fb1.setName("附近房源");
		fb1.setUrl("https://www.zzw777.com/#");
		fb1.setType("view");*/ 
		
		FatherButton fb1 = new FatherButton();
		fb1.setName("附近房源");
		fb1.setType("miniprogram");
		fb1.setAppid(PayCommonConfig.qcc_xiaochengxuappid);
		fb1.setUrl("http://mp.weixin.qq.com");
		fb1.setPagepath("pages/nearbyMap/nearbyMap");
		

		// -------------
		// 父按钮2
		FatherButton fb2 = new FatherButton();
		fb2.setUrl("https://www.zzw777.com/#");
		fb2.setName("发布房源");
		fb2.setType("view");

		// ------------------
		// 父按钮3
		FatherButton fb3 = new FatherButton();
		fb3.setName("更多");
		List<SonButton> sonButtons3 = new ArrayList<SonButton>();

		// 子按钮3-1
		SonButton sb31 = new SonButton();
		sb31.setName("招聘信息");
		sb31.setKey("31");
		sb31.setType("click");
		// 子按钮3-2
		SonButton sb32 = new SonButton();
		sb32.setName("客服电话");
		sb32.setKey("32");
		sb32.setType("click");
		// // 子按钮3-3-->测试不了，因为要media_id。这需要调用素材id.
		SonButton sb33 = new SonButton();
		sb33.setName("绑定账号");
		sb33.setKey("33");
		//sb33.setUrl("https://www.zzw777.com/pages/qiuzulist.html");
		sb33.setType("click");

		SonButton sb34 = new SonButton();
		sb34.setName("发布求租");
		sb34.setUrl("https://www.zzw777.com/pages/qiuzu.html");
		sb34.setType("view");

		// 添加子按钮到子按钮队列
		sonButtons3.add(sb31);
		sonButtons3.add(sb32);
		sonButtons3.add(sb33);
		sonButtons3.add(sb34);

		// 将子按钮放到3-0父按钮队列
		fb3.setSonButtons(sonButtons3);
		// ---------------------

		// 将父按钮加入到父按钮集合
		fatherButtons.add(fb1);
		fatherButtons.add(fb2);
		fatherButtons.add(fb3);

		// 将父按钮队列加入到菜单栏
		menu.setFatherButtons(fatherButtons);
		String json = gson.toJson(menu);
		return json;

	}

	@SuppressWarnings("unused")
	public void createSpecialMenuJson() {

		String ACCESS_TOKEN = MD5Util.getAccessToken(PayCommonConfig.qcc_gzhappid, PayCommonConfig.qcc_gzhsecret);// 获取AccessToken
		// 拼接api要求的httpsurl链接
		String urlString = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=" + ACCESS_TOKEN;
		try {
			// 创建一个url
			URL reqURL = new URL(urlString);
			// 拿取链接
			HttpsURLConnection httpsConn = (HttpsURLConnection) reqURL.openConnection();
			httpsConn.setDoOutput(true);
			// 取得该连接的输出流，以读取响应内容
			OutputStreamWriter osr = new OutputStreamWriter(httpsConn.getOutputStream());
			osr.write(getSpecialMenuJson());
			osr.close();

			// 返回结果
			InputStreamReader isr = new InputStreamReader(httpsConn.getInputStream());
			// 读取服务器的响应内容并显示
			char[] chars = new char[1024];
			String reslut = "";
			int len;
			while ((len = isr.read(chars)) != -1) {
				reslut += new String(chars, 0, len);
			}
			isr.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getSpecialMenuJson() {
		/*
		 * 任务（注释：“m-0”表示父按钮；“m-n”表示第m个父按钮，第n个子按钮（m,n≠0））：1-0：名字：click，响应点击事件：
		 * 点击推事件 。2-0：名
		 * 字:父按钮2。2-1：名字：view,响应事件：跳转网页；2-2：名字：scancode_push，响应事件：扫码推事件；2-
		 * 3：名字：scancode_waitmsg
		 * ，响应事件：扫码推事件且弹出“消息接收中”提示框；2-4：名字：pic_sysphoto，响应事件
		 * ：弹出系统拍照发图。2-5：名字：pic_photo_or_album，响应事件：弹出拍照或者相册发图。3-0：名
		 * 字:父按钮3。3-1：名字
		 * ：pic_weixin,响应事件：弹出微信相册发图器；3-2：名字：location_select，响应事件：弹出地理位置选择器
		 * ；3-3：名字：media_id
		 * ，响应事件：下发消息（除文本消息）；3-4：名字：view_limited，响应事件：跳转图文消息URL。
		 */
		Gson gson = new Gson();// json处理工具

		Menu menu = new Menu();// 菜单
		List<FatherButton> fatherButtons = new ArrayList<FatherButton>();// 菜单中的父按钮集合
		// 父按钮1
		FatherButton fb1 = new FatherButton();
		fb1.setName("click");
		fb1.setType("click");
		fb1.setKey("10");
		// -----------
		// 父按钮2
		FatherButton fb2 = new FatherButton();
		List<SonButton> sonButtons2 = new ArrayList<SonButton>();
		fb2.setName("父按钮2");
		// ---------------
		// 子按钮2-1
		SonButton sb21 = new SonButton();
		sb21.setName("view");
		sb21.setUrl("http://www.baidu.com");
		sb21.setType("view");
		// 子按钮2-2
		SonButton sb22 = new SonButton();
		sb22.setName("scancode_push");
		sb22.setType("scancode_push");
		sb22.setKey("22");
		// 子按钮2-3
		SonButton sb23 = new SonButton();
		sb23.setName("scancode_waitmsg");
		sb23.setType("scancode_waitmsg");
		sb23.setKey("23");
		// 子按钮2-4
		SonButton sb24 = new SonButton();
		sb24.setName("pic_sysphoto");
		sb24.setType("pic_sysphoto");
		sb24.setKey("24");
		// 子按钮2-5
		SonButton sb25 = new SonButton();
		sb25.setName("pic_photo_or_album");
		sb25.setType("pic_photo_or_album");
		sb25.setKey("25");

		// 添加子按钮到子按钮队列
		sonButtons2.add(sb21);
		sonButtons2.add(sb22);
		sonButtons2.add(sb23);
		sonButtons2.add(sb24);
		sonButtons2.add(sb25);

		// 将子按钮放到2-0父按钮队列
		fb2.setSonButtons(sonButtons2);
		// ------------------
		// 父按钮3
		FatherButton fb3 = new FatherButton();
		List<SonButton> sonButtons3 = new ArrayList<SonButton>();
		fb3.setName("父按钮3");

		// 子按钮3-1
		SonButton sb31 = new SonButton();
		sb31.setName("pic_weixin");
		sb31.setType("pic_weixin");
		sb31.setKey("31");

		// 子按钮3-2
		SonButton sb32 = new SonButton();
		sb32.setName("locatselect");
		sb32.setType("location_select");
		sb32.setKey("32");
		// 这个按钮是为个性化按钮准备的
		SonButton sb33 = new SonButton();
		sb33.setName("女生22");
		sb33.setType("click");
		sb33.setKey("33");
		// // 子按钮3-4-->测试不了，因为要media_id。这需要调用素材id.
		// SonButton sb34 = new SonButton();
		// sb34.setName("view_limited");
		// sb34.setType("view_limited");
		// sb34.setMedia_id("???");
		// 添加子按钮到子按钮队列
		sonButtons3.add(sb31);
		sonButtons3.add(sb32);
		sonButtons3.add(sb33);
		// sonButtons3.add(sb34);
		// 将子按钮放到3-0父按钮队列
		fb3.setSonButtons(sonButtons3);
		// ---------------------

		// 将父按钮加入到父按钮队列
		fatherButtons.add(fb1);
		fatherButtons.add(fb2);
		fatherButtons.add(fb3);
		// 将父按钮队列加入到菜单栏
		menu.setFatherButtons(fatherButtons);

		// -----
		// 从此处开始设置个性菜单
		MatchRule matchrule = new MatchRule();
		matchrule.setSex("2");// 男生
		menu.setMatchrule(matchrule);

		// ----

		String json = gson.toJson(menu);
		return json;

	}
}
