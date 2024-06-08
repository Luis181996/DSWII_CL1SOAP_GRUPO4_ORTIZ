package pe.edu.cibertec.DSWII_CL1SOAP_GRUPO4_ORTIZ.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entiy
@Setter
@Getter
@Table(name = "auto")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idautor;
    private String nomautor;
    private String apeautor;
    private Date fechnacautor;
}
