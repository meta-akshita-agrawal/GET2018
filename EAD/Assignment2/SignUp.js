
		
			function firstNameValidate(){

				var firstName = document.myForm.firstName;	
				var errorMessage= document.getElementById("firstNameMessage");
				
				if(firstName.value.length<2 || /[^a-zA-Z]/.test(firstName.value)){
		
					firstName.style.borderColor="red";
					errorMessage.style.color="red";
					errorMessage.innerHTML="Length should be greater than 2 and should be non-numeric";
					return false;
				}
				
				errorMessage.innerHTML="";
				firstName.style.borderColor="green";
				
				return true;
			}
		
			function lastNameValidate(){
			
				var lastName = document.myForm.lastName;	
				var errorMessage= document.getElementById("lastNameMessage");
			
				if(lastName.value.length<2 || /[^a-zA-Z]/.test(lastName.value)){
		
					lastName.style.borderColor="#ff0000";
					errorMessage.style.color="red";
					errorMessage.innerHTML="Length should be greater than 2 and should be non-numeric";
					
					return false;
				}
				
				lastName.style.borderColor="#008000";
				errorMessage.innerHTML="";
				
				return true;
			}
			
			function emailValidate(){
				
				var email= document.myForm.email;
				var errorMessage= document.getElementById("emailMessage");
				
				if(email.value.length>4 && email.value.includes("@") && email.value.includes(".") && email.value.indexOf("@") != 0 && email.value.indexOf(".") !=0 && email.value.indexOf(".")-email.value.indexOf("@") != 1){
					email.style.borderColor="green";
					errorMessage.innerHTML="";
					return true;
				}
				
				email.style.borderColor="red";
				errorMessage.style.color="red";
				errorMessage.innerHTML="email should contain atleast 5 characters and should be in format abc@xyz.lmn";
				return false;
				
			}
			
			function passwordValidate(){
				
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
			
			function confrimPasswordValidate(){
				
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
			
			function contactNumberValidate(){
				
				var contactNumber = document.myForm.contactNumber;
				
				if(contactNumber.value.length!=10 || /[^0-9]/.test(contactNumber.value)){
					contactNumber.style.borderColor="red";
					return false;
				}
				
				contactNumber.style.borderColor="green";
				return true;
				
			}
			
			function companyValidate(){
				var companyName= document.myForm.companyName;
				
				if(companyName.value="Choose here"){
					companyName.style.borderColor="red";
					return false;
				}
				
				companyName.style.borderColor="green";
				return true;
				
			}
			
			function formValidate(){
				return firstNameValidate() && lastNameValidate() && emailValidate() && passwordValidate() && confrimPasswordValidate() && contactNumberValidate() && companyValidate();
			}
