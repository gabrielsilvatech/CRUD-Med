package exercicio2.med.medico;

import exercicio2.med.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(

        @NotBlank
        String nome,
        @NotBlank @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotBlank
        String telefone,
        @NotBlank @Email
        String email,
        @NotNull
        Especialidade especialidade,
        @NotNull @Valid
        DadosEndereco endereco
) {
}
