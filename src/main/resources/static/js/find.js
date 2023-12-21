const openDivArr = document.querySelectorAll(".find-content-title");
const hiddenMenuArr = document.querySelectorAll(".find-content-hidden");
const openBtnArr = document.querySelectorAll(".menu-open");
const closeBtnArr = document.querySelectorAll(".menu-close");

const stateArr = [false, false, false]; // ~ 찾기 open state

// 누르면 열리기
const clickHiddenMenuBtn = (index) => {
    if (!stateArr[index]) {
        openBtnArr[index].style.display = `none`;
        closeBtnArr[index].style.display = `block`;
        hiddenMenuArr[index].style.display = `block`;
        stateArr[index] = true;
    } else {
        openBtnArr[index].style.display = `block`;
        closeBtnArr[index].style.display = `none`;
        hiddenMenuArr[index].style.display = `none`;
        stateArr[index] = false;
    }
};

for (let i = 0; i < 3; i++) {
    openDivArr[i].onclick = function () {
        clickHiddenMenuBtn(i);
    };
}


// 버튼을 누르면 해당 form valid 할 수 있지??
// valid 후 submit
const findBtnArr = document.querySelectorAll(".find-btn");
const findFromArr = document.querySelectorAll(".find-input-wrap");

const clickFindBtn = (index) => {
    console.log(findFromArr[index].firstElementChild.innerContext);
}

for(let i=0; i<3; i++){
    findBtnArr[i].onclick = function() {
        clickFindBtn(i);
    }
}