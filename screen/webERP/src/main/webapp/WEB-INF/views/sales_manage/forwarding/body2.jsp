<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    
<% 
String inputNo = (String)request.getAttribute("inputNo");
	String relCode = request.getParameter("relCode");
%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<c:forEach var="forward" items="${forwardInsert}">
	<c:set var="relCode" value="${forward.relCode}"/>
	<c:set var="relDate" value="${forward.relDate}"/>
	<c:set var="custCode" value="${forward.custCode}"/>
	<c:set var="deadLine" value="${forward.deadLine}"/>
	<c:set var="note" value="${forward.note}"/>
	</c:forEach>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출고 처리 등록</title>
<style>
        #contents2{
            position: absolute;
            right: 0;
            top: 25%;
            width: 85%;
            height: 35%;
            border: 1px solid black;
            z-index: 1;
        }
         #view{
            width: 100%;
            text-align: center;
            border: 1px solid black;
        }
        #view td:not(#no){
            width: 8%;
        }
        #view td input{
            width: 100%;
        }
</style>
</head>
<body>
            <container2 id="contents2">
           <table id="view">
               <thead>
                   <td colspan="7">주문출고</td>
               </thead>
                <thead>
                    <td><input type="checkbox" id="check" name="content" onclick="selectAll(this)"/></td>
                    <td>출고번호</td>
                    <td>출고일자</td>
                    <td>고객</td>
                    <td>마감</td>
                    <td>비고</td>
                </thead>
                <c:forEach var="supForward" items="${supForwardList}" varStatus="status">
                <tbody id="updsupForward" align="center">
                    <td><input type="checkbox" value = "${supForward.relCode}" name="content"/></td>
                    <td><a href="javascript:popFunction('${supForward.relCode}','${supForward.relDate}')">
                    <input type="text"  name="ListVO[${status.index}].relCode" value="${supForward.relCode}" readonly/></td>
                    <td><input type="text"  name="ListVO[${status.index}].relDate" value="${supForward.relDate}" readonly /></td>
                    <td><input type="text" name="ListVO[${status.index}].custCode" value="${supForward.custCode}" ondbclick="search2()" readonly /></td>
                    <td><input type="text" name="ListVO[${status.index}].deadLine" value="${supForward.deadLine}" readonly /></td>
                    <td><input type="text" name="ListVO[${status.index}].note" value="${supForward.note}" readonly /></td>
                </tbody>
                </c:forEach>
                    <tbody id="insertsupForward" align="center">
                    <td><input type="checkbox"/></td>
                    <td><input type="text" id="relCode" name="ListVO[${fn:length(forward)}].relCode" value="${relCode}" readonly/></td>
                    <td><input type="date" id="relDate" name="ListVO[${fn:length(forward)}].relDate" value="${relDate}" readonly /></td>
                    <td><input type="text" id="custCode" name="ListVO[${fn:length(forward)}].custCode" value="${custCode}" readonly /></td>
                    <td><input type="text" id="deadLine" name="ListVO[${fn:length(forward)}].deadLine" value="${deadLine}" readonly /></td>
                    <td><input type="text" id="note" name="ListVO[${fn:length(forward)}].note" value="${note}" readonly /></td>
                </tbody>
           </table>
        </container2>
        <script type="text/javascript">
        var text_code = document.getElementById("code");
    	var text_name = document.getElementById("name");
        function popFunction(code,name){
			text_code.value = code;
			text_name.value = name;
			
	}
        
       	function search2(){
      	  
        openWindowPop('http://localhost:8090/webERP/member/forwardcodehelper2.do','cust');  
        }
       	function deleteData() {
    
	  		var item = document.getElementsByName("content").length;
	  		var no = "";
	  		var ary = [];
	  		for(var i=0; i<item;i++){
		  		if(document.getElementsByName("content")[i].checked==true){
					no = document.getElementsByName("content")[i].value;
			
			   		ary.push(no); 
		  		}
		 	  	window.location.href = "${contextPath}/member/delforward.do?no="+ary;
	  		}
		}
       	function submit1(){
       		text_code.setAttribute("relCode",text_code.value);
			text_name.setAttribute("custCode",text_name.value); 
       		window.location.href = "${contextPath}/member/forwardcodehelper3.do?" ;
        }
       		
        </script>
</body>
</html>