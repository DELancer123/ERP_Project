<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>
<c:forEach var="com" items="${comcom}" >     
 	<c:set var="general_Customer_Code" value="${com.general_Customer_Code }"/>
 	<c:set var="general_Customer_Name" value="${com.general_Customer_Name }"/>
 	<c:set var="general_Customer_Division" value="${com.general_Customer_Division }"/>
 	<c:set var="company_Registration_Number" value="${com.company_Registration_Number }"/>
 	<c:set var="resident_Registration_Number" value="${com.resident_Registration_Number }"/>
 	<c:set var="representativs_Name" value="${com.representativs_Name }"/>>
 	<c:set var="upstate" value="${com.upstate }"/>
 	<c:set var="industry" value="${com.industry }"/>
 	<c:set var="zipCode" value="${com.zipCode }"/>
 	<c:set var="workplace_Address" value="${com.workplace_Address }"/>
 	<c:set var="generalCustomer_Tel" value="${com.generalCustomer_Tel }"/>
 	<c:set var="wholesale_Retail_Business_Code" value="${com.wholesale_Retail_Business_Code }"/>
</c:forEach>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> <!-- ��������CDN -->
<style>
 #contents1{
            position: absolute;
            left: 15%;
            top: 15%;
            width: 85%;
            height: 10%;
            border: 1px solid #ccc;
            z-index: 1;
        }
        #contents2{
            position: absolute;
            left: 15%;
            top: 25%;
            width: 35%;
            height: 70%;
            border: 1px solid #ccc;
            z-index: 1;
        }
        #contents3{
            position: absolute;
            left: 50%;
            top: 25%;
            width: 50%;
            height: 70%;
            z-index: 1;
            border: 1px solid #cc;
        }
        .con1_search {
            margin: 10px;   
        }
       
        
        #contents1 td {
            text-align: right;
            letter-spacing: 1px;
            padding: 1px;
        }
        #contents2 td {
            border-collapse: collapse;
            padding: 3px;
        }
        #contents3 td {
            border-collapse: collapse;
            padding: 3px;
        }

        
        #contents2, #contents3 td{
            border-collapse: collapse;    
        }
        
        #contents1 input[type="text"] {
            text-align: center;
        }
        
        #contents2 input[type="text"] {
            text-align: center;
            width: 100%;
        }
        #contents3 input {
            text-align: center;
        }        
        
        #table1 {
        	margin-top:30px;
        	margin-right:5px;
            width: 80%;

        }
        #table2 {
            width: 100%;
            text-align: center;
        }
        #table3 {
            width: 100%; 
        }
        
        #reqInput {
            background-color: rgb(255, 255, 149);
            text-align: center;
        }
	 	#table1 {
            text-align: center; 
			overflow: hidden;
        }
        #table2 {
            width: 100%;  text-align: left;
            border-collapse: separate; border-spacing: 0 15px;
        }
        #reqInput {
           	background-color: rgb(255, 255, 149);
            text-align: center;
        }
</style>
</head>
<body>
<container1 id = contents1>
            <table id="table1" align="center">
                <tr>
                    <td align="center">�ŷ�ó�ڵ�</td>
                    <td>
                        <input type=text name="customerCode"
                        pattern="[0-9]{4}" maxlength="4"/>
                    </td>
                    <td align="center">�ŷ�ó��</td>
                    <td>
                        <input type=text name="customerName">
                    </td>
                    <td align="center">�ŷ�ó����</td>
                    <td>
                        <select name="customerType" >
                            <option value="default">�Ϲ�/����/�ֹ�</option>
                            <option value="1">1.�Ϲ�</option>
                            <option value="2">2.����</option>
                            <option value="3">3.�ֹ�</option>
                        </select>
                    </td>
                </tr>
            </table>
        </container1>
        <form name="update" method="get" commandName="SystemmagVO">
        <container2 id= contents2>
            <table id="table2" align="center">
                <thead>
                    <td><input type="checkbox" id="chec" name="content" onclick="selectAll(this)"/></td>
                    <td align="center">�ڵ�</td>
                    <td align="center">�ŷ�ó��</td>
                    <td align="center">����</td>
                </thead>
               <c:forEach var="com" items="${comView}" >     
                <tbody>
                    <td><input type="checkbox" name="checkedContent" value='${com.general_Customer_Code}'></td>
                    <td>
                        <input type="text" id='textbox1' onfocus = "searchView(this.value)" name="temp" value='${com.general_Customer_Code}'/>
                    </td>
                    <td>
                        <input type="text" name="temp" value='${com.general_Customer_Name}'/>
                    </td>
                    <td>
                        <input type="text" name="temp" value='${com.general_Customer_Division}'/>
                    </td>
                </tbody>
                </c:forEach>
            </table>
        </container2>
        <container3 id="contents3">
        
            <table id="table3" align="center">
                <tr>
                    <p><td colspan = "4" span style="color:black" align="center">�⺻��ϻ���</td></p>
                </tr>
                <tr>
                    <td align="center">�ڵ�</td>
                    <td colspan="3">
                        <input type="text" name="ceoName" value="${general_Customer_Code }">
                    </td>
                </tr>
                <tr>
                    <td align="center">�ŷ�ó��</td>
                    <td colspan="3">
                        <input type="text" name="ceoName" value="${general_Customer_Name }">
                    </td>
                </tr>
                <tr>
                    <td align="center">����</td>
                    <td colspan="3">
                        <input type="text" name="ceoName" value="${general_Customer_Division }">
                    </td>
                </tr>
                <tr>
                    <td align="center">����ڵ�Ϲ�ȣ</td>
                    <td colspan="3">
                        <input type="text" name="registrationNumber" id="reqInput" value="${company_Registration_Number}"
                        pattern="[0-9]{10}" maxlength="10"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">�ֹε�Ϲ�ȣ</td>
                    <td colspan="3">
                        <input type="text" name="socialNumber" pattern="[0-9]{13}" maxlength="13" value="${resident_Registration_Number}"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">��ǥ�ڼ���</td>
                    <td colspan="3">
                        <input type="text" name="ceoName" value="${representativs_Name }">
                    </td>
                </tr>
                <tr>
                    <td align="center">����</td>
                    <td colspan="3">
                        <input type="text" name="business" value="${upstate }">
                    </td>
                </tr>
                <tr>
                    <td align="center">����</td>
                    <td colspan="3">
                        <input type="text" name="specific" value="${industry }">
                    </td>
                </tr>
                <tr>
                    <td align="center">�����ȣ</td>
                    <td>
                        <input type="text" name="zipCode" pattern="[0-9]{5}" maxlength="5" value="${zipCode }"
                        style="width:150px;"/>
                        <i class="fas fa-search" style="color: blue;"></i>
                    </td>
                </tr>
                <tr>
                    <td align="center">������ּ�</td>
                    <td colspan="3">
                        <input type="text" name="workSpaceAddress" value="${workplace_Address }">
                    </td>
                </tr>
                <tr>
                    <td align="center">��ȭ��ȣ</td>
                    <td colspan="3">
                        <input type="text" name="phoneNumber" pattern="[0-9]{10}" maxlength="10" value="${generalCustomer_Tel }"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">�ַ��ڵ�</td>
                    <td>
                        <input type="text" id="inchargeManager" name="inchargeManager" value="${wholesale_Retail_Business_Code }">
                    </td>
                </tr>
            </table>
        </form>
        </container3>
        <script>
        var deleteButton = document.getElementById('delete'); //������ư�� �̺�Ʈ�� �ο��ϴ� �����
        deleteButton.addEventListener('click', function(){deleteData();}, false);
        
        var updateButton = document.getElementById('update'); //������ư�� �̺�Ʈ�� �ο��ϴ� �����
        updateButton.addEventListener('click', function(){updateRow();}, false);

        
        function searchView(name) { //��ȸ�� ����ϴ� �ڹٽ�ũ��Ʈ��
            window.location.href = "${contextPath}/member/regbasicacc.do?submit=1&&com_code=" + name; 
        }
        
        
        
        function deleteData() {//üũ�ڽ��� üũ�Ѱ��� ���� �迭�θ���� ��Ʈ�ѷ��� �ѱ�� �Լ�
        	var item = document.getElementsByName("checkedContent").length;
        	var no = "";
        	var ary = [];
        	
        	for(var i=0; i<item; i++) {
        		if(document.getElementsByName("checkedContent")[i].checked==true) {
        			no = document.getElementsByName("checkedContent")[i].value;
        			ary.push(no);
        		}
        		
        	}
        	if(ary.length === 0 || ary === null){
    			alert('������ ����� üũ�ڽ��� �������ּ���^^')
    			window.location.href = "${contextPath}/member/regbasicacc.do";
    		}
        	else 
    			window.location.href = "${contextPath}/member/deleteBasicacc.do?no="+ary;
        	
        }
        
        function updateRow() {
        	alert('������Ʈ ������');
        	
    	
        	window.location.href = "${contextPath}/member/updateBasicacc.do";
        }
        
                	
        
      
        /* function updateRow(){
              alert('������Ʈ������');
          	  var workOrderTable = document.getElementById('table3');
              var row = workOrderTable.insertRow(); 
              const URLSearch = new URLSearchParams(location.search);
              URLSearch.set('submit', '1');
      		  const newParam = URLSearch.toString();
      		  var link = location.pathname +'?'+newParam;
       			 document.getElementById("registrationNumber").disabled = true;
       		     document.getElementById("loss").disabled = true;
       		     document.getElementById("outSourcingUnitPrice").disabled = true;
       		     document.getElementById("actualCost").disabled = true;
       		     document.getElementById("no").disabled = true;
       		     document.getElementById("startDate").disabled = true;
       		     document.getElementById("endDate").disabled = true; 
        		 document.getElementById("inchargerManager").disabled = true;
       		 var articleNOInput = document.createElement("input");
     		     articleNOInput.setAttribute("type","hidden");
     		     articleNOInput.setAttribute("name","path");
     		     articleNOInput.setAttribute("value", link);
     		     document.getElementById('rightSideForm').appendChild(articleNOInput);
                 document.getElementById('rightSideForm').action = "${contextPath}/member/updateBasicacc.do";
       			 document.getElementById('rightSideForm').submit();  
        } */
        
	  		
	       
   
        
		</script>
        
</body>
</html>