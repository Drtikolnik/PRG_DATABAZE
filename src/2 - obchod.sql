CREATE DATABASE obchod;

USE obchod;

CREATE TABLE zakaznici (
    id INT AUTO_INCREMENT PRIMARY KEY,
    jmeno VARCHAR(255),
    email VARCHAR(255)
);

CREATE TABLE objednavky (
    id INT AUTO_INCREMENT PRIMARY KEY,
    zakaznik_id INT,
    produkt VARCHAR(255),
    cena DECIMAL(10, 2),
    datum DATE,
    FOREIGN KEY (zakaznik_id) REFERENCES zakaznici(id)
);

-- Vložení dat do tabulek
INSERT INTO zakaznici (jmeno, email) VALUES
('Petr Novák', 'petr@novak.cz'),
('Jana Svobodová', 'jana@svobodova.cz');

INSERT INTO objednavky (zakaznik_id, produkt, cena, datum) VALUES
(1, 'Notebook', 15000.00, '2024-11-10'),
(1, 'Mobilní telefon', 7000.00, '2024-11-15'),
(1, 'Notebook', 18000.00, '2026-11-10'),
(2, 'Monitor', 5000.00, '2024-11-12');