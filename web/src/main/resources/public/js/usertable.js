//TO DO: Make update.

$(document).ready(show());

$('#userAdd').click(function () {
    addUser();
});

$('#deleteAll').click(function () {
    deleteAll();
});

$('#uemail').change('value', function () {
        validate();
    }
);

$("#myselect option:selected").text();

function show() {
    $('#tablecont').html("");
    $.ajax({
        url: "restful/user/",
        type: 'GET',
        success: function (data) {
            data.sort(function mycomparator(a, b) {
                return a.userId - b.userId;
            });

            for (var index in data) {
                var tr = $('<tr>');
                var tdId = $('<td>').text(data[index].userId);
                var tdfName = $('<td>').text(data[index].firstName).attr("class", "small");
                var tdlName = $('<td>').text(data[index].lastName).attr("class", "small");
                var tdbDate = $('<td>').text(new Date(data[index].birthDate).toLocaleDateString(['ban', 'id']))
                    .attr("class", "small");
                var tdEmail = $('<td>').text(data[index].email).attr("class", "small");
                var tdPhoneN = $('<td>').text(data[index].phoneNumber).attr("class", "small");
                var tdPass = $('<td>').text(data[index].password).attr("class", "small");
                var tdGender = $('<td>').text(data[index].gender).attr("class", "small");
                var Editbutton = $('<button>')
                    .attr("class", "btn btn-success btn-sm")
                    .text("Edit").attr("bid", data[index].userId.toString())
                var DeleteButton = $('<button>')
                    .attr("class", "btn btn-warning btn-sm")
                    .text("Delete").attr("bid", data[index].userId.toString())
                    .attr('id', data[index].userId)
                    .click(deleteUserById);
                var tdEButton = $('<td>').append(Editbutton);
                var tdDButton = $('<td>').append(DeleteButton);

                tr.append(tdId).append(tdfName).append(tdlName).append(tdbDate).append(tdPhoneN)
                    .append(tdEmail).append(tdPass).append(tdGender).append(tdEButton).append(tdDButton);
                $('#tablecont').append(tr);
            }
        }
    })
};

function deleteUserById() {
    $.ajax({
        url: "restful/user/" + $(this).attr('id'),
        type: 'DELETE',
    })
    show();
};

function deleteAll() {
    $.ajax({
        url: "restful/user",
        type: 'DELETE',
        success: function () {
            console.log("Deleted all Users");
            show();
        }
    });
}

function addUser() {
    if (($('#firstNameId').val().length > 0) && (validate())) {
        var json = {
            "firstName": $('#firstNameId').val(),
            "lastName": $('#lastName').val(),
            "birthDate": $('#udate').val(),
            "email": $('#uemail').val(),
            "phoneNumber": $('#uNumber').val(),
            "password": $('#upassword').val(),
            "gender": $('#uGender').val(),
        };

        $.ajax({
            url: "restful/user/",
            type: 'POST',
            data: JSON.stringify(json),
            contentType: "application/json",
            success: function () {
                console.log("OK");
                show();
            }
        });
    }
}

function validate() {
    $("#result").text("");
    var email = $("#uemail").val();

    if (validateEmail(email)) {
        console.log(email + " is valid :)");
        $("#uemail").css("border-color", "green");
        return true;
    } else {
        console.log(email + " is not valid :(");
        $("#uemail").css("border-color", "red");
    }   return false;
}

function validateEmail(email) {
    var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}