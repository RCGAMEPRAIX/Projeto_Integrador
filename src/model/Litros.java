package model;

import exception.DadoInvalidoException;

public class Litros extends Produto {

    private double qtdLitros;

    public Litros(double qtdLitros, String codigo, String nome, String descricao, String categoria, Object empresa, double precoCusto, double preco, double precoAtacado, double qtdMinAtacado, double estoqueMinimo, boolean ativo) throws DadoInvalidoException {
        super(codigo, nome, descricao, categoria, empresa, precoCusto, preco, precoAtacado, qtdMinAtacado, estoqueMinimo, ativo);
        setQtdLitros(qtdLitros);
    }

    public double getQtdLitros() {
        return qtdLitros;
    }

    public void setQtdLitros(double qtdLitros) throws DadoInvalidoException {
        if (qtdLitros < 0) {
            throw new DadoInvalidoException("Quantidade não pode ser negativa.");
        }
        this.qtdLitros = qtdLitros;
    }

    @Override
    public double getQuantidade() {
        return qtdLitros;
    }

    @Override
    public void setQuantidade(double quantidade) throws DadoInvalidoException {
        setQtdLitros(quantidade);
    }

    @Override
    public String getUnidadeMedida() {
        return "L";
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
