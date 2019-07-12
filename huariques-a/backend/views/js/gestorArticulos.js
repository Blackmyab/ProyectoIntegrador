/*=============================================
Agregar artículo          
=============================================*/
$("#btnAgregarArticulo").click(function(){

	$("#agregarArtículo").toggle(400);

})

/*=============================================
Subir Imagen a través del Input         
=============================================*/
$("#subirFoto").change(function(){

	imagen = this.files[0];

	//Validar tamaño de la imagen

	imagenSize = imagen.size;

	if(Number(imagenSize) > 2000000){

		$("#arrastreImagenArticulo").before('<div class="alert alert-warning alerta text-center">El archivo excede el peso permitido, 200kb</div>')

	}

	else{

		$(".alerta").remove();

	}

	// Validar tipo de la imagen

	imagenType = imagen.type;

	if(imagenType == "image/jpeg" || imagenType == "image/png"){

		$(".alerta").remove();
	}

	else{

		$("#arrastreImagenArticulo").before('<div class="alert alert-warning alerta text-center">El archivo debe ser formato JPG o PNG</div>')

	}



})






/*=============================================
Editar CATEGORIA     
=============================================*/

$(".editarCategoria").click(function(){

	idArticulo = $(this).parent().parent().attr("id");
	titulo = $("#"+idArticulo).children("h1").html();

	$("#"+idArticulo).html('<form method="post" enctype="multipart/form-data"><input type="text" value="'+titulo+'" name="editarTitulo"><span><input style="width:100%; padding:5px 0; margin-top:4px" type="submit" class="btn btn-primary pull-right" value="Guardar"></span><input type="hidden" value="'+idArticulo+'" name="id"><hr></form>');



})




