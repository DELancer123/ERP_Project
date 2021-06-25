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
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
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
        
        /* 컨테이너 스타일부 */
        #workOrderDetail{
            overflow: scroll;
            height: 100%;
        }
        #workOrderInfo {
            width: 100%;
            overflow: scroll;
            height: 100%;
        }
        /* 컨테이너 스타일부 종료 */
        

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
                            <input type="button" value="자재사용" onClick="materialUse();" style="padding: 5px; margin-left: 30px;"></input>
                        </td>
                    </tr>
                </table>
                </form>
        </container1>
        <container2 id="contents2">
             <div id="workOrderDetail">
              <form id="dataForm" mehtod="get" commandName="ListVO">
                <table id="workOrderDetailTable">
                    <thead> 
                        <td><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
                        <td>작업지시번호</td>
                        <td>자재출고상태</td>
                        <td>작업장</td>
                        <td>지시일</td>
                        <td>납기일</td>
                        <td>품번</td>
                        <td>품명</td>
                        <td>규격</td>
                        <td>단위</td>
                        <td>지시수량</td>
                        <td>실적수량</td>
                        <td>실적잔량</td>
                        <td>상태</td>
                        <td>작업구분</td>
                        <td>검사</td>
                        <td>생산설비</td>
                        <td>작업팀</td>
                        <td>비고</td>
                    </thead>
                    <!-- 테스트용 데이터, 추후 표현식으로 수정필요 -->
                    <tbody>
                        <c:forEach var="info" items="${infoList}" varStatus="status">   
                     <tr id="updateData" align="center">
                     	<td><input type="checkbox" name="content" value="${info.workOrderNumber }" /></td>
                     	<td><input type="text" name="ListVO[${status.index }].workOrderNumber" value="${info.workOrderNumber}" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].materialstatus" value="${info.materialstatus}" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].workplaceCode" value="${info.workplaceCode}" readonly /></td>
                     	<td><input type="date" name="ListVO[${status.index }].instructiondate" value="${info.instructionDate}" readonly /></td>
                     	<td><input type="date" name="ListVO[${status.index }].dueDate" value="${info.dueDate}" readonly/></td>
                     	<td><input type="text" name="ListVO[${status.index }].itemCode" value="${info.itemCode }" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].itemName" value="${info.itemName}" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].standard" value="${info.standard}" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].inventoryUnit" value="${info.inventoryUnit}" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].indicated" value="${info.indicated}" readonly/></td>
                     	<td><input type="text" name="ListVO[${status.index }].sumPerformanceQuantity" value="${info.sumPerformanceQuantity}" readonly/></td>
                     	<td><input type="text" name="ListVO[${status.index }].remainingPerformance" value="${info.remainingPerformance}" readonly/></td>
                     	<td style="width:13px;"><input type="text" name="ListVO[${status.index }].status" value="${info.status}" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].workSortation" value="${info.workSortation}" readonly/></td>
                     	<td style="width:20px;"><input type="text" name="ListVO[${status.index }].inspection" value="${info.inspection}" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].productionFacility" value="${info.productionFacility}" readonly/></td>
                        <td><input type="text" name="ListVO[${status.index }].taskTeam" value="${info.taskTeam}" readonly/></td>
                     	<td><input type="text" name="ListVO[${status.index }].note" value="${info.note}" readonly /></td>
                     </tr>
                     </c:forEach>
                    </tbody>
                </table>
                </form>
             </div>
        </container2>
        
        <container3 id="contents3">
            <div id="workOrderInfo">
            <form id="dataForm1" mehtod="get" commandName="DetailVO">
                <table id="workOrderTable">
                    <thead>
                        <td><input type="checkbox" name="content2" onclick="selectAll2(this)"/></td>
                        <td>작업실적번호</td>
                        <td>자재사용유무</td>
                        <td>실적일</td>
                        <td>공정</td>
                        <td>작업장</td>
                        <td>구분</td>
                        <td>실적수량</td>
                        <td>검사</td>
                        <td>비고</td>
                        <td>작업지시번호</td>
                        <td>입고창고</td>
                    </thead>
                    <!-- 테스트용 데이터, 추후 표현식으로 수정필요 -->
                    <tbody>
                        <c:forEach var="detail" items="${detailList}" varStatus="status">
  					 <tr>
  					 	<td><input type="checkbox" value="${detail.opNumber }" name="content2"/></td>
                        <td><input type="text" name="DetailVO[${status.index }].OPNumber" value="${detail.opNumber }" readonly /></td>
                        <td><input type="text" name="DetailVO[${status.index }].materialUseStatus" value="${detail.materialUseStatus }" readonly /></td>
                        <td><input type="date" name="DetailVO[${status.index }].performanceDate" value="${detail.performanceDate }" /></td>
                        <td><input type="text" name="DetailVO[${status.index }].processCode" value="${detail.processCode }" /></td>
                        <td><input type="text" name="DetailVO[${status.index }].workplaceCode" value="${detail.workplaceCode }" /></td>
                        <td><input type="text" name="DetailVO[${status.index }].sortation" value="${detail.sortation}"/></td>
                        <td><input type="text" name="DetailVO[${status.index }].performanceQuantity" value="${detail.performanceQuantity}"/></td>
                        <td><input type="text" name="DetailVO[${status.index }].inspection" value="${detail.inspection}"/></td>                      
                        <td><input type="text" name="DetailVO[${status.index }].note" value="${detail.note}"/></td>
                        <td><input type="text" name="DetailVO[${status.index }].workOrderNumber" value="${param.searchNumber}" /></td>
                        <td><input type="text" name="DetailVO[${status.index }].houseCode" value="${detail.houseCode}"/></td>
  					 </tr>
                    </c:forEach>
                    <tr>
                        <td><input type="checkbox" value = "check" id="check" name="content2"/></td>
                        <td><input type="text" id="opNumber" name="DetailVO[${fn:length(detailList)}].opNumber" value="${param.opNumber }" readonly /></td>
                        <td><input type="text" id="materialUseStatus" name="DetailVO[${fn:length(detailList)}].materialUseStatus" value="${param.materialUseStatus }" readonly /></td>
                        <td><input type="date" id="performanceDate" name="DetailVO[${fn:length(detailList)}].performanceDate" value="${param.performanceDate }"/></td>
                        <td><input type="text" id="processCode" name="DetailVO[${fn:length(detailList)}].processCode" value="${param.processName }" ondblclick="processCodeSearch()"/></td>
                        <td><input type="text" id="workplaceCode" name="DetailVO[${fn:length(detailList)}].workplaceCode" value="${param.workplaceCode }"/></td>
                        <td><input type="text" id="sortation" name="DetailVO[${fn:length(detailList)}].sortation" value="${param.sortation }"/></td>
                        <td><input type="text" id="performanceQuantity" name="DetailVO[${fn:length(detailList)}].performanceQuantity" value="${param.performanceQuantity }"/></td>
                        <td><input type="text" id="inspection" name="DetailVO[${fn:length(detailList)}].inspection" value="${param.inspection }"/></td>
                        <td><input type="text" id="note" name="DetailVO[${fn:length(detailList)}].note" value="${param.note }"/></td>
                        <td><input type="text" id="workOrderNumber" name="DetailVO[${fn:length(detailList)}].workOrderNumber" value="${param.searchNumber }"/></td>
                        <td><input type="text" id="houseCode" name="DetailVO[${fn:length(detailList)}].houseCode" ondblclick="houseCodeSearch()" value="${param.houseCode }" /></td>
                    </tr>
                    </tbody>
                </table>
                </form>
            </div>
            <!-- 컨테이너 출력 종료 -->
            
        </container3>
      
</body>
</html>

<script>
/* input date의 현재 날짜 기본값 설정*/
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
  		    document.getElementById('dataForm1').appendChild(linkPath);
            document.getElementById('dataForm1').action = "${contextPath}/member/addRegistOperationPerformanceInfoDetail.do";
  			document.getElementById('dataForm1').submit();  
		
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
        
        
        
        function materialUse() {
        	var item = document.getElementsByName("content2").length;
        	  var no = "";
        	  var ary = [];
        	  for(var i=0; i<item;i++){
        		  if(document.getElementsByName("content2")[i].checked==true){
        			  no = document.getElementsByName("content2")[i].value;
        			  ary.push(no);
        		  	}
        		  }
        	  
        		window.location.href = "${contextPath}/member/materialUse.do?opNumber="+ary;
        
        }
	/*  팝업 조회부*/
  
 	function houseCodeSearch(){
 			openWindowPop('http://localhost:8090/webERP/member/houseCodeSearchPop.do','houseCodeSearch');
		}
	
 	function processCodeSearch(){
			openWindowPop('http://localhost:8090/webERP/member/processCodeSearchPop.do','processCodeSearch');
	}
      </script>