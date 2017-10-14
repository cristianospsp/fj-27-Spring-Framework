<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="templates" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<templates:template>
    <jsp:attribute name="title">Livros ::: On-Line</jsp:attribute>
    <jsp:body>

        <div class="mdl-cell mdl-cell--6-col mdl-cell--3-offset">
            <h4>${sucesso}</h4>
            <h3>Livros</h3>
            <div class="mdl-cell mdl-cell--12-col">
                <table class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
                    <thead>
                    <tr>
                        <th class="mdl-data-table__cell--non-numeric">Título</th>
                        <th>Descrição</th>
                        <th>Valores</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${products}" var="product">
                        <tr>
                            <td class="mdl-data-table__cell--non-numeric">${product.title}</td>
                            <td class="mdl-data-table__cell--non-numeric">${product.description}</td>
                            <td><c:forEach items="${product.prices}" var="price">
                                [${price.value} - ${price.bookType}]
                            </c:forEach></td>
                            <td>
                                <c:url value="/products/${product.id}" var="linkDetalhar" />
                                <a href="${linkDetalhar}">
                                    Detalhar
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </jsp:body>
</templates:template>