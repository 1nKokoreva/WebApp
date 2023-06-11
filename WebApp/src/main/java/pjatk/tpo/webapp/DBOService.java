package pjatk.tpo.webapp;

import java.sql.*;

public class DBOService {

        Connection conn;
        public void connectDbo()
        {
            String url = "jdbc:mysql://localhost:3306/ksiazka";
            String username = "root";
            String password = "your password";

            try
            {
                conn = DriverManager.getConnection(url, username, password);
            } catch (SQLException e)
            {
                e.printStackTrace();
            }

        }
        public void dissDbo()
        {
            try
            {
                conn.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

    public String getReview(String newId) {
        connectDbo();
        StringBuilder sqlQuery = new StringBuilder("SELECT r.id_ksiazka, r.ocena, c.imie_czytelnika, r.tresc_recenzji FROM Czytelnicy c JOIN Recenzje r ON c.id_czytelnika = r.id_czytelnika WHERE r.id_ksiazka = " + newId);

        Statement statement;
        try {
            if (newId == null) {
                return "no data"; //zwraca, jesli nie ma daty i id
            }
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery.toString());

            StringBuilder result = new StringBuilder();
            while (resultSet.next()) {
                String idBook = resultSet.getString("id_ksiazka");
                String nameReader = resultSet.getString("imie_czytelnika");
                String assessment = resultSet.getString("ocena");
                String description = resultSet.getString("tresc_recenzji");

                result.append("ID BOOK: ").append(idBook)
                        .append(",<br>      ASSESSMENT: ").append(assessment)
                        .append(",<br>     NAME READER: ").append(nameReader)
                        .append(",<br>      DESCRIPTION: ").append(description).append("<br><br>");
            }

            dissDbo();
            if (result.length() == 0) {
                return "the review not found";
            } else {
                return result.toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "the review not found";
    }

    public String getBD() {
        connectDbo();
        StringBuilder sqlQuery = new StringBuilder("SELECT * FROM Ksiazka");
        Statement statement;
        try {
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery.toString());

            StringBuilder result = new StringBuilder();
            while (resultSet.next()) {
                String id = resultSet.getString("id_ksiazka");
                String tytul = resultSet.getString("tytul_ksiazki");
                String data = resultSet.getString("data_publikacji");
                String iaAutor = resultSet.getString("id_autora");
                String genre = resultSet.getString("id_gatunku");

                result.append("ID: ").append(id)
                        .append(",   TITLE: ").append(tytul)
                        .append(",    DATE OF PUBLICATION: ").append(data)
                        .append(",    ID AUTHOR: ").append(iaAutor)
                        .append(",    ID GENRE: ").append(genre).append("<br>");
            }

            dissDbo();
            return result.toString();
        } catch (SQLException e) {
            e.printStackTrace();
            return "***Error retrieving data from the database: " + e.getMessage();
        }
    }

    public String getBooks(String newId, String publicationDate) {
        connectDbo();
        StringBuilder sqlQuery = new StringBuilder("SELECT k.id_ksiazka, k.tytul_ksiazki, k.data_publikacji, a.imie_autora, k.id_gatunku FROM Ksiazka k JOIN Autor a ON k.id_autora= a.id_autora WHERE ");

        boolean isIdSet = (newId != null && !newId.isEmpty());
        boolean isDateSet = (publicationDate != null && !publicationDate.isEmpty());

        if (isIdSet) {
            sqlQuery.append("id_ksiazka = '").append(newId).append("'");
        }

        if (isIdSet && isDateSet) {
            sqlQuery.append(" OR ");
        }

        if (isDateSet) {
            sqlQuery.append("data_publikacji = '").append(publicationDate).append("'");
        }

        Statement statement;
        try {
            if (!isIdSet && !isDateSet) {
                return "no data"; //zwraca, jesli nie ma daty i id
            }

            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery.toString());

            StringBuilder result = new StringBuilder();
            while (resultSet.next()) {
                String id = resultSet.getString("id_ksiazka");
                String tytul = resultSet.getString("tytul_ksiazki");
                String data = resultSet.getString("data_publikacji");
                String imie_autora = resultSet.getString("imie_autora");
                String genre = resultSet.getString("id_gatunku");

                result.append("ID: ").append(id).append(",<br>   TITLE: ").append(tytul)
                        .append(",<br>     DATE OF PUBLICATION: ").append(data)
                        .append(",<br>      NAME AUTHOR: ").append(imie_autora)
                        .append(",<br>      ID GENRE: ").append(genre).append("<br><br>");
            }

            dissDbo();
            if (result.length() == 0) {
                return "***the book was not found";
            } else {
                return result.toString();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "***the book was not found";
    }

    public String addBook(String id, String title, String genreId){
        connectDbo();
        StringBuilder sqlQuery = new StringBuilder("INSERT INTO Ksiazka (id_ksiazka, tytul_ksiazki, id_gatunku) VALUES ('" + id + "', '" + title + "', '" + genreId + "');");        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sqlQuery.toString());
            return "Book added to database";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

}

