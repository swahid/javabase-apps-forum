
/*
 * Comments JS function
 */
$(document).ready(function($) {
    $("#commentBox").submit(function(event) {
        
        event.preventDefault();
        
        // Form validation use jquery validation plugin
        javascript: $("#commentBox").validationEngine('attach');
        if (!$("#commentBox").validationEngine('validate')) {
            return;
        }
        var data    = {},
            url = "comment/new";
            data["commentTitle"]        = $("#commentTitle").val();
            data["commentDescription"]  = $("#commentDescription").val();
            data["createUser"]          = $("#createUser").val();
            data["contentId"]          = $("#contentId").val();
            data["createDate"]          = new Date();
        
        var token = $('#csrfToken').val();
        var header = $('#csrfHeader').val();
        
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
                document.getElementById("commentBox").reset()
            },
            error      : function(e) {
                console.log("ERROR: ",e);
                error("registration falied");
            }
        });
        
    });
    
});
function descriptionLength() {
    var total = 299;
    var val = $("#commentDescription").val();

    var count = val.length;
    document.getElementById('remaining').innerHTML = total - count;
}