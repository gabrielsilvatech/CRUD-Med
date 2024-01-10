package exercicio2.med.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Endereco {

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.cep = dados.cep();
    }

    public void atualizarEndereco(DadosEndereco dadosEndereco) {

        if (dadosEndereco.logradouro() != null) {
            this.logradouro = dadosEndereco.logradouro();
        }

        if (dadosEndereco.numero() != null) {
            this.numero = dadosEndereco.numero();
        }

        if (dadosEndereco.complemento() != null) {
            this.complemento = dadosEndereco.complemento();
        }

        if (dadosEndereco.bairro() != null) {
            this.bairro = dadosEndereco.bairro();
        }

        if (dadosEndereco.cidade() != null) {
            this.cidade = dadosEndereco.cidade();
        }

        if (dadosEndereco.uf() != null) {
            this.uf = dadosEndereco.uf();
        }

        if (dadosEndereco.cep() != null) {
            this.cep = dadosEndereco.cep();
        }
    }
}
