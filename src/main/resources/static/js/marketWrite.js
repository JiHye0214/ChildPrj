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



