package cn.com.qcc.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.SuggesMapper;
import cn.com.qcc.pojo.Sugges;
import cn.com.qcc.pojo.SuggesExample;
import cn.com.qcc.queryvo.SuggesCustomer;
import cn.com.qcc.queryvo.VillageeVo;
import cn.com.qcc.service.SuggesService;

@Service
@Transactional
public class SuggesServiceImpl implements SuggesService{

	@Autowired
	SuggesMapper suggesMapper;
	//添加意见反馈
	public ResultMap andsugges(Sugges sugges) {
		sugges = sugges == null ? new Sugges() : sugges;
		if (sugges.getUserid() == null) {
			return ResultMap.build(404,"请登录后在添加反馈！");
		}
		if (sugges.getTitle()== null || "".equals(sugges.getTitle())) {
			return ResultMap.build(400,"请输入发布反馈的标题！");
		}
		if (sugges.getPicture() == null || "".equals(sugges.getPicture())) {
			sugges.setPicture("-1");
		}
		sugges.setUpdate_time(new Date());
		sugges.setState(1);
		suggesMapper.insertSelective(sugges);
		return ResultMap.build(200,"恭喜你反馈成功！");
	}
	//查询已经反馈
	public List<SuggesCustomer>  suggeslist(VillageeVo villageeVo) {
		List<SuggesCustomer> list =  suggesMapper.suggeslist(villageeVo);
		return list;
	}
	@Override
	public ResultMap getmysugges(Long userid) {
		if (userid == null ) {
			return ResultMap.build(404,"请登录后操作！");
		}
		SuggesExample example = new SuggesExample();
		SuggesExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(userid);
		criteria.andStateEqualTo(1);
		List<Sugges> sugges = suggesMapper.selectByExample(example);
		Map<String , Object> map = new HashMap<>();
		map.put("sugges", sugges);
		return ResultMap.IS_200(sugges);
	}
	@Override
	public Integer suggescount(VillageeVo villageeVo) {
		return suggesMapper.suggescount(villageeVo);
	}
	@Override
	public SuggesCustomer getdetail(Long suggesid) {
		return suggesMapper.searchbyid (suggesid);
	}
	@Override
	public ResultMap deletesugges(Sugges sugges) {
		if (sugges.getUserid() == null) {
			return ResultMap.build(404, "请先登录在操作");
		}
		if (sugges.getSuggesid() == null) {
			return ResultMap.build(400, "该反馈不存在无法移除");
		}
		Sugges sugges_search = checksugges(sugges);
		if (sugges_search ==  null) {
			return ResultMap.build(400, "该反馈不存在无法移除");
		}
		sugges_search.setUpdate_time(new Date());
		sugges_search.setState(2);
		suggesMapper.updateByPrimaryKeySelective(sugges_search);
		return ResultMap.build(200, "移除成功！");
	}
	private Sugges checksugges(Sugges sugges) {
		SuggesExample example = new SuggesExample();
		SuggesExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(sugges.getUserid());
		criteria.andSuggesidEqualTo(sugges.getSuggesid());
		List<Sugges> list = suggesMapper.selectByExample(example);
		return  list == null ? null : list.get(0);
	}

}
