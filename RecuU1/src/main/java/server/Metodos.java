package server;

import model.Bean;
import model.dao;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Metodos {

    dao daoExam = new dao();
    private String auto;

    public String insertar(String modelo, String marca, String color, String NoSerie) {
        daoExam.insertarRegistro(modelo,marca,color,NoSerie);
        return "" ;
    }

    public String consulta(String NoSerie){

        ArrayList<Bean> aux = daoExam.consultarRegistro(NoSerie);
        String response = "";

        for (Bean auto: aux){
            response += "Modelo: " + auto.getModelo() + "\n"
                    + "Marca: " + auto.getMarca() + "\n"
                    + "Color: " + auto.getColor() + "\n"
                    + "Numero de Serie: " + auto.getNoSerie();
        }

        return response;
    }
}
