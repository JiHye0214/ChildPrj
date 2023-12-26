const $togetherTitle = document.querySelector(".together");
const $protectTitle = document.querySelector(".protect");
const $raiseTitle = document.querySelector(".raise");

const titleArr = document.querySelectorAll(".main-menu");
const detailArr = document.querySelectorAll(".main-detail");

let findIndex = 0;

const addClassTogetherDetail = () => {
    $togetherTitle.classList.add("togetherColor");
    detailArr[0].classList.add("slideDetailDown");
    findIndex = 0;
};
const addClassProtectDetail = () => {
    $protectTitle.classList.add("protectColor");
    detailArr[1].classList.add("slideDetailDown");
    findIndex = 1;
};
const addClassRaiseDetail = () => {
    $raiseTitle.classList.add("raiseColor");
    detailArr[2].classList.add("slideDetailDown");
    findIndex = 2;
};

const mouseOut = () => {
    titleArr[findIndex].className = "main-menu";
    detailArr[findIndex].classList.remove("slideDetailDown");
    detailArr[findIndex].classList.add("slideDetailUp");
};

$togetherTitle.addEventListener("mouseover", addClassTogetherDetail);
$protectTitle.addEventListener("mouseover", addClassProtectDetail);
$raiseTitle.addEventListener("mouseover", addClassRaiseDetail);

$togetherTitle.addEventListener("mouseout", mouseOut);
$protectTitle.addEventListener("mouseout", mouseOut);
$raiseTitle.addEventListener("mouseout", mouseOut);

// graph
const graphWrap = document.querySelectorAll(".graph");

for(let i=0; i<graphWrap.length; i++){
    let count = graphWrap[i].childElementCount;
    for(let j=1; j<count; j++){
        graphWrap[i].children[j].children[0].innerText = j;
    }
}
