import java.sql.*;
import java.util.*;

void main() {
    Scanner sc = new Scanner(System.in);

    String url = "jdbc:mysql://localhost/obchod"; // URL databáze: server, port, název DB
    String username = "root"; // Uživatelské jméno
    String password = ""; // Heslo k databázi

    System.out.println("zadejte email zakaznika");
    String emailVybrany = sc.nextLine();



// Připojení k databázi
    try (Connection conn = DriverManager.getConnection(url, username, password)) {
        System.out.println("Připojení k databázi bylo úspěšné!");
// Výpis dat z tabulky
        String idZakaznikaSELECT = "SELECT id FROM zakaznici WHERE email = ?";
        String obednavkaSELECT = "SELECT * FROM objednavky WHERE zakaznik_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(idZakaznikaSELECT)){
             stmt.setString(1, emailVybrany);

             try (ResultSet rs = stmt.executeQuery()){
                 System.out.println("Seznam objednávek:");
                 if (rs.next()){
                     int idZakaznika = rs.getInt("id");

                     try (PreparedStatement stmt2 = conn.prepareStatement(obednavkaSELECT)) {
                         stmt2.setInt(1, idZakaznika);

                         try (ResultSet rs2 = stmt2.executeQuery()) {
                             while (rs2.next()){
                                 String produkt = rs2.getString("produkt");
                                 String cena = rs2.getString("cena");
                                 String datum = rs2.getString("datum");
                                 System.out.println(produkt + " | " + cena + " | " + datum);
                             }

                         }


                     }
                 }



            }




        } catch (SQLException e) {
            System.err.println("Problém s SQL.");
        }
    } catch (SQLException e) {
        System.err.println("Problém s připojením.");
    }


}
