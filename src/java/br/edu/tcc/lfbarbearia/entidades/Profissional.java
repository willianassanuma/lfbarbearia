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
import javax.persistence.JoinTable;
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
@Table(name = "profissional")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profissional.findAll", query = "SELECT p FROM Profissional p")
    , @NamedQuery(name = "Profissional.findById", query = "SELECT p FROM Profissional p WHERE p.id = :id")
    , @NamedQuery(name = "Profissional.findByNomeProf", query = "SELECT p FROM Profissional p WHERE p.nomeProf = :nomeProf")
    , @NamedQuery(name = "Profissional.findByEndereco", query = "SELECT p FROM Profissional p WHERE p.endereco = :endereco")
    , @NamedQuery(name = "Profissional.findByNumero", query = "SELECT p FROM Profissional p WHERE p.numero = :numero")
    , @NamedQuery(name = "Profissional.findByBairro", query = "SELECT p FROM Profissional p WHERE p.bairro = :bairro")
    , @NamedQuery(name = "Profissional.findByComplemento", query = "SELECT p FROM Profissional p WHERE p.complemento = :complemento")
    , @NamedQuery(name = "Profissional.findByEmail", query = "SELECT p FROM Profissional p WHERE p.email = :email")
    , @NamedQuery(name = "Profissional.findByStatus", query = "SELECT p FROM Profissional p WHERE p.status = :status")
    , @NamedQuery(name = "Profissional.findByObservacao", query = "SELECT p FROM Profissional p WHERE p.observacao = :observacao")
    , @NamedQuery(name = "Profissional.findByTelefoneComercial", query = "SELECT p FROM Profissional p WHERE p.telefoneComercial = :telefoneComercial")
    , @NamedQuery(name = "Profissional.findByTelefoneCelular", query = "SELECT p FROM Profissional p WHERE p.telefoneCelular = :telefoneCelular")})
public class Profissional implements Serializable, InterfaceEntidades {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "nomeProf")
    private String nomeProf;
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
    @JoinTable(name = "profissional_servico", joinColumns = {
        @JoinColumn(name = "idProfissional", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "idServico", referencedColumnName = "id")})
    @ManyToMany
    private Collection<Servico> servicoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProfissional")
    private Collection<Agenda> agendaCollection;
    @JoinColumn(name = "idCidade", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cidade idCidade;

    public Profissional() {
    }

    public Profissional(Integer id) {
        this.id = id;
    }

    public Profissional(Integer id, String nomeProf, String endereco, int numero, String bairro, String email, boolean status, String telefoneCelular) {
        this.id = id;
        this.nomeProf = nomeProf;
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

    public String getNomeProf() {
        return nomeProf;
    }

    public void setNomeProf(String nomeProf) {
        this.nomeProf = nomeProf;
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
    public Collection<Servico> getServicoCollection() {
        return servicoCollection;
    }

    public void setServicoCollection(Collection<Servico> servicoCollection) {
        this.servicoCollection = servicoCollection;
    }

    @XmlTransient
    public Collection<Agenda> getAgendaCollection() {
        return agendaCollection;
    }

    public void setAgendaCollection(Collection<Agenda> agendaCollection) {
        this.agendaCollection = agendaCollection;
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
        if (!(object instanceof Profissional)) {
            return false;
        }
        Profissional other = (Profissional) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.tcc.lfbarbearia.entidades.Profissional[ id=" + id + " ]";
    }
    
}
