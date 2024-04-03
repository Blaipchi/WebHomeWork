
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
        <h3>计算机知识交流平台分享-个人详细信息</h3>
        <hr color="skyblue">
    </div>

    <div class="users">
        <h5>用户具体信息</h5>
        <form action="UpdateUserInfoServlet" method="post">
            <table style="overflow-y: scroll;">
                <tr>
                    <th>uid:    <input type="text" disabled></th>
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
                    <th>flag:	<input type="text" disabled></th>
                </tr>
                <tr>
                    <td colspan="3" style="text-align: center;">
                        <input type="button"value="提交" onclick="" style="margin-left: 30%;">
                        <input type="button"value="取消" onclick="">
                        <input type="button" value="返回" onclick="">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>