package br.iftm.edu.orquestrademo.controller;

import br.iftm.edu.orquestrademo.model.Task;
import br.iftm.edu.orquestrademo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TaskControlador {

    @Autowired
    TaskRepository repo;

//    Retorna lista de tasks
    @GetMapping(value = "/tasks")
    public String tasksTabela(Model modelo) {
        List<Task> lista = repo.buscaTodasTasks();
        modelo.addAttribute("tasks", lista);
        return "lista-tasks";
    }

//    Redireciona para página de criação de nova task
    @GetMapping(value = "/cadastro-task")
    public String Task(Model modelo) {
        modelo.addAttribute("task", new Task());
        return "cadastro-task";
    }

//    Cria nova task
    @PostMapping(value = "/cadastro-task")
    public String tasksCadastro(Task task) {
        if(task.getId() == null) {
            repo.insereTask(task);
        } else {
            repo.atualizaTask(task);
        }
        return "redirect:/tasks";
    }

//    Edita task na lista de tasks
    @GetMapping(value = "/editar-task")
    public String editaTask(@RequestParam(name = "id", required = true) Integer cod, Model modelo) {
        modelo.addAttribute("task", repo.buscaPorId(cod));
        return "cadastro-task";
    }

//    Exclui task
    @GetMapping(value = "excluir-task")
    public String excluiTask(@RequestParam(name = "id", required = true) Integer cod) {
        repo.excluiTask(cod);
        return "redirect:/tasks";

    }

}
