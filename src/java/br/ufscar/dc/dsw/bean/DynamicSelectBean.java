package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.CidadeDAO;
import br.ufscar.dc.dsw.dao.EstadoDAO;
import br.ufscar.dc.dsw.pojo.Cidade;
import br.ufscar.dc.dsw.pojo.Estado;
import java.util.List;

public class DynamicSelectBean {

    public List<Estado> getEstados() {
        EstadoDAO dao = new EstadoDAO();
        return dao.getAll();
    }

    public List<Cidade> getCidadesPorEstado(String sigla) {
        EstadoDAO dao = new EstadoDAO();
        Estado estado = dao.getBySigla(sigla);
        return new CidadeDAO().getByEstado(estado);
    } 
}
