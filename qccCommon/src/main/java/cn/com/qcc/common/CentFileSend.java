package cn.com.qcc.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore;
import java.util.SortedMap;
import javax.net.ssl.SSLContext;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.jpay.ext.kit.PaymentKit;
/** 证书请求后的操作 **/
public class CentFileSend {

	/** 执行七彩租房证书后的操作 **/
	public static String qiye_fukuan(SortedMap<String, String> packageParams) {
		// ***********************企业付款请求*********************************
		StringBuilder sb = new StringBuilder();
		try {
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			// 证书的位置
			String certPath = PayCommonConfig.gzh_KEY_PATH;
			FileInputStream instream = new FileInputStream(new File(certPath));
			try {
				keyStore.load(instream, PayCommonConfig.qcc_gzh_mchid.toCharArray());
			} finally {
				instream.close();
			}
			// Trust own CA and all self-signed certs
			SSLContext sslcontext = SSLContexts.custom()
					.loadKeyMaterial(keyStore, PayCommonConfig.qcc_gzh_mchid.toCharArray()).build();
			// Allow TLSv1 protocol only
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" },
					null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			try {
				HttpPost httpPost = new HttpPost(PayCommonConfig.qiye_fukuan);
				httpPost.addHeader("Connection", "keep-alive");
				httpPost.addHeader("Accept", "*/*");
				httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				httpPost.addHeader("Host", "api.mch.weixin.qq.com");
				httpPost.addHeader("X-Requested-With", "XMLHttpRequest");
				httpPost.addHeader("Cache-Control", "max-age=0");
				httpPost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
				String dataXML = PaymentKit.toXml(packageParams);
				// WXPayUtil.mapToXml(data);
				httpPost.setEntity(new StringEntity(dataXML, "UTF-8"));


				CloseableHttpResponse response = httpclient.execute(httpPost);
				try {
					HttpEntity entity = response.getEntity();
					if (entity != null) {
						BufferedReader bufferedReader = new BufferedReader(
								new InputStreamReader(entity.getContent(), "UTF-8"));
						String text = "";
						while ((text = bufferedReader.readLine()) != null) {
							sb.append(text);
						}

					}
					EntityUtils.consume(entity);
				} finally {
					response.close();
				}
			} finally {
				httpclient.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return sb.toString();

	}

	/** 执行小程序退款证书操作 
	 * @param xmlparam : 封装的xml数据
	 * **/
	public static String house_refund(String xmlparam ) {
		StringBuilder sb = new StringBuilder();
		try {
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			String centPath = PayCommonConfig.gzh_KEY_PATH;
			FileInputStream instream = new FileInputStream(new File(centPath));
			// 公众平台商户号
			String mch_id = PayCommonConfig.qcc_gzh_mchid;
			try {
				keyStore.load(instream, mch_id.toCharArray());
			} finally {
				instream.close();
			}

			// 证书
			SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, mch_id.toCharArray()).build();
			// 只允许TLSv1协议
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" },
					null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			// 创建基于证书的httpClient,后面要用到
			CloseableHttpClient client = HttpClients.custom().setSSLSocketFactory(sslsf).build();

			HttpPost httpPost = new HttpPost(PayCommonConfig.refund_url);// 退款接口
			StringEntity reqEntity = new StringEntity(xmlparam);
			// 设置类型
			reqEntity.setContentType("application/x-www-form-urlencoded");
			httpPost.setEntity(reqEntity);
			CloseableHttpResponse response = client.execute(httpPost);
			try {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					BufferedReader bufferedReader = new BufferedReader(
							new InputStreamReader(entity.getContent(), "UTF-8"));
					String text = "";
					while ((text = bufferedReader.readLine()) != null) {
						sb.append(text);
					}
				}
				EntityUtils.consume(entity);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
