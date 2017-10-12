<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="templates"%>

<templates:template>
	<jsp:attribute name="title">Livros</jsp:attribute>
	<jsp:body>
	
	<div class="mdl-grid">
		<div class="mdl-cell mdl-cell--2-col"></div>
		<div class="mdl-cell mdl-cell--8-col">
		<h4>${sucesso}</h4>
		<h3>Livros</h3>
		<table
					class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
			<thead>
				<tr>
					<th class="mdl-data-table__cell--non-numeric">T�tulo</th>
					<th>Descri��o</th>
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
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		<div class="mdl-cell mdl-cell--2-col"></div>
	</div>
	</jsp:body>
</templates:template>