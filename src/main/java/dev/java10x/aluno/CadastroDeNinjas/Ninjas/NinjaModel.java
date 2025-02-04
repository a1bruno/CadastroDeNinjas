package dev.java10x.aluno.CadastroDeNinjas.Ninjas;

import dev.java10x.aluno.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    private String rank;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissoesModel missao;

    @Override
    public String toString() {
        return "NinjaModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade + '\'' +
                ", rank=" + rank + '\'' +
                ", missao=" + missao +
                '}';
    }
}
