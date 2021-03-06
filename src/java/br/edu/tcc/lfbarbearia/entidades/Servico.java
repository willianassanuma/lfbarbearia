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
import javax.persistence.ManyToMany;
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
 * @author Terminal 150
 */
@Entity
@Table(name = "servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servico.findAll", query = "SELECT s FROM Servico s")
    , @NamedQuery(name = "Servico.findById", query = "SELECT s FROM Servico s WHERE s.id = :id")
    , @NamedQuery(name = "Servico.findByDescricaoServico", query = "SELECT s FROM Servico s WHERE s.descricaoServico = :descricaoServico")
    , @NamedQuery(name = "Servico.findByComissaoServico", query = "SELECT s FROM Servico s WHERE s.comissaoServico = :comissaoServico")
    , @NamedQuery(name = "Servico.findByTempoGastoReal", query = "SELECT s FROM Servico s WHERE s.tempoGastoReal = :tempoGastoReal")
    , @NamedQuery(name = "Servico.findByTempoEsperaDurExec", query = "SELECT s FROM Servico s WHERE s.tempoEsperaDurExec = :tempoEsperaDurExec")
    , @NamedQuery(name = "Servico.findByStatus", query = "SELECT s FROM Servico s WHERE s.status = :status")})
public class Servico implements Serializable, InterfaceEntidades {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "descricaoServico")
    private String descricaoServico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comissaoServico")
    private float comissaoServico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tempoGastoReal")
    @Temporal(TemporalType.TIME)
    private Date tempoGastoReal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tempoEsperaDurExec")
    @Temporal(TemporalType.TIME)
    private Date tempoEsperaDurExec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @ManyToMany(mappedBy = "servicoCollection")
    private Collection<Profissional> profissionalCollection;

    public Servico() {
    }

    public Servico(Integer id) {
        this.id = id;
    }

    public Servico(Integer id, String descricaoServico, float comissaoServico, Date tempoGastoReal, Date tempoEsperaDurExec, boolean status) {
        this.id = id;
        this.descricaoServico = descricaoServico;
        this.comissaoServico = comissaoServico;
        this.tempoGastoReal = tempoGastoReal;
        this.tempoEsperaDurExec = tempoEsperaDurExec;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public float getComissaoServico() {
        return comissaoServico;
    }

    public void setComissaoServico(float comissaoServico) {
        this.comissaoServico = comissaoServico;
    }

    public Date getTempoGastoReal() {
        return tempoGastoReal;
    }

    public void setTempoGastoReal(Date tempoGastoReal) {
        this.tempoGastoReal = tempoGastoReal;
    }

    public Date getTempoEsperaDurExec() {
        return tempoEsperaDurExec;
    }

    public void setTempoEsperaDurExec(Date tempoEsperaDurExec) {
        this.tempoEsperaDurExec = tempoEsperaDurExec;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Profissional> getProfissionalCollection() {
        return profissionalCollection;
    }

    public void setProfissionalCollection(Collection<Profissional> profissionalCollection) {
        this.profissionalCollection = profissionalCollection;
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
        if (!(object instanceof Servico)) {
            return false;
        }
        Servico other = (Servico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.tcc.lfbarbearia.entidades.Servico[ id=" + id + " ]";
    }
    
}
