/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
public class Principal {
     public static final String ANSI_VERDE = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_VEMELHOR = "\u001B[31m";
   public static final String ANSI_RESETs = "\u001B[0m";
    
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        LivroFisico livro1 = new LivroFisico(
                "Dom Casmurro",
                "Machado de Assis",
                256,
                0.45
        );

        LivroFisico livro2 = new LivroFisico(
                "O Cortico",
                "Aluísio Azevedo",
                304,
                0.52
        );

        Ebook ebook1 = new Ebook(
                "1984",
                "George Orwell",
                328,
                2.5
        );

        Ebook ebook2 = new Ebook(
                "O Hobbit",
                "J.R.R. Tolkien",
                310,
                3.2
        );

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.adicionarLivro(ebook1);
        biblioteca.adicionarLivro(ebook2);

        System.out.println(ANSI_VERDE+"=== LISTA DE LIVROS ==="+ANSI_RESET);
        biblioteca.listarLivros();

        System.out.println(ANSI_VEMELHOR+"\n=== BUSCA POR TÍTULO ==="+ANSI_RESETs);

        Livro encontrado = biblioteca.buscarLivroPorTitulo("1984");

        if (encontrado != null) {
            encontrado.descricao();
        } else {
            System.out.println("Livro nao encontrado.");
        }
    }
}