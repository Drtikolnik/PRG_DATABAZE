CREATE DATABASE hra2;

USE hra2;

CREATE TABLE Hrac (
    id_hrac INT AUTO_INCREMENT PRIMARY KEY,
    jmeno VARCHAR(255),
    level INT,
    zlato INT
);

CREATE TABLE Postava (
    id_postava INT AUTO_INCREMENT PRIMARY KEY,
    id_hrac INT,
    jmeno VARCHAR(255),
    class VARCHAR(255),
    velikost_utoku INT,
    -- cena DECIMAL(10, 2),
    -- datum DATE,
    FOREIGN KEY (id_hrac) REFERENCES Hrac(id_hrac) ON DELETE CASCADE
);

CREATE TABLE Predmet (
    id_predmet INT AUTO_INCREMENT PRIMARY KEY,
    id_hrac INT,
    nazev VARCHAR(255),
    typ VARCHAR(255),
    price INT,
    FOREIGN KEY (id_hrac) REFERENCES Hrac(id_hrac) ON DELETE CASCADE
);

CREATE TABLE Mise (
    id_mise INT AUTO_INCREMENT PRIMARY KEY,
    id_hrac INT,
    nazev VARCHAR(255),
    obtiznost VARCHAR(255),
    odmena INT,
    splneno BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (id_hrac) REFERENCES Hrac(id_hrac) ON DELETE CASCADE
);

-- Vložení dat do tabulek
-- INSERT INTO zakaznici (jmeno, email) VALUES
-- ('Petr Novák', 'petr@novak.cz'),
-- ('Jana Svobodová', 'jana@svobodova.cz');
--
-- INSERT INTO objednavky (zakaznik_id, produkt, cena, datum) VALUES
-- (1, 'Notebook', 15000.00, '2024-11-10'),
-- (1, 'Mobilní telefon', 7000.00, '2024-11-15'),
-- (1, 'Notebook', 18000.00, '2026-11-10'),
-- (2, 'Monitor', 5000.00, '2024-11-12');

INSERT INTO hrac (jmeno, level, zlato) VALUES
(jmenoZadane, levelZadany, zlatoZadane);

