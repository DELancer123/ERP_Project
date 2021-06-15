<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"    
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>
    <c:forEach var="wor" items="${worcom}" >
 	<c:set var="worcompany_Registration_Number" value="${wor.worcompany_Registration_Number }"/>
 	<c:set var="worcorporate_Registration_Number" value="${wor.worcorporate_Registration_Number }"/>
 	<c:set var="worrepresentatives_Name" value="${wor.worrepresentatives_Name }"/>
 	<c:set var="workplace_Zipcode" value="${wor.workplace_Zipcode }"/>
 	<c:set var="workplace_Address" value="${wor.workplace_Address }"/>
 	<c:set var="workplace_Number" value="${wor.workplace_Number }"/>
 	<c:set var="workplace_Tel" value="${wor.workplace_Tel }"/>
 	<c:set var="worupstate" value="${wor.worupstate }"/>
 	<c:set var="worindustry" value="${wor.worindustry }"/>
 	<c:set var="main_Store_Status" value="${wor.main_Store_Status }"/>
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
            width: 25%;
            height: 80%;
            border: 1px solid black;
            z-index: 1;
        }
        #contents2{
            position: absolute;
            left: 40%;
            top: 15%;
            width: 60%;
            height: 80%;
            z-index: 1;
            border: 1px solid black;
        }
	 #table1 {
            text-align: center; width: 100%; padding-top: 20px;
            padding-right: 10%; padding-left: 2px;
            overflow: hidden;
        }
        #table2 {
            width: 100%; padding-top: 20px; padding-left: 50px; text-align: left;
            border-collapse: separate; border-spacing: 0 15px;
        }
        #reqInput {
           	background-color: rgb(255, 255, 149);
            text-align: center;
        }
</style>
</head>
<body>
<container id = contents1>
            <table id="table1">
                <tr>
                    <p><td colspan = "2" span style="color:black" align="center">�����������</td></p>
                </tr>
                <tr>
                    <td align="center">�ڵ�</td>
                    <td align="center">������</td>
                </tr>
                <c:forEach var="wor" items="${worView }" >
                <tr>
                    <td>
                        <input type="text" id="textbox2" onfocus="searchView(this.value)" name="workplace_Code" value='${wor.workplace_Code }'
                        style="background-color: rgb(235, 235, 235);
                        border-style: none; vertical-align: 1px; width: 80px; 
                        text-align: center;" pattern="[0-9]{4}" maxlength="4"
                        />
                    </td>
                    <td>
                        <input type=text name="workplace_Name" value='${wor.workplace_Name }'
                        style="background-color: rgb(235, 235, 235); 
                        border-style: none; vertical-align: 1px; width: 160px;
                        text-align: center;"  />
                    </td>
                </tr>
                </c:forEach>
            </table>
        </container>
        <container id="contents2">
            <table id="table2">
                <tr>
                    <p><td colspan = "2" span style="color:black" align="center">�⺻��ϻ���</td></p>
                </tr>
                <tr>
                    <td align="center">����ڵ�Ϲ�ȣ</td>
                    <td colspan="2">
                        <input type="text" name="registrationNumber" id="reqInput"
                        value='${worcompany_Registration_Number }' 
                        style="width: 240px;" pattern="[0-9]{10}" maxlength="10"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">���ε�Ϲ�ȣ</td>
                    <td colspan="2">
                        <input type="text" name="cooperationNumber"
                        value="${worcorporate_Registration_Number }"
                        style="background-color: rgb(235,235,235);
                        border-style: none; width: 240px;
                        text-align: center;" pattern="[0-9]{13}" maxlength="13"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">��ǥ�ڸ�</td>
                    <td colspan="2">
                        <input type="text" name="ceoName" id="reqInput" value="${worrepresentatives_Name }"
                        style="width: 240px;"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">���������ȣ</td>
                    <td>
                        <input type="text" name="zipCode" value="${workplace_Zipcode }"
                        style="background-color: rgb(235,235,235);
                        border-style: none; width: 205px;
                        text-align: center;" pattern="[0-9]{5}" maxlength="5"/>
                        <i class="fas fa-search" style="color: blue;"></i> 
                    </td>
                </tr>
                <tr>
                    <td align="center">������ּ�</td>
                    <td colspan="2">
                        <input type="text" name="workSpaceAddress" id="reqInput" value="${workplace_Address }"
                        style="width: 240px;"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">��������</td>
                    <td colspan="2">
                        <input type="text" name="workStreetAddress"  value="${workplace_Number }"
                        style="background-color: rgb(235,235,235);
                        border-style: none; width: 240px;
                        text-align: center;"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">��ȭ��ȣ</td>
                    <td colspan="2">
                        <input type="text" name="phoneNumber" value="${workplace_Tel }"
                            style="background-color: rgb(235,235,235);
                            border-style: none; width: 240px;
                            text-align: center;" pattern="[0-9]{10}" maxlength="10"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">����</td>
                    <td colspan="2">
                        <input type="text" name="business" id="reqInput" value="${worupstate }"
                        style="width: 240px;"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">����</td>
                    <td colspan="2">
                        <input type="text" name="specific" id="reqInput" value="${worindustry }"
                        style="width: 240px;"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">��������</td>
                    <td>
                        <select name="headOfficeType" value="${main_Store_Status }"
                        style="background-color:rgb(235, 235, 235); 
                        border-style: none; width: 100px;
                        text-align: center;" >
                            <option value="default">��/��</option>
                            <option value="0">1.��</option>
                            <option value="1">2.��</option>
                        </select>
                    </td>
                </tr>
            </table>
            <script>
        var textbox1 = document.getElementById("textbox2");
        function searchView(name) {
        	console.log('Ȯ��');
         	window.location.href = "${contextPath}/member/regbusiness.do?submit=1&&wor_code=" + name; 
        }
        </script>
        </container>
</body>
</html>