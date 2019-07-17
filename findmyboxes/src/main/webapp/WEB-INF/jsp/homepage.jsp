<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="Find My Boxes" />
<%@include file="common/header.jsp"%>

<div class="bg-img">

</div>


<section class="hero is-link is-bold has-text-centered">
	<div class="hero-body">
		<div class="container">
			<h1 class="title">Find the perfect boxes for your next shipping adventure</h1>
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
							<input class="input" type="text" placeholder="20.75"
								maxlength="8" name="height" id="height" required />
						</div>
					</div>
					<div class="field dimension">
						<label class="label" for="width">Width</label>
						<div class="control">
							<input class="input" type="text" placeholder="8.25" maxlength="8"
								name="width" id="width" required />
						</div>
					</div>
					<div class="field dimension">
						<label class="label" for="length">Length</label>
						<div class="control">
							<input class="input" type="text" placeholder="8.25" maxlength="8"
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

<%@include file="common/footer.jsp"%>