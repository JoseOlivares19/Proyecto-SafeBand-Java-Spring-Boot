package com.integracion.jcoq.repository;

import com.integracion.jcoq.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Repository
public class UsuarioRepository {

    @Autowired
    private JdbcTemplate jdbc;

    public void insertar(Usuario usuario) {
        Date fecha = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaString = formato.format(fecha);
        usuario.setFecha(fechaString);
        jdbc.update("{call sp_insertar_usuario(?, ?, ?, ?, ?, ?, ?, ?)}",
                usuario.getNombre(), usuario.getCorreo(), usuario.getEdad(), usuario.getFecha(), usuario.getPresion(), usuario.getFrec_resp(), usuario.getPulso(), usuario.getTemperatura());
    }


    public List<Usuario> listar() {
        return jdbc.query("{call sp_listar_usuarios()}", new RowMapper<Usuario>() {
            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setNombre(rs.getString("nombre"));
                u.setCorreo(rs.getString("correo"));
                u.setEdad(rs.getString("edad"));
                u.setPresion(rs.getString("presion"));
                u.setFrec_resp(rs.getString(("frec_resp")));
                u.setTemperatura(rs.getString("temperatura"));
                u.setPulso(rs.getString("pulso"));
                u.setFecha(rs.getString("fecha"));
                return u;
            }
        });
    }
}