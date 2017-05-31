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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Marcos
 */
@Entity
@Table(name = "contaspagar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contaspagar.findAll", query = "SELECT c FROM Contaspagar c")
    , @NamedQuery(name = "Contaspagar.findById", query = "SELECT c FROM Contaspagar c WHERE c.id = :id")
    , @NamedQuery(name = "Contaspagar.findByValor", query = "SELECT c FROM Contaspagar c WHERE c.valor = :valor")
    , @NamedQuery(name = "Contaspagar.findByQtdeParcelas", query = "SELECT c FROM Contaspagar c WHERE c.qtdeParcelas = :qtdeParcelas")
    , @NamedQuery(name = "Contaspagar.findByDataVencimento", query = "SELECT c FROM Contaspagar c WHERE c.dataVencimento = :dataVencimento")
    , @NamedQuery(name = "Contaspagar.findByStatus", query = "SELECT c FROM Contaspagar c WHERE c.status = :status")})
public class Contaspagar implements Serializable, InterfaceEntidades {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private float valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qtdeParcelas")
    private int qtdeParcelas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataVencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "status")
    private String status;
    @ManyToMany(mappedBy = "contaspagarCollection")
    private Collection<Fornecedor> fornecedorCollection;
    @JoinColumn(name = "idCompra", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Compra idCompra;

    public Contaspagar() {
    }

    public Contaspagar(Integer id) {
        this.id = id;
    }

    public Contaspagar(Integer id, float valor, int qtdeParcelas, Date dataVencimento, String status) {
        this.id = id;
        this.valor = valor;
        this.qtdeParcelas = qtdeParcelas;
        this.dataVencimento = dataVencimento;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQtdeParcelas() {
        return qtdeParcelas;
    }

    public void setQtdeParcelas(int qtdeParcelas) {
        this.qtdeParcelas = qtdeParcelas;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Fornecedor> getFornecedorCollection() {
        return fornecedorCollection;
    }

    public void setFornecedorCollection(Collection<Fornecedor> fornecedorCollection) {
        this.fornecedorCollection = fornecedorCollection;
    }

    public Compra getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Compra idCompra) {
        this.idCompra = idCompra;
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
        if (!(object instanceof Contaspagar)) {
            return false;
        }
        Contaspagar other = (Contaspagar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.tcc.lfbarbearia.entidades.Contaspagar[ id=" + id + " ]";
    }
    
}
