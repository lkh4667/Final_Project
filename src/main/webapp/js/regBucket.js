var oEditors = [];
$(function(){
	nhn.husky.EZCreator.createInIFrame({
	    oAppRef: oEditors,
	    elPlaceHolder: "bk_content",
	    sSkinURI: "../mybucket/static/sdk/nhn-se2/SmartEditor2Skin.html",
	    fCreator: "createSEditor2"
	 /*   fOnAppLoad : function(){
	    	//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
	    	oEditors.getById["bk_content"].exec("PASTE_HTML", ["view_content"]); 
	    }*/

	})
});


