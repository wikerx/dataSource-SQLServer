// JavaScript Document
var issubmit=false;
//全局变量设置不可重复提交，切记
function validateForm(){
	if(issubmit==false){
      issubmit = true;
		//cardNo
		if($('#cardNo').val()==""){
				$('#cardNoText').html('Card number cannot be empty.');
				$('#cardNo').focus();
			issubmit = false;
			return false;
		}
		if(parseInt($('#cardNo').val().length) < 15 || parseInt($('#cardNo').val().length) > 19){
				$('#cardNoText').html('Please enter the correct card number.');
				$('#cardNo').focus();
			issubmit = false;
			return false;
		}
		//cardType
		var cardNoType = $('#cardType').val();
		if(cardType($('#cardNo').val()).toUpperCase() == "noCardType".toUpperCase()){
				$('#cardNoText').html('Sorry, your card is unrecognized. Please try another card.');
				$('#cardNo').focus();
			issubmit = false;
			return false;
		}
		if(cardNoType.toUpperCase().indexOf(cardType($('#cardNo').val()).toUpperCase()) == -1){
				$('#cardNoText').html('Sorry, your service provider has not yet opened the '+cardType($('#cardNo').val()).toUpperCase()+' card channel,Please try another card.');
				$('#cardNo').focus();
			issubmit = false;
			return false;
			}
		
		//serviceCode
		if($('#serviceCode').val()==""){
				$('#cvvText').html('CVV cannot be empty.');
				$('#serviceCode').focus();
			issubmit = false;
			return false;
			}
		if(parseInt($('#serviceCode').val().length) < 3 || parseInt($('#serviceCode').val().length) > 4){
				$('#cvvText').html('Please enter the correct CVV.');
				$('#serviceCode').focus();
			issubmit = false;
			return false;
		}
		//expiryMonth
		if(!$('#expiryMonth').val()){
				$('#expiryText').html('The expiryMonth cannot be empty.');
				$('#expiryMonth').focus();
			issubmit = false;
			return false;
		}
		//expiryYear
		if(!$('#expiryYear').val()){
				$('#expiryText').html('The expiryYear cannot be empty.');
				$('#expiryYear').focus();
			issubmit = false;
			return false;
		}
		//Time contrast
		 var date=new Date;
		 var year=date.getFullYear(); 
		 var month=date.getMonth()+1;
		 month =(month<10 ? "0"+month:month); 
		 var mydate = (year.toString()+month.toString());
		 var getdate = $('#expiryYear').val()+$('#expiryMonth').val();
		 if(parseInt(getdate)<parseInt(mydate)){
			 $('#expiryText').html('Overdue cards, please change cards and pay again.');
			 $('#expiryYear').focus();
			 issubmit = false;
			return false;
		}
		//FirstName
		if($('#firstName').val()==""){
				$('#firstText').html('First Name cannot be empty.');
				$('#firstName').focus();
			issubmit = false;
			return false;
		}
		//LastName
		if($('#lastName').val()==""){
				$('#lastText').html('Last Name cannot be empty.');
				$('#lastName').focus();
			issubmit = false;
			return false;
		}
		//Address
		if($('#street').val()==""){
				$('#addressText').html('Address cannot be empty.');
				$('#street').focus();
			issubmit = false;
			return false;
			}
		//City
		if($('#city').val()==""){
				$('#cityText').html('City cannot be empty.');
				$('#city').focus();
			issubmit = false;
			return false;
			}
		//Country
		if($('#country').val()==""){
				$('#countryText').html('Country cannot be empty.');
				$('#country').focus();
			issubmit = false;
			return false;
			}
		//postCode
		if($('#postCode').val()==""){
				$('#zipText').html('postCode cannot be empty.');
				$('#postCode').focus();
			issubmit = false;
			return false;
			}
		//Email
		if($('#email').val()==""){
				$('#emailText').html('Email cannot be empty.');
				$('#email').focus();
			issubmit = false;
			return false;
			}
		var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
		if(!reg.test($('#email').val())){
				$('#emailText').html('The mailbox format is incorrect/illegal.');
				$('#email').focus();
			issubmit = false;
			return false;
			}	
		//Tel
		if($('#phone').val()==""){
				$('#telText').html('Telephone cannot be empty.');
				$('#phone').focus();
			issubmit = false;
			return false;
			}
		var regexp1 = "^(((\\+\\d{2}-)?0\\d{2,3}-\\d{7,8})|((\\+\\d{2}-)?(\\d{2,3}-)?([1][3,4,5,7,8][0-9]\\d{8})))$";
		var regexp2 = "^(\\+\\d{2}-)?(\\d{2,3}-)?([1][3,4,5,7,8][0-9]\\d{8})$";
		if(!regexp1.test($('#phone').val()) && !regexp2.test($('#phone').val())){
				$('#telText').html('The telephone format is incorrect/illegal.');
				$('#phone').focus();
			issubmit = false;
			return false;
		}
		//Non-repeatable submission
		//$("input[type='submit']").attr("disabled",true);
	}else{
		issubmit = false;
		return false;
	}
		
	}
	
	//cardType
	function cardType(cardNo){
		var cardType = "noCardType";
		if(cardNo.slice(0,1)=="4"){
			cardType = "visa";
		}
		if(((parseInt(cardNo.slice(0,2)) >= 51)&&(parseInt(cardNo.slice(0,2)) <= 55)) || ((parseInt(cardNo.slice(0,4)) >= 2221)&&(parseInt(cardNo.slice(0,4)) <= 2720))  ){
			cardType = "master";
		}
		if(((parseInt(cardNo.slice(0,4)) >= 3528)&&(parseInt(cardNo.slice(0,4)) <= 3589)) || cardNo.slice(0,4)=="2131" || cardNo.slice(0,4)=="1800"){
			cardType = "jcb";
		}
		if(cardNo.slice(0,2)=="34" || cardNo.slice(0,2)=="37"){
			cardType = "ae";
		}
		if(cardNo.slice(0,2)=="36" || cardNo.slice(0,4)=="3095" || (parseInt(cardNo.slice(0,2)) >= 38 && parseInt(cardNo.slice(0,2)) <= 39) || 
		(parseInt(cardNo.slice(0,3)) >= 300 && parseInt(cardNo.slice(0,3)) <= 305)){
			cardType = "dc";
		}
		if(cardNo.slice(0,4)=="6011" || cardNo.slice(0,2)=="64" || cardNo.slice(0,2)=="65" ||
		 (parseInt(cardNo.slice(0,6)) >= 622126 && parseInt(cardNo.slice(0,6)) <= 622925) ||
		  (parseInt(cardNo.slice(0,6)) >= 624000 && parseInt(cardNo.slice(0,6)) <= 626999) || 
		  (parseInt(cardNo.slice(0,6)) >= 628200 && parseInt(cardNo.slice(0,6)) <= 628899) ){
			cardType = "dic";
			}
	return cardType;
	}
	
	