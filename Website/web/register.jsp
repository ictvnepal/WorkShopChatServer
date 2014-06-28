<%-- 
    Document   : register
    Created on
 : Jun 28, 2014, 2:25:21 PM
    Author     : forsell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add User</title>
    </head>
    <body>
        <h1>Add Users</h1>
        <br />
        <br />
        <br />

    <form  method="post" action="register">
      <label >User Name</label>
      <input type="text" name="username"  value="Username" /><br />
      <label >Password</label>
      <input type="text" name="password" value="Password" /><br />
      <label >Email</label>
      <input type="text" name="email" value="Email" /><br />
      <input type="submit" name="submit" value="Register"/>
    </form>
    </body>
</html>
