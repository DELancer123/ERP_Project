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
            position: absolute;
            top: 25%;
            left: 15%;
        }
        
        #view1{
            width: 100%;
            text-align: center;
            border: 1px solid black;
        }
        #contents1 div button{
            width: 80px;
            position: absolute;
            right: 20px;
            top: 10px;
            
        }
        #reqInput {
            background-color: rgb(255, 255, 149);
            text-align: center;
        }
</style>
</head>
<body>
<container1 id = contents1>
            <table class="con1_search">
                <tr>
                    <td>사업장</td>
                    <td style="width: 50px;"><input type="text" id="reqInput" style="width: 100%;"/></td>

                    <td colspan="3"><input type="text" name="" disabled style="width: 100%;"/></td>
                    <td><i class="fas fa-search" style="color: blue;"></i></td>
                    <td colspan="5" style="width: 100px;">부서</td>
                    <td style="width: 80px;"><input type="text" id="reqInput" style="width: 100%;"/></td>
                    <td ><i class="fas fa-search" style="color: blue;"></i></td>
                    <td><input type="text" name="" disabled/></td>
                    
                </tr> 
                <tr>
                    <td>계획기간</td>
                    <td colspan="2" style="width: 80px;"><input type="date" id="reqInput" style="width: 100%;"/></td>
                    <td>~</td>
                    <td><input type="date" id="reqInput" style="width: 100%;"/></td>
                    <td></td>
                    <td colspan="5">사원</td>
                    <td style="width: 80px;"><input type="text" id="reqInput" style="width: 100%;"/></td>
                    <td><i class="fas fa-search" style="color: blue;"></i></td>
                    <td><input type="text" name="" disabled/></td>
                </tr>
            </table>
            <div>
                <button>주문적용</button>
            </div>
        </container1>
        <container2 id= contents2>
            <table id="view1">
                <tr>
                    <th><input type="checkbox" name="content"/></th>
                    <th>계획일</th>
                    <th>품번</th>
                    <th>품명</th>
                    <th>단위</th>
                    <th>순서</th>
                    <th>계획수량</th>
                    <th>고객</th>
                    <th>납기일</th>
                    <th>출하예정일</th>
                </tr>
            </table>
        </container2>
</body>
</html>