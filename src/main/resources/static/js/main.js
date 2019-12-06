$(document).ready(function(){
    assignButtons()


});

function assignButtons() {
    $("#submitButtone").click(function (e) {

        if (($("#input").val() != "")&&($("#inputa").val() != "")&&($("#inputb").val() != "") ) {
            var slug=$("#input").val();
            var a=$("#inputa").val();
            var b=$("#inputb").val();


            $.getJSON('/encrypt?plain='+slug+'&a='+a+'&b='+b, function(data) {
                $("#c1").text(data.mes);
            });


        }
    });

    $("#submitButtond").click(function (e) {

        if (($("#input").val() != "")&&($("#inputa").val() != "")&&($("#inputb").val() != "") ) {
            var slug=$("#input").val();
            var a=$("#inputa").val();
            var b=$("#inputb").val();



            $.getJSON('/decrypt?plain='+slug+'&a='+a+'&b='+b, function(data) {
                $("#c1").text(data.mes);
            });


        }
    });
}
