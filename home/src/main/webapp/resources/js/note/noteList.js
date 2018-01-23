/**
 * 
 */
$(function(){
	
	getNoteList(1);
	
	$("#toWrite").click(function(){
		location.href="/home/note/writeNoteView";
	});
		
	$("li").click(function(e){
		var page = $(this).text();
		console.log("clicked " + page);
		getNoteList(page);
	});
	
	
	/*$("table td").on("click", function(){
		var sn = $(this td).
	});*/

	
});

//테이블 목록 생성 
function getNoteList(page){
	
	var param = {"curPage" : page};
	
	$.ajax({
		url : "getNoteList",
		type : "get",
		data : param,
		dataType : "json",
		beforeSend : function(){
			$("#loading img").css("display", "inline-block");
		}, 
		success : function(data){
			console.log("getNoteList : success");
			var result = "";
			
			if(data.length > 0){
				for(var i in data){
					result += "<tr><td><a href='readNote?sn=" + data[i].sn + "'>" + data[i].sn + "</a></td>";
					result += "<td>" + data[i].title + "</td>";
					result += "<td>" + data[i].insertDt + "</td></tr>";
				}
			}else{
				result = "<tr><td colspan='3'>불러올 글이 없습니다.</td></tr>";
			}
			
			$("#head").after(result); 
		},
		error : function(e){
			console.log("getNoteList :error");
		},
		complete : function(e){
			$("#loading img").css("display", "none");
			setPagingNav(curPage);
		}		
	});
}

//하단 페이징 네비게이션 세팅
function setPagingNav(curPage){
	
	//var curPage = $("#curPage").val();
	var curBlock = $("#curBlock").val();
	var lastPage = $("#lastPage").val();
	var firstPage = $("#firstPage").val();
	var totalBlockNum = $("#totalBlockNum").val();
	
	if(curBlock <= 1)
		$("#prevBtn").attr("class", "disabled");
		
	if(curBlock => totalBlockNum)
		$("#nextBtn").attr("class", "disabled");
	
	
	$("li").each(function(index, item){
		$(item).removeClass("active");
		
		var text = $(item).text();
		if(text == curPage){
			$(item).attr("class", "active");
			/*console.log("got it!");
			console.log(text);*/
		}
		//console.log($(item).text());
	});
	//$("li:eq(" + curPage  + ")").attr("class", "active");
	
	//curPage active
	
}