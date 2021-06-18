<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
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
            margin: 20px 20px;
            padding:0;
            text-align: center;
        }
        /* 컨테이너 스타일부 */
        #workOrderInfo {
            overflow: scroll;
            height: 100%;
            width: 100%;
        }

</style>
</head>
<body>
 <container1 id = contents1>
            <form id="searchForm">
                <table class="con1_search">
                    <tr>
                        <td>외주처</td>
                        <td style="width: 80px;"><input type="text" value='${param.itemNumber }' id="outcode"style="width: 100%; background-color: yellow;"/></td>
                        <td> <a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></a></td> 
                        <td colspan="2"><input type="text" name="" value='${param.itemName }' disabled style="width: 100%;"/></td>
    
                        <td colspan="4" style="width: 80px;">외주작업장</td>
                        <td style="width: 80px;"><input type="text" style="width: 100%; background-color: yellow;"/></td>
                        <td> <a href="javascript:search2()"><i class="fas fa-search" style="color: blue;"></i></a></td>
                        <td><input type="text" name="" disabled/></td>
                        
                    </tr>
                    
                    <tr>
                        <td>품목군</td>
                        <td style="width: 80px;"><input type="text" style="width: 100%;"/></td>
                        <td>  <a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></a></td>
                        <td><input type="text" name="" disabled/></td>
    
                        <td colspan="5" style="width: 80px;">사원</td>
                        <td style="width: 80px;"><input type="text" style="width: 100%; background-color: yellow;"/></td>
                        <td > <a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></a></td>
                        <td><input type="text" name="" disabled/></td>

                        <td>
                            <input type="button" value="품목전개" style="padding: 5px; margin-left: 30px;"></input>
                        </td>
                        <td>
                            <input type="button" value="품목복사" style="padding: 5px;"></input>
                        </td>
                    </tr>
                </table>
            </form>
        </container1>
        <container2 id= contents2>
            <div id="workOrderInfo">
                <table id="workOrderTable">
                    <thead>
                        <td><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
                        <td>품번</td>
                        <td>품명</td>
                        <td>규격</td>
                        <td>단위</td>
                        <td>원가</td>
                        <td>외주단가</td>
                        <td>시작일</td>
                        <td>종료일</td>
                    </thead>
                    <!-- 테스트용 데이터, 추후 표현식으로 수정필요 -->
                    <tbody>
                        <td><input type="checkbox" value = "check1" id="check" name="content"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>
                        <td><input type="text"/></td>
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
    	      	openWindowPop('http://localhost:8090/webERP/member/outsourcingPop.do?div=2&&itemNumber='+outcode.value,'codehelper');
      }
		
      </script>
</body>
</html>