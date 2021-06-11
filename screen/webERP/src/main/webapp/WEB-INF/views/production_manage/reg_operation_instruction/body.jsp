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
            /* position: absolute; ĭ ���߶� ����*/
            top: 25%;
            left: 5%;
        }
         #searchForm {
            height: 100%;
            margin: 0;
            padding:0;
            text-align: center;
        }
        /* �����̳� ��Ÿ�Ϻ� */
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
                        <td>�����</td>
                        <td style="width: 80px;"><input type="text" value="${param.itemNumber }" style="width: 100%; background-color: yellow;"/></td>
                        <td colspan="3"><input type="text" value="${param.itemName }" disabled style="width: 100%;"/></td>
                        <td><a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></td> 
    
                        <td colspan="5" style="width: 80px;">�μ�</td>
                        <td style="width: 80px;"><input type="text" value="${param.departmentCode }" style="width: 100%; background-color: yellow;"/></td>
                        <td><input type="text" value="${param.departmentName }" disabled/></td>
                        <td><a href="javascript:search2()"><i class="fas fa-search" style="color: blue;"></i></td>
                        
                    </tr>
                    
                    <tr>
                        <td>���ñⰣ</td>
                        <td colspan="2" style="width: 50px;"><input type="date"  id='searchStartDate' style="width: 100%;"/></td>
                        <td>~</td>
                        <td ><input type="date" id='searchEndDate' style="width: 100%;"/></td>
                        <td></td>
    
                        <td colspan="5" style="width: 80px;">���</td>
                        <td style="width: 80px;"><input type="text" style="width: 100%; background-color: yellow;"/></td>
                        <td><input type="text" name="" disabled/></td>
                        <td > <i class="fas fa-search" style="color: blue;"></i></td>
                        <td>
                            <input type="button" value="�����ȹ��ȸ" style="padding: 5px;" onClick="searchPlan()"></input>
                        </td>
                    </tr>
                </table>
                </form>
        </container1>
        <container2 id= contents2>
            <div id="workOrderInfo">
	         <form id="dataForm" commandName="OperationRegistVO">
                <table id="workOrderTable">
                    <thead>
                        <td><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
                        <td>�۾����ù�ȣ</td>
                        <td>������</td>
                        <td>������</td>
                        <td>ǰ��</td>
                        <td>ǰ��</td>
                        <td>�԰�</td>
                        <td>����</td>
                        <td>���ü���</td>
                        <td>����</td>
                        <td>�˻�</td>
                        <td>���</td>
                    </thead>
                    <!-- �׽�Ʈ�� ������, ���� ǥ�������� �����ʿ� -->
                    <tbody>
                    	<c:forEach var="info" items="${infoList}" varStatus="status">   
                     <tr id="updateData" align="center">
                     	<td><input type="checkbox" value = "check1" name="content"/></td>
                     	<td><input type="text" name="OperationRegistVO[${status.index }].workOrderNumber" value="${info.workOrderNumber}" /></td>
                     	<td><input type="date" name="OperationRegistVO[${status.index }].instructiondate" value="${info.instructionDate}" readonly /></td>
                     	<td><input type="date" name="OperationRegistVO[${status.index }].dueDate" value="${info.dueDate}" /></td>
                     	<td><input tpye="text" name="OperationRegistVO[${status.index }].itemCode" value="${info.itemCode }" /></td>
                     	<td><input type="text" name="OperationRegistVO[${status.index }].itemName" value="${info.itemName}" /></td>
                     	<td><input type="text" name="OperationRegistVO[${status.index }].standard" value="${info.standard}" /></td>
                     	<td><input type="text" name="OperationRegistVO[${status.index }].inventoryUnit" value="${info.inventoryUnit}" /></td>
                     	<td><input type="text" name="OperationRegistVO[${status.index }].indicated" value="${info.indicated}" /></td>
                     	<td style="width:13px;"><input type="text" name="OperationRegistVO[${status.index }].status" value="${info.status}" /></td>
                     	<td style="width:20px;"><input type="text" name="OperationRegistVO[${status.index }].inspection value="${info.inspection}" /></td>
                     	<td><input type="text" name="OperationRegistVO[${status.index }].note" value="${info.note}" /></td>
                     </tr>
                     </c:forEach>
                     <tr>
                        <td><input type="checkbox" value = "check1" name="content"/></td>
                        <td><input type="text" id="workOrderNumber"/></td>
                        <td><input type="date" id="instructionDate" value="${param.workDate }"/></td>
                        <td><input type="date" id="dueDate" value="${param.workDate }"/></td>
                        <td><input type="text" id="itemCode" value="${param.itemCode }"/></td>
                        <td><input type="text" id="itemName" value="${param.itemName }"/></td>
                        <td><input type="text" id="standard" value="${param.standard }"/></td>
                        <td><input type="text" id="inventoryUnit" value="${param.inventoryUnit }"/></td>
                        <td><input type="text" id="indicated" value="${param.quantity }"/></td>
                        <td style="width:13px;"><input type="text" id="status" readonly/></td>
                        <td style="width:20px;"><input type="text" id="inspection" readonly/></td>
                        <td><input type="text" id="note" value="${param.note }"/></td>
                     </tr>
                    </tbody>
                </table>
                </form>
            </div>
        </container2>
      
</body>
</html>
 <script>
 /* input date�� ���� ��¥ �⺻�� ����*/
 document.getElementById('searchStartDate').value = new Date().toISOString().substring(0,10);;
 document.getElementById('searchEndDate').value = new Date().toISOString().substring(0,10);;
 
 /* �˻��� date onChange �Լ� ���� */
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
      
      /* ��ȸ��ư Ŭ���� ��� ���� */
      view_button.onclick = function(){
		  if(startDate>endDate){
			  alert("���ñⰣ �������� �����Ϻ��� ������ �����ϴ�.");
		  } else{
			  
    	  const URLSearch = new URLSearchParams(location.search);
		  URLSearch.set('startDate', startDate);
		  URLSearch.set('endDate', endDate);
		  const newParam = URLSearch.toString();

		  window.open(location.pathname + '?' + newParam, '_self');
		  }
  	}
      
      </script>