<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"    
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
 	<c:set var="no" value="${set.no }"/>
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
            <form id="searchForm" method="get" commandName = "ListVO">
 <container1 id = contents1>
                <table class="con1_search">
                    <tr>
                        <td>����ó</td>
                        <td style="width: 80px;"><input type="text" name="ListVO[${fn:length(outpriceView) }].parent" value='${param.itemNumber }' id="outcode"style="width: 100%; background-color: yellow;"/></td>
                        <td> <a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></a></td> 
                        <td colspan="2"><input type="text" name="" value='${param.itemName }' disabled style="width: 100%;"/></td>
    
                        <td colspan="4" style="width: 80px;">�����۾���</td>
                        <td style="width: 80px;"><input type="text" value='${param.placeCode }' style="width: 100%; background-color: yellow;"/></td>
                        <td> <a href="javascript:search2()"><i class="fas fa-search" style="color: blue;"></i></a></td>
                        <td><input type="text" name="" disabled/></td>
                        
                    </tr>
                    
                    <tr>
                        <td>ǰ��</td>
                        <td style="width: 80px;"><input type="text"  style="width: 100%;"/></td>
                        <td>  <a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></a></td>
                        <td><input type="text" name="" disabled/></td>
    
                        <td colspan="5" style="width: 80px;">���</td>
                        <td style="width: 80px;"><input type="text" style="width: 100%;"/></td>
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
                        <td>������</td>
                        <td>������</td>
                    </thead>
                    <!-- �׽�Ʈ�� ������, ���� ǥ�������� �����ʿ� -->
                    <c:forEach var="out" items='${outpriceView }' varStatus="status">
                    <tbody>
                        <td><input type="checkbox" value = "check1" id="check" name="content" value='${out.item_code }'/></td>
                        <input type="hidden" name="outpriveVO[${status.index}].outsourcing_Code" value='${out.outsourcing_Code }'/>
                        <input type="hidden" name="outpriveVO[${status.index}].outcustomer" value='${out.outcustomer }'/>
                        <td><input type="text" name="outpriveVO[${status.index}].item_code" value='${out.item_code }' readonly/></td>
                        <td><input type="text" value='${out.bomVO.itemName }' ondblclick="search3()" readonly/></td>
                        <td><input type="text" value='${out.bomVO.standard }' readonly/></td>
                        <td><input type="text" value='${out.bomVO.unit }' readonly/></td>
                        <td><input type="text" value='${out.bomVO.cost }' readonly/></td>
                        <td><input type="text" name="outpriveVO[${status.index}].outprice" value='${out.outprice }'  /></td>
                        <td><input type="date" name="outpriveVO[${status.index}].startDate" value='${out.startDate }'/></td>
                        <td><input type="date" name="outpriveVO[${status.index}].endDate" value='${out.endDate }'/></td>
                    </tbody>
                    </c:forEach>
                    <tbody>
                        <td><input type="checkbox" value = "check1" id="check" name="content"/></td>
                        <input type="hidden" id="outsoucing" name="outpriveVO[${fn:length(outpriceView) }].outsourcing_Code" value='${param.itemNumber}'/>
                        <input type="hidden" id="placecode" name="outpriveVO[${fn:length(outpriceView) }].outcustomer" value='${param.placeCode }'/>
                        <td><input type="text" id="itemCode" name="outpriveVO[${fn:length(outpriceView) }].item_code" value='${itemNumber }' readonly /></td>
                        <td><input type="text" id="itemName"value='${itemName }'  ondblclick="search3()" readonly/></td>
                        <td><input type="text" id="standard"value='${standard }' readonly /></td>
                        <td><input type="text" id="unit"value='${unit }' readonly /></td>
                        <td><input type="text" id="cost"value='${actual }' readonly /></td>
                        <td><input type="text" id="outprice" name="outpriveVO[${fn:length(outpriceView) }].outprice"/></td>
                        <td><input type="date" id="start" name="outpriveVO[${fn:length(outpriceView) }].startDate"/></td>
                        <td><input type="date" id="end" name="outpriveVO[${fn:length(outpriceView) }].endDate"/></td>
                    </tbody>
                </table>
            </div>
            </form>
        </container2>
        <script>
        var save_button = document.getElementById('save');
        var update_button = document.getElementById('update');
        var delete_button = document.getElementById('delete');
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
		  openWindowPop('http://localhost:8090/webERP/member/outpricehelper.do','codehelper2');
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
		save_button.onclick = function(){
			const URLSearch = new URLSearchParams(location.search);
			  URLSearch.set('submit', '1');
			  const newParam = URLSearch.toString();
			 var link = location.pathname +'?'+newParam;
	  			var articleNOInput = document.createElement("input");
	  		     articleNOInput.setAttribute("type","hidden");
	  		     articleNOInput.setAttribute("name","path");
	  		     articleNOInput.setAttribute("value", link);
	  		     document.getElementById('searchForm').appendChild(articleNOInput);
	            document.getElementById('searchForm').action = "${contextPath}/member/addoutprice.do";
	  			document.getElementById('searchForm').submit();  
		}
		update_button.onclick = function(){
			document.getElementById("outsoucing").disabled = true;
 		     document.getElementById("placecode").disabled = true;
 		     document.getElementById("itemCode").disabled = true;
 		     document.getElementById("itemName").disabled = true;
 		     document.getElementById("standard").disabled = true;
 		     document.getElementById("unit").disabled = true;
 		     document.getElementById("cost").disabled = true;
 		     document.getElementById("outprice").disabled = true;
 		     document.getElementById("start").disabled = true;
 		     document.getElementById("end").disabled = true;
 		    const URLSearch = new URLSearchParams(location.search);
			  URLSearch.set('submit', '1');
			  const newParam = URLSearch.toString();
			 var link = location.pathname +'?'+newParam;
	  			var articleNOInput = document.createElement("input");
	  		     articleNOInput.setAttribute("type","hidden");
	  		     articleNOInput.setAttribute("name","path");
	  		     articleNOInput.setAttribute("value", link);
	  		     document.getElementById('searchForm').appendChild(articleNOInput);
	            document.getElementById('searchForm').action = "${contextPath}/member/updoutprice.do";
	  			document.getElementById('searchForm').submit();  
		}
		delete_button.onclick = function(){
			 var item = document.getElementsByName("content").length;
	    	  var no = "";
	    	  var ary = [];
	    	  for(var i=0; i<item;i++){
	    		  if(document.getElementsByName("content")[i].checked==true){
	    			  no = document.getElementsByName("content")[i].value;
	    			  ary.push(no);
	    		  }
	    		  
	    			  window.location.href = "${contextPath}/member/deloutprice.do?no="+ary;
	    	  }
		}
      </script>
      
</body>
</html>