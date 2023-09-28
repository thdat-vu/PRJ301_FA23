USE [master]
GO
/****** Object:  Database [Mvc2DB]    Script Date: 9/29/2023 12:31:50 AM ******/
CREATE DATABASE [Mvc2DB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Mvc2DB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER\MSSQL\DATA\Mvc2DB.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Mvc2DB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER\MSSQL\DATA\Mvc2DB_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [Mvc2DB] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Mvc2DB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Mvc2DB] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Mvc2DB] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Mvc2DB] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Mvc2DB] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Mvc2DB] SET ARITHABORT OFF 
GO
ALTER DATABASE [Mvc2DB] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Mvc2DB] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Mvc2DB] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Mvc2DB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Mvc2DB] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Mvc2DB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Mvc2DB] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Mvc2DB] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Mvc2DB] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Mvc2DB] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Mvc2DB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Mvc2DB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Mvc2DB] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Mvc2DB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Mvc2DB] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Mvc2DB] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Mvc2DB] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Mvc2DB] SET RECOVERY FULL 
GO
ALTER DATABASE [Mvc2DB] SET  MULTI_USER 
GO
ALTER DATABASE [Mvc2DB] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Mvc2DB] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Mvc2DB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Mvc2DB] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Mvc2DB] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'Mvc2DB', N'ON'
GO
ALTER DATABASE [Mvc2DB] SET QUERY_STORE = OFF
GO
USE [Mvc2DB]
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [Mvc2DB]
GO
/****** Object:  Table [dbo].[Registration2]    Script Date: 9/29/2023 12:31:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Registration2](
	[username] [int] NOT NULL,
	[password] [int] NOT NULL,
	[lastname] [nvarchar](50) NOT NULL,
	[isAdmin] [bit] NOT NULL,
 CONSTRAINT [PK_Registration2] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
USE [master]
GO
ALTER DATABASE [Mvc2DB] SET  READ_WRITE 
GO
