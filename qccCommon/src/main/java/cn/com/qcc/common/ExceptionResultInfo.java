package cn.com.qcc.common;


/**
 * 自定义系统异常类
 */
@SuppressWarnings("serial")
public class ExceptionResultInfo extends Exception {

	// 系统统一使用的结果类，包括了 提示信息类型和信息内容
	private ResultMap resultMap;

	public ResultMap getResultMap() {
		return resultMap;
	}

	public void setResultMap(ResultMap resultMap) {
		this.resultMap = resultMap;
	}
	
	public ExceptionResultInfo(ResultMap resultMap) {
		super(resultMap.getMsg());
		this.resultMap = resultMap;
	}


}
