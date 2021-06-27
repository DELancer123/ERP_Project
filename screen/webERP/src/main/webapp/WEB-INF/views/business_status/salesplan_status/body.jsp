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
<title>판매계획 현황</title>
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
                .con1_search{
            padding:0;
            text-align: center;
            top: 25%;
            left: 5%;
        }
         #searchForm {
            height: 100%;
            margin: 25px 10px;
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
            <table class="con1_search">
                <tr>    
                    <td>계획기간</td>
                    <td colspan="3" style="width: 70px; text-align: left;">
                        <button id="minus"><<</button>
                        <input type="text" value="2021" id="year" style="background-color: rgb(255, 255, 149); width: 30%;"/>
                    <button id="plus">>></button></td>
                </tr>
                <tr>
                    <td>품  목</td>
                    <td style="width: 50px;"><input type="text" name="item" value='${param.item_name}' style="width: 100%;"/></td>
                    <td style="width: 50px;"><a href="javascript:search1()"><i class="fas fa-search"></i></a></td>

                    <td colspan="5">품목군</td>
                    <td style="width: 80px;"><input type="text" style="width: 100%;"/></td>
                    <td><input type="text" name="" disabled/></td>
                    <td><i class="fas fa-search"></i></td>
                    
                </tr>
            </table>
        </container1>

    <script>
    function openWindowPop(url, name){
        var options = 'top=330, left=400, width=320, height=420, status=no, menubar=no, toolbar=no, resizable=no';
        window.open(url, name, options);
    }
          function search1(){
    	  
        	  openWindowPop('http://localhost:8090/webERP/business_status/pop/popItem.do','popupItem');  
    }
    </script>
</body>
</html>