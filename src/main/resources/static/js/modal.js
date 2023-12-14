const $dropUserClose = document.querySelector(".dropUserCloseBtn");
const $modal = document.querySelector(".modal");

const clickDropUserCloseBtn = () => {
    $modal.style.visibility = `hidden`;
    $body.style.overflow = "unset";
};

$dropUserClose.addEventListener("click", clickDropUserCloseBtn);
