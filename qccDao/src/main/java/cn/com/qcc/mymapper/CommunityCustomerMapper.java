package cn.com.qcc.mymapper;

import java.util.List;

import cn.com.qcc.queryvo.BanCustomer;
import cn.com.qcc.queryvo.Community;
import cn.com.qcc.queryvo.CommunityCustomer;
import cn.com.qcc.queryvo.CommunityVo;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.VillageCustomer;
import cn.com.qcc.queryvo.VillageeVo;


public interface CommunityCustomerMapper {

	
	//小区编辑的查询
	CommunityCustomer searchCommByCommid( Long communityid);

	List <CommunityCustomer> searchCommlist (CommunityVo communityVo);

	Integer searchCommlistCount(CommunityVo communityVo);
	
	//小区详情
	Community searchCommdetail(Long communityid);
	
	List <CommunityCustomer> searchbuildlist (CommunityVo communityVo);
	

	Integer searchbuildlistCount(CommunityVo communityVo);
	
	
	//楼栋详情
	BanCustomer searchBanById(Long banid);

	List<VillageCustomer> checkbuildingExist(VillageeVo villageeVo);
	
	//楼栋下面房源的列表
	List<HouseCustomer> searchhouseList(CommunityVo communityVo);

	
	
	
	
}
