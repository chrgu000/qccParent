package cn.com.qcc.service;

import java.util.List;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Sugges;
import cn.com.qcc.queryvo.SuggesCustomer;
import cn.com.qcc.queryvo.VillageeVo;

public interface SuggesService {
	
	//添加意见反馈
	ResultMap andsugges(Sugges sugges);
	
	List<SuggesCustomer> suggeslist(VillageeVo villageeVo);
	
	//我的反馈
	ResultMap getmysugges(Long userid);

	Integer suggescount(VillageeVo villageeVo);
	
	//反馈的详情
	SuggesCustomer getdetail(Long suggesid);
	
	//移除反馈
	ResultMap deletesugges(Sugges sugges);

}
