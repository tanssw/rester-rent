CREATE TABLE THEME (
	ID MEDIUMINT NOT NULL AUTO_INCREMENT primary key,
    TNAME VARCHAR(20),
    IMAGE TEXT(200),
    DETAILS TEXT(200)
);
CREATE TABLE ACCESSORY (
	ID MEDIUMINT NOT NULL AUTO_INCREMENT primary key,
    ANAME VARCHAR(20),
    QUANTITY MEDIUMINT
);


CREATE TABLE FOOD (
	ID MEDIUMINT NOT NULL AUTO_INCREMENT primary key,
    FNAME VARCHAR(20),
    CAPACITY MEDIUMINT,
    SIZE VARCHAR(15)
);
CREATE TABLE MENU (
	ID MEDIUMINT NOT NULL AUTO_INCREMENT primary key,
    MNAME VARCHAR(20),
    QUANTITY MEDIUMINT
);


CREATE TABLE THEME_ACCESSORY (
	THEME_ID MEDIUMINT,
    ACCESSORY_ID MEDIUMINT,
    PRIMARY KEY (THEME_ID, ACCESSORY_ID),
    FOREIGN KEY(THEME_ID) REFERENCES THEME(ID),
    FOREIGN KEY(ACCESSORY_ID) REFERENCES ACCESSORY(ID)
    ON DELETE CASCADE
);
CREATE TABLE FOOD_MENU (
	FOOD_ID MEDIUMINT,
    MENU_ID MEDIUMINT,
    PRIMARY KEY (FOOD_ID, MENU_ID),
    FOREIGN KEY(FOOD_ID) REFERENCES FOOD(ID),
    FOREIGN KEY(MENU_ID) REFERENCES MENU(ID)
    ON DELETE CASCADE
);