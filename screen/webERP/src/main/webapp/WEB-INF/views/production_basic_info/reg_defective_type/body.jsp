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
            /* position: absolute; 칸 모잘라서 지움*/
            top: 25%;
            left: 5%;
        }
        #searchForm {
            height: 100%;

        }
        /* 컨테이너 스타일부 */
        #workOrderTable{
        	width:100%;
        	margin: 0; 
        }
		input {
			width:100%;
		}
        #workOrderInfo {
            overflow: scroll;
            height: 100%;
            width: 100%;
        }

</style>
</head>
<body>
<container1 id = contents1>
                <table style="margin-left:10%; margin-top:2%;">

                    <tr>
                        <td>
                            불량군
                        </td>
                        <td>
                            <input type="text" name="department" value='${param.defGroupCode }' style="width: 130px;">
                        </td>
                        <td>
                             <a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></a>
                        </td>
                        <td>
                            <input type="text" name="ckdepartment" value='${param.defGroup }' style="width: 130px;" disabled >
                        </td>
                    </tr>
                </table>
            </form>
        </container1>
        <container2 id= contents2>
            <form id="searchForm" method="get" commandName = "defList">
            <div id="workOrderInfo">
                <table id="workOrderTable" >
                    <thead align="center" style="background-color:gray">
                        <td style="width:3%"><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
                        <td>불량코드</td>
                        <td>불량유형명</td>
                        <td>불량군</td>
                        <td>사용여부</td>
                        <td>불량설명</td>
                    </thead>
                    <c:forEach var = "def" items='${defectiveList }' varStatus="status" >
                    <tbody align="center">
                        <td style="width:3%"><input type="checkbox" value = '${def.defectCode }'  id="check" class="check" name="content"/></td>
                        <td><input type="text" name="defList[${status.index }].defectCode" value = '${def.defectCode }'/></td>
                        <td><input type="text" name="defList[${status.index }].defectiveTypeName"value='${def.defectiveTypeName }'/></td>
                        <td><input type="text" name="defList[${status.index }].defectiveItemGroup" value='${def.defectiveItemGroup }' readonly/></td>
                        <td><input type="text" name="defList[${status.index }].usageStatus" value='${def.usageStatus }'/></td>
                        <td><input type="text" name="defList[${status.index }].defectiveDescription" value='${def.defectiveDescription }'/></td>
                        <input type="hidden" name="defList[${status.index }].defectiveItemGroupCode" value='${def.defectiveItemGroupCode }'/>
                        <input type="hidden" name="defList[${status.index }].oridefectCode" value='${def.defectCode }'/>
                    </tbody>
                    </c:forEach>
                    <tr align="center">
                    <td style="width:3%"></td>
                        <td><input type="text" id="defCode" name="defList[${fn:length(defectiveList) }].defectCode"/></td>
                        <td><input type="text" id="defName" name="defList[${fn:length(defectiveList) }].defectiveTypeName"/></td>
                        <td><input type="text" id="defgroup" name="defList[${fn:length(defectiveList) }].defectiveItemGroup"value='${param.defGroup }' readonly/></td>
                        <td><input type="text" id="usage" name="defList[${fn:length(defectiveList) }].usageStatus"/></td>
                        <td><input type="text" id="defDes" name="defList[${fn:length(defectiveList) }].defectiveDescription"/></td>
                        <input type="hidden" id="groupCode" name="defList[${fn:length(defectiveList) }].defectiveItemGroupCode"value='${param.defGroupCode }' />
                    <tr>
                </table>
            </div>
        </form>
        </container2>
      <script>
      	var save_button = document.getElementById("save");
      	var upd_button = document.getElementById("update");
      	var delete_button = document.getElementById("delete");
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
	            document.getElementById('searchForm').action = "${contextPath}/member/adddefType.do";
	  			document.getElementById('searchForm').submit();  
		}
      	upd_button.onclick = function(){
			document.getElementById("defCode").disabled = true;
 		     document.getElementById("defName").disabled = true;
 		     document.getElementById("defgroup").disabled = true;
 		     document.getElementById("usage").disabled = true;
 		     document.getElementById("defDes").disabled = true;
 		     document.getElementById("groupCode").disabled = true;
 		    const URLSearch = new URLSearchParams(location.search);
			  URLSearch.set('submit', '1');
			  const newParam = URLSearch.toString();
			 var link = location.pathname +'?'+newParam;
	  			var articleNOInput = document.createElement("input");
	  		     articleNOInput.setAttribute("type","hidden");
	  		     articleNOInput.setAttribute("name","path");
	  		     articleNOInput.setAttribute("value", link);
	  		     document.getElementById('searchForm').appendChild(articleNOInput);
	            document.getElementById('searchForm').action = "${contextPath}/member/upddefType.do";
	  			document.getElementById('searchForm').submit();  
		}
      	function search1(){
	      	openWindowPop('http://localhost:8090/webERP/member/deftypepop.do','codehelper');
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
      			  window.location.href = "${contextPath}/member/deldefType.do?no="+ary;
      	  }
      	}
      </script>
</body>
</html>