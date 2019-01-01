<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title><spring:message code="file" /></title>
<base href="${pageContext.request.contextPath}/" />
<link rel='stylesheet' type="text/css" href='webjars/bootstrap/4.1.3/css/bootstrap.min.css'></link>
<link rel='stylesheet' type="text/css" href='webjars/font-awesome/5.6.1/css/all.min.css'></link>
</head>
<body>
    <script type="text/javascript" src="webjars/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>

    <c:import url="../common/menu.jsp"></c:import>

    <form method="POST" enctype="multipart/form-data" action="file/save">
        <spring:message code="fileToUpload" /> <input id="file" type="file" name="file" /> <input id="submit" type="submit">
        <spring:message code="fileUpload" />
    </form>
</body>
</html>