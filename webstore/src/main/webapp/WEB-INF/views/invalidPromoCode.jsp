<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Invalid Promo Code</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1 class="alert alert-danger"><spring:message code="invalidPromoCode.title.label"/></h1>
        </div>
        <div class="pull-right" style="padding-right:50px">
            <a href="?language=pl" ><spring:message code="invalidPromoCode.changeLangToPL.button.label"/>
            </a>|<a href="?language=eng" ><spring:message code="invalidPromoCode.changeLangToENG.button.label"/></a>
        </div>
    </div>
</section>

<section>
    <div class="container">
        <p>
            <a href="<spring:url value="/products" />" class="btn btn-primary">
                <span class="glyphicon-hand-left glyphicon"></span>
                <spring:message code="invalidPromoCode.products.button.label"/>
            </a>
        </p>
    </div>

</section>
</body>
</html>