package cn.com.qcc.service.impl;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.qcc.mapper.SceneuserMapper;
import cn.com.qcc.mapper.WeixinuserinfoMapper;
import cn.com.qcc.pojo.Weixinuserinfo;
import cn.com.qcc.service.ScanuserService;
@Service
public class ScanuserServiceImpl implements ScanuserService {

	@Autowired
	WeixinuserinfoMapper weixinuserinfoMapper;
	@Autowired
	SceneuserMapper sceneuserMapper;
	
	@Override
	public String saveorupdateweixinuser(Weixinuserinfo user) {
		String returnstr = "old";
		try {
			Weixinuserinfo weixinuserinfo = checkUserExist(user);
			//以前关注过再次关注
			if(weixinuserinfo !=null){
				
				weixinuserinfoMapper.updateByPrimaryKeySelective(user);
			}else{
				
				//新关注
				user.setSubscribeTime(new Date());
				weixinuserinfoMapper.insertSelective(user);
				returnstr = "new";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnstr;
	}

	

	public Weixinuserinfo checkUserExist(Weixinuserinfo user) {
		return weixinuserinfoMapper.selectByPrimaryKey(user.getOpenId());
	}

}
