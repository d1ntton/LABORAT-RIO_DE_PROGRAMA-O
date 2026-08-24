/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */

public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        // =========================
        // CADASTRO DE LIVROS
        // =========================

        Livro livro1 = new Livro(
            "978-85-00001",
            "Java para Iniciantes",
            "Autor A"
        );

        Livro livro2 = new Livro(
            "978-85-00002",
            "Programação Orientada a Objetos",
            "Autor B"
        );

        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);

        // =========================
        // CADASTRO DE MEMBROS
        // =========================

        Membro membro1 = new Membro(
            1,
            "João",
            "joao@email.com",
            "MAT001"
        );

        Membro membro2 = new Membro(
            2,
            "Maria",
            "maria@email.com",
            "MAT002"
        );

        biblioteca.cadastrarMembro(membro1);
        biblioteca.cadastrarMembro(membro2);

        // =========================
        // LISTAGEM
        // =========================

        biblioteca.listarLivros();
        biblioteca.listarMembros();

        // =========================
        // EMPRÉSTIMO
        // =========================

        try {

            biblioteca.realizarEmprestimo(
                "978-85-00001",
                1
            );

        } catch (LivroNaoEncontradoException |
                 LivroIndisponivelException e) {

            System.out.println(
                "Erro: " + e.getMessage()
            );
        }

        biblioteca.listarEmprestimos();

        // =========================
        // TENTATIVA DE EMPRESTAR
        // O MESMO LIVRO NOVAMENTE
        // =========================

        try {

            biblioteca.realizarEmprestimo(
                "978-85-00001",
                2
            );

        } catch (LivroNaoEncontradoException |
                 LivroIndisponivelException e) {

            System.out.println(
                "Erro: " + e.getMessage()
            );
        }

        // =========================
        // ENCERRAMENTO
        // =========================

        try {

            biblioteca.encerrarEmprestimo(
                "978-85-00001"
            );

        } catch (EmprestimoNaoEncontradoException e) {

            System.out.println(
                "Erro: " + e.getMessage()
            );
        }

        biblioteca.listarEmprestimos();

        // =========================
        // TESTE DE POLIMORFISMO
        // =========================

        System.out.println("\n===== POLIMORFISMO =====");

        Usuario usuario1 = membro1;

        Usuario usuario2 = new Funcionario(
            10,
            "Carlos",
            "carlos@biblioteca.com",
            "Bibliotecário"
        );

        usuario1.exibirDados();
        usuario2.exibirDados();

        // =========================
        // LISTAGEM GERAL
        // =========================

        System.out.println("\n===== SISTEMA COMPLETO =====");

        biblioteca.listarDados();
    }
}
