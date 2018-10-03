function firstNameValidate(){//validates first name in the form  where minimum length is 2 and should not be numeric

    var firstName = document.getElementById("firstName")	
                                            
if(firstName.value.length<2 || /[^a-zA-Z]/.test(firstName.value)){

    firstName.style.borderColor="red";//border is red when validation is false
    //errorMessage.style.color="red";
    //alert("Length should be greater than 2 and should be non-numeric");//changes inner html of span tag with this message
    return false;
}
firstName.style.borderColor="green";//otherwise green
return true;
}

function lastNameValidate(){//validates first name in the form  where minimum length is 2 and should not be numeric

	var lastName = document.getElementById("lastName");	
	var errorMessage= document.getElementById("lastNameMessage");

	if(lastName.value.length<2 || /[^a-zA-Z]/.test(lastName.value)){

		lastName.style.borderColor="red";//border is red when validation is false
		//errorMessage.style.color="red";
		//alert("Length should be greater than 2 and should be non-numeric");//changes inner html of span tag with this message
		
		return false;
	}
	
	lastName.style.borderColor="green";//otherwise green
	//errorMessage.innerHTML="";
	
	return true;
}

function emailValidate(){//validates email where it should contain @, . and should have length atleast 5
    //also checks that @, . should not be used in beginning. and should not come together i.e. abc@.lmn is not valid

var email= document.getElementById("email");

if(email.value.length>4 && email.value.includes("@") && email.value.includes(".") && email.value.indexOf("@") != 0 && email.value.indexOf(".") !=0 && email.value.indexOf(".")-email.value.indexOf("@") != 1){
email.style.borderColor="green";
//errorMessage.innerHTML="";
return true;
}

email.style.borderColor="red";//border is red when validation is false
//errorMessage.style.color="red";
//alert("email should contain atleast 5 characters and should be in format abc@xyz.lmn");//changes inner html of span tag with this message
return false;

}

function contactNumberValidate(){//should have length 10 and should not contain any character other than digits
	
	var contactNumber = document.getElementById("contactNumber");
	
	if(contactNumber.value.length!=10 || /[^0-9]/.test(contactNumber.value)){
		contactNumber.style.borderColor="red";
		return false;
	}
	
	contactNumber.style.borderColor="green";
	return true;
	
}

function addressValidate(){

    var address = document.getElementById("address");

    if(address.value.length>2 && address.value.length<=50){
        address.style.borderColor="green";
        return true;
    }

    address.style.borderColor="red";
    return false;
}

function cityValidate(){

    var city = document.getElementById("city");

    if(city.value.length>2 && city.value.length<=20){
        city.style.borderColor="green";
        return true;
    }
    city.style.borderColor="red";
    return false;
}

