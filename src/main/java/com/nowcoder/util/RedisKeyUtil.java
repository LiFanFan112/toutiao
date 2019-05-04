package com.nowcoder.util;


public class RedisKeyUtil {
    private static String SPLIT = ":";
    private static String BIZ_LIKE = "LIKE";
    private static String BIZ_DISLIKE = "DISLIKE";
    private static String BIZ_EVENT = "EVENT";

    //粉丝
    private static String BIZ_FOLLOWER = "FOLLOWER";

    //关注对象
    private static String BIZ_FOLLOWEE = "FOLLOWEE";

    public static String getEventQueueKey() {
        return BIZ_EVENT;
    }

    public static String getLikeKey(int entityId, int entityType) {
        return BIZ_LIKE + SPLIT + String.valueOf(entityType) + SPLIT + String.valueOf(entityId);
    }

    public static String getDisLikeKey(int entityId, int entityType) {
        return BIZ_DISLIKE + SPLIT + String.valueOf(entityType) + SPLIT + String.valueOf(entityId);
    }

    public static String getFollowerKey(int entityType,int entityId){
        //每一个实体所有粉丝的key
        return BIZ_FOLLOWER+SPLIT+String.valueOf(entityType)+SPLIT+String.valueOf(entityId);
    }

    public static String getFolloweeKey(int userId,int entityType){
        //用户关注的所有尸体
        return BIZ_FOLLOWER+SPLIT+String.valueOf(userId)+SPLIT+String.valueOf(entityType);
    }

}
