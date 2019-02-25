package cn.com.qcc.service;

import cn.com.qcc.common.ResultMap;
import cn.com.qcc.pojo.Housemodel;
import cn.com.qcc.queryvo.SearchResult;

public interface HouseModelService {

	ResultMap selectAddToHouseModel(Long houseid , Long userid);

	ResultMap oneHouseDelete(Long houseid , Long userid);

	ResultMap oneHouseSearch(Long houseModelId);

	SearchResult houseList(Housemodel model);

	ResultMap updateHouseModel(Housemodel houseModel);


}
