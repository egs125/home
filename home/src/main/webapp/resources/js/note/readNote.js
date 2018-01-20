/**
 * 
 */
$(function(){
	
	$("#toWrite").click(function(){
		console.log("updateNote");
		updateNoteView();
	})
	
});

function updateNoteView(){

	var sn =  $("#sn").val();
	console.log(sn);
	$.ajax({
		url  : "writeNoteView",
		type : "post",
		data : {sn : sn},
		dataType : "json",
		success : function(data){
			console.log("updateNoteView :success");
		},
		error : function(e){
			console.log("updateNoteView :error");
		}		
	});
}