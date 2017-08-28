<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Products</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1><spring:message code="products.title.lablel"/></h1>
            <p><spring:message code="products.paragraph.label"/></p>
        </div>
        <div class="pull-right" style="padding-right:50px">
            <a href="?language=pl" ><spring:message code="addProduct.changeLangToPL.button.label"/>
            </a>|<a href="?language=eng" ><spring:message code="addProduct.changeLangToENG.button.label"/></a>
        </div>
    </div>
</section>

<section class="container">
    <div class="row">
        <c:forEach items="${products}" var="product">
            <div class="col-sm-4" style="padding-bottom: 15px" align="left">
                <div class="thumbnail">
                    <img src="<c:url value="/resource/images/${product.productId}.jpg">
                    </c:url>" alt="image" style="width:100%"/>
                    <div class="caption">
                        <h3>${product.name}</h3>
                        <p>${product.description}</p>
                        <p>${product.unitPrice} PLN</p>
                        <p><spring:message code="products.avaliableQuantity.label"/>${product.unitsInStock}</p>
                        <p><a href=" <spring:url value="/products/product/${product.productId}" />"
                               class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"></span>
                            <spring:message code="products.details.button.label"/>
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
</body>
</html>
