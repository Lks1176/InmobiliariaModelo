package inmobiliaria.model;

import java.util.Date;

public class TransaccionInm {
    private int transaccionId;
    private int propiedadId;
    private String tipo;
    private double valor;
    private Date fecha;
    private int clienteId;
    private double comision;
    private double valorMulta;
    private double valorImpuesto;
    
    public TransaccionInm() {
    }

    public TransaccionInm(int transaccionId, int propiedadId, String tipo, double valor, Date fecha, int clienteId) {
        this.transaccionId = transaccionId;
        this.propiedadId = propiedadId;
        this.tipo = tipo;
        this.valor = valor;
        this.fecha = fecha;
        this.clienteId = clienteId;
        this.comision = 0;
        this.valorMulta = 0;
        this.valorImpuesto = 0;
    }

    public int getTransaccionId() {
        return transaccionId;
    }
    public void setTransaccionId(int transaccionId) {
        this.transaccionId = transaccionId;
    }

    public int getPropiedadId() {
        return propiedadId;
    }
    public void setPropiedadId(int propiedadId) {
        this.propiedadId = propiedadId;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getClienteId() {
        return clienteId;
    }
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public double getComision() {
        return comision;
    }
    public void setComision(double comision) {
        this.comision = comision;
    }

    public double getValorMulta() {
        return valorMulta;
    }
    public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }

    public double getValorImpuesto() {
        return valorImpuesto;
    }
    public void setValorImpuesto(double valorImpuesto) {
        this.valorImpuesto = valorImpuesto;
    }
    
}
