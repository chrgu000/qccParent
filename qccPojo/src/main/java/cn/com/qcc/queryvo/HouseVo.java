package cn.com.qcc.queryvo;

import java.util.Date;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.pojo.Metro;


public class HouseVo {
	
	private PageQuery pagequery; //分页的查询条件
	
	private BuildingCustomer buildingCustomer = new BuildingCustomer();//楼栋相关的封装
	
	private HouseCustomer houseCustomer = new HouseCustomer();
	
	private Date start_time;
	
	private Date end_time;
	
	private BrandCustomer brandCustomer = new BrandCustomer();
	private AreaCustomer areaCustomer = new AreaCustomer();
	private AuthCustomer  authCustomer = new AuthCustomer();
	private Long userid;
	private HousetagCustomer housetagCustomer = new HousetagCustomer();
	private Metro metro = new Metro();
	private VillageCustomer villageCustomer = new VillageCustomer();
	private QiuzuCustomer qiuzuCustomer = new QiuzuCustomer();
	// 价格的查询条件
	private PriceCustomer priceCustomer = new PriceCustomer();

	// 房源类型的查询条件
	private PropertyCustomer propertyCustomer = new PropertyCustomer();
	// 房源类型的查询条件
	private ApartmentCustomer apartmentCustomer = new ApartmentCustomer();
	
	private AddressCustomer addressCustomer = new AddressCustomer() ;
	
	private Integer house_id;
	
	private Integer messagesType;
	
	private UserCustomer userCustomer;
	
	private String juli ;
	
	private String orderbyjuli;
	
	private String orderbytime;
	
	private String inUserIds ;
	
	
	
	
	
	public String getInUserIds() {
		return inUserIds;
	}

	public void setInUserIds(String inUserIds) {
		this.inUserIds = inUserIds;
	}

	public BrandCustomer getBrandCustomer() {
		return brandCustomer;
	}

	public void setBrandCustomer(BrandCustomer brandCustomer) {
		this.brandCustomer = brandCustomer;
	}

	public AreaCustomer getAreaCustomer() {
		return areaCustomer;
	}

	public void setAreaCustomer(AreaCustomer areaCustomer) {
		this.areaCustomer = areaCustomer;
	}

	public AuthCustomer getAuthCustomer() {
		return authCustomer;
	}

	public void setAuthCustomer(AuthCustomer authCustomer) {
		this.authCustomer = authCustomer;
	}

	public HousetagCustomer getHousetagCustomer() {
		return housetagCustomer;
	}

	public void setHousetagCustomer(HousetagCustomer housetagCustomer) {
		this.housetagCustomer = housetagCustomer;
	}

	public Metro getMetro() {
		return metro;
	}

	public void setMetro(Metro metro) {
		this.metro = metro;
	}

	public VillageCustomer getVillageCustomer() {
		return villageCustomer;
	}

	public void setVillageCustomer(VillageCustomer villageCustomer) {
		this.villageCustomer = villageCustomer;
	}

	public QiuzuCustomer getQiuzuCustomer() {
		return qiuzuCustomer;
	}

	public void setQiuzuCustomer(QiuzuCustomer qiuzuCustomer) {
		this.qiuzuCustomer = qiuzuCustomer;
	}

	public PriceCustomer getPriceCustomer() {
		return priceCustomer;
	}

	public void setPriceCustomer(PriceCustomer priceCustomer) {
		this.priceCustomer = priceCustomer;
	}

	public PropertyCustomer getPropertyCustomer() {
		return propertyCustomer;
	}

	public void setPropertyCustomer(PropertyCustomer propertyCustomer) {
		this.propertyCustomer = propertyCustomer;
	}

	public ApartmentCustomer getApartmentCustomer() {
		return apartmentCustomer;
	}

	public void setApartmentCustomer(ApartmentCustomer apartmentCustomer) {
		this.apartmentCustomer = apartmentCustomer;
	}

	public AddressCustomer getAddressCustomer() {
		return addressCustomer;
	}

	public void setAddressCustomer(AddressCustomer addressCustomer) {
		this.addressCustomer = addressCustomer;
	}

	public Integer getHouse_id() {
		return house_id;
	}

	public void setHouse_id(Integer house_id) {
		this.house_id = house_id;
	}

	public Integer getMessagesType() {
		return messagesType;
	}

	public void setMessagesType(Integer messagesType) {
		this.messagesType = messagesType;
	}

	public UserCustomer getUserCustomer() {
		return userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}

	public String getJuli() {
		return juli;
	}

	public void setJuli(String juli) {
		this.juli = juli;
	}

	public String getOrderbyjuli() {
		return orderbyjuli;
	}

	public void setOrderbyjuli(String orderbyjuli) {
		this.orderbyjuli = orderbyjuli;
	}

	public String getOrderbytime() {
		return orderbytime;
	}

	public void setOrderbytime(String orderbytime) {
		this.orderbytime = orderbytime;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public HouseCustomer getHouseCustomer() {
		return houseCustomer;
	}

	public void setHouseCustomer(HouseCustomer houseCustomer) {
		this.houseCustomer = houseCustomer;
	}

	public BuildingCustomer getBuildingCustomer() {
		return buildingCustomer;
	}

	public void setBuildingCustomer(BuildingCustomer buildingCustomer) {
		this.buildingCustomer = buildingCustomer;
	}

	

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public PageQuery getPagequery() {
		return pagequery;
	}

	public void setPagequery(PageQuery pagequery) {
		this.pagequery = pagequery;
	}
	
	

}
