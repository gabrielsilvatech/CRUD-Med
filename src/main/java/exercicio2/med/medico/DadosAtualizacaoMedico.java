package exercicio2.med.medico;

import exercicio2.med.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(

        Long id,
        String nome,
        String email,
        String telefone,
        DadosEndereco endereco
) {
}
