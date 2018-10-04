var errorMap = new Map();

window.onload=function(){
	var formSubmit = document.getElementById('form');

	if ( window.addEventListener ) { 
		formSubmit.addEventListener('submit', validate);
	}
}


function firstNameValidate(){//validates first name in the form  where minimum length is 2 and should not be numeric

    var firstName = document.getElementById("firstName")	
                                            
    if(firstName.value.length<2 || /[^a-zA-Z]/.test(firstName.value)){

        firstName.style.borderColor="red";//border is red when validation is false
        errorMap.set("First Name","Length should be greater than 2 and should be non-numeric");//changes inner html of span tag with this message
    }
    else{
        firstName.style.borderColor="green";//otherwise green
        errorMap.delete("First Name");
    }
    
}   

function lastNameValidate(){//validates first name in the form  where minimum length is 2 and should not be numeric

	var lastName = document.getElementById("lastName");	
	var errorMessage= document.getElementById("lastNameMessage");

	if(lastName.value.length<2 || /[^a-zA-Z]/.test(lastName.value)){

		lastName.style.borderColor="red";//border is red when validation is false
		errorMap.set("Last Name","Length should be greater than 2 and should be non-numeric");//changes inner html of span tag with this message
    }
    else{
        lastName.style.borderColor="green";//otherwise green
        errorMap.delete("Last Name");
    }
}

function emailValidate(){//validates email where it should contain @, . and should have length atleast 5
    //also checks that @, . should not be used in beginning. and should not come together i.e. abc@.lmn is not valid

    var email= document.getElementById("email");

    if(email.value.length>4 && email.value.includes("@") && email.value.includes(".") && email.value.indexOf("@") != 0 && email.value.indexOf(".") !=0 && email.value.indexOf(".")-email.value.indexOf("@") != 1){
        email.style.borderColor="green";
        errorMap.delete("Email");
    }

email.style.borderColor="red";//border is red when validation is false
errorMap.set("Email","email should contain atleast 5 characters and should be in format abc@xyz.lmn");//changes inner html of span tag with this message

}

function contactNumberValidate(){//should have length 10 and should not contain any character other than digits
	
	var contactNumber = document.getElementById("contactNumber");
	
	if(contactNumber.value.length!=10 || /[^0-9]/.test(contactNumber.value)){
		contactNumber.style.borderColor="red";
        errorMap.set("Contact Number","Contact Number should only contain numbers and should be of length 10");
	}
	
	contactNumber.style.borderColor="green";
	errorMap.delete("Contact Number");
	
}

function addressValidate(){

    var address = document.getElementById("address");

    if(address.value.length>2 && address.value.length<=50){
        address.style.borderColor="green";
        errorMap.delete("Address");
    }

    address.style.borderColor="red";
    errorMap.set("Address","Address should have length atleast 3 and should not be more than 50");
    
}

function cityValidate(){

    var city = document.getElementById("city");

    if(city.value.length>2 && city.value.length<=20){
        city.style.borderColor="green";
        errorMap.delete("City");
    }
    city.style.borderColor="red";
    errorMap.set("City","City should have atleast 3 characters");
    return false;
}

function stateField(){
    var state = document.getElementById("state");

    var form = document.getElementById("form");
    
    var zipCode = document.getElementById("zipCode");
    var webDomain = document.getElementById("webDomain");
    var hosting = document.getElementById("hosting");
    var projectDes = document.getElementById("projectDes");

    if(document.contains(zipCode)){
        form.removeChild(zipCode);
    }

    if(document.contains(webDomain)){
        form.removeChild(webDomain);
    }

    if(document.contains(hosting)){
        form.removeChild(hosting);
    }

    if(document.contains(projectDes)){
        form.removeChild(projectDes);
    }

    if(state.value=="Rajasthan"){
        createWebDomain();
        createProjectDescription();
    }

    if(state.value=="Haryana"){
        createZipCode();
        createHosting();
    }
    
    if(state.value=="Maharashtra"){
        createZipCode();
        createProjectDescription();
    }
}

function createZipCode(){
    var form = document.getElementById("form");

    var rowDiv = document.createElement("div");
    rowDiv.className="row";
    rowDiv.id="zipCode";
    rowDiv.innerHTML="<div class='field'>Zip Code</div><div class='input-field'><div class='icon'><i class='fas fa-home'></i></div><input type='phone' placeholder='Zip Code' size='6' required/></div>";
    
    var buttonDiv = document.getElementById("buttonDiv");

    form.insertBefore(rowDiv,buttonDiv);
}

function createWebDomain(){

    var rowDiv = document.createElement("div");
    rowDiv.className="row";
    rowDiv.id="webDomain";
    rowDiv.innerHTML="<div class='field'>Website or Domain Page</div>" +"<div class='input-field'>" +
    "<div class='icon'><i class='fas fa-globe-asia'></i></div>" +
    "<input type='text' placeholder='Website or Domain Page' required/>" +
"</div>";

    var buttonDiv = document.getElementById("buttonDiv");

    form.insertBefore(rowDiv,buttonDiv);
}

function createHosting(){

    var rowDiv = document.createElement("div");
    rowDiv.className="row";
    rowDiv.id="hosting";
    rowDiv.innerHTML="<div class='field'>Do you have hosting?</div>" +
    "<div class='input-field'>" +
        "<input type='radio' name='check' value='Yes' required/>Yes<br />" +
        "<input type='radio' name='check' value='No' />No" +
    "</div>";

    var buttonDiv = document.getElementById("buttonDiv");

    form.insertBefore(rowDiv,buttonDiv);
}

function createProjectDescription(){

    var rowDiv = document.createElement("div");
    rowDiv.className="row";
    rowDiv.id="projectDes";
    rowDiv.innerHTML="<div class='field'>Project Description</div>" +
    "<div class='input-field'>" +
        "<div class='icon'><i class='fas fa-pencil-alt'></i></div>" +
        "<textarea rows='3' cols='20' name='Description'></textarea>" +
    "</div>";
    var buttonDiv = document.getElementById("buttonDiv");

    form.insertBefore(rowDiv,buttonDiv);
}

function validate(event){
    var message="";
    firstNameValidate();
    lastNameValidate();
    emailValidate();
    contactNumberValidate();
    addressValidate();
    cityValidate();
    for(var entry of errorMap){
        message += entry + "\n";
    }

    if(message.length != 0){
        alert(message);
        event.preventDefault();
    }

    console.log(message);
    
}
