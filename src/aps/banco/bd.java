package aps.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import aps.agua.Agua;

public class bd {

    protected ArrayList<Object> listaBD = new ArrayList();
    private Connection conexao;

    public boolean conectar() {
        try {
            String url = "jdbc:sqlite:banco_de_dados/banco_de_dados.db";
            this.conexao = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean desconectar() {
        try {
            if (this.conexao.isClosed() == false) {
                this.conexao.close();

            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Statement criarStatment() {
        try {
            return this.conexao.createStatement();
        } catch (SQLException e) {
            return null;
        }
    }

    public PreparedStatement criarPreparedStatement(String sql) {
        try {
            return this.conexao.prepareStatement(sql);
        } catch (SQLException e) {
            return null;
        }
    }

    public Connection getConexao() {
        return this.conexao;
    }
}
