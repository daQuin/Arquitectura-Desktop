package co.edu.ufps.modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Dairo F. Ramirez
 */
public class Usuario {

    private int id;
    private String usuario;
    private Date createdAt;
    private Date updatedAt;

    public Usuario() {
    }

    public Usuario(String usuario) {
        this.usuario = usuario;
    }
    public Usuario(int id, String usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
        hash = 11 * hash + this.id;
        hash = 11 * hash + Objects.hashCode(this.usuario);
        hash = 11 * hash + Objects.hashCode(this.createdAt);
        hash = 11 * hash + Objects.hashCode(this.updatedAt);
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
        final Usuario other = (Usuario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
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
        return "{"
                + "id: " + id + ","
                + "usuario: " + usuario+ ","
                + "createdAt: " + createdAt+ ","
                + "updatedAt: " + updatedAt
                + "}";
    }

}
