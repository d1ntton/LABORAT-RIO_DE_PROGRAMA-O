

/**
 * Exceção lançada quando um livro não é encontrado.
 */
public class LivroNaoEncontradoException extends Exception {

    public LivroNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
