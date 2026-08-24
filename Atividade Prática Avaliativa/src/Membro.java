
/**
 * Representa um membro da biblioteca.
 */
public class Membro extends Usuario {

    private String matricula;

    public Membro(int id, String nome, String email, String matricula) {
        super(id, nome, email);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public void exibirDados() {
        System.out.println(
            "Membro: " + getNome() +
            " | E-mail: " + getEmail() +
            " | Matrícula: " + matricula
        );
    }
}
