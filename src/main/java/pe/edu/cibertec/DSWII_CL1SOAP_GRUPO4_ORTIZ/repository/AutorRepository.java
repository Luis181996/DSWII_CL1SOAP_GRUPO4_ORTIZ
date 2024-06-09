package pe.edu.cibertec.DSWII_CL1SOAP_GRUPO4_ORTIZ.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_CL1SOAP_GRUPO4_ORTIZ.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
