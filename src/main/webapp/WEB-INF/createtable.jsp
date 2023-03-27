<!DOCTYPE html>
<html lang="en">
<script src="https://code.jquery.com/jquery-1.12.4.min.js">
</script>

<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
            crossorigin="anonymous">
    </script>
    <script src="../assests/createtable.js"></script>
    <script src="../assests/CommonJavaScript.js"></script>
    <script>
        $(document).ready(function () {
            $("#actiondiv").hide();
        })
    </script>
</head>
<body>
<%--<div class="row">--%>
<label for="column" class="col-sm-6 col-form-label">Number of Column</label>
<div class="col-sm-4">
    <input type="text" onchange="numberOfColumn();" class="form-control col-sm-4" id="column"></br>
</div>
<form id="fromdata">
    <input type="hidden" name="noofrow" id="noofrow">
    <div id="noColumn">
    </div>

    <div class="col-sm-4">

        <div class="row">
            <div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" name="actionbutton" id="actionbutton"
                           onchange="hideShow(this.id,'actiondiv');">
                    <label class="form-check-label" for="actionbutton">Action Button</label>
                </div>
            </div>
            <div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" name="isCheckbox" id="isCheckbox">
                    <label class="form-check-label" for="isCheckbox">Check Box</label>
                </div>
            </div>
            <div id="actiondiv">
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="edit" name="edit">
                    <label class="form-check-label" for="edit">Edit</label>
                </div>
                <div class="form-check form-check-inline">
                    <input class="form-check-input" type="checkbox" id="delete" name="delete">
                    <label class="form-check-label" for="delete">Delete</label>
                </div>
            </div>
        </div>
        <label for="column" class="col-sm-6 col-form-label">Table view kye</label>
        <input type="text" class="form-control col-sm-4" onkeyup="tableViewKey(this)" name="tableviewname"
               id="tableviewname"></br>
        <label for="column" class="col-sm-6 col-form-label">Title of view</label>
        <input type="text" class="form-control col-sm-4" name="title" id="title"></br>
        <label for="column" class="col-sm-6 col-form-label">MVC Url</label>
        <input type="text" class="form-control col-sm-4" name="mvcurl" id="mvcurl"></br>
        <label for="column" class="col-sm-6 col-form-label">Rest Url</label>
        <input type="text" class="form-control col-sm-4" name="resturl" id="resturl"></br>
    </div>

    <button type="button" class="btn btn-primary" onclick="savedata();">Save</button>
    <div>
        <p id="div1"></p>
    </div>
</form>
</body>
</html>