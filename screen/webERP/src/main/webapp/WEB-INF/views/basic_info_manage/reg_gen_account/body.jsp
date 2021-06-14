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
                    <td align="center">거래처코드</td>
                    <td>
                        <input type=text name="customerCode"
                        pattern="[0-9]{4}" maxlength="4"/>
                    </td>
                    <td align="center">거래처명</td>
                    <td>
                        <input type=text name="customerName">
                    </td>
                    <td align="center">거래처구분</td>
                    <td>
                        <select name="customerType" >
                            <option value="default">일반/무역/주민</option>
                            <option value="1">1.일반</option>
                            <option value="2">2.무역</option>
                            <option value="3">3.주민</option>
                        </select>
                    </td>
                </tr>
            </table>
        </container1>
        <container2 id= contents2>
            <table id="table2" align="center">
                <thead>
                    <td><input type="checkbox" id="chec" name="content" onclick="selectAll(this)"/></td>
                    <td align="center">코드</td>
                    <td align="center">거래처명</td>
                    <td align="center">구분</td>
                </thead>
               <c:forEach var="com" items="${comView}" >     
                <tbody>
                    <td><input type="checkbox" name="content" value='${com.general_Customer_Code}'></td>
                    <td>
                        <input type="text" id='textbox1' name="temp" value='${com.general_Customer_Code}'/>
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
                    <p><td colspan = "4" span style="color:black" align="center">기본등록사항</td></p>
                </tr>
                <tr>
                    <td align="center">사업자등록번호</td>
                    <td colspan="3">
                        <input type="text" name="registrationNumber" id="reqInput" value="${company_Registration_Number}"
                        pattern="[0-9]{10}" maxlength="10"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">주민등록번호</td>
                    <td colspan="3">
                        <input type="text" name="socialNumber" pattern="[0-9]{13}" maxlength="13" value="${resident_Registration_Number}"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">대표자성명</td>
                    <td colspan="3">
                        <input type="text" name="ceoName" value="${representativs_Name }">
                    </td>
                </tr>
                <tr>
                    <td align="center">업태</td>
                    <td colspan="3">
                        <input type="text" name="business" value="${upstate }">
                    </td>
                </tr>
                <tr>
                    <td align="center">종목</td>
                    <td colspan="3">
                        <input type="text" name="specific" value="${industry }">
                    </td>
                </tr>
                <tr>
                    <td align="center">우편번호</td>
                    <td>
                        <input type="text" name="zipCode" pattern="[0-9]{5}" maxlength="5" value="${zipCode }"
                        style="width:150px;"/>
                        <i class="fas fa-search" style="color: blue;"></i>
                    </td>
                </tr>
                <tr>
                    <td align="center">사업장주소</td>
                    <td colspan="3">
                        <input type="text" name="workSpaceAddress" value="${workplace_Address }">
                    </td>
                </tr>
                <tr>
                    <td align="center">전화번호</td>
                    <td colspan="3">
                        <input type="text" name="phoneNumber" pattern="[0-9]{10}" maxlength="10" value="${generalCustomer_Tel }"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">주류코드</td>
                    <td>
                        <input type="text" name="inchargeManager" value="${wholesale_Retail_Business_Code }">
                    </td>
                </tr>
            </table>
        </container3>
        <script>
        
        
        var textbox1 = document.getElementById("textbox1");
        textbox1.onfocus = function() {
        	console.log('확인');
         	window.location.href = "${contextPath}/member/regbasicacc.do?submit=1&&com_code=" + textbox1.value; 
        }
        

       	/* var textbox1 = document.getElementsByClassName('textbox1');
       	
        textbox1.onfocus = function() {
        	    	
	        for(var i = 0; i< textbox1.length; i++) {
	        	if(textbox1.value === textbox1.item(i)){
	        		window.location.href = "${contextPath}/member/regbasicacc.do?submit=1&&com_code=" + textbox1.value; 
	        	}
	        	        		        	
	        }
	               
         	
        } */
	        
        
        /* var textbox1 = document.getElementById("textbox1");
        function searchView(name) {
           console.log('확인');
            window.location.href = "${contextPath}/member/regcompany.do?submit=1&&com_code=" + name; 
        } */
        
	  		
	       
   
        
		</script>
        
</body>
</html>