-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 03, 2022 at 12:40 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `algodomains_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `product_table`
--

CREATE TABLE `product_table` (
  `product_id` int(11) NOT NULL,
  `fild1` varchar(255) DEFAULT NULL,
  `fild2` varchar(255) DEFAULT NULL,
  `fild3` varchar(255) DEFAULT NULL,
  `fild4` varchar(255) DEFAULT NULL,
  `product_category` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_price` double DEFAULT NULL,
  `product_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product_table`
--

INSERT INTO `product_table` (`product_id`, `fild1`, `fild2`, `fild3`, `fild4`, `product_category`, `product_name`, `product_price`, `product_type`) VALUES
(1, '4 Gb Ram', '1 TB Hard Disk', '16 Inch Screen', 'Black colour', 'Electronic', 'Dell Latitude 5420', 57599, 'Laptop'),
(2, '4 Gb Ram', '256 SSD', '14 Inch Screen', 'Silver colour', 'Electronic', 'Lenovo T14 Gen2', 54499, 'Laptop'),
(3, '680 rmp Max Speed', '6.5 kg', 'Stainless Stainless Stil Tub', 'Digital Display', 'Electronic', 'Samsung', 14590, 'Washing Machine'),
(4, '100% wool', 'knite fabric', 'Ribbed neackline', 'Instarsia knit logo', 'Clothing', 'Balman', 39341.66, 'Sweat Shirts'),
(5, '100 % Cotton', 'Regular Cuff', 'Full Sleeves', 'Formal', 'Clothing', 'Louis Philippe', 2313, 'Shirt'),
(6, 'Blue color', ' 500 g', 'Casual Backpack', ' Unisex-adult', 'Bags', 'Sky Bags', 1974, 'Travler Bag'),
(7, 'Blue color', 'Dual Wheels', 'Anti-Theft Zipper', 'TSA Lock', 'Bags', 'Safari', 7110, 'Travler Bag');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product_table`
--
ALTER TABLE `product_table`
  ADD PRIMARY KEY (`product_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product_table`
--
ALTER TABLE `product_table`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
