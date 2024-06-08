package pe.edu.cibertec.DSWII_CL1SOAP_GRUPO4_ORTIZ.endpoint;

import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import pe.edu.cibertec.DSWII_CL1SOAP_GRUPO4_ORTIZ.service.AutorService;

@AllArgsConstructor
@Endpoint
public class AutorEndPoint {

    private AutorService autorService;
    private static final String NAMESPACE_URL = "http://www.cibertec.edu.pe/ws/objects";

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getAutoresRequest")
    @ResponsePayload
    public GetAutorResponse getAutores(@RequestPayload
                                       GetAutorRequest request) {
        GetAutorResponse response = new GetAutorResponse();
        response.getAutores().addAll(autorService.listarAutores());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "getAutorRequest")
    @ResponsePayload
    public GetAutorResponse getAutor(@RequestPayload
                                             GetAutorRequest request){
        GetAutorResponse response = new GetAutorResponse();
        Autorws domiciliows = autorService.obtenerAutorxId(request.getId());
        if(domiciliows == null)
            throw new NotFoundException("El autor con el ID " + request.getId()+" no existe!");
        response.setAutor(domiciliows);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URL, localPart = "postAutorRequest")
    @ResponsePayload
    public PostAutorResponse saveAutor(@RequestPayload
                                               PostAutorRequest request){
        PostAutorResponse response = new PostAutorResponse();
        response.setAutor(autorService.registrarActualizarAutor(
                request.getAutor()));
        return response;
    }
}
