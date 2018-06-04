package mat.web.service;

import javax.ws.rs.GET; //import da biblioteca jersey
import javax.ws.rs.Path; //import da biblioteca jersey
import javax.ws.rs.Produces; //import da biblioteca jersey
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;


@Path("/PrincipalRestService") // o @path define a URI do recurso que nesse caso será /helloworld
public class Teste {
	
	@GET // utilizando apenas o verbo GET, ou seja, vou apenas ler o recurso
	@Path("/teste1")
	@Produces("text/plain") // define qual tipo MIME é retornado para o cliente
	public String exibir(){
		return "Hello World";
	}
	
	@GET
	@Path("/teste2")
	@Produces("text/plain")
	public String exibir2(){
		return "Matheus";
	}
	
}
   
