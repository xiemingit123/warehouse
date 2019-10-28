<%--
  Created by IntelliJ IDEA.
  User: xiemin
  Date: 2019/10/20
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-1.8.3.js"></script>
    <script>
        $(function () {
            $.post("getProduct.do",null,function(data){
                for (var i = 0; i < data.length; i++) {
                    var option="<option value="+data[i].id+">"+data[i].productname+"</option>";
                    $("#id").append(option);
                }
            },"json")
        })

        function check() {
            if ($("#id").val()==null||$("#id").val()==""){
                alert("请选择商品");
                return false;
            }
            if ($("#quantity").val()==null||$("#quantity").val()==""){
                alert("请选择数量");
                return false;
            }
            if ($("#quantity").val()<0||$("#quantity").val()%2!=0){
                alert("数量必须是>0的整数!");
                return false;
            }
            if ($("#handler").val()==null||$("#handler").val()==""){
                alert("请填写经手人");
                return false;
            }

            return true;
        }
        $(function () {
            $("#btn").click(function () {
                $.post("checkNum.do",{"id":$("#id").val()},function(data){
                    if (data.result-$("#quantity").val()>0){
                        $("#sp").text("数量充足").css("color","red");
                    } else {
                        $("#sp").text("数量不足,库存量为"+data.result).css("color","red");
                    }
                },"json")
            })
        })
    </script>
</head>
<body>
<center>
    <h3>商品出库</h3>
    <br>
    <form action="insertIntoTakeOut.do" onsubmit="return check()" method="post">
        出库商品: <select  id="id" name="id">
        <option  value="">请选择商品</option>
    </select>
        <br>
        数量: <input type="text" name="quantity" id="quantity"><span id="sp"></span>
        <input type="button" value="检查数量是否足够" id="btn">
        <br>
        经手人: <input type="text" name="handler" id="handler">
        <br>
        <input type="submit" value="提交">
        &nbsp;&nbsp;
        <input type="reset" value="重置">
    </form>
</center>
</body>
<script>
    if (${flag==1}){
        alert("操作成功!");
    } else if(${flag==0}){
        alert("操作失败");
    }
</script>
</html>
