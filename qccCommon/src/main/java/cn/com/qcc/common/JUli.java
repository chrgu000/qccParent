package cn.com.qcc.common;

public class JUli {

	private static double EARTH_RADIUS = 6378.137;

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}

	public static double  getDistance(double lat1, double lng1, double lat2,
			double lng2) {
		double radLat1 = rad(lat1);
		double radLat2 = rad(lat2);
		double a = radLat1 - radLat2;
		double b = rad(lng1) - rad(lng2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(radLat1) * Math.cos(radLat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000d) / 10000d;
		s = s * 1000;
		return s;


	}
	
	public static void main (String [] args) {
		double  lat1Str = 22.72487;
		double  lng1Str = 114.27415;
		double  lat2Str = 22.725734;
		double  lng2Str=114.278280;
		double  sss =  getDistance( lat1Str,  lng1Str,  lat2Str,  lng2Str);
	}

}
