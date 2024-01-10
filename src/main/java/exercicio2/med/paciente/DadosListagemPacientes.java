package exercicio2.med.paciente;

public record DadosListagemPacientes(
        Long id,
        String nome,
        String email,
        String cpf,
        Boolean ativo
) {
    public DadosListagemPacientes(Paciente dados) {
        this(dados.getId(), dados.getNome(), dados.getEmail(), dados.getCpf(), dados.getAtivo());
    }
}
