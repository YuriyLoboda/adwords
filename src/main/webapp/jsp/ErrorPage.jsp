<%@ page import="domain.Content"%>
<%@ page import="domain.User"%>
<%@ page import="domain.Catalog"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="css/style.css">
     <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script type="text/javascript" src="js/my.js"></script>
    <h2>Извените, но возникла ошибка при регистрации</h2>
    <% String err= (String)session.getAttribute("Error1");%>
    <h3><%if(err!=null)out.println(err); %></h3>
</head>
<body>

<div class="wrap">
    <div class="head">
    
    
    </div>
   
    
    <div class="footer">&#169; Все права защещены</div>
    </div>
</body>
</html>