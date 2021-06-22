<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>
<c:forEach var="com" items="${comcom}" >     
 	<c:set var="general_Customer_Code" value="${com.general_Customer_Code }"/>
 	<c:set var="general_Customer_Name" value="${com.general_Customer_Name }"/>
 	<c:set var="general_Customer_Division" value="${com.general_Customer_Division }"/>
 	<c:set var="company_Registration_Number" value="${com.company_Registration_Number }"/>
 	<c:set var="resident_Registration_Number" value="${com.resident_Registration_Number }"/>
 	<c:set var="representativs_Name" value="${com.representativs_Name }"/>>
 	<c:set var="upstate" value="${com.upstate }"/>
 	<c:set var="industry" value="${com.industry }"/>
 	<c:set var="zipCode" value="${com.zipCode }"/>
 	<c:set var="workplace_Address" value="${com.workplace_Address }"/>
 	<c:set var="generalCustomer_Tel" value="${com.generalCustomer_Tel }"/>
 	<c:set var="wholesale_Retail_Business_Code" value="${com.wholesale_Retail_Business_Code }"/>
</c:forEach>
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
            width: 35%;
            height: 70%;
            border: 1px solid #ccc;
            z-index: 1;
        }
        #contents3{
            position: absolute;
            left: 50%;
            top: 25%;
            width: 50%;
            height: 70%;
            z-index: 1;
            border: 1px solid #cc;
        }
        .con1_search {
            margin: 10px;   
        }
       
        
        #contents1 td {
            text-align: right;
            letter-spacing: 1px;
            padding: 1px;
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
        
        #table1 {
        	margin-top:30px;
        	margin-right:5px;
            width: 80%;

        }
        #table2 {
            width: 100%;
            text-align: center;
        }
        #table3 {
            width: 100%; 
        }
        
        #reqInput {
            background-color: rgb(255, 255, 149);
            text-align: center;
        }
	 	#table1 {
            text-align: center; 
			overflow: hidden;
        }
        #table2 {
            width: 100%;  text-align: left;
            border-collapse: separate; border-spacing: 0 15px;
        }
        #reqInput {
           	background-color: rgb(255, 255, 149);
            text-align: center;
        }
</style>
</head>
<body>
<container1 id = contents1>
            <table id="table1" align="center">
                <tr align="center">
                    <td align="center" style="width:80px;">거래처코드</td>
                    <td style="width:50px;">
                        <input type=text name="customerCode" style="width:100%;" value="${param.itemNumber }" pattern="[0-9]{4}" maxlength="5"/>
                    </td>
     				<td style="width:8px;">
     					<div style="text-align:center; width:100%;"><a href="javascript:searchCode()"><i class="fas fa-search" style="color :blue;"></i></a></div>
     				</td>
                    <td style="width:80px; text-align:left;">
                    	<input type=text name="ckcustomerCode" value="${param.itemName }" style="width:100%;" disabled/>
                    </td>	
                    
                    
                    <td align="center" style="width:100px; padding-right:7px;">거래처구분</td>
                    <td style="width:100px; text-align:left" >
                        <select name="customerType" >
                            <option value="default">1.일반</option>
                            <option value="2">2.무역</option>
                            <option value="3">3.주민</option>
                        </select>
                    </td>
                </tr>
            </table>
        </container1>
        
        <container2 id= contents2>
            <table id="table2" align="center">
                <thead>
                    <td><input type="checkbox" id="chec" name="content" onclick="selectAll(this)"/></td>
                    <td align="center">코드</td>
                    <td align="center">거래처명</td>
                    <td align="center">구분</td>
                </thead>
                    
                <tbody>
                <c:forEach var="com" items="${comView}" >
	                
	                <tr class="repeatedRow">
	                    <td>
	                    	<input type="checkbox" name="checkedContent" value="${com.general_Customer_Code}"/>
	                    </td>                   
	                    <td>
	                        <input type="text" onfocus = "searchView(this.value)" value="${com.general_Customer_Code}"/>
	                    </td>     
	                    <td>
	                        <input type="text" value="${com.general_Customer_Name}"/>
	                    </td>                    
	                    <td>
	                        <input type="text" value="${com.general_Customer_Division}"/>
	                    </td>
	                </tr>
	               
                </c:forEach>
                </tbody>
                
            </table>
        </container2>
        <container3 id="contents3">
        <form  method="get" id="reg_gen_account"> <!-- ****폼태그**** -->
            <table id="table3" align="center" style="margin-top:10px;">
                <tr>
                    <p><td colspan = "4" style="color:black;" align="center">기본등록사항</td></p>
                </tr>
                <tr>
                    <td align="center">코드</td>
                    <td colspan="3">
                        <input type="text" name="general_Customer_Code" id="general_Customer_Code" value="${general_Customer_Code }">
                    </td>
                </tr>
                <tr>
                    <td align="center">거래처명</td>
                    <td colspan="3">
                        <input type="text" name="general_Customer_Name" id="general_Customer_Name" value="${general_Customer_Name }">
                    </td>
                </tr>
                <tr>
                    <td align="center">구분</td>
                    <td colspan="3">
                        <input type="text" name="general_Customer_Division" id="general_Customer_Division" value="${general_Customer_Division }">
                    </td>
                </tr>
                <tr>
                    <td align="center">사업자등록번호</td>
                    <td colspan="3">
                        <input type="text" name="company_Registration_Number" id="company_Registration_Number" value="${company_Registration_Number}"
                        pattern="[0-9]{10}" maxlength="10"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">주민등록번호</td>
                    <td colspan="3">
                        <input type="text" name="resident_Registration_Number" id="resident_Registration_Number" pattern="[0-9]{13}" maxlength="13" value="${resident_Registration_Number}"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">대표자성명</td>
                    <td colspan="3">
                        <input type="text" name="representativs_Name" id="representativs_Name" value="${representativs_Name }">
                    </td>
                </tr>
                <tr>
                    <td align="center">업태</td>
                    <td colspan="3">
                        <input type="text" name="upstate" id="upstate" value="${upstate }">
                    </td>
                </tr>
                <tr>
                    <td align="center">종목</td>
                    <td colspan="3">
                        <input type="text" name="industry" id="industry" value="${industry }">
                    </td>
                </tr>
                <tr>
                    <td align="center">우편번호</td>
                    <td>
                        <input type="text" name="zipCode" id="zipCode" pattern="[0-9]{5}" maxlength="5" value="${zipCode }"
                        style="width:150px;"/>
                        <a href="javascript:searchZip()"><i class="fas fa-search" style="color :blue;"></i></a>
                    </td>
                </tr>
                <tr>
                    <td align="center">사업장주소</td>
                    <td colspan="3">
                        <input type="text" name="workplace_Address" id="workplace_Address" value="${workplace_Address }">
                    </td>
                </tr>
                <tr>
                    <td align="center">전화번호</td>
                    <td colspan="3">
                        <input type="text" name="generalCustomer_Tel" id="generalCustomer_Tel" pattern="[0-9]{10}" maxlength="10" value="${generalCustomer_Tel }"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">주류코드</td>
                    <td>
                        <input type="text" name="wholesale_Retail_Business_Code" id="wholesale_Retail_Business_Code" value="${wholesale_Retail_Business_Code }">
                    </td>
                </tr>
            </table>
        </form>
        </container3>
        <script>
        var deleteButton = document.getElementById('delete'); //삭제버튼에 이벤트를 부여하는 기능임
        deleteButton.addEventListener('click', function(){deleteData();}, false);
        
        var updateButton = document.getElementById('update'); //수정버튼에 이벤트를 부여하는 기능임
        updateButton.addEventListener('click', function(){updateRow();}, false); 
        
        var registButton = document.getElementById('save'); //저장버튼에 이벤트를 부여하는 기능임
        registButton.addEventListener('click', function(){newRow();}, false);
       
        
        function searchView(name) { //조회를 담당하는 자바스크립트임
            window.location.href = "${contextPath}/member/regbasicacc.do?submit=1&&com_code=" + name; 
        }
        
                
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
    			window.location.href = "${contextPath}/member/regbasicacc.do";
    		}
        	else //컨트롤러로 해당목록의 no값을 보낸다
    			window.location.href = "${contextPath}/member/deleteBasicacc.do?no="+ary;       	
        }
        
        
         function updateRow() {  //목록을 수정한 내용을 컨트롤러로 넘기는 함수
        	var is_empty = false; //변수 is_empty로 조건문의 분기를 만듬
        	$('#reg_gen_account').find('input[type!="hidden"]').each(function(){//값이 비어있는지 체크하는 제이쿼리
        	    if(!$(this).val()) { //#reg_gen_account는 form태그의 id값임
        	    	is_empty = true;      	    	
        	    }      	 
        	});       	 
        	if(is_empty) { //비어있는내용이 있는지 체크함
        	    alert('비어있는 내용이 있습니다. 다시입력하세요');
        	}
        	else{
	        	document.getElementById('reg_gen_account').action = "${contextPath}/member/updateBasicacc.do";
	    		document.getElementById('reg_gen_account').submit(); //폼태그*의 목록들을 컨트롤러로 전송함
	    		alert('수정되었습니다'); 
        	}      	
        } 
         
        function searchCode() { //돋보기버튼을 클릭하면 컨트롤러로 팝업에 대한 정보를 호출함       	
        	openWindowPop("${contextPath}/member/regbasicaccPopup.do", "regbasicaccPopup");
        }
        
        function searchZip() { //우편번호 검색 팝업
        	openWindowPop("${contextPath}/member/regbasicaccZipPopup.do", "regbasicaccZipPopup");
        }
        
        function setChildValue(name){
        	  
       	    const URLSearch = new URLSearchParams(location.search);
     		URLSearch.set('submit', '2');
     		const newParam = URLSearch.toString();
     		
            if(URLSearch.get('zipCode') == null){
      		window.location.href = location.pathname +'?'+newParam + '&zipCode=' + name;
            }
            else{
            	URLSearch.set('zipCode', name);
            	const newParam = URLSearch.toString();
            	window.location.href = location.pathname +'?'+newParam;
            }
        }
        
        function newRow(){
    		const URLSearch = new URLSearchParams(location.search);
    		URLSearch.set('submit','1');
    		const newParam = URLSearch.toString();
    		var link = location.pathname +'?'+newParam;
    		var articleNOInput = document.createElement("input");
    		articleNOInput.setAttribute("type","hidden");
    		articleNOInput.setAttribute("name","path");
    		articleNOInput.setAttribute("value", link);
    		document.getElementById('regcompany').appendChild(articleNOInput);
    		document.getElementById('regcompany').action = "${contextPath}/member/addcompany.do";
    		document.getElementById('regcompany').submit();
    		}
      
  
		</script>
        
</body>
</html>