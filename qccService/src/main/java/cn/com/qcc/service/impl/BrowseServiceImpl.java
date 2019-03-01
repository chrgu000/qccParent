package cn.com.qcc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.qcc.common.CheckDataUtil;
import cn.com.qcc.mapper.ArticledetailMapper;
import cn.com.qcc.mapper.BrowseMapper;
import cn.com.qcc.mapper.BuildingMapper;
import cn.com.qcc.mapper.BuyMapper;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mapper.QiuzuMapper;
import cn.com.qcc.mapper.TribeMapper;
import cn.com.qcc.mapper.VillageMapper;
import cn.com.qcc.pojo.Articledetail;
import cn.com.qcc.pojo.Browse;
import cn.com.qcc.pojo.BrowseExample;
import cn.com.qcc.pojo.Building;
import cn.com.qcc.pojo.Buy;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.Qiuzu;
import cn.com.qcc.pojo.Tribe;
import cn.com.qcc.pojo.Village;
import cn.com.qcc.queryvo.BrowerCustomer;
import cn.com.qcc.queryvo.HouseVo;
import cn.com.qcc.service.BrowseService;

@Service
@Transactional
public class BrowseServiceImpl implements BrowseService {

	@Autowired
	BrowseMapper browseMapper;
	@Autowired
	HouseMapper houseMapper;
	@Autowired
	QiuzuMapper qiuzuMapper;
	@Autowired
	BuildingMapper buildingMapper;
	@Autowired
	ArticledetailMapper articledetailMapper;
	@Autowired
	VillageMapper villageMapper;
	@Autowired
	TribeMapper tribeMapper;
	@Autowired
	BuyMapper buyMapper;

	/**
	 * 查询我的浏览
	 * @param type : 浏览的type类型
	 * **/
	public List<Browse> BrowseList(Browse browse, Integer type) {
		BrowseExample example = new BrowseExample();
		example.setOrderByClause("b_time desc");
		BrowseExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(browse.getUserid());
		criteria.andTypeEqualTo(type);
		criteria.andStatueEqualTo(1);
		List<Browse> list = browseMapper.selectByExample(example);
		return list;
	}

	// 查询当前浏览是否存在
	public Browse Browsexixt(Long otherid,Long userid, Integer type) {
			Long followUserid = null;
			String title = "hello";
		    Browse retrunbro = new Browse();
			//根据被收藏的物品主键查询用户ID
			if (type == 1) {
				House house = houseMapper.selectByPrimaryKey(otherid);
					followUserid = house.getUser_id();
					// 房源在发布图片时候肯定有值
					title = house.getPicture().split(",")[0];
			}
			//求租的userid
			if (type == 2) {
				Qiuzu qiuzu  =qiuzuMapper.selectByPrimaryKey(otherid) ;
				followUserid = qiuzu.getUser_id();
				title =  qiuzu.getCaption() + qiuzu.getDescribes();
			}
			//求购
			if (type == 3) {
				Buy buy = buyMapper.selectByPrimaryKey(otherid);
				followUserid = buy.getUser_id();
				title =  buy.getDescribes();
			}
			//小区
			if (type == 4 ) {
				Village community = villageMapper.selectByPrimaryKey(otherid);
				followUserid = community.getUserid();
				title =  community.getPicture().split(",")[0];
			}
			//楼栋
			if (type == 5) {
				Building ban = buildingMapper.selectByPrimaryKey(otherid);
				followUserid = ban.getUserid();
				title =  ban.getPicture().split(",")[0];
			}
			if (type == 8 || type == 6 || type ==7 || type == 11) {
				Articledetail articledetail = articledetailMapper.selectByPrimaryKey(otherid);
				followUserid = articledetail.getUserid();
				if (articledetail.getPicture() !=null && !"".equals(articledetail.getPicture())) {
					title =  articledetail.getPicture().split(",")[0];
				}else {
					title =  articledetail.getTitle()+articledetail.getDescription();
				}
			}
			if (type == 9 ) {
				Tribe tribe = tribeMapper.selectByPrimaryKey(otherid);
				if (CheckDataUtil.checkNotEmpty(tribe)) {
					followUserid = tribe.getUserid();
					title = tribe.getPicture().split(",")[0];
				}
			}
			
			
			BrowseExample example = new BrowseExample();
			BrowseExample.Criteria criteria = example.createCriteria();
			criteria.andUseridEqualTo(userid);
			criteria.andTypeEqualTo(type );
			criteria.andOtheridEqualTo(otherid);
			List<Browse> list = browseMapper.selectByExample(example);
			if (list.size() > 0 && !list.isEmpty()) {
				retrunbro = list.get(0);
				retrunbro.setTitle(title);
				return retrunbro;
			}
			retrunbro.setTitle(title);
			retrunbro.setFollowUserId(followUserid);
			return retrunbro;
		}
		
//		BrowseExample example = new BrowseExample();
//		BrowseExample.Criteria criteria = example.createCriteria();
//		criteria.andFollowUserIdEqualTo(browse.getFollowUserId());
//		criteria.andOtheridEqualTo(browse.getOtherid());
//		criteria.andUseridEqualTo(browse.getUserid());
//		criteria.andTypeEqualTo(type);
//		List<Browse> list = browseMapper.selectByExample(example);
//		if (!list.isEmpty() && list.size() > 0) {
//			return list.get(0);
//		}
//		return null;

	
	/**
	 * 插入浏览量
	 * @param type : 浏览的类型
	 * **/
	public void addBrowse(Long otherid ,Long userid, Integer type) {
		
		if (CheckDataUtil.checkNotEmpty(userid) && CheckDataUtil.checkNotEmpty(userid)
				&& CheckDataUtil.checkNotEmpty(type)) {
			Browse checkbrowse = this.Browsexixt(otherid,userid, type);
			if (CheckDataUtil.checkNotEmpty(checkbrowse.getUserid())) {
				Date cuntTime = new Date();
				Long cunt = cuntTime.getTime();
				Long old = checkbrowse.getB_time().getTime() + 3600000;
				if (cunt > old) {
					Integer count = checkbrowse.getBcount();
					count++;
					checkbrowse.setBcount(count);
					checkbrowse.setB_time(new Date());
					checkbrowse.setStatue(1);
					browseMapper.updateByPrimaryKeySelective(checkbrowse);
				}
			} else {
				checkbrowse.setOtherid(otherid);
				checkbrowse.setUserid(userid);
				checkbrowse.setB_time(new Date());
				checkbrowse.setBcount(1);
				checkbrowse.setType(type);
				checkbrowse.setStatue(1);
				browseMapper.insert(checkbrowse);
			}
		}
	}

	// 查询 这个浏览的总计
	public Integer count(Long userid, Integer type) {
		if (userid == null) {
			return 0;
		}
		Integer count = browseMapper.selectount(userid, type);
		if ("".equals(count)) {
			return 0;
		} else {
			return count;
		}
	}

	/**
	 * 当前物品的浏览量
	 * @param otherid : 物品主键
	 * @param type : 类目类型
	 * **/ 
	public BrowerCustomer countone(Integer type, Long qiuzuid) {
		BrowerCustomer boBrowerCustomer =  browseMapper.selectountone(type, qiuzuid);
		return boBrowerCustomer;
	}

	/** 查询我的浏览列表
	 * @param userid : 用户ID
	 * **/
	public List<BrowerCustomer> findmyBrowList(HouseVo houseVo) {
		return browseMapper.mybrowList(houseVo);
	}
	public int findmyBrowListCount(HouseVo houseVo) {
		return browseMapper.findmyBrowListCount(houseVo);
	}
	
	

	/**删除查看也就是更新状态
	 * @param userid : 用户ID
	 * @param statue  : 1,正常，2停用
	 * **/ 
	public void updatestate(Browse browse) {
		if (browse!=null) {
			browse.setStatue(2);
			browseMapper.updateByPrimaryKeySelective(browse);
		}
	}

	

}
