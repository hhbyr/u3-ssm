<%--
  Created by IntelliJ IDEA.
  User: zhaojing
  Date: 2019/9/27
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.js"></script>
</head>
<body>
    <center>
        <h2>用户管理系统</h2>
        <form action="${pageContext.request.contextPath}/list.do" method="post" id="myform">
            <%--隐藏域--%>
            <input type="hidden" name="pageNum" id="pageNum">
            姓名：<input type="text" name="searchName" value="${term.searchName}">
            工资：<input type="text" name="startEpay" value="${term.startEpay}">-
            <input type="text" name="endEpay" value="${term.endEpay}">
            入职日期：<input type="date" name="startTime" value="${term.startTime}">-
            <input type="date" name="endTime" ${term.endTime}>
            部门：
            <select name="searchDid" id="">
                <option value="">请选择</option>
                <c:forEach items="${deptList}" var="dept">
                    <option value="${dept.did}"
                      <c:if test="${dept.did==term.searchDid}">selected</c:if>
                    >
                        ${dept.dname}
                    </option>
                </c:forEach>
            </select>
            <input type="submit" value="查询">
            <input type="button" value="新增员工" onclick="addEmp()">
        </form>
        <table border="1" cellpadding="5" cellspacing="0" width="80%">
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>入职日期</th>
                <th>工资</th>
                <th>部门名称</th>
                <th>靓照</th>
                <th>操作</th>
            </tr>
            <c:if test="${not empty pageInfo.list}">
                <c:forEach items="${pageInfo.list}" var="emp">
                    <tr>
                        <td>${emp.eid}</td>
                        <td>${emp.ename}</td>
                        <td>${emp.esex}</td>
                        <td><fmt:formatDate value="${emp.estartime}" pattern="yyyy-MM-dd"></fmt:formatDate></td>
                        <td>${emp.epay}</td>
                        <td>${emp.dept.dname}</td>
                        <td></td>
                        <td>
                            <a href="">修改</a>&nbsp;&nbsp;
                            <a href="">删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
        <br>
        <table border="1" cellpadding="5" cellspacing="0" width="50%">
            <tr>
                <%--使用js的函数来实现跳转
                javascript: 表示直接跳转到某个js函数去执行。
                --%>
                <td><a href="javascript:toPage(1)">首页</a></td>
                <td><a href="javascript:toPage(${pageInfo.pageNum-1})">上一页</a></td>
                <%--放页码：点击页码跳转
                pages:总页数
                --%>
                <td>
                    <c:forEach var="i" begin="1" end="${pageInfo.pages}">
                        <a href="javascript:toPage(${i})">${i}</a>
                    </c:forEach>
                </td>
                <td><a href="javascript:toPage(${pageInfo.pageNum+1})">下一页</a></td>
                <td><a href="javascript:toPage(${pageInfo.pages})">尾页</a></td>
                <td>
                    跳转到第 <input type="text" id="tPage" size="5" value="${pageInfo.pageNum}">页
                    <input type="button" value="GO" onclick="doBtn()">
                </td>
            </tr>
        </table>
    </center>
</body>
<script>
    function toPage(pageNum) {
        /*给pageNum赋值*/
        $("#pageNum").val(pageNum);
        /*提交表单*/
        $("#myform").submit();
    }
    function doBtn() {
        /*调用toPage函数，传递页码*/
        toPage($("#tPage").val());
    }
    function addEmp() {
        location.href="${pageContext.request.contextPath}/showAddEmp.do";
    }
</script>
</html>
