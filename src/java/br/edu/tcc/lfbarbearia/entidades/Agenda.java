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
 * @author Marcos
 */
@Entity
@Table(name = "agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a")
    , @NamedQuery(name = "Agenda.findById", query = "SELECT a FROM Agenda a WHERE a.id = :id")
    , @NamedQuery(name = "Agenda.findByDataAgenda", query = "SELECT a FROM Agenda a WHERE a.dataAgenda = :dataAgenda")
    , @NamedQuery(name = "Agenda.findByHora", query = "SELECT a FROM Agenda a WHERE a.hora = :hora")})
public class Agenda implements Serializable, InterfaceEntidades {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataAgenda")
    @Temporal(TemporalType.DATE)
    private Date dataAgenda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAgenda")
    private Collection<Contasreceber> contasreceberCollection;
    @JoinColumn(name = "idProfissional", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Profissional idProfissional;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agenda")
    private Collection<AgendaCliente> agendaClienteCollection;

    public Agenda() {
    }

    public Agenda(Integer id) {
        this.id = id;
    }

    public Agenda(Integer id, Date dataAgenda, Date hora) {
        this.id = id;
        this.dataAgenda = dataAgenda;
        this.hora = hora;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataAgenda() {
        return dataAgenda;
    }

    public void setDataAgenda(Date dataAgenda) {
        this.dataAgenda = dataAgenda;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    @XmlTransient
    public Collection<Contasreceber> getContasreceberCollection() {
        return contasreceberCollection;
    }

    public void setContasreceberCollection(Collection<Contasreceber> contasreceberCollection) {
        this.contasreceberCollection = contasreceberCollection;
    }

    public Profissional getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(Profissional idProfissional) {
        this.idProfissional = idProfissional;
    }

    @XmlTransient
    public Collection<AgendaCliente> getAgendaClienteCollection() {
        return agendaClienteCollection;
    }

    public void setAgendaClienteCollection(Collection<AgendaCliente> agendaClienteCollection) {
        this.agendaClienteCollection = agendaClienteCollection;
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
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.tcc.lfbarbearia.entidades.Agenda[ id=" + id + " ]";
    }
    
}
