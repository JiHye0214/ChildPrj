const $recomBtn = document.querySelector(".talk-left-btn-wrap > .raise-btn");
const cmtDelBtnArr = document.querySelectorAll(".comment-delete-btn");

let recomToggle = false;

// 추천
const clickRecommendBtn = () => {
    if(!recomToggle){
        $recomBtn.style.background = `var(--raise-btn)`;
        recomToggle = true
    } else {
        $recomBtn.style.background = `white`;
        recomToggle = false
    }
}

$recomBtn.addEventListener("click", clickRecommendBtn);

// 글 삭제
const clickDetailDelBtn = () => {
    let del = confirm("글을 삭제하시겠습니까?");
    if(del){
        document.forms["detailDelete"].submit();
    }
}