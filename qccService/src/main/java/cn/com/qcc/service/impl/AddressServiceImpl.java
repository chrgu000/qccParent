package cn.com.qcc.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.common.ResultMap;
import cn.com.qcc.mapper.AreaMapper;
import cn.com.qcc.mapper.DeliveryMapper;
import cn.com.qcc.mapper.MetroMapper;
import cn.com.qcc.mymapper.AddressCustomerMapper;
import cn.com.qcc.mymapper.AreaCustomerMapper;
import cn.com.qcc.mymapper.ReleaseCustomerMapper;
import cn.com.qcc.pojo.Area;
import cn.com.qcc.pojo.AreaExample;
import cn.com.qcc.pojo.Brand;
import cn.com.qcc.pojo.Delivery;
import cn.com.qcc.pojo.Metro;
import cn.com.qcc.pojo.MetroExample;
import cn.com.qcc.queryvo.AreaCustomer;
import cn.com.qcc.queryvo.MetroCustomer;
import cn.com.qcc.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired AreaMapper areaMapper;
	@Autowired AddressCustomerMapper addressCustomerMapper;
	@Autowired AreaCustomerMapper areaCustomerMapper;
	@Autowired MetroMapper metroMapper;
	@Autowired DeliveryMapper deliveryMapper;
	@Autowired ReleaseCustomerMapper releaseCustomerMapper;

	/**   根据上一级地址查询下一级地址
	 *    @param code  : 其中的code
	 * **/
	public List<AreaCustomer> getnextareabycode(String [] code) {
		return addressCustomerMapper.getarealist(code);
	}

	
	/** 根据区域的ID编辑区域
	 *  @param id : 区域主键
	 *  @param name : 区域名称
	 * **/
	public void updatename(Area area) {
		areaMapper.updateByPrimaryKeySelective(area);
	}

	/**
	 * 新增 四级联动地址
	 * **/
	public ResultMap add(Area area ,String subname) {
		
		if ("".equals(subname) || subname ==null) {
			return ResultMap.build(400,"新增地址不能为空！");
		}
		if ("新增地址不能为空！".equals(subname)) {
			return ResultMap.build(400,"新增地址不能为空！");
		}
		if ("末级地址不可添加！".equals(subname)) {
			return ResultMap.build(400,"末级地址不可添加！");
		}
		if (area.getLevel() == 4) {
			return ResultMap.build(400,"末级地址不可添加！");
		}
		if (subname.equals("恭喜你添加 [ "+subname+"  ]成功")) {
			return ResultMap.build(400,"新增地址不能为空！");
		}
		Area Area_insert = new Area();
		//查询以当前为节点是否有下一级
		Area area_search = areaCustomerMapper.getmaxareacode(area.getCode());
		Area_insert.setParentId(area.getCode());
		Area_insert.setName(subname);
		Area_insert.setLevel(area.getLevel()+1);
		if (area_search == null) {
			//说明当前节点下无数据
			if (area.getLevel() == 3) {
				Area_insert.setCode(Long.valueOf(area.getCode()+"001"));
			}else {
				Area_insert.setCode(Long.valueOf(area.getCode()+"01"));
			}
		}else {
			Area_insert.setCode(area_search.getCode()+1);
		}
		areaMapper.insertSelective(Area_insert);
		return ResultMap.build(200, "恭喜你添加 [ "+subname+"  ]成功");
	}

	/**根据CODE 查询区域的详情
	 * @param code : 区域CODE
	 * **/
	public Area areadetail(Long code) {
		AreaExample example = new AreaExample();
		AreaExample.Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(code);
		List<Area> AREA = areaMapper.selectByExample(example);
		if (!AREA.isEmpty() && AREA.size() >0) {
			return AREA.get(0);
		}
		return null;
	}

	/**地铁   新增/ 编辑
	 * @param metro.Finalstop  : 地铁站点
	 * @param metro.Name       : 地铁名称
	 * @param metro.metroid    : 地铁ID
	 * @param metro.code       : 地铁所属区域
	 * **/ 
	public ResultMap metroadd(Metro metro) {
		Metro metro_check = metroexist(metro);
		if (metro_check !=null) {
			return ResultMap.build(400, "该地铁路线和站点存在！");
		}
		if (metro.getFinalstop() == null || "".equals(metro.getFinalstop()) ) {
			return ResultMap.build(400, "站点不能为空！");
		}
		if (metro.getName() == null || "".equals(metro.getName()) ) {
			return ResultMap.build(400, "地铁路线不能为空！");
		}
		if (metro.getMetroid() == null) {
			metroMapper.insertSelective(metro);
			return ResultMap.build(200, "恭喜你发布成功！");
		} else {
			metroMapper.updateByPrimaryKeySelective(metro);
			return ResultMap.build(201, "恭喜你编辑成功！");
		}
		
		
		
		
	}

	// 判断地铁是否存在
	private Metro metroexist(Metro metro) {
		MetroExample example = new MetroExample();
		MetroExample.Criteria criteria = example.createCriteria();
		criteria.andCodeEqualTo(metro.getCode());
		criteria.andNameEqualTo(metro.getName());
		criteria.andFinalstopEqualTo(metro.getFinalstop());
		List<Metro> list = metroMapper.selectByExample(example);
		if ( !list.isEmpty() && list.size() >0) {
			return list.get(0);
		}
		return null;
	}

	/**
	 * 地铁查询
	 * @param code : 区域code
	 * @param currentpage : 当前页面
	 * @param pagesize    : 每页查询数目
	 * **/ 
	public List<MetroCustomer> mertrosearch(Long code ,PageQuery pagequery) {
		List<MetroCustomer> list = addressCustomerMapper.metrosearch(code, pagequery);
		return list;
	}
	@Override
	public int mertrosearchCount(Long code) {
		// TODO Auto-generated method stub
		return addressCustomerMapper.metrosearchCount(code);
	}

	/**地铁删除
	 *  @param metroid : 地铁ID
	 * **/ 
	public ResultMap metrodelete(Metro metro) {
		metroMapper.deleteByPrimaryKey(metro.getMetroid());
		return ResultMap.build(200, "恭喜你删除成功！");
	}

	/*** 根据站点查询地铁 
	 *  @param finalstop : 地铁站点
	 *  @param code : 地铁所属区域
	 * **/ 
	public ResultMap searchbycodeandfinalstop(Metro metro) {
		String code = metro.getCode().toString().substring(0, 2);
		metro.setCode(Long.valueOf(code));
		List<Metro> metrolist = addressCustomerMapper.searchbycodeandfinalstop(metro);
		return ResultMap.IS_200(metrolist);
	}

	/** 查询地铁的线路
	 * @param name : 地铁线路名称
	 * **/ 
	public ResultMap metrobyname(Metro metro) {
		if (metro.getCode() ==null) {return ResultMap.build(400,"检查区域");}
		String code = metro.getCode()+"";
		if (code.startsWith("11") || code.startsWith("12") || code.startsWith("31") || code.startsWith("50")) {
			code = code.substring(0, 2);
		}else {
			code = code.substring(0,4);
		}
		metro.setCode(Long.valueOf(code));
		List<Metro> metrolist = addressCustomerMapper.metrobyname(metro);
		return ResultMap.IS_200(metrolist);
	}

	/**
	 * 地铁详情
	 * **/
	public ResultMap metrodetail(Metro metro) {
		String code = metro.getCode()+".";
		if (code.startsWith("11") || code.startsWith("12") || code.startsWith("31") || code.startsWith("50")) {
			code = code.substring(0, 2);
		}else {
			if (code.length() > 4) {
				code = code.substring(0,4);
			}
		}
		metro.setCode(Long.valueOf(code));
		List<Metro> metrolist = addressCustomerMapper.metrodetail(metro);
		return ResultMap.IS_200(metrolist);
	}

	/**新增收货地址 
	 * @param deliveryphone : 联系人电话
	 * @param code : 街道CODE
	 * @param deliveryname  : 联系人姓名、
	 * @param deliveryaddress : 详情地址
	 * @param userid : 发布人ID
	 * **/
	public ResultMap adddDeli(Delivery delivery) {
		if (delivery.getDeliveryphone() == null || "".equals(delivery.getDeliveryphone())) {
			return ResultMap.build(400,"联系人电话不能为空");
		}
		if (delivery.getUserid() == null) {
			return ResultMap.build(400, "请先登录");
		}
		if (delivery.getCode() == null) {
			return ResultMap.build(400, "街道必须填写");
		}
		if (delivery.getDeliveryname() == null || "".equals(delivery.getDeliveryname())) {
			return ResultMap.build(400, "联系你必须填写 ");
		} 
		if (delivery.getDeliveryaddress() == null || "".equals(delivery.getDeliveryaddress())) {
			return ResultMap.build(400, "详情地址必须填写 ");
		}
		delivery.setUpdate_time(new Date());
		deliveryMapper.insertSelective(delivery);
		return ResultMap.build(200, "新增收货地址成功");
	}

	/**编辑收货地址 
	 * @param deliveryphone : 联系人电话
	 * @param deliveryid : 详情地址主键
	 * @param code : 街道CODE
	 * @param deliveryname  : 联系人姓名、
	 * @param deliveryaddress : 详情地址
	 * @param userid : 发布人ID
	 * **/
	public ResultMap editdelivery(Delivery delivery) {
		if (delivery.getDeliveryid() == null) {
			return ResultMap.build(400, "编辑错误，编辑的地址不存在");
		}
		
		deliveryMapper.updateByPrimaryKeySelective(delivery);
		return ResultMap.build(200, "更新成功");
	}

	/** 编辑收货地址 的查询
	 * @param Deliveryid : 收货地址ID
	 * **/
	public ResultMap searchdeliverybyid(Delivery de_livery) {
		Delivery delivery = deliveryMapper.selectByPrimaryKey(de_livery.getDeliveryid());
		if (delivery == null) {
			return ResultMap.build(400, "收货地址不存在");
		}
		//获得街道和区一级
		Delivery de_tr = releaseCustomerMapper.getTrandname(delivery.getCode());
		delivery.setDiscode(de_tr.getDiscode());
		delivery.setDisname(de_tr.getDisname());
		delivery.setTracode(de_tr.getTracode());
		delivery.setTradname(de_tr.getTradname());
		//获得区一级和市一级
		Delivery de_qu = releaseCustomerMapper.getquname(de_tr.getTracode());
		delivery.setCitycode(de_qu.getCitycode());
		delivery.setCityname(de_qu.getCityname());
		Delivery de_city = releaseCustomerMapper.getcityname(de_qu.getCitycode());
		delivery.setProcode(de_city.getProcode());
		delivery.setProname(de_city.getProname());
		return ResultMap.IS_200(delivery);
	}

	/** 根据城市查询类似的品牌
	 * @param city : 城市名称
	 * @param likename : 输入的品牌名称
	 * @param code : 城市code
	 * **/
	public List<Brand> getlikebrand(String likename ,String likecode) {
		return addressCustomerMapper.getlikebrand(likename ,likecode);
	}




}