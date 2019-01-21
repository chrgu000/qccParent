package cn.com.qcc.queryvo;

import cn.com.qcc.pojo.Tribe;

//接受部落或者群返回值
public class TribeCustomer extends Tribe {

	private Integer browseid;
	// 部落图像
	private String tribepicture;

	// 发布物品的标题
	private String title;

	// 发布物品类别的名称
	private String typename;

	// 发布物品的图片
	private String thingpicture;
	// 当前物品的留言总数
	private Integer mescount;
	// 总人数
	private Integer pcount;
	// 粉丝总数
	private Integer fcount;
	// 部落总数
	private Integer tcount;
	// 用户名
	private String user_name;
	// 用户头像
	private String avatar;
	
	private String comfrom;
	
	// 获取一张
	private String onepicture;
	//价格单位
	private String  pricestype;
	//价格
	private String prices;
	
	private String trading;
	
	private String villagename;
	
	private String apartmentname;
	
	private String housetitle;
	
	private String house_number;
	
	private Integer type;
	
	private String mes;
	

	public Integer getBrowseid() {
		return browseid;
	}

	public void setBrowseid(Integer browseid) {
		this.browseid = browseid;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getTrading() {
		return trading;
	}

	public void setTrading(String trading) {
		this.trading = trading;
	}

	public String getVillagename() {
		return villagename;
	}

	public void setVillagename(String villagename) {
		this.villagename = villagename;
	}

	public String getApartmentname() {
		return apartmentname;
	}

	public void setApartmentname(String apartmentname) {
		this.apartmentname = apartmentname;
	}

	public String getHousetitle() {
		return housetitle;
	}

	public void setHousetitle(String housetitle) {
		this.housetitle = housetitle;
	}

	public String getHouse_number() {
		return house_number;
	}

	public void setHouse_number(String house_number) {
		this.house_number = house_number;
	}

	public Integer getType() {
		return type;
	}

	public String getComfrom() {
		return comfrom;
	}

	public void setComfrom(String comfrom) {
		this.comfrom = comfrom;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPricestype() {
		return pricestype;
	}

	public void setPricestype(String pricestype) {
		this.pricestype = pricestype;
	}


	public String getOnepicture() {
		if(onepicture !=null && !"".equals(onepicture)){
			onepicture =  onepicture.split(",")[0];
		}
		return onepicture;
	}
	

	public String getPrices() {
		return prices;
	}

	public void setPrices(String prices) {
		this.prices = prices;
	}

	public void setOnepicture(String onepicture) {
		if(onepicture !=null && !"".equals(onepicture)){
			onepicture =  onepicture.split(",")[0];
		}
		this.onepicture = onepicture;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getFcount() {
		return fcount;
	}

	public void setFcount(Integer fcount) {
		this.fcount = fcount;
	}

	public Integer getTcount() {
		return tcount;
	}

	public void setTcount(Integer tcount) {
		this.tcount = tcount;
	}

	public Integer getPcount() {
		return pcount;
	}

	public void setPcount(Integer pcount) {
		this.pcount = pcount;
	}

	// 部落里面物品的唯一主键
	private Integer articledetailid;

	public Integer getArticledetailid() {
		return articledetailid;
	}

	public void setArticledetailid(Integer articledetailid) {
		this.articledetailid = articledetailid;
	}

	public Integer getMescount() {
		return mescount;
	}

	public void setMescount(Integer mescount) {
		this.mescount = mescount;
	}

	public String getTribepicture() {
		return tribepicture;
	}

	public void setTribepicture(String tribepicture) {
		this.tribepicture = tribepicture;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getThingpicture() {
		return thingpicture;
	}

	public void setThingpicture(String thingpicture) {
		this.thingpicture = thingpicture;
	}

}
