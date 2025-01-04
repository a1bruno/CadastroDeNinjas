package dev.java10x.aluno.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boas-vindas")
    public String boasVindas() {
        return "Essa é a mensagem de boas vindas";
    }

    @PostMapping("/criar-ninja")
    public String criarNinja() {
        return "criar ninja";
    }

    @GetMapping("/mostrar-ninjas")
    public String mostrarUsuarios() {
        return "Esses são os usuários";
    }

    @GetMapping("/mostrar-id_ninja")
    public String mostrarUsuario() {
        return "Usuario id";
    }

    @PutMapping("/alterar-ninja")
    public String alterarNinja() {
        return "alterar ninja";
    }

    @DeleteMapping("/deletar-ninja")
    public String deletarNinja() {
        return "deletar ninja";
    }




}
