package com.dakun.jianzhong.utils;

/**
 * Created by wangh09 on Thu Jul 06 17:15:47 CST 2017.
 */
public class ServerUtils {
    static final public String API_LIST_URL = "http://resource-service/api/list";
    static final public String API_ADD_URL = "http://resource-service/api/add-batch";
    static final public String BAIDU_LBS_POI_HOST = "http://api.map.baidu.com/geodata/v3/poi/";
    static final public String BAIDU_GEOCODING_URL = "http://api.map.baidu.com/geocoder/v2/";
    static final public String BAIDU_LBS_POI_CREATE = BAIDU_LBS_POI_HOST + "create";
    static final public String BAIDU_LBS_POI_DETAIL = BAIDU_LBS_POI_HOST + "detail";
    static final public String BAIDU_LBS_POI_LIST = BAIDU_LBS_POI_HOST + "list";
    static final public String BAIDU_AK = "8cyBzD0qPEPHZKYuXkq01wvKmmXIioTo";
    static final public String BAIDU_GEOTABLE = "175728";
    static final public String COORD_TYPE = "1";
    static final public String SOCIAL_MINE_URL = "http://social-service/mine/get";
    static final public String RESOURCE_CROP_MINE_URL = "http://resource-service/crop/getMyConcernCrops";
    static final public String SOCIAL_TAG_URL = "http://social-service/tag";
    static final public String RESOURCE_PESTICIDE_URL = "http://resource-service/pesticide";
    static final public String ACCOUNT_USER_LIST = "http://account-service/user/list";
    static final public String ACCOUNT_USER_GET = "http://account-service/user/get";
    static final public String ACCOUNT_USER_GET_SIMPLE = "http://account-service/user/getSimple";
}
