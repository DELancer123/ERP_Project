<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    isELIgnored="false"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>
<c:forEach var="sel" items="${logisticsSelectedView}" >     
 	<c:set var="logistics_In_Code" value="${sel.logistics_In_Code }"/>
 	<c:set var="logistics_In_Name" value="${sel.logistics_In_Name }"/>
 	<c:set var="explanation" value="${sel.explanation }"/>
 	<c:set var="remarks" value="${sel.remarks }"/>
</c:forEach>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>물류관리내역등록</title>
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
            text-align: center; width: 100%; padding-top: 10px;
            padding-right: 2%; padding-left: 2px;
        }
        #table2 {
            width: 100%; text-align: center;
            border-collapse: separate; border-spacing: 0 15px; border: 1px solid black;
            padding-right: 15%;
        }
        #table3 {
            width: 100%; padding-top: 10px; padding-left: 10px; text-align: center;
            border-collapse: separate; border-spacing: 0 15px;
        }      
        
        #contents1 input {
        	text-align:center;
        	width:100%;
        }        
        #contents2 input {
        	text-align:center;
        }
        
       
        
       
</style>
</head>
<body>
<container id = contents1>
            <table id="table1">            	
                <tr>
                    <td style="width:5%;"><input type="checkbox" name="ckcontent" onclick="selectAll(this)"/></td>
                    <td style="width:47.5%;">코드</td>
                    <td style="width:47.5%;">관리항목명</td>
                </tr>
                <c:forEach var="logis" items="${logisticsView}" >
	                <tr>
	                    <td>
	                    	<input type="checkbox" name="content" value="${logis.logistics_In_Code}"/>
	                    </td>                   
	                    <td>
	                        <input type="text" onfocus = "searchView(this.value)" value="${logis.logistics_In_Code}"/>
	                    </td>     
	                    <td>
	                        <input type="text" value="${logis.logistics_In_Name}"/>
	                    </td>                    	                    
	                </tr>
	               
                </c:forEach>                
            </table>
        </container>

        <container id="contents2">
            <table id="table2">
                <tr>
                    <td align="center" style="width:25%; text-align:right;">코드</td>
                    <td style="width:25%;">
                        <input type="text" onfocus = "searchView(this.value)">
                    </td>    
                    <td><i class="fas fa-search" style="color: blue;"></i></td>
                    <td align="center" style="width:20%; text-align:right;">관리내역명</td>
                    <td style="width:25%;">
                        <input type="text">
                    </td>
                    <td><i class="fas fa-search" style="color: blue;"></i></td>
                </tr>
            </table>
            <table id="table3">
                <thead>
                    <td align="center">관리내역코드</td>
                    <td align="center">관리항목명</td>
                    <td align="center">품목군설명</td>
                    <td align="center">비고</td>
                </thead>
                <tbody>
                	<tr>
	                    <td>
	                        <input type="text" value="${logistics_In_Code }">
	                    </td>
	                    <td>
	                        <input type="text" value="${logistics_In_Name }">
	                    </td>
	                    <td>
	                        <input type="text" value="${explanation }">
	                    </td>
	                    <td>
	                        <input type="text" value="${remarks }">
	                    </td>
                    </tr>
                </tbody>
            </table>
        </container>
        <script>
	        function searchView(name) { //조회를 담당하는 자바스크립트임
	            window.location.href = "${contextPath}/member/logistics_manage.do?submit=1&&com_code=" + name; 
	        }
        </script>
</body>
</html>