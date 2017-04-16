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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "agenda_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AgendaCliente.findAll", query = "SELECT a FROM AgendaCliente a")
    , @NamedQuery(name = "AgendaCliente.findByIdCliente", query = "SELECT a FROM AgendaCliente a WHERE a.agendaClientePK.idCliente = :idCliente")
    , @NamedQuery(name = "AgendaCliente.findByIdAgenda", query = "SELECT a FROM AgendaCliente a WHERE a.agendaClientePK.idAgenda = :idAgenda")
    , @NamedQuery(name = "AgendaCliente.findByHoraInicio", query = "SELECT a FROM AgendaCliente a WHERE a.horaInicio = :horaInicio")
    , @NamedQuery(name = "AgendaCliente.findByHoraFim", query = "SELECT a FROM AgendaCliente a WHERE a.horaFim = :horaFim")})
public class AgendaCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AgendaClientePK agendaClientePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaInicio")
    @Temporal(TemporalType.TIME)
    private Date horaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horaFim")
    @Temporal(TemporalType.TIME)
    private Date horaFim;
    @JoinColumn(name = "idCliente", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "idAgenda", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Agenda agenda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "agendaCliente")
    private Collection<Servico> servicoCollection;

    public AgendaCliente() {
    }

    public AgendaCliente(AgendaClientePK agendaClientePK) {
        this.agendaClientePK = agendaClientePK;
    }

    public AgendaCliente(AgendaClientePK agendaClientePK, Date horaInicio, Date horaFim) {
        this.agendaClientePK = agendaClientePK;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public AgendaCliente(int idCliente, int idAgenda) {
        this.agendaClientePK = new AgendaClientePK(idCliente, idAgenda);
    }

    public AgendaClientePK getAgendaClientePK() {
        return agendaClientePK;
    }

    public void setAgendaClientePK(AgendaClientePK agendaClientePK) {
        this.agendaClientePK = agendaClientePK;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    @XmlTransient
    public Collection<Servico> getServicoCollection() {
        return servicoCollection;
    }

    public void setServicoCollection(Collection<Servico> servicoCollection) {
        this.servicoCollection = servicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agendaClientePK != null ? agendaClientePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AgendaCliente)) {
            return false;
        }
        AgendaCliente other = (AgendaCliente) object;
        if ((this.agendaClientePK == null && other.agendaClientePK != null) || (this.agendaClientePK != null && !this.agendaClientePK.equals(other.agendaClientePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.tcc.lfbarbearia.entidades.AgendaCliente[ agendaClientePK=" + agendaClientePK + " ]";
    }
    
}
