package com.example.proyectofinal1;

public class Contratos {
    String idContrato;
    String guia;
    String telefono;
    String personas;
    String destino;
    String tiempo;
    String foto;
    public Contratos(String idContrato, String guia, String telefono, String personas, String destino, String tiempo, String foto) {
        this.idContrato = idContrato;
        this.guia = guia;
        this.telefono = telefono;
        this.personas = personas;
        this.destino = destino;
        this.tiempo = tiempo;
        this.foto = foto;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(String idAmigo) {
        this.idContrato = idContrato;
    }

    public String getGuia() {
        return guia;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPersonas() {
        return personas;
    }

    public void setPersonas(String personas) {
        this.personas = personas;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}

