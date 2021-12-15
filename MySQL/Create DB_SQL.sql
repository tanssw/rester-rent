CREATE TABLE THEME (
	ID MEDIUMINT NOT NULL AUTO_INCREMENT primary key,
    TNAME VARCHAR(50),
    PRICE MEDIUMINT,
    IMAGE TEXT(200),
    DETAILS TEXT(200)
);
CREATE TABLE ACCESSORY (
	ID MEDIUMINT NOT NULL AUTO_INCREMENT primary key,
    ANAME VARCHAR(50)
);

CREATE TABLE FOOD (
	ID MEDIUMINT NOT NULL AUTO_INCREMENT primary key,
    FNAME VARCHAR(50),
    CAPACITY MEDIUMINT,
    PRICE MEDIUMINT,
    SIZE VARCHAR(15),
    MENUS JSON
);

CREATE TABLE THEME_ACCESSORY (
	THEME_ID MEDIUMINT,
    ACCESSORY_ID MEDIUMINT,
    QUANTITY MEDIUMINT,
    PRIMARY KEY (THEME_ID, ACCESSORY_ID),
    FOREIGN KEY(THEME_ID) REFERENCES THEME(ID),
    FOREIGN KEY(ACCESSORY_ID) REFERENCES ACCESSORY(ID)
    ON DELETE CASCADE
);

