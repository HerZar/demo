//Functions
var listAfill;

function getAll() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      //document.getElementById("listado").innerHTML =
      listAfill = this.responseText;
      var arrayList = JSON.parse(listAfill)
      var listView = document.getElementById("listAfiliates");
      listView.innerHTML="";
      listView.innerHTML="<tr><th>Firstname</th><th>Lastname</th><th>Address</th></tr>";
        for ( i = 0; i< arrayList.length; i++){            
            listView.innerHTML +=
            "<tr><td>"+arrayList[i].name+"</td><td>"+arrayList[i].lastName+"</td><td>"+arrayList[i].address+"</td></tr> ";
        }
    }
  }  
  xhttp.open("GET", "http://localhost:8080/afiliates", true);
  xhttp.send();
}

function inventar() {
    fetch('http://localhost:8080/afiliates/inventar')
        .then(function(response) {
            return response.json();
        })
        .then(function(data) {
            console.log('data = ', data);
        })
        .catch(function(err) {
            console.error(err);
        });
}

//buttons
{
    $('#btnListar').click(()=>{
        getAll();            
    });
}