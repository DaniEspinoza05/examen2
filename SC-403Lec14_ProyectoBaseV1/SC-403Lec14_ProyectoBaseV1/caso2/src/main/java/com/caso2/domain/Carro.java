package com.caso2.domain;

import java.util.Date;
import lombok.Data;

@Data
public class Carro {    
    private int idCarro;
    private String descripcion;
    private int cilindros;
    private String modelo;

    public Carro() {
    }

    public Carro(int idCarro, String descripcion, int cilindros) {
        this.idCarro = idCarro;
        this.descripcion = descripcion;
        this.cilindros = cilindros;
        this.modelo = ""+(new Date());
    }
    
}
