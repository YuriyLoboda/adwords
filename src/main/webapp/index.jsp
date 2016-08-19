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
</head>
<body>

<div class="wrap">
    <div class="head">
    <img src="img/main_banner1.jpg" alt="">
    <img src="img/main_banner2.jpg" alt="">
    <img src="img/main_banner2.png" alt="">
    
    </div>
    <div class="content">
    <form method="post"  id="index"action="http://localhost:8080/yuriy_loboda_adwords_web/userCheck">
    	<%String err =(String) session.getAttribute("Error"); %>
   		 <%if (err!=null) out.println(err); %>
   		 <input type="text" placeholder="Введите логин" name="login" >
   		 <input type="text" placeholder="Введите пароль" name ="pass">
   		 <input type="submit" value="Войти" >
   		 <input type = "button"  id="registration" value="Регистрация"  >
    </form>
    
    <div class="reg">
    	<form method="post" action="http://localhost:8080/yuriy_loboda_adwords_web/registration">
     		<input type="text" placeholder="Введите Ваше имя" id="nameR" name="nameR">
     		<input type="text" placeholder="Введите логин" id="loginR" name="loginR">
     		<input type="text" placeholder="Введите пароль(больше 3х символов)" id="passR" name="passR">
     		<input type="text" placeholder="Повторите пароль(должны совпадать)" id="passRConfirm" name="passRConfirm">
     		 <input type = "submit" value="Зарегистрироваться"  >
     		
     	</form>
   
   
     
     </div>
    <div class="main_posts_block" id="search_box">
    <input type="button" value="поиск" id="btnSerch" onclick="ajaxF()">
         <input type="text" placeholder="Что Вы ищете?" id="searched">    
    </div>
       
        <div class="main_posts_block" id="ads_box">
           
        </div>
         <div class="review">
             
            	
            </div>
    <div class="footer">&#169; Все права защещены</div>
    </div>
</body>
</html>