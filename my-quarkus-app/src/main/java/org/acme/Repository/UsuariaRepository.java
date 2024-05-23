package org.acme.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.Usuaria;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class UsuariaRepository implements PanacheRepositoryBase<Usuaria, String> {
    
}