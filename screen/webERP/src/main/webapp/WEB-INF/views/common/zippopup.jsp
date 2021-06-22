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
            width: 1100px; 
            height: 500px;
            border: 1px solid black;
        }
        #searchBox{
            width: 100%;
            height: 18%;
            border: 1px solid black;
        }
        #button{
            margin-top: -4%;
            margin-right: 3%;
            text-align: right;
        }
        #search{
            margin-left: 30px;
        }
        #view{
        	width:100%;
        	height:82%;
        	overflow:scroll;
        }
        #test{
        	width:100px;
        }
    </style>
</head>
<body>
<form name="popForm" method="get" action="${contextPath }/member/zippopup" >
    <div id="wrap">
        <div id="searchBox">
            <table id="search">
                <tr>
                    <td>우편번호</td>
                    <td><input type="text" id="zipcode"/></td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td><input type="text" id="address1"/></td>
                </tr>
                <tr>
                    <td>주소2</td>
                    <td><input type="text" id="address2"/></td>
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
                    <td id="test">우편번호</td>
                    <td>주소</td>
                    <td>주소2</td>
                </tr>
                <c:forEach var="zip" items="${zipView}" >     
   <tr align="center">
      <td><a href="javascript:popFunction('${zip.zipcode }','${zip.road_address }','${zip.lot_address }')">${zip.zipcode }</a></td>
      <td><a href="#">${zip.road_address}</a></td>
      <td><a href="#">${zip.lot_address}</a></td>
    </tr>
    </c:forEach> 
            </table>
        </div>
    </div>
    
    <script>
    var submit_button = document.getElementById("submit");
    		var text_zipcode = document.getElementById("zipcode");
    		var text_address1 = document.getElementById("address1");
    		var text_address2 = document.getElementById("address2");
    	function popFunction(zipcode,address1,address2){
    		text_zipcode.value = zipcode;
    		text_address1.value = address1;
    		text_address2.value = address2;
    	}
    	submit_button.onclick = function(){
    		opener.setChildValue(text_zipcode.value);
			window.close();
    	}
    </script>
    </form>
</body>
</html>