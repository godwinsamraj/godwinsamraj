import React,{useState} from "react";
import styles from '../css/Login.module.css';

function Login(){
    const [name,setName]=useState('')
    const [password,setPassword]=useState('')
    const handleClick=(evt)=>{evt.preventDefault()
        if(name==='')alert("fill name");
        else if(password==='')alert("fill password");
        else{
            fetch("http://localhost:8080/api/v1/person/loginPerson/"+name+"/"+password,{method:"POST"})
            .then((data)=>{return data.json()})
            .then((evt)=>console.log(evt))
        }
    }
    return (
        <div className={styles.card}>
            <input type="text"placeholder="name or username" value={name} onChange={(evt)=>setName(evt.target.value)}></input>
            <input type="password" placeholder="password" value={password} onChange={(evt)=>setPassword(evt.target.value)}></input>
            <button onClick={handleClick}>LOGIN</button>
        </div>
    );
}

export default Login;