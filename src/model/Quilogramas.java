package model;

import exception.DadoInvalidoException;

public class Quilogramas extends Produto {

    private double qtdQuilogramas;

    public Quilogramas(double qtdQuilogramas, String codigo, String nome, String descricao, String categoria, Object empresa, double precoCusto, double preco, double precoAtacado, double qtdMinAtacado, double estoqueMinimo, boolean ativo) throws DadoInvalidoException {
        super(codigo, nome, descricao, categoria, empresa, precoCusto, preco, precoAtacado, qtdMinAtacado, estoqueMinimo, ativo);
        setQtdQuilogramas(qtdQuilogramas);
    }

    public double getQtdQuilogramas() {
        return qtdQuilogramas;
    }

    public void setQtdQuilogramas(double qtdQuilogramas) throws DadoInvalidoException {
        if (qtdQuilogramas < 0) {
            throw new DadoInvalidoException("Quantidade não pode ser negativa.");
        }
        this.qtdQuilogramas = qtdQuilogramas;
    }

    @Override
    public double getQuantidade() {
        return qtdQuilogramas;
    }

    @Override
    public void setQuantidade(double quantidade) throws DadoInvalidoException {
        setQtdQuilogramas(quantidade);
    }

    @Override
    public String getUnidadeMedida() {
        return "KG";
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nQuantidade: "
                + getQuantidade()
                + " "
                + getUnidadeMedida()
                + ".";
    }
}
