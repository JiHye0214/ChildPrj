const $recommendBtn = document.querySelector(".recommend-btn");

const $recommendCnt = document.querySelector(".talk-inform-recomCnt");
let count = 0;
$recommendCnt.value = count;
$recommendCnt.innerText = count;

const clickRecommendBtn = () => {
    console.log($recommendCnt.value);
    $recommendCnt.innerText = $recommendCnt.value;
    $recommendCnt.value += 1;
};

$recommendBtn.addEventListener("click", clickRecommendBtn);
