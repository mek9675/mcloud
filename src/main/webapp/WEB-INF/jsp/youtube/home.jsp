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
        <title>YouTube Module</title>
        <script type="text/javascript" >
            function checkUncheck(filter,obj) {
                $('[name="' + filter + '"]').each(function(index) {
                    if(obj!=this)
                        this.checked=false;
                });
                if(obj.checked)
                    obj.checked=true;
                
                //for refresh result
                getSearchResult('youtubeSearch');
            }
        
            function getSearchResult(name) {
                
                var formData = $('form[name="' + name + '"]').serialize();

                $.ajax({
                    type: "POST",
                    url: "./search",
                    data: formData,
                    success: function(msg){
                        alert( "Data Saved: " + msg );
                    }
                });
                
            }
        </script>
    </head>
    
    <body>
        <form name="youtubeSearch" id="youtubeSearch" method="post" action="./search">
            <input type="text" name="q" id="q" value="${search.q}" />
            <input type="button" name="Search" value="Search" class="medium primary btn" onclick="getSearchResult('youtubeSearch')" />
            <table>
                <tr>
                    <c:forEach items="${filter}" var="mainFilter" varStatus="vs">
                        <td>
                            <b>${mainFilter.key}</b><br />
                            <c:forEach items="${mainFilter.value}" var="subFilter" varStatus="vs1">
                                <input type="checkbox" name="${mainFilter.key}" value="${subFilter.value}" onchange="checkUncheck('${mainFilter.key}',this)" />${subFilter.key} <br/>
                            </c:forEach>
                        </td>
                    </c:forEach>
                </tr>
            </table>
        </form>
    </body>
</html>
