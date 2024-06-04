package inmobiliaria.model;

import java.util.Date;

public class Propiedad {
    private int propiedadId;
    private int clienteId;
    private String tipo;
    private String ciudad;
    private String pais;
    private double valor;
    private Date fechaApertura;
    private String estado;

    public Propiedad() {
    }

    public Propiedad(int clienteId, String tipo, String ciudad, String pais, double valor, Date fechaApertura, String estado) {
        this.clienteId = clienteId;
        this.tipo = tipo;
        this.ciudad = ciudad;
        this.pais = pais;
        this.valor = valor;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
    }

    public int getPropiedadId() {
        return propiedadId;
    }
    public void setPropiedadId(int propiedadId) {
        this.propiedadId = propiedadId;
    }

    public int getClienteId() {
        return clienteId;
    }
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }
    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}