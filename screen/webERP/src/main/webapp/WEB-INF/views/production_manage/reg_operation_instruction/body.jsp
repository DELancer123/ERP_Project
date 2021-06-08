<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"    
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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
                        <td>지시기간</td>
                        <td colspan="2" style="width: 50px;"><input type="date" style="width: 100%;"/></td>
                        <td>~</td>
                        <td ><input type="date" style="width: 100%;"/></td>
                        <td></td>
    
                        <td colspan="5" style="width: 80px;">사원</td>
                        <td style="width: 80px;"><input type="text" style="width: 100%; background-color: yellow;"/></td>
                        <td><input type="text" name="" disabled/></td>
                        <td > <i class="fas fa-search" style="color: blue;"></i></td>
                        <td>
                            <input type="button" value="생산계획조회" style="padding: 5px;" onClick="searchPlan()"></input>
                        </td>
                    </tr>
                </table>
                </form>
        </container1>
        <container2 id= contents2>
            <div id="workOrderInfo">
                <table id="workOrderTable">
                    <thead>
                        <td><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
                        <td>작업지시번호</td>
                        <td>지시일</td>
                        <td>납기일</td>
                        <td>품번</td>
                        <td>품명</td>
                        <td>규격</td>
                        <td>단위</td>
                        <td>지시수량</td>
                        <td>상태</td>
                        <td>검사</td>
                        <td>비고</td>
                    </thead>
                    <!-- 테스트용 데이터, 추후 표현식으로 수정필요 -->
                    <tbody>
                    	<c:forEach var="info" items="${infoList}" >   
                     <tr>
                     	<td><input type="checkbox" value = "check1" id="check" name="content"/></td>
                     	<td>${info.workOrderNumber}</td>
                     	<td><input type="date" value="${info.instructionDate}"></td>
                     	<td><input type="date" value="${info.dueDate}"></td>
                     	<td>${info.itemCode }</td>
                     	<td>${info.itemName}</td>
                     	<td>${info.standard}</td>
                     	<td>${info.inventoryUnit}</td>
                     	<td>${info.indicated}</td>
                     	<td id="status">${info.status}</td>
                     	<td>
                     		<select id="inspectionSelector" name="inspectionSelect">
                     		<option value="" selected disabled hidden>${info.inspection}</option>
                     		<option value="검사">검사</option>
                     		<option value="비검사">비검사</option>
                     		</select>
                     	</td>
                     	<td>${info.note}</td>
                     </tr>
                     </c:forEach>
                     <tr>
                        <td><input type="checkbox" value = "check1" id="check" name="content"/></td>
                        <td><input type="text" name="workOrderNumber"/></td>
                        <td><input type="date" name="instructionDate"/></td>
                        <td><input type="date" name="dueDate"/></td>
                        <td><input type="text" name="itemCode"/></td>
                        <td><input type="text" name="itemName"/></td>
                        <td><input type="text" name="standard"/></td>
                        <td><input type="text" name="inventoryUnit"/></td>
                        <td><input type="text" name="indicated"/></td>
                        <td><input type="text" name="status"/></td>
                        <td><input type="text" name="inspection"/></td>
                        <td><input type="text" name="note"/></td>
                     </tr>
                    </tbody>
                </table>
            </div>
        </container2>
      
</body>
</html>
 <script>
      function search1(){  
    	      	openWindowPop('http://localhost:8090/webERP/member/factorySearch.do','factorySearch');  	  
      }
      function search2(){  
	      	openWindowPop('http://localhost:8090/webERP/member/departmentSearch.do','departmentSearch');  	  
		}
      function searchPlan(){
    	  openWindowPop('http://localhost:8090/webERP/member/productionPlanSearch.do','productionPlanSearch');
      }
      </script>