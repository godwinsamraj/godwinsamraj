var cu=false;
var ce=false;
function handleClick(){
    var gender=false;
    var drugs=false;
    var username=document.getElementById("username").value;
    var name=document.getElementById("name").value;
    var age=document.getElementById("age").value;
    var radio_1=document.querySelector('input[name="gender"]:checked');
    var radio_2=document.querySelector('input[name="drugs"]:checked');
    var city=document.getElementById("city").value;
    var district=document.getElementById("district").value;
    var pincode=document.getElementById("pincode").value;
    var phone=document.getElementById("phone").value;
    var bloodgroup=document.getElementById("bloodgroup").value;
    var email=document.getElementById("email").value;
    var password=document.getElementById("password").value;
    if(username==='')
        alert("fill username");
    else if(cu)
        alert("username unavailable");
    else if(name==='')
        alert("fill name");
    else if(age==='')
        alert("fill age");
    else if(radio_1===null)
        alert("fill gender");
    else if(radio_2===null)
        alert("fill drugs");
    else if(city==='')
        alert("fill city");
    else if(district==='')
        alert("fill district");
    else if(pincode==='')
        alert("fill pincode");
    else if(phone==='')
        alert("fill phone");
    else if(bloodgroup==='')
        alert("fill bloodgroup");
    else if(email==='')
        alert("fill email");
    else if(ce)
        alert("email unavailable");
    else if(password==='')
        alert("fill password");
    else{
        if(radio_1.value==="Male") gender=true;
        if(radio_2.value==="Yes") drugs=true;
        const donar={username,name,age,gender,drugs,city,district,
        pincode,phone,bloodgroup,email,password}
        console.log(donar);
        fetch("http://localhost:8080/api/v1/donar/add",{method:"POST",
        headers:{"Content-Type":"application/json"},
        body:JSON.stringify(donar)})
        .then(()=>{console.log("New Donar Added")})
        window.location="Login.html";
    }
}
function checkUsername(){
    var username=document.getElementById("username").value;
    fetch("http://localhost:8080/api/v1/donar/username/"+username,{method:"POST"})
    .then((data)=>{return data.json()})
    .then((evt)=>{if(evt){document.getElementById("username").style.border="3px solid red";cu=true}else{document.getElementById("username").style.border="";cu=false}})
}
function checkEmail(){
    var email=document.getElementById("email").value;
    fetch("http://localhost:8080/api/v1/donar/email/"+email,{method:"POST"})
    .then((data)=>{return data.json()})
    .then((evt)=>{if(evt){document.getElementById("email").style.border="3px solid red";ce=true}else{document.getElementById("email").style.border="";ce=false}})
}