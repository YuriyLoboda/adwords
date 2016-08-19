function ajaxF(){
	$('#ads_box div').detach();
	$('#ads_box input').detach();
	var searched= $("#searched").val();
	var control = "CatalogIsNull";
	$.ajax({
		type: "POST",
		data: "searched="+searched +"&control="+control,
		url: "searched",
		dataType: "json",
		success: function(data){
			if(data.result=="ok"){
			var content = data.list ;
			$('#ads_box').append(content);
			}
			$('#ads_box').append("<input type=\"button\" onClick=\"searchedReview()\" value=\"Просмотреть\">");
				
		},
		error: function(data){
			alert("error!");
		}
		
	});
}

function ajaxAdd(){
	
	var btnType="add";
	var price = $('#price').val();
	var date = $('#date').val();
	var discription = $('#discription').val();
	var selectType=$('#selectType').val();
	$.ajax({
		type : "GET",
		data :"btnType="+btnType+ "&price="+price +"&date="+date+"&discription="+discription+"&selectType="+selectType,
		url  : "auto",
		dataType :'json',
		success:function(data){
			$('.newContent').append("<div><input type=\"radio\" name=\"content\" value="+data.id+">" +data.object+"</div");
		},
		error: function(data){
			alert("error!");
		}
	});
	
}
function ajaxDelete(){
	var btnType="delete";
	var checked = $('input:radio:checked').val();
	
	$.ajax({
		type: 		"POST",
		data:		"btnType="+btnType+"&checked="+checked,
		url:		"auto",
		dataType: 	"json"
			
	});
	
	$("#"+checked).detach();
	
}

function ajaxEdit(){
	var btnType="edit";
	var checked =$('input:radio:checked').val();
	$.ajax({
		type: 		"POST",
		data:		"btnType="+btnType+"&checked="+checked,
		url:		"auto",
		dataType:	"json",
		success:function(data){
			$('#price').val(data.price);
			$('#date').val(data.date);
			$('#discription').val(data.discription);
		}
	});
	
}

function ajaxCommitEdit(){
	var checked =$('input:radio:checked').val();
	var btnType="commit";
	var price = $('#price').val();
	var date = $('#date').val();
	var discription = $('#discription').val();
	var selectType=$('#selectType').val();
	setTimeout("window.location.reload()",5000)
	$.ajax({
		type: 		"POST",
		data : "btnType="+btnType+"&checked="+checked+"&price="+price +"&date="+date+"&discription="+discription+"&selectType="+selectType,
		url:"auto",
		dataType:"json",
		
	});
	

}

function changeType(){
	
	var type = $('#selectType').val();
	
	if(type=="1"){
		$('#price').attr("placeholder","Цена");
		$('#date').attr("placeholder","Год выпуск?");
		$('#discription').attr("placeholder","Описание");
	}
	if(type=="2"){
		$('#price').attr("placeholder","Зарплата");
		$('#date').attr("placeholder","Должность");
		$('#discription').attr("placeholder","Описание");
	}
	if(type=="3"){
		$('#price').attr("placeholder","Цена/Мес.");
		$('#date').attr("placeholder","Район");
		$('#discription').attr("placeholder","Описание");
	}
}
function searchedReview(){
	var checked = $('input:radio:checked').val();
	$('.review input').detach();
	var btnType ="review";
	$.ajax({
		type: "POST",
		data: "btnType="+btnType+"&checked="+checked,
		url: "auto",
		dataType : "json",
		success:function(data){
		
			$('.review').append("<input type=\"text\" class=\"1\"  disabled>");
			$('.review').append("<input type=\"text\" class=\"2\"  disabled>");
			$('.review').append("<input type=\"text\" class=\"3\" disabled>");
			$('.review').append("<input type=\"text\" class=\"4\"  disabled>");
			$('.review').append("<input type=\"text\" class=\"5\"  disabled>"); 
			
			$('.1').val("Рубрика :"+data.catalogName);
			$('.2').val(data.date);
			$('.3').val("Цена/Зарплата :"+data.price);
			$('.4').val("Описание :"+data.text);
			$('.5').val("Автор объявления :"+data.userName);
		},
		error: function(data){
			alert("error!");
		}
	});
	
	
	}


$(document).ready(function(){
	$('#add').click(function() {
		if($('.selector').css('display') == 'none'){
			$('.selector').css('display','block');
			$('#add').val('Скрыть');
		}
			
	
		$('.selector').change(function(){
			$('.addForm').css('display','block');
			$('#first').css('display','block');
		})
		
		
	});
	
	$('#edit').click(function() {
		if($('.selector').css('display') == 'none'){
			$('.selector').css('display','block');
			
		}
		$('.selector').change(function(){
			$('.addForm').css('display','block');
			$('#second').css('display','block');
		})
		
	});
	$('#registration').click(function(){
		$('.reg form').css('display','block');
	});
	
	
		
	
	});
	
	


