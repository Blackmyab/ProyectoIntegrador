<?php

class EnlacesModels
{

    public function enlacesModel($enlaces)
    {

        if ($enlaces == "ventas" ||
            $enlaces == "ingreso" ||
            $enlaces == "slide" ||
            $enlaces == "suscriptores" ||
            $enlaces == "productos" ||
            $enlaces == "categorias" ||
            $enlaces == "salir") {

            $module = "views/modules/" . $enlaces . ".php";
        } else if ($enlaces == "index") {
            $module = "views/modules/ingreso.php";
        } else {
            $module = "views/modules/ingreso.php";
        }

        return $module;

    }

}
