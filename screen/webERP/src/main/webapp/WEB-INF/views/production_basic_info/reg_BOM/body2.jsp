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
		
        #contents2{
            position: absolute;
            left: 15%;
            top: 25%;
            width: 85%;
            height: 70%;
            border: 1px solid black;
            z-index: 1;
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
    	<td><input type="text" style="width:100%"  disabled/></td>
    	<td><input type="text" id="itemcode"  ondblclick="search2()"/></td>
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
<c:forEach var="bom" items="${bomInsert}" >     
   <tr align="center">
   	  <td><input type="checkbox" name="content"/></td>

      <td>${bom.itemNumber}</td>
      <td>${bom.itemName}</td>
      <td>${bom.standard}</td>
      <td>${bom.unit}</td>
      
  
    </tr>
    </c:forEach> 
                </table>
            </div>
            <!-- �հ� ��º� -->
            <div id="resultWindow">
                �� �� <span style="margin-left: 100px;">���̼��� <input type="text"></span><span style="margin-left: 100px;">�ʿ���� <input type="text"></span>
            </div>
            <!-- �հ� ��º� ���� -->
        </container2>
      <script>
      function search2(){
    	
      	openWindowPop('http://localhost:8090/webERP/member/bomcodehelper.do','codehelper');
    	 
      }
      function setChildValue(name){
    	  const URLSearch = new URLSearchParams(location.search);
		  URLSearch.set('submit', '2');
		  const newParam = URLSearch.toString();

        document.getElementById("itemcode").value = name;
        
        if(URLSearch.get('itemcode') == null)
		window.location.href = location.pathname +'?'+newParam + '&&itemCode=' + name;
        else{
        	URLSearch.set('itemcode', name);
        	window.location.href = location.pathname +'?'+newParam;
        }
    }
      </script>
</body>
</html>