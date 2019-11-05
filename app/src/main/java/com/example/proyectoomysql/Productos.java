package com.example.proyectoomysql;

public class Productos {
    int codigo;
    String descripcion;
    double precio;
    String imagen;

    public Productos() {
    }

    public Productos(int codigo, String descripcion, double precio, String imagen) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagen = imagen;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
