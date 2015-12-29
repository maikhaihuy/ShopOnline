<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<!-- Header -->
    <tiles:insertAttribute name="header"/>              
	<!-- Body-->
	<tiles:insertAttribute name="content"/>
	<!--Footer-->
    <tiles:insertAttribute name="footer"/>
    
</body>
</html>
