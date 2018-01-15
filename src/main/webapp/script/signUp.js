let login = document.forms['register_form']['login'];
let email = document.forms['register_form']['email'];
let password = document.forms['register_form']['password'];
let passwordConf = document.forms['register_form']['confirm_password'];
let phoneNumber = document.forms['register_form']['phone_number'];
let address = document.forms['register_form']['address'];

let loginError = document.getElementById('login_error');
let emailError = document.getElementById('email_error');
let passwordError = document.getElementById('password_error');
let passwordConfError = document.getElementById('password_conf_error');
let phoneNumberError = document.getElementById('phone_number_error');
let addressError = document.getElementById('address_error');

login.addEventListener('blur', loginVerify, true);
email.addEventListener('blur', emailVerify, true);
password.addEventListener('blur', passwordVerify, true);
passwordConf.addEventListener('blur', passwordConfVerify, true);
phoneNumber.addEventListener('blur', phoneNumberVerify, true);
address.addEventListener('blur', addressVerify, true);

function loginVerify(){
	if(!isEmpty(login) && isValidLogin(login)){
		return hideError(login, loginError)
	}
}
function emailVerify(){
	if(!isEmpty(email) && isValidEmail(email)){
		return hideError(email, emailError)
	}
}
function passwordVerify(){
	if(!isEmpty(password) && isValidPasswordLength(password) && isValidPassword(password)){
		return hideError(password, passwordError)
	}
}
function passwordConfVerify(){
	if(!isEmpty(passwordConf) && passwordsMatch(password, passwordConf)){
		return hideError(passwordConf, passwordConfError)
	}
}
function phoneNumberVerify(){
	if(!isEmpty(phoneNumber) && isValidPhoneNumber(phoneNumber)){
		return hideError(phoneNumber, phoneNumberError)
	}
}
function addressVerify(){
	if(!isEmpty(address)){
		return hideError(address, addressError)
	}
}
function showError(elem, elemError, errorMessage){
	elem.style.cssText = 'border-bottom: solid 1px red;';
	elemError.textContent = errorMessage;
	elem.focus();
	return false;
}
function hideError(elem, elemError){
	elem.style.cssText = 'border-bottom: solid 1px #a2a2a2;';
	elemError.innerHTML = '';
	return true;
}
function isEmpty(elem){
	return elem.value == '';
}
function passwordsMatch(pas1, pas2){
	return pas1.value == pas2.value;
}
function isValidLogin(login){
	return login.value.match('^[a-zA-Z][a-zA-Z@\-_0-9]{5,20}$');
}
function isValidEmail(email){
	return	email.value.match('^[a-zA-Z0-9_].+@.+\..+');
}
function isValidPhoneNumber(phoneNumber){
	return phoneNumber.value.match('^[0-9]{5,15}$');
}
function isValidPasswordLength(password){
	return password.value.length >= 6;
}
function isValidPassword(password){
	return password.value.search('[a-z]') >= 0 && password.value.search('[A-Z]') >= 0 && password.value.search('[0-9]') >= 0;
}


function vlidateRegisterData(){
	if(isEmpty(login)){
		return showError(login, loginError, 'Login is required');
	}
	if(!isValidLogin(login)){
		return showError(login, loginError, 'Login must have more then 5 symbols and start from english letter');
	}
	if(isEmpty(email)){
		return showError(email, emailError, 'Email is required');
	}
	if(!isValidEmail(email)){
		return showError(email, emailError, 'Email is invalid');
	}
	if(isEmpty(password)){
		return showError(password, passwordError, 'Password is required');
	}
	if(!isValidPasswordLength(password)){
		return showError(password, passwordError, 'Password must include min 6 symbols');
	}
	if(!isValidPassword(password)){
		return showError(password, passwordError, 'Password must include min one letter of any register and number');
	}
	if(!passwordsMatch(password, passwordConf)){
		return showError(passwordConf, passwordConfError, 'Passwords must match');
	}
	if(isEmpty(phoneNumber)){
		return showError(phoneNumber, phoneNumberError, 'Phone number is required');
	}
	if(!isValidPhoneNumber(phoneNumber)){
		return showError(phoneNumber, phoneNumberError, 'Invalid phone number');
	}
	if(isEmpty(address)){
		return showError(address, addressError, 'Address is required');
	}
}