<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        String basePathImg= request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
    %>

    <!--在当前页所有的链接前面加上basePath的值-->
    <base href="<%=basePath %>" />
    <title>文件的上传</title>

</head>
<body>
   <span style="color: red">
        ${imgInfo}
   </span>
    <form action="upload.lovo" method="post" enctype="multipart/form-data">
      用户名：<input type="text" name="userName" ><p/>
    上传文件：<input type="file" name="fileName"><p/>
        <input type="submit">
    </form>

   <ul>
        <c:forEach var="img" items="${imgPaths}">
       <li><img src="<%=basePathImg%>img/${img}" width="50px" height="50px"> </li>
        </c:forEach>
   </ul>
</body>
</html>
