-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 22, 2020 at 04:49 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mycourse`
--

-- --------------------------------------------------------

--
-- Table structure for table `courseregister`
--

CREATE TABLE `courseregister` (
  `userid` varchar(50) NOT NULL,
  `courseid` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courseregister`
--

INSERT INTO `courseregister` (`userid`, `courseid`) VALUES
('mrr', 'r1r'),
('mrr', 'r199r'),
('mrr', 'r19r'),
('15', '2'),
('15', '1'),
('17', '1'),
('17', '3'),
('17', '2'),
('18', '1');

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `courseid` int(50) NOT NULL,
  `coursename` varchar(50) NOT NULL,
  `duration` varchar(1000) NOT NULL,
  `tutor` varchar(1000) NOT NULL,
  `price` longtext NOT NULL,
  `coursepic` longtext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`courseid`, `coursename`, `duration`, `tutor`, `price`, `coursepic`) VALUES
(1, 'Java', '12 ', 'Allwin jones', '4000', 'http://192.168.106.8/dashboard/courseimages/java.jpg'),
(2, 'Python', '10', 'Ajeeth Vikram', '3000', 'http://192.168.106.8/dashboard/courseimages/python.jpg'),
(3, 'Dart', '14', 'Abinesh Thangavel', '4500', 'http://192.168.106.8/dashboard/courseimages/dart.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `pass` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `pass`) VALUES
(1, 'q', 'q', 'q'),
(3, 'm', 'm', 'm'),
(4, 'mr', 'mr', 'mr'),
(5, 't', 'y', 't'),
(6, 'mrr', 'rmr', 'rmr'),
(7, 'mrr', 'rmrr', 'rmr'),
(8, 'mrr', 'rmr1r', 'rmr'),
(9, 'kksoe', 'sidijdjd', 'djjdhdjd'),
(10, 'rcur', 'pvuur', 'vuru'),
(11, 'mrr', 'rmr1rr', 'rmr'),
(12, 'ogidufue', 'dusysskfo', 'fidkfkdi'),
(13, 'pl', 'pl', 'pl'),
(14, 'mrr', 'r1r', 'rmr'),
(15, 'typfjfnd', 'typfjtj', 'ty'),
(16, 'mrr', 'r1r09', 'rmr'),
(17, 'tyu', 'tyu', 'tyu'),
(18, 'Rohith Kannan', 'rohithkannan.m@gmail.com', 'Rohith123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`courseid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `courseid` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
