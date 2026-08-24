

/**
 * Representa um funcionário da biblioteca.
 */
public class Funcionario extends Usuario {

    private String cargo;

    public Funcionario(int id, String nome, String email, String cargo) {
        super(id, nome, email);
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public void exibirDados() {
        System.out.println(
            "Funcionário: " + getNome() +
            " | E-mail: " + getEmail() +
            " | Cargo: " + cargo
        );
    }
}
