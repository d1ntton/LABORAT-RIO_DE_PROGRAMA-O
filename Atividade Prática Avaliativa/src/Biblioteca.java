




import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelo gerenciamento da biblioteca.
 */
public class Biblioteca implements Listavel {

    private List<Livro> livros;
    private List<Membro> membros;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        livros = new ArrayList<>();
        membros = new ArrayList<>();
        emprestimos = new ArrayList<>();
    }

    // =========================
    // GERENCIAMENTO DE LIVROS
    // =========================

    /**
     * Adiciona um novo livro.
     */
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    /**
     * Edita os dados de um livro.
     */
    public void editarLivro(
            String isbn,
            String novoTitulo,
            String novoAutor)
            throws LivroNaoEncontradoException {

        for (Livro livro : livros) {

            if (livro.getIsbn().equals(isbn)) {
                livro.setTitulo(novoTitulo);
                livro.setAutor(novoAutor);

                System.out.println("Livro atualizado com sucesso!");
                return;
            }
        }

        throw new LivroNaoEncontradoException(
            "Livro não encontrado."
        );
    }

    /**
     * Remove um livro pelo ISBN.
     */
    public void removerLivro(String isbn)
            throws LivroNaoEncontradoException {

        for (Livro livro : livros) {

            if (livro.getIsbn().equals(isbn)) {
                livros.remove(livro);

                System.out.println("Livro removido com sucesso!");
                return;
            }
        }

        throw new LivroNaoEncontradoException(
            "Livro não encontrado."
        );
    }

    /**
     * Lista todos os livros.
     */
    public void listarLivros() {

        System.out.println("\n===== LIVROS =====");

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    // =========================
    // GERENCIAMENTO DE MEMBROS
    // =========================

    /**
     * Cadastra um novo membro.
     */
    public void cadastrarMembro(Membro membro) {
        membros.add(membro);
        System.out.println("Membro cadastrado com sucesso!");
    }

    /**
     * Edita um membro.
     */
    public void editarMembro(
            int id,
            String novoNome,
            String novoEmail) {

        for (Membro membro : membros) {

            if (membro.getId() == id) {

                membro.setNome(novoNome);
                membro.setEmail(novoEmail);

                System.out.println("Membro atualizado com sucesso!");
                return;
            }
        }

        System.out.println("Membro não encontrado.");
    }

    /**
     * Lista todos os membros.
     */
    public void listarMembros() {

        System.out.println("\n===== MEMBROS =====");

        if (membros.isEmpty()) {
            System.out.println("Nenhum membro cadastrado.");
            return;
        }

        for (Membro membro : membros) {
            membro.exibirDados();
        }
    }

    // =========================
    // GERENCIAMENTO DE EMPRÉSTIMOS
    // =========================

    /**
     * Realiza um empréstimo.
     */
    public void realizarEmprestimo(
            String isbn,
            int idMembro)
            throws LivroNaoEncontradoException,
                   LivroIndisponivelException {

        Livro livroEncontrado = null;
        Membro membroEncontrado = null;

        for (Livro livro : livros) {

            if (livro.getIsbn().equals(isbn)) {
                livroEncontrado = livro;
                break;
            }
        }

        if (livroEncontrado == null) {
            throw new LivroNaoEncontradoException(
                "Livro não encontrado."
            );
        }

        if (!livroEncontrado.isDisponivel()) {
            throw new LivroIndisponivelException(
                "O livro já está emprestado."
            );
        }

        for (Membro membro : membros) {

            if (membro.getId() == idMembro) {
                membroEncontrado = membro;
                break;
            }
        }

        if (membroEncontrado == null) {
            throw new LivroNaoEncontradoException(
                "Membro não encontrado."
            );
        }

        Emprestimo emprestimo =
                new Emprestimo(livroEncontrado, membroEncontrado);

        livroEncontrado.setDisponivel(false);

        emprestimos.add(emprestimo);

        System.out.println("Empréstimo realizado com sucesso!");
    }

    /**
     * Encerra um empréstimo.
     */
    public void encerrarEmprestimo(String isbn)
            throws EmprestimoNaoEncontradoException {

        for (Emprestimo emprestimo : emprestimos) {

            if (emprestimo.getLivro()
                    .getIsbn()
                    .equals(isbn)
                    && emprestimo.isAtivo()) {

                emprestimo.encerrar();

                System.out.println(
                    "Empréstimo encerrado com sucesso!"
                );

                return;
            }
        }

        throw new EmprestimoNaoEncontradoException(
            "Empréstimo ativo não encontrado."
        );
    }

    /**
     * Lista todos os empréstimos.
     */
    public void listarEmprestimos() {

        System.out.println("\n===== EMPRÉSTIMOS =====");

        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
            return;
        }

        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }
    }

    /**
     * Implementação da interface Listavel.
     */
    @Override
    public void listarDados() {

        listarLivros();
        listarMembros();
        listarEmprestimos();
    }
}
