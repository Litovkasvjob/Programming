package ua.litovka.lection8_JDBC.simple;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Movie {

    private  int id;
    private  String title;
    private String description;
    private int duration;

    public Movie() {
    }

    public Movie(String title, String description, int duration) {
        this.title = title;
        this.description = description;
        this.duration = duration;
    }
}
