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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "insumo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Insumo.findAll", query = "SELECT i FROM Insumo i")
    , @NamedQuery(name = "Insumo.findById", query = "SELECT i FROM Insumo i WHERE i.id = :id")
    , @NamedQuery(name = "Insumo.findByNome", query = "SELECT i FROM Insumo i WHERE i.nome = :nome")
    , @NamedQuery(name = "Insumo.findByStatus", query = "SELECT i FROM Insumo i WHERE i.status = :status")
    , @NamedQuery(name = "Insumo.findByEstoqueMinimo", query = "SELECT i FROM Insumo i WHERE i.estoqueMinimo = :estoqueMinimo")
    , @NamedQuery(name = "Insumo.findByObservacao", query = "SELECT i FROM Insumo i WHERE i.observacao = :observacao")})
public class Insumo implements Serializable, InterfaceEntidades {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estoqueMinimo")
    private float estoqueMinimo;
    @Size(max = 300)
    @Column(name = "observacao")
    private String observacao;
    @ManyToMany(mappedBy = "insumoCollection")
    private Collection<Fornecedor> fornecedorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInsumo")
    private Collection<Movestoque> movestoqueCollection;
    @JoinColumn(name = "idUnidadeMedida", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unidademedida idUnidadeMedida;

    public Insumo() {
    }

    public Insumo(Integer id) {
        this.id = id;
    }

    public Insumo(Integer id, String nome, boolean status, float estoqueMinimo) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.estoqueMinimo = estoqueMinimo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(float estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @XmlTransient
    public Collection<Fornecedor> getFornecedorCollection() {
        return fornecedorCollection;
    }

    public void setFornecedorCollection(Collection<Fornecedor> fornecedorCollection) {
        this.fornecedorCollection = fornecedorCollection;
    }

    @XmlTransient
    public Collection<Movestoque> getMovestoqueCollection() {
        return movestoqueCollection;
    }

    public void setMovestoqueCollection(Collection<Movestoque> movestoqueCollection) {
        this.movestoqueCollection = movestoqueCollection;
    }

    public Unidademedida getIdUnidadeMedida() {
        return idUnidadeMedida;
    }

    public void setIdUnidadeMedida(Unidademedida idUnidadeMedida) {
        this.idUnidadeMedida = idUnidadeMedida;
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
        if (!(object instanceof Insumo)) {
            return false;
        }
        Insumo other = (Insumo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.tcc.lfbarbearia.entidades.Insumo[ id=" + id + " ]";
    }
    
}
