<%@ page import="domain.Content"%>
<%@ page import="domain.User"%>
<%@ page import="domain.Catalog"%>
<%@ page import="java.util.List"%>
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
    
     <div class="top_buttons">
     
    	<form action="http://localhost:8080/yuriy_loboda_adwords_web/cabinet" method = "post">
    		<input class="submit" type = "submit" value="Мой кабинет">
    	</form>
    	<form action="http://localhost:8080/yuriy_loboda_adwords_web/logout" method = "post">
    		<input class="submit" type = "submit" value="Выйти">
    	</form>
   	
    </div>
</head>
<body>

<div class="wrap">
    <div class="head">
   	<form action="http://localhost:8080/yuriy_loboda_adwords_web/dispatcher" method="post">
           <button name ="type"value="3" type="submit"><img src="img/main_banner1.jpg" alt=""></button>
         </form>  
         
         <form action="http://localhost:8080/yuriy_loboda_adwords_web/dispatcher" method="post">
           <button name ="type"value="2" type="submit"><img src="img/main_banner2.jpg" alt=""></button> 
         </form> 
          <form action="http://localhost:8080/yuriy_loboda_adwords_web/dispatcher" method="post">
           <button name ="type"value="1" type="submit"><img src="img/main_banner2.png" alt=""></button>
         </form> 
    
    </div>
    <div class="content">
   
     <div class="main_posts_block" id="search_box"> 
         	<input type="text" placeholder="Что Вы ищете?" id="searched">
         	<input type="button" value="поиск" id="btnSearch" onclick="ajaxF()">      	 
   		 	</div>
   		 	
       
         <div class="review">
             
            	
            </div>
       
        <div class="main_posts_block" id="ads_box">
             <% List <Content> list =(List<Content>)request.getAttribute("list");  %>
            <%for (Content c: list) {out.println("<div>"+c+"</div>");}%>
        </div>
    <div class="footer">&#169; Все права защещены</div>
    </div>
</body>
</html>