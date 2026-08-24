/*
package model;

/**
 * Representa um livro cadastrado na biblioteca.
 */
public class Livro {

    private String isbn;
    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn +
               " | Título: " + titulo +
               " | Autor: " + autor +
               " | Disponível: " +
               (disponivel ? "Sim" : "Não");
    }
}
