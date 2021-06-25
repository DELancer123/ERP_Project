<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>출고 처리 등록</title>
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
        #reqInput {
            background-color: rgb(255, 255, 149);
            text-align: center;
        }
</style>
</head>
<body>
<container1 id = contents1>
            <table class="con1_search">
                <tr>
                    <td>거래처 명</td>
                    <td><input type="text" name="cust" value='${param.custCode}'disabled /></td>
                    <td><input type="text" name="cust" value='${param.custName}'disabled /></td>
                    <td style="width: 50px;"><a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></a></td>
                    <td>출고기간</td>
                    <td><input type="date" id="reqInput"></td>
                    <td>~</td>
                    <td><input type="date" id="reqInput"></td>
                </tr>
               <!--  <tr>
                    <td>고객</td>
                    <td><input type="text"></td>
                    <td><i class="fas fa-search" style="color: blue;"></i></td>
                    <td><input type="text" disabled></td>
                    <td>출고창고</td>
                    <td><input type="text" id="reqInput"></td>
                    <td><i class="fas fa-search" style="color: blue;"></i></td>
                    <td><input type="text" disabled></td>
                </tr>
                 -->
            </table>
        </container1>
         <script>
                     function search1(){
    	  
        	  openWindowPop('http://localhost:8090/webERP/sales_manage/pop/regforwardCust.do','regforwardCust');  
    }
    </script>
</body>
</html>