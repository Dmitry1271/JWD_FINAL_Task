let login = document.forms['login_form']['login'];
let password = document.forms['login_form']['password'];

let loginError = document.getElementById('login_error');
let passwordError = document.getElementById('password_error');

login.addEventListener('blur', loginVerify, true);
password.addEventListener('blur', passwordVerify, true);

function loginVerify(){
	if(!isEmpty(login)){
		return hideError(login, loginError)
	}
}
function passwordVerify(){
	if(!isEmpty(password)){
		return hideError(password, passwordError)
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
function vlidateLoginData(){
	if(isEmpty(login)){
		return showError(login, loginError, 'Login is required');
	}
	if(isEmpty(password)){
		return showError(password, passwordError, 'Password is required');
	}
}