package cn.com.qcc.detailcommon;

public class GetDistince {

	public static Integer Distance(double long1, double lat1, double long2,  
	        double lat2) {  
	    double a, b, R;  
	    R = 6378137; // 地球半径  
	    lat1 = lat1 * Math.PI / 180.0;  
	    lat2 = lat2 * Math.PI / 180.0;  
	    a = lat1 - lat2;  
	    b = (long1 - long2) * Math.PI / 180.0;  
	    double d;  
	    double sa2, sb2;  
	    sa2 = Math.sin(a / 2.0);  
	    sb2 = Math.sin(b / 2.0);  
	    d = 2  
	            * R  
	            * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1)  
	                    * Math.cos(lat2) * sb2 * sb2));  
	    return Integer.parseInt( (d+"").substring(0,(d+"").lastIndexOf(".") )  );  
	} 


	
	public static void main(String[] args) {
		double latitude1 =22.6;
		double longitude1 = 114.2;
		double latitude2 =22.0;
		double longitude2 = 114.0;
		
		Integer s = GetDistince.Distance(longitude1, latitude1, longitude2, latitude2);
	}
}