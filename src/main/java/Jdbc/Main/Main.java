package Jdbc.Main;

import Jdbc.Dao.DaoAddress;
import Jdbc.Dao.DaoCategory;
import Jdbc.Dao.DaoGenre;
import Jdbc.Dao.DaoMovie;
import Jdbc.Model.Category;
import Jdbc.Model.Genre;
import Jdbc.Model.Movie;

public class Main {
    public static void main(String[] args) {

        DaoAddress daoAddress = new DaoAddress();
        DaoCategory daoCategory = new DaoCategory();
        DaoGenre daoGenre = new DaoGenre();
        DaoMovie daoMovie = new DaoMovie();

        //daoAddress.insertAddress(new Address(0,"Dos Abacateiros","Rua","Ap","Santa Maria","RS","97100000","230","Pinheiro Machado"));
        System.out.println(daoAddress.getAllAddress());
        //daoCategory.insertCategory(new Category(0,"DOCUMENTÁRIO",15));
        System.out.println(daoCategory.getAllCategories());
        //daoGenre.insertGenre(new Genre(0,"CRIME"));
        System.out.println(daoGenre.getAllGenres());
        daoMovie.insertMovie(new Movie("Matrix 3", "Matrix 3", 2, new Category(1), new Genre(2)));
        System.out.println(daoMovie.getAllMovies());
    }
}