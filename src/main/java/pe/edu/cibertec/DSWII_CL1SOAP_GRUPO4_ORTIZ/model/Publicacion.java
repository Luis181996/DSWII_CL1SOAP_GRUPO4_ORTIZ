package pe.edu.cibertec.DSWII_CL1SOAP_GRUPO4_ORTIZ.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "publicacion")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpublicacion;
    private String titulo;
    private String resumen;
    private Date fechpublicacion;
    private Integer idautor;
}
