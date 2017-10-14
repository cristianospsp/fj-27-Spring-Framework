<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="templates" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<templates:template>
    <jsp:attribute name="title">Cadastro</jsp:attribute>
    <jsp:body>

        <form:form commandName="product" method="post" enctype="multipart/form-data"
                   action='${spring:mvcUrl("saveProduct").build()}'>

            <div class="mdl-cell mdl-cell--6-col mdl-cell--5-offset">

                <div class="mdl-cell mdl-cell--12-col">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <form:input path="title" class="mdl-textfield__input"/>
                        <form:errors path="title" cssStyle="color: orangered;"/>
                        <label class="mdl-textfield__label" for="title">Título</label>
                    </div>
                </div>

                <div class="mdl-cell mdl-cell--12-col">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <form:input path="dataDeLancamento" type="date" class="mdl-textfield__input"/>
                        <form:errors path="dataDeLancamento" cssStyle="color: orangered;"/>
                        <label class="mdl-textfield__label" for="dataDeLancamento">Data de Lançamento</label>
                    </div>
                </div>

                <div class="mdl-cell mdl-cell--12-col">
                    <div
                            class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <form:textarea path="description" class="mdl-textfield__input" type="text" rows="6"
                                       cols="50" name="description" id="description"></form:textarea>
                        <form:errors path="description"/>
                        <label class="mdl-textfield__label" for="description">Descrição</label>
                    </div>
                </div>

                <div class="mdl-cell mdl-cell--12-col">
                    <div
                            class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <form:input path="numberOfPages" class="mdl-textfield__input" type="text"
                                    pattern="-?[0-9]*(\.[0-9]+)?" id="numberOfPages"/>
                        <form:errors path="numberOfPages"/><label
                            class="mdl-textfield__label" for="numberOfPages"> Número de Páginas </label> <span
                            class="mdl-textfield__error">Input is not a number!</span>
                    </div>
                </div>

                <div class="mdl-grid">
                    <c:forEach items="${types}" var="bookType" varStatus="status">
                        <div class="mdl-cell mdl-cell--3-col">
                            <div
                                    class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                                <label for="price_${bookType}">${bookType}</label>
                                <form:input class="mdl-textfield__input" pattern="-?[0-9]*(\.[0-9]+)?"
                                            path="prices[${status.index}].value"
                                            id="price_${bookType}"/>
                                <form:errors path="prices[${status.index}].value"/>
                                <form:input type="hidden"
                                            path="prices[${status.index}].bookType" value="${bookType}"/>

                            </div>
                        </div>

                    </c:forEach>
                </div>

                <div class="mdl-cell mdl-cell--12-col">
                    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                        <input name="summary" id="summary" type="file" class="mdl-textfield__input"/>
                        <form:errors path="summaryPath" cssStyle="color: orangered;"/>
                        <label class="mdl-textfield__label" for="summary">Sumário do Livro</label>
                    </div>
                </div>


                <div class="mdl-cell mdl-cell--12-col">
                    <input
                            class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
                            type="submit" value="Enviar"/>
                </div>
            </div>

        </form:form>
    </jsp:body>
</templates:template>
