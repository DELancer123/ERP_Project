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
            width: 85%;
            height: 70%;
            border: 1px solid #ccc;
            z-index: 1;
        }
        .con1_search {
            margin: 10px;   
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
            text-align: center;
            letter-spacing: 1px;
            padding: 1px;
            font-family: 'Hanna';
        }
        #contents2 td {
            border-collapse: collapse;
            padding: 3px;
            text-align: center;
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
            width: 70%;
            padding-top: 15px;
            padding-left: 25px;
            text-align: center;
            margin-top: 18px;
        }
        #table2 {
            width: 60%;
        }
</style>
</head>
<body>
<form method="get" id="regItemg">
<container1 id = contents1>
            <table id="table1" align="center">
                
                <tr>
                    <td align="center">�˻�����</td>
                </tr>
            </table>
        </container1>
        <container2 id= contents2>
            <table id="table2" align="center">
                <tr>
                    <td>
                        <input type="checkbox" name="checkedContent" onclick="selectAll1(this)"/>
                    </td>
                    <td>ǰ���ڵ�</td>
                    <td>ǰ�񱺸�</td>
                    <td>��뿩��</td>
                    <td>ǰ�񱺼���</td>
                </tr>
                <c:forEach var="itemg" items="${itemgView}" varStatus="status" >  
                <tr id = "updateTest" align="center">
                <td><input type="checkbox" name="checkedContent" value='${itemg.item_Group_Code}'/></td>
                    <td><input type="text" name="ListVO[${status.index }].item_Group_Code" value = '${itemg.item_Group_Code}'/></td>
                    <td><input type="text" name="ListVO[${status.index }].item_Group_Name" value = '${itemg.item_Group_Name}'/></td>
                    <td><select name="ListVO[${status.index }].use_Status">
    					<option value=0 <c:if test="${itemg.use_Status == 0}">selected</c:if>>0.��</option>
    					<option value=1 <c:if test="${itemg.use_Status == 1}">selected</c:if>>1.��</option>
    				</select></td>
                    <td><input type="text" name="ListVO[${status.index }].explanation" value = '${itemg.explanation}'/></td>
                 </tr>
                </c:forEach>
                <tbody>
                 <tr id ="insertTest" align="center" >
    <td></td>
    	<td><input type="text" name="ListVO[${fn:length(itemgView) }].item_Group_Code" id="item_Group_Code1" style="background-color: rgb(255, 255, 149);"/></td>
    	<td><input type="text" name="ListVO[${fn:length(itemgView) }].item_Group_Name" id="item_Group_Name1" style="background-color: rgb(255, 255, 149);"/></td>
    	<td>
    	<select name="ListVO[${fn:length(itemgView) }].use_Status" id="use_Status1" style="background-color: rgb(235,235,235);">
    	<option value=0 <c:if test="${itemg.use_Status == 0}">selected</c:if>>0.��</option>
    	<option value=1 <c:if test="${itemg.use_Status == 1}">selected</c:if>>1.��</option>
    	</select>
    	</td>
    	<td><input type="text" name="ListVO[${fn:length(itemgView) }].explanation" id="explanation1" style="background-color: rgb(235,235,235);"/></td>
    </tr>
                 </tbody>
            </table>
        </container2>
        </form>
        <script>
      //üũ�ڽ��Լ�
    	function selectAll1(selectAll1){
        	const checkbox = document.getElementsByName('checkedContent');
        	checkbox.forEach((checkbox) => {
            	checkbox.checked = selectAll1.checked;
        	})
    	}
        
        var deleteButton = document.getElementById('delete'); //������ư�� �̺�Ʈ�� �ο��ϴ� �����
        deleteButton.addEventListener('click', function(){deleteData();}, false);
        
        var updateButton = document.getElementById('update'); //������ư�� �̺�Ʈ�� �ο��ϴ� �����
        updateButton.addEventListener('click', function(){updateRow();}, false); 
        //����Լ�
        function newRow(){
    		const URLSearch = new URLSearchParams(location.search);
    		URLSearch.set('submit','1');
    		const newParam = URLSearch.toString();
    		var link = location.pathname +'?'+newParam;
    		var articleNOInput = document.createElement("input");
    		articleNOInput.setAttribute("type","hidden");
    		articleNOInput.setAttribute("name","path");
    		articleNOInput.setAttribute("value", link);
    		document.getElementById('regItemg').appendChild(articleNOInput);
    		document.getElementById('regItemg').action = "${contextPath}/member/additemg.do";
    		document.getElementById('regItemg').submit();
    		}
      //�����Լ�
        function updateRow() {  //����� ������ ������ ��Ʈ�ѷ��� �ѱ�� �Լ�
        	document.getElementById('item_Group_Code1').disabled = true;
        	document.getElementById('item_Group_Name1').disabled = true;
        	document.getElementById('use_Status1').disabled = true;
        	document.getElementById('explanation1').disabled = true;
       	var is_empty = false; //���� is_empty�� ���ǹ��� �б⸦ ����
       	/* $('#regItemg').find('input[type!="hidden"]').each(function(){//���� ����ִ��� üũ�ϴ� ��������
       	    if(!$(this).val()) { //#regdepartment2�� form�±��� id����
       	    	is_empty = true;      	    	
       	    }      	 
       	});       	 
       	if(is_empty) { //����ִ³����� �ִ��� üũ��
       	    alert('����ִ� ������ �ֽ��ϴ�. �ٽ��Է��ϼ���');
       	}
       	else{ */
	        	document.getElementById('regItemg').action = "${contextPath}/member/upditemg.do";
	    		document.getElementById('regItemg').submit(); //���±�*�� ��ϵ��� ��Ʈ�ѷ��� ������
	    		alert('�����Ǿ����ϴ�'); 
       	/* } */      	
       }
      //�����Լ�
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
    			window.location.href = "${contextPath}/member/regitemgroup.do";
    		}
        	else //��Ʈ�ѷ��� �ش����� no���� ������
    			window.location.href = "${contextPath}/member/deleteItemg.do?no="+ary;       	
        }
        </script>
</body>
</html>