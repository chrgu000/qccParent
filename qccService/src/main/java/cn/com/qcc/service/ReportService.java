package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Report;
import cn.com.qcc.pojo.Reportdetail;

public interface ReportService {
	
	//根据上级ID查询举报的类目
	List<Report> housereport(Integer fatherid);
	
	//发布举报信息
	ResultMap addreportdetail(Reportdetail reportdetail);

}
