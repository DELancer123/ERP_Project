<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"    
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>    
<% String parent = request.getParameter("itemNumber"); %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <c:forEach var="bom" items="${bomInsert}" >     
 	<c:set var="itemNumber" value="${bom.itemNumber }"/>
 	<c:set var="itemName" value="${bom.itemName }"/>
 	<c:set var="standard" value="${bom.standard }"/>
 	<c:set var="unit" value="${bom.unit }"/>
 </c:forEach>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
		
        #contents2{
            position: absolute;
            left: 15%;
            top: 25%;
            width: 85%;
            height: 70%;
            border: 1px solid black;
            z-index: 1;
        }
        
        /* 컨테이너 스타일부 */
        #workOrderInfo {
            overflow: scroll;
            height: 97%;
            width: 100%;
        }
        #workOrderTable{
       		width:100%;
       	}
        /* 합계 출력부 */
        #resultWindow{
            height: 3%;
            background-color: gray;
            line-height: 5%;
        }
        #button{
            position: absolute;
            right: 10px;
            top: 10px;
        }
		input {
			text-align : center;
		}

</style>
</head>
<body>
<form id="regBOM" method="get" commandName = "ListVO">
<input type="hidden" id="path" value=""/>
        <container2 id= contents2>
            <div id="workOrderInfo">
                <table id="workOrderTable">
                    <thead align="center" style="background-color:gray">
                        <td ><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
                        <td style="width:10px;">No</td>
                        <td>모품목코드</td>
                        <td>품번코드</td>
                        <td>품명</td>
                        <td>규격</td>
                        <td>단위</td>
                        <td>정미수량</td>
                        <td>LOSS(%)</td>
                        <<td>필요수량</td>
                        <td>원가</td>
                        <td>외주단가</td>
                        <td>시작일자</td>
                        <td>종료일자</td>
                        <td>비고</td>
                    </thead>
                    <!-- 테스트용 데이터, 추후 표현식으로 수정필요 -->
         <c:forEach var="bom" items="${bomView}" varStatus="status" >     
   <tr name= "updateTest" align="center">
   	  <td><input type="checkbox" name="content" value="${bom.no }"/></td>
   	  <td style="width:13px;"><input type="text" name="ListVO[${status.index}].no" value = '${bom.no }' style="width:100%"/></td>
   	  <td><input type="text" name="ListVO[${status.index}].parent" value = '${bom.parent}'/></td>
   	  <td><input type="text" name="ListVO[${status.index}].itemNumber" value = '${bom.itemNumber}'/></td>
   	  <td><input type="text" name="ListVO[${status.index}].itemName" value = '${bom.itemName}'/></td>
   	  <td><input type="text" name="ListVO[${status.index}].standard" value = '${bom.standard }'/></td>
   	  <td><input type="text" name="ListVO[${status.index}].unit" value = '${bom.unit }'/></td>
   	  <td><input type="text" name="ListVO[${status.index}].precisionQuantity" value = '${bom.precisionQuantity }'/></td>
   	  <td><input type="text" name="ListVO[${status.index}].loss" value = '${bom.loss }'/></td>
   	  <td><input type="text" value = '${bom.precisionQuantity+bom.loss * 0.1 }'/></td>
   	  <td><input type="text" name="ListVO[${status.index}].actualCost" value = '${bom.actualCost }'/></td>
   	  <td><input type="text" name="ListVO[${status.index}].outSourcingUnitPrice" value = '${bom.outSourcingUnitPrice }'/></td>
   	  <td><input type="date" name="ListVO[${status.index}].startDate" value = '${bom.startDate }'/></td>
   	  <td><input type="date" name="ListVO[${status.index}].endDate" value = '${bom.endDate }'/></td>
   	  <td><input type="text" name="ListVO[${status.index}].note" value = '${bom.note }'/>   </td>
    </tr>
    </c:forEach> 
    
    <tr name ="insertTest" align="center">
    <td><input type="checkbox" name="content"/></td>
    	<td><input type="text" name="ListVO[${fn:length(bomView) }].no" style="width:100%"/></td>
    	<td><input type="text" name="ListVO[${fn:length(bomView) }].parent" value = <%=parent %> /></td>
    	<td><input type="text" id="itemNumber" name="ListVO[${fn:length(bomView) }].itemNumber" value='${itemNumber }' ondblclick="search2()"/></td>
    	<td><input type="text" name="ListVO[${fn:length(bomView) }].itemName" value='${itemName }' /></td>
    	<td><input type="text" name="ListVO[${fn:length(bomView) }].standard" value='${standard }' /></td>
    	<td><input type="text" name="ListVO[${fn:length(bomView) }].unit" value='${unit }'/></td>
    	<td><input type="text" name="ListVO[${fn:length(bomView) }].precisionQuantity"/></td>
    	<td><input type="text" name="ListVO[${fn:length(bomView) }].loss"/></td>
    	<td><input type="text"/></td>
    	<td><input type="text" name="ListVO[${fn:length(bomView) }].actualCost"/></td>
    	<td><input type="text" name="ListVO[${fn:length(bomView) }].outSourcingUnitPrice"/></td>
    	<td><input type="date" name="ListVO[${fn:length(bomView) }].startDate"/></td>
    	<td><input type="date" name="ListVO[${fn:length(bomView) }].endDate"/></td>
    	<td><input type="text" name="ListVO[${fn:length(bomView) }].note"/></td>
    </tr>
     
                </table>
                 
            </div>
            <!-- 합계 출력부 -->
            <div id="resultWindow">
                합 계 <span style="margin-left: 100px;">정미수량 <input type="text"></span><span style="margin-left: 100px;">필요수량 <input type="text"></span>
            </div>
            <!-- 합계 출력부 종료 -->
        </container2>
      <script>
      var itemNumber = document.getElementById("itemCode");
      var itemName = document.getElementById("dataoutput");
      var standard = document.getElementById("dataoutput");
      var unit = document.getElementById("dataoutput");
      var save_button = document.getElementById("save");
      var update_button = document.getElementById('update');
      function search2(){
    	
      	openWindowPop('http://localhost:8090/webERP/member/bomcodehelper.do','codehelper');
    	 
      }
      function setChildValue(name){
    	  
    	  const URLSearch = new URLSearchParams(location.search);
		  URLSearch.set('submit', '2');
		  const newParam = URLSearch.toString();
        if(URLSearch.get('itemCode') == null){
		window.location.href = location.pathname +'?'+newParam + '&itemCode=' + name;
        }
        else{
        	URLSearch.set('itemCode', name);
        	const newParam = URLSearch.toString();
        	window.location.href = location.pathname +'?'+newParam;
        }
        
    }
      
      function updateRow(){
    	  var workOrderTable = document.getElementById('workOrderTable');
          var row = workOrderTable.insertRow(); 
           document.getElementByName('updateTest').action = "${contextPath}/member/updateBOM.do";
  			document.getElementByName('updateTest').submit(); 
      }
      
      
      function newRow(){
          // dao에서 저장
          var workOrderTable = document.getElementById('workOrderTable');
          var row = workOrderTable.insertRow(); 
  			var link = document.location.href;
  			document.getElementById('regBOM').setAttribute('path',link);
            document.getElementById('regBOM').action = "${contextPath}/member/addBOM.do";
  			document.getElementById('regBOM').submit(); 
		/* window.location.href = "${contextPath}/member/addBOM.do"; */
         /*  var cell1 = row.insertCell(0);
          var cell2 = row.insertCell(1);
          var cell3 = row.insertCell(2);
          var cell4 = row.insertCell(3);
          var cell5 = row.insertCell(4);
          cell1.innerHTML = "<input type='checkbox' name='content'/>";;
          cell2.innerHTML = "<input type='text'/>";
          cell4.innerHTML = "<input type='text' />";
          cell5.innerHTML = "<input type='text' />";
          cell3.innerHTML =  "<input type='date' />";
           */
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
    			  window.location.href = "${contextPath}/member/delBOM.do?no="+ary;
    	  }
      }

      </script>
      </form>
</body>
</html>