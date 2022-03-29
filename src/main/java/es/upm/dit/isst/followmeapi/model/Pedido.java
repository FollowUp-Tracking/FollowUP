package es.upm.dit.isst.followmeapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pedido {
    
    @Id
    private long numeroSeguimiento;
    private double[][] origen; 
    private double[][] destino;
    private Date fecha;
    private String producto;
    private String correo;
    private int idRepartidor;
    private double[][] trazas;

    public Pedido() {
    }

    public long getNumero() {
        return numeroSeguimiento;
    }

    public void setNumero(long numeroSeguimiento) {
        this.numeroSeguimiento = numeroSeguimiento;
    }

    public double[][] getOrigen() {
        return origen;
    }

    public void setOrigen(double[][] origen) {
        this.origen = origen;
    }

    public double[][] getDestino() {
        return destino;
    }

    public void setDestino(double[][] destino) {
        this.destino = destino;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(int idRepartidor) {
        this.idRepartidor = idRepartidor;
    }

    public double[][] getTrazas() {
        return trazas;
    }

    public void setTrazas(double[][] trazas) {
        this.trazas = trazas;
    }
}
