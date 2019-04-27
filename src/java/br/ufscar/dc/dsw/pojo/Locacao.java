/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufscar.dc.dsw.pojo;

import br.ufscar.dc.dsw.pojo.Locadora;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pedro
 */
@Entity
@Table(name = "LOCACAO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Locacao.findAll", query = "SELECT l FROM Locacao l")})
public class Locacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DATA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @JoinColumn(name = "CPF_CLIENTE", referencedColumnName = "CPF")
    @ManyToOne(optional = false)
    private String cpfCliente;
    @JoinColumn(name = "CNPJ_LOCADORA", referencedColumnName = "CNPJ")
    @ManyToOne(optional = false)
    private String cnpjLocadora;

    public Locacao() {
    }

    public Locacao(Integer id) {
        this.id = id;
    }

    public Locacao(Integer id, Date dataHora) {
        this.id = id;
        this.dataHora = dataHora;
    }
    
    public Locacao(Integer id, Date dataHora, String cpf, String cnpj) {
        this.id = id;
        this.dataHora = dataHora;
        this.cpfCliente = cpf;
        this.cnpjLocadora = cnpj;
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

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getCnpjLocadora() {
        return cnpjLocadora;
    }

    public void setCnpjLocadora(String cnpjLocadora) {
        this.cnpjLocadora = cnpjLocadora;
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
        return "br.ufscar.dc.dsw.model.Locacao[ id=" + id + " ]";
    }
    
}
