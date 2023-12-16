
const inputArr = document.querySelectorAll(".signup-input-wrap > input")
const warnMsgArr = document.querySelectorAll(".warn-message")
const $signupBtn = document.querySelector(".signup-btn")

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