<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>검사유형등록</title>
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
            top: 15%;
            width: 85%;
            height: 35%;
            border: 1px solid black;
            z-index: 1;
        }
        #contents3{
            position: absolute;
            right: 0;
            top:50%;
            width: 85%;
            height: 45%;
            border: 1px solid black;
            z-index: 1;
        }
        #con1_search {
            width: 30%;
            padding-top: 10px;
            left: 5%;
        }
        #table1 input {
        	width:90%;
        }
        .input2 {
        	width:90%;
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
        <container2 id="contents2">
            <table id="view1">
                <thead>
                    <td></td>
                    <td align="center">코드</td>
                    <td align="center">검사유형명</td>
                    <td align="center">비고</td>
                </thead>
                <tbody id="table1" align="center">
                    <td align="center" style="width:5%;"><input type="checkbox" value = "check1" id="check" name="content"/></td>
                    <td align="center"><input type="text"/></td>
                    <td align="center"><input type="text"/></td>
                    <td align="center"><input type="text"/></td>
                </tbody>
            </table>
        </container2>
        <container3 id="contents3">
            <table id="view2">
                <thead>
                    <td align="center">no</td>
                    <td align="center">검사유형질문</td>
                    <td align="center">비고</td>
                </thead>
                <tbody id="table2" align="center">
                    <td align="center"><input class="input2" type="text"/></td>
                    <td align="center"><input class="input2" type="text"/></td>
                    <td align="center"><input class="input2" type="text"/></td>
                </tbody>
            </table>
        </container3>
        <script>

        </script>
</body>
</html>