package com.caso2.service;


import com.caso2.domain.Carro;
import java.util.ArrayList;
import java.util.List;

public interface CarroService {
    
    public List<Carro> listaCarros=new ArrayList<>();
    
    public List<Carro> getCarros();
    
    public void save(Carro carro);
    
    public void delete(Carro carro);
    
    public Carro getCarro(Carro carro);
    
}
