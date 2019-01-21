package cn.com.qcc.queryvo;

import cn.com.qcc.common.PageQuery;

public class CommunityVo {

	private VillageCustomer villageCustomer;
	
	private CommunityCustomer communityCustomer;

	private AreaCustomer addressCustomer;

	private PageQuery pagequery;

	private HousetagCustomer housetagCustomer;

	// 房间类型的查询条件
	private HouseCustomer houseCustomer;

	// 房源类型的查询条件
	private PropertyCustomer propertyCustomer;

	// 价格的查询条件
	private PriceCustomer priceCustomer;
	
	private ApartmentCustomer apartmentCustomer;
	
	

	public ApartmentCustomer getApartmentCustomer() {
		return apartmentCustomer;
	}

	public void setApartmentCustomer(ApartmentCustomer apartmentCustomer) {
		this.apartmentCustomer = apartmentCustomer;
	}

	public PriceCustomer getPriceCustomer() {
		return priceCustomer;
	}

	public VillageCustomer getVillageCustomer() {
		return villageCustomer;
	}

	public void setVillageCustomer(VillageCustomer villageCustomer) {
		this.villageCustomer = villageCustomer;
	}

	public void setPriceCustomer(PriceCustomer priceCustomer) {
		this.priceCustomer = priceCustomer;
	}

	public PageQuery getPagequery() {
		return pagequery;
	}

	public void setPagequery(PageQuery pagequery) {
		this.pagequery = pagequery;
	}

	public AreaCustomer getAddressCustomer() {
		return addressCustomer;
	}

	public void setAddressCustomer(AreaCustomer addressCustomer) {
		this.addressCustomer = addressCustomer;
	}

	public CommunityCustomer getCommunityCustomer() {
		return communityCustomer;
	}

	public void setCommunityCustomer(CommunityCustomer communityCustomer) {
		this.communityCustomer = communityCustomer;
	}

	public HousetagCustomer getHousetagCustomer() {
		return housetagCustomer;
	}

	public void setHousetagCustomer(HousetagCustomer housetagCustomer) {
		this.housetagCustomer = housetagCustomer;
	}

	public HouseCustomer getHouseCustomer() {
		return houseCustomer;
	}

	public void setHouseCustomer(HouseCustomer houseCustomer) {
		this.houseCustomer = houseCustomer;
	}

	public PropertyCustomer getPropertyCustomer() {
		return propertyCustomer;
	}

	public void setPropertyCustomer(PropertyCustomer propertyCustomer) {
		this.propertyCustomer = propertyCustomer;
	}

}
