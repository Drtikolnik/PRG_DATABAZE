import java.sql.*;
import java.util.*;

void main() {
    Scanner sc = new Scanner(System.in);

    String url = "jdbc:mysql://localhost/hackaton_hra"; // URL databáze: server, port, název DB
    String username = "root"; // Uživatelské jméno
    String password = ""; // Heslo k databázi

    System.out.print("Zadej jméno hráče: ");
    String jmenoZadane = sc.nextLine();

    System.out.print("Zadej level: ");
    int levelZadany = sc.nextInt();

    System.out.print("Zadej zlato: ");
    int zlatoZadane = sc.nextInt();

// Připojení k databázi
    try (Connection conn = DriverManager.getConnection(url, username, password)) {
        System.out.println("Připojení k databázi bylo úspěšné!");
// Výpis dat z tabulky
        String hracINSERT = "INSERT INTO Hrac (jmeno, level, zlato) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(hracINSERT)){
            stmt.setString(1, jmenoZadane);
            stmt.setInt(2, levelZadany);
            stmt.setInt(3, zlatoZadane);

            // executeUpdate() se používá pro INSERT, UPDATE a DELETE
            int radekPridano = stmt.executeUpdate();

            if (radekPridano > 0) {
                System.out.println("Hráč " + jmenoZadane + " byl úspěšně vytvořen!");
            }
        } catch (SQLException e) {
            System.err.println("Problém s SQL.");
        }










    } catch(
    SQLException e)

    {
        System.err.println("Problém s připojením.");
    }

}