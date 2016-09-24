<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.sql.*"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
	@import url(table.css)
</style>
<body>
<table class="gridtable">
	<tr>
		<td>string</td>
		<td>id</td>
	</tr>
    <c:if test="${list==null}">null!</c:if>
	<c:forEach items="${list}" var="str">
		<tr>
			<td>${str.string}</td>
			<td>${str.id}</td>
			<td><a href="update.jsp?id=${str.id}">修改</a></td>
			<td><a href="delete.jsp?id=${str.id}">删除</a></td>
		</tr>
	</c:forEach>
	    
	<tr>
			<td colspan="2">
       			 <a href="search2.action?page=${page-1 }" onclick="return frontPageCheck();">上一页</a>
         		  [每页显示：${pageSize}条] [  第${page}页 / 共${allpage} 页]
       			 <a href="search2.action?page=${page+1 }" onclick="return backPageCheck();">下一页</a>
        	</td>
	</tr>
	
</table>
<p style="margin : auto auto;">
<a href="add.jsp" >增加</a>
</p>
</body>
<SCRIPT type="text/javascript">  
            function frontPageCheck()  
            {  
                if(${page > 1})  
                {  
                    return true;  
                }  
                return false;  
            }  
              
            function backPageCheck()  
            {  
                if(${page < allpage})  
                {  
                    return true;  
                }             
                return false;  
            }  
        </SCRIPT> 
</html>