package pe.edu.cibertec.DSWII_CL1SOAP_GRUPO4_ORTIZ.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_CL1SOAP_GRUPO4_ORTIZ.convert.AutorConvert;
import pe.edu.cibertec.DSWII_CL1SOAP_GRUPO4_ORTIZ.repository.AutorRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AutorService implements IAutorService{

    private AutorRepository autorRepository;
    private AutorConvert autorConvert;
    @Override
    public List<Autorws> listarAutores() {
        return autorConvert.convertAutorToAutorWs(
                autorRepository.findAll());
    }

    @Override
    public Autorws obtenerAutorxId(int id) {
        Optional<Autor> autor = autorRepository.findById(id);
        return autor.map(value ->
                        autorConvert.convertAutorToAutorWs(value))
                .orElse(null);
    }

    @Override
    public Autorws registrarActualizarAutor(Autorws autor) {
        Autor nuevoAutor = AutorRepository.save(
                AutorConvert.convertAutorToAutorWs(autorws));
        if(nuevoAutor == null)
            return  null;
        return autorConvert.convertAutorToAutorWs(nuevoAutor);
    }
}
