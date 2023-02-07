import React,{useState} from 'react';
import styles from '../css/Resume.module.css';
import Axios from 'axios';

function Resume(){
    const [name,setName]=useState('')
    const [about,setAbout]=useState('')
    const [address,setAddress]=useState('')
    const [phone,setPhone]=useState('')
    const [email,setEmail]=useState('')
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
    Axios.get("http://localhost:8080/api/v1/person/godwinsamraj")
    .then((res)=>{
        setName(res.data.name)
        setAbout(res.data.about)
        setAddress(res.data.address)
        setPhone(res.data.phone)
        setEmail(res.data.email)
        setSkill_1(res.data.skill_1)
        setSkill_2(res.data.skill_2)
        setSkill_3(res.data.skill_3)
        setSkill_4(res.data.skill_4)
        setTenth(res.data.tenth)
        setTwelth(res.data.twelth)
        setUg(res.data.ug)
        setJt_1(res.data.jt_1)
        setJt_1_ex(res.data.jt_1_ex)
        setJt_2(res.data.jt_2)
        setJt_2_ex(res.data.jt_2_ex)
        setJt_3(res.data.jt_3)
        setJt_3_ex(res.data.jt_3_ex)
    })
    return (
        <div className={styles.resume}>
            <div className={styles.name}><h1>{name}</h1></div>
            <div className={styles.content}>
                <div className={styles.left}>
                    <div class={styles.contact}>
                        <h4>CONTACT</h4>
                        {address}<br></br>
                        {phone}<br></br>
                        {email}<br></br>
                    </div>
                    <div className={styles.skill}>
                        <h4>SKILL</h4>
                        {skill_1}<br></br>
                        {skill_2}<br></br>
                        {skill_3}<br></br>
                        {skill_4}<br></br>
                    </div>
                    <div className={styles.education}>
                        <h4>EDUCATION</h4>
                        <div>
                            <h5>TENTH</h5>
                            {tenth}<br></br>
                        </div>
                        <div>
                            <h5>TWELTH</h5>
                            {twelth}<br></br>
                        </div>
                        <div>
                            <h5>UG</h5>
                            {ug}<br></br>
                        </div>
                    </div>
                </div>
                <div className={styles.right}>
                    <div className={styles.about}>
                        <h4>ABOUT</h4>
                        {about}
                    </div>
                    <div>
                            <h4>EXPERIENCE</h4>
                            <div className={styles.jt_1}>
                                <h5>{jt_1}</h5>
                                <div className={styles.exp}>{jt_1_ex}</div>
                            </div>
                            <div className={styles.jt_2}>
                                <h5>{jt_2}</h5>
                                <div className={styles.exp}>{jt_2_ex}</div>
                            </div>
                            <div className={styles.jt_3}>
                                <h5>{jt_3}</h5>
                                <div className={styles.exp}>{jt_3_ex}</div>
                            </div>
                    </div>
                </div>
            </div>
            <button>UPDATE</button>
        </div>
    );
}

export default Resume;