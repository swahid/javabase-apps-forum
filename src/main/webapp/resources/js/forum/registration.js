/*
 * REGISTRATION  JS FUNCTION
 */
$(document).ready(function($) {
    $("#registerForm").submit(function(event) {
        event.preventDefault();
        
        // Form validation use jquery validation plugin
        /*javascript: $("#registerForm").validationEngine('attach');
        if (!$("#registerForm").validationEngine('validate')) {
            return;
        }*/
        var data    = {},
            url = "registration";
            data["firstName"]   = $("#firstName").val();
            data["lastName"]    = $("#lastName").val();
            data["userEmail"]   = $("#email").val();
            data["username"]    = $("#username").val();
            data["password"]    = $("#password").val();
        
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
                $("#success").show();
                document.getElementById("registerForm").reset()
            },
            error      : function(e) {
                console.log("ERROR: ",e);
                $("#error").show();
            }
        });
        
    });
});