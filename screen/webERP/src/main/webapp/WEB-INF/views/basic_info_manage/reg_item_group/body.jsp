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
            text-align: center;
            letter-spacing: 1px;
            padding: 1px;
            font-family: 'Hanna';
        }
        #contents2 td {
            border-collapse: collapse;
            padding: 3px;
            text-align: center;
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
            width: 70%;
            padding-top: 15px;
            padding-left: 25px;
            text-align: center;
            margin-top: 18px;
        }
        #table2 {
            width: 60%;
        }
</style>
</head>
<body>
<container1 id = contents1>
            <table id="table1" align="center">
                
                <tr>
                    <td align="center">검색조건</td>
                </tr>
            </table>
        </container1>
        <container2 id= contents2>
            <table id="table2" align="center">
                <tr>
                    <td>
                        <input type="checkbox" name="content" onclick="selectAll(this)"/>
                    </td>
                    <td>품목군코드</td>
                    <td>품목군명</td>
                    <td>사용여부</td>
                    <td>품목군설명</td>
                </tr>
                <c:forEach var="itemg" items="${itemgView}" >  
                <tr>
                    <td>
                        <input type="checkbox" name="content"/>
                    </td>
                    <td>
                        <input type=text name="rangeCode" value='${itemg.item_Group_Code }' >
                    </td>
                    <td>
                        <input type=text name="rangeName" value='${itemg.item_Group_Name }' >
                    </td>
                    <td>
                        <select name="usable" >
                        <option value="0">사용</option>
                        <option value="1">미사용</option>
                    </td>
                    <td>
                        <input type=text name="explain" value='${itemg.explanation }' >
                    </td>
                </tr>
                </c:forEach>
            </table>
        </container2>
</body>
</html>