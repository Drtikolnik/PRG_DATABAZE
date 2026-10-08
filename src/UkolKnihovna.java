import java.sql.*;

void main() {

    String url = "jdbc:mysql://localhost/knihovna"; // URL databáze: server, port, název DB
    String username = "root"; // Uživatelské jméno
    String password = ""; // Heslo k databázi
// Připojení k databázi
    try (Connection conn = DriverManager.getConnection(url, username, password)) {
        System.out.println("Připojení k databázi bylo úspěšné!");
// Výpis dat z tabulky
        String dotazSELECT = "SELECT * FROM knihy ORDER BY rok_vydani";
        try (PreparedStatement stmt = conn.prepareStatement(dotazSELECT);
             ResultSet rs = stmt.executeQuery()) {
            System.out.println("Seznam knih:");
            while (rs.next()) {
                String nazev = rs.getString("nazev");
                String autor = rs.getString("autor");
                int rokVydani = rs.getInt("rok_vydani");
                System.out.println(nazev + " | " + autor + " | " + rokVydani);
            }
        } catch (SQLException e) {
            System.err.println("Problém s SQL.");
        }
    } catch (SQLException e) {
        System.err.println("Problém s připojením.");
    }


}
