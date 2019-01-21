package weixin.util;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 操作txt工具类
 * @author liyizhong
 * @since 2016-08-11
 */
public class TxtUtil {
	
	/**
	 * 将数据写入到相关的文件地址里面
	 * @param dataSet
	 * @param file
	 */
	public static void writeToTxt(String content,String fileUrl){
		
		try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileUrl, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            if(StringUtils.isNotBlank(content)){
            	String s = "";
            	s = content+"\r\n";
            	randomFile.writeBytes(s);
            }
           
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
        	
        }
    }

	/**
	 * 将数据写入到相关的文件地址里面
	 * @param dataSet
	 * @param file
	 */
	@SuppressWarnings("rawtypes")
	public static void writeToTxt(Map dataMap,String fileUrl){
		
		try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileUrl, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            if(dataMap != null && dataMap.size() > 0){
            	String s = "";
            	String orderId = (String)dataMap.get("orderId");
            	s = orderId+"\r\n";
            	randomFile.writeBytes(s);
            }
           
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
        	
        }
    }
	
	
}
