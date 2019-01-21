package cn.com.qcc.queryvo;

import cn.com.qcc.common.PageQuery;

//部落的入参
public class TribeVo {
	
	private UserCustomer userCustomer;
	private PageQuery pagequery;
	
	private AddressCustomer addressCustomer = new AddressCustomer();
	
	private ArticleTypeCustomer articleTypeCustomer;
	
	private TribecontrollerCustomer tribecontrollerCustomer;
	
	private TribeTypeCustomer tribeTypeCustomer;
	
	private TribeCustomer tribeCustomer;
	
	private BrowerCustomer browerCustomer;
	
	private TypeDetailCustomer typedetailCustomer;
	
	private Long userid;
	
	private Long articledetailid;
	
	

	public TypeDetailCustomer getTypedetailCustomer() {
		return typedetailCustomer;
	}

	public void setTypedetailCustomer(TypeDetailCustomer typedetailCustomer) {
		this.typedetailCustomer = typedetailCustomer;
	}

	public Long getArticledetailid() {
		return articledetailid;
	}

	public void setArticledetailid(Long articledetailid) {
		this.articledetailid = articledetailid;
	}

	public UserCustomer getUserCustomer() {
		return userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public BrowerCustomer getBrowerCustomer() {
		return browerCustomer;
	}

	public void setBrowerCustomer(BrowerCustomer browerCustomer) {
		this.browerCustomer = browerCustomer;
	}

	public TribeTypeCustomer getTribeTypeCustomer() {
		return tribeTypeCustomer;
	}

	public void setTribeTypeCustomer(TribeTypeCustomer tribeTypeCustomer) {
		this.tribeTypeCustomer = tribeTypeCustomer;
	}

	public TribecontrollerCustomer getTribecontrollerCustomer() {
		return tribecontrollerCustomer;
	}

	public void setTribecontrollerCustomer(TribecontrollerCustomer tribecontrollerCustomer) {
		this.tribecontrollerCustomer = tribecontrollerCustomer;
	}

	public ArticleTypeCustomer getArticleTypeCustomer() {
		return articleTypeCustomer;
	}

	public void setArticleTypeCustomer(ArticleTypeCustomer articleTypeCustomer) {
		this.articleTypeCustomer = articleTypeCustomer;
	}
	

	public AddressCustomer getAddressCustomer() {
		return addressCustomer;
	}

	public void setAddressCustomer(AddressCustomer addressCustomer) {
		this.addressCustomer = addressCustomer;
	}

	public PageQuery getPagequery() {
		return pagequery;
	}

	public void setPagequery(PageQuery pagequery) {
		this.pagequery = pagequery;
	}

	

	public TribeCustomer getTribeCustomer() {
		return tribeCustomer;
	}

	public void setTribeCustomer(TribeCustomer tribeCustomer) {
		this.tribeCustomer = tribeCustomer;
	}
	
	

}
