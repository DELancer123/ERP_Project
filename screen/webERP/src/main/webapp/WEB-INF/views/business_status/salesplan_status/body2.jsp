<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%> 
<%
	String inputNo = (String)request.getAttribute("inputNo");
	
%>
<% String parent = request.getParameter("item_code");%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:forEach var="item" items="${salesplan}"> 
	<c:set var="code" value="${item.item_code}"/>
	<c:set var="name" value="${item.item_name}"/>
</c:forEach>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

        #contents2{
            position: absolute;
            right: 0;
            top: 25%;
            width: 85%;
            height: 35%;
            border: 1px solid black;
            z-index: 1;
        }
        #contents3{
            position: absolute;
            right: 0;
            top:60%;
            width: 85%;
            height: 35%;
            border: 1px solid black;
            z-index: 1;
        }
        #view1,#view2,#v_total1{
            width: 100%;
            text-align: center;
            border: 1px solid black; 
            
        }
        #total1{
            width: 100%;
            position: absolute;
            bottom: 0;
        }
        #view2 td:not(.ch){
            width: 8%;
            font-size: 15px;
            font-weight: bold;
        }
        #view2 td input{
            width: 100%;
        }
        #view1 td:not(#non){
            width: 14.5%;
        }
        #view1 td input{
            width: 100%;
        }
        #view1 th{
            width: 4%;
        }

        #tab_div ul.tabs{
			margin: 0px;
			padding: 0px;
			list-style: none;
            
		}
		#tab_div ul.tabs li{
			background: none;
			color: black;
			display: inline-block;
			padding: 0;
			cursor: pointer;
            width: 60px;
            text-align: center;
            font-size: 13px;
		}


		#tab_div ul.tabs{
            
			margin: 0px;
			padding: 0px;
			list-style: none;
		}
		#tab_div ul.tabs li{
            
			background: none;
			color: black;
			display: inline-block;
			padding: 5px 5px;
			cursor: pointer;
            width: 80px;
            text-align: center;
            font-size: 12px;
		}


		#tab_div ul.tabs li.current{
			border-top: 2px solid skyblue;			
            background-color: #ddd;        
            border-top-left-radius: 8px;
            border-top-right-radius: 8px;
		}

		#tab_div .tab-content{
			display: none;	
			
		}

		#tab_div .tab-content.current{
			display: inherit;
		}  

</style>
</head>
<body>

        <container2 id="contents2">
            
            <table id="view1">
                <thead id="month" style="display: none;">
                    <!-- 월별 -->
                    
                    <th id="non"><input type="checkbox" name="content" onclick="selectAll(this)"/></th>
                    <th>해당월</th>
                    <th>연초수량</th>
                    <th>수정수량</th>
                    <th>차이수량</th>
                    <th>연초원화금액</th>
                    <th>수정원화금액</th>
                    <th>차이원화금액</th>
                </thead>
                <thead id="things">
                    <!-- 품목별 -->
                    <th id="non"><input type="checkbox" name="content"  onclick="selectAll(this)"/></th>
                    <th>품번</th>
                    <th>품명</th>
                    <th>규격</th>
                    <th>단위</th>
                    <th>연초수량</th>
                    <th>수정수량</th>
                    <th>차이수량</th>
                    <th>연초원화금액</th>
                    <th>수정원화금액</th>
                    <th>차이원화금액</th>
                </thead> 
                
                <thead id="set" style="display: none;"> 
                    <!-- 품목군별 -->
                    <th id="non"><input type="checkbox" name="content"  onclick="selectAll(this)"/></th>
                    <th>품목군코드</th>
                    <th>품목군명</th>
                    <th>연초수량</th>
                    <th>수정수량</th>
                    <th>차이수량</th>
                    <th>연초원화금액</th>
                    <th>수정원화금액</th>
                    <th>차이원화금액</th>
                </thead>
                      <c:forEach var="item" items="${salesplan}" varStatus="status" > 
                <tbody align="center">
                    <td  class="ch" style="width: 5%;"><input type="checkbox" name="content"/></td>
                    <td><input type="text" value="${item.item_code}"readonly/></td>
                    <td><input type="text" value="${item.item_name}" readonly/></td>
                    <td><input type="text" value="${item.standard}" readonly/></td>
                    <td><input type="text" value="${item.inventory_unit}" readonly/></td>
                    <td><input type="text" value="${item.planquantity}" readonly/></td>
                    <td><input type="text" value="${item.newquantity}" readonly/></td>
                    <td><input type="text" value="${item.planquantity-item.newquantity}" readonly/></td>
                    <td><input type="text" value="${item.planquantity*item.planprice}" readonly/></td>
                    <td><input type="text" value="${item.newquantity*item.newprice}" readonly/></td>
                    <td><input type="text" value="${item.planprice-item.newprice}" readonly/></td>
             
                    </c:forEach>
                </tbody>      
              </table>
            <div id="total1">
                <table id="v_total1">
                    <tr>
                        <td>연초수량합계</td>
                        <td>수정수량합계</td>
                        <td>차이수량합계</td>
                        <td>연초원화금액</td>
                        <td>수정원화금액</td>
                        <td>차이원화금액</td>
                    </tr>
                    <c:forEach var="item" items="${salesplan}" varStatus="status" > 
                    <tr>
                        <td><input type="text" value="${item.planquantity}" readonly/></td>
                        <td><input type="text" value="${item.newquantity}" readonly/></td>
                        <td><input type="text" value="${item.planquantity-item.newquantity}" readonly/></td>
                        <td><input type="text" value="${item.planquantity*item.planprice}" readonly/></td>
                        <td><input type="text" value="${item.newquantity*item.newprice}" readonly/></td>
                        <td><input type="text" value="${(item.planquantity*item.planprice)-(item.newquantity*item.newprice)}" readonly/></td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </container2>
        <container3 id="contents3">
            <table id="view2">
                <tr id="set2">
                    <td style="width: 3%;"><input type="checkbox" name="content" /></td>
                    <td>해당월</td>
                    <td>연초수량</td>
                    <td>수정수량</td>
                    <td>차이수량</td>
                    <td>연초원화단가</td>
                    <td>수정원화단가</td>
                    <td>연초원화금액</td>
                    <td>수정원화금액</td>
                    <td>차이원화금액</td>
                </tr>
                <c:forEach var="item" items="${salesplan}" varStatus="status" > 
                <tr align="center">
                    <td  class="ch" style="width: 5%;"><input type="checkbox" name="content"/></td>
                    <td><input type="text" value="${item.plandate}"readonly/></td>
                    <td><input type="text" value="${item.planquantity}" readonly/></td>
                    <td><input type="text" value="${item.newquantity}" readonly/></td>
                    <td><input type="text" value="${item.planquantity-item.newquantity}" readonly/></td>
                    <td><input type="text" value="${item.planprice}" readonly/></td>
                    <td><input type="text" value="${item.newprice}" readonly/></td>
                    <td><input type="text" value="${item.planquantity*item.planprice}" readonly/></td>
                    <td><input type="text" value="${item.newquantity*item.newprice}" readonly/></td>
                    <td><input type="text" value="${(item.planquantity*item.planprice)-(item.newquantity*item.newprice)}" readonly/></td>
                </c:forEach>
                    </tr>
                
                <tr id="month2" style="display: none;">
                    <td style="width: 3%;"><input type="checkbox" name="content" /></td>
                    <td>품번</td>
                    <td>품명</td>
                    <td>규격</td>
                    <td>단위</td>
                    <td>연초수량</td>
                    <td>수정수량</td>
                    <!-- <td>차이수량</td> -->
                    <td>연초원화단가</td>
                    <td>수정원화단가</td>
                    <!-- <td>연초원화금액</td>
                    <td>수정원화금액</td>
                    <td>차이원화금액</td> -->
                </tr>

            </table>
            <div id="total1">
                <table id="v_total1">
                    <tr >
                        <td>연초수량합계</td>
                        <td>수정수량합계</td>
                        <td>차이수량합계</td>
                        <td>연초원화금액</td>
                        <td>수정원화금액</td>
                        <td>차이원화금액</td>
                    </tr>
                    <c:forEach var="item" items="${salesplan}" varStatus="status" > 
                    <tr>
                     	<td><input type="text" value="${item.planquantity}" readonly/></td>
                    	<td><input type="text" value="${item.newquantity}" readonly/></td>
                    	<td><input type="text" value="${item.planquantity-item.newquantity}" readonly/></td>
                        <td><input type="text" value="${item.planquantity*item.planprice}" readonly/></td>
                   		<td><input type="text" value="${item.newquantity*item.newprice}" readonly/></td>
                    	<td><input type="text" value="${(item.planquantity*item.planprice)-(item.newquantity*item.newprice)}" readonly/></td>
               
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </container3>
        <script>
        var plus_button = document.getElementById('plus');
        var minus_button = document.getElementById('minus');
        var month_button = document.getElementById('month_button');
        var things_button = document.getElementById('things_button');
        var set_button = document.getElementById('set_button');
        plus_button.onclick = function(){
            var year = document.getElementById('year');
            year.value =Number(year.value) + 1;
        }
        minus_button.onclick = function(){
            var year = document.getElementById('year');
            year.value =Number(year.value) - 1;
        }
        month_button.onclick = function(){
            var month = document.getElementById('month');
            var things = document.getElementById('things');
            var set = document.getElementById('set');
            var month2 = document.getElementById('month2');
            var set2 = document.getElementById('set2');
            month.style.display = "block";
            set.style.display = "none";
            things.style.display = "none";
            month2.style.display = "block";
            set2.style.display = "none";
            
        }
        things_button.onclick = function(){
            var month = document.getElementById('month');
            var things = document.getElementById('things');
            var set = document.getElementById('set');
            var month2 = document.getElementById('month2');
            var set2 = document.getElementById('set2');
            month.style.display = "none";
            set.style.display = "none";
            things.style.display = "block";
            month2.style.display = "none";
            set2.style.display = "block";
            
        }
        set_button.onclick = function(){
            var month = document.getElementById('month');
            var things = document.getElementById('things');
            var set = document.getElementById('set');
            var month2 = document.getElementById('month2');
            var set2 = document.getElementById('set2');
            month.style.display = "none";
            set.style.display = "block";
            things.style.display = "none";
            month2.style.display = "none";
            set2.style.display = "block";
            
        }
        
    </script>
    <script src="http://code.jquery.com/jquery-latest.js"></script> <!--제이쿼리최신버젼가져옴-->
    <script>
        $(document).ready(function(){
        
        $('ul.tabs li').click(function(){
            var tab_id = $(this).attr('data-tab');
    
            $('ul.tabs li').removeClass('current');
            $('.tab-content').removeClass('current');
    
            $(this).addClass('current');
            $("#"+tab_id).addClass('current');
        })
    
    })
    </script>
</body>
</html>