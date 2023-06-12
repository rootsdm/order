package com.service.order.eNum;

public enum PrioridadeOs {
    BAIXA(0, "BAIXA"),

    MEDIA(1, "MEDIA"),

    ALTA(2, "ALTA");

    private Integer cod;
    private String descricao;

    PrioridadeOs(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static PrioridadeOs toEnum(Integer cod){
        if (cod == null){
            return null;
        }
        for (PrioridadeOs x : PrioridadeOs.values()){
            if (cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("Prioride Os invalida: " + cod);
    }
}
