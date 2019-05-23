$(document).ready(function () {
    var request=new XMLHttpRequest();
    function searchInfo(){
        var name=document.patientsFacilities.name.value;
        var url="/wwr/facility?id="+name;

        try{
            request.onreadystatechange=function(){
                if(request.readyState===4){
                    var val=request.responseText;
                    document.getElementById('mylocation').innerHTML=val;
                }
            }//end of function
            request.open("GET",url,true);
            request.send();
        }catch(e){alert("Unable to connect to server");}
    }
}