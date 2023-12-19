const $commentWriteBtn = document.querySelector(".market-comment-content > .market-btn");
const $commentInput = document.querySelector(".market-comment-content > .write-comment-input");
const $price = document.querySelector(".market-writer-price");
const $detailDelBtn = document.querySelector(".delBtn");

const cmtDelBtnArr = document.querySelectorAll(".comment-delete-btn");
const cmtFormArr = document.querySelectorAll(".product-comment-content");

// 가격 0 --> 나눔
if($price.innerText == "0"){
    $price.innerText = "나눔";
}

// 댓글 작성
const clickMarketCommentWriteBtn = () => {
    if($commentInput.value != "") {
        document.forms["writeComment"].submit();
        $commentInput.value = "";
    }
}

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

const clickCmtDelBtn = (i) => { // index : 내가 누른 버튼
    let del = confirm("댓글을 삭제하시겠습니까?");
    if(del){
        console.log(formWithBtn[i]);
        console.log(formWithBtn[i].name);
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

$commentWriteBtn.addEventListener("click", clickMarketCommentWriteBtn);
$detailDelBtn.addEventListener("click", clickDetailDelBtn);

for(let i=0; i<cmtDelBtnArr.length; i++){
    cmtDelBtnArr[i].onclick = function () {
        clickCmtDelBtn(i);
    };
}
