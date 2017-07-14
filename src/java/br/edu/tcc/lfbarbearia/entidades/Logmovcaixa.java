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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Terminal 150
 */
@Entity
@Table(name = "logmovcaixa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logmovcaixa.findAll", query = "SELECT l FROM Logmovcaixa l")
    , @NamedQuery(name = "Logmovcaixa.findById", query = "SELECT l FROM Logmovcaixa l WHERE l.id = :id")
    , @NamedQuery(name = "Logmovcaixa.findByDataMov", query = "SELECT l FROM Logmovcaixa l WHERE l.dataMov = :dataMov")
    , @NamedQuery(name = "Logmovcaixa.findByAlteracao", query = "SELECT l FROM Logmovcaixa l WHERE l.alteracao = :alteracao")})
public class Logmovcaixa implements Serializable, InterfaceEntidades {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataMov")
    @Temporal(TemporalType.DATE)
    private Date dataMov;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "alteracao")
    private String alteracao;
    @JoinColumn(name = "idCaixa", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Caixa idCaixa;

    public Logmovcaixa() {
    }

    public Logmovcaixa(Integer id) {
        this.id = id;
    }

    public Logmovcaixa(Integer id, Date dataMov, String alteracao) {
        this.id = id;
        this.dataMov = dataMov;
        this.alteracao = alteracao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataMov() {
        return dataMov;
    }

    public void setDataMov(Date dataMov) {
        this.dataMov = dataMov;
    }

    public String getAlteracao() {
        return alteracao;
    }

    public void setAlteracao(String alteracao) {
        this.alteracao = alteracao;
    }

    public Caixa getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(Caixa idCaixa) {
        this.idCaixa = idCaixa;
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
        if (!(object instanceof Logmovcaixa)) {
            return false;
        }
        Logmovcaixa other = (Logmovcaixa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.tcc.lfbarbearia.entidades.Logmovcaixa[ id=" + id + " ]";
    }
    
}
