package br.ufscar.dc.dsw.bean;

import br.ufscar.dc.dsw.dao.CidadeDAO;
import br.ufscar.dc.dsw.pojo.Cidade;
import java.util.List;

public class AutoCompleteBean {

    public List<Cidade> getCidadesPorNome(String nome) {
        CidadeDAO dao = new CidadeDAO();
        return dao.getByNome(nome);
    } 
}
