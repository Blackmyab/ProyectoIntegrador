<?php

require_once "controllers/template.php";

require_once "models/gestorSlide.php";
require_once "controllers/gestorSlide.php";

require_once "models/gestorCategoria.php";
require_once "controllers/gestorCategoria.php";

require_once "models/gestorOfertas.php";
require_once "controllers/gestorOfertas.php";

require_once "models/gestorNuevos.php";
require_once "controllers/gestorNuevos.php";

require_once "models/gestorTodo.php";
require_once "controllers/gestorTodo.php";



$template = new TemplateController();
$template -> template();




