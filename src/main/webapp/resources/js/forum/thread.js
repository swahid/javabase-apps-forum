/*
 * Thread JS FUNCTION
 */
$(document).ready(function($) {
    
    $("#threadCreateForm").submit(function(event) {
        event.preventDefault();
        
        // Form validation use jquery validation plugin
        javascript: $("#threadCreateForm").validationEngine('attach');
        if (!$("#threadCreateForm").validationEngine('validate')) {
            return;
        }
        var data    = {},
            url = "create";
            data["threadTitle"]         = $("#threadTitle").val();
            data["threadDescription"]   = $("#threadDescription").val();
            data["createUser"]          = $("#loginUserName").val();
            data["topicId"]             = $("#topic option:selected").val().trim();
            data["topicName"]           = $("#topic option:selected").text().trim();
            data["userId"]              = $("#loginUserId").val();
        
        var token     = $('#csrfToken').val();
        var header    = $('#csrfHeader').val();
        
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
//                location.href = resonse.url;
                document.getElementById("threadCreateForm").reset()
                $.notify(message, "success");
            },
            error      : function(e) {
                console.log("ERROR: ",e);
                $.notify("unable to Create Thread ", "error");
            }
        });
        
    });
});