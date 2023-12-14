const $nicknameChangeBtn = document.querySelector(".nickname-change-btn");
const $nicknameChangeCompleteBtn = document.querySelector(".nickname-change-complete");
const $nickname = document.querySelector(".nickname");
const $nicknameInput = document.querySelector(".nickname-change-input");
const $completeBtn = document.querySelector(".nickname-change-complete");

const $changePwBtn = document.querySelector(".mypage-content-content > .change-password-btn");
const $changePwCompleteBtn = document.querySelector(".change-pw-complete");
const $changePwWrap = document.querySelector(".change-pw-wrap");

const $changePicBtn = document.querySelector(".picture-change-btn");

const $dropUser = document.querySelector(".drop-user");

const $body = document.querySelector("body");

// 닉네임 변경
const clickNickNameChangeBtn = () => {
    $nickname.style.display = `none`;
    $nicknameChangeBtn.style.display = `none`;
    $completeBtn.style.display = `block`;
    $nicknameInput.style.display = `block`;
};

const clickNickNameChangeCompleteBtn = () => {
    $nickname.style.display = `block`;
    $nicknameChangeBtn.style.display = `block`;
    $completeBtn.style.display = `none`;
    $nicknameInput.style.display = `none`;

    $nickname.innerHTML = $nicknameInput.value;
    $nicknameInput.placeholder = $nicknameInput.value;

    alert("닉네임 변경 완료");
};

// 비밀번호 변경
const clickPasswordChangeBtn = () => {
    console.log("비밀번호 변경");
    $changePwBtn.style.display = `none`;
    $changePwWrap.style.display = `block`;
};

const clickPasswordChangeCompleteBtn = () => {
    $changePwBtn.style.display = `block`;
    $changePwWrap.style.display = `none`;

    alert("비밀번호 변경 완료");
};

// 프사 변경
const clickChangePicBtn = () => {
    alert("프사 변경하기!!");
};

// 회원 탈퇴
const clickDropUserBtn = () => {
    const realDrop = confirm("정말 탈퇴하시겠습니까?");
    if (realDrop) {
        $modal.style.visibility = `visible`;
        $body.style.overflow = "hidden";
    }
};

$nicknameChangeBtn.addEventListener("click", clickNickNameChangeBtn);
$nicknameChangeCompleteBtn.addEventListener("click", clickNickNameChangeCompleteBtn);

$changePwBtn.addEventListener("click", clickPasswordChangeBtn);
$changePwCompleteBtn.addEventListener("click", clickPasswordChangeCompleteBtn);

$changePicBtn.addEventListener("click", clickChangePicBtn);

$dropUser.addEventListener("click", clickDropUserBtn);
