<?php

require_once "conexion.php";

class GestorCategoriasModel
{

    #GUARDAR CATEGORIAS
    #------------------------------------------------------------

    public function guardarCategoriaModel($datosModel, $tabla)
    {

        $stmt = Conexion::conectar()->prepare("INSERT INTO $tabla (titulo) VALUES (:titulo)");

        $stmt->bindParam(":titulo", $datosModel["titulo"], PDO::PARAM_STR);

        if ($stmt->execute()) {

            return "ok";
        } else {

            return "error";
        }

        $stmt->close();

    }

    #MOSTRAR CATEGORIAS
    #------------------------------------------------------
    public function mostrarCategoriasModel($tabla)
    {

        $stmt = Conexion::conectar()->prepare("SELECT id, titulo FROM $tabla");

        $stmt->execute();

        return $stmt->fetchAll();

        $stmt->close();

    }

    #BORRAR CATEGORIAS
    #-----------------------------------------------------
    public function borrarCategoriaModel($datosModel, $tabla)
    {

        $stmt = Conexion::conectar()->prepare("DELETE FROM $tabla WHERE id = :id");

        $stmt->bindParam(":id", $datosModel, PDO::PARAM_INT);

        if ($stmt->execute()) {

            return "ok";

        } else {

            return "error";

        }

        $stmt->close();

    }

    #ACTUALIZAR CATEGORIAS
    #---------------------------------------------------
    public function editarCategoriaModel($datosModel, $tabla)
    {

        $stmt = Conexion::conectar()->prepare("UPDATE $tabla SET titulo = :titulo WHERE id = :id");

        $stmt->bindParam(":titulo", $datosModel["titulo"], PDO::PARAM_STR);
        $stmt->bindParam(":id", $datosModel["id"], PDO::PARAM_INT);

        if ($stmt->execute()) {

            return "ok";
        } else {

            return "error";
        }

        $stmt->close();

    }


}
