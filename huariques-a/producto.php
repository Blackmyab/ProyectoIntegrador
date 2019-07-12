<?php

require_once "controllers/detalles.php";

require_once "models/gestorCategoria.php";
require_once "controllers/gestorCategoria.php";

require_once "models/gestorOfertas.php";
require_once "controllers/gestorOfertas.php";

require_once "models/gestorProducto.php";
require_once "controllers/gestorProducto.php";


$detalles = new DetallesController();
$detalles -> detalles();