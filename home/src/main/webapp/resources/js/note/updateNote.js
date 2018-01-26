/**
 * 
 */
$(function(){
	CKEDITOR.replace( 'contents' );
    CKEDITOR.config.height = 500;
	
    $("#writeBtn").on("click", function(){
    	
    	 var params = {
    		  sn    : $("#sn").val(),
              title : $("#title").val(),
              contents : CKEDITOR.instances.contents.getData()
         };
 
         $.ajax({
             url         :   "updateNote",
             type        :   "post",
             data        :   params,
             dataType    : "json",
             success     :   function(data){ 
            	 alert(data);                
             },
             error       :   function(data){
            	 alert(data); 
                 console.log("AJAX_ERROR");
             }
         });
          
    });
    
});