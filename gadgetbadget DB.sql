-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 25, 2021 at 08:11 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gadgetbadget`
--

-- --------------------------------------------------------

--
-- Table structure for table `approvements`
--

CREATE TABLE `approvements` (
  `ApproveID` int(11) NOT NULL,
  `ApproveStatus` varchar(255) NOT NULL,
  `ApproveDate` varchar(255) DEFAULT NULL,
  `ApproveDetails` varchar(255) DEFAULT NULL,
  `Endorser` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `approvements`
--

INSERT INTO `approvements` (`ApproveID`, `ApproveStatus`, `ApproveDate`, `ApproveDetails`, `Endorser`) VALUES
(1, 'Acepted', '12.09.2018', 'Quality Product', 'Nipuna'),
(3, 'Decline', '09.06.2017', 'Quality Product', 'Nipuna Kaush'),
(8, 'Decline', '12.11.2019', 'Not Quality Product', 'kaush'),
(9, 'Decline', '12.11.2019', 'Not Quality Product', 'kaush');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `CustomerID` int(11) NOT NULL,
  `CustomerName` varchar(255) NOT NULL,
  `CustomerEmail` varchar(255) DEFAULT NULL,
  `CustomerType` varchar(255) DEFAULT NULL,
  `CustomerContact` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`CustomerID`, `CustomerName`, `CustomerEmail`, `CustomerType`, `CustomerContact`) VALUES
(1, 'kulana avinash', 'kulana avinash@gmail.com', 'Need-based customer', '0713333333'),
(3, 'Kalana', 'kalana@gmail.com', 'Impulse customer', '0713131967'),
(6, 'Malinda', 'malinda@gmail.com', 'Discount customer', '0713131244');

-- --------------------------------------------------------

--
-- Table structure for table `funders`
--

CREATE TABLE `funders` (
  `FunderID` int(11) NOT NULL,
  `FunderName` varchar(255) NOT NULL,
  `FunderEmail` varchar(255) DEFAULT NULL,
  `FunderContact` varchar(255) DEFAULT NULL,
  `FunderType` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `funders`
--

INSERT INTO `funders` (`FunderID`, `FunderName`, `FunderEmail`, `FunderContact`, `FunderType`) VALUES
(1, 'pathum', 'pathum@gmail.com', '0774565456', 'Governemnt'),
(3, 'avinash', 'avinash@gmail.com', '0345566771 ', 'Government');

-- --------------------------------------------------------

--
-- Table structure for table `inventors`
--

CREATE TABLE `inventors` (
  `InventorID` int(11) NOT NULL,
  `InventorName` varchar(255) NOT NULL,
  `InventorEmail` varchar(255) DEFAULT NULL,
  `InventorContact` varchar(255) DEFAULT NULL,
  `InventorType` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `inventors`
--

INSERT INTO `inventors` (`InventorID`, `InventorName`, `InventorEmail`, `InventorContact`, `InventorType`) VALUES
(3, 'ganepola', 'ganepola@gmail.com', '0987656767', 'Student'),
(4, 'malindaganepola', 'malindaganepola@gmail.com', '0342234321', 'School Leaver'),
(5, 'malindaganepola', 'malindaganepola@gmail.com', '0342234321', 'School Leaver');

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `PaymentID` int(11) NOT NULL,
  `PaymentDate` varchar(255) NOT NULL,
  `CardNumber` varchar(255) DEFAULT NULL,
  `Amount` varchar(255) DEFAULT NULL,
  `PaymentType` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payments`
--

INSERT INTO `payments` (`PaymentID`, `PaymentDate`, `CardNumber`, `Amount`, `PaymentType`) VALUES
(1, '12.09.2017', '12334335454664', '130000.00 ', 'Cash'),
(3, '12.05.2016', '122333443423', '25000.00', 'Debit Cards'),
(6, '12.08.1018', '1231234321314', '150000.00', 'Check');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `ProductID` int(11) NOT NULL,
  `ProductName` varchar(255) NOT NULL,
  `ProductDate` varchar(255) DEFAULT NULL,
  `ProductDetails` varchar(255) DEFAULT NULL,
  `ProductCategory` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`ProductID`, `ProductName`, `ProductDate`, `ProductDetails`, `ProductCategory`) VALUES
(3, 'A Talking Hearing Aid', '12.11.2019', 'Vision Care Hearing Aid Solution Latest Technology With Extensive Aftercare', 'medical'),
(4, 'A Talking Hearing Aid', '12.11.2019', 'Vision Care Hearing Aid Solution Latest Technology With Extensive Aftercare', 'medical');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `approvements`
--
ALTER TABLE `approvements`
  ADD PRIMARY KEY (`ApproveID`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `funders`
--
ALTER TABLE `funders`
  ADD PRIMARY KEY (`FunderID`);

--
-- Indexes for table `inventors`
--
ALTER TABLE `inventors`
  ADD PRIMARY KEY (`InventorID`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`PaymentID`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`ProductID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `approvements`
--
ALTER TABLE `approvements`
  MODIFY `ApproveID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `CustomerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `funders`
--
ALTER TABLE `funders`
  MODIFY `FunderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `inventors`
--
ALTER TABLE `inventors`
  MODIFY `InventorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `PaymentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `ProductID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
