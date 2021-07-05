CREATE TABLE IF NOT EXISTS Translated_data {

    uuid    CHAR(36) NOT NULL,
    lang    CHAR(2) DEFAULT EN NOT NULL,
    PRIMARY KEY (uuid),

    };