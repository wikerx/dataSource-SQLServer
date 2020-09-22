package com.scott.ds.common.dateutils;

/**
 * @author :Mr.薛
 * @version :V1.0
 * @classdateType :DateParttern
 * @description : 时间格式枚举
 * @data :2020/7/10 0010 下午 2:08
 * @status : 编写
 **/
public enum DateParttern {

    FROMAT1("yyyy-MM-dd",1),
    FROMAT2("yyyy-MM-dd HH:mm",2),
    FROMAT3("yyyy-MM",3),
    FROMAT4("yyyy/MM/dd",4),
    FROMAT5("yyyy-MM-dd HH:mm:ss.sss",5),
    FROMAT6("yyyyMMddHHmmss",6),
    FROMAT7("yyyyMMdd",7),
    FROMAT8("yyyyMM",8);

    // 成员变量
    private String dateType;
    private int index;
    // 构造方法
    private DateParttern(String dateType, int index) {
        this.dateType = dateType;
        this.index = index;
    }
    // 普通方法
    public static String getDateType(int index) {
        for (DateParttern c : DateParttern.values()) {
            if (c.getIndex() == index) {
                return c.dateType;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getDateType(1));
    }


//    get set

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
