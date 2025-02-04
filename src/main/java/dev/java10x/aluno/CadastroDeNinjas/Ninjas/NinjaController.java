package dev.java10x.aluno.CadastroDeNinjas.Ninjas;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;
    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boas-vindas")
    public String boasVindas() {
        return "Essa é a mensagem de boas vindas";
    }

    @PostMapping("/criar-ninja")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja " + novoNinja.getNome() + " criado com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinja(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarNinjaPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok(ninja);
        } else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja inexistente.");
    }

    @PutMapping("/alterar-ninja/{id}")
    public ResponseEntity<?> alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        NinjaDTO ninja = ninjaService.alterarNinja(id, ninjaAtualizado);
        if (ninjaAtualizado != null) {
            return ResponseEntity.ok(ninja);
        } else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ninja de ID "+id+ "não existe.");
    }

    @DeleteMapping("/deletar-ninja/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id) {
        if (listarNinja(id) != null) {
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Ninja de id " + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de ID " + id + " não encontrado.");
        }
    }




}
