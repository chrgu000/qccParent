package cn.com.qcc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.mapper.ArticledetailMapper;
import cn.com.qcc.mapper.BuildingMapper;
import cn.com.qcc.mapper.BuyMapper;
import cn.com.qcc.mapper.HouseMapper;
import cn.com.qcc.mapper.QiuzuMapper;
import cn.com.qcc.mapper.VillageMapper;
import cn.com.qcc.mapper.ZanMapper;
import cn.com.qcc.pojo.Articledetail;
import cn.com.qcc.pojo.Building;
import cn.com.qcc.pojo.Buy;
import cn.com.qcc.pojo.House;
import cn.com.qcc.pojo.Qiuzu;
import cn.com.qcc.pojo.Village;
import cn.com.qcc.pojo.Zan;
import cn.com.qcc.pojo.ZanExample;
import cn.com.qcc.queryvo.ZanCustomer;
import cn.com.qcc.service.ZanService;

@Service
@Transactional
public class ZanServiceImpl implements ZanService {

	@Autowired ZanMapper zanMapper;
	@Autowired HouseMapper houseMapper;
	@Autowired QiuzuMapper qiuzuMapper;
	@Autowired BuyMapper buyMapper;
	@Autowired ArticledetailMapper articledetailMapper;
	@Autowired VillageMapper villageMapper;
	@Autowired BuildingMapper buildingMapper;

	/** 当前用户查看zan的数量
	 *  @param userid : 当前用户ID
	 * **/ 
	public int findzanfollowCount(Long userid) {

		return zanMapper.findzanfollowCount(userid);
	}

	/** 判断是否给某个物品或者是否点过赞
	 * @param type : 参数类型
	 * @param userid : 当前用户
	 * @param otherid : 物品 ,
	 * @param followuserid : 发布人ID
	 * 
	 * **/
	public Zan findisZan(Zan zan, Integer type) {
		if (zan.getUserid() == null || zan.getFollowUserId() ==null || type == null) {
			return null;
		}
		Long followUserid = getfollowUserID(zan, type);
		ZanExample example = new ZanExample();
		ZanExample.Criteria criteria = example.createCriteria();
		criteria.andUseridEqualTo(zan.getUserid());
		criteria.andOtheridEqualTo(zan.getOtherid());
		criteria.andTypeEqualTo(type);
		criteria.andFollowUserIdEqualTo(followUserid );
		List<Zan> zanlist = zanMapper.selectByExample(example);
		if (!zanlist.isEmpty() && zanlist.size() > 0) {
			return zanlist.get(0);
		}
		return null;
	}

	/**点赞
	 * @param userid : 操作人ID
	 * @param type : 参数类型
	 * @param 
	 * 
	 * **/
	public void addzan(Zan zan, Integer type) {
		// 点赞之前获取title
		if (zan.getUserid() !=null) {
			String title = getTitle(zan, type);
			Zan clickzak = this.findisZan(zan, type);
			if (clickzak != null) {
				clickzak.setTitle(title);
				clickzak.setUpdate_time(new Date());
				if (clickzak.getState().equals("1")) {
					clickzak.setState(0 + "");
				} else {
					clickzak.setState(1 + "");
				}
				zanMapper.updateByPrimaryKeySelective(clickzak);
			} else {
				Long followuserid = getfollowUserID(zan, type);
				zan.setCreate_time(new Date());
				zan.setUpdate_time(new Date());
				zan.setFollowUserId(followuserid);
				zan.setType(type);
				zan.setState(1 + "");
				zan.setTitle(title);
				zanMapper.insert(zan);
			}
		}
		
	}

	// 根据type类型 ，和zan的otherID 获取点赞的 TITLE
	private String getTitle(Zan zan, Integer type) {
		String title = "";
		if (zan.getOtherid() == null) {return title ;}
		// 根据被收藏的物品主键查询用户ID
		if (type == 1) {
			House house = houseMapper.selectByPrimaryKey(Long.valueOf(zan.getOtherid()));
			return house.getPicture().split(",")[0];
		}
		// 求租的userid
		if (type == 2) {
			Qiuzu qiuzu = qiuzuMapper.selectByPrimaryKey(Long.valueOf(zan.getOtherid()));
			return qiuzu.getCaption() + qiuzu.getDescribes();
		}
		// 求购
		if (type == 3) {
			Buy buy = buyMapper.selectByPrimaryKey(Long.valueOf(zan.getOtherid()));
			return  buy.getDescribes();
		}
		// 小区
		if (type == 4) {
			Village community = villageMapper.selectByPrimaryKey(Long.valueOf(zan.getOtherid()));
			return community.getPicture().split(",")[0];
		}
		// 楼栋
		if (type == 5) {
			Building ban = buildingMapper.selectByPrimaryKey(Long.valueOf(zan.getOtherid()));
			return ban.getPicture().split(",")[0];
		}
		if (type == 8 || type == 6 || type == 7 || type == 11) {
			Articledetail articledetail = articledetailMapper.selectByPrimaryKey(Long.valueOf(zan.getOtherid()));
			if (articledetail.getPicture() != null && !"".equals(articledetail.getPicture())) {
				return articledetail.getPicture().split(",")[0];
			} else {
				return articledetail.getTitle() + articledetail.getDescription();
			}
		}
		return title;
	}

	/** 取消赞
	 * **/
	public void removezan(Zan zan, Integer type) {
		
		if (zan.getUserid() !=null) {
			Zan clickzak = this.findisZan(zan, type);
			if (clickzak != null) {
				clickzak.setState(0 + "");
				zanMapper.updateByPrimaryKeySelective(clickzak);
			} else {
				Long followuserid = getfollowUserID(zan, type);
				zan.setFollowUserId(followuserid);
				zan.setCreate_time(new Date());
				zan.setUpdate_time(new Date());
				zan.setState(0 + "");
				zan.setType(type);
				zanMapper.insert(zan);
			}
		}
	}

	@Override
	public List<ZanCustomer> findzanfollow(Long userid ,PageQuery pagequery) {
		return zanMapper.findzanfollow(userid ,pagequery);
	}
	
	//通过zan 的主键查询发布人ID
	public Long getfollowUserID  (Zan zan ,Integer type) {
		Long followUserid = null;
		// 根据被收藏的物品主键查询用户ID
		if (type == 1) {
			House house = houseMapper.selectByPrimaryKey(Long.valueOf(zan.getOtherid()));
			followUserid = house.getUser_id();
		}
		// 求租的userid
		if (type == 2) {
			Qiuzu qiuzu = qiuzuMapper.selectByPrimaryKey(Long.valueOf(zan.getOtherid()));
			followUserid = qiuzu.getUser_id();
		}
		// 求购
		if (type == 3) {
			Buy buy = buyMapper.selectByPrimaryKey(Long.valueOf(zan.getOtherid()));
			followUserid = buy.getUser_id();
		}
		// 小区
		if (type == 4) {
			Village community = villageMapper.selectByPrimaryKey(Long.valueOf(zan.getOtherid()));
			followUserid = community.getUserid();
		}
		// 楼栋
		if (type == 5) {
			Building ban = buildingMapper.selectByPrimaryKey(Long.valueOf(zan.getOtherid()));
			followUserid = ban.getUserid();
		}
		if (type == 8 || type == 6 || type == 7 || type ==11) {
			Articledetail articledetail = articledetailMapper.selectByPrimaryKey(Long.valueOf(zan.getOtherid()));
			followUserid = articledetail.getUserid();
		}
		return followUserid;
	}
	
}
