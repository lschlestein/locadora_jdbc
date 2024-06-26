package Jdbc.Model;

public class Movie {
    private int cod_filme;
    private String titulo_original;
    private String titulo;
    private int quantidade;
    private Category category;
    private Genre genre;

    public Movie(int cod_filme, String titulo_original, String titulo, int quantidade, Category category, Genre genre) {
        this.cod_filme = cod_filme;
        this.titulo_original = titulo_original;
        this.titulo = titulo;
        this.quantidade = quantidade;
        this.category = category;
        this.genre = genre;
    }

    public Movie(String titulo_original, String titulo, int quantidade, Category category, Genre genre) {
        this.genre = genre;
        this.category = category;
        this.quantidade = quantidade;
        this.titulo = titulo;
        this.titulo_original = titulo_original;
    }

    public Movie() {
    }

    public int getCod_filme() {
        return cod_filme;
    }

    public void setCod_filme(int cod_filme) {
        this.cod_filme = cod_filme;
    }

    public String getTitulo_original() {
        return titulo_original;
    }

    public void setTitulo_original(String titulo_original) {
        this.titulo_original = titulo_original;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "cod_filme=" + cod_filme +
                ", titulo_original='" + titulo_original + '\'' +
                ", titulo='" + titulo + '\'' +
                ", quantidade=" + quantidade +
                ", category=" + category +
                ", genre=" + genre +
                "}\n";
    }
}
