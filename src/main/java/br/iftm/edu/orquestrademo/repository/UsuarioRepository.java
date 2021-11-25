package br.iftm.edu.orquestrademo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.iftm.edu.orquestrademo.model.Usuario;

@Repository
public class UsuarioRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int registraUsuario(Usuario usuario){
        String consulta = "INSERT INTO usuario(senha, nome_usuario) VALUES(?,?)";
        return jdbcTemplate.update(consulta, usuario.getNome_usuario(), usuario.getSenha());
    }

}
