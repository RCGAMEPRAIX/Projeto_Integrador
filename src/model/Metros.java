package model;

import exception.DadoInvalidoException;

public class Metros extends Produto {

    private double qtdMetros;

    public Metros(double qtdMetros, String codigo, String nome, String descricao, String categoria, Object empresa, double precoCusto, double preco, double precoAtacado, double qtdMinAtacado, double estoqueMinimo, boolean ativo) throws DadoInvalidoException {
        super(codigo, nome, descricao, categoria, empresa, precoCusto, preco, precoAtacado, qtdMinAtacado, estoqueMinimo, ativo);
        this.qtdMetros = qtdMetros;
    }

    public double getQtdMetros() {
        return qtdMetros;
    }

    public void getQtdMetros(double qtdMetros) throws DadoInvalidoException {
        if (qtdMetros < 0) {
            throw new DadoInvalidoException("Quantidade não pode ser negativa.");
        }
        this.qtdMetros = qtdMetros;
    }

    @Override
    public double getQuantidade() {
        return qtdMetros;
    }

    @Override
    public void setQuantidade(double quantidade) throws DadoInvalidoException {
        getQtdMetros(quantidade);
    }

    @Override
    public String getUnidadeMedida() {
        return "M";
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
