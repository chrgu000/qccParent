package cn.com.qcc.service;

import javax.servlet.http.HttpServletRequest;


public class ContentPath {
	
	/**获取图片路径**/
	public static String SearchImageContentPath (HttpServletRequest request) {
		String contentPath =  request.getSession().getServletContext().getRealPath("/img");
		contentPath = contentPath.replace("\\", "/");
		return contentPath+"/";
	}
	

}
