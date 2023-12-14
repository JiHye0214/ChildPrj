const allAgree = document.getElementById("check0");
const agree1 = document.getElementById("check1");
const agree2 = document.getElementById("check2");

const $nextBtn = document.querySelector(".agree-next-btn");

$nextBtn.style.background = `rgb(197,197,197)`;
$nextBtn.style.cursor = `default`;

if (allAgree.checked || (agree1.checked && agree2.checked)) {
    $nextBtn.style.background = ``;
    console.log("hi");
}

const clickAllCheckBox = () => {
    if (allAgree.checked) {
        agree1.checked = true;
        agree2.checked = true;
        $nextBtn.style.background = ``;
        $nextBtn.style.cursor = ``;
    } else {
        agree1.checked = false;
        agree2.checked = false;
        $nextBtn.style.background = `rgb(197,197,197)`;
        $nextBtn.style.cursor = `default`;
    }
};

const clickCheckBox = () => {
    if (agree1.checked && agree2.checked) {
        allAgree.checked = true;
        $nextBtn.style.background = ``;
        $nextBtn.style.cursor = ``;
    } else {
        allAgree.checked = false;
        $nextBtn.style.background = `rgb(197,197,197)`;
        $nextBtn.style.cursor = `default`;
    }
};

allAgree.addEventListener("click", clickAllCheckBox);
agree1.addEventListener("click", clickCheckBox);
agree2.addEventListener("click", clickCheckBox);
