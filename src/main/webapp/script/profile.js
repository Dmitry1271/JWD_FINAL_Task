let email = document.forms['change_profile_form']['email'];
let phoneNumber = document.forms['change_profile_form']['phone_number'];
let address = document.forms['change_profile_form']['address'];

let emailError = document.getElementById('email_error');
let phoneNumberError = document.getElementById('phone_number_error');

email.addEventListener('blur', emailVerify, true);
phoneNumber.addEventListener('blur', phoneNumberVerify, true);

function emailVerify(){
    if(!isEmpty(email) && isValidEmail(email)){
        return hideError(email, emailError);
    }
}
function phoneNumberVerify(){
    if(isEmpty(phoneNumber) || isValidPhoneNumber(phoneNumber)){
        return hideError(phoneNumber, phoneNumberError);
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
function isValidEmail(email){
    return	email.value.match('^([a-zA-Z0-9_].+@.+\..+)$');
}
function isValidPhoneNumber(phoneNumber){
    return phoneNumber.value.match('^[0-9]{5,15}$');
}

function validateInputProfileData(){
    if(isEmpty(email)){
        return showError(email, emailError, 'Email is required');
    }
    if(!isValidEmail(email)){
        return showError(email, emailError, 'Email is invalid');
    }
    if(!isEmpty(phoneNumber) && !isValidPhoneNumber(phoneNumber) ){
        return showError(phoneNumber, phoneNumberError, 'Invalid phone number');
    }
}

let oldPassword = document.forms['change_password_form']['old_password'];
let password = document.forms['change_password_form']['password'];
let passwordConf = document.forms['change_password_form']['password_confirmation'];

let oldPasswordError = document.getElementById('old_password_error');
let passwordError = document.getElementById('password_error');
let passwordConfError = document.getElementById('password_conf_error');

oldPassword.addEventListener('blur', oldPasswordVerify, true);
password.addEventListener('blur', passwordVerify, true);
passwordConf.addEventListener('blur', passwordConfVerify, true);

function oldPasswordVerify(){
    if(!isEmpty(oldPassword)){
        return hideError(oldPassword, oldPasswordError);
    }
}

function passwordVerify(){
    if(!isEmpty(password) && isValidPasswordLength(password) && isValidPassword(password)){
        return hideError(password, passwordError);
    }
}
function passwordConfVerify(){
    if(!isEmpty(passwordConf) && passwordsMatch(password, passwordConf)){
        return hideError(passwordConf, passwordConfError);
    }
}
function passwordsMatch(pas1, pas2){
    return pas1.value == pas2.value;
}
function isValidPasswordLength(password){
    return password.value.length >= 6;
}
function isValidPassword(password){
    return password.value.search('[a-z]') >= 0 && password.value.search('[A-Z]') >= 0 && password.value.search('[0-9]') >= 0;
}

function validateInputPasswordsData(){
    if(isEmpty(oldPassword)){
        return showError(oldPassword, oldPasswordError, 'Old password is required');
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
}
