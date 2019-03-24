//전역변수
var obj = [];

$(function(){
	nhn.husky.EZCreator.createInIFrame({
	    oAppRef: obj,
	    elPlaceHolder: "cont_write",
	    sSkinURI: "../mybucket/resources/editor/SmartEditor2Skin.html",
	    htParams : {
            // 툴바 사용 여부
            bUseToolbar : true,            
            // 입력창 크기 조절바 사용 여부
            bUseVerticalResizer : true,    
            // 모드 탭(Editor | HTML | TEXT) 사용 여부
            bUseModeChanger : true,
        }

	})
});


