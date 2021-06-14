<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<% request.setCharacterEncoding("UTF-8"); %>
<% String inputNO = (String)request.getAttribute("inputNO"); %>
<% String parent = request.getParameter("Item_Code"); %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:forEach var="iup" items="${iupInsert}">
	<c:set var="Item_Code" value="${iup.Item_Code }"/>
	<c:set var="Item_Name" value="${iup.Item_Name }"/>
	<c:set var="Standard" value="${iup.Standard }"/>
	<c:set var="Unit" value="${iup.Unit }"/>
</c:forEach>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
#contents1{
            position: absolute;
            padding: 10px;
            right: 0;
            top: 15%;
            width: 85%;
            height: 12%; 
            border: 1px solid black;
            z-index: 1;
        }
        
        #contents2{
            position: absolute;
            right: 0;
            top: 27%; 
            width: 85%;
            height: 68%; 
            border: 1px solid black;
            z-index: 1;
        }
        .con1_search{
            padding:0;
            text-align: center;
            /* position: absolute; 칸 모잘라서 지움*/
            top: 25%;
            left: 18%;
        }
        #iupTable1,#view2{
            width: 100%;
            text-align: center;
            border: 1px solid black;
            
        }
        /* end default 밑으로 css 추가함*/
        .con1_search {
            margin: 10px;
        }        
        #contents2 {
            overflow: scroll;
        }

        /*탭구현 css임*/		
		ul.tabs{
			margin: 0px;
			padding: 0px;
			list-style: none;
		}
		ul.tabs li{
			background: none;
			color: black;
			display: inline-block;
			padding: 5px 5px;
			cursor: pointer;
            width: 80px;
            text-align: center;
		}


		ul.tabs li.current{
			border-top: 2px solid skyblue;			
            background-color: #ddd;        
            border-top-left-radius: 8px;
            border-top-right-radius: 8px;
		}

		.tab-content{
			display: none;	
			
		}

		.tab-content.current{
			display: inherit;
		}
        
</style>
</head>
<body>
	<container1 id = contents1>
		<form id="searchForm">
			<table class="con1_search">
                <tr>
                    <td>
                    	품번
                    </td>
                    <td style="width: 50px;">
                    	<input type="text" style="width: 100%;" name="" value='${param.Item_Code }' />
                    </td>
                    <td>
                    	<a href="javascript:search1()">
                    		<i class="fas fa-search" style="color: blue;"></i>
                    	</a>
                    </td> 
                    <td colspan="3">
                    	<input type="text" name="" value='${param.Item_Name }' disabled style="width: 100%;"/>
                    </td>
                </tr>
                <tr>
                    <td>품목군</td>
                    <td style="width: 50px;"><input type="text" style="width: 100%;"/></td>
                    <td><i class="fas fa-search" style="color: blue;"></i></td>
                    <td colspan="3"><input type="text" name="" disabled style="width: 100%;"/></td>
                </tr>
			</table>
		</form>
            <ul class="tabs" style="left: 0px; bottom: 0px; position: absolute;">
                <li class="tab-link current" data-tab="tab-1">구매단가</li>
                <li class="tab-link" data-tab="tab-2">판매단가</li>
            </ul>
        </container1>
<form id="regIup" method="get" commandName="ListVO">
	<container2 id="contents2">
		<div id="iupInfo">    
            <table id="iupTable">
                <thead align="center" style="background-color:gray">                    
                    <td><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
                    <td style="width:10px;">No</td>
                    <td>품 번</td>
                    <td>품 명</td>
                    <td>규 격</td>
                    <td>재고단위</td>
                    <td>구매단가</td>
                    <td>판매단가</td>
				</thead>
			<c:forEach var="bom" items="${bomView }">
                <tr id="updateIup" align="center">
                    <td><input type="checkbox" value = "check1" id="check" name="content"/></td>
                    <td style="width:13px;"><input type="text" name="ListVO[${status.index}].No" value='${iup.No }' readonly style="width:100%;"/></td>
                    <td><input type="text" name="ListVO[${status.index}].Item_Code" value='${iup.Item_Code }' ondbclick="search2()"/></td>
                    <td><input type="text" name="ListVO[${status.index}].Item_Name" value='${iup.Item_Name }' readonly/></td>
                    <td><input type="text" name="ListVO[${status.index}].Standard" value='${iup.Standard }' readonly/></td>
                    <td><input type="text" name="ListVO[${status.index}].Inventory_Unit" value='${iup.Inventory_Unit }' readonly/></td>
                    <td><input type="text" name="ListVO[${status.index}].Purchase_Price" value='${iup.Purchase_Price }' /></td>
                    <td><input type="text" name="ListVo[${status.index}].Sales_Price" value='${iup.Sales_Price }'/></td>                                                                            
                </tr>
			</c:forEach>
                <tr id="updateIup" align="center">
                    <td><input type="text" id="No" name="ListVO[${fn.length(iupView }].No" value='${inputNo }' readonly style="width:100%"></td>
                    <td><input type="text" id="Item_Code" name="ListVO[${fn.length(iupView)}].Item_Code" value='${param.Item_Code }' ondbclick="search2()"/></td>
                    <td><input type="text" id="Item_Name" name="ListVO[${fn.length(iupView)}].Item_Name" value='${param.Item_Name }' readonly/></td>
                    <td><input type="text" id="Standard" name="ListVO[${fn.length(iupView}].Standard" value='${param.Standard }' readonly/></td>
                    <td><input type="text" id="Inventory_Unit" name="ListVO[${fn.length(iupView}]" value='${param.Inventory_Unit }' readonly/></td>
                    <td><input type="text" id="Purchase_Price" name="ListVO[${fn.length(iupView}]" value='${param.Purchase_Price }' readonly/></td>
                    <td><input type="text" id="Sales_Price" name="ListVO[${fn.length(iupView}]" value='${param.Sales_Price }' readonly/></td>                                                        
                </tr>
            </table>
		</div>
	</container2>
	
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
    	
    	var Item_Code = document.getElementById("Item_Code");
        var Item_Name = document.getElementById("dataoutput");
        var Standard = document.getElementById("dataoutput");
        var Unit = document.getElementById("dataoutput");
        
        var Inventory_Unit = document.getElementById("dataoutput");
//	 	var Kind = document.getElementById("dataoutput"); //종류구분
		var Purchase_Price = document.getElementById("dataoutput");
		var Sales_Price = document.getElementById("dataoutput");
		
        var Inventory_Unit = document.getElementById("Inventory_Unit");
//	 	var Kind = document.getElementById("dataoutput"); //종류구분
		var Purchase_Price = document.getElementById("Purchase_Price");
		var Sales_Price = document.getElementById("Sales_Price");
		var save_button = document.getElementById("save");
		var update_button = document.getElementById("update");
		
		function search1(){
			openWindowPop('http://localhost:8090/webERP/member/iupcodehelper1.do','iupcodehelper1');
		}
		
		function search2(){
			openWindowPop('http://localhost:8090/webERP/member/iupcodehelper2.do','iupcodehelper2');
		}
		
		function setChildValue(name){
			const URLSearch = new URLSearchParams(location.search);
			URLSearch.set('submit','2');
			const newParam = URLSearch.toString();
			if(URLSearch.get('Item_Code') == null){
				window.location.href = location.pathname + '?' + newParam + '&Item_Code=' + name;
			}
			else{
				URLSearch.set('Item_Code',name);
				const newParam = URLSearch.toString();
				window.location.href = location.pathname + '?' +newParam;
			}
		}
		
		function updateRow(){
			var iupTable = document.getElementById('iupTable');
			var row = iup.insertRow();
			const URLSearch = new URLSearchParams(location.search);
			URLSearch.set('submit','1');
			const newParam = URLSearch.toString();
			var link = location.pathname + '?' + newParam;
				document.getElementById("Inventory_Unit").disabled = true;
//				document.getElementById("Kind").disabled = true;
				document.getElementById("Purchase_Price").disabled = true;
				document.getElementById("Sales_Price").disabled = true;
				document.getElementById("No").disabled = true;
			var articleNoInput = document.createElement("input");
				articleNoInput.setAttribute("type","hidden");
				articleNoInput.setAttribute("name","path");
				articleNoInput.setAttribute("value",link);
				document.getElementById('regIup').appendChild(articleNoInput);
				document.getElementById('regIup').action = "${contextPath}/member/updateIup.do";
				document.getElementById('regIup').submit();
		}
		
		function newRow(){ //DAO에서 저장
			var row = workOrderTable.insertRow();
			const URLSearch = new URLSearchParams(location.search);
			URLSearch.set('submit','1');
			const newParam = URLSearch.toString();
			var link = location.pathname + '?' + newParam;
			var articleNoInput = document.createElement("input");
			articleNoInput.setAttribute("type","hidden");
			articleNoInput.setAttribute("name","path");
			articleNoInput.setAttribute("value",link);
			document.getElementById('regIup').appendChild(articleNoInput);
			document.getElementById('regIup').action = "${contextPath}/member/addIup.do";
			document.getElementById('regIup').submit();
		}
		
		function deleteData(){
			var item = document.getElementsByName("content").length;
			var no = "";
			var ary = [];
			for(var i=0; i<item; i++){
				if(document.getElemetsByName("content")[i].checked==true){
					no = document.getElementsByName("content")[i].value;
					ary.push(no);
				}
				window.location.href = "${contextPath}/member/delIup.do?no="+ary;
			}
		}
    </script>
</body>
</html>