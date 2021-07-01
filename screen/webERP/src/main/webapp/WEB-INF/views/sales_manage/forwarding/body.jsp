<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
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
</style>
<script>
   window.onload = function(){
	   l_sub1.style.display = "block";
	   l_sub1.style.position = "relative";
	   l_sub1.style.marginLeft = "10px";
   }
</script>
</head>
<body>
<container1 id = contents1>
            <table class="con1_search">
                <tr>
                    <td>거래처 명</td>
                    <td><input type="text" name="code" value='${param.general_Customer_Code}'disabled /></td>
                    <td><input type="text" name="name" value='${param.general_Customer_Name}'disabled /></td>
                    <td style="width: 50px;"><a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></a></td>
                    <td>출고기간</td>
                    <td><input type="date" id="reqInput"></td>
                    <td>~</td>
                    <td><input type="date" id="reqInput"></td>
                </tr>
            </table>
        </container1>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script>
function search1(){
	  
	openWindowPop('http://localhost:8090/webERP/member/salesmanagepop.do','salesmanagepop');  
	}
	
view_button.onclick = function(){
	  const URLSearch = new URLSearchParams(location.search);
	  URLSearch.set('submit', '1');
	  const newParam = URLSearch.toString();

	  window.open(location.pathname + '?' + newParam, '_self');
}

</script>
</body>
</html>