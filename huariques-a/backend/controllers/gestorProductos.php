<?php

class GestorProductos
{

    #MOSTRAR IMAGEN ARTÍCULO
    #------------------------------------------------------------
    public function mostrarImagenController($datos)
    {

        list($ancho, $alto) = getimagesize($datos);

        if ($ancho < 800 || $alto < 400) {

            echo 0;

        } else {

            $aleatorio = mt_rand(100, 999);
            $imagen      = "../../views/images/articulos/temp/articulo" . $aleatorio . ".jpg";
            $origen    = imagecreatefromjpeg($datos);
            $destino   = imagecrop($origen, ["x" => 0, "y" => 0, "width" => 800, "height" => 400]);
            imagejpeg($destino, $imagen);

            echo $imagen;
        }

    }

      #GUARDAR ARTICULO
    #-----------------------------------------------------------

    public function guardarProductoController()
    {

        if (isset($_POST["tituloArticulo"])) {

            $ruta = $_FILES["ruta"]["tmp_name"];

            $borrar = glob("views/images/articulos/temp/*");

            foreach ($borrar as $file) {

                unlink($file);

            }

            $aleatorio = mt_rand(100, 999);

            $imagen = "views/images/articulos/articulo" . $aleatorio . ".jpg";

            $origen = imagecreatefromjpeg($ruta);

            $destino = imagecrop($origen, ["x" => 0, "y" => 0, "width" => 800, "height" => 400]);

            imagejpeg($destino, $imagen);

            $datosController = array("titulo" => $_POST["tituloArticulo"],
                "descripcion"                    => $_POST["descripcionArticulo"],
                "contenido"                       => $_POST["contenidoArticulo"],
                "imagen"                            => $imagen,
                "precio"                       => $_POST["precioArticulo"],
                "categoria"                       => $_POST["categoriaArticulo"]);

            $respuesta = GestorProductosModel::guardarProductoModel($datosController, "productos");

            if ($respuesta == "ok") {

                echo '<script>

                    swal({
                          title: "¡OK!",
                          text: "¡El artículo ha sido creado correctamente!",
                          type: "success",
                          confirmButtonText: "Cerrar",
                          closeOnConfirm: false
                    },

                    function(isConfirm){
                             if (isConfirm) {
                                window.location = "productos";
                              }
                    });


                </script>';

            } else {

                echo $respuesta;

            }

        }

    }


    #MOSTRAR ARTICULOS
    #-----------------------------------------------------------

    static public function mostrarProductosController()
    {

        $respuesta = GestorProductosModel::mostrarProductosModel("productos");

        foreach ($respuesta as $row => $item) {

            echo ' 

                <tr>
                    <td>'.$item["id"].'</td>
                    <td>'.utf8_encode($item["titulo"]).'</td>
                    <td>'.utf8_encode($item["descripcion"]).'</td>
                    <td>'.utf8_encode($item["contenido"]).'</td>
                    <td>'.utf8_encode($item["precio"]).'</td>
                    <td>'.utf8_encode($item["categoria"]).'</td>
                    <td>
<a href="index.php?action=productos&idBorrar=' . $item["id"] . '&rutaImagen=' . $item["imagen"] . '">
                        <i class="fa fa-times btn btn-danger"></i>
                    </a>
                    </td>
                </tr>
';

        }

    }

    #BORRAR ARTICULO
    #------------------------------------

    public function borrarProductoController()
    {

        if (isset($_GET["idBorrar"])) {

            unlink($_GET["rutaImagen"]);

            $datosController = $_GET["idBorrar"];

            $respuesta = GestorProductosModel::borrarProductoModel($datosController, "productos");

            if ($respuesta == "ok") {

                echo '<script>

                    swal({
                          title: "¡OK!",
                          text: "¡El producto se ha borrado correctamente!",
                          type: "success",
                          confirmButtonText: "Cerrar",
                          closeOnConfirm: false
                    },

                    function(isConfirm){
                             if (isConfirm) {
                                window.location = "productos";
                              }
                    });


                </script>';

            }
        }

    }





}
