

import java.time.LocalDate;

/**
 * Representa um empréstimo de um livro para um membro.
 */
public class Emprestimo {

    private Livro livro;
    private Membro membro;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private boolean ativo;

    public Emprestimo(Livro livro, Membro membro) {
        this.livro = livro;
        this.membro = membro;
        this.dataInicio = LocalDate.now();
        this.ativo = true;
    }

    public Livro getLivro() {
        return livro;
    }

    public Membro getMembro() {
        return membro;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public boolean isAtivo() {
        return ativo;
    }

    /**
     * Encerra o empréstimo e devolve o livro.
     */
    public void encerrar() {
        this.dataFim = LocalDate.now();
        this.ativo = false;
        livro.setDisponivel(true);
    }

    @Override
    public String toString() {
        return "Livro: " + livro.getTitulo() +
               " | Membro: " + membro.getNome() +
               " | Início: " + dataInicio +
               " | Fim: " + dataFim +
               " | Ativo: " + (ativo ? "Sim" : "Não");
    }
}
