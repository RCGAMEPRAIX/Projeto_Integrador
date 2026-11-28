package model;

import exception.DadoInvalidoException;
import exception.EstoqueInsuficienteException;

public abstract class Produto {

    private String codigo;
    private String nome;
    private String descricao;
    private String categoria;
    private Empresa empresa;
    private double precoCusto;
    private double preco;
    private double precoAtacado;
    private double qtdMinAtacado;
    private double estoqueMinimo;
    private boolean ativo = true;

    public Produto(String codigo, String nome, String descricao, String categoria, Empresa empresa,
            double precoCusto, double preco, double precoAtacado, double qtdMinAtacado,
            double estoqueMinimo, boolean ativo) throws DadoInvalidoException{
        setCodigo(codigo);
        setNome(nome);
        setDescricao(descricao);
        setCategoria(categoria);
        setEmpresa(empresa);
        setPrecoCusto(precoCusto);
        setPreco(preco);
        setPrecoAtacado(precoAtacado);
        setQtdMinAtacado(qtdMinAtacado);
        setEstoqueMinimo(estoqueMinimo);
    }

    public abstract double getQuantidade();

    public abstract void setQuantidade(double quantidade) throws DadoInvalidoException;

    public abstract String getUnidadeMedida();

    public void entrada(double qtd) throws DadoInvalidoException{
        if (qtd <= 0) {
            throw new DadoInvalidoException("A entrada não pode ser menor do que um.");
        }
        setQuantidade(getQuantidade() + qtd);
    }

    public void saida(double qtd) throws EstoqueInsuficienteException {
        if (qtd > getQuantidade()) {
            throw new EstoqueInsuficienteException("Estoque insuficiente para " + getNome() + ".", getQuantidade());
        }
        setQuantidade(getQuantidade() - qtd);
    }

    public double precoPara(double qtd) {
        if (qtd >= qtdMinAtacado && qtdMinAtacado > 0) {
            return qtd * precoAtacado;
        }
        return qtd * preco;
    }

    public boolean isAbaixoDoMinimo() {
        if (getQuantidade() <= estoqueMinimo) {
            return true;
        }
        return false;
    }

    public String getSituacaoEstoque() {
        if (getQuantidade() == 0){
            return "Sem estoque";
        } else if (isAbaixoDoMinimo()){
            return "Estoque baixo";
        }
        return "OK";
    }

    public String getQuantidadeFormatada() {
        return getQuantidade() + " " + getUnidadeMedida();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) throws DadoInvalidoException {
        if (codigo == null || codigo.trim().isEmpty() || codigo.contains(";")) {
            throw new DadoInvalidoException("Código não pode estar vazio ou conter ';'.");
        }
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws DadoInvalidoException {
        if (nome == null || nome.trim().isEmpty() || nome.contains(";")) {
            throw new DadoInvalidoException("Nome não pode estar vazio ou conter ';'");
        }
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) throws DadoInvalidoException{
        if (descricao.contains(";")){
            throw new DadoInvalidoException("Descrição não pode conter ';'.");
        }
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) throws DadoInvalidoException {
        if (categoria == null || categoria.trim().isEmpty() || categoria.contains(";")) {
            throw new DadoInvalidoException("Categoria não pode estar vazio ou conter ';'");
        }
        this.categoria = categoria;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) throws DadoInvalidoException {
        if (nome == null) {
            throw new DadoInvalidoException("Produto precisa estar ligado a uma empresa.");
        }
        this.empresa = empresa;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) throws DadoInvalidoException {
        if (precoCusto <= 0) {
            throw new DadoInvalidoException("Custo tem que ser maior que zero.");
        }
        this.precoCusto = precoCusto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) throws DadoInvalidoException {
        if (preco <= 0) {
            throw new DadoInvalidoException("Preço de venda tem que ser maior que zero.");
        }
        this.preco = preco;
    }

    public double getPrecoAtacado() {
        return precoAtacado;
    }

    public void setPrecoAtacado(double precoAtacado) throws DadoInvalidoException {
        if (precoAtacado < 0 || precoAtacado >= preco) {
            throw new DadoInvalidoException("Preço de atacado inválido.");
        }
        this.precoAtacado = precoAtacado;
    }

    public double getQtdMinAtacado() {
        return qtdMinAtacado;
    }

    public void setQtdMinAtacado(double qtdMinAtacado) throws DadoInvalidoException {
        if (qtdMinAtacado < 0 || qtdMinAtacado == 1) {
            throw new DadoInvalidoException("Quantidade mínima de atacado não pode ser menor que zero ou igual a um.");
        }
        this.qtdMinAtacado = qtdMinAtacado;
    }

    public double getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(double estoqueMinimo) throws DadoInvalidoException {
        if (estoqueMinimo <= 0) {
            throw new DadoInvalidoException("Estoque mínimo não pode ser menor do que zero.");
        }
        this.estoqueMinimo = estoqueMinimo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "\n=====PRODUTO====="
                + "\nCodigo: " + codigo
                + "\nNome: " + nome
                + "\nDescricao: " + descricao
                + "\nCategoria: " + categoria
                + "\nEmpresa=" + empresa
                + "\nPreco de custo: " + precoCusto
                + "\nPreco de venda: " + preco
                + "\nPreco atacado: " + precoAtacado
                + "\nQuantidade min. atacado: " + qtdMinAtacado
                + "\nEstoque minimo: " + estoqueMinimo
                + "\nAtivo: " + ativo;
    }

}
