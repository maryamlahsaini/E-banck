
package ensa.com.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ensa.com.webservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindOpByNameAndNum_QNAME = new QName("http://controller.example.com/", "FindOpByNameAndNum");
    private final static QName _FindOpByNameAndNumResponse_QNAME = new QName("http://controller.example.com/", "FindOpByNameAndNumResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ensa.com.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindOpByNameAndNumResponse }
     * 
     */
    public FindOpByNameAndNumResponse createFindOpByNameAndNumResponse() {
        return new FindOpByNameAndNumResponse();
    }

    /**
     * Create an instance of {@link FindOpByNameAndNum }
     * 
     */
    public FindOpByNameAndNum createFindOpByNameAndNum() {
        return new FindOpByNameAndNum();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOpByNameAndNum }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.example.com/", name = "FindOpByNameAndNum")
    public JAXBElement<FindOpByNameAndNum> createFindOpByNameAndNum(FindOpByNameAndNum value) {
        return new JAXBElement<FindOpByNameAndNum>(_FindOpByNameAndNum_QNAME, FindOpByNameAndNum.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindOpByNameAndNumResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://controller.example.com/", name = "FindOpByNameAndNumResponse")
    public JAXBElement<FindOpByNameAndNumResponse> createFindOpByNameAndNumResponse(FindOpByNameAndNumResponse value) {
        return new JAXBElement<FindOpByNameAndNumResponse>(_FindOpByNameAndNumResponse_QNAME, FindOpByNameAndNumResponse.class, null, value);
    }

}
