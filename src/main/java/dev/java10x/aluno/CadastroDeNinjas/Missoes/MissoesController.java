package dev.java10x.aluno.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    @GetMapping("/show")
    public String abaMissoes() {
        return "Essa é a aba de missões";
    }

    @PostMapping("/criar-missao")
    public String criarMissao() { return "missao criada com sucesso!"; }

    @GetMapping("/mostrar-missao_id")
    public String mostrarMissao() { return "mostrando missao"; }

    @PutMapping("/atualizar-missao_id")
    public String atualizarMissao() { return "missao atualizada com sucesso!"; }

    @DeleteMapping("/deleter-missao_id")
    public String deletarMissao() { return "missao deletada com sucesso"; }



}
