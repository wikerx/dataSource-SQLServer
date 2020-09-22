package com.scott.ds.common.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * 作者: Mr.薛
 * 时间: 2018-8-21下午12:43:05
 * 内容: java获取本机IP 适配Linux
 * 状态: 编写
 */
public class GetLocalIP {
	public static boolean isWindowOS() {
        boolean isWindowOS = false;
        String osName = System.getProperty("os.name");
        if(osName.toLowerCase().contains("windows")) {
            isWindowOS = true;
        }
        return isWindowOS;
    }
    
    public static InetAddress getInetAddress() {
        InetAddress inetAddress = null;
        try {
            //如果是windows操作系统
            if (isWindowOS()) {
                inetAddress = InetAddress.getLocalHost();
            } else {
                boolean bFindIP = false;
                //定义一个内容都是NetworkInterface的枚举对象
                Enumeration<NetworkInterface> netInterfaces = (Enumeration<NetworkInterface>) 
                        NetworkInterface.getNetworkInterfaces();
                //如果枚举对象里面还有内容(NetworkInterface)
                while (netInterfaces.hasMoreElements()) {
                    if (bFindIP) {
                        break;
                    }
                    //获取下一个内容(NetworkInterface)
                    NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
                    //----------特定情况，可以考虑用ni.getName判断
                    //遍历所有IP
                    Enumeration<InetAddress> ips = ni.getInetAddresses();
                    while (ips.hasMoreElements()) {
                        inetAddress = (InetAddress) ips.nextElement();
//                        属于本地地址
                        if (inetAddress.isSiteLocalAddress()
//                        不是回环地址
                                && !inetAddress.isLoopbackAddress()
//                        地址里面没有:号
                                && !inetAddress.getHostAddress().contains(":")) {
//                            找到了地址
                            bFindIP = true;
//                            退出循环
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inetAddress;
    }
    
    public static String getLocalIP() {
	    String localIp = getLocalIPNew().trim();
	    if(Ognl.isEmpty(localIp) || localIp.equals("127.0.0.1")){
	        localIp = getInetAddress().getHostAddress();
        }
        return localIp;
    }

    
    
    
    /**
     * 获取本地IP地址
     *
     * @throws SocketException
     */
    public static String getLocalIPNew(){
    	try{
	        if (isWindowsOS()) {
	            return InetAddress.getLocalHost().getHostAddress();
	        } else {
	            return getLinuxLocalIp();
	        }
    	}catch (Exception e) {
			// TODO: handle exception
    		return null;
		}
    }
    
    
    /**
     * 判断操作系统是否是Windows
     *
     * @return
     */
    public static boolean isWindowsOS() {
        boolean isWindowsOS = false;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().indexOf("windows") > -1) {
            isWindowsOS = true;
        }
        return isWindowsOS;
    }
 
    /**
     * 获取本地Host名称
     */
    public static String getLocalHostName() throws UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }
 
    /**
     * 获取Linux下的IP地址
     *
     * @return IP地址
     * @throws SocketException
     */
    private static String getLinuxLocalIp() throws SocketException {
        String ip = "";
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                String name = intf.getName();
                if (!name.contains("docker") && !name.contains("lo")) {
                    for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
                        InetAddress inetAddress = enumIpAddr.nextElement();
                        if (!inetAddress.isLoopbackAddress()) {
                            String ipaddress = inetAddress.getHostAddress().toString();
                            if (!ipaddress.contains("::") && !ipaddress.contains("0:0:") && !ipaddress.contains("fe80")) {
                                ip = ipaddress;
                            }
                        }
                    }
                }
            }
        } catch (SocketException ex) {
            ip = "127.0.0.1";
            ex.printStackTrace();
        }
        return ip;
    }
    
    
    
    
    
    
    
    
    
    
    
    public static void main(String[] args) {
        System.out.println("当前服务器IP：" + getLocalIP());
        System.out.println("当前服务器IP：" + getLocalIPNew());
    }
    
}
