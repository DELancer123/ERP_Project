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
<style>
#contents1{
            position: absolute;
            padding: 10px;
            right: 0;
            top: 15%;
            width: 85%;
            height: 10%;
            border: 1px solid black;
            z-index: 1;
        }
        #contents2{
            position: absolute;
            right: 0;
            top: 25%;
            width: 85%;
            height: 35%;
            border: 1px solid black;
            z-index: 1;
        }
        #contents3{
            position: absolute;
            right: 0;
            top:60%;
            width: 85%;
            height: 35%;
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
            margin: 10px 20px;
            padding:0;
            text-align: center;
        }

        #workOrderDetail{
            height: 100%;
            overflow: scroll;
        }
        #workOrderInfo {
            height: 100%;
            width: 100%;
            overflow: scroll;
        }

</style>
</head>
<body>
<container1 id = contents1>
            <form id="searchForm">
                <table class="con1_search">
                    <tr>
                        <td>사업장</td>
                        <td style="width: 80px;"><input type="text" value="${param.factoryNumber }" style="width: 100%; background-color: yellow;"/></td>
                        <td colspan="3"><input type="text" value="${param.factoryName }" disabled style="width: 100%;"/></td>
                        <td><a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></td> 
    
                        <td colspan="5" style="width: 80px;">부서</td>
                        <td style="width: 80px;"><input type="text" value="${param.departmentCode }" style="width: 100%; background-color: yellow;"/></td>
                        <td><input type="text" value="${param.departmentName }" disabled/></td>
                        <td><a href="javascript:search2()"><i class="fas fa-search" style="color: blue;"></i></td>
                        
                    </tr>
                    
                    <tr>
                        <td>지시일</td>
                        <td colspan="2" style="width: 50px;"><input type="date"  id='searchStartDate' style="width: 100%;"/></td>
                        <td>~</td>
                        <td ><input type="date" id='searchEndDate' style="width: 100%;"/></td>
                        <td></td>
    
                        <td colspan="5" style="width: 80px;">사원</td>
                        <td style="width: 80px;"><input type="text" style="width: 100%; background-color: yellow;"/></td>
                        <td><input type="text" name="" disabled/></td>
                        <td > <i class="fas fa-search" style="color: blue;"></i></td>

                        <td>
                            <input type="button" value="마감처리" onClick="closing();" style="padding: 5px; margin-left: 30px;"></input>
                        </td>
                        <td>
                            <input type="button" value="마감취소" onClick="closingCancle();" style="padding: 5px;"></input>
                        </td>
                    </tr>
                </table>
                </form>
        </container1>
        <container2 id="contents2">
           <!-- 디테일부 -->
           <div id="workOrderDetail">
            <table id="workOrderDetailTable">
                <thead>
                    <td><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
                    <td>작업지시번호</td>
                    <td>지시일</td>
                    <td>완료일</td>
                    <td>품번</td>
                    <td>품명</td>
                    <td>규격</td>
                    <td>단위</td>
                    <td>지시수량</td>
                    <td>상태</td>
                    <td>공정</td>
                </thead>
                <!-- 테스트용 데이터, 추후 표현식으로 수정필요 -->
                <tbody>
                     <c:forEach var="info" items="${infoList}" varStatus="status">   
                     <tr id="updateData" align="center">
                     	<td><input type="checkbox" name="content" value="${info.workOrderNumber }" /></td>
                     	<td><input type="text" name="ListVO[${status.index }].workOrderNumber" value="${info.workOrderNumber}" readonly /></td>
                     	<td><input type="date" name="ListVO[${status.index }].instructiondate" value="${info.instructionDate}" readonly /></td>
                     	<td><input type="date" name="ListVO[${status.index }].dueDate" value="${info.dueDate}" /></td>
                     	<td><input tpye="text" name="ListVO[${status.index }].itemCode" value="${info.itemCode }" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].itemName" value="${info.itemName}" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].standard" value="${info.standard}" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].inventoryUnit" value="${info.inventoryUnit}" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].indicated" value="${info.indicated}" /></td>
                     	<td style="width:13px;"><input type="text" name="ListVO[${status.index }].status" value="${info.status}" readonly /></td>
                     	<td style="width:20px;"><input type="text" name="ListVO[${status.index }].workplaceCode" value="${info.workplaceCode}" readonly /></td>
                     </tr>
                     </c:forEach>
                     <tr>
                        <td><input type="checkbox" value = "check1" name="content"/></td>
                        <td><input type="text" id="workOrderNumber" name="ListVO[${fn:length(infoList)}].workOrderNumber" readonly /></td>
                        <td><input type="date" id="instructionDate" name="ListVO[${fn:length(infoList)}].instructionDate" value="${param.workDate }"/></td>
                        <td><input type="date" id="dueDate" name="ListVO[${fn:length(infoList)}].dueDate" value="${param.workDate }"/></td>
                        <td><input type="text" name="ListVO[${fn:length(infoList)}].itemCode" value="${param.itemCode }"/></td>
                        <td><input type="text" name="ListVO[${fn:length(infoList)}].itemName" value="${param.itemName }"/></td>
                        <td><input type="text" name="ListVO[${fn:length(infoList)}].standard" value="${param.standard }"/></td>
                        <td><input type="text" name="ListVO[${fn:length(infoList)}].inventoryUnit" value="${param.inventoryUnit }"/></td>
                        <td><input type="text" id="indicated" name="ListVO[${fn:length(infoList)}].indicatedQuantity" value="${param.indicatedQuantity }"/></td>
                        <td style="width:13px;"><input type="text" name="ListVO[${fn:length(infoList)}].status" readonly/></td>
                        <td style="width:20px;"><input type="text" name="ListVO[${fn:length(infoList)}].workplaceCode" readonly/></td>
                     </tr>
                </tbody>
            </table>
        </div>
        <!-- 디테일부 종료 -->
        </container2>
        <container3 id="contents3">
            <div id="workOrderInfo">
                <table id="workOrderTable">
                    <thead>
                        <td><input type="checkbox" name="content2" onclick="selectAll2(this)"/></td>
                        <td>NO</td>
                        <td>지시일</td>
                        <td>완료일</td>
                        <td>공정구분</td>
                        <td>공정</td>
                        <td>작업장</td>
                        <td>지시수량</td>
                        <td>실적수량</td>
                        <td>실적잔량</td>
                        <td>단가</td>
                        <td>금액</td>
                        <td>검사</td>
                        <td>비고</td>
                    </thead>
                    <!-- 테스트용 데이터, 추후 표현식으로 수정필요 -->
                    <tbody>
                        <td><input type="checkbox" value = "check1" id="check" name="content2"/></td>
                        <td><input type="text"/></td>
                        <td><input type="date"/></td>
                        <td><input type="date"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>
                    </tbody>
                </table>
            </div>
        </container3>
      
</body>
</html>
<script>
 /* 검색부 date onChange 함수 설정 */
 		var startDate = "";
    	var endDate = "";
    	
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
      
      /* 조회버튼 클릭시 기능 구현 */
      view_button.onclick = function(){
		 if(startDate>endDate){
			  alert("지시기간 종료일은 시작일보다 작을수 없습니다.");
		  } else{
			  
		var item = document.getElementsByName("content").length;
	    var no = "";
	    var ary = [];
	    for(var i=0; i<item;i++){
	    	if(document.getElementsByName("content")[i].checked==true){
	      		no = document.getElementsByName("content")[i].value;
	      		ary.push(no);
	      	  }
	     }
	      
    	  const URLSearch = new URLSearchParams(location.search);
		  URLSearch.set('startDate', startDate);
		  URLSearch.set('endDate', endDate);
		  URLSearch.set('searchNumber', ary);
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
        
        function closing() {
        	var item = document.getElementsByName("content").length;
        	  var no = "";
        	  var ary = [];
        	  for(var i=0; i<item;i++){
        		  if(document.getElementsByName("content")[i].checked==true){
        			  no = document.getElementsByName("content")[i].value;
        			  ary.push(no);
        		  }
        			window.location.href = "${contextPath}/member/closingDetail.do?workOrderNumber="+ary;
        	  }
        }
        
        function closingCancle() {
        	var item = document.getElementsByName("content").length;
        	  var no = "";
        	  var ary = [];
        	  for(var i=0; i<item;i++){
        		  if(document.getElementsByName("content")[i].checked==true){
        			  no = document.getElementsByName("content")[i].value;
        			  ary.push(no);
        		  }
        			window.location.href = "${contextPath}/member/closingCancleDetail.do?workOrderNumber="+ary;
        	  }
        }

      </script>