function userhandle()
{   
        var password = document.getElementById  ("password");  
        var password2 = document.getElementById  ("password2");  

        if(password==password2)
        {
            let text = "success "    
            document.getElementById("error").innerHTML = text;
            console.log("workin1");
            var xmlhttp = new XMLHttpRequest();
            xmlhttp.onreadystatechange = function() {
             if (this.readyState == 4 && this.status == 200) {
   
           console.log("hello2");
         const myObj = JSON.parse(this.responseText);
    
         document.getElementById("").innerHTML = text;
       }
       
         }
         xmlhttp.open("POST", "/user", true);
       xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
       xmlhttp.send();
        }   
        else
        {
           let text = "Password do not match "    
            document.getElementById("error").innerHTML = text;
        }
}

// var phone = document.getElementById  ("phone");  
// var email = document.getElementById  ("email");  
// var username = document.getElementById  ("username");  