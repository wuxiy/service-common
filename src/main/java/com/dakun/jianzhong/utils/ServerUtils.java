package com.dakun.jianzhong.utils;

/**
 * Created by wangh09 on Thu Jul 06 17:15:47 CST 2017.
 */
public class ServerUtils {
    public static final String API_LIST_URL = "http://resource-service/api/list";
    public static final String API_ADD_URL = "http://resource-service/api/add-batch";
    public static final String BAIDU_LBS_POI_HOST = "http://api.map.baidu.com/geodata/v3/poi/";
    public static final String BAIDU_GEOCODING_URL = "http://api.map.baidu.com/geocoder/v2/";
    public static final String BAIDU_LBS_POI_CREATE = BAIDU_LBS_POI_HOST + "create";
    public static final String BAIDU_LBS_POI_DETAIL = BAIDU_LBS_POI_HOST + "detail";
    public static final String BAIDU_LBS_POI_LIST = BAIDU_LBS_POI_HOST + "list";
    public static final String BAIDU_AK = "8cyBzD0qPEPHZKYuXkq01wvKmmXIioTo";
    public static final String BAIDU_GEOTABLE = "175728";
    public static final String COORD_TYPE = "1";
    public static final String SOCIAL_MINE_URL = "http://social-service/mine/get";
    public static final String RESOURCE_CROP_MINE_URL = "http://resource-service/crop/getMyConcernCrops";
    public static final String SOCIAL_TAG_URL = "http://social-service/tag";
    public static final String RESOURCE_PESTICIDE_URL = "http://resource-service/pesticide";
    public static final String ACCOUNT_USER_LIST = "http://account-service/user/list";
    public static final String ACCOUNT_USER_GET = "http://account-service/user/get";
    public static final String ACCOUNT_USER_GET_SIMPLE = "http://account-service/user/getSimple";
    public static final String ACCOUNT_MESSAGE_SOCIAL_FOLLOW_COMMENT_PUSH = "http://account-service/message/socialFollowCommentPush";
    public static final String ACCOUNT_MESSAGE_SOCIAL_FOLLOW_CONVERSATION_PUSH = "http://account-service/message/socialFollowConversationPush";
    public static final String ACCOUNT_MESSAGE_SOCIAL_ATTITUDE_PUSH = "http://account-service/message/socialAttitudePush";
    public static final String ACCOUNT_FOLLOW_LIST = "http://account-service/follow/list";
    public static final String ACCOUNT_EXPERT_GET = "http://account-service/expert/get";
    public static final String ACCOUNT_DEALER_GET = "http://account-service/dealer/get";
}
