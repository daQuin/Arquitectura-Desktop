package co.edu.ufps.modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Dairo F. Ramirez
 */
public class Mensaje {

    private String texto;
    private Usuario remitente;
    private Usuario destinatario;
    private Date createdAt;
    private Date updatedAt;

    public Mensaje() {
    }

    public Mensaje(String texto, Usuario remitente, Usuario destinatario) {
        this.texto = texto;
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Usuario getRemitente() {
        return remitente;
    }

    public void setRemitente(Usuario remitente) {
        this.remitente = remitente;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.texto);
        hash = 37 * hash + Objects.hashCode(this.remitente);
        hash = 37 * hash + Objects.hashCode(this.destinatario);
        hash = 37 * hash + Objects.hashCode(this.createdAt);
        hash = 37 * hash + Objects.hashCode(this.updatedAt);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mensaje other = (Mensaje) obj;
        if (!Objects.equals(this.texto, other.texto)) {
            return false;
        }
        if (!Objects.equals(this.remitente, other.remitente)) {
            return false;
        }
        if (!Objects.equals(this.destinatario, other.destinatario)) {
            return false;
        }
        if (!Objects.equals(this.createdAt, other.createdAt)) {
            return false;
        }
        if (!Objects.equals(this.updatedAt, other.updatedAt)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  "texto: " + texto
                + "remitente: " + remitente
                + "destinatario: " + destinatario
                + "createdAt: " + createdAt
                + "updatedAt: " + updatedAt
                ;
    }

}
