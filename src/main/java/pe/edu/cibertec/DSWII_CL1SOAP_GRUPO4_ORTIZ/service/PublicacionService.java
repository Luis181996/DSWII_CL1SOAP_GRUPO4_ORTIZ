package pe.edu.cibertec.DSWII_CL1SOAP_GRUPO4_ORTIZ.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_CL1SOAP_GRUPO4_ORTIZ.convert.PublicacionConvert;
import pe.edu.cibertec.DSWII_CL1SOAP_GRUPO4_ORTIZ.model.Publicacion;
import pe.edu.cibertec.DSWII_CL1SOAP_GRUPO4_ORTIZ.repository.PublicacionRepository;
import pe.edu.cibertec.ws.objects.Publicacionws;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PublicacionService implements IPublicacionService{

    private PublicacionRepository publicacionRepository;
    private PublicacionConvert publicacionConvert;
    @Override
    public List<Publicacionws> listarPublicaciones() {
        return publicacionConvert.convertPublicacionToPublicacionWs(
                publicacionRepository.findAll());
    }

    @Override
    public Publicacionws obtenerPublicacionxId(int id) {
        Optional<Publicacion> publicaciones = publicacionRepository.findById(id);
        return publicaciones.map(value ->
                        publicacionConvert.convertPublicacionToPublicacionWs(value))
                .orElse(null);
    }

    @Override
    public Publicacionws registrarActualizarPublicacion(Publicacionws publicacion) {
        Publicacion nuevoPublicacion = PublicacionRepository.save(
                PublicacionConvert.convertPublicacionToPublicacionWs(publicacionws));
        if(nuevoPublicacion == null)
            return  null;
        return publicacionConvert.convertPublicacionToPublicacionWs(publicacionws);
    }
}
