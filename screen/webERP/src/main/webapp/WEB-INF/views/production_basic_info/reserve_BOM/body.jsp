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
            margin: 20px 10px;
        }
        /* 컨테이너 스타일부 */
        #workOrderInfo {
            overflow: scroll;
            height: 97%;
            width: 100%;
        }
        /* 합계 출력부 */
        #resultWindow{
            height: 3%;
            background-color: gray;
            line-height: 5%;
        }
        #workOrderTable{
            width: 100%;
            font-weight: bold;
        }

</style>
</head>
<body>
<container1 id = contents1>
            <form id="searchForm">
                <table>
                    <tr>
                        <td>
                            자품목
                        </td>
                         <Td>
                            <input type="text" name="factory" value='${param.itemNumber }' style="width: 120px; background-color: yellow;">
                        </Td>
                        <td>
                            <a href="javascript:search1()"><i class="fas fa-search" style="color: blue;"></i></a>
                        </td>
                        <td>
                            <input type="text" name="ckfactory" value='${param.itemName }' style="width: 120px;" disabled>
                        </td>
                       
                    </tr>
                    <tr>
                        <td>
                            기준일자
                        </td>
                        <td colspan="2">
                            <input type="date" name="department" style="width: 120px; background-color: yellow;"><a href="#" onclick="showPopup();"></a>
                        </td>
                        <td>
                            <input type="checkbox">BOM 총전개
                        </td>
                        <td>
                            <input type="button" value="<< 이전품목" style="padding: 5px; margin-left: 70px;"></input>
                        </td>
                        <td>
                        <input type="button" value="다음품목 >>" style="padding: 5px;"></input>
                        </td>
                    </tr>
                </table>
                </form>
        </container1>
        <container2 id= contents2>
            <div id="workOrderInfo">
                <table id="workOrderTable">
                    <tr>
                        <td><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
                        <td>LEVEL</td>
                        <td>순번</td>
                        <td>품번</td>
                        <td>품명</td>
                        <td>규격</td>
                        <td>단위</td>
                        <td>정미수량</td>
                        <td>LOSS(%)</td>
                        <td>필요수량</td>
                        <td>표준원가</td>
                        <td>실제원가</td>
                        <td>외주</td>
                        <td>사용여부</td>
                        <td>비고</td>
                    </tr>
                    <!-- BOM 역전개는 입력부 불필요 -->
                    
                </table>
            </div>
            <!-- 합계 출력부 -->
            <div id="resultWindow">
                합 계 <span style="margin-left: 100px;">정미수량 <input type="text"></span><span style="margin-left: 100px;">필요수량 <input type="text"></span>
            </div>
            <!-- 합계 출력부 종료 -->
        </container2>
      <script>
      function openWindowPop(url, name){
          var options = 'top=0, left=0, width=320, height=420, status=no, menubar=no, toolbar=no, resizable=no';
          window.open(url, name, options);
      }
      
      function search1(){
    	  openWindowPop('http://localhost:8090/webERP/member/reservePop.do','codehelper');
      }
      view_button.onclick = function(){
		  const URLSearch = new URLSearchParams(location.search);
		  URLSearch.set('submit', '1');
		  const newParam = URLSearch.toString();

		  window.open(location.pathname + '?' + newParam, '_self');
 	}
      function childSearch(name){
    	  const URLSearch = new URLSearchParams(location.search);
		  URLSearch.set('submit', '2');
		  const newParam = URLSearch.toString();
		  if(URLSearch.get('childCode') == null)
		  window.open(location.pathname + '?' + newParam + "&&childCode=" + name.innerText, '_self');
		  else{
			  URLSearch.set('childCode',name.innerText);
			  const newParam = URLSearch.toString();
	          window.location.href = location.pathname +'?'+newParam;
		  }
			  
      }
		
      </script>
</body>
</html>