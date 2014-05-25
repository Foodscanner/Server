SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE TABLE IF NOT EXISTS ARTICLE (
  ID bigint(20) NOT NULL,
  `Name` varchar(255) NOT NULL,
  Description text NOT NULL,
  ImageURL varchar(255) NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO ARTICLE (ID, Name, Description, ImageURL) VALUES
(3045320092066, 'Bonne-Maman Kirsch-Konfitüre', 'Yummy marmelade', 'http://upload.wikimedia.org/wikipedia/commons/9/92/Marmelade.jpg');

CREATE TABLE IF NOT EXISTS  ARTICLE_FLAGS (
  FK_ArticleID bigint(20) NOT NULL,
  FK_FlagID int(11) NOT NULL,
  PRIMARY KEY (FK_ArticleID,FK_FlagID)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO ARTICLE_FLAGS (FK_ArticleID, FK_FlagID) VALUES
(3045320092066, 7),
(3045320092066, 8);

CREATE TABLE IF NOT EXISTS ARTICLE_INGREDIENTS (
  FK_ArticleID bigint(20) NOT NULL,
  FK_IngredientID int(11) NOT NULL,
  PRIMARY KEY (FK_ArticleID,FK_IngredientID)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO ARTICLE_INGREDIENTS (FK_ArticleID, FK_IngredientID) VALUES
(3045320092066, 1),
(3045320092066, 2);

CREATE TABLE IF NOT EXISTS  FLAG (
  ID int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  Description text NOT NULL,
  LimitToProduct tinyint(1) NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;

INSERT INTO FLAG (ID, Name, Description, LimitToProduct) VALUES
(1, 'Lactose', 'Contains Lactose', 0),
(2, 'Gluten', 'Contains Gluten', 0),
(3, 'Sugar', 'Contains a high amount of sugar', 0),
(4, 'Strawberries', 'Contains Strawberries', 0),
(5, 'Strawberries', 'Contains Strawberries', 0),
(6, 'Sugar', 'Contains Sugar', 0),
(7, 'Phenylalanine', 'Contains a source of phenylalanine', 1);

CREATE TABLE IF NOT EXISTS INGREDIENT (
  ID int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8;

INSERT INTO INGREDIENT (ID, Name) VALUES
(1, 'Sugar'),
(2, 'Strawberries'),
(3, 'Milk'),
(4, 'Wheat flour'),
(5, 'Citric acid'),
(6, 'Aspartame'),
(7, 'Peppermint oil'),
(8, 'Sorbite'),
(9, 'High-Fructose Corn Syrup');

CREATE TABLE IF NOT EXISTS INGREDIENT_FLAGS (
  FK_IngredientID int(11) NOT NULL,
  FK_FlagID int(11) NOT NULL,
  PRIMARY KEY (FK_IngredientID,FK_FlagID)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

INSERT INTO INGREDIENT_FLAGS (FK_IngredientID, FK_FlagID) VALUES
(1, 7),
(2, 8);
