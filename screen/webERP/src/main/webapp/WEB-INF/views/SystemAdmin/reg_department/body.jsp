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
            width: 85%;
            height: 70%;
            border: 1px solid #ccc;
            z-index: 1;
        }
        .con1_search {
            margin: 10px;   
        }
        #contents1 {
            border-bottom: none;
            
        }
        #contents2 {
            border-bottom: none;
            
        }
        
        #contents1 td {
            text-align: right;
            letter-spacing: 1px;
            padding: 1px;
            font-family: 'Hanna';
        }
        #contents2 td {
            border-collapse: collapse;
            padding: 3px;
        }
        #contents3 td {
            border-collapse: collapse;
            padding: 3px;
        }

        #contents1 input[type="text"] {
            text-align: center;
        }
        #contents1 input[disabled] {
            border: 2px inset rgb(148, 147, 150);
        }
        #contents2 input {
            text-align: center;
        }
        #contents3 input {
            text-align: center;
        }        
        
        #table1 {
        	margin-top:18px;
        	width:100%

        }
        #table2 {
            width: 100%;
            overflow: hidden;
            
        }
</style>
</head>
<body>
<form method="get" id="regdepartment">
<container1 id = contents1>
            <table id="table1" align="center">
                <tr>
                    <p><td colspan="3" span style="color:black" align="center">부서등록</td></p>
                    <p><td colspan="7" span style="color:black" align="center">부문등록</td></p>
                </tr>
                <tr>
                    <td align="center">사업장</td>
                    <td >
                        <select name="workSpace" style="width: 120px;">
                        </select>
                        <i class="fas fa-search" style="color: blue;"></i>
                    </td>
                    <td align="center">조회기준일 적용</td>
                    <td>
                        <input type="checkbox">
                        <input type="date" disabled text-align: center; style="width: 130px;"/>
                    </td>                  
                    <td align="center" colspan="3" style="width:150px; text-align: right;">부문코드&nbsp;</td>
                    <td>
                        <input type=text name="sectorCode" style=" width: 80px;"/>
                    </td>
                    <td align="center">부문명</td>
                    <td>
                        <input type=text name="sectorName" style="width: 150px;"/>
                    </td>
                    <td align="center">사용기간 시작</td>
                    <td>
                        <input type="date" style="width: 130px;">
                    </td>
                </tr>
            </table>
        </container1>
        <container2 id= contents2>
            <table id="table2" align="center">
                <thead>
                	<td><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
                    <td align="center">부서코드</td>
                    <td align="center">부서명</td>
                    <td align="center">사업장코드</td>
                    <td align="center">사업장명</td>
                    <td align="center">부문코드</td>
                    <td align="center">부문명</td>
                    <td align="center">사용기간 시작</td>
                </thead>
                <c:forEach var="department" items="${departmentView}" >
               
                <tbody>
                <td><input type="checkbox" name="content" /></td>
                    <td align="center">
                        <input type=text name="divCode" style="width: 100px;" value='${department.department_Code }'>
                    </td>
                    <td align="center">
                        <input type=text name="divName" value='${department.department_Name }'>
                    </td>
                    <td align="center">
                        <input type=text name="workSpaceCode" style="width: 100px;" value='${department.workplace_Code }'>
                    </td>
                    <td align="center">
                        <input type=text name="workSpaceName" value='${department.workplace_Name }'>
                    </td>
                    <td align="center">
                        <input type=text name="sectorCode" style="width: 100px;" value='${department.sector_Code }'>
                    </td>
                    <td align="center">
                        <input type=text name="sectorName" value='${department.sector_Name }'>
                    </td>
                    <td align="center">
                        <input type="date" value='${department.usedate }'>
                    </td>
                    </tbody>
                </tr>
                </c:forEach>
                <tbody>
                 <tr id ="insertTest" align="center">
    <td></td>
    	<td><input type="text" name="ListVO[${fn:length(departmentView) }].department_Code" /></td>
    	<td><input type="text" name="ListVO[${fn:length(departmentView) }].department_Name" /></td>
    	<td><input type="text" name="ListVO[${fn:length(departmentView) }].workplace_Code" /></td>
    	<td><input type="text" name="ListVO[${fn:length(departmentView) }].workplace_Name" /></td>
    	<td><input type="text" name="ListVO[${fn:length(departmentView) }].sector_Code" /></td>
    	<td><input type="text" name="ListVO[${fn:length(departmentView) }].sector_Name" /></td>
    	<td><input type="date" name="ListVO[${fn:length(departmentView) }].usedate" /></td>
    </tr>
                  </tr>
            </table>
        </container2>
        </form>
        <script>
        function newRow(){
    		const URLSearch = new URLSearchParams(location.search);
    		URLSearch.set('submit','1');
    		const newParam = URLSearch.toString();
    		var link = location.pathname +'?'+newParam;
    		var articleNOInput = document.createElement("input");
    		articleNOInput.setAttribute("type","hidden");
    		articleNOInput.setAttribute("name","path");
    		articleNOInput.setAttribute("value", link);
    		document.getElementById('regdepartment').appendChild(articleNOInput);
    		document.getElementById('regdepartment').action = "${contextPath}/member/adddepartment.do";
    		document.getElementById('regdepartment').submit();
    		}
        </script>
</body>
</html>