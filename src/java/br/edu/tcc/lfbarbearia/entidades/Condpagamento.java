/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.tcc.lfbarbearia.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Terminal 150
 */
@Entity
@Table(name = "condpagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Condpagamento.findAll", query = "SELECT c FROM Condpagamento c")
    , @NamedQuery(name = "Condpagamento.findById", query = "SELECT c FROM Condpagamento c WHERE c.id = :id")
    , @NamedQuery(name = "Condpagamento.findByDescricao", query = "SELECT c FROM Condpagamento c WHERE c.descricao = :descricao")
    , @NamedQuery(name = "Condpagamento.findByQtdeVezes", query = "SELECT c FROM Condpagamento c WHERE c.qtdeVezes = :qtdeVezes")})
public class Condpagamento implements Serializable, InterfaceEntidades {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descricao")
    private String descricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtdeVezes")
    private int qtdeVezes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCondPag")
    private Collection<Compra> compraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCondPagamento")
    private Collection<Contasreceber> contasreceberCollection;

    public Condpagamento() {
    }

    public Condpagamento(Integer id) {
        this.id = id;
    }

    public Condpagamento(Integer id, String descricao, int qtdeVezes) {
        this.id = id;
        this.descricao = descricao;
        this.qtdeVezes = qtdeVezes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdeVezes() {
        return qtdeVezes;
    }

    public void setQtdeVezes(int qtdeVezes) {
        this.qtdeVezes = qtdeVezes;
    }

    @XmlTransient
    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    @XmlTransient
    public Collection<Contasreceber> getContasreceberCollection() {
        return contasreceberCollection;
    }

    public void setContasreceberCollection(Collection<Contasreceber> contasreceberCollection) {
        this.contasreceberCollection = contasreceberCollection;
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
        if (!(object instanceof Condpagamento)) {
            return false;
        }
        Condpagamento other = (Condpagamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.tcc.lfbarbearia.entidades.Condpagamento[ id=" + id + " ]";
    }
    
}
