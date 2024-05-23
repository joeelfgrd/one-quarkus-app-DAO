package org.acme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.acme.Repository.ItemRepository;
import org.acme.Repository.OrdenRepository;
import org.acme.Repository.UsuariaRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ServiceOlli {

    @Inject
    public UsuariaRepository usuariaRepo;

    @Inject
    public ItemRepository itemRepo;

    @Inject
    public OrdenRepository ordenRepo;

    public ServiceOlli() {}
    
    public Usuaria cargaUsuaria(String nombre) {
        Optional<Usuaria> usuaria = usuariaRepo.findByIdOptional(nombre);
        return usuaria.isPresent()? usuaria.get(): new Usuaria();
    }

    public Item cargaItem(String nombre) {
        Optional<Item> item = itemRepo.findByIdOptional(nombre);
        return item.isPresent()? item.get(): new Item();
    }

    public List<Orden> cargaOrden(String usuaria_nombre) {
        return ordenRepo.findByUserName(usuaria_nombre);
    }

@Transactional
    public Orden comanda(String usuaria_nombre, String item_nombre) {
        Orden orden = null;
        Optional<Usuaria> usuaria = usuariaRepo.findByIdOptional(usuaria_nombre);
        Optional<Item> item = itemRepo.findByIdOptional(item_nombre);
        if (usuaria.isPresent() && item.isPresent() 
            && usuaria.get().getDestreza() >= item.get().getQuality()) {
            orden = new Orden(usuaria.get(), item.get());
            ordenRepo.persist(orden);
        }
        return orden;
    }

   
    @Transactional
    public List<Orden> comandaMultiple(String usuaria, List<String> productos) {

        Optional<Usuaria> user = usuariaRepo.findByIdOptional(usuaria);
        if (user.isEmpty()) {
            return Collections.emptyList();
        }
        
        List<Orden> ordenes = new ArrayList<Orden>();

        Orden orden = null;
        for (String producto: productos) {
            orden = this.comanda(user.get().getNombre(), producto);
            if (orden != null) {
                ordenes.add(orden);
            }
        }
        return ordenes;      
    }
}