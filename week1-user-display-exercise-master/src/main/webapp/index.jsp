<%@include file="head.jsp"%>
<html>
<body>
<h2>User Display Exercise - Week 1</h2>
<html>
<head>
</head>
<body>
<br/><br/>
<form action="/searchUser" class="form-inline">
    <table border="0" width="300" align="center" bgcolor="#e9f">
        <tr><td colspan=2 style="font-size:12pt;" align="center">
            <h3>Search User</h3></td></tr>
        <tr><td ><b>Last Name</b></td>
            <td>: <input  type="text" name="searchTerm" id="searchTerm">
            </td></tr>
        <tr><td colspan=2 align="center">
            <button type="submit" name="submit" value="search">Search</button>
            <button type="submit" name="submit" value="viewAll">View all users</button>
    </table>
</form>
</body>
</html>
<a href = "searchUser">Go to the User Search</a>
</body>
</html>