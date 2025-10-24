package br.com.portfolio.api_observabilidade;

// Imports desnecessários removidos

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas") // Todos os endpoints começarão com /tarefas
public class TarefaController {

    @Autowired
    private TarefaRepository repository; // Agora o Java encontra essa classe

    // Endpoint para CRIAR uma nova tarefa (POST /tarefas)
    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) { // E encontra essa
        return repository.save(tarefa);
    }

    // Endpoint para LISTAR todas as tarefas (GET /tarefas)
    @GetMapping
    public List<Tarefa> listarTarefas() {
        return repository.findAll();
    }
}