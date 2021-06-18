<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"    
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>    
 <c:forEach var="set" items="${setText}" >     
 	<c:set var="itemNumber" value="${set.itemNumber }"/>
 	<c:set var="itemName" value="${set.itemName }"/>
 	<c:set var="standard" value="${set.standard }"/>
 	<c:set var="unit" value="${set.unit }"/>
 	<c:set var="actual" value="${set.cost }"/>
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
            border: 1px solid black;
            z-index: 1;
        }
        #contents2{
            position: absolute;
            left: 15%;
            top: 25%;
            width: 85%;
            height: 70%;
            border: 1px solid black;
            z-index: 1;
        }
        .con1_search{
            padding:0;
            text-align: center;
            /* position: absolute; ĭ ���߶� ����*/
            top: 25%;
            left: 5%;
        }
        #searchForm {
            height: 100%;
            margin: 20px 20px;
            padding:0;
            text-align: center;
        }
        /* �����̳� ��Ÿ�Ϻ� */
        #workOrderInfo {
            overflow: scroll;
            height: 100%;
            width: 100%;
        }
		input{
			text-align: center;
		}
</style>
</head>
<body>
 <container1 id = contents1>
            <form id="searchForm">
                <table class="con1_search">
                    <tr>
                        <td>����ó</td>
                        <td style="width: 80px;"><input type="text" value='${param.itemNumber }' id="outcode"style="width: 100%; background-color: yellow;"/></td>
                        <td> <a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></a></td> 
                        <td colspan="2"><input type="text" name="" value='${param.itemName }' disabled style="width: 100%;"/></td>
    
                        <td colspan="4" style="width: 80px;">�����۾���</td>
                        <td style="width: 80px;"><input type="text" style="width: 100%; background-color: yellow;"/></td>
                        <td> <a href="javascript:search2()"><i class="fas fa-search" style="color: blue;"></i></a></td>
                        <td><input type="text" name="" disabled/></td>
                        
                    </tr>
                    
                    <tr>
                        <td>ǰ��</td>
                        <td style="width: 80px;"><input type="text" style="width: 100%;"/></td>
                        <td>  <a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></a></td>
                        <td><input type="text" name="" disabled/></td>
    
                        <td colspan="5" style="width: 80px;">���</td>
                        <td style="width: 80px;"><input type="text" style="width: 100%; background-color: yellow;"/></td>
                        <td > <a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></a></td>
                        <td><input type="text" name="" disabled/></td>

                        <td>
                            <input type="button" value="ǰ������" style="padding: 5px; margin-left: 30px;"></input>
                        </td>
                        <td>
                            <input type="button" value="ǰ�񺹻�" style="padding: 5px;"></input>
                        </td>
                    </tr>
                </table>
            </form>
        </container1>
        <container2 id= contents2>
            <div id="workOrderInfo">
                <table id="workOrderTable">
                    <thead align="center">
                        <td><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
                        <td>ǰ��</td>
                        <td>ǰ��</td>
                        <td>�԰�</td>
                        <td>����</td>
                        <td>����</td>
                        <td>���ִܰ�</td>
                    </thead>
                    <!-- �׽�Ʈ�� ������, ���� ǥ�������� �����ʿ� -->
                    <c:forEach var="out" items='${outpriceView }'>
                    <tbody>
                        <td><input type="checkbox" value = "check1" id="check" name="content"/></td>
                        <td><input type="text" value='${out.itemNumber }'/></td>
                        <td><input type="text" value='${out.itemName }' ondblclick="search3()"/></td>
                        <td><input type="text" value='${out.standard }'/></td>
                        <td><input type="text" value='${out.unit }'/></td>
                        <td><input type="text" value='${out.actualCost }'/></td>
                        <td><input type="text" value='${out.outSourcingUnitPrice }'/></td>
                    </tbody>
                    </c:forEach>
                    <tbody>
                        <td><input type="checkbox" value = "check1" id="check" name="content"/></td>
                        <td><input type="text" value='${itemNumber} '/></td>
                        <td><input type="text" ondblclick="search3()" value='${itemName }'/></td>
                        <td><input type="text" value='${standard }' /></td>
                        <td><input type="text" value='${unit }'/></td>
                        <td><input type="text" value='${actual }'/></td>
                        <td><input type="text"/></td>
                    </tbody>
                </table>
            </div>
        </container2>
        <script>
      function openWindowPop(url, name){
          var options = 'top=0, left=0, width=320, height=420, status=no, menubar=no, toolbar=no, resizable=no';
          window.open(url, name, options);
      }
      
      function search1(){
    	      	openWindowPop('http://localhost:8090/webERP/member/outsourcingPop.do?div=1','codehelper');
      }
      function search2(){
    	  var outcode = document.getElementById('outcode');
    	      	openWindowPop('http://localhost:8090/webERP/member/outsourcingPop.do?div=2&&itemNumber='+outcode.value,'codehelper1');
      }
	  function search3(){
		  openWindowPop('http://localhost:8090/webERP/member/bomcodehelper.do','codehelper');
	  }
		function setChildValue(name){
    	  
    	  const URLSearch = new URLSearchParams(location.search);
		  URLSearch.set('submit', '2');
		  const newParam = URLSearch.toString();
        if(URLSearch.get('itemCode') == null){
		window.location.href = location.pathname +'?'+newParam + '&itemCode=' + name;
        }
        else{
        	URLSearch.set('itemCode', name);
        	const newParam = URLSearch.toString();
        	window.location.href = location.pathname +'?'+newParam;
        }
        
    }
		
		function newRow(){
			
		}
      </script>
</body>
</html>