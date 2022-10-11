package model;

import java.sql.Date;

public class Bean {
    private String modelo;
    private String marca;
    private String color;
    private String NoSerie;

    public Bean() {
    }

    public Bean(String modelo, String marca, String color, String NoSerie) {
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.NoSerie = NoSerie;
    }
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNoSerie() {
        return NoSerie;
    }

    public void setNoSerie(String NoSerie) {
        this.NoSerie = NoSerie;
    }

}
