package cn.com.qcc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.qcc.mapper.HousetagMapper;
import cn.com.qcc.mapper.PararuleMapper;
import cn.com.qcc.mymapper.AddressCustomerMapper;
import cn.com.qcc.mymapper.HouseCustomerMapper;
import cn.com.qcc.pojo.Housetag;
import cn.com.qcc.pojo.HousetagExample;
import cn.com.qcc.pojo.Pararule;
import cn.com.qcc.queryvo.HouseCustomer;
import cn.com.qcc.queryvo.PreparatoryCustomer;
import cn.com.qcc.service.HousertargService;

@Service
@Transactional
public class HouseTargServiceImpl implements HousertargService {

	@Autowired
	HousetagMapper housetagMapper;
	@Autowired
	HouseCustomerMapper houseCustomerMapper;
	@Autowired
	PararuleMapper pararuleMapper;
	@Autowired
	 AddressCustomerMapper addressCustomerMapper;

	/**
	 * 发布房屋提取公用设施给前台 
	 * @param category_name : 房源基础设置名称
	 * @return
	 */
	public List<Housetag> getHousetagByCategory(String category_name) {
		HousetagExample example = new HousetagExample();
		HousetagExample.Criteria criteria = example.createCriteria();
		criteria.andCategory_nameEqualTo(category_name);
		List<Housetag> housetags = housetagMapper.selectByExample(example);
		return housetags;
	}

	/**
	 * 根据type获取房子属性的ID
	 * **/ 
	public String getHousetagByType(String type) {
		HousetagExample example = new HousetagExample();
		HousetagExample.Criteria criteria = example.createCriteria();
		criteria.andTypeEqualTo(type);
		List<Housetag> housetags = housetagMapper.selectByExample(example);
		if (!housetags.isEmpty() && housetags.size() > 0) {
			return housetags.get(0).getHousetagid() + "";
		}
		return null;
	}

	/**
	 *  根据房子ID查询性别的标签
	 * **/
	public List<Housetag> getHousetagsofSex(Integer houseid) {
		return housetagMapper.getHousetagsSexbyId(houseid);
	}

	/**根据房子ID查询独立的标签
	 * @param houseid : 房源ID
	 * **/ 
	public List<Housetag> getHousetagsofalone(Integer houseid) {
		return housetagMapper.getHousetagsalonebyId(houseid);
	}

	/**根据房子ID查询公共的标签
	 * @param houseid : 房源ID 
	 * **/ 
	public List<Housetag> getHousetagsofcommon(Integer houseid) {
		return housetagMapper.getHousetagscommonbyId(houseid);
	}

	/**
	 * 根据category 查询房源设备信息
	 * **/
	public List<Housetag> getTargBycategory(String category) {
		List<Housetag> list = houseCustomerMapper.getTargBycategory(category); 
		return list;
	}

	/**根据类型查询traname
	 * **/
	public PreparatoryCustomer getTraName(long houseid) {
		return houseCustomerMapper.getTraName(houseid);
	}

	/**根据ID 查询租客规则
	 * @param pararuleid
	 * @return
	 */
	public Pararule searchpararulebyid(Integer pararuleid) {
		return pararuleMapper.selectByPrimaryKey(pararuleid);
	}

	/***
	 * 查询规则参数列表
	 * */
	public List<Pararule> searchpararuleList() {
		return pararuleMapper.selectByExample(null);
	}

	/**编辑规格参数**/
	public void updateparaule(Pararule pararule) {
		pararuleMapper.updateByPrimaryKeySelective(pararule);
	}

	/**根据housetag_id查询类型**/
	public List<Housetag> getTargByHouseTargId(String housetagid) {
		if (housetagid == null || "".equals(housetagid)) {return new ArrayList<Housetag>();}
		if (housetagid.endsWith(",")) {housetagid = housetagid.substring(0, housetagid.length()-1);}
		return houseCustomerMapper.getTargByHouseTargId(housetagid);
	}

	@Override
	public List<HouseCustomer> getpayListBybuilid(Long buildingid) {
		// TODO Auto-generated method stub
		return addressCustomerMapper.getpayListBybuilid(buildingid);
	}

	@Override
	public List<HouseCustomer> getredecoraListBybuilid(Long buildingid) {
		// TODO Auto-generated method stub
		return addressCustomerMapper.getredecoraListBybuilid(buildingid);
	}

	@Override
	public List<HouseCustomer> getproperListBybuilid(Long buildingid) {
		// TODO Auto-generated method stub
		return addressCustomerMapper.getproperListBybuilid(buildingid);
	}

	@Override
	public List<HouseCustomer> getapartmentnameListBybuilid(Long buildingid) {
		// TODO Auto-generated method stub
		return addressCustomerMapper.getapartmentnameListBybuilid(buildingid);
	}

	@Override
	public List<HouseCustomer> getCountAndpricesBybuilid(Long buildingid) {
		// TODO Auto-generated method stub
		return addressCustomerMapper.getCountAndpricesBybuilid(buildingid);
	}

}
