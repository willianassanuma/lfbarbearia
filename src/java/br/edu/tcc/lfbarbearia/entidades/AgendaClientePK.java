/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.tcc.lfbarbearia.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Marcos
 */
@Embeddable
public class AgendaClientePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idCliente")
    private int idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idAgenda")
    private int idAgenda;

    public AgendaClientePK() {
    }

    public AgendaClientePK(int idCliente, int idAgenda) {
        this.idCliente = idCliente;
        this.idAgenda = idAgenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCliente;
        hash += (int) idAgenda;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgendaClientePK)) {
            return false;
        }
        AgendaClientePK other = (AgendaClientePK) object;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (this.idAgenda != other.idAgenda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.tcc.lfbarbearia.entidades.AgendaClientePK[ idCliente=" + idCliente + ", idAgenda=" + idAgenda + " ]";
    }
    
}
