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
            overflow: scroll;
        }
         #view{
            width: 100%;
            text-align: center;
            border: 1px solid black;
        }

        .con1_search{
            padding:0;
            text-align: center;
            position: absolute;
            top: 25%;
            left: 10%;
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
                <tr >
                    <td align="center">�����</td>
                    <td><input type="text" name="" id="reqInput"></td>
                    <td><i class="fas fa-search" style="color: blue;"></i></td>
                    <td><input type="text" disabled></td>
                    <td align="right" colspan="2">�����</td>
                    <td colspan="2">
                        <button id="minus"><<</button>
                        <input type="text" value="2021" id="year" style="background-color: rgb(255, 255, 149); width: 60px; text-align: center;">
                        <button id="plus">>></button>
                        <select name="" id="reqInput">
                            <option value="1">1��</option>
                            <option value="2">2��</option>
                            <option value="3">3��</option>
                            <option value="4">4��</option>
                            <option value="5">5��</option>
                            <option value="6">6��</option>
                            <option value="7">7��</option>
                            <option value="8">8��</option>
                            <option value="9">9��</option>
                            <option value="10">10��</option>
                            <option value="11">11��</option>
                            <option value="12">12��</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="center">��</td>
                    <td><input type="text"></td>
                    <td><i class="fas fa-search" style="color: blue;"></i></td>
                    <td><input type="text" disabled></td>
                    <td align="center">ǰ��</td>
                    <td><input type="text"></td>
                    <td><i class="fas fa-search" style="color: blue;"></i></td>
                    <td><input type="text" disabled></td>
                </tr>
            </table>
        </container1>
        <container2 id="contents2">
           <table id="view">
                <thead>
                    <td><input type="checkbox" id="check" name="content" onclick="selectAll(this)"/></td>
                    <td align="center">���ڵ�</td>
                    <td align="center">����</td>
                    <td align="center">���⿹���</td>
                    <td align="center">��ȹ�μ�</td>
                </thead>
                <tbody>
                    <td><input type="checkbox" value = "check1" id="check" name="content"/></td>
                    <td><input type="text"></td>
                    <td><input type="text"></td>
                    <td><input type="text"></td>
                    <td><input type="text"></td>
                </tbody>
           </table>
        </container2>
        <container3 id="contents3">
            <table id="view">
                <thead>
                    <td style="width: 5%;"><input type="checkbox" name="content1" onclick="selectAll1(this)"></td>
                    <td align="center">ǰ��</td>
                    <td align="center">ǰ��</td>
                    <td align="center">�԰�</td>
                    <td align="center">����(����)</td>
                    <td align="center">����</td>
                    <td align="center">�ܰ�</td>
                    <td align="center">���⿹��ݾ�</td>
                    <td align="center">���</td>
                </thead>
                <tbody>
                    <td style="width: 5%;"><input type="checkbox" value = "check1" id="check" name="content1"/></td>
                    <td><input type="text" name="" id=""></td>
                    <td><input type="text" name="" id=""></td>
                    <td><input type="text" name="" id=""></td>
                    <td><input type="text" name="" id=""></td>
                    <td><input type="text" name="" id=""></td>
                    <td><input type="text" name="" id=""></td>
                    <td><input type="text" name="" id=""></td>
                    <td><input type="text" name="" id=""></td>
                </tbody>
            </table>
        </container3>
</body>
</html>