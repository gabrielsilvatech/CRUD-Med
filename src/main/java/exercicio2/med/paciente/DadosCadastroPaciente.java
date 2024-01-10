package exercicio2.med.paciente;

import exercicio2.med.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroPaciente(

        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotBlank @Email
        String email,
        @NotBlank @Pattern(regexp = "\\d{6}")
        String cpf,
        @NotNull @Valid
        DadosEndereco endereco

) {
}
