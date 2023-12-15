const inputArr = document.querySelectorAll(".login-input")
const loginBtn = document.querySelector(".login-btn")
const warnMsgArr = document.querySelectorAll(".warn-message")

const loginValidation = () => {
    for(let i=0; i<2; i++) {
        let inputText = inputArr[i].value;
        if(inputText == "") {
            warnMsgArr[i].style.display = `block`;
        } else {
            warnMsgArr[i].style.display = `none`;
        }
    }
}

loginBtn.addEventListener("click", loginValidation)