package es.upm.dit.isst.followmeapi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedidos")
public class Pedido {
    
    @Id
    private String numeroSeguimiento;

    private int idCliente;

    private int idVendedor;

    private int idRepartidor;
    
    @OneToMany(mappedBy = "pedido")
    private List<Traza> trazas;
    
    public Pedido() {
    }

    public String getNumeroSeguimiento() {
        return numeroSeguimiento;
    }

    public void setNumeroSeguimiento(String numeroSeguimiento) {
        this.numeroSeguimiento = numeroSeguimiento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getIdRepartidor() {
        return idRepartidor;
    }

    public void setIdRepartidor(int idRepartidor) {
        this.idRepartidor = idRepartidor;
    }

}
