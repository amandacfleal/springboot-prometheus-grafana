package br.com.portfolio.api_observabilidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data; // Importa do Lombok

@Data // <-- Mágica do Lombok: cria Getters, Setters, toString, etc.
@Entity // <-- Diz ao JPA que esta classe é uma tabela no banco
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private boolean concluida;
}