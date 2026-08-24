

/**
 * Exceção lançada quando um livro já está emprestado.
 */
public class LivroIndisponivelException extends Exception {

    public LivroIndisponivelException(String mensagem) {
        super(mensagem);
    }
}
