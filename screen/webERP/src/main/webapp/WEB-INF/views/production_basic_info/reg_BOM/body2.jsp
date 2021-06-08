<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"    
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>    
<% String parent = request.getParameter("itemNumber"); %>
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
<form id="regBOM" method="get">
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
         <c:forEach var="bom" items="${bomView}" >     
   <tr align="center">
   	  <td><input type="checkbox" name="content"/></td>
   	  <td style="width:13px;"><input type="text" value = '${bom.no }' style="width:100%"/>
   	  <td><input type="text" value = '${bom.parent}'/>
   	  <td><input type="text" value = '${bom.itemNumber}'/>
   	  <td><input type="text" value = '${bom.itemName}'/>
   	  <td><input type="text" value = '${bom.standard }'/>
   	  <td><input type="text" value = '${bom.unit }'/>
   	  <td><input type="text" value = '${bom.precisionQuantity }'/>
   	  <td><input type="text" value = '${bom.loss }'/>
   	  <td><input type="text" value = '${bom.precisionQuantity+bom.loss * 0.1 }'/>
   	  <td><input type="text" value = '${bom.actualCost }'/>
   	  <td><input type="text" value = '${bom.outSourcingUnitPrice }'/>
   	  <td><input type="date" value = '${bom.startDate }'/>
   	  <td><input type="date" value = '${bom.endDate }'/>
   	  <td><input type="text" value = '${bom.note }'/>
      
    </tr>
    </c:forEach> 
    <tr align="center">
    <td><input type="checkbox" name="content"/></td>
    	<td><input type="text" name="no" style="width:100%"/></td>
    	<td><input type="text" name="parent" value = <%=parent %> /></td>
    	<td><input type="text" id="itemNumber" name="itemNumber" value='${itemNumber }' ondblclick="search2()"/></td>
    	<td><input type="text" name="itemName" value='${itemName }' /></td>
    	<td><input type="text" name="standard" value='${standard }' /></td>
    	<td><input type="text" name="unit" value='${unit }'/></td>
    	<td><input type="text" name="precisionQuantity"/></td>
    	<td><input type="text" name="loss"/></td>
    	<td><input type="text"/></td>
    	<td><input type="text" name="actualCost"/></td>
    	<td><input type="text" name="outSourcingUnitPrice"/></td>
    	<td><input type="date" name="startDate"/></td>
    	<td><input type="date" name="endDate"/></td>
    	<td><input type="text" name="note"/></td>
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
          window.location.href = "${contextPath}/member/updateBOM.do";
      }
      
      
      function newRow(){
          // dao에서 저장
          var workOrderTable = document.getElementById('workOrderTable');
          var row = workOrderTable.insertRow(); 
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
<<<<<<< HEAD
      
     function deleteData() {
    	  var item = document.getElementsByName("content").length;
    	  var itemCode = "";
    	  for(var i=0; i<item;i++){
    		  if(document.getElementsByName("content")[i].checked==true){
    			  itemCode = document.getElementsByName("content")[i].value;
    			  window.location.href = "${contextPath}/member/delBOM.do?itemCode="+itemCode;
    		  }
    	  }
      }
=======
>>>>>>> 81038a2736614bc72197ad0df327da9ba7a333f2
      </script>
      </form>
</body>
</html>