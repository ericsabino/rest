package br.com.ems.avaliacao.rest.itauRest.utils;

public enum EnumProduto {
	EMPRESTIMO(2),CONSIGNADO(1);
	
    private int tipo;
    EnumProduto(int tipo) {
        this.tipo = tipo;
    }

    public int getPoints(){
        return tipo;
    }
}
