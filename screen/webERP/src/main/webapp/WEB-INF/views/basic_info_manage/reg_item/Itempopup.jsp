<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    
    

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
    <style>
    	a{
    		text-decoration:none;
    	}
        #wrap{
            width: 300px;
            height: 400px;
            border: 1px solid black;
        }
        #searchBox{
            width: 100%;
            height: 23%;
            border: 1px solid black;
        }
        #button{
            margin-top: 3%;
            margin-right: 3%;
            text-align: right;
        }
        #search{
            margin-left: 30px;
        }
        #view{
        	width:100%;
        	height:77%;
        	overflow:scroll;
        }
    </style>
</head>
<body>
<form name="popForm" method="get" action="${contextPath }/member/regitemg" >
    <div id="wrap">
        <div id="searchBox">
            <table id="search">
                <tr>
                    <td>검색1</td>
                    <td><input type="text" id="code" /></td>
                    <td>검색2</td>
                    <td><input type="text" id="name" /></td>
                </tr>
            </table>
            <div id="button">
                <button id="search">조회</button>
                <button id="submit">적용</button>
            </div>
        </div>
        <div id="view">
            <table style="width: 100%;">
                <tr align="center">
                    <td>품목코드</td>
                    <td>품명</td>
                </tr>
                <c:forEach var="itemg" items="${itemgView}" >     
   <tr align="center">
      <td><a href="javascript:popFunction('${itemg.item_Group_Code }','${itemg.item_Group_Name }')">${itemg.item_Group_Code}</a></td>
      <td><a href="#">${itemg.item_Group_Code}</a></td>
      <td><a href="#">${itemg.item_Group_Name}</a></td>
    </tr>
    </c:forEach> 
            </table>
        </div>
    </div>
    
    <script>
    var submit_button = document.getElementById("submit");
    		var text_code = document.getElementById("code");
    		var text_name = document.getElementById("name");
    	function popFunction(code,name){
    		text_code.value = code;
    		text_name.value = name;
    	}
    	submit_button.onclick = function(){
    		opener.parent.location='${contextPath }/member/regitem.do?item_Group_Code='+text_code.value+'&&item_Group_Name='+text_name.value+'&&submit='+0;
    		window.close();
    	}
    </script>
    </form>
</body>
</html>