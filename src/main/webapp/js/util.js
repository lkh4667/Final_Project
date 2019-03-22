
/**
 * 로딩 이미지 생성
 * 
 * @returns
 */
function wrapWindowByMask() {

	var platform = fn_chkPlatform();

	// 화면의 높이와 너비를 구한다.
	var maskHeight = $(document).height();
	// var maskWidth = $(document).width();
	var maskWidth = window.document.body.clientWidth;

	var mask = "<div id='mask' style='position:absolute;width:100%;height:100%;z-index:9000;background-color:#000000;display:none;left:0; top:0;'></div>";
	var loadingImg = '';
	loadingImg += "<div id='loadingImg'style='position:absolute;top:50%;width:100%;height:100%;display:none; z-index:10000;text-align:center;'>";
	loadingImg += "   <img src='images/squares.gif' style='vertical-align:middle; margin-top:100px; margin-bottom:100px; padiing:100px;'/>";
	loadingImg += "</div>";

	// 화면에 레이어 추가
	$('body').append(mask).append(loadingImg)

	// 마스크의 높이와 너비를 화면 것으로 만들어 전체 화면을 채운다.
	$('#mask').css({
		'width' : maskWidth,
		'height' : maskHeight,
		'opacity' : '0.3'
	});

	// 마스크 표시
	$('#mask').show();

	// 로딩중 이미지 표시
	$('#loadingImg').show();
}

/**
 * 플랫폼 체크 (모바일/pc)
 * 
 * @returns
 */
function fn_chkPlatform() {
	var filter = "win16|win32|win64|mac";
	if (navigator.platform) {
		if (0 > filter.indexOf(navigator.platform.toLowerCase())) {
			return "Mobile";
		} else {
			return "PC";
		}
	}
}

/**
 * 로딩 이미지 제거
 * 
 * @returns
 */
function closeWindowByMask() {
	$('#mask, #loadingImg').hide();
	$('#mask, #loadingImg').remove();
}
