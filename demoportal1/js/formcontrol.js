


$(document).ready(function () {
    //variables
    //Functions
    loading();

    var retSuccess = "success";

    function loading() {
        var query = window.location.search.substring(1);
        var variables = query.split("=");
        id = variables[1];
        getAfiliate(id);
    }

    function getAfiliate(id) {
        if (!isUndefinedOrNull(id)) {
            $.get("http://localhost:8080/afiliates/" + id, function (data, status) {
                var afiliate = data;
                if (!isUndefinedOrNull(afiliate)){
                    setInformation(afiliate);
                    var btnSave = document.getElementById("btnAdd");
                    btnSave.innerHTML = "Save";
                    var txtTittle = document.getElementById("title");
                    txtTittle.innerHTML = "Update Afiliate";
                }
                
            });
        }
    }

    function putAfiliate(afiliate) {

        $.ajax({
            url: 'http://localhost:8080/afiliates',
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            success: function (data) {
                setInformation(data);
                alert("save successfull");
                window.location = './../index.html';
            },
            data: JSON.stringify(afiliate)
        });
    }

    function isUndefinedOrNull(a) {
        if (typeof a === 'undefined') {
            return true;
        } else if (a === null) {
            return true;
        } else if (a === "") {
            return true;
        }
        return false;
    }

    function getInformation() {
        var id = $('#txtId').val();
        if (isUndefinedOrNull(id)) {
            id = "0";
        }
        var afiliate = {
            idNumber: id,
            name: $('#txtNombre').val(),
            lastName: $('#txtApellido').val(),
            phoneNumber: $('#txtTelefono').val(),
            email: $('#txtEmail').val(),
            address: $('#txtDireccion').val(),
            state: $('#selEstado').val()
        }
        return afiliate;
    }

    function setInformation(afiliate) {
        $('#txtId').val(afiliate.idNumber);
        $('#txtNombre').val(afiliate.name);
        $('#txtApellido').val(afiliate.lastName);
        $('#txtTelefono').val(afiliate.phoneNumber);
        $('#txtEmail').val(afiliate.email);
        $('#txtDireccion').val(afiliate.address);
        $('#selEstado').val(afiliate.state);
    }

    function goHome() {
        window.location.href = "./../index.html";
    }

    //buttones
    $('#btnAdd').click(() => {
        var afiliate = getInformation();
        putAfiliate(afiliate);
    });
    $('#btnCancel').click(() => {
        goHome();
    });
    $('#btnHome').click(() => {
        goHome();
    });
});