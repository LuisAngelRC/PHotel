-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-06-2021 a las 06:44:44
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hotel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `huespedes`
--

CREATE TABLE `huespedes` (
  `nombre` varchar(45) NOT NULL,
  `ciudad` varchar(30) NOT NULL,
  `fechaE` date NOT NULL,
  `fechaS` date NOT NULL,
  `tipoH` varchar(10) NOT NULL,
  `numPersonas` int(10) NOT NULL,
  `cuentaNumPersonas` int(50) NOT NULL,
  `numPiso` int(4) NOT NULL,
  `numHab` int(40) NOT NULL,
  `cuentaServicios` int(50) NOT NULL,
  `diasHospedaje` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `huespedes`
--

INSERT INTO `huespedes` (`nombre`, `ciudad`, `fechaE`, `fechaS`, `tipoH`, `numPersonas`, `cuentaNumPersonas`, `numPiso`, `numHab`, `cuentaServicios`, `diasHospedaje`) VALUES
('a', 'a', '2021-06-01', '2021-06-04', 'Hunn', 2, 0, 2, 27, 0, 0),
('ab', 'b', '2021-06-01', '2021-06-07', 'Hunn', 2, 0, 1, 9, 0, 0),
('anhel', 'a', '2021-06-01', '2021-06-04', 'Hunn', 2, 0, 2, 24, 0, 0),
('Anjol bb', 'ags', '2021-06-02', '2021-06-07', 'Hunn', 2, 0, 2, 18, 0, 0),
('axxx', 'a', '2021-06-02', '2021-06-08', 'Hunn', 2, 3200, 2, 21, 0, 0),
('cxx', 'e', '2021-06-01', '2021-06-07', 'Hunn ', 2, 0, 1, 6, 0, 0),
('er', 'a', '2021-06-02', '2021-06-05', 'Hunn ', 2, 0, 2, 29, 0, 0),
('fd', 'a', '2021-06-01', '2021-06-08', 'Hunn ', 2, 0, 1, 6, 0, 0),
('fr', 'a', '2021-06-01', '2021-06-06', 'Hunn', 1, 2800, 2, 19, 0, 0),
('fra', 'a', '2021-06-01', '2021-06-04', 'Hunn', 1, 2800, 1, 14, 0, 0),
('gf', 'q', '2021-06-02', '2021-06-05', 'Hunn ', 2, 0, 1, 2, 0, 0),
('hg', 'f', '2021-06-01', '2021-06-08', 'Hunn ', 2, 0, 2, 16, 0, 0),
('MAXI', 'ags', '2021-06-02', '2021-06-06', 'Hunn ', 2, 0, 1, 3, 0, 0),
('qw', 'a', '2021-06-01', '2021-06-08', 'Hunn', 2, 2800, 2, 29, 0, 0),
('r', 'f', '2021-06-01', '2021-06-08', 'Hunn ', 2, 0, 2, 17, 0, 0),
('re', 'f', '2021-06-01', '2021-06-04', 'Hunn ', 4, 0, 2, 19, 0, 0),
('rtt', 'a', '2021-06-01', '2021-06-07', 'Hunn', 3, 2800, 2, 30, 0, 0),
('sa', 'e', '2021-06-01', '2021-06-06', 'Hunn', 2, 2800, 1, 13, 0, 0),
('t', 'a', '2021-06-02', '2021-06-09', 'Hunn ', 2, 0, 2, 23, 0, 0),
('u', 'u', '2021-06-01', '2021-06-06', 'Hunn', 3, 3600, 2, 28, 0, 0),
('xiam', 'a', '2021-06-01', '2021-06-04', 'Hunn', 1, 2800, 2, 26, 0, 3),
('yt', 'a', '2021-06-02', '2021-06-05', 'Hunn', 2, 3200, 2, 17, 0, 0),
('za', 'f', '2021-06-01', '2021-06-05', 'Hunn ', 2, 0, 1, 10, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `usuario` varchar(20) NOT NULL,
  `pswd` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`usuario`, `pswd`) VALUES
('Max_Gonzalez', '9450476b384b32d8ad8b758e76c98a69');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `huespedes`
--
ALTER TABLE `huespedes`
  ADD PRIMARY KEY (`nombre`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
