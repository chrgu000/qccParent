package cn.com.qcc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.mapper.ArticledetailMapper;
import cn.com.qcc.mapper.BuildingMapper;
import cn.com.qcc.mapper.BuyMapper;
import cn.com.qcc.mapper.EnshrineMapper;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mapper.QiuzuMapper;
import cn.com.qcc.mapper.VillageMapper;
import cn.com.qcc.pojo.Articledetail;
import cn.com.qcc.pojo.Building;
import cn.com.qcc.pojo.Buy;
import cn.com.qcc.pojo.Enshrine;
import cn.com.qcc.pojo.EnshrineExample;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.Qiuzu;
import cn.com.qcc.pojo.Village;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.queryvo.ZanCustomer;
import cn.com.qcc.service.EnshrineService;

@Service
public class EnshrineServiceImpl implements EnshrineService {

	@Autowired EnshrineMapper enshrineMapper;
	@Autowired HouseMapper houseMapper;
	@Autowired QiuzuMapper qiuzuMapper;
	@Autowired BuyMapper buyMapper;
	@Autowired ArticledetailMapper articledetailMapper;
	@Autowired VillageMapper villageMapper;
	@Autowired BuildingMapper buildingMapper;
	

	/**
	 * 判断房子的收藏状态
	 * * 1-房源，2-出租，3-出售，4-其他 (type)
	 * @param userid : 用户ID
	 * @param otherid : 物品主键
	 * **/ 
	public Enshrine enshriexist(Enshrine enshrine, Integer type) {
		Long followUserid = getfollowUserid(enshrine, type);	
		if (followUserid == null) {return  null;}
		EnshrineExample example = new EnshrineExample();
		EnshrineExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(enshrine.getUserid());
		criteria.andTypeEqualTo(type + "");
		criteria.andOtheridEqualTo(enshrine.getOtherid());
		criteria.andFollowUserIdEqualTo(followUserid);
		List<Enshrine> list = enshrineMapper.selectByExample(example);
		if (list.size() > 0 && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	/**添加收藏
	 * @param type : 1-房源，2-出租，3-出售，4-其他 (type)
	 * @param userid : 用户ID
	 * **/
	public void addenshrine(Enshrine enshrine, Integer type) {
		//收藏之前获取title
		String title = getTitle(enshrine, type);
		Enshrine clickenshire = this.enshriexist(enshrine, type);
		if (clickenshire != null) {
			if (clickenshire.getStatue() == 1) {
				clickenshire.setStatue(0);
			} else {
				clickenshire.setStatue(1);
			}
			clickenshire.setTitle(title);
			clickenshire.setUpdate_time(new Date());
			enshrineMapper.updateByPrimaryKeySelective(clickenshire);
		} else {
			Long followuserId = getfollowUserid(enshrine, type);
			enshrine.setFollowUserId(followuserId);
			enshrine.setCreate_time(new Date());
			enshrine.setUpdate_time(new Date());
			enshrine.setType(type + "");
			enshrine.setTitle(title);
			enshrine.setStatue(1);
			// 收藏
			enshrineMapper.insert(enshrine);
		}

	}

	// 获取收藏的title
	private String getTitle(Enshrine enshrine, Integer type) {
		String title = "hello";

		// 根据被收藏的物品主键查询用户ID
		if (type == 1) {
			House house = houseMapper.selectByPrimaryKey(Long.valueOf(enshrine.getOtherid()));
			return house.getPicture().split(",")[0];
		}
		// 求租的userid
		if (type == 2) {
			Qiuzu qiuzu = qiuzuMapper.selectByPrimaryKey(Long.valueOf(enshrine.getOtherid()));
			title =  qiuzu.getCaption() + qiuzu.getDescribes();
		}
		// 求购
		if (type == 3) {
			Buy buy = buyMapper.selectByPrimaryKey(Long.valueOf(enshrine.getOtherid()));
			title =  buy.getDescribes();
		}
		// 小区
		if (type == 4) {
			Village community = villageMapper.selectByPrimaryKey(Long.valueOf(enshrine.getOtherid()));
			title =  community.getPicture().split(",")[0];
		}
		// 楼栋
		if (type == 5) {
			Building ban = buildingMapper.selectByPrimaryKey(Long.valueOf(enshrine.getOtherid()));
			title =  ban.getPicture().split(",")[0];
		}
		if (type == 8 || type == 6 || type == 7 || type == 11) {
			Articledetail articledetail = articledetailMapper.selectByPrimaryKey(Long.valueOf(enshrine.getOtherid()));
			if (articledetail.getPicture() !=null && !"".equals(articledetail.getPicture())) {
				return articledetail.getPicture().split(",")[0];
			}else {
				return articledetail.getTitle()+articledetail.getDescription();
			}
		}
		return title;
	}

	/**
	 * 取消收藏
	 * **/ 
	public void removeenshrine(Enshrine enshrine, Integer type) {
		Enshrine clickenshire = this.enshriexist(enshrine, type);
		if (clickenshire != null) {
			clickenshire.setStatue(0);
			enshrineMapper.updateByPrimaryKeySelective(clickenshire);
		} else {
			Long followuserid = getfollowUserid(enshrine, type);
			enshrine.setFollowUserId(followuserid);
			enshrine.setCreate_time(new Date());
			enshrine.setUpdate_time(new Date());
			enshrine.setType(type + "");
			// 取消收藏
			enshrine.setStatue(0);
			enshrineMapper.insert(enshrine);
		}
	}

	/** 查询我的收藏
	 * @param userid : 用户ID
	 * **/
	public List<ZanCustomer> findMyEnshList(HouseVo houseVo) {
		return enshrineMapper.findEnshfollow(houseVo);
	}
	
	public Long getfollowUserid (Enshrine enshrine, Integer type) {
		
		Long followUserid = null;
		
		if (enshrine.getOtherid() ==null) {
			return followUserid;
		}
		//根据被收藏的物品主键查询用户ID
		if (type == 1) {
			House house = houseMapper.selectByPrimaryKey(Long.valueOf(enshrine.getOtherid()));
			if (house !=null) { followUserid = house.getUser_id();  }
			
		}
		//求租的userid
		if (type == 2) {
			Qiuzu qiuzu  =qiuzuMapper.selectByPrimaryKey(Long.valueOf(enshrine.getOtherid())) ;
			if (qiuzu !=null) {followUserid = qiuzu.getUser_id(); }
		}
		//求购
		if (type == 3) {
			Buy buy = buyMapper.selectByPrimaryKey(Long.valueOf(enshrine.getOtherid()));
			if (buy !=null) {	followUserid = buy.getUser_id();}
		}
		//小区
		if (type == 4 ) {
			Village community = villageMapper.selectByPrimaryKey(Long.valueOf(enshrine.getOtherid()));
			if (community !=null) {followUserid = community.getUserid(); }
			
		}
		//楼栋
		if (type == 5) {
			Building ban = buildingMapper.selectByPrimaryKey(Long.valueOf(enshrine.getOtherid()));
			if(ban !=null) {followUserid = ban.getUserid();  }
		}
		if (type == 8 || type == 6 || type ==7 || type ==11) {
			Articledetail articledetail = articledetailMapper.selectByPrimaryKey(Long.valueOf(enshrine.getOtherid()));
			if (articledetail !=null) {  	followUserid = articledetail.getUserid();  }
		
		}
		return followUserid;
	}

	@Override
	public int findMyEnshListCount(HouseVo houseVo) {
		return  enshrineMapper.findEnshfollowCount(houseVo);
	}
}
