<?php

require_once "conexion.php";

class GestorProductosModel
{

    #GUARDAR ARTICULO
    #------------------------------------------------------------

    public function guardarProductoModel($datosModel, $tabla)
    {

        $stmt = Conexion::conectar()->prepare("INSERT INTO $tabla (titulo, descripcion, contenido, imagen, precio, categoria) VALUES (:titulo, :descripcion, :contenido, :imagen, :precio, :categoria)");


      

        $stmt->bindParam(":titulo", $datosModel["titulo"], PDO::PARAM_STR);
        $stmt->bindParam(":descripcion", $datosModel["descripcion"], PDO::PARAM_STR);
        $stmt->bindParam(":contenido", $datosModel["contenido"], PDO::PARAM_STR);
        $stmt->bindParam(":imagen", $datosModel["imagen"], PDO::PARAM_STR);
        $stmt->bindParam(":precio", $datosModel["precio"], PDO::PARAM_INT);
        $stmt->bindParam(":categoria", $datosModel["categoria"], PDO::PARAM_INT);


        if ($stmt->execute()) {

            return "ok";
        } else {

            return "error";
        }

        $stmt->close();

    }

    #MOSTRAR ARTÍCULOS
    #------------------------------------------------------
    static public function mostrarProductosModel($tabla)
    {

        $stmt = Conexion::conectar()->prepare("SELECT id, titulo, descripcion, contenido, imagen, precio, categoria  FROM $tabla");

        $stmt->execute();

        return $stmt->fetchAll();

        $stmt->close();

    }

    #BORRAR ARTICULOS
    #-----------------------------------------------------
    public function borrarProductoModel($datosModel, $tabla)
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




}
