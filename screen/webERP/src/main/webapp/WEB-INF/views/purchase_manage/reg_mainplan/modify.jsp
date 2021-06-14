<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<!-- include summernote css/js-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<!-- include summernote-ko-KR -->
<script src="/resources/js/summernote-ko-KR.js"></script>
<title>수정</title>

<!-- <script>
 $(document).ready(function() {
	  $('#summernote').summernote({
 	    	placeholder: 'content',
	        minHeight: 370,
	        maxHeight: null,
	        focus: true, 
	        lang : 'ko-KR'
	  });
	  // Summernote에 글 내용 추가하는 코드
	  $("#summernote").summernote('code','${board.content}');
	}); 
</script> -->
</head>
<body>
<h2 style="text-align: center;">수정</h2><br><br><br>

<div style="width: 60%; margin: auto;">
	<form method="post" action="/modify" >
		<input type="hidden" name="seq" value="${mainplan.seq}">
		<input type="text" name="plandate" style="width: 20%;" placeholder="계획일" value="${mainplan.plandate }" /><br>
		<input type="text" name="item_Code" style="width: 40%;" placeholder="품명" value="${mainplan.item_Code }"readonly/>
		<input type="text" name="item_Name" style="width: 40%;" placeholder="품번" value="${mainplan.item_Name }"readonly/>
		<input type="text" name="standard" style="width: 40%;" placeholder="규격" value="${mainplan.standard }"readonly/>
		<input type="text" name="unit" style="width: 40%;" placeholder="단위" value="${mainplan.unit }"readonly/>
		<input type="text" name="expected_date" style="width: 40%;" placeholder="출하예정일" value="${mainplan.expected_date }"readonly/>
		<input type="text" name="due_date" style="width: 40%;" placeholder="납기일" value="${mainplan.due_date }"readonly/>
		<input type="text" name="plan_quantity" style="width: 40%;" placeholder="계획수량" value="${mainplan.plan_quantity }"/>
		<input type="text" name="customer_Name" style="width: 40%;" placeholder="고객" value="${mainplan.customer_Name }"readonly/>
		<input type="text" name="note" style="width: 40%;" placeholder="비고" value="${mainplan.note }"readonly/>
		<br><br> 
		<!-- <textarea id="summernote" name="content"></textarea> -->
		<input id="subBtn" type="button" value="글 수정" style="float: right;" onclick="goModify(this.form)"/>
	</form>
</div>
<script>
function goModify(frm) {
	var plan_quantity = frm.plan_quantity.value;
	var plandate = frm.plandate.value;
	
	if (plan_quantity.trim() == ''){
		alert("수량을 입력해주세요");
		return false;
	}
	if (plandate.trim() == ''){
		alert("계획일 입력해주세요");
		return false;
	}
	frm.submit();
}
</script>
</body>
</html>