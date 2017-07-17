/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.tcc.lfbarbearia.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "parametro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parametro.findAll", query = "SELECT p FROM Parametro p")
    , @NamedQuery(name = "Parametro.findById", query = "SELECT p FROM Parametro p WHERE p.id = :id")
    , @NamedQuery(name = "Parametro.findByTempoGerAgeda", query = "SELECT p FROM Parametro p WHERE p.tempoGerAgeda = :tempoGerAgeda")
    , @NamedQuery(name = "Parametro.findByHarioFechamentoCaixa", query = "SELECT p FROM Parametro p WHERE p.harioFechamentoCaixa = :harioFechamentoCaixa")})
public class Parametro implements Serializable, InterfaceEntidades {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tempoGerAgeda")
    @Temporal(TemporalType.TIME)
    private Date tempoGerAgeda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "harioFechamentoCaixa")
    @Temporal(TemporalType.DATE)
    private Date harioFechamentoCaixa;

    public Parametro() {
    }

    public Parametro(Integer id) {
        this.id = id;
    }

    public Parametro(Integer id, Date tempoGerAgeda, Date harioFechamentoCaixa) {
        this.id = id;
        this.tempoGerAgeda = tempoGerAgeda;
        this.harioFechamentoCaixa = harioFechamentoCaixa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTempoGerAgeda() {
        return tempoGerAgeda;
    }

    public void setTempoGerAgeda(Date tempoGerAgeda) {
        this.tempoGerAgeda = tempoGerAgeda;
    }

    public Date getHarioFechamentoCaixa() {
        return harioFechamentoCaixa;
    }

    public void setHarioFechamentoCaixa(Date harioFechamentoCaixa) {
        this.harioFechamentoCaixa = harioFechamentoCaixa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametro)) {
            return false;
        }
        Parametro other = (Parametro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.tcc.lfbarbearia.entidades.Parametro[ id=" + id + " ]";
    }
    
}
