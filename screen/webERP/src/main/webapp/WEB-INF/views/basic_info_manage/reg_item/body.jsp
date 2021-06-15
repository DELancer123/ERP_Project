<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"    
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>
<c:forEach var="item1" items="${comitem}" >     
 	<c:set var="item_Code" value="${item1.item_Code  }"/>
 	<c:set var="item_Name" value="${item1.item_Name }"/>
 	<c:set var="standard" value="${item1.standard }"/>
 	<c:set var="inventory_Unit" value="${item1.inventory_Unit }"/>
 	<c:set var="whether_LOT" value="${item1.whether_LOT }"/>
 	<c:set var="sET_Item" value="${item1.sET_Item }"/>
 	<c:set var="inspection_Status" value="${item1.inspection_Status }"/>
 	<c:set var="use_Status" value="${item1.use_Status }"/>
 	<c:set var="lOT_Quantity" value="${item1.lOT_Quantity }"/>
 	<c:set var="drawing_Number" value="${item1.drawing_Number }"/>
 	<c:set var="hs_Code" value="${item1.hs_Code }"/>
 	<c:set var="width" value="${item1.width }"/>
 	<c:set var="length" value="${item1.length }"/>
 	<c:set var="height" value="${item1.height }"/>
 	<c:set var="cost" value="${item1.cost }"/>
 	<c:set var="item_Group_Code " value="${item1.item_Group_Code  }"/>
 	<c:set var="division" value="${item1.division }"/> 	
 	<c:set var="notes" value="${item1.notes }"/>
 	<c:set var="daily_production" value="${item1.daily_production }"/>

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
            width: 85%;
            height: 10%;
            border: 1px solid #ccc;
            z-index: 1;
        }
        #contents2{
            position: absolute;
            left: 15%;
            top: 25%;
            width: 25%;
            height: 70%;
            border: 1px solid #ccc;
            z-index: 1;
        }
        #contents3{
            position: absolute;
            left: 40%;
            top: 25%;
            width: 60%;
            height: 70%;
            z-index: 1;
            border: 1px solid #ccc;
        }
        .con1_search {
            margin: 10px;   
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
        }
        #contents3 td {
            border-collapse: collapse;
            padding: 3px;
        }

        
        #contents2, #contents3 td{
            border-collapse: collapse;    
        }
        
        #contents1 input[type="text"] {
            text-align: center;
        }
        
        #contents2 input[type="text"] {
            text-align: center;
            width: 100%;
        }
        #contents3 input {
            text-align: center;
        }        
        #contents2, #contents3 {
            overflow: auto;   
        }
      
        #table1 {
            width: 70%;
            padding-top: 20px;
            padding-left: 30px;
        }
        #table2 {
            width: 91%;
            text-align: center;
        }
        #table3 {
            padding-left: 30px;
            padding-top: 15px;
            width: 100%; 
        }
        #bottom1 {
			position:fixed;
			bottom:0px;
        }
        
        #reqInput {
            background-color: rgb(255, 255, 149);
            text-align: center;
        }
</style>
</head>
<body>
<container1 id = contents1>
            <table id="table1">
                <tr>
                    <td>ǰ��</td>
                    <td>
                        <input type=text style="width:80px;">
                        <i class="fas fa-search" style="color: blue;"></i>
                    </td>
                    <td>
                        <input type=text>
                    </td>
                </tr>
                <tr>
                    <td>�˻�����</td>
                    <td>
                        <select name="" id="">
                            <option value="0">0.���۹��ڿ�</option>
                            <option value="1">1.���Թ��ڿ�</option>
                        </select>
                    </td>
                    <td>
                        <input type="text" value=" ǰ�� �˻�" id="search1">
                    </td>
                    <td>
                        <input type="text" value=" ǰ�� �˻�" id="search2">
                    </td>
                    <td>
                        <input type="text" value=" �԰� �˻�" id="search3">
                    </td>
                </tr>
            </table>
        </container1>
        <container2 id= contents2>
            <table id="table2">
                <thead>
                    <td><input type="checkbox" name="content" onclick="selectAll(this)" id="focus1" /></td>
                    <td>ǰ��</td>
                    <td>ǰ��</td>
                    <td>�԰�</td>
                </thead>
                <c:forEach var="item" items="${itemView}" > 
                <tbody>
                    <td><input type="checkbox" value = "check1" id="check" name="content"/></td>
                    <td>
                        <input type="text" value='${item.item_Code }' onfocus="searchView(this.value)">
                    </td>
                    <td>
                        <input type="text" value='${item.item_Name }'>
                    </td>
                    <td>
                        <input type="text" value='${item.standard }'>
                    </td>
                </tbody>
                </c:forEach>
            </table>
            <div id=bottom1>
                <table>
                    <td>��ȸǰ���</td>
                    <td><input type="text" style="width: 50px;">��</td>
                </table>
            </div>
        </container2>
        <container3 id="contents3">
            <table id="table3">
                <tr>
                    <td align="center">ǰ��</td>
                    <td>
                        <input type="text" disabled value='${item_Code }'>
                    </td>
                </tr>
                <tr>
                    <td align="center">ǰ��</td>
                    <td>
                        <input type="text" disabled value='${item_Name }'>
                    </td>
                </tr>
                <tr>
                    <td align="center">�԰�</td>
                    <td>
                        <input type="text" disabled value='${standard }'>
                    </td>
                </tr>
                <tr>
                    <td align="center">������</td>
                    <td>
                        <input type="text" id="reqInput" value='${inventory_Unit }'>
                    </td>
                </tr>
                <!-- <tr>
                    <td align="center">ǰ��</td>
                    <td>
                        <input type="text" style="width: 70px;">
                        <button>+</button>
                        <input type="text" style="width: 100px;">
                    </td>
                </tr> -->
                <tr>
                    <td align="center">LOT����</td>
                    <td>
                        <select name="" id="reqInput">
                            <option value="0">0.�̻��</option>
                            <option value="1">1.�̻��</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="center">SETǰ��</td>
                    <td>
                        <select name="" id="reqInput">
                            <option value="0">0.��</option>
                            <option value="1">1.��</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="center">�˻翩��</td>
                    <td>
                        <select name="" id="reqInput">
                            <option value="0">0.���˻�</option>
                            <option value="1">1.�˻�</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="center">��뿩��</td>
                    <td>
                        <select id="reqInput">
                            <option value="0.">0.��</option>
                            <option value="1">1.��</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="center">LOT����</td>
                    <td>
                        <input type="text" value='${lOT_Quantity }'>
                    </td>
                </tr>
                <tr>
                    <td align="center">�����ȣ</td>
                    <td>
                        <input type="text" value='${drawing_Number }'>
                    </td>
                </tr>
                <tr>
                    <td align="center">HS CODE</td>
                    <td>
                        <input type="text" value='${hs_Code }'>
                    </td>
                </tr>
                <tr>
                    <td align="center">��</td>
                    <td>
                        <input type="text"  value='${width }'>
                    </td>
                </tr>
                <tr>
                    <td align="center">����</td>
                    <td>
                        <input type="text"  value='${length } '>
                    </td>
                </tr>
                <tr>
                    <td align="center">����</td>
                    <td>
                        <input type="text"  value='${height }'>
                    </td>
                </tr>
                <tr>
                    <td align="center">����</td>
                    <td>
                        <input type="text"  value='${cost }'>
                    </td>
                </tr>
                <tr>
                    <td align="center">��/����ǰ</td>
                    <td>
                        <input type="text" value='${division }'>
                    </td>
                </tr>
                <tr>
                    <td align="center">���</td>
                    <td>
                        <input type="text"  value='${notes }'>
                    </td>
                </tr>
                <tr>
                    <td align="center">�ϻ��귮</td>
                    <td>
                        <input type="text" disabled value='${daily_production }'>
                    </td>
                </tr>
            </table>
        </container3>
        <script>
        	var search_box1 = document.getElementById('search1');
        	var search_box2 = document.getElementById('search2');
        	var search_box3 = document.getElementById('search3');
        	search_box1.onfocus = function(){
                document.getElementById("search1").value = '';
            }
            search_box1.onblur = function(){
                document.getElementById("search1").value = ' ǰ�� �˻�';
            }
            search_box2.onfocus = function(){
                document.getElementById("search2").value = '';
            }
            search_box2.onblur = function(){
                document.getElementById("search2").value = ' ǰ�� �˻�';
            }
            search_box3.onfocus = function(){
                document.getElementById("search3").value = '';
            }
            search_box3.onblur = function(){
                document.getElementById("search3").value = ' �԰� �˻�';
            }
            function searchView(name) {
            	console.log('Ȯ��');
             	window.location.href = "${contextPath}/member/regitem.do?submit=1&&item_code=" + name; 
            }
        </script>
        
</body>
</html>