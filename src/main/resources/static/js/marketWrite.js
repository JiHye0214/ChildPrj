const guNames = [
    "강남구",
    "강동구",
    "강북구",
    "강서구",
    "관악구",
    "광진구",
    "구로구",
    "금천구",
    "노원구",
    "도봉구",
    "동대문구",
    "동작구",
    "마포구",
    "서대문구",
    "서초구",
    "성동구",
    "성북구",
    "송파구",
    "양천구",
    "영등포구",
    "용산구",
    "은평구",
    "종로구",
    "중구",
    "중랑구",
];

// $('#content').summernote('fontSize', 20);
$("#content").summernote({
    width: 1200,
    height: 350,
    placeholder: "내용을 입력해 주세요",
});

const guSelectBtn = document.querySelector("#gu-select-btn");
const guWrap = document.querySelector("#gu-wrap");
const guInput = document.querySelector(".gu-input");

guNames.forEach((guName) => {
    guWrap.innerHTML += `<div class="gu">${guName}</div>`;
});
const guDiv = document.querySelectorAll(".gu");

guDiv.forEach((gu) => {
    gu.addEventListener("click", () => {
        // 방금 클릭한 구가 이미 클릭되어 있었다면
        // 해당 구 "clicked" 해제
        // 글자를 "지역선택" 으로 변경
        if (gu.classList.contains("clicked")) {
            gu.classList.remove("clicked");
            guSelectBtn.textContent = "지역선택";
        }
            // 방금 클릭한 구가 구 중에 첫 클릭이거나
            // 방금 클릭한 구 이전에 클릭되어 있던 다른 구가 있었다면
            // 모든 구 "clicked" 해제 후 방금 클릭한 구 "clicked" 추가
        // 글자를 해당 "~~구" 로 변경
        else {
            guDiv.forEach((el) => {
                el.classList.remove("clicked");
            });
            gu.classList.add("clicked");
            guSelectBtn.textContent = gu.textContent;
        }

        guInput.value = gu.textContent;
    });
});

guSelectBtn.addEventListener("click", () => {
    // 구 선택창 닫혀있었다면
    if (guWrap.style.display !== "block") {
        $("#gu-wrap").slideDown("fast");
    }
    // 구 선택창 열려있었다면
    else {
        $("#gu-wrap").slideUp("fast");
    }

    // 지역선택 클릭되어 있었고
    // 글자가 "지역선택" 이라면
    if (guSelectBtn.classList.contains("clicked") && guSelectBtn.textContent == "지역선택") {
        guSelectBtn.classList.remove("clicked");
    }
        // 지역선택 클릭되어 있지 않았거나
    // 글자가 "~~구" 라면
    else {
        guSelectBtn.classList.add("clicked");
    }
});

$(document).click(function (e) {
    if (e.target.className == "gu-select-btn") {
        return false;
    } else if (e.target.className == "gu-select-btn clicked") {
        return false;
    } else if (e.target.className == "gu") {
        return false;
    } else if (e.target.className == "gu clicked") {
        return false;
    }

    $("#gu-wrap").slideUp("fast");

    if (guSelectBtn.textContent == "지역선택") {
        guSelectBtn.classList.remove("clicked");
    } else {
        guSelectBtn.classList.add("clicked");
    }
});
