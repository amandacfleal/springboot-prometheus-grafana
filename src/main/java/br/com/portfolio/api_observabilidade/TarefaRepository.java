package br.com.portfolio.api_observabilidade;

// A LINHA DE IMPORT FOI REMOVIDA DAQUI

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    // A mágica do Spring Data JPA:
    // Não precisamos escrever NADA. Os métodos save(), findAll(), findById()
    // já estão prontos para nós.
}