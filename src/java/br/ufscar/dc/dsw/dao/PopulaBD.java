package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Cidade;
import br.ufscar.dc.dsw.pojo.Estado;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class PopulaBD {

    static Map<String, Estado> map = new HashMap<>();

    private static void populaEstados() {
        String line;
        InputStream stream = PopulaBD.class.getResourceAsStream("/estados.txt");
        InputStreamReader isr = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(isr);
        try {
            line = reader.readLine();

            EstadoDAO dao = new EstadoDAO();
            while (line != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");

                Estado estado = new Estado();
                String sigla = tokenizer.nextToken();
                estado.setSigla(sigla);
                estado.setNome(tokenizer.nextToken());
                dao.save(estado);

                map.put(sigla, estado);

                System.out.println("Salvo: " + estado);

                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void populaCidades() {

        String line;
        String nome;
        Estado estado;
        String sigla;

        InputStream stream = PopulaBD.class.getResourceAsStream("/cidades.txt");
        InputStreamReader isr = new InputStreamReader(stream);
        BufferedReader reader = new BufferedReader(isr);

        try {
            line = reader.readLine();
            CidadeDAO dao = new CidadeDAO();
            while (line != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                sigla = tokenizer.nextToken();
                sigla = sigla.substring(1, 3);
                nome = tokenizer.nextToken();
                nome = nome.substring(1, nome.length() - 1);
                estado = map.get(sigla);
                Cidade cidade = new Cidade();
                cidade.setNome(nome);
                cidade.setEstado(estado);
                dao.save(cidade);
                System.out.println("Salvo: " + cidade);
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        populaEstados();
        populaCidades();
    }
}
