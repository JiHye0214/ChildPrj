
const inputArr = document.querySelectorAll(".new")
const warnMsgArr = document.querySelectorAll(".login-warn")
const $signupBtn = document.querySelector(".signup-btn")
const $signValid = document.querySelector(".sign-valid")

const signUpValidation = () => {

    let count = 0;
    let pwCheck = false;

    // 모두 입력 valid
    for(let i=0; i<inputArr.length; i++) {
        let input = inputArr[i].value;
        if(input == "") {
            warnMsgArr[i].innerHTML = `${inputArr[i].placeholder} 을(를) 입력해 주세요`;
        } else {
            warnMsgArr[i].innerHTML = ``;
            count++;
        }
    }

    // 비밀번호 일치 확인
    if(inputArr[1].value == inputArr[2].value){
        pwCheck = true;
    } else {
        warnMsgArr[2].innerHTML = "비밀번호가 일치하지 않습니다";
    }

    if(count == 6 && pwCheck == true) {
        document.forms["signup"].submit();
    }
}

$signupBtn.addEventListener("click", signUpValidation)