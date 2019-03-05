package cn.com.qcc.service;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Bdmanager;

public interface BDService {

	ResultMap addOrUpdate(Bdmanager bdmanager);

	ResultMap listBD();

	ResultMap findOne(String bdid);

	ResultMap changeState(String bdid);

	Bdmanager searchBDByPhoneOrId(String account);

}
