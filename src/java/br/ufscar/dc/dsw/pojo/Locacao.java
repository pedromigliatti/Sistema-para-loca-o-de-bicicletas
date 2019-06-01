/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.pojo;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pedro
 */
@Entity
@Table(name = "LOCACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locacao.findAll", query = "SELECT l FROM Locacao l"),
    @NamedQuery(name = "Locacao.findById", query = "SELECT l FROM Locacao l WHERE l.id = :id"),
    @NamedQuery(name = "Locacao.findByDataHora", query = "SELECT l FROM Locacao l WHERE l.dataHora = :dataHora"),
    @NamedQuery(name = "Locacao.findByCliente", query = "SELECT l FROM Locacao l WHERE l.cpfclienteId = :cliente"),
    @NamedQuery(name = "Locacao.findByLocadora", query = "SELECT l FROM Locacao l WHERE l.cnpjlocadoraId = :locadora")})
public class Locacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "DATA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @JoinColumn(name = "CPFCLIENTE_ID", referencedColumnName = "ID")
    @ManyToOne
    private Cliente cpfclienteId;
    @JoinColumn(name = "CNPJLOCADORA_ID", referencedColumnName = "ID")
    @ManyToOne
    private Locadora cnpjlocadoraId;

    public Locacao() {
    }

    public Locacao(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Cliente getCpfclienteId() {
        return cpfclienteId;
    }

    public void setCpfclienteId(Cliente cpfclienteId) {
        this.cpfclienteId = cpfclienteId;
    }

    public Locadora getCnpjlocadoraId() {
        return cnpjlocadoraId;
    }

    public void setCnpjlocadoraId(Locadora cnpjlocadoraId) {
        this.cnpjlocadoraId = cnpjlocadoraId;
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
        if (!(object instanceof Locacao)) {
            return false;
        }
        Locacao other = (Locacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufscar.dc.dsw.pojo.Locacao[ id=" + id + " ]";
    }
    
}
