//
// Este archivo ha sido generado por Eclipse Implementation of JAXB v3.0.0 
// Visite https://eclipse-ee4j.github.io/jaxb-ri 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2024.06.08 a las 09:55:29 PM PET 
//


package pe.edu.cibertec.ws.objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="publicacion" type="{http://www.cibertec.edu.pe/ws/objects}publicacionws"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "publicacion"
})
@XmlRootElement(name = "getPublicacionResponse")
public class GetPublicacionResponse {

    @XmlElement(required = true)
    protected Publicacionws publicacion;

    /**
     * Obtiene el valor de la propiedad publicacion.
     * 
     * @return
     *     possible object is
     *     {@link Publicacionws }
     *     
     */
    public Publicacionws getPublicacion() {
        return publicacion;
    }

    /**
     * Define el valor de la propiedad publicacion.
     * 
     * @param value
     *     allowed object is
     *     {@link Publicacionws }
     *     
     */
    public void setPublicacion(Publicacionws value) {
        this.publicacion = value;
    }

}
