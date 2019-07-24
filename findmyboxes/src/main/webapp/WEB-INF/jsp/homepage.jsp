<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="pageTitle" value="Find My Boxes" />
<%@include file="common/header.jsp"%>


<section class="hero is-link is-bold has-text-centered">
	<div class="hero-body">
		<div class="container">
			<h1 class="title">Moving? Shipping? Wrapping?</h1>
			<h1 class="title">Find the best fitted box for any of your items!</h1>
		</div>
	</div>
</section>

<h2 class="title"></h2>
<c:url var="boxParametersSubmitUrl" value="/" />

<div id="main-card" class="container">
	<form method="POST" action="${boxParametersSubmitUrl}"
		modelAttribute="boxParameters">
		<div class="card card-content">
			<div class="columns has-text-centered">
				<div class="column">
					<figure class="image">
						<img id="product-image" src="img/dimensions.png"
							title="sample shipping item image">
					</figure>
				</div>
				<div class="column">
					<div class="field dimension">
						<label class="label" for="height">Height</label>
						<div class="control">
							<input class="input" type="text" placeholder="20.75 (in)"
								maxlength="8" name="height" id="height" required />
						</div>
					</div>
					<div class="field dimension">
						<label class="label" for="width">Width</label>
						<div class="control">
							<input class="input" type="text" placeholder="8.25 (in)" maxlength="8"
								name="width" id="width" required />
						</div>
					</div>
					<div class="field dimension">
						<label class="label" for="length">Length</label>
						<div class="control">
							<input class="input" type="text" placeholder="8.25 (in)" maxlength="8"
								name="length" id="length" required />
						</div>
					</div>
				</div>
			</div>
			<div class="has-text-centered">
				<button class="button is-link" type="submit">Find My Boxes</button>
			</div>
		</div>
	</form>
</div>
<br>
<div id="results" class="container has-text-centered">
	<c:if test="${fn:length(boxes) > 0}">
		<h4 class="title">Best fits for ${boxParameters.height}" x ${boxParameters.width}" x ${boxParameters.length}"</h4>
		<h4 class="subtitle">Sorted by Lowest Volume</h4>
	</c:if>
	<c:forEach items="${boxes}" var="box">
		<div class="card card-content">
			<div class="columns">
				<div class="column">
					<figure class="image is-64x64">
						<img src="img/${box.supplierLogo}" title="Supplier logo">
					</figure>
				</div>
				<div class="column">
					<p class="has-text-weight-semibold">Dimensions</p>
					<span>${box.length}" x ${box.width}" x ${box.height}"</span>
				</div>
				<div class="column">
					<p class="has-text-weight-semibold">Price</p>
					<span><fmt:formatNumber value="${box.price}" type="CURRENCY"></fmt:formatNumber></span>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@include file="common/footer.jsp"%>