$(document).ready(function() {
    $('table').on('click', 'button[id="edit"]', function(e) {
        var id = $(this).closest('tr').children('td:first').text();
        var name = $(this).closest('tr').children('td:nth-child(2)').text();
        var age = $(this).closest('tr').children('td:nth-child(3)').text();
        var login = $(this).closest('tr').children('td:nth-child(4)').text();
        var password = $(this).closest('tr').children('td:nth-child(5)').text();
        $("#idChange").val(id);
        $("#nameChange").val(name);
        $("#ageChange").val(age);
        $("#loginChange").val(login);
        $("#passwordChange").val(password);
        $('#save').click(function () {
            $.ajax ({
                type : "POST",
                url: "/changeUser",
                data: {
                    idChange : $("#idChange").val(),
                    nameChange : $("#nameChange").val(),
                    ageChange: $("#ageChange").val(),
                    loginChange: $("#loginChange").val(),
                    passwordChange: $("#passwordChange").val(),
                },
                success: function(html){
                    location.reload();
                }
            });
        });
    });
    $('table').on('click', 'button[id="delete"]', function (e){
        var id = $(this).closest('tr').children('td:first').text();
        $.ajax ({
            type: "GET",
            url: "/removeUser/" + id,
            success: function(html){
                $("#container").html(html);
            }
        })
    });
});