package org.acme.Repository;
import org.acme.Item;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemRepository implements PanacheRepositoryBase<Item, String>{
    
}