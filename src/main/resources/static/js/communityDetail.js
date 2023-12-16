const $recomBtn = document.querySelector(".talk-left-btn-wrap > .raise-btn");

let recomToggle = false;

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
