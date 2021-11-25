package br.iftm.edu.orquestrademo.repository;

import br.iftm.edu.orquestrademo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Task> buscaTodasTasks() {
        String consulta = "SELECT * FROM TASK;";

        //nomes de acordo com as variáveis criadas no banco de dados
        return jdbcTemplate.query(
                consulta,
                (resultado, numeroDaLinha) -> {
                    return new Task(
                            resultado.getInt("id_task"),
                            resultado.getDate("data_de_execucao"),
                            resultado.getDouble("total_de_horas"),
                            resultado.getString("tipo_natureza"),
                            resultado.getString("descricao"),
                            resultado.getInt("id_usuario"),
                            resultado.getInt("projeto")
                    );
                }
        );
    }

    public int insereTask(Task task) {
        String consulta = "INSERT INTO TASK (data_de_execucao, total_de_horas, tipo_natureza, descricao, id_usuario, projeto) VALUES(? ,? ,? ,? ,? ,? )";
        return jdbcTemplate.update(consulta,
                task.getDataExecucao(),
                task.getTotalHoras(),
                task.getTipoNatureza(),
                task.getDescricao(),
                9,
                2
        );
    }

    public int atualizaTask(Task task) {
        String consulta = "UPDATE TASK SET " +
                                "data_de_execucao = ?, " +
                                "total_de_horas = ?, " +
                                "tipo_natureza = ?, " +
                                "descricao = ? " +
                           "WHERE " +
                                "id_task = ? ";
        return jdbcTemplate.update(consulta,
                                    task.getDataExecucao(),
                                    task.getTotalHoras(),
                                    task.getTipoNatureza(),
                                    task.getDescricao(),
                                    task.getId()
        );
    }

    public int excluiTask(Integer id) {
        String consulta = "DELETE FROM TASK WHERE id_task = ?";
        return jdbcTemplate.update(consulta, id);
    }

    public Task buscaPorId(Integer id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM TASK WHERE id_task = ? ",
                (resultado, numeroDaLinha) -> {
                    return new Task(
                            resultado.getInt("id_task"),
                            resultado.getDate("data_de_execucao"),
                            resultado.getDouble("total_de_horas"),
                            resultado.getString("tipo_natureza"),
                            resultado.getString("descricao"),
                            resultado.getInt("id_usuario"),
                            resultado.getInt("projeto")
                            );},
                id);
    }


}
