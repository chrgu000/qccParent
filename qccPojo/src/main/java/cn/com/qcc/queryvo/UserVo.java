package cn.com.qcc.queryvo;

import cn.com.qcc.common.PageQuery;

public class UserVo {

	private AreaCustomer addressCustomer;

	private UserCustomer userCustomer;
	
	private VillageCustomer villageCustomer;
	
	private BrandCustomer brandCustomer;
	// 分页查询
	private PageQuery pagequery;
	
	private String orderinmonetary;
	
	private String orderoutmonetary;
	
	private String ordervipmonetary;
	private String enorder;
	private String searchwhere;
	private String telephone;
	
	private String rolename;
	
	private String userstate ;
	
	private Long userid;
	
	private Integer type;
	
	
	public String getUserstate() {
		return userstate;
	}

	public void setUserstate(String userstate) {
		this.userstate = userstate;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public BrandCustomer getBrandCustomer() {
		return brandCustomer;
	}

	public void setBrandCustomer(BrandCustomer brandCustomer) {
		this.brandCustomer = brandCustomer;
	}

	public String getSearchwhere() {
		return searchwhere;
	}

	public void setSearchwhere(String searchwhere) {
		this.searchwhere = searchwhere;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getOrdervipmonetary() {
		return ordervipmonetary;
	}

	public void setOrdervipmonetary(String ordervipmonetary) {
		this.ordervipmonetary = ordervipmonetary;
	}

	public String getOrderoutmonetary() {
		return orderoutmonetary;
	}

	public void setOrderoutmonetary(String orderoutmonetary) {
		this.orderoutmonetary = orderoutmonetary;
	}

	public String getOrderinmonetary() {
		return orderinmonetary;
	}

	public void setOrderinmonetary(String orderinmonetary) {
		this.orderinmonetary = orderinmonetary;
	}

	public VillageCustomer getVillageCustomer() {
		return villageCustomer;
	}

	public void setVillageCustomer(VillageCustomer villageCustomer) {
		this.villageCustomer = villageCustomer;
	}

	public String getEnorder() {
		return enorder;
	}

	public void setEnorder(String enorder) {
		this.enorder = enorder;
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

	public UserCustomer getUserCustomer() {
		return userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}

}
