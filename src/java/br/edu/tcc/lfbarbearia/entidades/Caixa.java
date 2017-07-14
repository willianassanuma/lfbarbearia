/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.tcc.lfbarbearia.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Terminal 150
 */
@Entity
@Table(name = "caixa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caixa.findAll", query = "SELECT c FROM Caixa c")
    , @NamedQuery(name = "Caixa.findById", query = "SELECT c FROM Caixa c WHERE c.id = :id")
    , @NamedQuery(name = "Caixa.findByValorEntrada", query = "SELECT c FROM Caixa c WHERE c.valorEntrada = :valorEntrada")
    , @NamedQuery(name = "Caixa.findByValorSaida", query = "SELECT c FROM Caixa c WHERE c.valorSaida = :valorSaida")
    , @NamedQuery(name = "Caixa.findByDataDia", query = "SELECT c FROM Caixa c WHERE c.dataDia = :dataDia")})
public class Caixa implements Serializable, InterfaceEntidades {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorEntrada")
    private float valorEntrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorSaida")
    private float valorSaida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataDia")
    @Temporal(TemporalType.DATE)
    private Date dataDia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCaixa")
    private Collection<Logmovcaixa> logmovcaixaCollection;
    @JoinColumn(name = "idTipoMov", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tipomovimento idTipoMov;

    public Caixa() {
    }

    public Caixa(Integer id) {
        this.id = id;
    }

    public Caixa(Integer id, float valorEntrada, float valorSaida, Date dataDia) {
        this.id = id;
        this.valorEntrada = valorEntrada;
        this.valorSaida = valorSaida;
        this.dataDia = dataDia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(float valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public float getValorSaida() {
        return valorSaida;
    }

    public void setValorSaida(float valorSaida) {
        this.valorSaida = valorSaida;
    }

    public Date getDataDia() {
        return dataDia;
    }

    public void setDataDia(Date dataDia) {
        this.dataDia = dataDia;
    }

    @XmlTransient
    public Collection<Logmovcaixa> getLogmovcaixaCollection() {
        return logmovcaixaCollection;
    }

    public void setLogmovcaixaCollection(Collection<Logmovcaixa> logmovcaixaCollection) {
        this.logmovcaixaCollection = logmovcaixaCollection;
    }

    public Tipomovimento getIdTipoMov() {
        return idTipoMov;
    }

    public void setIdTipoMov(Tipomovimento idTipoMov) {
        this.idTipoMov = idTipoMov;
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
        if (!(object instanceof Caixa)) {
            return false;
        }
        Caixa other = (Caixa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.tcc.lfbarbearia.entidades.Caixa[ id=" + id + " ]";
    }
    
}
