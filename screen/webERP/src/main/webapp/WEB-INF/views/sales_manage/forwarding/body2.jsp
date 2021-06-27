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
String custCode = request.getParameter("custCode");
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
                    <input type="text"  name="ListVO[${status.index}].relCode" value="${supForward.relCode}" ondblclick="submit1()"readonly/></a></td>
                    <td><input type="text"  name="ListVO[${status.index}].relDate" value="${supForward.relDate}" readonly /></td>
                    <td><input type="text" name="ListVO[${status.index}].custCode" value="${supForward.custCode}" ondblclick="search2()" readonly /></td>
                    <td><input type="text" name="ListVO[${status.index}].deadLine" value="${supForward.deadLine}" readonly /></td>
                    <td><input type="text" name="ListVO[${status.index}].note" value="${supForward.note}" readonly /></td>
                    
                </tbody>
                </c:forEach>
                    <tbody id="insertsupForward" align="center">
                    <td><input type="checkbox"/></td>
                    <td><input type="text" id="relCode" name="ListVO[${fn:length(forward)}].relCode" value="${relCode}" readonly/></td>
                    <td><input type="date" id="relDate" name="ListVO[${fn:length(forward)}].relDate" value="${relDate}" /></td>
                    <td><input type="text" id="custCode" name="ListVO[${fn:length(forward)}].custCode" value="${param.custCode}" ondblclick="search2()" readonly/></td>
                    <td><input type="text" id="deadLine" name="ListVO[${fn:length(forward)}].deadLine" value="${deadLine}" /></td>
                    <td><input type="text" id="note" name="ListVO[${fn:length(forward)}].note" value="${note}" /></td>
                </tbody>
           </table>
        </container2>
        
        <script type="text/javascript">
      	var relCode = document.getElementById("relCode");
       	var relDate = document.getElementById("relDate");
        var custCode = document.getElementById("custCode");
        var deadLine = document.getElementById("deadLine");
        var note = document.getElementById("note");
		
		var view_button = document.getElementById("view_button");
		var save_button = document.getElementById("save");
		var update_button = document.getElementById("update");
        function popFunction(code,name){
			text_code.value = code;
			text_name.value = name;
			
	}
    	function openWindowPop(url, name){
			var options = 'top=0, left=0, width=320, height=420, status=no, menubar=no, toolbar=no, resizable=no';
			window.open(url, name, options);
		}
		function selectAll(selectAll){
            const checkbox = document.getElementsByName('content');
            checkbox.forEach((checkbox) => {
                checkbox.checked = selectAll.checked;
            });
        }
		        
       	function search2(){
      	  
        openWindowPop('http://localhost:8090/webERP/member/forwardcodehelper2.do','cust');  
        }
       	view_button.onclick = function(){
      	  const URLSearch = new URLSearchParams(location.search);
      	  URLSearch.set('submit', '1');
      	  const newParam = URLSearch.toString();

      	  window.open(location.pathname + '?' + newParam, '_self');
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
       	
    	function popFunction(code,relCode){
			text_code.value = code;
			text_relCode.value = relCode;
			
		}
       	function submit1(){
       		text_code.setAttribute("custCode",text_code.value);
			text_name.setAttribute("relCode",text_relCode.value); 
       		window.location.href = "${contextPath}/member/insertByItem.do?" ;
        }
    	function setChildValue(name){
			const URLSearch = new URLSearchParams(location.search);
			URLSearch.set('submit','2');
			const newParam = URLSearch.toString();
			if(URLSearch.get('custCode') == null){
				window.location.href = location.pathname + '?' + newParam + '&custCode=' + code;
			}
			else{
				URLSearch.set('custCode',relCode);
				const newParam = URLSearch.toString();
				window.location.href = location.pathname + '?' + newParam;
			}
		}	
       	
        </script>
</body>
</html>