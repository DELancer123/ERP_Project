<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"    
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style>
#contents1{
            position: absolute;
            left: 15%;
            top: 15%;
            width: 85%;
            height: 10%;
            border: 1px solid black;
            z-index: 1;
        }
        #contents2{
            position: absolute;
            left: 15%;
            top: 25%;
            width: 85%;
            height: 70%;
            border: 1px solid black;
            z-index: 1;
        }
        .con1_search{
            padding:0;
            text-align: center;
            /* position: absolute; 칸 모잘라서 지움*/
            top: 25%;
            left: 5%;
        }
         #searchForm {
            height: 100%;
            margin: 0;
            padding:0;
            text-align: center;
        }
        /* 컨테이너 스타일부 */
        #workOrderInfo {
            overflow: scroll;
            height: 100%;
            width: 100%;
        }

</style>
</head>
<body>
<container1 id = contents1>
            <form id="searchForm">
                <table class="con1_search">
                    <tr>
                        <td>사업장</td>
                        <td style="width: 80px;"><input type="text" value="${param.itemNumber }" style="width: 100%; background-color: yellow;"/></td>
                        <td colspan="3"><input type="text" value="${param.itemName }" disabled style="width: 100%;"/></td>
                        <td><a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></td> 
    
                        <td colspan="5" style="width: 80px;">부서</td>
                        <td style="width: 80px;"><input type="text" value="${param.departmentCode }" style="width: 100%; background-color: yellow;"/></td>
                        <td><input type="text" value="${param.departmentName }" disabled/></td>
                        <td><a href="javascript:search2()"><i class="fas fa-search" style="color: blue;"></i></td>
                        
                    </tr>
                    
                    <tr>
                        <td>작업예정일</td>
                        <td colspan="2" style="width: 50px;"><input type="date"  id='searchStartDate' style="width: 100%;"/></td>
                        <td>~</td>
                        <td ><input type="date" id='searchEndDate' style="width: 100%;"/></td>
                        <td></td>
    
                        <td colspan="5" style="width: 80px;">사원</td>
                        <td style="width: 80px;"><input type="text" style="width: 100%; background-color: yellow;"/></td>
                        <td><input type="text" name="" disabled/></td>
                        <td > <i class="fas fa-search" style="color: blue;"></i></td>
                    </tr>
                </table>
                </form>
        </container1>
        <container2 id= contents2>
            <div id="workOrderInfo">
	         <form id="dataForm" mehtod="get" commandName="ListVO">
                <table id="workOrderTable">
                    <thead>
                        <td><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
                        <td>품번</td>
                        <td>품명</td>
                        <td>규격</td>
                        <td>단위</td>
                        <td>일생산량</td>
                        <td>순서</td>
                        <td>작업예정일</td>
                        <td>수량</td>
                        <td>비고</td>
                    </thead>
                    <!-- 테스트용 데이터, 추후 표현식으로 수정필요 -->
                    <tbody>
               		<c:forEach var="info" items="${infoList}" >    
                     <tr id="updateData" align="center">
                     	<td><input type="checkbox" value = "check1" id="check" name="content"/></td>
                     	<td><input type="text" value="${info.itemCode }" readonly/></td>
                     	<td><input type="text" value="${info.itemName }" readonly/></td>
                     	<td><input type="text" value="${info.standard }" readonly/></td>
                     	<td><input type="text" value="${info.inventoryUnit }" readonly/></td>
                     	<td><input type="text" value="${info.dailyProduction }" readonly/></td>
                        <td><input type="text" value="${info.sequence }" readonly/></td>
                        <td><input type="date" value="${info.scheduled }" readonly/></td>
                        <td><input type="text" value="${info.quantity }" readonly/></td>
                        <td><input type="text" value="${info.note }" readonly /></td>
                     </tr>
                     </c:forEach>
                     <tr>
                        <td><input type="checkbox" value = "check1" name="content"/></td>
                        <td><input type="text" id="workOrderNumber" name="ListVO[${fn:length(infoList)}].workOrderNumber" readonly /></td>
                        <td><input type="text" name="ListVO[${fn:length(infoList)}].itemCode" value="${param.itemCode }"/></td>
                        <td><input type="text" name="ListVO[${fn:length(infoList)}].itemName" value="${param.itemName }"/></td>
                        <td><input type="text" name="ListVO[${fn:length(infoList)}].standard" value="${param.standard }"/></td>
                        <td><input type="text" name="ListVO[${fn:length(infoList)}].inventoryUnit" value="${param.inventoryUnit }"/></td>
                        <td><input type="text" id="indicated" name="ListVO[${fn:length(infoList)}].indicated" value="${param.quantity }"/></td>
                        <td><input type="date" name="ListVO[${fn:length(infoList)}].status" /></td>
                        <td><input type="text" name="ListVO[${fn:length(infoList)}].inspection" readonly/></td>
                        <td><input type="text" name="ListVO[${fn:length(infoList)}].note" value="${param.note }"/></td>
                        <td><input type="hidden" name="ListVO[${fn:length(infoList)}].productionPlanCode" value="${param.productionPlanCode }" /></td>
                     </tr>
                    </tbody>
                </table>
                </form>
            </div>
        </container2>
      
</body>
</html>
 <script>
 /* input date의 현재 날짜 기본값 설정*/
 document.getElementById('searchStartDate').value = new Date().toISOString().substring(0,10);;
 document.getElementById('searchEndDate').value = new Date().toISOString().substring(0,10);;
 
 /* 검색부 date onChange 함수 설정 */
 		var startDate = new Date().toISOString().substring(0,10);;
    	var endDate = new Date().toISOString().substring(0,10);;
    	
    	$('#searchStartDate').change(function (){
            var date = $('#searchStartDate').val();
            startDate = date;
        });
    	$('#searchEndDate').change(function (){
            var date = $('#searchEndDate').val();
            endDate = date;
        });
    	
      function search1(){  
    	  openWindowPop('http://localhost:8090/webERP/member/factorySearch.do','factorySearch');  	  
      }
      function search2(){  
	      openWindowPop('http://localhost:8090/webERP/member/departmentSearch.do','departmentSearch');  	  
		}
      function searchPlan(){
    	  openWindowBroadPop('http://localhost:8090/webERP/member/productionPlanSearch.do','productionPlanSearch');
      }
      
      /* 조회버튼 클릭시 기능 구현 */
      view_button.onclick = function(){
		  if(startDate>endDate){
			  alert("지시기간 종료일은 시작일보다 작을수 없습니다.");
		  } else{
			  
    	  const URLSearch = new URLSearchParams(location.search);
		  URLSearch.set('startDate', startDate);
		  URLSearch.set('endDate', endDate);
		  const newParam = URLSearch.toString();

		  window.open(location.pathname + '?' + newParam, '_self');
		  }
  	}
      
      /* 저장 버튼 기능 구현 */
      
        function newRow(){
          // dao에서 저장
    	 
        	var row = workOrderTable.insertRow(); 
          	const URLSearch = new URLSearchParams(location.search);
		 	const newParam = URLSearch.toString();
			var link = location.pathname +'?'+newParam;
  			var linkPath = document.createElement("input");
  		    linkPath.setAttribute("type","hidden");
  		    linkPath.setAttribute("name","path");
  		    linkPath.setAttribute("value", link);
  		    document.getElementById('dataForm').appendChild(linkPath);
            document.getElementById('dataForm').action = "${contextPath}/member/addOperationInstruction.do";
  			document.getElementById('dataForm').submit();  
		
      }
      
        function updateRow() {
        	var row = workOrderTable.insertRow(); 
        	const URLSearch = new URLSearchParams(location.search);
        	const newParam = URLSearch.toString();
  		 	var link = location.pathname +'?'+newParam;
  		 	document.getElementById("dueDate").disabled = true;
		    document.getElementById("indicated").disabled = true;
		    document.getElementById("instructionDate").disabled = true;
    		var linkPath = document.createElement("input");
    		linkPath.setAttribute("type","hidden");
    		linkPath.setAttribute("name","path");
    		linkPath.setAttribute("value", link);
  		    document.getElementById('dataForm').appendChild(linkPath);
            document.getElementById('dataForm').action = "${contextPath}/member/updateOperationInstruction.do";
    		document.getElementById('dataForm').submit();  
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
      			  window.location.href = "${contextPath}/member/delOperationInstruction.do?workOrderNumber="+ary;
      	  }
        }
      </script>