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
const graphGrade = document.querySelectorAll(".grade");

let i=1;
for(e of graphGrade){
    e.innerText = i;
    i++;
    if(i == 6) i = 1;
}
