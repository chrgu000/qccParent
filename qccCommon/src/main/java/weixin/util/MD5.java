package weixin.util;

import java.security.MessageDigest;

/**
 * User: rizenguo
 * Date: 2014/10/23
 * Time: 15:43
 */
public class MD5 {
    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7",
            "8", "9", "a", "b", "c", "d", "e", "f"};
    private static final char hexdig[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 转换字节数组为16进制字串
     * @param b 字节数组
     * @return 16进制字串
     */
    public static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (byte aB : b) {
            resultSb.append(byteToHexString(aB));
        }
        return resultSb.toString();
    }

    /**
     * 转换byte到16进制
     * @param b 要转换的byte
     * @return 16进制格式
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * MD5编码
     * @param origin 原始字符串
     * @return 经过MD5加密之后的结果
     */
    public static String MD5Encode(String origin) {
        String resultString = null;
        try {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultString;
    }
    
    /*
     * 先转为utf-8
     * */
     public static String MD5Encoding(String s) {
         byte[] btInput = null;
         try {
             btInput = s.getBytes("UTF-8");
         }catch (Exception e){
         }
         return MD5(btInput, 32);
     }
     public static String MD5(String s) {
         byte[] btInput = s.getBytes();
         return MD5(btInput, 32);
     }
     
     public static String MD5_16(String str) {
         byte[] btInput = str.getBytes();
         return MD5(btInput, 16);
     }
     
     private static String MD5(byte[] btInput, int length) {
         try {
             // 获得MD5摘要算法的 MessageDigest 对象
             MessageDigest mdInst = MessageDigest.getInstance("MD5");
             // MessageDigest mdInst = MessageDigest.getInstance("SHA-1");
             // 使用指定的字节更新摘要
             mdInst.update(btInput);
             // 获得密文
             byte[] md = mdInst.digest();
             // 把密文转换成十六进制的字符串形式
             int j = md.length;
             char str[] = new char[j * 2];
             int k = 0;
             for (byte byte0 : md) {
                 str[k++] = hexdig[byte0 >>> 4 & 0xf];
                 str[k++] = hexdig[byte0 & 0xf];
             }
             String result = new String(str);
             return length == 16 ? result.substring(8, 24) : result;
         } catch (Exception e) {
             e.printStackTrace();
             return null;
         }
     }


}

