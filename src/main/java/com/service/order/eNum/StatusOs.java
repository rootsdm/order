package com.service.order.eNum;

public enum StatusOs {

    ABERTA(0, "ABERTA"),

    EM_ANDAMENTO(1,"EM ANDAMENTO"),

    CONCLUIDA(2, "CONCLUIDA");

    private Integer cod;


    StatusOs(Integer cod, String descricao) {
        this.cod = cod;
    }

    public StatusOs getCod() {
       return toEnum(cod);
    }

    public static StatusOs toEnum(Integer cod){
        if (cod == null){
            return null;
        }
        for (StatusOs x : StatusOs.values()){
            if (cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("Status Os invalido: " + cod);
    }

}
