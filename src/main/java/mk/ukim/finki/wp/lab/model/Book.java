package mk.ukim.finki.wp.lab.model;

import lombok.*;

@Data
@Getter
@Setter
public class Book {
    private String title;
    private String genre;
    private double averageRating;
    private Long id;
    private Author author;
    private int likes;


    public Book() {
    }

    public Long getId() {
        return id;
    }

    // Constructor with all fields
    public Book(String title, String genre, double averageRating,Author author ,int likes) {
        this.title = title;
        this.genre = genre;
        this.averageRating = averageRating;
        this.id= (long) (Math.random()*1000);
        this.author=author;
        this.likes=0;
    }

    // Getters & Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void incrementLikes() {
        this.likes++;
    }
}
