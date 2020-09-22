// 生成订单号
function getOrderNo(){
	var merOrderNo = "";
	merOrderNo = getDateNow() +  randomNum(100,999);
	$("#merOrderNo").val(merOrderNo);
}
// 初始化年份
function getYear() {
	var now = new Date();
	var year = now.getFullYear();
	var obj = document.getElementById("cardExpirationYear");
	for(var a = 1;a <= 20; a++){
		obj.add(new Option(year,year));
		++year;
	}
}

// 初始化国家
function getCountry() {
	var country = ["AND","ARE","AFG","ATG","AIA","ALB","ARM","AGO","ATA","ARG","ASM","AUT","AUS","ABW","ALA","AZE","BIH","BRB","BGD","BEL","BFA","BGR","BHR","BDI","BEN","BLM","BMU","BRN","BOL","BES","BRA","BHS","BTN","BVT","BWA","BLR","BLZ","CAN","CCK","CAF","CHE","CHL","CMR","COL","CRI","CUB","CPV","CXR","CYP","CZE","DEU","DJI","DNK","DMA","DOM","DZA","ECU","EST","EGY","ESH","ERI","ESP","FIN","FJI","FLK","FSM","FRO","FRA","GAB","GRD","GEO","GUF","GHA","GIB","GRL","GIN","GLP","GNQ","GRC","SGS","GTM","GUM","GNB","GUY","HKG","HMD","HND","HRV","HTI","HUN","IDN","IRL","ISR","IMN","IND","IOT","IRQ","IRN","ISL","ITA","JEY","JAM","JOR","JPN","KHM","KIR","COM","KWT","CYM","LBN","LIE","LKA","LBR","LSO","LTU","LUX","LVA","LBY","MAR","MCO","MDA","MNE","MAF","MDG","MHL","MKD","MLI","MMR","MAC","MTQ","MRT","MSR","MLT","MDV","MWI","MEX","MYS","NAM","NER","NFK","NGA","NIC","NLD","NOR","NPL","NRU","OMN","PAN","PER","PYF","PNG","PHL","PAK","POL","PCN","PRI","PSE","PLW","PRY","QAT","REU","ROU","SRB","RUS","RWA","SLB","SYC","SDN","SWE","SGP","SVN","SJM","SVK","SLE","SMR","SEN","SOM","SUR","SSD","STP","SLV","SYR","SWZ","TCA","TCD","TGO","THA","TKL","TLS","TUN","TON","TUR","TUV","TZA","UKR","UGA","USA","URY","VAT","VEN","VGB","VIR","VNM","WLF","WSM","YEM","MYT","ZAF","ZMB","ZWE","CHN","COG","COD","MOZ","GGY","GMB","MNP","ETH","NCL","VUT","ATF","NIU","UMI","COK","GBR","TTO","VCT","TWN","NZL","SAU","LAO","PRK","KOR","PRT","KGZ","KAZ","TJK","TKM","UZB","KNA","SPM","SHN","LCA","MUS","CIV","KEN","MNG"];
	var nameCn = ["安道尔","阿联酋","阿富汗","安提瓜和巴布达","安圭拉","阿尔巴尼亚","亚美尼亚","安哥拉","南极洲","阿根廷","美属萨摩亚","奥地利","澳大利亚","阿鲁巴","奥兰群岛","阿塞拜疆","波黑","巴巴多斯","孟加拉","比利时","布基纳法索","保加利亚","巴林","布隆迪","贝宁","圣巴泰勒米岛","百慕大","文莱","玻利维亚","荷兰加勒比区","巴西","巴哈马","不丹","布韦岛","博茨瓦纳","白俄罗斯","伯利兹","加拿大","科科斯群岛","中非","瑞士","智利","喀麦隆","哥伦比亚","哥斯达黎加","古巴","佛得角","圣诞岛","塞浦路斯","捷克","德国","吉布提","丹麦","多米尼克","多米尼加","阿尔及利亚","厄瓜多尔","爱沙尼亚","埃及","西撒哈拉","厄立特里亚","西班牙","芬兰","斐济群岛","马尔维纳斯群岛（ 福克兰）","密克罗尼西亚联邦","法罗群岛","法国","加蓬","格林纳达","格鲁吉亚","法属圭亚那","加纳","直布罗陀","格陵兰","几内亚","瓜德罗普","赤道几内亚","希腊","南乔治亚岛和南桑威奇群岛","危地马拉","关岛","几内亚比绍","圭亚那","香港","赫德岛和麦克唐纳群岛","洪都拉斯","克罗地亚","海地","匈牙利","印尼","爱尔兰","以色列","马恩岛","印度","英属印度洋领地","伊拉克","伊朗","冰岛","意大利","泽西岛","牙买加","约旦","日本","柬埔寨","基里巴斯","科摩罗","科威特","开曼群岛","黎巴嫩","列支敦士登","斯里兰卡","利比里亚","莱索托","立陶宛","卢森堡","拉脱维亚","利比亚","摩洛哥","摩纳哥","摩尔多瓦","黑山","法属圣马丁","马达加斯加","马绍尔群岛","马其顿","马里","缅甸","澳门","马提尼克","毛里塔尼亚","蒙塞拉特岛","马耳他","马尔代夫","马拉维","墨西哥","马来西亚","纳米比亚","尼日尔","诺福克岛","尼日利亚","尼加拉瓜","荷兰","挪威","尼泊尔","瑙鲁","阿曼","巴拿马","秘鲁","法属波利尼西亚","巴布亚新几内亚","菲律宾","巴基斯坦","波兰","皮特凯恩群岛","波多黎各","巴勒斯坦","帕劳","巴拉圭","卡塔尔","留尼汪","罗马尼亚","塞尔维亚","俄罗斯","卢旺达","所罗门群岛","塞舌尔","苏丹","瑞典","新加坡","斯洛文尼亚","斯瓦尔巴群岛和 扬马延岛","斯洛伐克","塞拉利昂","圣马力诺","塞内加尔","索马里","苏里南","南苏丹","圣多美和普林西比","萨尔瓦多","叙利亚","斯威士兰","特克斯和凯科斯群岛","乍得","多哥","泰国","托克劳","东帝汶","突尼斯","汤加","土耳其","图瓦卢","坦桑尼亚","乌克兰","乌干达","美国","乌拉圭","梵蒂冈","委内瑞拉","英属维尔京群岛","美属维尔京群岛","越南","瓦利斯和富图纳","萨摩亚","也门","马约特","南非","赞比亚","津巴布韦","中国 内地","刚果（布）","刚果（金）","莫桑比克","根西岛","冈比亚","北马里亚纳群岛","埃塞俄比亚","新喀里多尼亚","瓦努阿图","法属南部领地","纽埃","美国本土外小岛屿","库克群岛","英国","特立尼达和多巴哥","圣文森特和格林纳丁斯","中华民国（台湾）","新西兰","沙特阿拉伯","老挝","朝鲜 北朝鲜","韩国 南朝鲜","葡萄牙","吉尔吉斯斯坦","哈萨克斯坦","塔吉克斯坦","土库曼斯坦","乌兹别克斯坦","圣基茨和尼维斯","圣皮埃尔和密克隆","圣赫勒拿","圣卢西亚","毛里求斯","科特迪瓦","肯尼亚","蒙古国 蒙古"];
	var nameUs = ["Andorra","United Arab Emirates","Afghanistan","Antigua & Barbuda","Anguilla","Albania","Armenia","Angola","Antarctica","Argentina","American Samoa","Austria","Australia","Aruba","?aland Island","Azerbaijan","Bosnia & Herzegovina","Barbados","Bangladesh","Belgium","Burkina","Bulgaria","Bahrain","Burundi","Benin","Saint Barthélemy","Bermuda","Brunei","Bolivia","Caribbean Netherlands","Brazil","The Bahamas","Bhutan","Bouvet Island","Botswana","Belarus","Belize","Canada","Cocos (Keeling) Islands","Central African Republic","Switzerland","Chile","Cameroon","Colombia","Costa Rica","Cuba","Cape Verde","Christmas Island","Cyprus","Czech Republic","Germany","Djibouti","Denmark","Dominica","Dominican Republic","Algeria","Ecuador","Estonia","Egypt","Western Sahara","Eritrea","Spain","Finland","Fiji","Falkland Islands","Federated States of Micronesia","Faroe Islands","France","Gabon","Grenada","Georgia","French Guiana","Ghana","Gibraltar","Greenland","Guinea","Guadeloupe","Equatorial Guinea","Greece","South Georgia and the South Sandwich Islands","Guatemala","Guam","Guinea-Bissau","Guyana","Hong Kong","Heard Island and McDonald Islands","Honduras","Croatia","Haiti","Hungary","Indonesia","Ireland","Israel","Isle of Man","India","British Indian Ocean Territory","Iraq","Iran","Iceland","Italy","Jersey","Jamaica","Jordan","Japan","Cambodia","Kiribati","The Comoros","Kuwait","Cayman Islands","Lebanon","Liechtenstein","Sri Lanka","Liberia","Lesotho","Lithuania","Luxembourg","Latvia","Libya","Morocco","Monaco","Moldova","Montenegro","Saint Martin (France)","Madagascar","Marshall islands","Republic of Macedonia (FYROM)","Mali","Myanmar (Burma)","Macao","Martinique","Mauritania","Montserrat","Malta","Maldives","Malawi","Mexico","Malaysia","Namibia","Niger","Norfolk Island","Nigeria","Nicaragua","Netherlands","Norway","Nepal","Nauru","Oman","Panama","Peru","French polynesia","Papua New Guinea","The Philippines","Pakistan","Poland","Pitcairn Islands","Puerto Rico","Palestinian territories","Palau","Paraguay","Qatar","Réunion","Romania","Serbia","Russian Federation","Rwanda","Solomon Islands","Seychelles","Sudan","Sweden","Singapore","Slovenia","Template:Country data SJM Svalbard","Slovakia","Sierra Leone","San Marino","Senegal","Somalia","Suriname","South Sudan","Sao Tome & Principe","El Salvador","Syria","Swaziland","Turks & Caicos Islands","Chad","Togo","Thailand","Tokelau","Timor-Leste (East Timor)","Tunisia","Tonga","Turkey","Tuvalu","Tanzania","Ukraine","Uganda","United States of America (USA)","Uruguay","Vatican City (The Holy See)","Venezuela","British Virgin Islands","United States Virgin Islands","Vietnam","Wallis and Futuna","Samoa","Yemen","Mayotte","South Africa","Zambia","Zimbabwe","China","Republic of the Congo","Democratic Republic of the Congo","Mozambique","Guernsey","Gambia","Northern Mariana Islands","Ethiopia","New Caledonia","Vanuatu","French Southern Territories","Niue","United States Minor Outlying Islands","Cook Islands","Great Britain (United Kingdom; England)","Trinidad & Tobago","St. Vincent & the Grenadines","Taiwan","New Zealand","Saudi Arabia","Laos","North Korea","South Korea","Portugal","Kyrgyzstan","Kazakhstan","Tajikistan","Turkmenistan","Uzbekistan","St. Kitts & Nevis","Saint-Pierre and Miquelon","St. Helena & Dependencies","St. Lucia","Mauritius","C?te d'Ivoire","Kenya","Mongolia"];
	var obj = document.getElementById("country");
	for(var i = 0;i < country.length; i++){
		obj.add(new Option(nameCn[i] + " - " + nameUs[i],country[i]));
	}
}

//生成时间规则
function getDateNow()
    {
        var vNow = new Date();
		var sNow = "";
        sNow += String(vNow.getFullYear());
        sNow += String(vNow.getMonth() + 1);
        sNow += String(vNow.getDate());
        sNow += String(vNow.getHours());
        sNow += String(vNow.getMinutes());
        sNow += String(vNow.getSeconds());
        sNow += String(vNow.getMilliseconds());
		return sNow;
}

//生成从minNum到maxNum的随机数
function randomNum(minNum,maxNum){ 
    switch(arguments.length){ 
        case 1: 
            return parseInt(Math.random()*minNum+1,10); 
        break; 
        case 2: 
            return parseInt(Math.random()*(maxNum-minNum+1)+minNum,10); 
        break; 
            default: 
                return 0; 
            break; 
    } 
} 

// 3方提交订单
function submitForm() {
	var merchantNo = $("#merchantNo").val();
	var key = $("#key").val();
	var merOrderNo = $("#merOrderNo").val();
	var payCurrency = $("#payCurrency").val();
	var payAmount = $("#payAmount").val();
	var returnUrl = $("#returnUrl").val();
	var notifyUrl = $("#notifyUrl").val();
	var goods = $("#goods").val();
	var remark = $("#remark").val();
	var sign = $("#sign").val();
	var good = {
		"name": "product1",
		"price": "10.01",
		"num": 10
	};
	var goods = JSON.stringify(good);
	//console.log("goodsJson:" + goods);
	$("#goods").val(goods);
	var signStr = merchantNo+merOrderNo+payCurrency+returnUrl+key;
	sign = hex_sha512(signStr);
	$("#sign").val(sign);
	if(!merchantNo){
		alert("商户号不能为空");
		$("#merchantNo").focus();
		return false;
	}else if(!key){
		alert("商户安全码不能为空");
		$("#key").focus();
		return false;
	}else if(!merOrderNo){
		alert("商户订单号不能为空");
		$("#merOrderNo").focus();
		return false;
	}else if(!payCurrency){
		alert("支付币种不能为空");
		$("#payCurrency").focus();
		return false;
	}else if(!payAmount){
		alert("支付金额不能为空");
		$("#payAmount").focus();
		return false;
	}else if(!returnUrl){
		alert("returnUrl不能为空");
		$("#returnUrl").focus();
		return false;
	}else if(!sign){
		alert("签名不能为空");
		$("#sign").focus();
		return false;
	}else{
		return true;
	}
}

// 2.5方订单提交
function submitFormOpened() {
	var merchantNo = $("#merchantNo").val();
	var key = $("#key").val();
	var merOrderNo = $("#merOrderNo").val();
	var payCurrency = $("#payCurrency").val();
	var payAmount = $("#payAmount").val();
	var returnUrl = $("#returnUrl").val();
	var goods = $("#goods").val();
	var remark = $("#remark").val();
	var cardNo = $("#cardNo").val();
	var cardExpirationYear = $("#cardExpirationYear").val();
	var cardExpirationMonth = $("#cardExpirationMonth").val();
	var cardExpiration = cardExpirationMonth + cardExpirationYear;
	$("#cardExpireDate").val(cardExpiration);
	var serviceCode = $("#serviceCode").val();
	var firstName = $("#firstName").val();
	var lastName = $("#lastName").val();
	var postCode = $("#postCode").val();
	var email = $("#email").val();
	var phone = $("#phone").val();
	var country = $("#country").val();
	var city = $("#city").val();
	var region = $("#region").val();
	var street = $("#street").val();
	var sign = $("#sign").val();
	var good = {
		"name": "product1",
		"price": "10.01",
		"num": 10
	};
	var goods = JSON.stringify(good);
	//console.log("goodsJson:" + goods);
	$("#goods").val(goods);
	var signStr = merchantNo+merOrderNo+payCurrency+returnUrl+country+city+street+key;
	sign = hex_sha512(signStr);
	$("#sign").val(sign);
	if(!merchantNo){
		alert("商户号不能为空");
		$("#merchantNo").focus();
		return false;
	}else if(!key){
		alert("商户安全码不能为空");
		$("#key").focus();
		return false;
	}else if(!merOrderNo){
		alert("商户订单号不能为空");
		$("#merOrderNo").focus();
		return false;
	}else if(!payCurrency){
		alert("支付币种不能为空");
		$("#payCurrency").focus();
		return false;
	}else if(!payAmount){
		alert("支付金额不能为空");
		$("#payAmount").focus();
		return false;
	}else if(!returnUrl){
		alert("returnUrl不能为空");
		$("#returnUrl").focus();
		return false;
	}else if(!cardNo){
		alert("卡号不能为空");
		$("#cardNo").focus();
		return false;
	}else if(!cardExpirationYear){
		alert("有效年不能为空");
		$("#cardExpirationYear").focus();
		return false;
	}else if(!cardExpirationMonth){
		alert("有效月不能为空");
		$("#cardExpirationMonth").focus();
		return false;
	}else if(!serviceCode){
		alert("CVV2不能为空");
		$("#serviceCode").focus();
		return false;
	}else if(!firstName){
		alert("firstName不能为空");
		$("#firstName").focus();
		return false;
	}else if(!lastName){
		alert("lastName不能为空");
		$("#lastName").focus();
		return false;
	}else if(!postCode){
		alert("postCode不能为空");
		$("#postCode").focus();
		return false;
	}else if(!email){
		alert("email不能为空");
		$("#email").focus();
		return false;
	}else if(!city){
		alert("city不能为空");
		$("#city").focus();
		return false;
	}else if(!phone){
		alert("phone不能为空");
		$("#phone").focus();
		return false;
	}else if(!country){
		alert("country不能为空");
		$("#country").focus();
		return false;
	}else if(!region){
		alert("region不能为空");
		$("#region").focus();
		return false;
	}else if(!street){
		alert("street不能为空");
		$("#street").focus();
		return false;
	}else if(!sign){
		alert("签名不能为空");
		$("#sign").focus();
		return false;
	}else{
		return true;
	}
}
























