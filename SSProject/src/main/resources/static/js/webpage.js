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

 
  let text = "<style>";
  text += "table, th, td,tr {";
  text += "border: 1px solid black;";
  text += "border-width: thin;";
  text += "}";
  text += "</style>";

 text += "<table border='1' width='300' height='100' border-width='thin'>";
  for (let x in myObj) {
    text += "<tr><td>" + myObj[x].teamId + "</td>";
    text += "<td>" + myObj[x].teamName + "</td>";
    text += "<td>" + myObj[x].fundGoal + "</td>";
    text += "<td>" + myObj[x].cycle + "</td>";
    text += "<td>" + myObj[x].users + "</td><td><button type='button' onclick='deleteteam("+myObj[x].teamId+")'>Delete</button></td></tr>";
  }
  text += "</table>"    
  document.getElementById("teamtab").innerHTML = text;
}

  }
  xmlhttp.open("GET", "/teaminfo", true);
xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xmlhttp.send();
  };

function loaduser() {
   
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

 
  let text = "<style>";
  text += "table, th, td,tr {";
  text += "border: 1px solid black;";
  text += "border-width: thin;";
  text += "}";
  text += "</style>";

 text += "<table border='1' width='300' height='100' border-width='thin'>";
  for (let x in myObj) {
    text += "<tr><td>" + myObj[x].userId + "</td>";
    text += "<td>" + myObj[x].userName + "</td>";
    text += "<td>" + myObj[x].phoneNo + "</td>";
    text += "<td>" + myObj[x].email + "</td><td><button type='button' onclick='deleteuser("+myObj[x].userId+")'>Delete</button></td></tr>";
  }
  text += "</table>"    
  document.getElementById("teamtab").innerHTML = text;
}

  }
  xmlhttp.open("GET", "/userinfo", true);
xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xmlhttp.send();
  };

  function deleteteam( teamId) {
   
    console.log("workindelete");
     var xmlhttp = new XMLHttpRequest();
     xmlhttp.onreadystatechange = function() {
      if (this.readyState == 4 && this.status == 200) {

    console.log("delete button working "+teamId);
  const myObj = JSON.parse(this.responseText);

}

  }
  xmlhttp.open("DELETE", "/teamsdelete/"+teamId, true);
xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xmlhttp.send();
  };
  function adduser( userId) {
    window.location.href="/adduser";
  };