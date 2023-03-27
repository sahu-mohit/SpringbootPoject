

function savedata() {
    var data = new FormData(fromdata);
    $.ajax({
        url: "rest/registration",
        // contentType: "application/x-www-form-urlencoded",
        processData: false,
        contentType: false,
        type: "POST",
        data: (data),
        success: function (result) {
            alert(result);
            viewopen("/");
        },
        error: function (result) {
            console.error("An error occurred:", result);
        }
    });
}

function  removeElementUsingId(columnid) {
    var columnid = columnid.value;
    $(columnid).remove();
}

function numberOfColumn(value) {
    var count = $("#column").val();
    $("#noofrow").val(count);
    for (var i = 0; i < count; i++) {
        var columnHtml = '<div class="input-group mb-3" id="row_'+i+'">\n' +
            ' <span class="input-group-text">Column Name</span>\n' +
            ' <input type="text" class="form-control"  aria-label="columnName" id="columnname_'+i+'" name="columnname_'+i+'">\n' +
            ' <span class="input-group-text">Column Id</span>\n' +
            ' <input type="text" class="form-control"  aria-label="columnId" id="columnid_'+i+'" name="columnid_'+i+'" >\n' +
            '<select class="form-select" aria-label="Default select example" id="columntype_'+i+'" name="columntype_'+i+'">\n' +
            '  <option selected>Select Column Type</option>\n' +
            '  <option value="text">Text</option>\n' +
            '  <option value="singleselect">Single Select</option>\n' +
            '  <option value="multipleselect">Multiple Select</option>\n' +
            '  <option value="checkbox">Check Box</option>\n' +
            '</select>\n'+

            '<button type="button" class=" form-control btn btn-primary" id="row" value="#row_'+i+'" onclick="removeElementUsingId(this);">remove row</button>\n'+
            '</div>';
        $("#noColumn").append(columnHtml)
    }
    $("#column").val("")
}

function tableViewKey(value)
{
    var key = value.value;
    data={
        'key': key
    };

    $.ajax(
        {
            url:"rest/getkey",
            type:"GET",
            contenType:"application/x-www-form-urlencoded",
            data:(data),
            success:function (responce) {
                $("#div1").html(responce)
            }
        }
    )
}

function hideShow(condition,change) {
    if($("#"+condition).is(":checked")){
        $("#"+change).show();
    }else{
        $("#"+change).hide();
    }
}
