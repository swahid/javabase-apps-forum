
/*
 * Content JS function
 */
$(document).ready(function($) {
    $("#contentForum").submit(function(event) {
        
        event.preventDefault();
        
        // Form validation use jquery validation plugin
        javascript: $("#contentForum").validationEngine('attach');
        if (!$("#contentForum").validationEngine('validate')) {
            return;
        }
        var data    = {},
            url = "new";
            data["contentTitle"]        = $("#contentTitle").val();
            data["topicId"]             = $("#category").val();
            data["contentDescription"]  = $("#contentDescription").val();
            data["createUser"]          = $("#createUser").val();
            data["createDate"]          = new Date();
        
        var token = $('#csrfToken').val();
        var header = $('#csrfHeader').val();
        console.log(data);
        console.log(token);
        console.log(header);
        
        /*
         * if in spring aplication csrf enable
         * send csrf parameter in header otherwise 405 error
         */
        $.ajax({
            type      : "POST",
            url       : url,
            data      : JSON.stringify(data),
            dataType  : 'json',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
                xhr.setRequestHeader(header, token);
            },
            success  : function(resonse) {
                var message = resonse.message;
                success(message);
                document.getElementById("contentForum").reset()
            },
            error      : function(e) {
                console.log("ERROR: ",e);
                error("registration falied");
            }
        });
        
    });
    
});
function descriptionLength() {
    var total = 499;
    var val = $("#contentDescription").val();

    var count = val.length;
    document.getElementById('remaining').innerHTML = total - count;
}