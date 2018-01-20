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
             url         :   "/board/save",
             dataType    :   "json",
             contentType :   "application/x-www-form-urlencoded; charset=UTF-8",
             type        :   "post",
             data        :   params,
             success     :   function(retVal){

                 if(retVal.code == "OK") {
                     alert(retVal.message);
                     location.href = "/board/list";  
                 } else {
                     alert(retVal.message);
                 }
                  
             },
             error       :   function(request, status, error){
                 console.log("AJAX_ERROR");
             }
         });
          
    });
    
});