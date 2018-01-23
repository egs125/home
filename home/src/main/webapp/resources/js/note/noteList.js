/**
 * 
 */
$(function(){
	
	getNoteList(1);
	
	$("#toWrite").click(function(){
		location.href="/home/note/writeNoteView";
	});
			
	$("ul").children("li").on("click", function(e){
		console.log(this);
		/*var page = $(this).children("a").text().trim();
		console.log("clicked " + page);*/
		//getNoteList(page);
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
			
			$("tbody").html(result); 
		},
		error : function(e){
			console.log("getNoteList :error");
		},
		complete : function(e){
			$("#loading img").css("display", "none");
			setPagingNav(page);
		}		
	});
}

//하단 페이징 네비게이션 세팅
function setPagingNav(page){
	
	var param = {"curPage" : page};
	
	$.ajax({
		url : "setPaging",
		type : "get",
		data : param,
		dataType : "json", 
		success : function(data){
			console.log("setPaging : success");
			console.log(data.lastPage);
			var result = '<li id="prevBtn"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>';
			for(var i = data.firstPage; i < data.lastPage; i++){	
				result += '<li onclick="getNoteList(' + i + ')"><a href="#">' + i + '</a></li>'; 	
			}
			result += '<li id="nextBtn"><a href="#" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>';
			
			$(".pagination").html(result); 
			
			if(data.curBlock <= 1)
				$("#prevBtn").attr("class", "disabled");
			
			if(data.totalBlockNum <= data.curBlock)
				$("#nextBtn").attr("class", "disabled");
			
			$("li").each(function(index, item){
				$(item).removeClass("active");
				
				var text = $(item).text().trim();
				if(text == data.curPage)
					$(item).attr("class", "active");
			});
			
		},
		error : function(e){
			console.log("setPaging :error");
		}
	});	
}