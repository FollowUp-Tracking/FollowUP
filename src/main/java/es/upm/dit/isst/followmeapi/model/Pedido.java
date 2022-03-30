/*package es.upm.dit.isst.followmeapi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pedido {
    
    @Id
    private String numeroSeguimiento;
    private Traza origen;
    private Traza destino;
    private Date fecha;
    private String producto;
    private String correo;
    private int idRepartidor;
    @OneToMany(targetEntity=Traza.class, mappedBy="pedido", fetch=FetchType.EAGER)
    private List<Traza> trazas;
    private String empresa;


    public Pedido() {
    }

    public String getNumeroSeguimiento() {
        return numeroSeguimiento;
    }

    public void setNumeroSeguimiento(String numeroSeguimiento) {
        this.numeroSeguimiento = numeroSeguimiento;
    }

    public Traza getOrigen() {
        return origen;
    }

    public void setOrigen(Traza origen) {
        this.origen = origen;
    }

    public Traza getDestino() {
        return destino;
    }

    public void setDestino(Traza destino) {
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

    public List<Traza> getTrazas() {
        return trazas;
    }

    public void setTrazas(List<Traza> trazas) {
        this.trazas = trazas;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}*/
