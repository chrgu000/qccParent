package cn.com.qcc.mymapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.pojo.Consume;
import cn.com.qcc.pojo.Integral;
import cn.com.qcc.pojo.Lucre;
import cn.com.qcc.pojo.Masonry;
import cn.com.qcc.queryvo.UserVo;
import cn.com.qcc.queryvo.VipCountCustomer;

public interface ConsumeCustomerMapper {
	
	//根据用户ID查询充值记录
	List<Consume> searchrecharge(UserVo userVo);
	int searchrechargeCount(UserVo userVo);
	
	//根据userid查询消费记录
	List<Consume> searchexpense(UserVo userVo);
	int searchexpenseCount(UserVo userVo);
	
	Long getordernum();
	
	//查询我的钱包
	VipCountCustomer getmyburse( @Param("userid")Long userid , @Param("daycount")int day );
	
	//查询系统用户钱包
	List<VipCountCustomer> getalluserburse(UserVo userVo);
	int getalluserburseCount(UserVo userVo);
	
	//我的洪币列表
	List<Masonry> mymasonrylist(UserVo userVo);
	int mymasonrylistCount(UserVo userVo);
	
	 // 我的积分事件
 	List<Integral> myinteout(UserVo userVo);
 	int myinteoutCount(UserVo userVo);
 	
 	//查询金币明细
	List<VipCountCustomer> searchjbmx(@Param("idsList")  String[] userid,@Param("pagequery") PageQuery pagequery);
	int searchjbmxCount(@Param("idsList") String[] userid);
	
	//查询收益明细
	int searchsymxCount(@Param("idsList") String[] userid);
	List<VipCountCustomer> searchsymx(@Param("idsList")  String[] userid,@Param("pagequery") PageQuery pagequery);
	
	//查询红币明细
	int searchhbmxCount(@Param("idsList") String[] userid);
	List<VipCountCustomer> searchhbmx(@Param("idsList")  String[] userid,@Param("pagequery") PageQuery pagequery);
	
	// 查看会员充值
	int searchhymxCount(@Param("idsList") String[] userid);
	List<VipCountCustomer> searchhymx(@Param("idsList")  String[] userid,@Param("pagequery") PageQuery pagequery);
	
	// 查询消费明细
	int searchxfmxCount(@Param("idsList") String[] userid);
	List<VipCountCustomer> searchxfmx(@Param("idsList")  String[] userid,@Param("pagequery") PageQuery pagequery);
	
	/**
	 * 统计金币时候判断当天类型发布的长度
	 * @param type : 金币类型
	 * @param userid : 用户ID
	 * **/
	Integer searchcurrntlength(@Param("commonid")Long commonid,@Param("userid") Long userid);
	
	/**
	 * 统计今天是否扣过积分
	 * @param type : 金币类型
	 * @param userid : 用户ID
	 * @param otherid : 类目主键
	 * **/
	Integer todaylength(@Param("commonid") Long commonid,@Param("otherid") Long otherid,@Param("userid") Long userid);
	
	/**
	 * 查询第  n 天 收益的正常情况
	 * **/
	List<Lucre> searchNeedAddLurceByTime(int daycount);
	
	/**
	 * 吧第n天的数据同步为已经收益状态
	 * **/
	void updateLurceIsAddByTime(int daycount);
	

}