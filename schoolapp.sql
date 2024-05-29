-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 29, 2024 at 08:30 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `schoolapp`
--

-- --------------------------------------------------------

--
-- Table structure for table `teachers`
--

CREATE TABLE `teachers` (
  `id` int(11) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `hiring_date` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `teachers`
--

INSERT INTO `teachers` (`id`, `age`, `gender`, `hiring_date`, `name`, `email`, `phone_number`) VALUES
(1, 30, 'Male', '2024-05-27 15:22:56.000000', 'Agus Cahyo', 'djbieri@csicable.net', '6283666478822'),
(2, 45, 'Female', '2024-05-27 21:30:37.000000', 'Siti Fatimah', 'fatimahsiti@gmail.com', '6287733634561'),
(3, 26, 'Male', '2024-05-07 15:43:45.000000', 'Roby Putra Alaidrus', 'robyput@gmail.com', '3453512312323'),
(4, 49, 'Female', '2024-05-27 15:41:00.000000', 'Fatmawati Putri', 'asdas@asdas.com', '3453512312323'),
(6, 55, 'Female', '2024-05-28 15:37:09.000000', 'Kunaesih', 'dioprasetiyo21@365msoffice.live', '0851618212123'),
(8, 44, 'Female', '2024-05-28 15:01:52.000000', 'Haryati', 'asdas@asdas', '6283453511119'),
(9, 30, 'Female', '2024-05-28 21:48:57.000000', 'Nurlela kusuma', 'lela@mail.com', '628523432434'),
(10, 31, 'Male', '2024-05-28 21:58:31.000000', 'kusuma bakti', 'kusumab@mail.com', '628523432431214'),
(12, 27, 'Female', '2024-05-29 13:24:45.000000', 'Monica Rainbow', 'moicar@mail.com', '628521212434');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `teachers`
--
ALTER TABLE `teachers`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `teachers`
--
ALTER TABLE `teachers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
