<%-- 
    Document   : result
    Created on : 9 Apr, 2013, 1:17:42 PM
    Author     : root
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:choose>
    <c:when test="${fn:length(result.arr) gt 0}">
        <table>
        <c:forEach items="${result.arr}" var="v" varStatus="vs" >
            <tr>
                <td>
                    <img src="${v.snippet.thumbnails.medium.url}" alt="Thumbnail" />
                    
                </td>
            </tr>    
        </c:forEach>
        </table>
        
        <br />
        nextPageToken : ${result.nextPageToken}
        prevPageToken : ${result.prevPageToken}
        
    </c:when>
    <c:otherwise>
        there is no video for search
    </c:otherwise>
</c:choose>