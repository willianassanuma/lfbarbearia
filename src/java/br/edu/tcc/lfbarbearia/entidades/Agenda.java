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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "agenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agenda.findAll", query = "SELECT a FROM Agenda a")
    , @NamedQuery(name = "Agenda.findById", query = "SELECT a FROM Agenda a WHERE a.id = :id")
    , @NamedQuery(name = "Agenda.findByDataHoraDeAgendamento", query = "SELECT a FROM Agenda a WHERE a.dataHoraDeAgendamento = :dataHoraDeAgendamento")
    , @NamedQuery(name = "Agenda.findByStatusAgendamento", query = "SELECT a FROM Agenda a WHERE a.statusAgendamento = :statusAgendamento")
    , @NamedQuery(name = "Agenda.findByHoraDeInicio", query = "SELECT a FROM Agenda a WHERE a.horaDeInicio = :horaDeInicio")
    , @NamedQuery(name = "Agenda.findByHoraDeFim", query = "SELECT a FROM Agenda a WHERE a.horaDeFim = :horaDeFim")})
public class Agenda implements Serializable, InterfaceEntidades {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataHoraDeAgendamento")
    @Temporal(TemporalType.DATE)
    private Date dataHoraDeAgendamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "statusAgendamento")
    private String statusAgendamento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaDeInicio")
    @Temporal(TemporalType.TIME)
    private Date horaDeInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaDeFim")
    @Temporal(TemporalType.TIME)
    private Date horaDeFim;
    @ManyToMany(mappedBy = "agendaCollection")
    private Collection<Cliente> clienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAgenda")
    private Collection<Contasreceber> contasreceberCollection;
    @JoinColumn(name = "idProfissional", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Profissional idProfissional;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataDaAgenda")
    @Temporal(TemporalType.DATE)
    private Date dataDaAgenda;

    public Agenda() {
    }

    public Agenda(Integer id) {
        this.id = id;
    }

    public Agenda(Integer id, Date dataHoraDeAgendamento, String statusAgendamento, Date horaDeInicio, Date horaDeFim) {
        this.id = id;
        this.dataHoraDeAgendamento = dataHoraDeAgendamento;
        this.statusAgendamento = statusAgendamento;
        this.horaDeInicio = horaDeInicio;
        this.horaDeFim = horaDeFim;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHoraDeAgendamento() {
        return dataHoraDeAgendamento;
    }

    public void setDataHoraDeAgendamento(Date dataHoraDeAgendamento) {
        this.dataHoraDeAgendamento = dataHoraDeAgendamento;
    }

    public String getStatusAgendamento() {
        return statusAgendamento;
    }

    public void setStatusAgendamento(String statusAgendamento) {
        this.statusAgendamento = statusAgendamento;
    }

    public Date getHoraDeInicio() {
        return horaDeInicio;
    }

    public void setHoraDeInicio(Date horaDeInicio) {
        this.horaDeInicio = horaDeInicio;
    }

    public Date getHoraDeFim() {
        return horaDeFim;
    }

    public void setHoraDeFim(Date horaDeFim) {
        this.horaDeFim = horaDeFim;
    }

    public Date getDataDaAgenda() {
        return dataDaAgenda;
    }

    public void setDataDaAgenda(Date dataDaAgenda) {
        this.dataDaAgenda = dataDaAgenda;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
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
