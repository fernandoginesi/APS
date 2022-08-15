package aps.banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class bdAgua extends bd {

    //---------------------------------------------//insert banco//--------------------------------------------------------------------
    public void insert(String mesConta, double valorConta) {
        this.conectar();

        String insertMes = "INSERT INTO agua(mes, valorConta) VALUES (?,?)";  //insert banco
        PreparedStatement stmt = this.criarPreparedStatement(insertMes);
        try {
            stmt.setString(1, mesConta);
            stmt.setDouble(2, valorConta);
            stmt.executeUpdate();

        } catch (SQLException e) {
        } finally {
            try {
                stmt.close();
                this.desconectar();
            } catch (SQLException e) {
            }
        }
    }

    // ---------------------------------------------//select banco//--------------------------------------------------------------------
    public ArrayList select() {
        ResultSet resultset = null;
        Statement statement = null;
        this.listaBD.clear();
        this.conectar();

        String query = "SELECT * FROM agua;";
        statement = this.criarStatment();
        try {
            resultset = statement.executeQuery(query);
            while (resultset.next()) {
                this.listaBD.add(String.valueOf(resultset.getString("id")) + " - " + resultset.getString("mes"));
                this.listaBD.add(resultset.getDouble("valorConta"));
            }
        } catch (SQLException e) {
        } finally {
            try {
                resultset.close();
                statement.close();
                this.desconectar();
            } catch (SQLException e) {
            }
        }
        return this.listaBD;
    }
}
