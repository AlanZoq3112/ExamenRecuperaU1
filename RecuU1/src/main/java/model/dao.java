package model;

import utils.MySqlConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class dao {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    private final String INSERT_REGISTRAR = "insert into auto(modelo, marca, color, NoSerie) " + "values(?,?,?,?)";

    private final String Consultar = "select * from auto WHERE  NoSerie = ?" ;

    public dao() {
    }

    public boolean insertarRegistro(String modelo, String marca, String color, String NoSerie){
        try{
            conn = new MySqlConnection().getConnection();
            String query = INSERT_REGISTRAR;
            pstm = conn.prepareStatement(query);
            pstm.setString(1, modelo);
            pstm.setString(2, marca);
            pstm.setString(3, color);
            pstm.setString(4, NoSerie);
            return pstm.executeUpdate()==1;
        }catch(SQLException e){
            Logger.getLogger(dao.class.getName())
                    .log(Level.SEVERE, "Error de operacion ->", e);
        } finally {
            closeConnections();
        } return false;
    }

    public ArrayList <Bean> consultarRegistro (String NoSerie){
        ArrayList<Bean> autosList = new ArrayList<>();
        Bean auto = null;
        try{
            conn = new MySqlConnection().getConnection();
            String query = Consultar;

            pstm = conn.prepareStatement(query);
            pstm.setString(1, NoSerie);
            rs = pstm.executeQuery();

            while(rs.next()){
                auto = new Bean();
                auto.setModelo(rs.getString("modelo"));
                auto.setMarca(rs.getString("marca"));
                auto.setColor(rs.getString("color"));
                auto.setNoSerie(rs.getString("NoSerie"));


                autosList.add(auto);
            }

        }catch (SQLException e) {
            Logger.getLogger(Bean.class.getName())
                    .log(Level.SEVERE, "Error de operacion -> ", e);
        } return autosList;
    }

    public void  closeConnections(){
        try{
            if(conn != null){
                conn.close();
            }
            if(pstm != null){
                pstm.close();
            }
            if(rs != null){
                rs.close();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
