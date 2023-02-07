function handleClick(){
    var username=document.getElementById("username").value;
    var password=document.getElementById("password").value;
    fetch("http://localhost:8080/api/v1/donar/loginDonar/"+username+"/"+password,{method:"POST"})
    .then((data)=>{return data.json()})
    .then((evt)=>{console.log(evt)})
}