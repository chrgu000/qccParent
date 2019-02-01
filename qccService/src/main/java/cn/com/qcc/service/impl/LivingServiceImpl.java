package cn.com.qcc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.LivingMapper;
import cn.com.qcc.pojo.Living;
import cn.com.qcc.service.LivingService;


@Service
public class LivingServiceImpl implements LivingService {

	@Autowired
	LivingMapper livingMapper;
	
	
	public List<Living> searchByTypeId(Long typeid) {
		List<Living> searchList = livingMapper.searchByTypeId(typeid);
		return searchList;
	}
	
	public List<Living> searchAllByTypeId(Long typeid) {
		List<Living> searchList = livingMapper.searchAllByTypeId(typeid);
		return searchList;
	}

	/**上移**/
	public ResultMap livingUp(Long typeid, Long livingid) {
		// 先查询所有的
		List<Living> searchList = livingMapper.searchByTypeId(typeid);
		Living current = null;
		Living pre = null ;
		if (searchList.size() <2) 
			return ResultMap.build(400, "就一个元素不需要上移");
		for (int i=0;i<searchList.size();i++) {
			// 获取当前的元素
			if (searchList.get(i).getLivingid() == livingid) {
				// 判断当前是不是一号位置
				if (i==0) 
					return ResultMap.build(400, "当前一号位置不需要上移");
					current = searchList.get(i);
					pre = searchList.get(i-1);
					Long currentId = current.getLivingid();
					Long preId = pre.getLivingid();
					
					//把两个ID 交换
					current.setOrderasc(Integer.parseInt(preId+""));
					current.setLivingid(preId);
					pre.setLivingid(currentId);
					pre.setOrderasc(Integer.parseInt(currentId+""));
					
					livingMapper.updateByPrimaryKeySelective(current);
					livingMapper.updateByPrimaryKeySelective(pre);
			// 查询父级
			Living father =livingMapper.selectByPrimaryKey(typeid);
			return ResultMap.build(200, "移动成功" , father);
			}
		}
		return ResultMap.build(400, "");
	}

	@Override
	public ResultMap add(Living livng) {
		if (CheckDataUtil.checkNotEmpty(livng.getLivingid())) {
			livingMapper.updateByPrimaryKeySelective(livng);
		} else {
			Integer maxOrder = livingMapper.getOrder(livng);
			livng.setState(1);
			livng.setOrderasc(maxOrder);
			livingMapper.insertSelective(livng);
		}
		//查询父级
		Living father = livingMapper.selectByPrimaryKey(livng.getTypeid());
		return ResultMap.IS_200(father);
	}

	@Override
	public ResultMap livingChange(Living living) {
		
		Living search = livingMapper.selectByPrimaryKey(living.getLivingid());
		if (CheckDataUtil.checkisEmpty(search)) {
			return ResultMap.build(400,"未知元素");
		}
		livingMapper.updateByPrimaryKeySelective(living);
		return ResultMap.IS_200(search.getTypeid());
	}

	@Override
	public Living searchOne(Long livingid) {
		// TODO Auto-generated method stub
		return livingMapper.selectByPrimaryKey(livingid);
	}

	@Override
	public void delete(Long livingid) {
		// TODO Auto-generated method stub
		livingMapper.deleteByPrimaryKey(livingid);
	}

}
