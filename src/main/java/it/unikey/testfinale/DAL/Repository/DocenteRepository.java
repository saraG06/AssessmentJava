package it.unikey.testfinale.DAL.Repository;

import it.unikey.testfinale.DAL.Entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {

    @Query(value= "SELECT * FROM docente d WHERE d.email LIKE :email", nativeQuery = true)
    Docente findByEmail(@Param("email") String email);
}
