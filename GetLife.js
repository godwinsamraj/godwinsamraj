var bar=false
function show(){
    if(bar){
        document.getElementById("ul-1").style.display="block";
        bar=false;
    }
    else{
        document.getElementById("ul-1").style.display="none";
        bar=true;
    }
}