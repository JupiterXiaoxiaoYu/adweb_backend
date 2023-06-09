DROP TABLE IF EXISTS ShopItem;
DROP TABLE IF EXISTS CurationItem;
DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Nft;


CREATE TABLE IF NOT EXISTS User (
    userID INT(11) NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(100) DEFAULT NULL,
    phone VARCHAR(20) DEFAULT NULL,
    PRIMARY KEY (UserID)
    );
INSERT INTO User (userID, username, password, email, phone) VALUES
                                                                (1, 'kaiyudai', '12345678', 'kydai@fudan.edu.cn', '13666666666'),
                                                                (2, 'fengshuangli', '12345678', '13302010002@fudan.edu.cn', '13888888888'),
                                                                (3, 'zhongyitong', '12345678', NULL, NULL);

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


