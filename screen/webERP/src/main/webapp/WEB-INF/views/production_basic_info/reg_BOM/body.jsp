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
            /* position: absolute; ĭ ���߶� ����*/
            top: 25%;
            left: 5%;
        }
         #searchForm {
            height: 100%;
            margin: 25px 10px;
        }
        /* �����̳� ��Ÿ�Ϻ� */
        #workOrderInfo {
            overflow: scroll;
            height: 97%;
            width: 100%;
        }
        #workOrderTable{
       		width:100%;
       	}
        /* �հ� ��º� */
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


</style>
</head>
<body>
<container1 id = contents1>
            <form id="searchForm">
                <table>
                    <tr>
                        <td>
                            ��ǰ��
                        </td>
                        <Td>
                            <input type="text" name="factory" value='${param.itemNumber }' style="width: 120px; background-color: yellow;">
                        </Td>
                        <td>
                            <a href="javascript:search1('1')"><i class="fas fa-search" style="color: blue;"></i></a>
                        </td>
                        <td>
                            <input type="text" name="ckfactory" value='${param.itemName }' style="width: 120px;" disabled>
                        </td>
                        <!-- ��ǰ�� �԰� -->
                        <td>
                            <input type="text" style="width: 150px; background-color: skyblue;" disabled>
                        </td>
                        <!-- ��ǰ�� ���� -->
                        <td>
                            <input type="text" style="width: 120px; background-color: skyblue;" disabled>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            ��������
                        </td>
                        <td colspan="2">
                            <input type="date" name="department" style="width: 120px; background-color: yellow;"><a href="#" onclick="showPopup();"></a>
                        </td>
                        
                    </tr>
                </table>
                </form>
                <div id="button">
                    <input type="button" value="BOM ����" style="padding: 5px; margin-left: 40px;"></input>
                    
                    <input type="button" value="�ϰ����纯��" style="padding: 5px;"></input>
                </div>
                
        </container1>
        <container2 id= contents2>
            <div id="workOrderInfo">
                <table id="workOrderTable">
                    <thead align="center" style="background-color:gray">
                        <td><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
                        <td>No</td>
                        <td>ǰ���ڵ�</td>
                        <td>ǰ��</td>
                        <td>�԰�</td>
                        <td>����</td>
                        <td>���̼���</td>
                        <td>LOSS(%)</td>
                        <<td>�ʿ����</td>
                        <td>����</td>
                        <td>���ִܰ�</td>
                        <td>��������</td>
                        <td>��������</td>
                        <td>���</td>
                    </thead>
                    <!-- �׽�Ʈ�� ������, ���� ǥ�������� �����ʿ� -->
         <c:forEach var="bom" items="${bomView}" >     
   <tr align="center">
   	  <td><input type="checkbox" name="content"/></td>
      <td>${bom.no}</td>
      <td>${bom.itemNumber}</td>
      <td>${bom.itemName}</td>
      <td>${bom.standard}</td>
      <td>${bom.unit}</td>
      <td>${bom.precisionQuantity}</td>
      <td>${bom.loss}</td>
      <td>${bom.precisionQuantity +bom.loss * 0.1 }</td>
      <td>${bom.actualCost}</td>
      <td>${bom.outSourcingUnitPrice}</td>
      <td>${bom.startDate}</td>
      <td>${bom.endDate}</td>
      <td>${bom.note}</td>
    </tr>
    </c:forEach> 
    <tr>
    <td><input type="checkbox" name="content"/></td>
    	<td><input type="text" style="width:100%" disabled/></td>
    	<td><input type="text" id="itemcode" ondblclick="search1('2')"/></td>
    	<td><input type="text" disabled/></td>
    	<td><input type="text"/></td>
    	<td><input type="text"/></td>
    	<td><input type="text"/></td>
    	<td><input type="text"/></td>
    	<td><input type="text"/></td>
    	<td><input type="text"/></td>
    	<td><input type="text"/></td>
    	<td><input type="text"/></td>
    	<td><input type="text"/></td>
    </tr>
   
                </table>
            </div>
            <!-- �հ� ��º� -->
            <div id="resultWindow">
                �� �� <span style="margin-left: 100px;">���̼��� <input type="text"></span><span style="margin-left: 100px;">�ʿ���� <input type="text"></span>
            </div>
            <!-- �հ� ��º� ���� -->
        </container2>
      <script>
      function search1(num){
    	  if(num == 1){
      	openWindowPop('http://localhost:8090/webERP/member/codehelper.do?div='+1,'codehelper');
    	  }
    	  else if(num == 2){
    	      	openWindowPop('http://localhost:8090/webERP/member/BOMcodehelper.do?div='+2,'codehelper');

    	  }
      }
      	
      </script>
</body>
</html>