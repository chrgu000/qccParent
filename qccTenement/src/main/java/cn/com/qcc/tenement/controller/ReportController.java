package cn.com.qcc.tenement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Report;
import cn.com.qcc.pojo.Reportdetail;
import cn.com.qcc.service.ReportService;


@Controller
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	
	//查询房源举报的类目名称
	@RequestMapping("/reportlist/{fatherid}")
	@ResponseBody
	public ResultMap housereport(@PathVariable Integer fatherid) {
		List<Report> housereport= reportService.housereport(fatherid);
		return ResultMap.IS_200(housereport);
	}
	
	// 发布举报
	@RequestMapping("/addreportdetail")
	@ResponseBody
	public ResultMap addreportdetail(Reportdetail reportdetail){
		ResultMap resultMap = reportService.addreportdetail(reportdetail);
		return resultMap;
	}

}
