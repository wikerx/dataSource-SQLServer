package com.scott.ds.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author :Mr.薛
 * @version :V1.0
 * @className :IdentityUtil
 * @description : 订单号生成策略
 * @data :2020/7/13 0013 上午 10:45
 * @status : 编写
 **/
public class IdentityUtil {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    private static int[] SEED_BUFFER;
    private static int SEED_BUFFER_INDEX = 0;
    private static int SEED_SIZE = 1000000;
    private static int[] SOURCE_BUFFER;
    private static long startInitTime = 0;

    private static Long markCode = -1L;

    /**
     * 订单号生成
     * */
    public static synchronized String getOrderNo(){
        return DATE_FORMAT.format(new Date()) + getRandom();
    }

    /**
     * 随机数生成策略
     * */
    public static synchronized String getRandom(){
        if (SEED_BUFFER == null || SEED_BUFFER_INDEX >= SEED_BUFFER.length){
            initSourceBuffer();
            SEED_BUFFER = getRandomArray();
            SEED_BUFFER_INDEX = 0;
            startInitTime = System.currentTimeMillis();
        }
        String random = String.valueOf(SEED_BUFFER[SEED_BUFFER_INDEX]);
        for (int i = random.length(); i < 6; i++) {
            random = "0"+random;
        }
        SEED_BUFFER_INDEX ++;
        if((SEED_BUFFER_INDEX+1) % SEED_SIZE == 0){
            try {
                long i = 1000 - (System.currentTimeMillis() - startInitTime);
                if(i>0) {
                    Thread.sleep(i);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return random;
    }

    /**
     * 随机数组
     * */
    private static int[] getRandomArray() {
        int[]ranArr = new int[SEED_SIZE];
        Random ran = new Random();
        for (int i = 0; i<SOURCE_BUFFER.length; i++) {
            int j = ran.nextInt(SOURCE_BUFFER.length - i);
            ranArr[i] = SOURCE_BUFFER[j];
            SOURCE_BUFFER[j] = SOURCE_BUFFER[SOURCE_BUFFER.length - 1 - i];
        }
        return ranArr;
    }

    /**
     * 初始化
     * */
    private static void initSourceBuffer() {
        SOURCE_BUFFER = new int[SEED_SIZE];
        for (int i = 0; i < SEED_SIZE; i++) {
            SOURCE_BUFFER[i] = i;
        }
    }

}
