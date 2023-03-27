<html>
<head>
    <title id="title"></title>

    <script src="../assests/CommonTableView"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
</head>
<body>
<script>
    $(document).ready(function() {
        setTableView();
    });
</script>

<h1 id="viewname">
</h1>

<div id="commontable"></div>
<input id="restApi" name="restApi" type="hidden" value="<%=request.getAttribute("restApi")%>">
</body>
</html>