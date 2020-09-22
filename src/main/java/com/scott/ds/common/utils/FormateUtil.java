package com.scott.ds.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.regex.Pattern;

/**
 * @author :Mr.薛
 * @version :V1.0
 * @className :FormateUtil
 * @description : 数据格式化
 * @data :2020/7/10 0010 下午 2:36
 * @status : 编写
 **/
public class FormateUtil {
    private static Pattern MONEY_FORMATE = Pattern.compile("^[+]?([0-9]+(.[0-9]{1,2})?)$");
    private static Pattern IS_NUMBER = Pattern.compile("^[-\\+]?[\\d]*$");
    private static Pattern IS_EMAIL = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
    private static String IS_IP = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";

    public static void main(String[] args) {
        System.out.println(judgeTwoDecimal(new BigDecimal("1.01")));
        System.out.println(isNumber("511111111111111111"));
        System.out.println(isEmail("123123163.cn"));
        System.out.println(isIp("192.168.0.55"));
        System.out.println(decimalFormat(45.85549));
        System.out.println(decimalFormate(new BigDecimal("45.85549"),4));
        System.out.println(numberFormat(45.85549,4));
    }

    /**
     * 左补0
     * @param length 数据总长度
     * @param str 数据库
     * @return String  数据左补0之后得到的长度
     * */
    public static String leftFillZero(int length,String str){
        if(Ognl.isEmpty(str)){
            str = "0";
            return String.format("%0" + length + "d", Long.parseLong(str));
        }
        if(str.length()>length){
            return str.substring(0, length);
        }else{
            int len = length - str.length();
            if(len > 0) {
                String str1 = String.format("%0" + len + "d", Long.parseLong("0"));
                return str1 + str;
            }else{
                return str.substring(0,length);
            }
        }
    }

    /**
     * 金额格式化
     * @param amount
     * */
    public static String decimalFormat(double amount){
        //保留两位小数 - 截取
        DecimalFormat df = new DecimalFormat("#0.00");
        /**
        DecimalFormat decimalFormat = new DecimalFormat();
//      #：位置上无数字不显示
        decimalFormat.applyPattern("#.##");
        System.out.println(decimalFormat.format(345235.0));// 345235
        // 0:位置上无数字显示0
        decimalFormat.applyPattern("0.00");
        System.out.println(decimalFormat.format(345235.0));// 345235.00
        // 加负数显示
        decimalFormat.applyPattern("-0.00");
        System.out.println(decimalFormat.format(345235.34567));// -345235.35
        // 逗号分隔
        decimalFormat.applyPattern("-0,000.00");
        System.out.println(decimalFormat.format(345235.34567));// -345,235.35
        // 百分位
        decimalFormat.applyPattern("0.00%");
        System.out.println(decimalFormat.format(0.34567));// 34.57%
        // 千分位
        decimalFormat.applyPattern("0.00\u2030");
        System.out.println(decimalFormat.format(0.34567));// 345.67‰
        // 科学计数法,E之前是底数的格式，E之后的是指数的格式
        decimalFormat.applyPattern("0.00E00");
        System.out.println(decimalFormat.format(2342.444));// 2.34E03
        // 格式后面加单位符号
        decimalFormat.applyPattern("0.00 KG");
        System.out.println(decimalFormat.format(2342.444));// 2342.44 KG
        decimalFormat.applyPattern("0.00 QA");
        System.out.println(decimalFormat.format(2342.444));// 2342.44 QA
        // 使用舍入模式：ROUND_HALF_EVEN，
        // 保留位数是奇数，使用ROUND_HALF_DOWN
        // 保留位数是偶数，使用ROUND_HALF_UP
        System.out.println(decimalFormat.format(2342.435));// 2342.43 QA
        System.out.println(decimalFormat.format(2342.445));// 2342.45 QA

        // String.format
        // 保留两位小数，个位数及小数点后两位无数字填充0，四舍五入
        System.out.println(String.format("%.2f", 0.2));// 0.20
        System.out.println(String.format("%.2f", 0.235));// 0.24
        System.out.println(String.format("%.2f", 0.236));// 0.24
        System.out.println(String.format("%.2f", 42.0));// 42.00
        **/


        return df.format(amount);
    }

    /**
     * 金额四舍五入
     * @param amount ：金额
     * @param newScale : 保留几位
     * */
    public static BigDecimal decimalFormate(BigDecimal amount,int newScale){
        amount = amount.setScale(newScale, BigDecimal.ROUND_HALF_UP);
        return amount;
    }

    /**
     * 金额四舍五入
     * @param amount ：金额
     * @param digits ：保留位数
     * */
    public static String numberFormat(double amount, int digits){
        NumberFormat nformat = NumberFormat.getNumberInstance();
        nformat.setMaximumFractionDigits(digits);
        return nformat.format(amount);
    }

    /**
     * 两位小数金额校验，2位以为都是可以的
     * @param obj : 任意格式金额
     *            true:ok  false:非法格式参数
     * */
    public static boolean judgeTwoDecimal(Object obj) {
        boolean flag = false;
        try {
            if (obj != null) {
                String source = obj.toString();
                // 判断是否是整数或者是携带一位或者两位的小数
                if (MONEY_FORMATE.matcher(source).matches()) {
                    flag = true;
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return flag;
    }

    /**
     * 判断字符串是否为纯数字
     * @param str :字符串
     *            true:ok  false:非法格式参数
     * */
    public static boolean isNumber(String str) {
        return IS_NUMBER.matcher(str).matches();
    }

    /**
     * 邮箱是否合法
     * @param email
     *            true:ok  false:非法格式参数
     * */
    public static boolean isEmail(String email) {
        return IS_EMAIL.matcher(email).matches();
    }

    /**
     * 邮箱是否合法
     * @param ip
     *            true:ok  false:非法格式参数
     * */
    public static boolean isIp(String ip) {
        return ip.matches(IS_IP);
    }

}
