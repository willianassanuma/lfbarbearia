/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.tcc.lfbarbearia.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Terminal 150
 */
@Entity
@Table(name = "contasreceber")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contasreceber.findAll", query = "SELECT c FROM Contasreceber c")
    , @NamedQuery(name = "Contasreceber.findById", query = "SELECT c FROM Contasreceber c WHERE c.id = :id")
    , @NamedQuery(name = "Contasreceber.findByValor", query = "SELECT c FROM Contasreceber c WHERE c.valor = :valor")
    , @NamedQuery(name = "Contasreceber.findByDataRecebimento", query = "SELECT c FROM Contasreceber c WHERE c.dataRecebimento = :dataRecebimento")
    , @NamedQuery(name = "Contasreceber.findByStatus", query = "SELECT c FROM Contasreceber c WHERE c.status = :status")})
public class Contasreceber implements Serializable, InterfaceEntidades {

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
    @Column(name = "dataRecebimento")
    @Temporal(TemporalType.DATE)
    private Date dataRecebimento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "idAgenda", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Agenda idAgenda;

    public Contasreceber() {
    }

    public Contasreceber(Integer id) {
        this.id = id;
    }

    public Contasreceber(Integer id, float valor, Date dataRecebimento, String status) {
        this.id = id;
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
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

    public Date getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(Date dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Agenda getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Agenda idAgenda) {
        this.idAgenda = idAgenda;
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
        if (!(object instanceof Contasreceber)) {
            return false;
        }
        Contasreceber other = (Contasreceber) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.tcc.lfbarbearia.entidades.Contasreceber[ id=" + id + " ]";
    }
    
}
