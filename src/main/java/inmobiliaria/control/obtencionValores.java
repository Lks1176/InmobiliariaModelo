/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inmobiliaria.control;

/**
 *
 * @author User
 */
public class obtencionValores {
    public static double obtenerComision(double valor){
        double comision = valor*0.05;
        return comision;
    }
    
    public static double obtenerMulta(double valor){
        double multa = valor*0.1;
        return multa;
    }
    
    public static double obtenerImpuesto(double valor){
        double impuesto = valor*0.19;
        return impuesto;
    }
}
