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
            /* position: absolute; 칸 모잘라서 지움*/
            top: 25%;
            left: 18%;
        }
        #view1,#view2{
            width: 100%;
            text-align: center;
            border: 1px solid black;
            
        }
        /* end default 밑으로 css 추가함*/
        .con1_search {
            margin: 10px;
            
            
        }        
        #contents2, #contents3{
            overflow: scroll;
        }
        
        #button{
            position: absolute;
            right: 10px;
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

                    <td colspan="5" style="width: 70px;">부서</td>
                    <td style="width: 80px;"><input type="text" id="reqInput" style="width: 100%;"/></td>
                    <td ><i class="fas fa-search" style="color: blue;"></i></td>
                    <td><input type="text" name="" disabled/></td>

                    <!-- <td colspan="5" style="width: 70px;">사원</td>
                    <td style="width: 80px;"><input type="text" style="width: 100%;"/></td>
                    <td><input type="text" name="" disabled/></td>
                    <td><button>검</button></td> -->
                    
                </tr>
                
                <tr>
                    <td>조정기간</td>
                    <td colspan="2" style="width: 80px;"><input type="date" id="reqInput" style="width: 100%;"/></td>
                    <td>~</td>
                    <td><input type="date" id="reqInput" style="width: 100%;"/></td>
                    <td></td>

                    <td colspan="5" style="width: 50px;">입고창고</td>
                    <td style="width: 80px;"><input type="text" id="reqInput" style="width: 100%;"/></td>
                    <td><i class="fas fa-search" style="color: blue;"></i></td>
                    <td><input type="text" name="" disabled/></td>
                                        
                    <!-- <td colspan="5" style="width: 50px;">입고장소</td>
                    <td style="width: 80px;"><input type="text" style="width: 100%;"/></td>
                    <td><input type="text" name="" disabled/></td>
                    <td><button>검</button></td> -->
                    
                    
                    
                </tr>

                <!-- <tr>
                    <td>출고창고</td>
                    <td style="width: 50px;"><input type="text" style="width: 100%;"/></td>
                    <td colspan="3"><input type="text" name="" disabled style="width: 100%;"/></td>
                    <td><button>검</button></td>

                    <td colspan="5" style="width: 50px;">출고장소</td>
                    <td style="width: 80px;"><input type="text" style="width: 100%;"/></td>
                    <td><input type="text" name="" disabled/></td>
                    <td ><button>검</button></td>

                    <td colspan="5" style="width: 50px;">품번</td>
                    <td style="width: 80px;"><input type="text" style="width: 100%;"/></td>
                    <td><input type="text" name="" disabled/></td>
                    <td><button>검</button></td>
                    
                </tr> -->
                

                
            </table>
            <div id="button">
                <input type="button" value="SET 적용" style="padding: 5px;">
            </div>
        </container1>
        <container2 id="contents2">
            <table id="view1">
                <thead style="font-weight: bold;">
                    <td><input type="checkbox" name="content" onclick="selectAll(this)"/></td>
                    <td>조정번호</td>
                    <td>조정일자</td>
                    <td>SET모품목</td>
                    <td>품명</td>
                    <td>입고조정수</td>
                    <td>단가</td>
                    <td>금액</td>                 
                </thead>
                <tbody id="table1">
                    <td><input type="checkbox" value = "check1" id="check" name="content"/></td>
                    <td><input type="text"/></td>
                    <td><input type="date"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>                    
                </tbody>
            </table>
        </container2>
        <container3 id="contents3">
            <table id="view2">
                <tr style="font-weight: bold;">
                    <td><input type="checkbox" name="content2" onclick="selectAll2(this)"/></td>
                    <td>조정번호</td>
                    <td>구성품번</td>
                    <td>품 명</td>
                    <td>출고조정수량</td>
                </tr>
                <tr>
                    <td><input type="checkbox" value = "check1" id="check" name="content2"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>
                    <td><input type="text"/></td>   
                </tr>
            </table>
            
        </container3>
</body>
</html>