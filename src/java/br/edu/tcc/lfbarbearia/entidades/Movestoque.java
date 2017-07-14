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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Terminal 150
 */
@Entity
@Table(name = "movestoque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movestoque.findAll", query = "SELECT m FROM Movestoque m")
    , @NamedQuery(name = "Movestoque.findById", query = "SELECT m FROM Movestoque m WHERE m.id = :id")
    , @NamedQuery(name = "Movestoque.findByQtdeEntrada", query = "SELECT m FROM Movestoque m WHERE m.qtdeEntrada = :qtdeEntrada")
    , @NamedQuery(name = "Movestoque.findByQtdeSaida", query = "SELECT m FROM Movestoque m WHERE m.qtdeSaida = :qtdeSaida")
    , @NamedQuery(name = "Movestoque.findByDataMov", query = "SELECT m FROM Movestoque m WHERE m.dataMov = :dataMov")})
public class Movestoque implements Serializable, InterfaceEntidades {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtdeEntrada")
    private float qtdeEntrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtdeSaida")
    private float qtdeSaida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataMov")
    @Temporal(TemporalType.DATE)
    private Date dataMov;
    @JoinColumn(name = "idInsumo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Insumo idInsumo;

    public Movestoque() {
    }

    public Movestoque(Integer id) {
        this.id = id;
    }

    public Movestoque(Integer id, float qtdeEntrada, float qtdeSaida, Date dataMov) {
        this.id = id;
        this.qtdeEntrada = qtdeEntrada;
        this.qtdeSaida = qtdeSaida;
        this.dataMov = dataMov;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getQtdeEntrada() {
        return qtdeEntrada;
    }

    public void setQtdeEntrada(float qtdeEntrada) {
        this.qtdeEntrada = qtdeEntrada;
    }

    public float getQtdeSaida() {
        return qtdeSaida;
    }

    public void setQtdeSaida(float qtdeSaida) {
        this.qtdeSaida = qtdeSaida;
    }

    public Date getDataMov() {
        return dataMov;
    }

    public void setDataMov(Date dataMov) {
        this.dataMov = dataMov;
    }

    public Insumo getIdInsumo() {
        return idInsumo;
    }

    public void setIdInsumo(Insumo idInsumo) {
        this.idInsumo = idInsumo;
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
        if (!(object instanceof Movestoque)) {
            return false;
        }
        Movestoque other = (Movestoque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.tcc.lfbarbearia.entidades.Movestoque[ id=" + id + " ]";
    }
    
}
