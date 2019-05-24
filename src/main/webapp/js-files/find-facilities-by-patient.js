$(document).ready(function () {
    var request=new XMLHttpRequest();
    function searchInfo(){
        var name=document.patientsFacilities.name.value;
        var url="/wwr/facility?searchBy="+name;

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
});

$(document).ready(function () {
    $(".facility").on("click", function () {
        $(".facility-details").toggle();
    })
});

// $(document).ready(function () {
//         var facilities = document.getElementsByClassName("facility");
//         for (var i = 0; i < facilities.length; i++) {
//             var index = i;
//             facilities[i].addEventListener("click", function (evt) {
//                 var details = document.getElementsByClassName("facility-details").item(index);
//                 $(details).toggle();
//             })
//         }
//     }
// );