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
            /* position: absolute; ĭ ���߶� ����*/
            top: 25%;
            left: 5%;
        }
        #searchForm {
            height: 100%;
            margin: 10px 20px;
            padding:0;
            text-align: center;
        }
        
        /* �����̳� ��Ÿ�Ϻ� */
        #workOrderDetail{
            overflow: scroll;
            height: 100%;
        }
        #workOrderInfo {
            width: 100%;
            overflow: scroll;
            height: 90%;
        }
        /* �����̳� ��Ÿ�Ϻ� ���� */
        /* ��º� ��Ÿ�Ϻ� */
        #detailPrint1{
            border: 1px solid;
            height: 10%;
        }

</style>
</head>
<body>
<container1 id = contents1>
            <form id="searchForm">
                <table class="con1_search">
                   <tr>
                        <td>�����</td>
                        <td style="width: 80px;"><input type="text" value="${param.factoryNumber }" style="width: 100%; background-color: yellow;"/></td>
                        <td colspan="3"><input type="text" value="${param.factoryName }" disabled style="width: 100%;"/></td>
                        <td><a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></td> 
    
                        <td colspan="5" style="width: 80px;">�μ�</td>
                        <td style="width: 80px;"><input type="text" value="${param.departmentCode }" style="width: 100%; background-color: yellow;"/></td>
                        <td><input type="text" value="${param.departmentName }" disabled/></td>
                        <td><a href="javascript:search2()"><i class="fas fa-search" style="color: blue;"></i></td>
                        
                    </tr>
                    
                    <tr>
                        <td>������</td>
                        <td colspan="2" style="width: 50px;"><input type="date"  id='searchStartDate' style="width: 100%;"/></td>
                        <td>~</td>
                        <td ><input type="date" id='searchEndDate' style="width: 100%;"/></td>
                        <td></td>
    
                        <td colspan="5" style="width: 80px;">���</td>
                        <td style="width: 80px;"><input type="text" style="width: 100%; background-color: yellow;"/></td>
                        <td><input type="text" name="" disabled/></td>
                        <td > <i class="fas fa-search" style="color: blue;"></i></td>

                        <td>
                            <input type="button" value="������" onClick="materialUse();" style="padding: 5px; margin-left: 30px;"></input>
                        </td>
                        <td>
                            <input type="button" value="�����ڿ����" style="padding: 5px;"></input>
                        </td>
                        <td>
                            <input type="button" value="�˻���" style="padding: 5px;"></input>
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
                        <td>�۾����ù�ȣ</td>
                        <td>����������</td>
                        <td>�۾���</td>
                        <td>������</td>
                        <td>������</td>
                        <td>ǰ��</td>
                        <td>ǰ��</td>
                        <td>�԰�</td>
                        <td>����</td>
                        <td>���ü���</td>
                        <td>��������</td>
                        <td>�����ܷ�</td>
                        <td>����</td>
                        <td>�۾�����</td>
                        <td>�˻�</td>
                        <td>���꼳��</td>
                        <td>�۾���</td>
                        <td>���</td>
                    </thead>
                    <!-- �׽�Ʈ�� ������, ���� ǥ�������� �����ʿ� -->
                    <tbody>
                        <c:forEach var="info" items="${infoList}" varStatus="status">   
                     <tr id="updateData" align="center">
                     	<td><input type="checkbox" name="content" value="${info.workOrderNumber }" /></td>
                     	<td><input type="text" name="ListVO[${status.index }].workOrderNumber" value="${info.workOrderNumber}" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].materialstatus" value="${info.materialstatus}" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].workplaceCode" value="${info.workplaceCode}" readonly /></td>
                     	<td><input type="date" name="ListVO[${status.index }].instructiondate" value="${info.instructionDate}" readonly /></td>
                     	<td><input type="date" name="ListVO[${status.index }].dueDate" value="${info.dueDate}" /></td>
                     	<td><input type="text" name="ListVO[${status.index }].itemCode" value="${info.itemCode }" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].itemName" value="${info.itemName}" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].standard" value="${info.standard}" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].inventoryUnit" value="${info.inventoryUnit}" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].indicated" value="${info.indicated}" /></td>
                     	<td><input type="text" name="ListVO[${status.index }].sumPerformanceQuantity" value="${info.sumPerformanceQuantity}" /></td>
                     	<td><input type="text" name="ListVO[${status.index }].remainingPerformance" value="${info.remainingPerformance}" /></td>
                     	<td style="width:13px;"><input type="text" name="ListVO[${status.index }].status" value="${info.status}" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].workSortation" value="${info.workSortation}" /></td>
                     	<td style="width:20px;"><input type="text" name="ListVO[${status.index }].inspection" value="${info.inspection}" readonly /></td>
                     	<td><input type="text" name="ListVO[${status.index }].productionFacility" value="${info.productionFacility}" readonly/></td>
                        <td><input type="text" name="ListVO[${status.index }].taskTeam" value="${info.taskTeam}" readonly/></td>
                     	<td><input type="text" name="ListVO[${status.index }].note" value="${info.note}" readonly /></td>
                     </tr>
                     </c:forEach>
                     <tr>
                        <td><input type="checkbox" value = "check1" name="content"/></td>
                        <td><input type="text" id="workOrderNumber" name="ListVO[${fn:length(infoList)}].workOrderNumber" readonly /></td>
                        <td><input type="text" id="materialstatus" name="ListVO[${fn:length(infoList)}].materialstatus" readonly /></td>
                        <td><input type="text" id="workplaceCode" name="ListVO[${fn:length(infoList)}].workplaceCode" readonly /></td>
                        <td><input type="date" id="instructionDate" name="ListVO[${fn:length(infoList)}].instructionDate" value="${param.workDate }"/></td>
                        <td><input type="date" id="dueDate" name="ListVO[${fn:length(infoList)}].dueDate" value="${param.workDate }"/></td>
                        <td><input type="text" name="ListVO[${fn:length(infoList)}].itemCode" value="${param.itemCode }"/></td>
                        <td><input type="text" name="ListVO[${fn:length(infoList)}].itemName" value="${param.itemName }"/></td>
                        <td><input type="text" name="ListVO[${fn:length(infoList)}].standard" value="${param.standard }"/></td>
                        <td><input type="text" name="ListVO[${fn:length(infoList)}].inventoryUnit" value="${param.inventoryUnit }"/></td>
                        <td><input type="text" id="indicated" name="ListVO[${fn:length(infoList)}].indicated" value="${param.indicated }"/></td>
                        <td><input type="text" id="sumPerformanceQuantity" name="ListVO[${fn:length(infoList)}].sumPerformanceQuantity" value="${param.sumPerformanceQuantity }"/></td>
                        <td><input type="text" id="remainingPerformance" name="ListVO[${fn:length(infoList)}].remainingPerformance" value="${param.remainingPerformance }"/></td>
                        <td style="width:13px;"><input type="text" name="ListVO[${fn:length(infoList)}].status" readonly/></td>
                        <td style="width:13px;"><input type="text" name="ListVO[${fn:length(infoList)}].workSortation" readonly/></td>
                        <td style="width:20px;"><input type="text" name="ListVO[${fn:length(infoList)}].inspection" readonly/></td>
                        <td style="width:20px;"><input type="text" name="ListVO[${fn:length(infoList)}].productionFacility" readonly/></td>
                        <td style="width:20px;"><input type="text" name="ListVO[${fn:length(infoList)}].taskTeam" readonly/></td>
                        <td><input type="text" name="ListVO[${fn:length(infoList)}].note" value="${param.note }"/></td>
                       
                     </tr>
                    </tbody>
                </table>
                </form>
             </div>
        </container2>
        <
        <container3 id="contents3">
            <div id="workOrderInfo">
                <table id="workOrderTable">
                    <thead>
                        <td><input type="checkbox" name="content2" onclick="selectAll2(this)"/></td>
                        <td>�۾�������ȣ</td>
                        <td>����������</td>
                        <td>������</td>
                        <td>����</td>
                        <td>�۾���</td>
                        <td>����</td>
                        <td>��������</td>
                        <td>�˻�</td>
                        <td>���</td>
                    </thead>
                    <!-- �׽�Ʈ�� ������, ���� ǥ�������� �����ʿ� -->
                    <tbody>
                        <c:forEach var="detail" items="${detailList}" varStatus="status">
  					 <tr>
  					 	<td><input type="checkbox" value="${detail.OPNumber }" name="content2"/></td>
                        <td><input type="text" name="DetailVO[${status.index }].OPNumber" value="${detail.OPNumber }" readonly /></td>
                        <td><input type="text" name="DetailVO[${status.index }].materialUseStatus" value="${detail.materialUseStatus }" readonly /></td>
                        <td><input type="date" name="DetailVO[${status.index }].performanceDate" value="${detail.performanceDate }" readonly /></td>
                        <td><input type="text" name="DetailVO[${status.index }].processCode" value="${detail.processCode }" readonly /></td>
                        <td><input type="text" name="DetailVO[${status.index }].workplaceCode" value="${detail.workplaceCode }" /></td>
                        <td><input type="text" name="DetailVO[${status.index }].sortation" value="${detail.sortation}"/></td>
                        <td><input type="text" name="DetailVO[${status.index }].performanceQuantity" value="${detail.performanceQuantity}"/></td>
                        <td><input type="text" name="DetailVO[${status.index }].inspection" value="${detail.inspection}"/></td>                      
                        <td><input type="text" name="DetailVO[${status.index }].note" value="${detail.note}"/></td>
  					 </tr>
                    </c:forEach>
                    <tr>
                        <td><input type="checkbox" value = "check" id="check" name="content2"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>
                        <td><input type="date"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>                        
                        <td><input type="text"/></td>
                    </tr>
                    </tbody>
                </table>
            </div>
            <!-- �����̳� ��� ���� -->
            <!-- ��º� -->
            
            <div id="detailPrint1">
                �԰� â��<input type="text" name="cargoName" style="width: 75px;"><a href="#" onclick="showPopup();"> <i class="fas fa-search"></i></a><input type="text" name="printCargoName" disabled>
                ���۾�<select>
                    <option>��</option>
                    <option>��</option>
                </select>
            </div>
        </container3>
      
</body>
</html>

<script>
/* input date�� ���� ��¥ �⺻�� ����*/
document.getElementById('searchStartDate').value = new Date().toISOString().substring(0,10);;
document.getElementById('searchEndDate').value = new Date().toISOString().substring(0,10);;

 /* �˻��� date onChange �Լ� ���� */
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
      
      /* ��ȸ��ư Ŭ���� ��� ���� */
      view_button.onclick = function(){
		 if(startDate>endDate){
			  alert("���ñⰣ �������� �����Ϻ��� ������ �����ϴ�.");
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
      
      /* ���� ��ư ��� ���� */
      
        function newRow(){
          // dao���� ����
    	 
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
        
        
        
        function materialUse() {
        	var item = document.getElementsByName("content").length;
        	  var no = "";
        	  var ary = [];
        	  for(var i=0; i<item;i++){
        		  if(document.getElementsByName("content")[i].checked==true){
        			  no = document.getElementsByName("content")[i].value;
        			  ary.push(no);
        		  }
        			window.location.href = "${contextPath}/member/materialUse.do?OPNumber="+ary;
        	  }
        }
        

      </script>