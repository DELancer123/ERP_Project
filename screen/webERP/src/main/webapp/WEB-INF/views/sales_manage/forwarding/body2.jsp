<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    
<% 
	String custCode1 = request.getParameter("general_Customer_Code");
	String custCode = request.getParameter("custCode");
	String relCode = request.getParameter("relCode");
%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<c:forEach var="forward" items="${forwardInsert}">
	<c:set var="relCode" value="${forward.relCode}"/>
	<c:set var="relDate" value="${forward.relDate}"/>
	<c:set var="custCode" value="${forward.general_Customer_Code}"/>
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
         #forwardingTable{
            width: 100%;
            text-align: center;
            border: 1px solid black;
        }
        #forwardingTable td:not(#no){
            width: 8%;
        }
        #forwardingTable td input{
            width: 100%;
        }
</style>
</head>
<body>
            <container2 id="contents2">
            <div id="forwardingInfo">
            <form id="dataForm" mehtod="get" commandName="ListVO">
           <table id="forwardingTable">
                <thead>
                    <td><input type="checkbox" id="check" name="content" onclick="selectAll(this)"/></td>
                    <td>출고번호</td>
                    <td>출고일자</td>
                    <td>고객</td>
                    <td>마감</td>
                    <td>비고</td>
                </thead>
                <c:forEach var="supForward" items="${submitCustList}" varStatus="status">
                <tbody id="updsupForward" align="center">
                    <td><input type="checkbox" value = "${supForward.relCode}" name="content"/></td>
                    <td><a href="javascript:popFunction('${supForward.relCode}','${supForward.relDate}')">
                    <input type="text"  name="ListVO[${status.index}].relCode" value="${supForward.relCode}"readonly/></a></td>
                    <td><input type="date"  name="ListVO[${status.index}].relDate" value="${supForward.relDate}" readonly /></td>
                    <td><input type="text" name="ListVO[${status.index}].general_Customer_Code" value="${supForward.general_Customer_Code}" readonly />
                    <input type="hidden" value=""${param.general_Customer_Name}""></td>
                    <td><input type="text" name="ListVO[${status.index}].deadLine" value="${supForward.deadLine}" readonly /></td>
                    <td><input type="text" name="ListVO[${status.index}].note" value="${supForward.note}" readonly /></td>
                </tbody>
                </c:forEach>
                    <tbody id="insertsupForward" align="center">
                    <td><input type="checkbox"/></td>
                    <td><input type="text" id="relCode" name="ListVO[${fn:length(supForwardList)}].relCode" value="${relCode}" /></td>
                    <td><input type="date" id="relDate" name="ListVO[${fn:length(supForwardList)}].relDate" value="${relDate}" /></td>
                    <td><input type="text" id="custCode" name="ListVO[${fn:length(supForwardList)}].general_Customer_Code" value="${param.custCode}" ondblclick="search2()" readonly/></td>
                    <td><input type="text" id="deadLine" name="ListVO[${fn:length(supForwardList)}].deadLine" value="${deadLine}" /></td>
                    <td><input type="text" id="note" name="ListVO[${fn:length(supForwardList)}].note" value="${note}" /></td>
                </tbody>
           </table>
           </form>
           </div>
        </container2>
        
        <script type="text/javascript">
        var text_code = document.getElementById("code");
    	var text_name = document.getElementById("name");
    	var relCode = document.getElementById("relCode");
       	var relDate = document.getElementById("relDate");
        var custCode = document.getElementById("custCode");
        var deadLine = document.getElementById("deadLine");
        var note = document.getElementById("note");
        
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
      	  
        openWindowPop('http://localhost:8090/webERP/member/forwardcodehelper.do','cust');  
        }
       	view_button.onclick = function(){
      	  const URLSearch = new URLSearchParams(location.search);
      	  URLSearch.set('submit', '1');
      	  const newParam = URLSearch.toString();
      	  window.open(location.pathname + '?' + newParam, '_self');
      }
       
    	function setChildValue(name){
			const URLSearch = new URLSearchParams(location.search);
			URLSearch.set('submit','2');
			const newParam = URLSearch.toString();
			if(URLSearch.get('general_Customer_Code') == null){
				window.location.href = location.pathname + '?' + newParam + '&general_Customer_Code=' + text_code;
			}
			else{
				URLSearch.set('general_Customer_Code',name);
				const newParam = URLSearch.toString();
				window.location.href = location.pathname + '?' + newParam;
			}
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
       	
    	/* 저장 버튼 기능 구현 */
        
        function newRow(){
          // dao에서 저장
        
           var row = forwardingTable.insertRow(); 
             const URLSearch = new URLSearchParams(location.search);
          const newParam = URLSearch.toString();
         var link = location.pathname +'?'+newParam;

           var linkPath = document.createElement("input");
            linkPath.setAttribute("type","hidden");
            linkPath.setAttribute("name","path");
            linkPath.setAttribute("value", link);
            
            document.getElementById('dataForm').appendChild(linkPath);
            document.getElementById('dataForm').action = "${contextPath}/member/addforward.do";
           document.getElementById('dataForm').submit();  

      
      }
    	
		/*수정버튼*/
        function updateRow() {
           var row = workOrderTable.insertRow(); 
           const URLSearch = new URLSearchParams(location.search);
           const newParam = URLSearch.toString();
            var link = location.pathname +'?'+newParam;
          var linkPath = document.createElement("input");
          linkPath.setAttribute("type","hidden");
          linkPath.setAttribute("name","path");
          linkPath.setAttribute("value", link);
            document.getElementById('dataForm').appendChild(linkPath);
            document.getElementById('dataForm').action = "${contextPath}/member/updforward.do";
          document.getElementById('dataForm').submit();  
        }
    	
        </script>
</body>
</html>