<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
  <!--在当前页所有的链接前面加上basePath的值-->
    <base href="<%=basePath %>" />
    <title>Title</title>
</head>
<body>


     <div align="center">
         <div>
              <table>
                  <tr>
                      <td>用户名</td>
                      <td>用户年龄</td>
                  </tr>
                  <c:forEach var="u" items="${listUser}">
                  <tr>

                      <td>${u.userName}</td>
                      <td>${u.userAge}</td>

                  </tr>
                  </c:forEach>
              </table>
         </div>
         <form action="user/login.lovo" method="post">
        <input type="text" name="userName"><p/>
         <input type="password" name="password"><p/>
         <input type="submit" value="登录">
         </form>
     </div>
</body>
</html>
