package br.edu.ifpb.iseries.repository;


import br.edu.ifpb.iseries.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.email = ?1")
    public Usuario findByEmail(String email);


}
