/**
 * 
 */
$(function(){
	
	$("#toWrite").click(function(){
		console.log("updateNote");
		updateNoteView();
	});
	
	$("#delBtn").click(function(){
		deleteNote();
	});
	
});

function updateNoteView(){

	var choice = confirm("Want to revise this note?");
	
	if(choice){
		var form = document.createElement("form");
		var el = document.createElement("input");
		
		form.method = "POST";
		form.action = "updateNoteView";
		
		el.value = $("#sn").val();
		el.name = "sn";
		
		form.appendChild(el);
		document.body.appendChild(form);
		form.submit();
	}else{
		return;
	}
	
}

function deleteNote(){
	
	var choice = confirm("Are you sure to delete this note?");
	
	if(choice) {
		var form = document.createElement("form");
		var el = document.createElement("input");
		
		form.method = "POST";
		form.action = "deleteNote";
		
		el.value = $("#sn").val();
		el.name = "sn";
		
		form.appendChild(el);
		document.body.appendChild(form);
		form.submit();
	}else{
		return;
	}
	
}
