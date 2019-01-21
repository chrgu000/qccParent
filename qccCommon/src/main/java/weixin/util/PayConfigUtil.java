package weixin.util;

public class PayConfigUtil {
	// 初始化
	public final static String APP_ID = "wx37a5a7281317047a"; // 公众账号appid（改为自己实际的）
	public final static String APP_SECRET = "0949f5a62f702d5c5862b8478425e157";
	public final static String MCH_ID = "1490776702"; // 商户号（改为自己实际的）
	public final static String API_KEY = "123456789101112131415139399300Sz"; // （改为自己实际的）key设置路径：微信商户平台(pay.weixin.qq.com)-->账户设置-->API安全-->密钥设置
	// 有关url
	public final static String UFDODER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
	public final static String NOTIFY_URL = "http://www.zzw777.com/weixin/return"; // 微信支付回调接口，就是微信那边收到（改为自己实际的）
	// 企业向个人账号付款的URL
	public final static String SEND_EED_PACK_URL = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers";
	public final static String CREATE_IP = "120.24.43.56";// 发起支付ip（改为自己实际的）
	public final static String NICK_NAME = "七彩巢"; // 提供方名称
	// public final static String SEND_NAME = "七彩巢"; //商户名称
	// public final static String WISHING = "CNM"; //红包祝福
	public final static String CLIENT_IP = "120.24.43.56";
	// public final static String ACT_NAME = "CNM"; //活动名称
	// public final static String REMARK = "CNM"; //备注
	public final static int HONGBAO_MAX_VALUE = 100; // 红包最大金额 单位：分
	public final static int HONGBAO_MIN_VALUE = 100; // 红包最小金额 单位：分
	public final static int FAIL = 0; // 失败
	public final static int TOTAL_NUM = 1; // 红包发放人数
	public final static int SUCCESS = 1; // 成功
	public final static int LOCK = 2; // 已在余额表中锁定该用户的余额，防止领取的红包金额大于预算

}
