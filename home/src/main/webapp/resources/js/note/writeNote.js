/**
 * 
 */
$(function(){
	CKEDITOR.replace( 'contents' );
    CKEDITOR.config.height = 500;
	
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