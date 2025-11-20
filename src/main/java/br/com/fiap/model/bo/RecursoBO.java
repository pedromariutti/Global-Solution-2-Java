package br.com.fiap.model.bo;

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.RecursoDAO;
import br.com.fiap.model.to.RecursoTO;
import java.sql.Connection;
import java.util.ArrayList;

public class RecursoBO {

    private RecursoDAO recursoDAO;

    public ArrayList<RecursoTO> findAll() {
        Connection con = ConnectionFactory.abrirConexao();
        recursoDAO = new RecursoDAO(con);
        ArrayList<RecursoTO> lista = recursoDAO.findAll();
        ConnectionFactory.fecharConexao(con);
        return lista;
    }

    public String save(RecursoTO recurso) {
        // Validação de Regra de Negócio
        if (!recurso.getLink().startsWith("http")) {
            return "Erro: O link deve começar com http ou https.";
        }

        Connection con = ConnectionFactory.abrirConexao();
        recursoDAO = new RecursoDAO(con);
        String resultado = recursoDAO.save(recurso);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public boolean delete(Long id) {
        Connection con = ConnectionFactory.abrirConexao();
        recursoDAO = new RecursoDAO(con);
        boolean resultado = recursoDAO.delete(id);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }

    public String update(RecursoTO recurso) {
        Connection con = ConnectionFactory.abrirConexao();
        recursoDAO = new RecursoDAO(con);
        String resultado = recursoDAO.update(recurso);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}