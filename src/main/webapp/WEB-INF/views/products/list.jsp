<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listagem de Produtos</title>
</head>
	<body>
		<table>
			<tr>
				<th>T�tulo</th>
				<th>Valores</th>
			</tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.title}</td>
					<td>${product.description}</td>
					<td>
						<c:forEach items="${product.prices}" var="price">
							[${price.value} - ${prce.bookType}]
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>