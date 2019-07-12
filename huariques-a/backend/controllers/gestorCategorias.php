<?php

class GestorCategorias
{


    #GUARDAR ARTICULO
    #-----------------------------------------------------------

    public function guardarCategoriaController()
    {

        if (isset($_POST["tituloArticulo"])) {



            $datosController = array("titulo" => $_POST["tituloArticulo"]);

            $respuesta = GestorCategoriasModel::guardarCategoriaModel($datosController, "categorias");

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
                                window.location = "categorias";
                              }
                    });


                </script>';

            } else {

                echo $respuesta;

            }

        }

    }

    #MOSTRAR CATEGORIAS
    #-----------------------------------------------------------

    public function mostrarCategoriasController()
    {

        $respuesta = GestorCategoriasModel::mostrarCategoriasModel("categorias");

        foreach ($respuesta as $row => $item) {

            echo '


             <li id="' . $item["id"] . '" class="bloqueArticulo">

                   <h1>'.utf8_encode($item["titulo"]).'</h1>
                                       <span class="handleArticle">
                    <a href="index.php?action=categorias&idBorrar=' . $item["id"] . '">
                        <i class="fa fa-times btn btn-danger"></i>
                    </a>
                    <i class="fa fa-pencil btn btn-primary editarCategoria"></i>
                    </span>
                </li>



                ';

        }

    }


    #ACTUALIZAR CATEGORIAS
    #-----------------------------------------------------------

    public function editarCategoriaController()
    {


        if (isset($_POST["editarTitulo"])) {



            $datosController = array("id" => $_POST["id"],
                "titulo"=> $_POST["editarTitulo"]);

            $respuesta = GestorCategoriasModel::editarCategoriaModel($datosController, "categorias");

            if ($respuesta == "ok") {

                echo '<script>

                    swal({
                          title: "¡OK!",
                          text: "¡El artículo ha sido actualizado correctamente!",
                          type: "success",
                          confirmButtonText: "Cerrar",
                          closeOnConfirm: false
                    },

                    function(isConfirm){
                             if (isConfirm) {
                                window.location = "categorias";
                              }
                    });


                </script>';

            } else {

                echo $respuesta;

            }

        }

    }

    #BORRAR CATEGORIAS
    #------------------------------------

    public function borrarCategoriaController()
    {

        if (isset($_GET["idBorrar"])) {


            $datosController = $_GET["idBorrar"];

            $respuesta = GestorCategoriasModel::borrarCategoriaModel($datosController, "categorias");

            if ($respuesta == "ok") {

                echo '<script>

                    swal({
                          title: "¡OK!",
                          text: "¡La categoria se ha borrado correctamente!",
                          type: "success",
                          confirmButtonText: "Cerrar",
                          closeOnConfirm: false
                    },

                    function(isConfirm){
                             if (isConfirm) {
                                window.location = "categorias";
                              }
                    });


                </script>';

            }
        }

    }




}
