const openDivArr = document.querySelectorAll(".find-content-title");
const hiddenMenuArr = document.querySelectorAll(".find-content-hidden");

const openBtnArr = document.querySelectorAll(".menu-open");
const closeBtnArr = document.querySelectorAll(".menu-close");

const stateArr = [false, false, false]; // ~ 찾기 open state

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
