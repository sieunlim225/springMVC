<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TILES : EMPTYLAYOUT</title>
</head>
<body>
<tiles:insertAttribute name="content"/>
<tiles:insertAttribute name="footer"/>
</body>
</html>