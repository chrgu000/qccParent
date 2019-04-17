package cn.com.qcc.service;

import cn.com.qcc.queryvo.HouseCustomer;

public interface PosterCreateService {
	
	/**创建个人名片海报
	 * @param username    : 用户昵称
	 * @param avatar      : 头像的超链接
	 * @param contentPath : 背景图片路径 + 文件名称
	 * @param serialCode  : 推荐码
	 * @param backimageUrl: 背景图片的真实路径
	 * **/
	public String createUserPoster (String username , String avatar  , String serialCode ,
			String backimageUrl) ;
	
	
	/**创建个人名片海报
	 * @param prices             : 房源价格
	 * @param apartmentname      : 头像的超链接
	 * @param houseid            : 房源对应的id
	 * @param onePicture         : 背景图片 房源的图片URL
	 * @param detailName         : 房源二维码类型
	 * **/
	public String createHousePoster (String prices , String apartmentname   ,
			String onePicture , Long houseid , String  detailName) ;


	public HouseCustomer searchHousePostMess(Long houseid);

}
