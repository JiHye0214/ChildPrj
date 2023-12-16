$(function(){
    // Summernode 추가
    $('.content-box').summernote({
        width: 1200,
        height: 350,
        placeholder: "내용을 입력해 주세요",
    });

});

const $writeBtn = document.querySelector(".write-btn");
const writeArr = document.querySelectorAll(".write-valid");
const warnMsgArr = document.querySelectorAll(".warn-message");

//const writeValidation = () => {
//    for(let i=0; i<2; i++) {
//        let inputText = writeArr[i].value;
//        if(inputText == "") {
//            warnMsgArr[i].style.display = `block`;
//        } else {
//            warnMsgArr[i].style.display = `none`;
//        }
//    }
//}

// $writeBtn.addEventListener("click", writeValidation);