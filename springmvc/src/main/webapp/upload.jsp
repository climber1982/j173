
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
    <img src="<%=basePathImg%>img/a5336ad69b344ba799638bd0e3b55409.jpg" width="300px" height="300px">
    <form action="upload.lovo" method="post" enctype="multipart/form-data">
      用户名：<input type="text" name="userName" ><p/>
    上传文件：<input type="file" name="fileName"><p/>
        <input type="submit">
    </form>
</body>
</html>
