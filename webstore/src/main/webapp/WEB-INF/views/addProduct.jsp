<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>New Product</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1><spring:message code="addProduct.title.label"/></h1>
            <p><spring:message code="addProduct.paragraph.label"/></p>
        </div>
        <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">
            <spring:message code="addProduct.logout.button.label"/>
        </a>
        <div class="pull-right" style="padding-right:50px">
            <a href="?language=pl" ><spring:message code="addProduct.changeLangToPL.button.label"/>
            </a>|<a href="?language=eng" ><spring:message code="addProduct.changeLangToENG.button.label"/></a>
        </div>
    </div>

</section>
<section class="container">
    <form:form modelAttribute="newProduct" class="form-horizontal"
    enctype="multipart/form-data">
        <form:errors path="*" cssClass="alert alert-danger" element="div"/>
        <fieldset>
            <legend><spring:message code="addProduct.legend.label"/></legend>

            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="productId">
                    <spring:message code="addProduct.form.productId.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="productId" path="productId" type="text" class="form:input-large"/>
                    <form:errors path="productId" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="name">
                    <spring:message code="addProduct.form.name.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="name" path="name" type="text" class="form:input-large"/>
                    <form:errors path="name" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="unitPrice">
                    <spring:message code="addProduct.form.unitPrice.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="unitPrice" path="unitPrice" type="text" class="form:input-large"/>
                    <form:errors path="unitPrice" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="description">
                    <spring:message code="addProduct.form.description.label"/>
                </label>
                <div class="col-lg-10">
                    <form:textarea id="description" path="description" rows="2"/>
                    <form:errors path="description" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="manufacturer">
                    <spring:message code="addProduct.form.manufacturer.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="manufacturer" path="manufacturer" type="text" class="form:input-large"/>
                    <form:errors path="manufacturer" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="category">
                    <spring:message code="addProduct.form.category.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="category" path="category" type="text" class="form:input-large"/>
                    <form:errors path="category" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="unitsInStock">
                    <spring:message code="addProduct.form.unitsInStock.label"/>
                </label>
                <div class="col-lg-10">
                    <form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
                    <form:errors path="unitsInStock" cssClass="text-danger"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="condition">
                    <spring:message code="addProduct.form.condition.label"/>
                </label>
                <div class="col-lg-10">
                    <form:radiobutton id="condition" path="condition" value="New"/>
                    <spring:message code="addProduct.form.conditionNew.label"/><br>
                    <form:radiobutton id="condition" path="condition" value="Old"/>
                    <spring:message code="addProduct.form.conditionOld.label"/> <br>
                    <form:radiobutton id="condition" path="condition" value="Refurbished"/>
                    <spring:message code="addProduct.form.conditionRefurbished.label"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="productImage">
                    <spring:message code="addProduct.form.productImage.label" />
                </label>
                <div class="col-lg-10">
                    <form:input id="productImage" path="productImage" type="file"
                                class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="productInfo">
                    <spring:message code="addProduct.form.productInfo.label" />
                </label>
                <div class="col-lg-10">
                    <form:input id="productInfo" path="productInfo" type="file"
                                class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary"
                           value="<spring:message code="addProduct.form.add.button.label"/>"/>
                </div>
            </div>

        </fieldset>
    </form:form>
</section>
</body>
</html>

