<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" value="Find My Boxes" />
<%@include file="common/header.jsp"%>




<h1>Find the perfect box for your next shipping adventure</h1>
<c:url var="boxParametersSubmitUrl" value="/" />
<form method="POST" action="${boxParametersSubmitUrl}" modelAttribute="boxParameters">
	<div class="dimension_container">
		<div class="item_image">
			<c:url value="/img/dimensions.png" var="product_img_url" />
			<img src="${product_img_url}" title="product logo" />
		</div>
		<div class="height_entry">
			<div class="form_item">
				<label for="height">Height</label>
				<input type="text" placeholder="20.75" maxlength="8" name="height" id="height" required/>
				
			</div>
		</div>
		<div class="width_entry">
			<div class="form_item">
				<label for="width">Width</label>
				<input type="text" placeholder="8.25" maxlength="8" name="width" id="width" required/>
			</div>
		</div>
		<div class="length_entry">
			<div class="form_item">
				<label for="length">Length</label>
				<input type="text" placeholder="8.25" maxlength="8" name="length" id="length" required/>
			</div>
		</div>
	</div>
</form>

<%@include file="common/footer.jsp"%>