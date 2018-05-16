package br.com.ems.avaliacao.rest.itauRest.utils;

public enum EnumTipoCartao {
	CREDITO(2),DEBITO(1);

    private int tipo;
    EnumTipoCartao(int tipo) {
        this.tipo = tipo;
    }

    public int getPoints(){
        return tipo;
    }
}
