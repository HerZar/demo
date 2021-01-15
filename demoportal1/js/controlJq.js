$(document).ready(function () {
    //loadding
    getAll();
    //variables
    var listAfill;
    //Functions
    function getAll() {
        $.get("http://localhost:8080/afiliates", function (data, status) {
            var arrayList = data
            var listView = document.getElementById("listAfiliates");
            listView.innerHTML = "";

            if (!isUndefinedOrNull(arrayList)) {
                for (i = 0; i < arrayList.length; i++) {
                    listView.innerHTML +=
                        "<tr>" +
                        "<td>" + arrayList[i].idNumber + "</td>" +
                        "<td>" + arrayList[i].name + "</td>" +
                        "<td>" + arrayList[i].lastName + "</td>" +
                        "<td>" + arrayList[i].phoneNumber + "</td>" +
                        "<td>" + arrayList[i].email + "</td>" +
                        "<td>" + arrayList[i].address + "</td>" +
                        "<td>" + arrayList[i].state + "</td>" +
                        "<td><button id='btnDelete'  class='btn btn-default' onclick='btnDelete(" + arrayList[i].idNumber + ")'>Delete</button></td>" +
                        "<td><button id='btnUpdate'  class='btn btn-default' onclick='btnUpdate(" + arrayList[i].idNumber + ")'>Update</button></td>" +
                        "</tr>"
                }
            }
        });
    }

    function deleteAfiliated(id) {
        // Ajax method
        $.ajax({
            url: 'http://localhost:8080/afiliates/' + id,
            type: 'delete', 
            contentType: 'application/json',
            success: function (data) {
				getAll();
            },
            error: function(data) {
                console.error(data);
            }
        });


    }

    function inventar() {
        fetch('http://localhost:8080/afiliates/inventar')
            .then(function (response) {
            })
            .catch(function (err) {
                console.error(err);
            });
    }

    function isUndefinedOrNull(a) {
        if (typeof a === 'undefined') {
            return true;
        } else if (a === null) {
            return true;
        }
        return false;
    }

    function goAdd() {

        window.location.href = "./pages/form.html";

    }

    // this function is called from outside that is way it is definde in the window scope
    window.btnDelete = function btnDelete(id) {
        deleteAfiliated(id);

    }

    // this function is called from outside that is way it is definde in the window scope
    window.btnUpdate = function btnUpdate(id) {
        window.location = './pages/form.html?id=' + id;
    }

    $('#btnList').click(() => {
        getAll();
    });

    $('#btnInvent').click(() => {
        inventar();
    });

    $('#btnAdd').click(() => {
        goAdd();
    });


});