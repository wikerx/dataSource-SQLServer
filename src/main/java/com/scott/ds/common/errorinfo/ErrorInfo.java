package com.scott.ds.common.errorinfo;

import com.scott.ds.config.DefaultConfig;

/**
 * @author :Mr.薛
 * @version :V1.0
 * @className :ErrorInfo
 * @description : 定义异常返回的数据实体
 * @data :2020/7/10 0010 下午 6:17
 * @status : 编写
 **/
public class ErrorInfo {
    /**
     * 顺序标识
     * */
    private int identify;
    /**
     * 对外返回码
     * */
    private String respCode;
    /**
     * 返回码说明：中文
     * */
    private String respDesc;
    /**
     * 返回码说明：英文
     * */
    private String respDescCn;

//    get set


    public int getIdentify() {
        return identify;
    }

    public void setIdentify(int identify) {
        this.identify = identify;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public String getRespDescCn() {
        return respDescCn;
    }

    public void setRespDescCn(String respDescCn) {
        this.respDescCn = respDescCn;
    }


    /**
     * 获取返回码的详细信息
     * @param num :标识
     * */
    public static ErrorInfo getMsg(int num){
        ErrorInfo info = new ErrorInfo();
        String respCode = "";
        String respDesc = "";
        String respDescCn = "";
        switch (num){
//            成功的交易
            case 0:
                respCode = DefaultConfig.RESPONSE_CODE_SUCCEED;
                respDesc = DefaultConfig.RESPONSE_EXPLAIN_SUCCEED;
                respDescCn = "交易成功";
                break;
            case 1:
                respCode = "M0001";
                respDesc = "Pending";
                respDescCn = "交易待处理";
                break;
            case 2:
                respCode = "M0002";
                respDesc = "merchantNo cannot be empty";
                respDescCn = "商户号不能为空";
                break;
            case 3:
                respCode = "M0003";
                respDesc = "merOrderNo cannot be empty";
                respDescCn = "商户订单号不能为空";
                break;
            case 4:
                respCode = "M0004";
                respDesc = "merOrderNo already exists";
                respDescCn = "商户订单号重复";
                break;
            case 5:
                respCode = "M0005";
                respDesc = "payCurrency cannot be empty";
                respDescCn = "支付币种不能为空";
                break;
            case 6:
                respCode = "M0006";
                respDesc = "payCurrency format is illegal";
                respDescCn = "支付币种格式不合法";
                break;
            case 7:
                respCode = "M0007";
                respDesc = "payAmount cannot be empty";
                respDescCn = "支付金额不能为空";
                break;
            case 8:
                respCode = "M0008";
                respDesc = "Payment amount cannot be less than 1 USD";
                respDescCn = "支付金额不能小于1美金";
                break;
            case 9:
                respCode = "M0009";
                respDesc = "PayAmount parameter format is invalid";
                respDescCn = "支付金额参数格式不合法";
                break;
            case 10:
                respCode = "M0010";
                respDesc = "Unsupported payCurrency";
                respDescCn = "支付币种不支持";
                break;
            case 11:
                respCode = "M0011";
                respDesc = "sourceUrl cannot be empty";
                respDescCn = "sourceUrl 不能为空";
                break;
            case 12:
                respCode = "M0012";
                respDesc = "sourceUrl is not allowed";
                respDescCn = "sourceUrl 不被允许";
                break;
            case 13:
                respCode = "M0013";
                respDesc = "ieLanguage cannot be empty";
                respDescCn = "浏览器语言不能为空";
                break;
            case 14:
                respCode = "M0014";
                respDesc = "ieLanguage is illegal";
                respDescCn = "浏览器语言格式不合法";
                break;
            case 15:
                respCode = "M0015";
                respDesc = "goods cannot be empty";
                respDescCn = "商品信息不能为空";
            case 16:
                respCode = "M0016";
                respDesc = "goods is illegal";
                respDescCn = "商品信息格式不合法";
                break;
            case 17:
                respCode = "M0017";
                respDesc = "Source URL collection error";
                respDescCn = "来源网址收集错误";
                break;
            case 18:
                respCode = "M0018";
                respDesc = "cardNo cannot be empty";
                respDescCn = "卡号不能为空";
                break;
            case 19:
                respCode = "M0019";
                respDesc = "Card number format is illegal";
                respDescCn = "卡号格式不合法";
                break;
            case 20:
                respCode = "M0020";
                respDesc = "Invalid card number";
                respDescCn = "无效卡号";
                break;
            case 21:
                respCode = "M0021";
                respDesc = "Expired card";
                respDescCn = "过期卡";
                break;
            case 22:
                respCode = "M0022";
                respDesc = "cardExpireDate cannot be empty";
                respDescCn = "卡有效期不能为空";
                break;
            case 23:
                respCode = "M0023";
                respDesc = "cardExpireDate Parameter format is incorrect(MMYYYY)";
                respDescCn = "cardExpireDate 参数格式不合法(MMYYYY)";
                break;
            case 24:
                respCode = "M0024";
                respDesc = "serviceCode cannot be empty";
                respDescCn = "serviceCode 不能为空";
                break;
            case 25:
                respCode = "M0025";
                respDesc = "serviceCode Parameter format is incorrect";
                respDescCn = "serviceCode 参数格式不合法";
                break;
            case 26:
                respCode = "M0026";
                respDesc = "firstName cannot be empty";
                respDescCn = "名字不能为空";
                break;
            case 27:
                respCode = "M0027";
                respDesc = "lastName cannot be empty";
                respDescCn = "姓氏不能为空";
                break;
            case 28:
                respCode = "M0028";
                respDesc = "postCode cannot be empty";
                respDescCn = "邮编不能为空";
                break;
            case 29:
                respCode = "M0029";
                respDesc = "Postal code format is illegal";
                respDescCn = "邮编格式不合法";
                break;
            case 30:
                respCode = "M0030";
                respDesc = "email cannot be empty";
                respDescCn = "邮箱不能为空";
                break;
            case 31:
                respCode = "M0031";
                respDesc = "email format is illegal";
                respDescCn = "邮箱格式不合法";
                break;
            case 32:
                respCode = "M0032";
                respDesc = "phone cannot be empty";
                respDescCn = "电话不能为空";
                break;
            case 33:
                respCode = "M0033";
                respDesc = "phone format is illegal";
                respDescCn = "电话格式不合法";
                break;
            case 34:
                respCode = "M0034";
                respDesc = "ip address cannot be empty";
                respDescCn = "ip 地址不能为空";
                break;
            case 35:
                respCode = "M0035";
                respDesc = "ip format is illegal";
                respDescCn = "ip 格式不合法";
                break;
            case 36:
                respCode = "M0036";
                respDesc = "Unsupported IP format(IPV6)";
                respDescCn = "不支持IPV6识别";
                break;
            case 37:
                respCode = "M0037";
                respDesc = "country cannot be empty";
                respDescCn = "国家代码不能为空";
                break;
            case 38:
                respCode = "M0038";
                respDesc = "country is illegal";
                respDescCn = "国家代码格式不合法";
                break;
            case 39:
                respCode = "M0039";
                respDesc = "Unsupported countries or regions";
                respDescCn = "不支持的国家或地区";
                break;
            case 40:
                respCode = "M0040";
                respDesc = "city cannot be empty";
                respDescCn = "城市不能为空";
                break;
            case 41:
                respCode = "M0041";
                respDesc = "Unknown city";
                respDescCn = "未知的城市";
                break;
            case 42:
                respCode = "M0042";
                respDesc = "street cannot be empty";
                respDescCn = "详细地址不能为空";
                break;
            case 43:
                respCode = "M0043";
                respDesc = "sign cannot be empty";
                respDescCn = "签名不能为空";
                break;
            case 44:
                respCode = "M0044";
                respDesc = "Wrong signature";
                respDescCn = "签名错误";
                break;
            case 45:
                respCode = "M0045";
                respDesc = "Merchant account is not activated";
                respDescCn = "商户号未开通";
                break;
            case 46:
                respCode = "M0046";
                respDesc = "Merchant number does not exist";
                respDescCn = "商户号不存在";
                break;
            case 47:
                respCode = "M0047";
                respDesc = "returnUrl cannot be empty";
                respDescCn = "returnUrl不能为空";
                break;
            case 48:
                respCode = "M0048";
                respDesc = "returnUrl format is incorrect";
                respDescCn = "returnUrl格式不正确";
                break;
            case 49:
                respCode = "M0049";
                respDesc = "returnUrl is too long";
                respDescCn = "returnUrl长度过长";
                break;
            case 50:
                respCode = "M0050";
                respDesc = "notifyUrl cannot be empty";
                respDescCn = "notifyUrl不能为空";
                break;
            case 51:
                respCode = "M0051";
                respDesc = "notifyUrlis too long";
                respDescCn = "notifyUrl长度过长";
                break;
            case 52:
                respCode = "M0052";
                respDesc = "Request parameter cannot be empty";
                respDescCn = "请求参数不能为空";
                break;
            case 53:
                respCode = "M0053";
                respDesc = "Merchants have not opened a direct channel between the two parties";
                respDescCn = "商户未开通两方直连通道";
                break;
            case 54:
                respCode = "M0054";
                respDesc = "Merchant IP limit";
                respDescCn = "商户IP限定";
                break;
            case 55:
                respCode = "M0055";
                respDesc = "Test merchant account amount cannot be greater than 1 (all currencies)";
                respDescCn = "测试商户号金额不能大于1(所有币种)";
                break;
            case 56:
                respCode = "M0056";
                respDesc = "Minimum payment amount: 1USD";
                respDescCn = "最小支付金额：1USD";
                break;
            case 57:
                respCode = "M0057";
                respDesc = "Merchant source URL limit";
                respDescCn = "商户来源网址限定";
                break;
            case 58:
                respCode = "M0058";
                respDesc = "Card Bin Blacklist";
                respDescCn = "卡Bin黑名单";
                break;
            case 59:
                respCode = "M0059";
                respDesc = "Merchant card type is not activated";
                respDescCn = "商户卡种未开通";
                break;
            case 60:
                respCode = "M0060";
                respDesc = "Issuer country limit";
                respDescCn = "发卡行国家限定";
                break;
            case 61:
                respCode = "M0061";
                respDesc = "Blacklist restriction";
                respDescCn = "黑名单限定";
                break;
            case 62:
                respCode = "M0062";
                respDesc = "National blacklist limit";
                respDescCn = "国家黑名单限定";
                break;
            case 63:
                respCode = "M0063";
                respDesc = "National whitelist limit";
                respDescCn = "国家白名单限定";
                break;
            case 64:
                respCode = "M0064";
                respDesc = "National blacklist limit";
                respDescCn = "指定国家地区黑名单数据限定";
                break;
            case 65:
                respCode = "M0065";
                respDesc = "Blocking rules";
                respDescCn = "阻止规则限定";
                break;
            case 66:
                respCode = "M0066";
                respDesc = "Whitelist restriction";
                respDescCn = "白名单限定";
                break;
            case 67:
                respCode = "M0067";
                respDesc = "Single limit exceeded";
                respDescCn = "本次交易的金额超出每笔交易金额限定";
                break;
            case 68:
                respCode = "M0068";
                respDesc = "Daily amount limit exceeded";
                respDescCn = "本次交易的金额超出每日交易金额限定";
                break;
            case 69:
                respCode = "M0069";
                respDesc = "Weekly amount limit exceeded";
                respDescCn = "本次交易的金额超出每月交易金额限定";
                break;
            case 70:
                respCode = "M0070";
                respDesc = "Monthly amount limit exceeded";
                respDescCn = "本次交易的金额超出周交易金额限定";
                break;
            case 71:
                respCode = "M0071";
                respDesc = "Number of routes limited";
                respDescCn = "笔数路由已满";
                break;
            case 72:
                respCode = "M0072";
                respDesc = "Amount of routes limited";
                respDescCn = "金额路由已满";
                break;
            case 73:
                respCode = "M0073";
                respDesc = "High Risk";
                respDescCn = "高风险卡";
                break;
            case 74:
                respCode = "M0074";
                respDesc = "No payment channel available";
                respDescCn = "暂无可用支付通道";
                break;
            case 75:
                respCode = "M0075";
                respDesc = "Single limit for payment channels";
                respDescCn = "支付通道单笔限额";
                break;
            case 76:
                respCode = "M0076";
                respDesc = "returnUrl cannot be empty";
                respDescCn = "returnUrl不能为空";
                break;
            case 77:
                respCode = "M0077";
                respDesc = "The external card channel is not open";
                respDescCn = "外卡通道未开启";
                break;
            case 78:
                respCode = "M0078";
                respDesc = "Merchant card type is not activated";
                respDescCn = "商户卡种未开通";
                break;
            case 79:
                respCode = "M0079";
                respDesc = "Business information does not exist";
                respDescCn = "商户信息不存在";
                break;
            case 80:
                respCode = "M0080";
                respDesc = "Please contact the acquiring bank";
                respDescCn = "银行处理异常";
                break;
            case 81:
                respCode = "M0081";
                respDesc = "Acquiring bank exception";
                respDescCn = "银行连接失败";
                break;
            case 82:
                respCode = "M0082";
                respDesc = "Channel allocation abnormal";
                respDescCn = "笔数路由已满，且没有通道可以使用";
                break;
            case 83:
                respCode = "M0083";
                respDesc = "Channel allocation abnormal";
                respDescCn = "金额路由已满，且没有通道可以使用";
                break;
            case 84:
                respCode = "M0084";
                respDesc = "Merchant has not opened 2.5 party channel";
                respDescCn = "商户未开启2.5方通道";
                break;
            case 85:
                respCode = "M0085";
                respDesc = "This channel does not currently support 3D transactions";
                respDescCn = "此通道暂不支持3D交易";
                break;
            case 86:
                respCode = "M0086";
                respDesc = "This card does not support 3D transactions, please contact the issuing bank";
                respDescCn = "此卡不支持3D交易，请联系发卡行";
                break;
            case 87:
                respCode = "M0087";
                respDesc = "The cardholder information verification failed, please contact the issuing bank";
                respDescCn = "持卡人信息校验失败，请联系发卡行";
                break;




            default:
                respCode = "M9999";
                respDesc = "Unkonwn Error";
                respDescCn = "未知异常";
                break;
        }
        info.setIdentify(num);
        info.setRespCode(respCode);
        info.setRespDesc(respDesc);
        info.setRespDescCn(respDescCn);
        return info;
    }


}
