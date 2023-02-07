import React,{useState} from "react";
import styles from '../css/Signin.module.css';

function Signin(){
    const [cn,setCn]=useState(false)
    const [ce,setCe]=useState(false)
    const [name,setName]=useState('')
    const [about,setAbout]=useState('')
    const [address,setAddress]=useState('')
    const [phone,setPhone]=useState('')
    const [email,setEmail]=useState('')
    const [password,setPassword]=useState('')
    const [skill_1,setSkill_1]=useState('')
    const [skill_2,setSkill_2]=useState('')
    const [skill_3,setSkill_3]=useState('')
    const [skill_4,setSkill_4]=useState('')
    const [tenth,setTenth]=useState('')
    const [twelth,setTwelth]=useState('')
    const [ug,setUg]=useState('')
    const [jt_1,setJt_1]=useState('')
    const [jt_1_ex,setJt_1_ex]=useState('')
    const [jt_2,setJt_2]=useState('')   
    const [jt_2_ex,setJt_2_ex]=useState('')
    const [jt_3,setJt_3]=useState('')
    const [jt_3_ex,setJt_3_ex]=useState('')
    const checkName=(evt)=>{
        fetch("http://localhost:8080/api/v1/person/name/"+evt,{method:"POST"})
        .then((data)=>{return data.json()})
        .then((evt)=>{if(evt){document.getElementById("name").style.border="3px solid red";setCn(true)}else{document.getElementById("name").style.border="";setCn(false)}})
    }
    const checkEmail=(evt)=>{
        fetch("http://localhost:8080/api/v1/person/email/"+evt,{method:"POST"})
        .then((data)=>{return data.json()})
        .then((evt)=>{if(evt){document.getElementById("email").style.border="5px solid red";setCe(true)}else{document.getElementById("email").style.border="";setCe(false)}})
    }
    const handleClick=(evt)=>{evt.preventDefault()
        if(name==='')alert("fill name");
        else if(cn)alert("username unavailable");
        else if(about==='')alert("fill about");
        else if(address==='')alert("fill address");
        else if(phone==='')alert("fill phone");
        else if(email==='')alert("fill email");
        else if(ce)alert("email unavailable");
        else if(password==='')alert("fill password");
        else if(skill_1==='')alert("fill skill-1");
        else if(skill_2==='')alert("fill skill-2");
        else if(skill_3==='')alert("fill skill-3");
        else if(skill_4==='')alert("fill skill-4");
        else if(tenth==='')alert("fill tenth");
        else if(twelth==='')alert("fill twelth");
        else if(ug==='')alert("fill ug");
        else if(jt_1==='')alert("fill jt-1");
        else if(jt_1_ex==='')alert("fill jt-1-ex");
        else if(jt_2==='')alert("fill jt-2");
        else if(jt_2_ex==='')alert("fill jt-2-ex");
        else if(jt_3==='')alert("fill jt-3");
        else if(jt_3_ex==='')alert("fill jt-3-ex");
        else{
            const person={name,about,address,phone,email,password,
                skill_1,skill_2,skill_3,skill_4,tenth,twelth,ug,
                jt_1,jt_1_ex,jt_2,jt_2_ex,jt_3,jt_3_ex}
                console.log(person)
                fetch("http://localhost:8080/api/v1/person/add",{method:"POST",
                headers:{"Content-Type":"application/json"},
                body:JSON.stringify(person)})
                .then(()=>{console.log("New Person Added")})
        }
    }
    return (
        <div className={styles.main}>
            <div className={styles.content}>
                <div><h1>SIGN UP</h1></div>
                <div className={styles.sub}>
                    <input spellcheck="false" id="name" type="text" placeholder="Name or Username" value={name} onChange={(evt)=>{setName(evt.target.value);checkName(evt.target.value)}}></input>
                    <label>Profile</label>
                    <textarea spellcheck="false" placeholder="about" value={about} onChange={(evt)=>setAbout(evt.target.value)}></textarea>
                    <label>Contact</label>
                    <input spellcheck="false" type="text" placeholder="Address" value={address} onChange={(evt)=>setAddress(evt.target.value)}></input>
                    <input spellcheck="false" type="tedt" placeholder="Phone" value={phone} onChange={(evt)=>setPhone(evt.target.value)}></input>
                    <input spellcheck="false" id="email" type="email" placeholder="E-Mail" value={email} onChange={(evt)=>{setEmail(evt.target.value);checkEmail(evt.target.value)}}></input>
                    <input spellcheck="false" type="password" placeholder="Create-Password" value={password} onChange={(evt)=>setPassword(evt.target.value)}></input>
                    <label>Skills</label>
                    <input spellcheck="false" placeholder="Professionals" value={skill_1} onChange={(evt)=>setSkill_1(evt.target.value)}></input>
                    <input spellcheck="false" placeholder="Professionals" value={skill_2} onChange={(evt)=>setSkill_2(evt.target.value)}></input>
                    <input spellcheck="false" placeholder="Professionals" value={skill_3} onChange={(evt)=>setSkill_3(evt.target.value)}></input>
                    <input spellcheck="false" placeholder="Professionals" value={skill_4} onChange={(evt)=>setSkill_4(evt.target.value)}></input>
                    <label>Education</label>
                    <textarea spellcheck="false" placeholder="TENTH-INFO
                    eg: University Name
                    Score in percentage
                    Year of Completion" value={tenth} onChange={(evt)=>setTenth(evt.target.value)}>
                    </textarea>
                    <textarea spellcheck="false" placeholder="TWELTH-INFO
                    eg: University Name
                    Score in percentage
                    Year of Completion" value={twelth} onChange={(evt)=>setTwelth(evt.target.value)}>
                    </textarea>
                    <textarea spellcheck="false" placeholder="UG 
                    eg: University Name
                    Score in percentage
                    Year of Completion" value={ug} onChange={(evt)=>setUg(evt.target.value)}>
                    </textarea>
                    <label>Experience</label>
                    <input spellcheck="false" placeholder="Job-Title" value={jt_1} onChange={(evt)=>setJt_1(evt.target.value)}></input>
                    <textarea spellcheck="false" placeholder="Info" value={jt_1_ex} onChange={(evt)=>setJt_1_ex(evt.target.value)}></textarea>
                    <input spellcheck="false" placeholder="Job-Title" value={jt_2} onChange={(evt)=>setJt_2(evt.target.value)}></input>
                    <textarea spellcheck="false" placeholder="Info" value={jt_2_ex} onChange={(evt)=>setJt_2_ex(evt.target.value)}></textarea>
                    <input spellcheck="false" placeholder="Job-Title" value={jt_3} onChange={(evt)=>setJt_3(evt.target.value)}></input>
                    <textarea spellcheck="false" placeholder="Info" value={jt_3_ex} onChange={(evt)=>setJt_3_ex(evt.target.value)}></textarea>
                </div>
                <div><button onClick={handleClick}>Submit</button></div>
            </div>
        </div>
    );
}

export default Signin;