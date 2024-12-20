package dev.java10x.aluno.CadastroDeNinjas.Missoes;

import dev.java10x.aluno.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    @OneToMany(mappedBy = "missao")
    private LinkedList<NinjaModel> ninjas;

    @Override
    public String toString() {
        return "MissoesModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dificuldade='" + dificuldade + '\'' +
                ", ninjas=" + ninjas +
                '}';
    }
}
