<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>userInfo</title>
    <script>

    </script>

    <style>
        .sty1{
            width: 400px;
            height: 600px;
            position: absolute;
            margin-top: 5%;
            margin-left: 35%;
            text-align: center;
            border: 5px solid aqua;
            border-style: outset;
            border-radius: 50px 50px 50px 50px;
            box-shadow:0px 0px 10px 5px #aaa inset;
        }

        .sty2{
            width: auto;
            height: 70px;
            position: relative;
        }

        .adminInfo{
            width: auto;
            height: 70px;
        }

        input{
            text-shadow: 1px 1px gray;
            background-color:white;
            color:black;
        }

        .users{
            width: 380px;
            height: 430px;
            margin-top: 10px;
            margin-left: 10px;
            border: 1px solid aqua;
            border-radius: 10px 10px 10px 10px;
            box-shadow:0px 0px 1px 1px #aaa inset;
        }

        th{
            text-align: right;
        }
    </style>
</head>
<body>
<div class="sty1">
        <div class="sty2">
            <h3>计算机知识交流平台分享-员工管理系统</h3>
            <hr color="skyblue">
        </div>
        
        <div class="adminInfo">
            <h4 style="margin-top: -10px;">adminName:</h4>
            <input type="button" value="返回" onclick="">
            <hr color="skyblue">
        </div>

        <div class="users">
            <h5>用户具体信息</h5>
            <form action="UpdateUserInfoServlet" method="post">
                <table style="overflow-y: scroll;">
                    <tr>
                        <th>uid:    <input type="text"></th>
                    </tr>
                    <tr>
                        <th>username:    <input type="text"></th>
                    </tr>
                    <tr>
                        <th>password:    <input type="text"></th>
                    </tr>
                    <tr>
                        <th>email:    <input type="text"></th>
                    </tr>
                    <tr>
                        <th>age:    <input type="text"></th>
                    </tr>
                    <tr>
                        <th>flag:
                            <select id="flag" style="width: 155px;border:2px solid black">
                                <option value="普通员工">普通员工</option>
                                <option value="管理员">管理员</option>
                            </select>
                        </th>
                    </tr>
                    <tr>
                        <th>articleList:    
                            <textarea cols="20" rows="10" disabled></textarea>
                        </th>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align: center;">
                            <input type="button"value="提交" style="margin-right: 20px;margin-left: 30%;">
                            <input type="button"value="重置" click="">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</body>
</html>