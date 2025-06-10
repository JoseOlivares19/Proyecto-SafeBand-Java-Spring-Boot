package com.integracion.jcoq.model;

public class Usuario {

    private int id;
    private String nombre;
    private String correo;
    private String edad;
    private String pulso;
    private String temperatura;
    private String frec_resp;
    private String presion;
    private String fecha;
    private String contrasena;


    public Usuario() {

    }

    public Usuario(int id, String nombre, String correo, String edad, String pulso, String temperatura, String frec_card, String presion, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
        this.pulso = pulso;
        this.temperatura = temperatura;
        this.frec_resp = frec_card;
        this.presion = presion;
        this.fecha = fecha;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPulso() {
        return pulso;
    }

    public void setPulso(String pulso) {
        this.pulso = pulso;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getFrec_resp() {
        return frec_resp;
    }

    public void setFrec_resp(String frec_card) {
        this.frec_resp = frec_card;
    }

    public String getPresion() {
        return presion;
    }

    public void setPresion(String presion) {
        this.presion = presion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
