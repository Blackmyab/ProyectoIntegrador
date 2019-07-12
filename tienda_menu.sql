-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-07-2019 a las 09:03:45
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tienda_menu`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `id` int(11) NOT NULL,
  `titulo` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id`, `titulo`) VALUES
(4, 'MENU CASERO'),
(5, 'MENU CARTA'),
(6, 'MENU EJECUTIVO'),
(8, 'MENU GASTRONOMICO'),
(9, 'DIETA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `titulo` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `descripcion` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  `contenido` varchar(800) COLLATE utf8_spanish_ci NOT NULL,
  `imagen` varchar(80) CHARACTER SET latin1 NOT NULL,
  `precio` decimal(12,2) NOT NULL,
  `calificacion` decimal(2,1) NOT NULL,
  `categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `titulo`, `descripcion`, `contenido`, `imagen`, `precio`, `calificacion`, `categoria`) VALUES
(12, 'Seco de Pollo', 'Comida', 'Segundo+Sopa+refresco', 'views/images/articulos/secopollo.jpg', '8.00', '0.0', 4),
(13, 'Pollo A la Olla', 'Comida', 'SEGUNDO+SOPA+REFRESCO', 'views/images/articulos/polloolla.jpg', '8.00', '0.0', 4),
(14, 'Arroz ala Cubana', 'Comida', 'Segundo+postre', 'views/images/articulos/arrozcuaban.jpg', '15.00', '0.0', 5),
(15, 'Lomo Saltado', 'Comida', 'Segundo+Postre', 'views/images/articulos/lomosaltado.jpg', '15.00', '0.0', 5),
(16, 'Omelete Pollo', 'Comida', 'Segundo+Refresco', 'views/images/articulos/omeletepollo.jpg', '25.00', '0.0', 9),
(17, 'Suprema Plancha', 'Comida', 'Segundo+refresco', 'views/images/articulos/supremaplancha.jpg', '25.00', '0.0', 9),
(18, 'Carapulcra Pollo/chancho', 'Comida', 'Segundo+chicha', 'views/images/articulos/carapulcra.jpg', '33.00', '0.0', 8),
(19, 'Pollo Plancha', 'Comida', 'Segundo+refresco', 'views/images/articulos/polloplancha.jpg', '25.00', '0.0', 9),
(20, 'Bisteck A lo pobre', 'Comida', 'Segundo+postre+refresco/gaseso', 'views/images/articulos/bisteckpobre.jpg', '20.00', '0.0', 6),
(22, 'Sopa Seca de pollo', 'Comida', 'Segundo+chicha', 'views/images/articulos/sopaseca.jpg', '25.00', '0.0', 8),
(23, 'Aji de Gallina', 'Segundo', 'Plato tipico Limeno compuesto bla bla bla', 'views/images/articulos/articulo395.jpg', '20.00', '0.0', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `slide`
--

CREATE TABLE `slide` (
  `id` int(11) NOT NULL,
  `ruta` text NOT NULL,
  `titulo` text NOT NULL,
  `descripcion` text NOT NULL,
  `orden` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `slide`
--

INSERT INTO `slide` (`id`, `ruta`, `titulo`, `descripcion`, `orden`) VALUES
(74, '../../views/images/slide/slidemenu1.jpg', 'descubre que tenemos para ti', 'ya estamos en linea', 1),
(75, '../../views/images/slide/slidemenu4.jpg', 'descubre las increiï¿½bles ofertas', 'que tenemos para ti', 2),
(76, '../../views/images/slide/slidemenu5.jpg', 'aprovecha los descuentos', 'de la temporada', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `usuario` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` varchar(15) NOT NULL,
  `mail` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `usuario`, `password`, `role`, `mail`) VALUES
(1, 'czubilete', '1234', 'administrador', 'huariques@curso.com'),
(2, 'sofea', '1234', 'cliente', 'comprador@curso.com'),
(12, 'cesar', '123456', 'cliente', 'czubilete@cliente.com'),
(14, 'Briam', 'claveprueb', 'cliente', 'pablito_el_alto@hotmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id` int(11) NOT NULL,
  `usuario` int(11) NOT NULL,
  `producto` varchar(30) NOT NULL,
  `imagen` varchar(80) NOT NULL,
  `costo` decimal(12,2) NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`id`, `usuario`, `producto`, `imagen`, `costo`, `fecha`) VALUES
(23, 2, 'Seco de Pollo', '', '8.00', '2019-06-12 00:00:00'),
(24, 12, 'seco de pollo', 'secopollo.jpg', '500.00', '2019-04-22 00:00:00');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `categoria` (`categoria`);

--
-- Indices de la tabla `slide`
--
ALTER TABLE `slide`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `usuario` (`usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `slide`
--
ALTER TABLE `slide`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=77;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`categoria`) REFERENCES `categorias` (`id`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
