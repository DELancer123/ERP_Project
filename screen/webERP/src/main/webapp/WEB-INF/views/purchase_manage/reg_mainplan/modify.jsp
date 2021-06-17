<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt %>
<%
request.setCharacterEncoding("UTF-8");
String sequence = (String)request.getAttribute("sequence");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정</title>
</head>
<body>
	<form name="updateform" method="post" action="/member/update">

		<div>순서</div>
		<div>
			<input type="hidden" name="sequence" value="${vo.sequence}" />
		</div>

		<div>계획일</div>
		<div>
			<input name="plandate" value="${vo.plandate}" type="text" />
		</div>

		<div>품명</div>
		<div>
			<input name="item_Code" value="${vo.item_Code}" type="text"
				readonly="readonly" />
		</div>

		<div>품번</div>
		<div>
			<input name="item_Name" value="${vo.item_Name}" type="text"
				readonly="readonly" />
		</div>

		<div>규격</div>
		<div>
			<input name="standard" value="${vo.standard}" type="text"
				readonly="readonly" />
		</div>

		<div>단위</div>
		<div>
			<input name="unit" value="${vo.unit}" type="text"
				readonly="readonly" />
		</div>

		<div>출하예정일</div>
		<div>
			<input name="expected_date" value="${vo.expected_date}"
				type="text" readonly="readonly" />
		</div>

		<div>납기일</div>
		<div>
			<input name="due_date" value="${vo.due_date}" type="text"
				readonly="readonly" />
		</div>

		<div>계획수량</div>
		<div>
			<input name="plan_quantity" value="${vo.plan_quantity}"
				type="text" />
		</div>

		<div>고객</div>
		<div>
			<input name="customer_Name" value="${vo.customer_Name}"
				type="text" readonly="readonly" />
		</div>

		<div>비고</div>
		<div>
			<input name="note" value="${vo.note}" type="text"
				readonly="readonly" />
		</div>
		<div class='btnSet'>
		<a class="btn-fill" onclick="$('form').submit()">저장</a>
		<a class="btn-empty" href="detail.do?sequence=${vo.sequence}">취소</a>
	</div>
	</form>
</body>
</html>