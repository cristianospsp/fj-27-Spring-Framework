<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags/templates" prefix="templates"%>

<templates:template>
<jsp:attribute name="title">Cadastro</jsp:attribute>
	<jsp:body>
<c:url value="/products" var="url" />
<form method="post" action="${url}">


	<div class="mdl-grid">
		<div class="mdl-cell mdl-cell--4-col"></div>
		<div class="mdl-cell mdl-cell--4-col">

			<div class="mdl-cell mdl-cell--12-col">
				<div
							class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
					<input class="mdl-textfield__input" type="text" name="title"
								id="title" required="required" /> <label
								class="mdl-textfield__label" for="title">Título</label>
				</div>
			</div>

			<div class="mdl-cell mdl-cell--12-col">
				<div
							class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
					<textarea class="mdl-textfield__input" type="text" rows="6"
								cols="50" name="description" id="description"
								required="required"></textarea>
					<label class="mdl-textfield__label" for="description">Descrição</label>
				</div>
			</div>

			<div class="mdl-cell mdl-cell--12-col">
				<div
							class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
					<input class="mdl-textfield__input" type="text"
								pattern="-?[0-9]*(\.[0-9]+)?" id="numberOfPages"
								required="required" /> <label class="mdl-textfield__label"
								for="numberOfPages"> Número de Páginas </label> <span
								class="mdl-textfield__error">Input is not a number!</span>
				</div>
			</div>

			<div class="mdl-grid">
				<c:forEach items="${types}" var="bookType" varStatus="status">
					<div class="mdl-cell mdl-cell--3-col">
						<div
									class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
							<label for="price_${bookType}">${bookType}</label> <input
										class="mdl-textfield__input" pattern="-?[0-9]*(\.[0-9]+)?"
										type="text" name="prices[${status.index}].value"
										id="price_${bookType}" required="required" /> <input
										type="hidden" name="prices[${status.index}].bookType"
										value="${bookType}" />
						</div>
					</div>

				</c:forEach>
			</div>
			<div class="mdl-cell mdl-cell--12-col">
				<input
							class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent"
							type="submit" value="Enviar" />
			</div>
		</div>
		<div class="mdl-cell mdl-cell--4-col"></div>
	</div>

</form>
</jsp:body>
</templates:template>