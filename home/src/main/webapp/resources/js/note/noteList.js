/**
 * 
 */
$(function(){
	
	$("#toWrite").click(function(){
		location.href="/home/note/writeNoteView";
	});
	//getPaging();
	
	getNoteList();
	
	/*$("table td").on("click", function(){
		var sn = $(this td).
	});*/

	
});

//페이지 네비게이션 바 출력
function getPaging(){
	
	$.ajax({
		url : "getPaging",
		type : "get",
		/* data : {page : count, code : code}, */
		dataType : "json",
		
		success : function(data){
			console.log("getPaging : success");
			/* var result = "";
			
			if(data.length > 0){
				for(var i in data){
					result += data[i].sn + "<br>";
					result += data[i].title + "<br>";
					result += data[i].contents + "<br>";
				}
				
			}else{
				result = "<h3>불러올 글이 없습니다!</h3>";
			}
			
			$("#main").html(result); */
		},
		error : function(e){
			console.log("getPaging : error");
		},
		complete : function(e){
			$("#loading img").css('display', 'none');
		}	
		
	});
}

//테이블 목록 생성 
function getNoteList(){
	
	var page = 1;
	
	$.ajax({
		url : "getNoteList",
		type : "get",
		/* data : {page : count, code : code}, */
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
		}		
	});
}