package exercicio2.med.medico;

public record DadosListagemMedicos(
        Long id,
        String nome,
        String crm,
        Especialidade especialidade,
        String email,
        String Telefone
) {
    public DadosListagemMedicos(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEspecialidade(), medico.getEmail(), medico.getTelefone());
    }
}
