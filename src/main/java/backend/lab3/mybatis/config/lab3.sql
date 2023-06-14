DROP TABLE IF EXISTS ShopItem;
DROP TABLE IF EXISTS CurationItem;
DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Nft;
DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS trade;

CREATE TABLE IF NOT EXISTS User (
    userID INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    image TEXT,
    birthday VARCHAR(50) ,
    gender INT(1) NOT NULL
    );
INSERT INTO User (userID, name, password, image, birthday,gender) VALUES

                                                                (1, 'kaiyudai', '12345678', 'kydai@fudan.edu.cn', '2001-01-01','3');


CREATE TABLE IF NOT EXISTS Nft (
    nftID INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    image VARCHAR(255),
    owner VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL
);

INSERT INTO Nft (nftID, name, description, image, owner, status) VALUES
                                                                (1, 'kaiyudai', '12345678', 'kydai@fudan.edu.cn', '13666666666', "unlisted"),
                                                                (2, 'fengshuangli', '12345678', '13302010002@fudan.edu.cn', '13888888888', "unlisted");
						


CREATE TABLE IF NOT EXISTS ShopItem (
    ShopItemID INT(11) NOT NULL AUTO_INCREMENT,
    userID INT(11) NOT NULL,
    nftID INT(11) NOT NULL,
    price INT(11) NOT NULL,
    PRIMARY KEY (ShopItemID),
    FOREIGN KEY (userID) REFERENCES User(userID),
    FOREIGN KEY (nftID) REFERENCES Nft(nftID)
);




CREATE TABLE IF NOT EXISTS CurationItem (
    CurationItemID INT(11) NOT NULL AUTO_INCREMENT,
    userID INT(11) NOT NULL,
    nftID INT(11) NOT NULL,
    PRIMARY KEY (CurationItemID),
    FOREIGN KEY (userID) REFERENCES User(userID),
    FOREIGN KEY (nftID) REFERENCES Nft(nftID)
);


CREATE TABLE IF NOT EXISTS account (
    accountID INT PRIMARY KEY AUTO_INCREMENT,
    userID INT(11) NOT NULL,
    funds float NOT NULL

    );
INSERT INTO account (accountID, userID, funds) VALUES

                                                                  (1, 1, 100),
                                                                  (2, 2, 1000);

CREATE TABLE IF NOT EXISTS trade (
    tradeID INT PRIMARY KEY AUTO_INCREMENT,
    userinID INT(11) ,
    useroutID INT(11) ,
    funds float ,
    time VARCHAR(255)


    );
INSERT INTO trade (tradeID, userinID, useroutID, funds, time) VALUES

                                                                  (1, 1, 2, 100,'2023-6-14,8:00 buy commodity1'),
                                                                  (2, 1, 2, 100, '2023-6-14,8:00 buy commodity1');


