/**
 * 
 */
$(function(){
	
	getNoteList(1);
	
	$("#toWrite").click(function(){
		location.href="/home/note/writeNoteView";
	});
	
	$("li").on("click", function(e){
		var page = $(this).text().trim();
		var curBlock = parseInt($("#curBlock").val());
		var curPage = parseInt($("#curPage").val());
		
		var prevClass = $("#prevBtn").hasClass("disabled");
		var nextClass = $("#nextBtn").hasClass("disabled");

		var mod = curPage % 5;	
		if(mod == 0) mod = 5;

		if(page == "«" && prevClass != true){
			page = curPage - mod;	
		}else if(page == "«" && prevClass == true){
			return;
		}else if(page == "»" && nextClass != true){
			page = (curPage + 5 - mod) + 1;
		}else if(page == "»" && nextClass == true){
			return;
		}
		
		getNoteList(page);
	});
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
					result += "<tr><td>" + data[i].sn + "</td>";
					result += "<td><a href='readNote?sn=" + data[i].sn + "'>" + data[i].title + "</a></td>";
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
			
			$("#curBlock").val(data.curBlock);
			$("#curPage").val(data.curPage);
			var index = data.lastPage - data.firstPage + 1;
			
			for(var i = 1; i < 6; i++) {
				var pageNo = data.firstPage;
				$("li:eq(" + i + ")").removeClass("active");
				
				for(var j = 1; j <= index; j++){
					if(i == j) {
						$("li:eq(" + j + ")").attr("style", "dislpay:inline-block");
						$("li:eq(" + j + ")").html('<a href="#">' + pageNo + '</a>');						
					}
					++pageNo;
				}
			}
			
			if(data.curBlock <= 1) $("#prevBtn").attr("class", "disabled");	
			if(data.totalBlockNum <= data.curBlock) $("#nextBtn").attr("class", "disabled");
			
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
