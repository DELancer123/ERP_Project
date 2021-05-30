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
        }
        .con1_search{
            padding:0;
            text-align: center;
            position: absolute;
            top: 25%;
            left: 18%;
        }
        #view1,#view2{
            width: 100%;
            text-align: center;
            border: 1px solid black;
        }
      
        /* ----------------��ư-------------------- */

        #view2 td:not(.ch){
            width: 8%;
            font-size: 15px;
            font-weight: bold;
        }
        #view2 td input{
            width: 100%;
        }
        #view1 td:not(#non){
            width: 14.5%;
        }
        #view1 td input{
            width: 100%;
        }
        #view1 th{
            width: 4%;
        }

        ul.tabs{
            margin: 0px;
            padding: 0px;
            list-style: none;
        }
        ul.tabs li{
            background: none;
            color: black;
            display: inline-block;
            padding: 0;
            cursor: pointer;
            width: 60px;
            text-align: center;
            font-size: 13px;
        }
        ul.tabs #month_button{
            border-top: 3px solid rgb(255,0,0);
            background-color: rgb(120,145,100);
            border-top-left-radius: 8px;
            border-top-right-radius: 8px;
            color: white;
        }
        ul.tabs #things_button{
            border-top: 3px solid rgb(255,0,0);
            background-color: rgb(120,145,100);
            border-top-left-radius: 8px;
            border-top-right-radius: 8px;
            color: white;
        }
        ul.tabs #set_button{
            border-top: 3px solid rgb(255,0,0);
            background-color: rgb(120,145,100);
            border-top-left-radius: 8px;
            border-top-right-radius: 8px;
            color: white;
        }
        .tab-content{
            display: none;
        }
        .tab-content.current{
            display: inherit;
        }
</style>
</head>
<body>
<container1 id = contents1>
            <table class="con1_search">
                <tr>
                    <td>�����</td>
                    <td>
                        <input type="text">
                        <button>+</button>
                    </td> 
                    <td>
                        <input type="text">
                    </td>
                    <td>�ŷ�ó</td>
                    <td>
                        <input type="text"">
                        <button>+</button>
                    </td>
                    <td>
                        <input type="text"">
                    </td>
                </tr>
            </table>
            <div>
                <ul class="tabs" style="left:0px; bottom:0px; position: absolute;">
                    <li id="month_button" class="month">â��/���</li>
                    <li id="things_button" class="thing">�������/�۾���</li>
                    <li id="set_button" class="set">���ְ���/�۾���</li>
                </ul>
            </div>
        </container1>
        <container2 id="contents2">
            <table id="view1">
                <thead id="month" style="display: none;">
                    <!-- â��/��� ��1 -->
                    <th id="non"><input type="checkbox" name="content" onclick="selectAll(this)" /></th>
                    <th>â���ڵ�</th>
                    <th>â���</th>
                    <th>�԰�⺻��ġ</th>
                    <th>���⺻��ġ</th>
                    <th>â����</th>
                    <th>��뿩��</th>
                </thead>
                <thead id="things">
                    <!-- �������/�۾��� -->
                    <th id="non"><input type="checkbox" name="content" onclick="selectAll(this)" /></th>
                    <th>��������ڵ�</th>
                    <th>���������</th>
                    <th>�԰�⺻��ġ</th>
                    <th>���⺻��ġ</th>
                    <th>��������</th>
                    <th>��뿩��</th>
                </thead>
                <thead id="set" style="display: none;">
                    <th id="non"><input type="checkbox" name="content" onclick="selectAll(this)" /></th>
                    <th>���ְ����ڵ�</th>
                    <th>���ְ�����</th>
                    <th>�԰�⺻��ġ</th>
                    <th>���⺻��ġ</th>
                    <th>���ְ�������</th>
                    <th>��뿩��</th>
                </thead>
                <!-- <tbody id="view1" style="display: none;">
                    <td id="non"><input type="checkbox" value = "check1" id="check" name="content"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><select name="" id="">
                        <option value="1">���</option>
                        <option value="2">�̻��</option>
                    </select></td>
                </tbody> -->
            </table>
        </container2>
        <container3 id="contents3">
            <table id="view2">
                <tr id="set2">
                    <td>��ġ�ڵ�</td>
                    <td>��ġ��</td>
                    <td>��ġ����</td>
                    <td>��뿩��</td>
                </tr>
                <tr id="month2" style="display: none;">
                    <td>�۾����ڵ�</td>
                    <td>�۾����</td>
                    <td>�۾��弳��</td>
                    <td>��뿩��</td>
                </tr>
                <!-- <tr>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><select name="" id="">
                        <option value="1">���</option>
                        <option value="2">�̻��</option>
                    </select></td>
                </tr> -->
            </table>
        </container3>
        <script>
        var month_button = document.getElementById('month_button');
        var things_button = document.getElementById('things_button');
        var set_button = document.getElementById('set_button');
        month_button.onclick = function(){
            var month = document.getElementById('month');
            var things = document.getElementById('things');
            var set = document.getElementById('set');
            var month2 = document.getElementById('month2');
            var set2 = document.getElementById('set2');
            month.style.display = "block";
            set.style.display = "none";
            things.style.display = "none";
            month2.style.display = "block";
            set2.style.display = "none";
            things_button.removeAttribute('id');
            set_button.removeAttribute('id');
            month_button.removeAttribute('id');
        }
        things_button.onclick = function(){
            var month = document.getElementById('month');
            var things = document.getElementById('things');
            var set = document.getElementById('set');
            var month2 = document.getElementById('month2');
            var set2 = document.getElementById('set2');
            month.style.display = "none";
            set.style.display = "none";
            things.style.display = "block";
            month2.style.display = "none";
            set2.style.display = "block";
            things_button.removeAttribute('id');
            set_button.removeAttribute('id');
            month_button.removeAttribute('id');

        }
        set_button.onclick = function(){
            var month = document.getElementById('month');
            var things = document.getElementById('things');
            var set = document.getElementById('set');
            var month2 = document.getElementById('month2');
            var set2 = document.getElementById('set2');
            month.style.display = "none";
            set.style.display = "block";
            things.style.display = "none";
            month2.style.display = "none";
            set2.style.display = "block";
            things_button.removeAttribute('id');
            set_button.removeAttribute('id');
            month_button.removeAttribute('id');
        }
        </script>
</body>
</html>