/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.tcc.lfbarbearia.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f")
    , @NamedQuery(name = "Fornecedor.findById", query = "SELECT f FROM Fornecedor f WHERE f.id = :id")
    , @NamedQuery(name = "Fornecedor.findByNomeFantasia", query = "SELECT f FROM Fornecedor f WHERE f.nomeFantasia = :nomeFantasia")
    , @NamedQuery(name = "Fornecedor.findByRazaoSocial", query = "SELECT f FROM Fornecedor f WHERE f.razaoSocial = :razaoSocial")
    , @NamedQuery(name = "Fornecedor.findByCnpj", query = "SELECT f FROM Fornecedor f WHERE f.cnpj = :cnpj")
    , @NamedQuery(name = "Fornecedor.findByInscricaoEstadual", query = "SELECT f FROM Fornecedor f WHERE f.inscricaoEstadual = :inscricaoEstadual")
    , @NamedQuery(name = "Fornecedor.findByEndereco", query = "SELECT f FROM Fornecedor f WHERE f.endereco = :endereco")
    , @NamedQuery(name = "Fornecedor.findByNumero", query = "SELECT f FROM Fornecedor f WHERE f.numero = :numero")
    , @NamedQuery(name = "Fornecedor.findByBairro", query = "SELECT f FROM Fornecedor f WHERE f.bairro = :bairro")
    , @NamedQuery(name = "Fornecedor.findByComplemento", query = "SELECT f FROM Fornecedor f WHERE f.complemento = :complemento")
    , @NamedQuery(name = "Fornecedor.findByEmail", query = "SELECT f FROM Fornecedor f WHERE f.email = :email")
    , @NamedQuery(name = "Fornecedor.findByStatus", query = "SELECT f FROM Fornecedor f WHERE f.status = :status")
    , @NamedQuery(name = "Fornecedor.findByObservacao", query = "SELECT f FROM Fornecedor f WHERE f.observacao = :observacao")
    , @NamedQuery(name = "Fornecedor.findByTelefoneComercial", query = "SELECT f FROM Fornecedor f WHERE f.telefoneComercial = :telefoneComercial")
    , @NamedQuery(name = "Fornecedor.findByTelefoneCelular", query = "SELECT f FROM Fornecedor f WHERE f.telefoneCelular = :telefoneCelular")})
public class Fornecedor implements Serializable, InterfaceEntidades {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nomeFantasia")
    private String nomeFantasia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "razaoSocial")
    private String razaoSocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "cnpj")
    private String cnpj;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "inscricaoEstadual")
    private String inscricaoEstadual;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "endereco")
    private String endereco;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "bairro")
    private String bairro;
    @Size(max = 50)
    @Column(name = "complemento")
    private String complemento;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @Size(max = 300)
    @Column(name = "observacao")
    private String observacao;
    @Size(max = 30)
    @Column(name = "telefoneComercial")
    private String telefoneComercial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "telefoneCelular")
    private String telefoneCelular;
    @JoinTable(name = "fornecedor_insumo", joinColumns = {
        @JoinColumn(name = "idFornecedor", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "idInsumo", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Insumo> insumoCollection;
    @JoinColumn(name = "idCidade", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cidade idCidade;

    public Fornecedor() {
    }

    public Fornecedor(Integer id) {
        this.id = id;
    }

    public Fornecedor(Integer id, String nomeFantasia, String razaoSocial, String cnpj, String inscricaoEstadual, String endereco, int numero, String bairro, String email, boolean status, String telefoneCelular) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.email = email;
        this.status = status;
        this.telefoneCelular = telefoneCelular;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getTelefoneComercial() {
        return telefoneComercial;
    }

    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    @XmlTransient
    public Collection<Insumo> getInsumoCollection() {
        return insumoCollection;
    }

    public void setInsumoCollection(Collection<Insumo> insumoCollection) {
        this.insumoCollection = insumoCollection;
    }

    public Cidade getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Cidade idCidade) {
        this.idCidade = idCidade;
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
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.tcc.lfbarbearia.entidades.Fornecedor[ id=" + id + " ]";
    }
    
}
