package exercicio2.med.paciente;

import exercicio2.med.endereco.DadosEndereco;

public record DadosAtualizacaoPaciente(

        Long id,
        String nome,
        String email,
        String telefone,
        DadosEndereco dadosEndereco
) {
}
