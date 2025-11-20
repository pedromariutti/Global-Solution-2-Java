package br.com.fiap.model.dao;

import br.com.fiap.model.to.RecursoTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecursoDAO {

    private Connection con;

    public RecursoDAO(Connection con) {
        this.con = con;
    }

    public ArrayList<RecursoTO> findAll() {
        ArrayList<RecursoTO> lista = new ArrayList<>();
        String sql = "SELECT * FROM T_RECURSO ORDER BY ID_RECURSO DESC";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                RecursoTO to = new RecursoTO();
                to.setId(rs.getLong("ID_RECURSO"));
                to.setTitulo(rs.getString("TITULO"));
                to.setLink(rs.getString("LINK"));
                to.setCategoria(rs.getString("CATEGORIA"));
                to.setDescricao(rs.getString("DESCRICAO"));
                to.setIdUsuario(rs.getLong("ID_USER"));
                lista.add(to);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar: " + e.getMessage());
        }
        return lista;
    }

    public String save(RecursoTO recurso) {
        String sql = "INSERT INTO T_RECURSO (TITULO, LINK, CATEGORIA, DESCRICAO, ID_USER) VALUES (?,?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, recurso.getTitulo());
            ps.setString(2, recurso.getLink());
            ps.setString(3, recurso.getCategoria());
            ps.setString(4, recurso.getDescricao());
            ps.setLong(5, recurso.getIdUsuario());
            if (ps.executeUpdate() > 0) {
                return "Cadastrado com sucesso!";
            }
        } catch (SQLException e) {
            return "Erro ao cadastrar: " + e.getMessage();
        }
        return "Erro desconhecido.";
    }

    // Método para deletar
    public boolean delete(Long id) {
        String sql = "DELETE FROM T_RECURSO WHERE ID_RECURSO = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar: " + e.getMessage());
            return false;
        }
    }

    // Método para Alterar
    public String update(RecursoTO recurso) {
        String sql = "UPDATE T_RECURSO SET TITULO=?, LINK=?, CATEGORIA=?, DESCRICAO=? WHERE ID_RECURSO=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, recurso.getTitulo());
            ps.setString(2, recurso.getLink());
            ps.setString(3, recurso.getCategoria());
            ps.setString(4, recurso.getDescricao());
            ps.setLong(5, recurso.getId());
            if (ps.executeUpdate() > 0) return "Atualizado com sucesso!";
        } catch (SQLException e) {
            return "Erro ao atualizar: " + e.getMessage();
        }
        return "Erro ao atualizar.";
    }
}