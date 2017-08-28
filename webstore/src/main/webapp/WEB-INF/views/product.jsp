<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Product</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1><spring:message code="product.title.label"/> </h1>
        </div>
        <div class="pull-right" style="padding-right:50px">
            <a href="?language=pl" ><spring:message code="addProduct.changeLangToPL.button.label"/>
            </a>|<a href="?language=eng" ><spring:message code="addProduct.changeLangToENG.button.label"/></a>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-md-5">
            <img src="<c:url value="/resource/images/${product.productId}.jpg"> </c:url>"
            alt="image" width="350" height="350"/>
            <h3>${product.name}</h3>
            <p>${product.description}</p>
            <p>
                <strong><spring:message code="product.ID.label"/></strong><span class="label label-warning">${product.productId}</span>
            </p>
            <p>
                <strong><spring:message code="product.manufacturer.label"/></strong>${product.manufacturer}
            </p>
            <p>
                <strong><spring:message code="product.category.label"/></strong>${product.category}
            </p>
            <p>
                <strong><spring:message code="product.avaliableQuantity.label"/></strong>${product.unitsInStock}
            </p>
            <h4>${product.unitPrice} PLN</h4>
            <p>
                <a href="#" class="btn btn-warning btn-large">
                    <span class="glyphicon-shopping-cart glyphicon">
                    </span> <spring:message code="product.buyNow.button.label"/>
                </a>
                <a href="<spring:url value="/products" />" class="btn btn-default">
                    <span class="glyphicon-hand-left glyphicon"></span>
                    <spring:message code="product.back.button.label"/>
                </a>
            </p>
        </div>
    </div>
</section>
</body>
</html>
