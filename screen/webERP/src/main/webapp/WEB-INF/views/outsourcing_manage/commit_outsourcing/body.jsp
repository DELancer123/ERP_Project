<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <c:forEach var="productionPlanView" items="${productionPlanView}" >     
 	<c:set var="parentItemCode;" value="${productionPlanView.item_Code }"/>
 	<c:set var="itemName" value="${productionPlanView.item_Name }"/>
 	<c:set var="standard" value="${productionPlanView.standard }"/>
 	<c:set var="inventoryUnit;" value="${productionPlanView.inventory_Unit}"/>

 </c:forEach>
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
            height: 30%;
            border: 1px solid black;
            z-index: 1;
        }
        #contents3{
            position: absolute;
            right: 0;
            top:55%;
            width: 85%;
            height: 40%;
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

        /* ���̺� css */
        #MDTable,#MDDetailTable{
            width: 100%;
            text-align: center;
            border: 1px solid black;
        }
        
        /* �����̳� ��Ʈ */
        #MDDetail {
            width: 100%;
            height: 100%;
            overflow: scroll;
        }
        
        #MDInfo{
            width: 100%;
            height: 95%;
            overflow: scroll;
        }

        #pdcInfo::after{
            content: "";
            display: block;
            clear: both;
        }

        /* �հ� ��º� */
        #resultWindow{
            height: 5%;
            background-color: gray;
            line-height: 5%;
        }

</style>
</head>
<body>
<container1 id = contents1>
            <!-- ��ȸ�˻� �� -->
            <form id="searchForm">
                <table class="con1_search">
                    <tr>
                        <td>�����</td>
                        <td style="width: 80px;"><input type="text" style="width: 100%; background-color: yellow;"/></td>
                        <td colspan="3"><input type="text" name="" disabled style="width: 100%;"/></td>
                        <td> <i class="fas fa-search" style="color: blue;"></i></td> 
    
                        <td colspan="4" style="width: 80px;">�μ�</td>
                        <td style="width: 80px;"><input type="text" style="width: 100%; background-color: yellow;"/></td>
                        <td><input type="text" name="" disabled/></td>
                        <td> <i class="fas fa-search" style="color: blue;"></i></td>
                        
                    </tr>
                    
                    <tr>
                        <td>����ó</td>
                        <td style="width: 50px;"><input type="text" style="width: 100%; background-color: yellow;"/></td>
                        <td colspan="3"><input type="text" style="width: 100%;"/></td>
                        <td> <i class="fas fa-search" style="color: blue;"></i></td>
    
                        <td colspan="4" style="width: 80px;">���</td>
                        <td style="width: 80px;"><input type="text" style="width: 100%; background-color: yellow;"/></td>
                        <td><input type="text" name="" disabled/></td>
                        <td > <i class="fas fa-search" style="color: blue;"></i></td>

                        <td>
                            <input type="button" value="�������" style="padding: 5px; margin-left: 30px;"></input>
                        </td>
                        <td>
                            <input type="button" value="���" style="padding: 5px;"></input>
                        </td>
                        <td>
                            <input type="button" value="Ȯ��" style="padding: 5px;"></input>
                        </td>
                    </tr>
                </table>
            </form>
        </container1>

        <container2 id="contents2">
            <!-- �����Ϻ� -->
            <div id="MDDetail">
                <table id="MDDetailTable">
                    <thead>
                        <td><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
                        <td>�������ù�ȣ</td>
                        <td>����������</td>
                        <td>������</td>
                        <td>������</td>
                        <td>ǰ��</td>
                        <td>ǰ��</td>
                        <td>�԰�</td>
                        <td>����</td>
                        <td>���ü���</td>
                        <td>�ܰ�</td>
                        <td>�ݾ�</td>
                        <td>����</td>
                        <td>�˻�</td>
                        <td>���</td>
                    </thead>
                    <!-- �׽�Ʈ�� ������, ���� ǥ�������� �����ʿ� -->
                    <tbody>
 <c:forEach var="out" items="${outsourcingView}" varStatus="status" >     
   <tr align="center">
   	  <td><input type="checkbox" name="content" value="${out.workOrderNumber}"/></td>
   	  <td><input type="text" name="ListVO[${status.index}].workOrderNumber" value = '${out.workOrderNumber}' readonly/></td>
   	  <td><input type="date" name="ListVO[${status.index}].instructionDate" value = '${out.instructionDate}'/></td>
   	  <td><input type="date" name="ListVO[${status.index}].dueDate" value = '${out.dueDate}'/></td>
   	  <td><input type="text" name="ListVO[${status.index}].itemCode" value = '${out.itemCode}' ondblclick="search2()"/></td>
   	  <td><input type="text" name="ListVO[${status.index}].itemName" value = '${out.itemName}' readonly/></td>
   	  <td><input type="text" name="ListVO[${status.index}].standard" value = '${out.standard}' readonly/></td>
   	  <td><input type="text" name="ListVO[${status.index}].inventoryUnit" value = '${out.inventoryUnit}' readonly/></td>
   	  <td><input type="text" name="ListVO[${status.index}].indicatedQuantity" value = '${out.indicatedQuantity}'/></td>
   	  <td><input type="text" name="ListVO[${status.index}].unitPrice" value = '${out.unitPrice}'/></td>
   	  <td><input type="text" value = '${out.indicatedQuantity*out.unitPrice}' readonly/></td>
   	  <td><input type="text" name="ListVO[${status.index}].status" value = '${out.status}'/></td>
   	  <td><input type="text" name="ListVO[${status.index}].inspection" value = '${out.inspection}'/></td>
   	  <td><input type="text" name="ListVO[${status.index}].note" value = '${out.note}'/>   </td>
   	  <td><input type="text" name="ListVO[${status.index}].productionPlanCode" value = '${out.productionPlanCode}'/>   </td>
    </tr>
    </c:forEach> 

    <tr align="center">
     <td><input type="checkbox" value = "check1" name="content"/></td>
    	<td><input type="text" name="ListVO[${fn:length(outsourcingView) }].workOrderNumber" readonly/></td>
    	<td><input type="date" id = "instructionDate" name="ListVO[${fn:length(outsourcingView) }].instructionDate"  value='${param.workDate }'/></td>
    	<td><input type="date" id = "dueDate" name="ListVO[${fn:length(outsourcingView) }].dueDate"  value='${param.workDate }'/></td>
    	<td><input type="text" name="ListVO[${fn:length(outsourcingView) }].itemCode" value='${param.itemCode }' ondblclick="search2()"/></td>
    	<td><input type="text" name="ListVO[${fn:length(outsourcingView) }].itemName" value='${param.itemName }' readonly/></td>
    	<td><input type="text" name="ListVO[${fn:length(outsourcingView) }].standard" value='${param.standard }' readonly/></td>
    	<td><input type="text" name="ListVO[${fn:length(outsourcingView) }].inventoryUnit" value='${param.inventoryUnit }' readonly/></td>
    	<td><input type="text" id = "indicatedQuantity" name="ListVO[${fn:length(outsourcingView) }].indicatedQuantity"  value='${param.quantity }'/></td>
    	<td><input type="text" id = "unitPrice" name="ListVO[${fn:length(outsourcingView) }].unitPrice" /></td>
    	<td><input type="text" id = "price" readonly/></td>
    	<td><input type="text" name="ListVO[${fn:length(outsourcingView) }].status" readonly/></td>
    	<td><input type="text" name="ListVO[${fn:length(outsourcingView) }].inspection" readonly/></td>
    	<td><input type="text" name="ListVO[${fn:length(outsourcingView) }].note" value='${param.note }'/></td>
    	<td><input type="text" name="ListVO[${fn:length(outsourcingView) }].productionPlanCode" value='${param.productionPlanCode}' disabled/></td>
    </tr>

                    </tbody>
                </table>
            </div>
                <!-- �����Ϻ� ���� -->
            </container2>
            <container3 id="contents3">
                <div id="MDInfo">
                    <table id="MDTable">
                        <thead>
                            <td><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
                            <td>û����</td>
                            <td>ǰ��</td>
                            <td>ǰ��</td>
                            <td>�԰�</td>
                            <td>����</td>
                            <td>���̼���</td>
                            <td>Ȯ������</td>
                            <td>����</td>
                            <td>���ִܰ�</td>
                            <td>�ݾ�</td>
                            <td>���</td>
                        </thead>
                        <!-- �׽�Ʈ�� ������, ���� ǥ�������� �����ʿ� -->
                        <tbody>
                            <td><input type="checkbox" value = "check1" id="check" name="content"/></td>
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
                    <!-- ��º� 1 -->
                </div>
                 <!-- �հ� ��º� -->
                <div id="resultWindow">
                    �� �� <span style="margin-left: 100px;"></span>���̼��� <input type="text"><span style="margin-left: 100px;">Ȯ������ <input type="text"></span><span style="margin-left: 100px;">�ݾ� <input type="text"></span>
                </div>
                    <!-- �հ� ��º� ���� -->
        </container3>
      
</body>
</html>