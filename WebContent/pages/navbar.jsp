<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav">

    		${user.firstname}<br>
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>


    </div>
  </div>
</nav>