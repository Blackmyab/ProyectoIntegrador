<?php

require_once "controllers/categorias.php";

require_once "models/gestorCategoria.php";
require_once "controllers/gestorCategoria.php";

require_once "models/gestorCate.php";
require_once "controllers/gestorCate.php";

$categorias = new CategoriasController();
$categorias -> categorias();