package model;

import exception.DadoInvalidoException;

public class Unidade extends Produto {

    private int qtdUnidade;

    public Unidade(int qtdUnidade, String codigo, String nome, String descricao, String categoria, Object empresa, double precoCusto, double preco, double precoAtacado, double qtdMinAtacado, double estoqueMinimo, boolean ativo) throws DadoInvalidoException {
        super(codigo, nome, descricao, categoria, empresa, precoCusto, preco, precoAtacado, qtdMinAtacado, estoqueMinimo, ativo);
        setQtdUnidade(qtdUnidade);
    }

    public int getQtdUnidade() {
        return qtdUnidade;
    }

    public void setQtdUnidade(int qtdUnidade) throws DadoInvalidoException {
        if (qtdUnidade < 0) {
            throw new DadoInvalidoException("Quantidade não pode ser negativa.");
        }
        this.qtdUnidade = qtdUnidade;
    }

    @Override
    public double getQuantidade() {
        return qtdUnidade;
    }

    @Override
    public void setQuantidade(double quantidade) throws DadoInvalidoException {
        if (quantidade != Math.floor(quantidade)) {
            throw new DadoInvalidoException("Produto vendido por unidade só aceita número inteiro.");
        }
        setQtdUnidade((int) quantidade);
    }

    @Override
    public String getUnidadeMedida() {
        return "UN";
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
