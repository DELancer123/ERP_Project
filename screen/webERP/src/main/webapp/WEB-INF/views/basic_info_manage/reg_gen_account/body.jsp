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
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> <!-- �����������������CDN -->
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
                    <td align="center" style="width:80px;">�ŷ�ó�ڵ�</td>
                    <td style="width:50px;">
                        <input type=text name="customerCode" style="width:100%;" value="${param.itemNumber }" pattern="[0-9]{4}" maxlength="5"/>
                    </td>
     				<td style="width:8px;">
     					<div style="text-align:center; width:100%;"><a href="javascript:searchCode()"><i class="fas fa-search" style="color :blue;"></i></a></div>
     				</td>
                    <td style="width:80px; text-align:left;">
                    	<input type=text name="ckcustomerCode" value="${param.itemName }" style="width:100%;" disabled/>
                    </td>	
                    
                    
                    <td align="center" style="width:100px; padding-right:7px;">�ŷ�ó����</td>
                    <td style="width:100px; text-align:left" >
                        <select name="customerType" >
                            <option value="default">1.�Ϲ�</option>
                            <option value="2">2.����</option>
                            <option value="3">3.�ֹ�</option>
                        </select>
                    </td>
                </tr>
            </table>
        </container1>
        
        <container2 id= contents2>
            <table id="table2" align="center">
                <thead>
                    <td><input type="checkbox" id="chec" name="content" onclick="selectAll(this)"/></td>
                    <td align="center">�ڵ�</td>
                    <td align="center">�ŷ�ó��</td>
                    <td align="center">����</td>
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
        <form  method="get" id="reg_gen_account"> <!-- ****���±�**** -->
            <table id="table3" align="center" style="margin-top:10px;">
                <tr>
                    <p><td colspan = "4" style="color:black;" align="center">�⺻��ϻ���</td></p>
                </tr>
                <tr>
                    <td align="center">�ڵ�</td>
                    <td colspan="3">
                        <input type="text" name="general_Customer_Code" id="general_Customer_Code" value="${general_Customer_Code }">
                    </td>
                </tr>
                <tr>
                    <td align="center">�ŷ�ó��</td>
                    <td colspan="3">
                        <input type="text" name="general_Customer_Name" id="general_Customer_Name" value="${general_Customer_Name }">
                    </td>
                </tr>
                <tr>
                    <td align="center">����</td>
                    <td colspan="3">
                        <input type="text" name="general_Customer_Division" id="general_Customer_Division" value="${general_Customer_Division }">
                    </td>
                </tr>
                <tr>
                    <td align="center">����ڵ�Ϲ�ȣ</td>
                    <td colspan="3">
                        <input type="text" name="company_Registration_Number" id="company_Registration_Number" value="${company_Registration_Number}"
                        pattern="[0-9]{10}" maxlength="10"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">�ֹε�Ϲ�ȣ</td>
                    <td colspan="3">
                        <input type="text" name="resident_Registration_Number" id="resident_Registration_Number" pattern="[0-9]{13}" maxlength="13" value="${resident_Registration_Number}"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">��ǥ�ڼ���</td>
                    <td colspan="3">
                        <input type="text" name="representativs_Name" id="representativs_Name" value="${representativs_Name }">
                    </td>
                </tr>
                <tr>
                    <td align="center">����</td>
                    <td colspan="3">
                        <input type="text" name="upstate" id="upstate" value="${upstate }">
                    </td>
                </tr>
                <tr>
                    <td align="center">����</td>
                    <td colspan="3">
                        <input type="text" name="industry" id="industry" value="${industry }">
                    </td>
                </tr>
                <tr>
                    <td align="center">�����ȣ</td>
                    <td>
                        <input type="text" name="zipCode" id="zipCode" pattern="[0-9]{5}" maxlength="5" value="${zipCode }"
                        style="width:150px;"/>
                        <a href="javascript:searchZip()"><i class="fas fa-search" style="color :blue;"></i></a>
                    </td>
                </tr>
                <tr>
                    <td align="center">������ּ�</td>
                    <td colspan="3">
                        <input type="text" name="workplace_Address" id="workplace_Address" value="${workplace_Address }">
                    </td>
                </tr>
                <tr>
                    <td align="center">��ȭ��ȣ</td>
                    <td colspan="3">
                        <input type="text" name="generalCustomer_Tel" id="generalCustomer_Tel" pattern="[0-9]{10}" maxlength="10" value="${generalCustomer_Tel }"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">�ַ��ڵ�</td>
                    <td>
                        <input type="text" name="wholesale_Retail_Business_Code" id="wholesale_Retail_Business_Code" value="${wholesale_Retail_Business_Code }">
                    </td>
                </tr>
            </table>
        </form>
        </container3>
        <script>
        var deleteButton = document.getElementById('delete'); //������ư�� �̺�Ʈ�� �ο��ϴ� �����
        deleteButton.addEventListener('click', function(){deleteData();}, false);
        
        var updateButton = document.getElementById('update'); //������ư�� �̺�Ʈ�� �ο��ϴ� �����
        updateButton.addEventListener('click', function(){updateRow();}, false); 
        
        var registButton = document.getElementById('save'); //�����ư�� �̺�Ʈ�� �ο��ϴ� �����
        registButton.addEventListener('click', function(){newRow();}, false);
       
        
        function searchView(name) { //��ȸ�� ����ϴ� �ڹٽ�ũ��Ʈ��
            window.location.href = "${contextPath}/member/regbasicacc.do?submit=1&&com_code=" + name; 
        }
        
                
        function deleteData() {//üũ�ڽ��� üũ�Ѱ��� ���� �迭�θ���� ��Ʈ�ѷ��� �Ѱ� �����ϴ� ����� �ϴ� �Լ�
        	var item = document.getElementsByName("checkedContent").length;
        	var no = "";
        	var ary = [];
        	
        	for(var i=0; i<item; i++) { //üũ�� üũ�ڽ����� no���� �ݺ����� ���Ͽ� �迭�θ����
        		if(document.getElementsByName("checkedContent")[i].checked==true) {
        			no = document.getElementsByName("checkedContent")[i].value;
        			ary.push(no);
        		}       		
        	}
        	if(ary.length === 0 || ary === null){ //üũ�ڽ��� �ƹ��͵� üũ���� �ʾ�����
    			alert('������ ����� üũ�ڽ��� �������ּ���')
    			window.location.href = "${contextPath}/member/regbasicacc.do";
    		}
        	else //��Ʈ�ѷ��� �ش����� no���� ������
    			window.location.href = "${contextPath}/member/deleteBasicacc.do?no="+ary;       	
        }
        
        
         function updateRow() {  //����� ������ ������ ��Ʈ�ѷ��� �ѱ�� �Լ�
        	var is_empty = false; //���� is_empty�� ���ǹ��� �б⸦ ����
        	$('#reg_gen_account').find('input[type!="hidden"]').each(function(){//���� ����ִ��� üũ�ϴ� ��������
        	    if(!$(this).val()) { //#reg_gen_account�� form�±��� id����
        	    	is_empty = true;      	    	
        	    }      	 
        	});       	 
        	if(is_empty) { //����ִ³����� �ִ��� üũ��
        	    alert('����ִ� ������ �ֽ��ϴ�. �ٽ��Է��ϼ���');
        	}
        	else{
	        	document.getElementById('reg_gen_account').action = "${contextPath}/member/updateBasicacc.do";
	    		document.getElementById('reg_gen_account').submit(); //���±�*�� ��ϵ��� ��Ʈ�ѷ��� ������
	    		alert('�����Ǿ����ϴ�'); 
        	}      	
        } 
         
        function searchCode() { //�������ư�� Ŭ���ϸ� ��Ʈ�ѷ��� �˾��� ���� ������ ȣ����       	
        	openWindowPop("${contextPath}/member/regbasicaccPopup.do", "regbasicaccPopup");
        }
        
        function searchZip() { //�����ȣ �˻� �˾�
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