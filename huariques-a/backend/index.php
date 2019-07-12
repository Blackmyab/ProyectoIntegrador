<?php

require_once "models/enlaces.php";
require_once "models/ingreso.php";
require_once "models/gestorSlide.php";
require_once "models/gestorProductos.php";
require_once "models/gestorCategorias.php";
require_once "models/gestorSuscriptores.php";
require_once "models/gestorVentas.php";

require_once "controllers/template.php";
require_once "controllers/enlaces.php";
require_once "controllers/ingreso.php";
require_once "controllers/gestorSlide.php";
require_once "controllers/gestorProductos.php";
require_once "controllers/gestorCategorias.php";
require_once "controllers/gestorSuscriptores.php";
require_once "controllers/gestorVentas.php";

$template = new TemplateController();
$template->template();
