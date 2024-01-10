package exercicio2.med.controller;

import exercicio2.med.medico.DadosAtualizacaoMedico;
import exercicio2.med.medico.DadosCadastroMedico;
import exercicio2.med.medico.DadosListagemMedicos;
import exercicio2.med.medico.Medico;
import exercicio2.med.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrarMedico(@RequestBody @Valid DadosCadastroMedico dados) {
        medicoRepository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedicos> listarMedicos(Pageable pageable) {
        return medicoRepository.findAllByAtivoTrue(pageable).map(DadosListagemMedicos::new);
    }

    @PutMapping
    @Transactional
    public void atualizarMedico(@RequestBody @Valid DadosAtualizacaoMedico dadosAtualizacaoMedico) {
        var medico = medicoRepository.getReferenceById(dadosAtualizacaoMedico.id());
        medico.atualizarMedico(dadosAtualizacaoMedico);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirMedico(@PathVariable("id") Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.excluirMedico(id);
    }
}
