<%--
  Created by IntelliJ IDEA.
  User: zhaojing
  Date: 2019/9/29
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/jquery.form.js"></script>
</head>
<body>
    <center>
        <h2>添加用户信息</h2>
        <form action="${pageContext.request.contextPath}/addEmp.do" method="post" id="myform">
            <%--隐藏域--%>
            <input type="hidden" name="url" id="url">
            <table border="1" cellspacing="0" cellpadding="5" width="50%">
                <tr>
                    <td>用户名</td>
                    <td><input type="text" name="ename" id=""></td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td>
                        <input type="radio" name="esex" id="" checked>男
                        <input type="radio" name="esex" id="">女
                    </td>
                </tr>
                <tr>
                    <td>入职日期</td>
                    <td>
                        <input type="date" name="estartime" id="">
                    </td>
                </tr>
                <tr>
                    <td>工资</td>
                    <td>
                        <input type="text" name="epay" id="">
                    </td>
                </tr>
                <tr>
                    <td>所属部门</td>
                    <td>
                        <select name="deptDid">
                            <option value="">请选择</option>
                            <c:forEach items="${deptList}" var="dept">
                                <option value="${dept.did}">
                                        ${dept.dname}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>上传靓照</td>
                    <td>
                        <%--回显靓照--%>
                        <img src="" alt="" id="showImg" width="100">
                        <%--当一选择图片的时候，就触发onchange事件--%>
                        <input type="file" name="mfile" id="" onchange="changeFile()">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="提交">
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
<script>
    function changeFile() {
        /*设置参数，把参数设置到变量中*/
        var $options = {
            type:"post",
            url:"${pageContext.request.contextPath}/uploadFile.do",
            dataType:"json",
            success:function (data) {
                //attr:设置标签的属性
                $("#showImg").attr("src",data.url);
                //给url隐藏域设置值
                $("#url").val(url);
            }
        };
        /*提交表单的异步请求操作:只提交图片*/
        $("#myform").ajaxSubmit($options);
    }
</script>
</html>
