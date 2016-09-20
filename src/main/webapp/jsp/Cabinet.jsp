<%@ page import="domain.Content"%>
<%@ page import="domain.User"%>
<%@ page import="domain.Catalog"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
   
   <div class="buttons">
		<input type="button" id="add" value="Создать объявление">
		<input type="button" id="add">Создать объявление</input>
		<input type="button" id="delete" value="Удалить объявление" onclick="ajaxDelete()">  
		<input type="button" id="edit" value="Редактировать объявление" onclick="ajaxEdit()">
    </div>
   
   
   	 <div class="selector" >
    	<select id="selectType" name="type" onchange = 'changeType()'>
    					<option value ="0">Тип Объявления</option>
                		<option  value="1">Авто</option>
                		<option  value="2">Работа</option>
                		<option  value="3">Недвижимость</option>   
            		</select>
    </div>
   <div class="addForm">
   <div class="inputs">
    		<input type="text" id="price" >
   			<input type="text" id="date" >
   		</div>
   		<div class="textarea">
   			<textarea  id="discription"> </textarea>
   		</div>
   
   		<div class="Ok">
   		<div id="first"><input type="button"  value ="Подтвердить" onclick="ajaxAdd()"></div>
   		<div><input type="button" id ="second" value ="Подтвердить" onclick="ajaxCommitEdit()"></div>
   		</div>
   </div>
    	
          <div class="listContent">   
            	<div class="itemListContent">
               		<h4></h4>
                	<p></p>
            	</div>
          
        </div>        
        <div class="newContent">
           <%List<Content> list =(List<Content>) session.getAttribute("list");%>
           <%for(Content con: list) out.println("<div id="+con.getId()+"><input type=\"radio\" name=\"content\" value="+con.getId()+">"+con+"</div>"); %>
           
        </div>
    
           
       </div>
       <div class="footer">&#169; Все права защещены! 2016г.</div>
  
</body>
</html>