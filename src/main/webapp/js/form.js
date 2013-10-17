$(document).ready(function()
    {

        var options = {
        beforeSend: function()
        {
        $("#progress").show();
        //clear everything
        $("#bar").width('0%');
        $("#message").html("");
        $("#percent").html("0%");
        },
uploadProgress: function(event, position, total, percentComplete)
            {
                $("#bar").width(percentComplete+'%');
                $("#percent").html(percentComplete+'%');

                },
success: function()
            {
                $("#bar").width('100%');
                $("#percent").html('100%');

                },
complete: function(response)
            {

                $("#message").html("<font color='green'>Salary Slips Generated for <br>" +response.responseText+"</font>");
            },
error: function()
            {
                $("#message").html("<font color='red'> ERROR: unable to upload files</font>");

                }

};

$("#myForm").ajaxForm(options);

});
                                                          \
function sendEmail(){
	$("#message").html("Emailing all Salary Slips..")
    $.ajax({
        url:"email"
    }).done(function(message){
           $("#message").html("<b>" +message+ "</b>")
        });
}