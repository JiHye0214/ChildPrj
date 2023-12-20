const $recomBtn = document.querySelector(".talk-left-btn-wrap > .raise-btn");
const $commentInput = document.querySelector(".talk-comment-content > .write-comment-input");
const $commentWriteBtn = document.querySelector(".talk-comment-content > .talk-btn");

const $writeForm = document.querySelector(".talk-comment-content");
const cmtDelBtnArr = document.querySelectorAll(".comment-delete-btn");
const cmtFormArr = document.querySelectorAll(".post-comment-content");

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

// 댓글 작성
const clickMarketCommentWriteBtn = () => {
    if($commentInput.value != "") {
        document.forms["writeComment"].submit();
        $commentInput.value = "";
    }
}

$commentWriteBtn.addEventListener("click", clickMarketCommentWriteBtn);

// 댓글 삭제 (onclick)
// form이 댓글 개수만큼 있을거라고.
// 그것 중에서 버튼이 있는 애들만 골라내.
// 그리고 내가 누른 버튼의 인덱스의 form을 찾아서
// 걔를 submit

const formWithBtn = [];
let index = 0;

for(let i=0; i<cmtFormArr.length; i++){
    if(cmtFormArr[i].childElementCount == 6){ // js 너란 녀석..
        formWithBtn[index] = cmtFormArr[i];
        formWithBtn[index].name = index; // 해당 폼 이름 바꾸기
        index++;
    }
}

for(let i=0; i<cmtDelBtnArr.length; i++){
    cmtDelBtnArr[i].onclick = function () {
        clickCmtDelBtn(i);
    };
}

const clickCmtDelBtn = (i) => { // index : 내가 누른 버튼
    let del = confirm("댓글을 삭제하시겠습니까?");
    if(del){
        formWithBtn[i].submit();
    }
}

// 글 삭제
const clickDetailDelBtn = () => {
    let del = confirm("글을 삭제하시겠습니까?");
    if(del){
        document.forms["detailDelete"].submit();
    }
}