const textColor = ["#63da53", "#ff748b", "#ffc400", "#dbdbdb"];
const menuArr = document.querySelectorAll(".menuText");
const $menuWrap = document.querySelector("menuTitleWrap");
const toggleArr = document.querySelectorAll(".raiseToggle");

// 어느 페이지인지 알아야지요
let link = document.location.href;
const linkArr = link.split("/");
console.log(linkArr);

// 토글 제어
if(linkArr[3] == "post"){
    toggleArr[0].style.display = `block`;
    toggleArr[1].style.display = `none`;
} else if(linkArr[3] == "product"){
    toggleArr[0].style.display = `none`;
    toggleArr[1].style.display = `block`;
}

// 메뉴
for(let i=0; i<menuArr.length; i++){
    if(linkArr[3] == "together"){
        menuArr[0].style.color = textColor[0];
    } else if(linkArr[3] == "protect"){
        menuArr[1].style.color = textColor[1];
    } else if((linkArr[3] == "post") || (linkArr[3] == "product")){
        menuArr[2].style.color = textColor[2];
    } else {
        menuArr[i].style.color = textColor[3];
    }
}

