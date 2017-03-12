package ua.litovka.lection8_JDBC.simple;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SergLion on 12.02.2017.
 */
public class Main {
    public static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS movie " +
            "(id int AUTO_INCREMENT primary key, title varchar(256), " +
            "description varchar (256), duration int)";
    public static final String SQL_INSERT = "INSERT INTO mydbtest.movie" +
            " (title, description, duration) VALUES (?,?,?)";
    private static String SQL_SELECT_ALL = "SELECT * FROM mydbtest.movie";


    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydbtest?useSSL=false";
        String user = "root";
        String password = "q620980";

        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Dracula", "Horror", 123));
        movieList.add(new Movie("Matrix", "Fantasy", 109));
        movieList.add(new Movie("Titanic", "Drama", 95));

        List<Movie> moviesFromDb = null;

        try(Connection connection = DriverManager.getConnection(url, user,  password);
            Statement statement = connection.createStatement()){

            statement.execute(SQL_CREATE_TABLE);
            //saveMovies(movieList,connection);
            moviesFromDb = readAllMovies(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        movieList.forEach(System.out::println);
        System.out.println("___________________");
        moviesFromDb.forEach(System.out::println);
    }

    public static List<Movie> readAllMovies(Connection connection) {
        List<Movie> movieList = new ArrayList<>();
        try (Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(SQL_SELECT_ALL)){
            Movie movie;
            while (rs.next()) {
                movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDescription(rs.getString("description"));
                movie.setDuration(rs.getInt("duration"));
                movieList.add(movie);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieList;
    }

    public static void saveMovies(List<Movie> movieList, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT,
                Statement.RETURN_GENERATED_KEYS);){
            for (Movie movie : movieList) {
                preparedStatement.setString(1, movie.getTitle());
                preparedStatement.setString(2, movie.getDescription());
                preparedStatement.setInt(3, movie.getDuration());
                preparedStatement.executeUpdate();
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    movie.setId(rs.getInt(1));
                }
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
