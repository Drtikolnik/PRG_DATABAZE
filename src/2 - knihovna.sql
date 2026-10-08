CREATE DATABASE knihovna;

USE knihovna;

CREATE TABLE knihy (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nazev VARCHAR(255),
    autor VARCHAR(255),
    rok_vydani INT
);

INSERT INTO knihy (nazev, autor, rok_vydani) VALUES
('1984', 'George Orwell', 1949),
('Kdo chytá v žitě', 'J.D. Salinger', 1951),
('Pán prstenů', 'J.R.R. Tolkien', 1954),
('Zločin a trest', 'Fjodor Michajlovič Dostojevskij', 1866);