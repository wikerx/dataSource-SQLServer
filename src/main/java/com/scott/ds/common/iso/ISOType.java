package com.scott.ds.common.iso;

import com.scott.ds.common.utils.FormateUtil;
import com.scott.ds.common.utils.Ognl;

import java.util.HashMap;
import java.util.Map;

/**   
 * @ClassName:  CountryType   
 * @Description:TODO   
 * @author: Mr.薛 
 * @date:   2019年5月16日 下午4:32:56     
 * @Copyright: 2019 
 * @Company: 自贸通
 */
public class ISOType {

	/**
	 * 功能:货币代码大全
	 * */
	public static Map<String,String> getCurrencyMap(){
		Map<String,String> map = new HashMap<String, String>();
		map.put("AFA","004");
		map.put("ADP","020");
		map.put("AFN","971");
		map.put("EUR","978");
		map.put("ALL","008");
		map.put("DZD","012");
		map.put("USD","840");
		map.put("EUR","978");
		map.put("AOA","973");
		map.put("XCD","951");
		map.put("ARS","032");
		map.put("AMD","051");
		map.put("AWG","533");
		map.put("AUD","036");
		map.put("EUR","978");
		map.put("AZN","944");
		map.put("BSD","044");
		map.put("BHD","048");
		map.put("BDT","050");
		map.put("BBD","052");
		map.put("BYN","933");
		map.put("EUR","978");
		map.put("BZD","084");
		map.put("XOF","952");
		map.put("BMD","060");
		map.put("INR","356");
		map.put("BTN","064");
		map.put("BOB","068");
		map.put("BOV","984");
		map.put("USD","840");
		map.put("BAM","977");
		map.put("BWP","072");
		map.put("NOK","578");
		map.put("BRL","986");
		map.put("USD","840");
		map.put("BND","096");
		map.put("BGN","975");
		map.put("XOF","952");
		map.put("BIF","108");
		map.put("CVE","132");
		map.put("KHR","116");
		map.put("XAF","950");
		map.put("CAD","124");
		map.put("KYD","136");
		map.put("XAF","950");
		map.put("XAF","950");
		map.put("CLP","152");
		map.put("CLF","990");
		map.put("CNY","156");
		map.put("AUD","036");
		map.put("COP","170");
		map.put("COU","970");
		map.put("KMF","174");
		map.put("CDF","976");
		map.put("XAF","950");
		map.put("NZD","554");
		map.put("CRC","188");
		map.put("XOF","952");
		map.put("HRK","191");
		map.put("CUP","192");
		map.put("CUC","931");
		map.put("ANG","532");
		map.put("EUR","978");
		map.put("CZK","203");
		map.put("DKK","208");
		map.put("DJF","262");
		map.put("XCD","951");
		map.put("DOP","214");
		map.put("USD","840");
		map.put("EGP","818");
		map.put("SVC","222");
		map.put("USD","840");
		map.put("XAF","950");
		map.put("ERN","232");
		map.put("EUR","978");
		map.put("ETB","230");
		map.put("EUR","978");
		map.put("FKP","238");
		map.put("DKK","208");
		map.put("FJD","242");
		map.put("EUR","978");
		map.put("EUR","978");
		map.put("EUR","978");
		map.put("XPF","953");
		map.put("EUR","978");
		map.put("XAF","950");
		map.put("GMD","270");
		map.put("GEL","981");
		map.put("EUR","978");
		map.put("GHS","936");
		map.put("GIP","292");
		map.put("EUR","978");
		map.put("DKK","208");
		map.put("XCD","951");
		map.put("EUR","978");
		map.put("USD","840");
		map.put("GTQ","320");
		map.put("GBP","826");
		map.put("GNF","324");
		map.put("XOF","952");
		map.put("GYD","328");
		map.put("HTG","332");
		map.put("USD","840");
		map.put("EUR","978");
		map.put("HNL","340");
		map.put("HKD","344");
		map.put("HUF","348");
		map.put("ISK","352");
		map.put("INR","356");
		map.put("IDR","360");
		map.put("XDR","960");
		map.put("IRR","364");
		map.put("IQD","368");
		map.put("EUR","978");
		map.put("GBP","826");
		map.put("ILS","376");
		map.put("EUR","978");
		map.put("JMD","388");
		map.put("JPY","392");
		map.put("GBP","826");
		map.put("JOD","400");
		map.put("KZT","398");
		map.put("KES","404");
		map.put("KPW","408");
		map.put("KRW","410");
		map.put("KWD","414");
		map.put("KGS","417");
		map.put("LAK","418");
		map.put("EUR","978");
		map.put("LBP","422");
		map.put("LSL","426");
		map.put("ZAR","710");
		map.put("LRD","430");
		map.put("LYD","434");
		map.put("CHF","756");
		map.put("EUR","978");
		map.put("EUR","978");
		map.put("MOP","446");
		map.put("MKD","807");
		map.put("MGA","969");
		map.put("MWK","454");
		map.put("MYR","458");
		map.put("MVR","462");
		map.put("XOF","952");
		map.put("EUR","978");
		map.put("USD","840");
		map.put("EUR","978");
		map.put("MRU","929");
		map.put("MUR","480");
		map.put("EUR","978");
		map.put("XUA","965");
		map.put("MXN","484");
		map.put("MXV","979");
		map.put("USD","840");
		map.put("MDL","498");
		map.put("EUR","978");
		map.put("MNT","496");
		map.put("EUR","978");
		map.put("XCD","951");
		map.put("MAD","504");
		map.put("MZN","943");
		map.put("MMK","104");
		map.put("NAD","516");
		map.put("ZAR","710");
		map.put("NPR","524");
		map.put("EUR","978");
		map.put("XPF","953");
		map.put("NZD","554");
		map.put("NIO","558");
		map.put("XOF","952");
		map.put("NGN","566");
		map.put("NZD","554");
		map.put("USD","840");
		map.put("NOK","578");
		map.put("OMR","512");
		map.put("PKR","586");
		map.put("USD","840");
		map.put("PAB","590");
		map.put("USD","840");
		map.put("PGK","598");
		map.put("PYG","600");
		map.put("PEN","604");
		map.put("PHP","608");
		map.put("NZD","554");
		map.put("PLN","985");
		map.put("EUR","978");
		map.put("USD","840");
		map.put("QAR","634");
		map.put("EUR","978");
		map.put("RON","946");
		map.put("RUB","643");
		map.put("RWF","646");
		map.put("EUR","978");
		map.put("SHP","654");
		map.put("XCD","951");
		map.put("XCD","951");
		map.put("EUR","978");
		map.put("EUR","978");
		map.put("XCD","951");
		map.put("WST","882");
		map.put("EUR","978");
		map.put("STN","930");
		map.put("SAR","682");
		map.put("XOF","952");
		map.put("RSD","941");
		map.put("SCR","690");
		map.put("SLL","694");
		map.put("SGD","702");
		map.put("ANG","532");
		map.put("XSU","994");
		map.put("EUR","978");
		map.put("EUR","978");
		map.put("SBD","090");
		map.put("SOS","706");
		map.put("ZAR","710");
		map.put("SSP","728");
		map.put("EUR","978");
		map.put("LKR","144");
		map.put("SDG","938");
		map.put("SRD","968");
		map.put("NOK","578");
		map.put("SZL","748");
		map.put("SEK","752");
		map.put("CHF","756");
		map.put("CHE","947");
		map.put("CHW","948");
		map.put("SYP","760");
		map.put("TWD","901");
		map.put("TJS","972");
		map.put("TZS","834");
		map.put("THB","764");
		map.put("USD","840");
		map.put("XOF","952");
		map.put("NZD","554");
		map.put("TOP","776");
		map.put("TTD","780");
		map.put("TND","788");
		map.put("TRY","949");
		map.put("TMT","934");
		map.put("USD","840");
		map.put("UGX","800");
		map.put("UAH","980");
		map.put("AED","784");
		map.put("GBP","826");
		map.put("USD","840");
		map.put("USN","997");
		map.put("UYU","858");
		map.put("UYI","940");
		map.put("UZS","860");
		map.put("VUV","548");
		map.put("VEF","937");
		map.put("VND","704");
		map.put("USD","840");
		map.put("USD","840");
		map.put("XPF","953");
		map.put("MAD","504");
		map.put("YER","886");
		map.put("ZMW","967");
		map.put("ZWL","932");
		map.put("XBA","955");
		map.put("XBB","956");
		map.put("XBC","957");
		map.put("XBD","958");
		map.put("XTS","963");
		map.put("XXX","999");
		map.put("XAU","959");
		map.put("XPD","964");
		map.put("XPT","962");
		map.put("XAG","961");
		map.put("AZM","031");
		map.put("BYR","974");
		map.put("LVL","428");
		map.put("LTL","440");
		map.put("MRO","478");
		map.put("STD","678");
		return map;
	}

	/**
	 * 功能:国家代码大全
	 * 三位国家简写，3位国家代码
	 * */
	public static Map<String ,String> getCountryCodeMap(){
		Map<String ,String> map = new HashMap<String, String>();
		map.put("AND","020");
		map.put("ARE","784");
		map.put("AFG","004");
		map.put("ATG","028");
		map.put("AIA","660");
		map.put("ALB","008");
		map.put("ARM","051");
		map.put("AGO","024");
		map.put("ATA","010");
		map.put("ARG","032");
		map.put("ASM","016");
		map.put("AUT","040");
		map.put("AUS","036");
		map.put("ABW","533");
		map.put("ALA","248");
		map.put("AZE","031");
		map.put("BIH","070");
		map.put("BRB","052");
		map.put("BGD","050");
		map.put("BEL","056");
		map.put("BFA","854");
		map.put("BGR","100");
		map.put("BHR","048");
		map.put("BDI","108");
		map.put("BEN","204");
		map.put("BLM","652");
		map.put("BMU","060");
		map.put("BRN","096");
		map.put("BOL","068");
		map.put("BES","535");
		map.put("BRA","076");
		map.put("BHS","044");
		map.put("BTN","064");
		map.put("BVT","074");
		map.put("BWA","072");
		map.put("BLR","112");
		map.put("BLZ","084");
		map.put("CAN","124");
		map.put("CCK","166");
		map.put("CAF","140");
		map.put("CHE","756");
		map.put("CHL","152");
		map.put("CMR","120");
		map.put("COL","170");
		map.put("CRI","188");
		map.put("CUB","192");
		map.put("CPV","132");
		map.put("CXR","162");
		map.put("CYP","196");
		map.put("CZE","203");
		map.put("DEU","276");
		map.put("DJI","262");
		map.put("DNK","208");
		map.put("DMA","212");
		map.put("DOM","214");
		map.put("DZA","012");
		map.put("ECU","218");
		map.put("EST","233");
		map.put("EGY","818");
		map.put("ESH","732");
		map.put("ERI","232");
		map.put("ESP","724");
		map.put("FIN","246");
		map.put("FJI","242");
		map.put("FLK","238");
		map.put("FSM","583");
		map.put("FRO","234");
		map.put("FRA","250");
		map.put("GAB","266");
		map.put("GRD","308");
		map.put("GEO","268");
		map.put("GUF","254");
		map.put("GHA","288");
		map.put("GIB","292");
		map.put("GRL","304");
		map.put("GIN","324");
		map.put("GLP","312");
		map.put("GNQ","226");
		map.put("GRC","300");
		map.put("SGS","239");
		map.put("GTM","320");
		map.put("GUM","316");
		map.put("GNB","624");
		map.put("GUY","328");
		map.put("HKG","344");
		map.put("HMD","334");
		map.put("HND","340");
		map.put("HRV","191");
		map.put("HTI","332");
		map.put("HUN","348");
		map.put("IDN","360");
		map.put("IRL","372");
		map.put("ISR","376");
		map.put("IMN","833");
		map.put("IND","356");
		map.put("IOT","086");
		map.put("IRQ","368");
		map.put("IRN","364");
		map.put("ISL","352");
		map.put("ITA","380");
		map.put("JEY","832");
		map.put("JAM","388");
		map.put("JOR","400");
		map.put("JPN","392");
		map.put("KHM","116");
		map.put("KIR","296");
		map.put("COM","174");
		map.put("KWT","414");
		map.put("CYM","136");
		map.put("LBN","422");
		map.put("LIE","438");
		map.put("LKA","144");
		map.put("LBR","430");
		map.put("LSO","426");
		map.put("LTU","440");
		map.put("LUX","442");
		map.put("LVA","428");
		map.put("LBY","434");
		map.put("MAR","504");
		map.put("MCO","492");
		map.put("MDA","498");
		map.put("MNE","499");
		map.put("MAF","663");
		map.put("MDG","450");
		map.put("MHL","584");
		map.put("MKD","807");
		map.put("MLI","466");
		map.put("MMR","104");
		map.put("MAC","446");
		map.put("MTQ","474");
		map.put("MRT","478");
		map.put("MSR","500");
		map.put("MLT","470");
		map.put("MDV","462");
		map.put("MWI","454");
		map.put("MEX","484");
		map.put("MYS","458");
		map.put("NAM","516");
		map.put("NER","562");
		map.put("NFK","574");
		map.put("NGA","566");
		map.put("NIC","558");
		map.put("NLD","528");
		map.put("NOR","578");
		map.put("NPL","524");
		map.put("NRU","520");
		map.put("OMN","512");
		map.put("PAN","591");
		map.put("PER","604");
		map.put("PYF","258");
		map.put("PNG","598");
		map.put("PHL","608");
		map.put("PAK","586");
		map.put("POL","616");
		map.put("PCN","612");
		map.put("PRI","630");
		map.put("PSE","275");
		map.put("PLW","585");
		map.put("PRY","600");
		map.put("QAT","634");
		map.put("REU","638");
		map.put("ROU","642");
		map.put("SRB","688");
		map.put("RUS","643");
		map.put("RWA","646");
		map.put("SLB","090");
		map.put("SYC","690");
		map.put("SDN","729");
		map.put("SWE","752");
		map.put("SGP","702");
		map.put("SVN","705");
		map.put("SJM","744");
		map.put("SVK","703");
		map.put("SLE","694");
		map.put("SMR","674");
		map.put("SEN","686");
		map.put("SOM","706");
		map.put("SUR","740");
		map.put("SSD","728");
		map.put("STP","678");
		map.put("SLV","222");
		map.put("SYR","760");
		map.put("SWZ","748");
		map.put("TCA","796");
		map.put("TCD","148");
		map.put("TGO","768");
		map.put("THA","764");
		map.put("TKL","772");
		map.put("TLS","626");
		map.put("TUN","788");
		map.put("TON","776");
		map.put("TUR","792");
		map.put("TUV","798");
		map.put("TZA","834");
		map.put("UKR","804");
		map.put("UGA","800");
		map.put("USA","840");
		map.put("URY","858");
		map.put("VAT","336");
		map.put("VEN","862");
		map.put("VGB","092");
		map.put("VIR","850");
		map.put("VNM","704");
		map.put("WLF","876");
		map.put("WSM","882");
		map.put("YEM","887");
		map.put("MYT","175");
		map.put("ZAF","710");
		map.put("ZMB","894");
		map.put("ZWE","716");
		map.put("CHN","156");
		map.put("COG","178");
		map.put("COD","180");
		map.put("MOZ","508");
		map.put("GGY","831");
		map.put("GMB","270");
		map.put("MNP","580");
		map.put("ETH","231");
		map.put("NCL","540");
		map.put("VUT","548");
		map.put("ATF","260");
		map.put("NIU","570");
		map.put("UMI","581");
		map.put("COK","184");
		map.put("GBR","826");
		map.put("TTO","780");
		map.put("VCT","670");
		map.put("TWN","158");
		map.put("NZL","554");
		map.put("SAU","682");
		map.put("LAO","418");
		map.put("PRK","408");
		map.put("KOR","410");
		map.put("PRT","620");
		map.put("KGZ","417");
		map.put("KAZ","398");
		map.put("TJK","762");
		map.put("TKM","795");
		map.put("UZB","860");
		map.put("KNA","659");
		map.put("SPM","666");
		map.put("SHN","654");
		map.put("LCA","662");
		map.put("MUS","480");
		map.put("CIV","384");
		map.put("KEN","404");
		map.put("MNG","496");
		return map;
	}

	public static void main(String[] args) {
//		System.out.println(getNumberByCurrency("EUR"));
//		System.out.println(getCurrencyByNumber("554"));
//		System.out.println(getCountryByCy("EU"));
//		System.out.println(getCountryByNumber("978"));
		String currecys = "TND,VUV,SGD,IRR,JOD,CNY,TWD,HKD,EUR,USD,GBP,KRW,JPY,ALL,DZD,ARS,AWG,AUD,EGP,ETB,MOP,OMR,AED,BSD,BHD,BBD,BYR,BZD,"
				+"BMD,BTN,BOB,BWP,BRL,BGN,BIF,ISK,PKR,PAB,PGK,PYG,PLN,KPW,XOF,DKK,DOP,RUB,CVE,FKP,FJD,PHP,HKD,XAF,COP,CRC,CUP,XCD,GMD,GYD,KRW,"
				+"HTG,HNL,KZT,KHR,CAD,CZK,DJF,GNF,KMF,HRK,KES,KWD,QAR,LAK,LVL,LBP,LSL,LRD,LYD,LTL,ANG,RON,RWF,USD,BDT,MKD,MWK,MYR,MVR,MRO,"
				+"MUR,MXN,MDL,MNT,MAD,MMK,PEN,NAD,NPR,NIO,NGN,NOK,ZAR,EUR,JPY,SEK,CHF,SVC,WST,STD,SAR,SCR,SLL,SBD,SOS,LKR,SHP,SZL,TWD,TRY,XPF,"
				+"TZS,THB,TOP,TTD,BND,GTQ,UAH,UYU,VND,HUF,SYP,GBP,INR,IDR,IQD,ILS,JMD,YER,CLP,GIP";
		String[] curr = currecys.split(",");
		StringBuffer result = new StringBuffer();
		for (String currency:curr) {
			if(Ognl.isEmpty(getNumberByCurrency(currency))){
				result.append(currency).append(",");
			}
		}
		System.out.println("不存在的币种：" + result.toString());

		String countriesCode = "474,478,500,470,462,454,484,458,516,562,574,566,558,528,578,524,520,512,591,604,258,598,608,586,616,612,630,275,585,600,634,638,642,688,643,646,090,690,729,752,702,705,744,703,694,674,686,706,740,728,678,222,760,748,796,148,768,764,772,626,788,776,792,798,834,804,800,840,858,336,862,092,850,704,876,882,887,175,710,894,716,156,662,178,180,508,831,270,580,231,540,548,260,570,581,184,826,780,670,158,554,682,418,408,410,620,417,398,762,795,860,659,666,654,480,384,404,496,020,784,004,028,660,008,024,010,032,016,040,036,533,248,031,070,052,050,056,854,100,048,108,204,652,060,096,068,535,076,044,064,074,072,112,084,124,166,140,756,152,120,170,188,192,132,162,196,203,276,262,208,212,214,012,218,233,818,732,232,724,246,242,238,583,234,250,266,308,268,254,288,292,304,324,312,226,300,239,320,316,624,328,344,334,340,191,332,348,360,372,376,833,356,086,368,364,352,380,832,388,400,392,116,296,174,414,136,422,438,144,430,426,440,442,428,434,504,492,498,499,663,450,584,807,466,104,446";
		String countries = "MTQ,MRT,MSR,MLT,MDV,MWI,MEX,MYS,NAM,NER,NFK,NGA,NIC,NLD,NOR,NPL,NRU,OMN,PAN,PER,PYF,PNG,PHL,PAK,POL,PCN,PRI,PSE,PLW,PRY,QAT,REU,ROU,SRB,RUS,RWA,SLB,SYC,SDN,SWE,SGP,SVN,SJM,SVK,SLE,SMR,SEN,SOM,SUR,SSD,STP,SLV,SYR,SWZ,TCA,TCD,TGO,THA,TKL,TLS,TUN,TON,TUR,TUV,TZA,UKR,UGA,USA,URY,VAT,VEN,VGB,VIR,VNM,WLF,WSM,YEM,MYT,ZAF,ZMB,ZWE,CHN,LCA,COG,COD,MOZ,GGY,GMB,MNP,ETH,NCL,VUT,ATF,NIU,UMI,COK,GBR,TTO,VCT,TWN,NZL,SAU,LAO,PRK,KOR,PRT,KGZ,KAZ,TJK,TKM,UZB,KNA,SPM,SHN,MUS,CIV,KEN,MNG,AND,ARE,AFG,ATG,AIA,ALB,AGO,ATA,ARG,ASM,AUT,AUS,ABW,ALA,AZE,BIH,BRB,BGD,BEL,BFA,BGR,BHR,BDI,BEN,BLM,BMU,BRN,BOL,BES,BRA,BHS,BTN,BVT,BWA,BLR,BLZ,CAN,CCK,CAF,CHE,CHL,CMR,COL,CRI,CUB,CPV,CXR,CYP,CZE,DEU,DJI,DNK,DMA,DOM,DZA,ECU,EST,EGY,ESH,ERI,ESP,FIN,FJI,FLK,FSM,FRO,FRA,GAB,GRD,GEO,GUF,GHA,GIB,GRL,GIN,GLP,GNQ,GRC,SGS,GTM,GUM,GNB,GUY,HKG,HMD,HND,HRV,HTI,HUN,IDN,IRL,ISR,IMN,IND,IOT,IRQ,IRN,ISL,ITA,JEY,JAM,JOR,JPN,KHM,KIR,COM,KWT,CYM,LBN,LIE,LKA,LBR,LSO,LTU,LUX,LVA,LBY,MAR,MCO,MDA,MNE,MAF,MDG,MHL,MKD,MLI,MMR,MAC";
		String arrCode[] = countriesCode.split(",");
		String arrCountry[] = countries.split(",");
		result.setLength(0);
		for (String code:arrCode) {
			if(Ognl.isEmpty(getCountryByNumber(code))){
				result.append(code).append(",");
			}
		}
		System.out.println("不存在的国家代码：" + result.toString());
		result.setLength(0);
		for (String country:arrCountry) {
			if(Ognl.isEmpty(getCountryByCy(country))){
				result.append(country).append(",");
			}
		}
		System.out.println("不存在的国家字母：" + result.toString());

		result.setLength(0);
		for (int i = 0 ; i< arrCode.length ; i++ ) {
			if(!getCountryByNumber(arrCode[i]).equals(arrCountry[i])){
				result.append(arrCode[i]).append(":").append(arrCountry[i]).append(" ,");
				System.out.println("code：" + arrCode[i] + " 国家：" + arrCountry[i] + "  ，查询得到的数据：" + getCountryByNumber(arrCode[i]));
			}
		}
		System.out.println("字母国家对应失败：" + result.toString());

	}


	/**
	 * 功能:根据币种取数字标识码
	 * @param currency
	 * */
	public static String getNumberByCurrency(String currency){
		currency = currency.toUpperCase();
		Map<String, String> map = getCurrencyMap();
		return map.get(currency);
	}

	/**
	 * 功能:根据数字标识取币种代码 左边无0
	 * @param number
	 * */
	public static String getCurrencyByNumber(String number){
		Map<String, String> map = getCurrencyMap();
		String currency = null;
		for(Map.Entry<String,String> str : map.entrySet())
		{
		    if(number.equals(str.getValue())){
		    currency = str.getKey();
		            break;
		   }
		}
		return currency;
	}
	
	/**
	 * 功能:根据三位国家代码识别3位数字代码
	 * @param country
	 * */
	public static String getCountryByCy(String country){
		country = country.toUpperCase();
		Map<String, String> map = getCountryCodeMap();
		return map.get(country);
	}

	/**
	 * 功能:根据3位数字标识取三位国家种代码 不足3位左补0
	 * @param number
	 * */
	public static String getCountryByNumber(String number){
		number = FormateUtil.leftFillZero(3, number);
		Map<String, String> map = getCountryCodeMap();
		String country = null;
		for(Map.Entry<String,String> str : map.entrySet())
		{
		    if(number.equals(str.getValue())){
		    	country = str.getKey();
		            break;
		   }
		}
		return country;
	}




}
