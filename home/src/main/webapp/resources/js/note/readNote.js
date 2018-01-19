/**
 * 
 */
$(function(){
	
	
	//getNote();
});

function getNote(){
	
	var sn = $("#sn").val();
	console.log(sn);
	$.ajax({
		url : "readNote",
		type : "post",
		data : {sn : sn},
		dataType : "json",
		/* beforeSend : function(){
			$(".when_load_data").css('display', 'block');
		}, */
		success : function(data){
			console.log("readNote : success");
			var result = "";
			
			if(data.length > 0){
				for(var i in data){
					result += data[i].sn + "<br>";
					result += data[i].title + "<br>";
					result += data[i].contents + "<br>";
					result += data[i].insertDt + "<br>";
				}
			}else{
				//result = "<tr><td colspan='3'>불러올 글이 없습니다.</td></tr>";
			}
			
			$("#head").after(result); 
		},
		error : function(e){
			console.log("readNote :error");
		}		
	});
}