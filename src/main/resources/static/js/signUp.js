const warnMsgArr = document.querySelectorAll(".warn-message");

const inputArr = document.querySelectorAll(".signup-input")
const $signupBtn = document.querySelector(".signup-btn")
const warnMsgArr = document.querySelectorAll(".warn-message")

const signUpValidation = () => {
    for(let i=0; i<2; i++) {
        let inputText = inputArr[i].value;
        if(inputText == "") {
            warnMsgArr[i].style.display = `block`;
        } else {
            warnMsgArr[i].style.display = `none`;
        }
    }
}

$signupBtn.addEventListener("click", signUpValidation)