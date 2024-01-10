package exercicio2.med.controller;

import exercicio2.med.paciente.DadosAtualizacaoPaciente;
import exercicio2.med.paciente.DadosCadastroPaciente;
import exercicio2.med.paciente.DadosListagemPacientes;
import exercicio2.med.paciente.Paciente;
import exercicio2.med.repository.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrarPaciente(@RequestBody @Valid DadosCadastroPaciente dados) {
        pacienteRepository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPacientes> listarPacientes(Pageable pageable) {
       return pacienteRepository.findAllByAtivoTrue(pageable).map(DadosListagemPacientes::new);
    }

    @PutMapping
    @Transactional
    public void atualizarCadastro(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        var paciente = pacienteRepository.getReferenceById(dados.id());
        paciente.atualizarPaciente(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirPaciente(@PathVariable("id") Long id) {
        var paciente = pacienteRepository.getReferenceById(id);
        paciente.excluirPaciente(id);
    }

}
