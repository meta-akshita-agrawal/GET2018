function firstNameValidate(){//validates first name in the form  where minimum length is 2 and should not be numeric

		var firstName = document.myForm.firstName;	
		var errorMessage= document.getElementById("firstNameMessage");
												
	if(firstName.value.length<2 || /[^a-zA-Z]/.test(firstName.value)){

		firstName.style.borderColor="red";//border is red when validation is false
		errorMessage.style.color="red";
		errorMessage.innerHTML="Length should be greater than 2 and should be non-numeric";//changes inner html of span tag with this message
		return false;
	}

	errorMessage.innerHTML="";
	firstName.style.borderColor="green";//otherwise green
	
	return true;
}

function lastNameValidate(){//validates first name in the form  where minimum length is 2 and should not be numeric

	var lastName = document.myForm.lastName;	
	var errorMessage= document.getElementById("lastNameMessage");

	if(lastName.value.length<2 || /[^a-zA-Z]/.test(lastName.value)){

		lastName.style.borderColor="red";//border is red when validation is false
		errorMessage.style.color="red";
		errorMessage.innerHTML="Length should be greater than 2 and should be non-numeric";//changes inner html of span tag with this message
		
		return false;
	}
	
	lastName.style.borderColor="green";//otherwise green
	errorMessage.innerHTML="";
	
	return true;
}

function emailValidate(){//validates email where it should contain @, . and should have length atleast 5
						 //also checks that @, . should not be used in beginning. and should not come together i.e. abc@.lmn is not valid
	
	var email= document.myForm.email;
	var errorMessage= document.getElementById("emailMessage");
	
	if(email.value.length>4 && email.value.includes("@") && email.value.includes(".") && email.value.indexOf("@") != 0 && email.value.indexOf(".") !=0 && email.value.indexOf(".")-email.value.indexOf("@") != 1){
		email.style.borderColor="green";
		errorMessage.innerHTML="";
		return true;
	}
	
	email.style.borderColor="red";//border is red when validation is false
	errorMessage.style.color="red";
	errorMessage.innerHTML="email should contain atleast 5 characters and should be in format abc@xyz.lmn";//changes inner html of span tag with this message
	return false;
	
}

function passwordValidate(){//should contains Uppercase, Lowercase, Numeric, Alphanumeric, and length minimum 8
	
	var password = document.myForm.password;
	var errorMessage = document.getElementById("passwordMessage");
	
	if(password.value.length>=8 && /[A-Z]/.test(password.value) && /[a-z]/.test(password.value) && /[0-9]/.test(password.value) && /[a-zA-z0-9]/.test(password.value)){
		password.style.borderColor="green";
		errorMessage.innerHTML="";
		return true;
	}
	
	password.style.borderColor="red";
	errorMessage.style.color="red";
	errorMessage.innerHTML="Password should contain atleast an uppercase, lowercase and should have minimum 8 characters";
	return false;
	
}

function confrimPasswordValidate(){//should be same as password value
	
	var cpassword = document.myForm.cpassword;
	var errorMessage = document.getElementById("cpasswordMessage");
	
	if(document.myForm.password.value == cpassword.value){
		cpassword.style.borderColor="green";	
		errorMessage.innerHTML="";
		return true;
	}
	
	cpassword.style.borderColor="red";
	errorMessage.innerHTML="Both passwords should be same"
	return false;
}

function contactNumberValidate(){//should have length 10 and should not contain any character other than digits
	
	var contactNumber = document.myForm.contactNumber;
	
	if(contactNumber.value.length!=10 || /[^0-9]/.test(contactNumber.value)){
		contactNumber.style.borderColor="red";
		return false;
	}
	
	contactNumber.style.borderColor="green";
	return true;
	
}


function formValidate(){//performs every validation returns false if any one of them is false
	return firstNameValidate() && lastNameValidate() && emailValidate() && passwordValidate() && confrimPasswordValidate() && contactNumberValidate();
}