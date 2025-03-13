
import demo.model.core.services.CatalanClientDTO;
import demo.model.core.services.ClientDTO;
import demo.model.core.services.serializers.JacksonSerializer;
import demo.model.core.services.serializers.JacksonXMLSerializer;
import demo.model.core.services.serializers.Serializer;

public class serializerClientTest {

    public static void main(String[] args) throws Exception {
         ClientDTO a = new ClientDTO(
                     "83360554K",
                    "David",
                    "David@gmail.com",
                    "Carrer del Español",
                    654379103,
                    "9403759105739184",
                    "08850",
                    "Gava");

         CatalanClientDTO aCat = new CatalanClientDTO(
                     "83360554K",
                    "David",
                    "David@gmail.com",
                    "Carrer del Español",
                    654379103,
                    "9403759105739184",
                    "08850",
                    "Gava");


            
    try {
        Serializer formatter1 = new JacksonSerializer<>();
        String jclient = formatter1.serializer(a);
        System.out.println(jclient);

        ClientDTO copyClientDTO = (ClientDTO) formatter1.deserializer(jclient, ClientDTO.class);
        System.out.println(copyClientDTO);
      } catch (Exception var4) {
         System.out.println(var4.getMessage());
      }

      try{
         Serializer formatter = new JacksonXMLSerializer();
         String xmlString = formatter.serializer(a);
         System.out.println(xmlString);

         ClientDTO clientDTO = (ClientDTO) formatter.deserializer(xmlString, ClientDTO.class);
         System.out.println(clientDTO);
      } catch (Exception var4) {
         System.out.println(var4.getMessage());
      }


      try {
         Serializer formatterCat = new JacksonSerializer<>();
         String jclientCat = formatterCat.serializer(aCat);
         System.out.println(jclientCat);
 
         CatalanClientDTO copyClientDTOCat = (CatalanClientDTO) formatterCat.deserializer(jclientCat, CatalanClientDTO.class);
         System.out.println(copyClientDTOCat);
       } catch (Exception var4) {
          System.out.println(var4.getMessage());
       }

       try {
         Serializer formatterCatXML = new JacksonXMLSerializer();
         String XmlclientCat = formatterCatXML.serializer(aCat);
         System.out.println(XmlclientCat);
 
         CatalanClientDTO XMLClientDTOCat = (CatalanClientDTO) formatterCatXML.deserializer(XmlclientCat, CatalanClientDTO.class);
         System.out.println(XMLClientDTOCat);
       } catch (Exception var4) {
          System.out.println(var4.getMessage());
       }


    }


}
