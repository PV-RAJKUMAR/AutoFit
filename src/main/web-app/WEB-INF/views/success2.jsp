<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h1>Thank you for your response!!!</h1>
<c:url value="dashBoard" var="URL" />
<a href="${URL}">Back</a>
<p><b>${message}</b></p>
</body>
</html>