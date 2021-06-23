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
                    <p><td colspan="3" span style="color:black" align="center">부서등록</td></p>
                    <p><td colspan="7" span style="color:black" align="center">부문등록</td></p>
                </tr>
                <tr>
                    <td align="center">사업장</td>
                    <td >
                        <select name="workSpace" style="width: 120px;">
                        </select>
                        <i class="fas fa-search" style="color: blue;"></i>
                    </td>
                    <td align="center">조회기준일 적용</td>
                    <td>
                        <input type="checkbox">
                        <input type="date" disabled text-align: center; style="width: 130px;"/>
                    </td>                  
                    <td align="center" colspan="3" style="width:150px; text-align: right;">부문코드&nbsp;</td>
                    <td>
                        <input type=text name="sectorCode" style=" width: 80px;"/>
                    </td>
                    <td align="center">부문명</td>
                    <td>
                        <input type=text name="sectorName" style="width: 150px;"/>
                    </td>
                    <td align="center">사용기간 시작</td>
                    <td>
                        <input type="date" style="width: 130px;">
                    </td>
                </tr>
            </table>
        </container1>
        <form method="get" id="regdepartment2">
        <container2 id= contents2>
            <table id="table2" align="center">
                <thead>
                	<td><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
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
                <td><input type="checkbox" name="content"/></td>
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
    	<td><input type="text" name="ListVO[${fn:length(departmentView) }].workplace_Code" style="width: 100px;" id="workplace_Code1" /></td>
    	<td><input type="text" name="ListVO[${fn:length(departmentView) }].workplace_Name" id="workplace_Name1" /></td>
    	<td><input type="text" name="ListVO[${fn:length(departmentView) }].sector_Code" style="width: 100px;" id="sector_Code1" /></td>
    	<td><input type="text" name="ListVO[${fn:length(departmentView) }].sector_Name" id="sector_Name1" /></td>
    	<td><input type="date" name="ListVO[${fn:length(departmentView) }].usedate" id="usedate1" /></td>
    </tr>
                 </tbody>
            </table>
        </container2>
        	</form>
        <script>
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
    		document.getElementById('regdepartment').appendChild(articleNOInput);
    		document.getElementById('regdepartment').action = "${contextPath}/member/adddepartment.do";
    		document.getElementById('regdepartment').submit();
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
        </script>
</body>
</html>