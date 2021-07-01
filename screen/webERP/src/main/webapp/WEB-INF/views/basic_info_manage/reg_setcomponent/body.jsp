<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%
request.setCharacterEncoding("UTF-8");
%>
<c:forEach var="set" items="${setset}" >     
 	<c:set var="set_Code" value="${set.set_Code }"/>
 	<c:set var="set_Name" value="${set.set_Name }"/>
 	<c:set var="set_Standard" value="${set.set_Standard }"/>
 	<c:set var="set_Unit" value="${set.set_Unit }"/>
</c:forEach>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>SET����ǰ���</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> <!-- �����������������CDN -->
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
        #view{
            width: 100%;
            text-align: center;
            border: 1px solid black;
        }

        #view td input:not(#check){
            width: 100%;
        }
        .con1_search{
            padding:0;
            text-align: center;
            position: absolute;
            top: 25%;
            left: 10%;
        }
</style>
<script>
   window.onload = function(){
	   l_sub2.style.display = "block";
	   l_sub2.style.position = "relative";
	   l_sub2.style.marginLeft = "10px";
   }
</script>
</head>
<body>
		<container1 id = contents1>
		<form method="get" id="searchForm">
            <table class="con1_search">
                <tr>
                    <td>��Ʈǰ</td>
                    <td>
                        <select name="" id="">
                            <option value="0">0.ǰ��</option>
                            <option value="1">1.ǰ��</option>
                            <option value="2">2.�԰�</option>
                        </select>
                    </td>
                    <td><input type="text" name="" id=""></td>
                    <td>ǰ��</td>
                    <td>
                        <input type="text">
                        <i class="fas fa-search" style="color: blue;"></i>
                    </td>
                    <td><input type="text" name="" id="" disabled></td>
                    <td>��������</td>
                    <td>
                        <select name="" id="">
                            <option value="7">��ü</option>
                            <option value="0">0.�����</option>
                            <option value="1">1.�����</option>
                            <option value="2">2.��ǰ</option>
                            <option value="4">4.����ǰ</option>
                            <option value="5">5.��ǰ</option>
                            <option value="6">6.����ǰ</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>����ǰ</td>
                    <td>
                        <select name="" id="">
                            <option value="0">0.ǰ��</option>
                            <option value="1">1.ǰ��</option>
                            <option value="2">2.�԰�</option>
                        </select>
                    </td>
                    <td><input type="text" name="" id=""></td>
                    <td>ǰ��</td>
                    <td>
                        <input type="text">
                        <i class="fas fa-search" style="color: blue;"></i>
                    </td>
                    <td><input type="text" name="" id="" disabled></td>
                    <td>��������</td>
                    <td>
                        <select name="" id="">
                            <option value="7">��ü</option>
                            <option value="0">0.�����</option>
                            <option value="1">1.�����</option>
                            <option value="2">2.��ǰ</option>
                            <option value="4">4.����ǰ</option>
                            <option value="5">5.��ǰ</option>
                            <option value="6">6.����ǰ</option>
                        </select>
                    </td>
                </tr>
            </table>
        </form>
        </container1>
        <container2 id="contents2">
        <form  method="get" id="reg_setcom1">
           <table id="view">
                <thead>
                    <td colspan="5">��Ʈǰ ���</td>
                </thead>
                <thead style="font-weight: bold;">
                    <td style="width: 5%;"></td>
                    <td>ǰ��</td>
                    <td>ǰ��</td>
                    <td>�԰�</td>
                    <td>����(����)</td>
                </thead>
                <c:forEach var="set" items="${setView}" >
	                <tbody>
	                    <td style="width: 5%;"><input type="checkbox" value = "${set.set_Code }" name="checkedContent"/></td>
	                    <td><input type="text" id="set_Code" name="set_Code" value = "${set.set_Code }" onfocus = "searchView(this.value)"></td>
	                    <td><input type="text" id="set_Name" name="set_Name" value = "${set.set_Name }"></td>
	                    <td><input type="text" id="set_Standard" name="set_Standard" value = "${set.set_Standard }"></td>
	                    <td><input type="text" id="set_Unit" name="set_Unit" value = "${set.set_Unit }"></td>
	                </tbody>
                </c:forEach>
                <tr>
                    <td colspan="5">
                        <button onclick="searchView(this.value)"
                        style="background-color: rgb(235, 235, 235); 
                        border-style: none; 
                        text-align: center; width:99%">�űԵ��</button>
                    </td>
                </tr>
           </table>
        </form>
        </container2>
        <container3 id="contents3">
        <form  method="get" id="reg_setcom2">
            <table id="view">
                <thead>
                    <td colspan="12">����ǰ ���</td>
                </thead>
                <thead style="font-weight: bold;">
                    <td></td>
                    <td>��Ʈǰ�ڵ�</td>
                    <td>����ǰ�ڵ�</td>
                    <td>ǰ��</td>
                    <td>����</td>
                    <td>����</td>
                    <td>�԰�</td>
                </thead>
                <c:forEach var="compo" items="${compoView}" >
                <tbody>
                    <td style="width: 5%;"><input type="checkbox" value = "${compo.set_Code }" id="check" name="content1"/></td>
                    <td><input type="text" name="set_Code" id="set_Code" value = "${compo.set_Code }"></td>
                    <td><input type="text" name="components_Code" id="components_Code" value = "${compo.components_Code }"></td>
                    <td><input type="text" name="components_Name" id="components_Name" value = "${compo.components_Name }"></td>
                    <td><input type="text" name="components_Standard" id="components_Standard" value = "${compo.components_Standard }"></td>
                    <td><input type="text" name="components_Unit" id="components_Unit" value = "${compo.components_Unit }"></td>
                    <td><input type="text" name="components_Stock" id="components_Stock"value = "${compo.components_Stock }"></td>
                </tbody>
                </c:forEach>
            </table>
        </form>
        </container3>
        <script>
        var set_Code = document.getElementById("set_Code");
        var set_Name = document.getElementById("set_Name");
        var set_Standard = document.getElementById("set_Standard");
        var set_Unit = document.getElementById("set_Unit");
        var components_Code = document.getElementById("components_Code");
        var components_Name = document.getElementById("components_Name");
        var components_Standard = document.getElementById("components_Standard");
        var components_Unit = document.getElementById("components_Unit");
        var components_Stock = document.getElementById("components_Stock");
        
        function searchView(name) { //��ȸ�� ����ϴ� �ڹٽ�ũ��Ʈ��
            window.location.href = "${contextPath}/member/regsetcom.do?submit=1&&com_code=" + name; 
        }
        
        function searchData() {
        	var searchForm = $('#searchForm');
        	var is_empty = false; //���� is_empty�� ���ǹ��� �б⸦ ����
        	$('#searchForm').find('input[type!="hidden"]').each(function(){//���� ����ִ��� üũ�ϴ� ��������
        	    if(!$(this).val()) { //#reg_gen_account�� form�±��� id����
        	    	is_empty = true;      	    	
        	    }      	 
        	});       	 
        	if(is_empty) { //����ִ³����� �ִ��� üũ��
        	    alert('�˻������� ����ֽ��ϴ�');
        	}
        	else{	        	
	    		searchForm.submit();
        	} 
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
    			alert('������ ����� üũ�ڽ��� �������ּ���');
    			window.location.href = "${contextPath}/member/regsetcom.do";
    		}
        	else {//��Ʈ�ѷ��� �ش����� no���� ������
        		alert('���� �Ǿ����ϴ�');
    			window.location.href = "${contextPath}/member/deleteSetComponents.do?no="+ary;
        	}
        }
        
        function newRow(){
        	if(general_Customer_Code == "" || general_Customer_Name == "" || general_Customer_Division.value == "" || company_Registration_Number.value == "" || representativs_Name.value == "" || upstate.value == "" || industry.value == "" || zipCode.value == "" || workplace_Address.value == "" )
        		{
        		alert('�ʼ� �Է��׸��� ����ֽ��ϴ�. ��� �Է����ּ���.')
        		} else {
        			
			alert('��ϵǾ����ϴ�');        	
    		const URLSearch = new URLSearchParams(location.search);
    		URLSearch.set('submit','1');
    		const newParam = URLSearch.toString();
    		var link = location.pathname +'?'+newParam;
    		var articleNOInput = document.createElement("input");
    		articleNOInput.setAttribute("type","hidden");
    		articleNOInput.setAttribute("name","path");
    		articleNOInput.setAttribute("value", link);
    		document.getElementById('reg_gen_account').appendChild(articleNOInput);
    		document.getElementById('reg_gen_account').action = "${contextPath}/member/addSetComponents.do";
    		document.getElementById('reg_gen_account').submit();
    	}
        }
        
        function updateRow() {  //����� ������ ������ ��Ʈ�ѷ��� �ѱ�� �Լ�
        	if(general_Customer_Code.value == "" || general_Customer_Name.value == "" || general_Customer_Division.value == "" || company_Registration_Number.value == "" || representativs_Name.value == "" || upstate.value == "" || industry.value == "" || zipCode.value == "" || workplace_Address.value == "" )
    		{
    		alert('�ʼ� �Է��׸��� ����ֽ��ϴ�. ��� �Է����ּ���.')
    		}
        	else{
	        	document.getElementById('reg_gen_account').action = "${contextPath}/member/updateSetComponents.do";
	    		document.getElementById('reg_gen_account').submit(); //���±�*�� ��ϵ��� ��Ʈ�ѷ��� ������
	    		alert('�����Ǿ����ϴ�'); 
        	}      	
        } 
         
        function searchCode() { //�������ư�� Ŭ���ϸ� ��Ʈ�ѷ��� �˾��� ���� ������ ȣ����       	
        	openWindowPop("${contextPath}/member/regbasicaccPopup.do", "regbasicaccPopup");
        }
        
        function searchZip() { //�����ȣ �˻� �˾��� ���� �Լ�
        	openWindowPop("${contextPath}/member/regbasicaccZipPopup.do", "regbasicaccZipPopup");
        } 
        </script>
</body>
</html>