<%-- 
    Document   : home
    Created on : 5 Apr, 2013, 9:08:48 AM
    Author     : root
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${ststicResources}/gumby/css/gumby.css" rel="stylesheet">  
        <script type="text/javascript" src="${ststicResources}/jQuery/js/jquery-1.8.3.min.js"></script>
        <script type="text/javascript" src="${ststicResources}/gumby/js/libs/gumby.js"></script>
        <title>YouTube</title>
        
    </head>
    
    <body>
        <form name="youtubeSearch" id="youtubeSearch" method="post" action="./search">
            ${java.io.tmpdir}
            <input type="text" name="q" id="q" value="${search.q}" />
            <input type="submit" name="Search" value="Search" class="medium primary btn" />
            
        </form>
    </body>
</html>
