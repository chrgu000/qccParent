package cn.com.qcc.common;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CheckDataUtil {
	
	/***校验数据不存在 
	 * @param obj: 参数
	 * @return : 如果是空 需要做逻辑处理 返回 true
	 *         : 如果不是空 数据校验通过  false**/
	@SuppressWarnings("rawtypes")
	public static boolean checkisEmpty(Object obj) {
		if (obj == null || "".equals(obj) || "undefined".equals(obj)||
			"null".equals(obj)||	"NaN".equals(obj)) {
			return true ;
		}
		if (obj instanceof Collection) 
			{
				Collection list = (Collection)obj;
				if (list.isEmpty() || list.size()==0) 
					{return true ;}
			}
		return false;
	}
	
	
	
	/***校验数据存在 
	 * @param str: 参数
	 * @return : 如果是空 需要做逻辑处理 返回 false
	 *         : 如果不是空 数据校验通过  true**/
	@SuppressWarnings("rawtypes")
	public static boolean checkNotEmpty(Object obj) {
		if (obj == null || "".equals(obj) || "undefined".equals(obj)||
			"null".equals(obj)||	"NaN".equals(obj)) {
			return false ;
		}
		if (obj instanceof Collection) 
		{
			Collection list = (Collection)obj;
			if (list.isEmpty() || list.size()==0) 
				{return false ;}
		}
		return true;
	}
	/**校验数据不等于某一个值
	 * 
	 * 
	 * **/
	public static boolean checkNotEqual(Object a ,Object b){
		
		// 如果其中一个数据失效则返回true表示 数据不完整
		if (a ==null || b==null || "".equals(a) || "".equals(b) || "null".equals(a) || "null".equals(b)
				|| "undefined".equals(a) || "undefined".equals(b)) {
			return true ;
		}
		// 判断两个数据的值是否一致
		return !a.toString().equals(b.toString());
		
	}
	
	
	/**校验数据不等于某一个值
	 * 
	 * 
	 * **/
	public static boolean checkisEqual(Object a ,Object b){
		
		// 如果其中一个数据失效则返回true表示 数据不完整
		if (a ==null || b==null || "".equals(a) || "".equals(b) || "null".equals(a) || "null".equals(b)
				|| "undefined".equals(a) || "undefined".equals(b)) {
			return false ;
		}
		// 判断两个数据的值是否一致
		return a.toString().equals(b.toString());
		
	}
	
	public static String ConnetcionToString (List<String> strList) {
		String returns ="";
		if (CheckDataUtil.checkisEmpty(strList)) {return returns;}
		for (String sss : strList) {
			returns+=sss+",";
		}
		String okreturn = "";
		String [] charList = returns.split(",");
		for (int i=0;i<charList.length;i++) {
			if (!okreturn.contains(charList[i])) {
				okreturn +=charList[i]+",";
			}
		}
		return okreturn;
	}
	
	
	/**校验数据不匹配
	 * 不匹配 返回true
	 * 匹配 返回 false
	 * 为空 也返回ture
	 * **/
	@SuppressWarnings("unused")
	public static boolean checkNotMatrhNumber(Object a ,String replat){
		
		// 先判断obj 是否存在
		if (checkNotEmpty(a)) {
			String abc = a.toString();
			// 如果末尾还包含匹配符号 说明不匹配成功 正常返回true
			if (abc.endsWith(replat) || abc.startsWith(replat)) { return true ; }
			abc = abc.replace(replat, "");
			try {
				//如果
				Long s = Long.valueOf(abc);
			} catch (Exception e) {
				return true ;
			}
			return false ;
		}
		// 如果为空说明不匹配 返回true表示不匹配成功
		return true ;
		
	}
	
	
	 public static boolean checkNotEmaile(String emaile){
		 
		 if (CheckDataUtil.checkisEmpty(emaile))
			 return true ;
         /**
          *   ^匹配输入字符串的开始位置 
          *   $结束的位置
          *   \转义字符 eg:\. 匹配一个. 字符  不是任意字符 ，转义之后让他失去原有的功能
          *   \t制表符
          *   \n换行符
          *   \\w匹配字符串  eg:\w不能匹配 因为转义了
          *   \w匹配包括字母数字下划线的任何单词字符
          *   \s包括空格制表符换行符
          *   *匹配前面的子表达式任意次
          *   .小数点可以匹配任意字符
          *   +表达式至少出现一次
          *   ?表达式0次或者1次
          *   {10}重复10次
          *   {1,3}至少1-3次
          *   {0,5}最多5次
          *   {0,}至少0次 不出现或者出现任意次都可以 可以用*号代替
          *   {1,}至少1次  一般用+来代替
          *   []自定义集合     eg:[abcd]  abcd集合里任意字符
          *   [^abc]取非 除abc以外的任意字符
          *   |  将两个匹配条件进行逻辑“或”（Or）运算 
          *   [1-9] 1到9 省略123456789
          *    邮箱匹配 eg: ^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\.){1,3}[a-zA-z\-]{1,}$ 
          *          
          */
         String RULE_EMAIL = "^[A-Za-z0-9][\\w\\-\\.]{3,12}@([\\w\\-]+\\.)+[\\w]{2,3}$";
        		 //"^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
         //正则表达式的模式 编译正则表达式
         Pattern p = Pattern.compile(RULE_EMAIL);
         //正则表达式的匹配器
         Matcher m = p.matcher(emaile);
         //进行正则匹配\
         return ! m.matches();  
     }   
	 
 public static boolean checkIsEmaile(String emaile){
		 
		 if (CheckDataUtil.checkisEmpty(emaile))
			 return false ;
         /**
          *   ^匹配输入字符串的开始位置 
          *   $结束的位置
          *   \转义字符 eg:\. 匹配一个. 字符  不是任意字符 ，转义之后让他失去原有的功能
          *   \t制表符
          *   \n换行符
          *   \\w匹配字符串  eg:\w不能匹配 因为转义了
          *   \w匹配包括字母数字下划线的任何单词字符
          *   \s包括空格制表符换行符
          *   *匹配前面的子表达式任意次
          *   .小数点可以匹配任意字符
          *   +表达式至少出现一次
          *   ?表达式0次或者1次
          *   {10}重复10次
          *   {1,3}至少1-3次
          *   {0,5}最多5次
          *   {0,}至少0次 不出现或者出现任意次都可以 可以用*号代替
          *   {1,}至少1次  一般用+来代替
          *   []自定义集合     eg:[abcd]  abcd集合里任意字符
          *   [^abc]取非 除abc以外的任意字符
          *   |  将两个匹配条件进行逻辑“或”（Or）运算 
          *   [1-9] 1到9 省略123456789
          *    邮箱匹配 eg: ^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\.){1,3}[a-zA-z\-]{1,}$ 
          *          
          */
         String RULE_EMAIL = "^[A-Za-z0-9][\\w\\-\\.]{3,12}@([\\w\\-]+\\.)+[\\w]{2,3}$";
        		 //"^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
         //正则表达式的模式 编译正则表达式
         Pattern p = Pattern.compile(RULE_EMAIL);
         //正则表达式的匹配器
         Matcher m = p.matcher(emaile);
         //进行正则匹配\
         return m.matches();  
     }   

	
	
	
	
public static void main (String args []) {
		
	System.out.println(checkNotEmaile("1sfsd1@163.com"));
}


public static String DeleteExist(String append) {
	String resultAppend = "";
	if (CheckDataUtil.checkisEmpty(append)) {return resultAppend;}
	String [] charList = append.split(",");
	for (int i=0;i<charList.length;i++) {
		if (!resultAppend.contains(charList[i])) {
			resultAppend +=charList[i]+",";
		}
	}
	return resultAppend;
}



	/**校验文件不是视频类型的
	 * 如果校验通过返回true
	 * 如果校验不通过返回false
	 * AVI、WMV、RM、RMVB、MPEG1、MPEG2、MPEG4(MP4)、3GP、
	 * ASF、SWF、VOB、DAT、MOV、M4V、FLV、F4V、MKV、MTS、TS。
	 * 其他什么IMV、AMV、XV、QSV
	 * 
	 * **/
	public static boolean checkNotVideo(String lastName) {
		
		// 获取所有的视频格式
		String viewType= ".avi-.wmv-.rm-.rmvb-.mpeg1-.mpeg2-.mpeg4-.mp4-.3gp-.asf-.swf-.vob-.dat-.m4v-.flv-.f4v-.mkv"
				+"-.mts-.ts-.imv-.amv-.xv";
		
		//如果是空直接返回true表示非视频类型
		if (CheckDataUtil.checkisEmpty(lastName)) 
			return true ;
		//如果是MP4结尾的说明是视频文件 校验通过
		
		//lastName 在viewtype里面说明是视频文件校验 失败
		if (viewType.contains(lastName)) 
			return false;
		return true;
	}




}
