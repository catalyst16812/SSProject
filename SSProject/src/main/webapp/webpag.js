function loadDoc() {
   
    console.log("workin1");
     var xmlhttp = new XMLHttpRequest();
     xmlhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {
    //    $('#table').DataTable({
    //     ajax:{url : "/teaminfo",dataSrc : ""} 
    //    });
  

    //   }
    console.log("hello2");
  const myObj = JSON.parse(this.responseText);

  let text = "<table border='1' width='400' height='400' style = 'border-width:2';>"
        
  for (let x in myObj) {
    text += "<tr><td>" + myObj[x].teamId + "</td>";
    text += "<td>" + myObj[x].teamName + "</td>";
    text += "<td>" + myObj[x].fundGoal + "</td>";
    text += "<td>" + myObj[x].cycle + "</td></tr>";
  }
  text += "</table>"    
  document.getElementById("demo").innerHTML = text;
}

  }
  xmlhttp.open("GET", "/teaminfo", true);
xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xmlhttp.send();
  };
