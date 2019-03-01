package cn.com.qcc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.ReportMapper;
import cn.com.qcc.mapper.ReportdetailMapper;
import cn.com.qcc.pojo.Report;
import cn.com.qcc.pojo.ReportExample;
import cn.com.qcc.pojo.Reportdetail;
import cn.com.qcc.service.ReportService;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

	@Autowired
	ReportMapper reportMapper;
	@Autowired
	ReportdetailMapper reportdetailMapper;
	//根据上一级的ID 查询举报的类目
	public List<Report> housereport(Integer fatherid) {
		if (fatherid == null || fatherid >11 ) {return null;}
		ReportExample example = new ReportExample();
		ReportExample.Criteria criteria = example.createCriteria();
		criteria.andFatheridEqualTo(fatherid);
		List<Report> reports = reportMapper.selectByExample(example);
		return reports;
	}
	@Override
	public ResultMap addreportdetail(Reportdetail reportdetail) {
		if(reportdetail.getUserid() == null){return ResultMap.build(404, "没有登录");}
		if (reportdetail.getReportids() == null||"".equals(reportdetail.getReportids())) {return ResultMap.build(500, "类目空");}
		if (reportdetail.getOtherid() == null) {return ResultMap.build(500, "选择举报的物品");}
		reportdetail.setCreate_time(new Date()); //设置举报的时间
		reportdetail.setState(1); //刚上的举报待后台处理结果
		reportdetailMapper.insertSelective(reportdetail);
		return ResultMap.build(200,"您的举报信息已经提交,请耐心等待我们的处理结果！");
	}

}
