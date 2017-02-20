/*
 * Thread JS FUNCTION
 */
$(document).ready(function($) {
    
    $("#commentEntryForm").submit(function(event) {
        event.preventDefault();
        
        // Form validation use jquery validation plugin
        javascript: $("#commentEntryForm").validationEngine('attach');
        if (!$("#commentEntryForm").validationEngine('validate')) {
            return;
        }
        
        var data    = {},
            url = "comment/create";
            data["firstName"]           = $("#firstName").val();
            data["firstName"]           = $("#firstName").val();
            data["username"]            = $("#username").val();
            data["password"]            = $("#password").val();
            data["commentDescription"]  = $("#commentDescription").val();
            data["createUser"]          = $("#username").val();
            data["commentTitle"]        = $("#commentTitle").val();
            data["threadId"]            = $("#threadId").val();
        
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
                location.href = window.location;
                document.getElementById("commentEntryForm").reset()
                $.notify(message, "success");
            },
            error      : function(e) {
                console.log("ERROR: ",e);
                $.notify("Unable to Post Comment", "error");
            }
        });
        
    });
});