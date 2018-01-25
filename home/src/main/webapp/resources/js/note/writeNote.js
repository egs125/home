/**
 * 
 */
$(function(){
	CKEDITOR.replace( 'contents', {
		width : '100%',
		height : '500px',
		filebrowserImageUploadUrl : '/home/ckeditor/upload.jsp?'
			+ 'realUrl=localhost:8080/home/' + '&realDir=resources/uploadImg'
	} );
    //CKEDITOR.config.height = 500;
	
	CKEDITOR.on('dialogDefinition', function( ev ){
        var dialogName = ev.data.name;
        var dialogDefinition = ev.data.definition;
      
        switch (dialogName) {
            case 'image': //Image Properties dialog
                //dialogDefinition.removeContents('info');
                dialogDefinition.removeContents('Link');
                dialogDefinition.removeContents('advanced');
                break;
        }
    });
	
    $("#writeBtn").on("click", function(){
    	
    	 var params = {
              title : $("#title").val(),
              contents : CKEDITOR.instances.contents.getData()
         };
          
         //ajax 호출
         $.ajax({
             url         :   "writeNote",
             type        :   "post",
             data        :   params,
             success     :   function(data){ 
            	 alert(data); 
            	 location.href = "/home/note/noteListView";
             },
             error       :   function(data){
            	 alert(data); 
                 console.log("AJAX_ERROR");
             }
         });
          
    });
    
});