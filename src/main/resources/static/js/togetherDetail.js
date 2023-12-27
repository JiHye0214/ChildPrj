// 상세 valid

const detailText = document.querySelectorAll("#txt-list-content > p");

for(e of detailText){
    if(e.innerText == ""){
        e.innerText = "-";
    }
}

// ----------------------------------------------
// 찜 버튼

const heartBtn = document.querySelector("#heart");
const zzimForm = document.querySelector("#zzimBtn");
const isZzimClicked = document.querySelector("#isZzimClicked");
const logged = document.querySelector("#logged");

if (isZzimClicked.value == "true") {
    heartBtn.style.fill = "rgb(255, 80, 80)";
} else {
    heartBtn.style.fill = "#fff";
}

heartBtn.addEventListener("click", () => {
    console.log(logged.value);

    if (logged.value) {
        zzimForm.submit();
    } else {
        location.href = "/user/logIn";
    }
});

// ----------------------------------------------
// 지도

const lot = document.querySelector("#LOT");
const lat = document.querySelector("#LAT");

// console.log("위도 : ", lot.value);
// console.log("경도 : ", lat.value);

var container = document.getElementById('map-wrap'),
		options = {
			center: new kakao.maps.LatLng(lat.value, lot.value),
			level: 3 //지도의 레벨(확대, 축소 정도)
		};

var map = new kakao.maps.Map(container, options);
var imageSrc = 'https://ifh.cc/g/oxMhdm.png', // 이미지 파일의 상대 경로 // 이미지 파일의 상대 경로
 // 마커이미지의 주소입니다
    imageSize = new kakao.maps.Size(53, 55), // 마커이미지의 크기입니다
    imageOption = {offset: new kakao.maps.Point(27, 69)}; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption),
    markerPosition = new kakao.maps.LatLng(lat.value, lot.value); // 마커가 표시될 위치입니다

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition,
    image: markerImage // 마커이미지 설정
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);







