<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"    
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>    
<c:forEach var="com" items="${comcom}" >     
 	<c:set var="fiscal_Year_Number" value="${com.fiscal_Year_Number }"/>
 	<c:set var="fiscal_Year_Dates" value="${com.fiscal_Year_Dates }"/>
 	<c:set var="fiscal_Year_Datee" value="${com.fiscal_Year_Datee }"/>

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
            width: 35%;
            height: 80%;
            border: 1px solid black;
            z-index: 1;
        }
        #contents2{
            position: absolute;
            left: 50%;
            top: 15%;
            width: 50%;
            height: 80%;
            z-index: 1;
            border: 1px solid black;
        }
	#table1 {
            text-align: center; width: 100%; padding-top: 20px;
            padding-right: 10%; padding-left: 2px;
            overflow: hidden;
            border: 1px solid #ccc; 
        }
        #table1 td{
            width: 100%;
        }
        #contents2{
            position: absolute;
            left: 50%;
            top: 15%;
            width: 50%;
            height: 80%;
            z-index: 1;
            border: 1px solid black;
        }
        #table2 {
            width: 100%; padding-top: 20px; padding-left: 50px; text-align: left;
            border-collapse: separate; border-spacing: 0 15px; 
        }
        .reqInput {
            background-color: rgb(255, 255, 149);
            text-align: center;
        }
        
</style>
</head>
<body>
<form  method="get">
<container id = contents1 style="overflow: auto;">

            <table id="table1">
                <tr>
                    <td align="center">회사코드</td>
                    <td align="center">회사명</td>
                    <td align="center">구분</td>
                </tr>
                <c:forEach var="com" items="${comView}" >     
                <tr>
                    <td>
                        <input type="text" id="textbox1" name="company_Code" value='${com.company_Code }'
                        style="background-color: rgb(235, 235, 235); 
                        border-style: none;
                        text-align: center;" maxlength="12" 
                         />
                    </td>
                    <td>
                        <input type=text name="company_Name"  value='${com.company_Name }'
                        style="background-color: rgb(235, 235, 235); 
                        border-style: none;
                        text-align: center;"/>
                    </td>
                    <td>
                        <select name="sortation" 
                        style="background-color:rgb(235, 235, 235); 
                        border-style: none;
                        text-align: center;" >
                            <option value="default">법인/개인</option>
                            <option value="0">0.법인</option>
                            <option value="1">1.개인</option>
                        </select>
                    </td>
                </tr>
		</c:forEach>
            </table>
        </container>
        <container id="contents2">
            <table id="table2">
                <tr>
                    <p><td colspan = "3" span style="color:black" align="center">기본정보등록</td></p>
                </tr>
                <tr>
                    <td align="center">회계연도</td>
                    <td>
                        제
                        <input type="text" name="fiscal_Year_Number" id="fiscal_Year_Number" class= "reqInput"
                        value='${fiscal_Year_Number }'
                        style="width: 60px" pattern="[0-9]{3}" maxlength="3"/>
                        기
                    </td>
                    <td>
                        <input type="date" name="fiscal_Year_Dates" id="fiscal_Year_Dates">
                        ~
                        <input type="date" name="fiscal_year_Datee" id="fiscal_year_Datee"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">사업자등록번호</td>
                    <td colspan="2">
                        <input type="text" name="company_Registration_Number" id="company_Registration_Number" class= "reqInput"
                        style="width: 240px;" pattern="[0-9]{13}" maxlength="13"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">법인등록번호</td>
                    <td colspan="2">
                        <input type="text" name="corporate_Registration_Number"
                        style="background-color: rgb(235,235,235);
                        border-style: none; width: 240px;
                        text-align: center;" pattern="[0-9]{13}" maxlength="13"/>
                        법인의 경우 필수입력항목
                    </td>
                </tr>
                <tr>
                    <td align="center">대표자성명</td>
                    <td colspan="2">
                        <input type="text" name="representatives_Name" id="representatives_Name" class= "reqInput"
                        style="width: 240px;"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">주민등록번호</td>
                    <td colspan="2">
                        <input type="text" name="resident_Registration_Number"
                        style="background-color: rgb(235,235,235);
                        border-style: none; width: 240px;
                        text-align: center;" pattern="[0-9]{13}" maxlength="13"/>
                        개인의 경우 필수입력항목
                    </td>
                </tr>
				
                <tr>
                    <td align="center">본점우편번호</td>
                    <td colspan="2">
                        <input type="text" name="main_Store_Postal_Code" 
                        style="background-color: rgb(235,235,235);
                        border-style: none; width: 205px;
                        text-align: center;" pattern="[0-9]{5}" maxlength="5"/>
                        <i class="fas fa-search" style="color: blue;"></i>
                    </td>
                </tr>
                <tr>
                    <td align="center">본점주소</td>
                    <td colspan="2">
                        <input type="text" name="main_Store_Address" id="main_Store_Address" class= "reqInput"
                        style="width: 240px;"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">본점번지</td>
                    <td colspan="2">
                        <input type="text" name="main_Branch_Number" 
                        style="background-color: rgb(235,235,235);
                        border-style: none; width: 240px;
                        text-align: center;"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">본점전화번호</td>
                    <td colspan="2">
                        <input type="text" name="main_Store_Tel"
                            style="background-color: rgb(235,235,235);
                            border-style: none; width: 240px;
                            text-align: center;" pattern="[0-9]{12}" maxlength="10"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">업태</td>
                    <td colspan="2">
                        <input type="text" name="upstate" id="upstate" class= "reqInput"
                        style="width: 240px;"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">종목</td>
                    <td colspan="2">
                        <input type="text" name="industry" id="industry" class= "reqInput"
                        style="width: 240px;"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">설립연월일</td>
                    <td colspan="2">
                        <input type="date" name="date_Of_Establishment"
                        style="background-color: rgb(235,235,235);
                        border-style: none;
                        text-align: center;"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">사용여부</td>
                    <td>
                        <select name="whether_To_Use_Status" id="whether_To_Use_Status">
                            <option value="1">1.사용</option>
                            <option value="0">0.미사용</option>
                        </select>
                    </td>
                </tr>
            </table>
        </container>
        <script>
        var textbox1 = document.getElementById("textbox1");
        textbox1.onfocus = function() {
        	console.log('확인');
         	window.location.href = "${contextPath}/member/regcompany.do?submit=1&&com_code=" + textbox1.value; 
        }
        
        </script>
</form>
</body>
</html>