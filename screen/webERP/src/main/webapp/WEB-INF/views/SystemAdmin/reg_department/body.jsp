<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"    
    isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> <!-- 제이쿼리사용을위한CDN -->
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
            width: 85%;
            height: 70%;
            border: 1px solid #ccc;
            z-index: 1;
        }
        .con1_search {
            margin: 10px;   
        }
        #contents1 {
            border-bottom: none;
            
        }
        #contents2 {
            border-bottom: none;
            
        }
        
        #contents1 td {
            text-align: right;
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

        #contents1 input[type="text"] {
            text-align: center;
        }
        #contents1 input[disabled] {
            border: 2px inset rgb(148, 147, 150);
        }
        #contents2 input {
            text-align: center;
        }
        #contents3 input {
            text-align: center;
        }        
        
        #table1 {
        	padding-left:25%;
        	padding-right:30%;
        	margin-top:18px;
        	width:100%

        }
        #table2 {
            width: 100%;
            overflow: hidden;
            
        }
</style>
</head>
<body>
<container1 id = contents1>
            <table id="table1" align="center">
                <tr>
                    <td colspan="3" span style="color:black" align="center" ><b>부서등록</b></td>
                </tr>
                <tr>
                    <td align="center">사업장</td>
                    <td >
                        <input type=text name="workSpace" style="width: 120px;" value='${param.workplace_Code }' readonly/>
                        <a href="javascript:searchitemg()"><i class="fas fa-search" style="color: blue;"></i></a>
                    </td>
                    <td align="center">사업장명</td>
                    <td >
                        <input type=text name="workSpaceName" style="width: 240px;" value='${param.workplace_Name }' readonly/>
                    </td>
                </tr>
            </table>
        </container1>
        <form method="get" id="regdepartment2">
        <container2 id= contents2>
            <table id="table2" align="center">
                <thead>
                	<td><input type="checkbox" name="checkedContent" onclick="selectAll1(this)"/></td>
                    <td align="center">부서코드</td>
                    <td align="center">부서명</td>
                    <td align="center">사업장코드</td>
                    <td align="center">사업장명</td>
                    <td align="center">부문코드</td>
                    <td align="center">부문명</td>
                    <td align="center">사용기간 시작</td>
                </thead>
                <c:forEach var="department" items="${departmentView}" varStatus="status" >
                <tbody>
                <tr id = "updateTest" align="center">
                <td><input type="checkbox" name="checkedContent" value = '${department.department_Code}' /></td>
                    <td><input type="text" name="ListVO[${status.index }].department_Code" value = '${department.department_Code}' style="width: 100px;"/></td>
                    <td><input type="text" name="ListVO[${status.index }].department_Name" value = '${department.department_Name}'/></td>
                    <td><input type="text" name="ListVO[${status.index }].workplace_Code" value = '${department.workplace_Code}' style="width: 100px;"/></td>
                    <td><input type="text" name="ListVO[${status.index }].workplace_Name" value = '${department.workplace_Name}'/></td>
                    <td><input type="text" name="ListVO[${status.index }].sector_Code" value = '${department.sector_Code}' style="width: 100px;"/></td>
                    <td><input type="text" name="ListVO[${status.index }].sector_Name" value = '${department.sector_Name}'/></td>
                    <td><input type="text" name="ListVO[${status.index }].usedate" value = '${department.usedate}'/></td>
                 </tr>
                    </tbody>
                </c:forEach>
                <tbody>
                 <tr id ="insertTest" align="center" >
    <td></td>
    	<td><input type="text" name="ListVO[${fn:length(departmentView) }].department_Code" style="width: 100px;" id="department_Code1"/></td>
    	<td><input type="text" name="ListVO[${fn:length(departmentView) }].department_Name" id="department_Name1" /></td>
    	<td><input type="text" name="ListVO[${fn:length(departmentView) }].workplace_Code" style="width: 100px;" id="workplace_Code1" value='${param.workplace_Code}' readonly/></td>
    	<td><input type="text" name="ListVO[${fn:length(departmentView) }].workplace_Name" id="workplace_Name1" value='${param.workplace_Name}' readonly/></td>
    	<td><input type="text" name="ListVO[${fn:length(departmentView) }].sector_Code" style="width: 100px;" id="sector_Code1" ondblclick="searchsector()" readonly value='${param.sector_Code}'/></td>
    	<td><input type="text" name="ListVO[${fn:length(departmentView) }].sector_Name" id="sector_Name1" readonly value='${param.sector_Name}'/></td>
    	<td><input type="date" name="ListVO[${fn:length(departmentView) }].usedate" id="usedate1" /></td>
    </tr>
                 </tbody>
            </table>
        </container2>
        	</form>
        <script>
      //체크박스함수
    	function selectAll1(selectAll1){
        	const checkbox = document.getElementsByName('checkedContent');
        	checkbox.forEach((checkbox) => {
            	checkbox.checked = selectAll1.checked;
        	})
    	}
        
        var deleteButton = document.getElementById('delete'); //삭제버튼에 이벤트를 부여하는 기능임
    	deleteButton.addEventListener('click', function(){deleteData();}, false);
        
        var updateButton = document.getElementById('update'); //수정버튼에 이벤트를 부여하는 기능임
        updateButton.addEventListener('click', function(){updateRow();}, false); 
        //등록함수
        function newRow(){
    		const URLSearch = new URLSearchParams(location.search);
    		URLSearch.set('submit','1');
    		const newParam = URLSearch.toString();
    		var link = location.pathname +'?'+newParam;
    		var articleNOInput = document.createElement("input");
    		articleNOInput.setAttribute("type","hidden");
    		articleNOInput.setAttribute("name","path");
    		articleNOInput.setAttribute("value", link);
    		document.getElementById('regdepartment2').appendChild(articleNOInput);
    		document.getElementById('regdepartment2').action = "${contextPath}/member/adddepartment.do";
    		document.getElementById('regdepartment2').submit();
    		}
        //수정함수
        function updateRow() {  //목록을 수정한 내용을 컨트롤러로 넘기는 함수
        	document.getElementById('department_Code1').disabled = true;
        	document.getElementById('department_Name1').disabled = true;
        	document.getElementById('workplace_Code1').disabled = true;
        	document.getElementById('workplace_Name1').disabled = true;
        	document.getElementById('sector_Code1').disabled = true;
        	document.getElementById('sector_Name1').disabled = true;
        	document.getElementById('usedate1').disabled = true;
       	var is_empty = false; //변수 is_empty로 조건문의 분기를 만듬
       	/* $('#regdepartment2').find('input[type!="hidden"]').each(function(){//값이 비어있는지 체크하는 제이쿼리
       	    if(!$(this).val()) { //#regdepartment2는 form태그의 id값임
       	    	is_empty = true;      	    	
       	    }      	 
       	});       	 
       	if(is_empty) { //비어있는내용이 있는지 체크함
       	    alert('비어있는 내용이 있습니다. 다시입력하세요');
       	}
       	else{ */
	        	document.getElementById('regdepartment2').action = "${contextPath}/member/upddepartment.do";
	    		document.getElementById('regdepartment2').submit(); //폼태그*의 목록들을 컨트롤러로 전송함
	    		alert('수정되었습니다'); 
       	/* } */      	
       } 
      //삭제함수
        function deleteData() {//체크박스의 체크한곳의 값을 배열로만들어 컨트롤러로 넘겨 삭제하는 기능을 하는 함수
          	var item = document.getElementsByName("checkedContent").length;
          	var no = "";
          	var ary = [];
          	
          	for(var i=0; i<item; i++) { //체크된 체크박스들의 no값을 반복문을 통하여 배열로만든다
          		if(document.getElementsByName("checkedContent")[i].checked==true) {
          			no = document.getElementsByName("checkedContent")[i].value;
          			ary.push(no);
          		}       		
          	}
          	if(ary.length === 0 || ary === null){ //체크박스가 아무것도 체크되지 않았을때
      			alert('삭제할 목록의 체크박스를 선택해주세요')
      			window.location.href = "${contextPath}/member/regdepartment.do";
      		}
          	else //컨트롤러로 해당목록의 no값을 보낸다
      			window.location.href = "${contextPath}/member/deletedepartment.do?no="+ary;       	
          }
    	//팝업
     	function searchitemg(){
		
		openWindowPop('${contextPath}/member/departmentpop.do','departmentpopup');
	}
     	function searchsector(){
    		
    		openWindowPop('${contextPath}/member/sectorpop.do','sectorpop');
    	}
     	function setChildValue(name){
      	  
      	  const URLSearch = new URLSearchParams(location.search);
  		  URLSearch.set('submit', '2');
  		  const newParam = URLSearch.toString();
          if(URLSearch.get('depCode') == null){
  		window.location.href = location.pathname +'?'+newParam + '&depCode=' + name;
          }
          else{
          	URLSearch.set('secCode', name);
          	const newParam = URLSearch.toString();
          	window.location.href = location.pathname +'?'+newParam + '&secCode=' + name;
          }
          
      }
        </script>
</body>
</html>