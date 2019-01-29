package cn.com.qcc.queryvo;

import cn.com.qcc.common.PageQuery;
import cn.com.qcc.pojo.Metro;

public class VillageeVo {
	private AddressCustomer addressCustomer = new AddressCustomer();
	private HouseCustomer houseCustomer = new HouseCustomer();
	private BuildingCustomer buildingCustomer = new BuildingCustomer();
	private AreaCustomer areaCustomer = new AreaCustomer();
	private VillageCustomer villageCustomer = new VillageCustomer();
	private HousetagCustomer housetagCustomer = new HousetagCustomer();
	private UserCustomer userCustomer = new UserCustomer();
	// 房源类型的查询条件
	private PropertyCustomer propertyCustomer = new PropertyCustomer();
	// 价格的查询条件
	private PriceCustomer priceCustomer = new PriceCustomer();
	private ApartmentCustomer apartmentCustomer = new ApartmentCustomer();
	private PageQuery pagequery;
	private Integer villageid;
	private Long userid;
	private String juli;
	private Long buildingid;
	private String orderjuli;
	private Metro metro = new Metro();
	private String orderprice;
	private String pictureshanxuann;
	private String messageshanxuan;

	public String getPictureshanxuann() {
		return pictureshanxuann;
	}


	public void setPictureshanxuann(String pictureshanxuann) {
		this.pictureshanxuann = pictureshanxuann;
	}

	public String getMessageshanxuan() {
		return messageshanxuan;
	}

	public void setMessageshanxuan(String messageshanxuan) {
		this.messageshanxuan = messageshanxuan;
	}

	public Metro getMetro() {
		return metro;
	}

	public void setMetro(Metro metro) {
		this.metro = metro;
	}

	public String getOrderjuli() {
		return orderjuli;
	}

	public Long getBuildingid() {
		return buildingid;
	}

	public void setBuildingid(Long buildingid) {
		this.buildingid = buildingid;
	}

	public void setOrderjuli(String orderjuli) {
		this.orderjuli = orderjuli;
	}

	public String getOrderprice() {
		return orderprice;
	}

	public void setOrderprice(String orderprice) {
		this.orderprice = orderprice;
	}

	public String getJuli() {
		return juli;
	}

	public void setJuli(String juli) {
		this.juli = juli;
	}

	public UserCustomer getUserCustomer() {
		return userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}

	public AddressCustomer getAddressCustomer() {
		return addressCustomer;
	}

	public void setAddressCustomer(AddressCustomer addressCustomer) {
		this.addressCustomer = addressCustomer;
	}

	public HousetagCustomer getHousetagCustomer() {
		return housetagCustomer;
	}

	public void setHousetagCustomer(HousetagCustomer housetagCustomer) {
		this.housetagCustomer = housetagCustomer;
	}

	public PropertyCustomer getPropertyCustomer() {
		return propertyCustomer;
	}

	public void setPropertyCustomer(PropertyCustomer propertyCustomer) {
		this.propertyCustomer = propertyCustomer;
	}

	public PriceCustomer getPriceCustomer() {
		return priceCustomer;
	}

	public void setPriceCustomer(PriceCustomer priceCustomer) {
		this.priceCustomer = priceCustomer;
	}

	public ApartmentCustomer getApartmentCustomer() {
		return apartmentCustomer;
	}

	public void setApartmentCustomer(ApartmentCustomer apartmentCustomer) {
		this.apartmentCustomer = apartmentCustomer;
	}

	public HouseCustomer getHouseCustomer() {
		return houseCustomer;
	}

	public void setHouseCustomer(HouseCustomer houseCustomer) {
		this.houseCustomer = houseCustomer;
	}

	public PageQuery getPagequery() {
		return pagequery;
	}

	public void setPagequery(PageQuery pagequery) {
		this.pagequery = pagequery;
	}

	public BuildingCustomer getBuildingCustomer() {
		return buildingCustomer;
	}

	public void setBuildingCustomer(BuildingCustomer buildingCustomer) {
		this.buildingCustomer = buildingCustomer;
	}

	public AreaCustomer getAreaCustomer() {
		return areaCustomer;
	}

	public void setAreaCustomer(AreaCustomer areaCustomer) {
		this.areaCustomer = areaCustomer;
	}

	public VillageCustomer getVillageCustomer() {
		return villageCustomer;
	}

	public void setVillageCustomer(VillageCustomer villageCustomer) {
		this.villageCustomer = villageCustomer;
	}

	public Integer getVillageid() {
		return villageid;
	}

	public void setVillageid(Integer villageid) {
		this.villageid = villageid;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}


	
	
	
	

	

}
