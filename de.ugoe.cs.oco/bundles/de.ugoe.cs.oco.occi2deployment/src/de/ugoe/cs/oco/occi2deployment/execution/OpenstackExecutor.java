package de.ugoe.cs.oco.occi2deployment.execution;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.occiware.clouddesigner.occi.Entity;

import de.ugoe.cs.oco.occi2deployment.Connection;
import de.ugoe.cs.oco.occi2deployment.provisioner.Provisioner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**An executor capable of performing requests to the Openstack API.
 * Required due to incompability of the OOI implementation and network management.
 * @author rockodell
 *
 */
public class OpenstackExecutor extends AbsExecutor {	

	/**Creates an executor for the Openstack API using the information in the passed Connection conn.
	 * @param conn
	 */
	public OpenstackExecutor(Connection conn) {
		this.connection = conn;
	}

	/**Creates a subnet for the network, whereby the attributes of the subnet
	 * is stored in the element parameter.
	 * @param id of the network the subnet is created for.
	 * @param element
	 */
	private void createSubnet(String id, EObject element) {
		HttpURLConnection conn = establishConnection("http://192.168.34.1:9696/v2.0/subnets",
				"POST", true, "application/json", this.connection.getToken());

		String input =	"{\"subnet\": "
				+ "{\"name\": \"" +((Entity) element).getTitle()+" subnet\","
				+ "\"network_id\": \"" + id
				+"\",\"ip_version\": 4,"
				+ "\"cidr\": \"192.68.0.0/24\","
				+ "\"dns_nameservers\": [\"8.8.8.8\"]}}";
		
		writeInput(conn, input);
		
		if(connectionSuccessful(conn)){
			log.debug("Rest resoibse: " + ((Entity) element).getTitle() + " " + getOutput(conn));
		}
		conn.disconnect();
	}

	@Override
	public void waitForActiveState(EObject extracted) {
		// TODO Auto-generated method stub
		log.info("Not Implemented Yet!");
	}

	@Override
	public String createToken(String user, String password, String project, String authenticationAdress) {
		// TODO Auto-generated method stub
		log.info("Not Implemented Yet!");
		return null;
	}

	@Override
	public void executePostOperation(EObject element) {
		Entity entity = (Entity) element;
		log.info("Execute Request POST: " + entity.getTitle());
		HttpURLConnection conn = establishConnection("http://192.168.34.1:9696/v2.0/networks",
				"POST", true, "application/json", this.connection.getToken());
		
		String input =	"{\"network\": "
				+ "{\"name\": \"" +((Entity) element).getTitle()
				+"\",\"admin_state_up\": true}}";
		writeInput(conn, input);
		
		if(connectionSuccessful(conn)){
			
			String id = extractIdFromOutput(getOutput(conn));
			//TO BE IMPROVED
			if(entity.getTitle().equals("stubNetwork")){
				Provisioner.stubId = id;
			}
			//TO BE IMPROVED
		    String[] swap = {entity.getId(), id};
		    if(entity.getTitle() == null){
		    	log.debug("ID Swap: "+entity.getKind().getTerm() + " Model ID: " + entity.getId() + " Actual ID: " + id);
		    }
		    else{
		    	log.debug("ID Swap: "+entity.getTitle()+ " Model ID: " + entity.getId() + " Actual ID: " + id);
		    }
		    connection.getIdSwapList().add(swap);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			createSubnet(id, element);
		}
		conn.disconnect();
	}

	/**Extracts the Id of the network from the output.
	 * @param output
	 * @return
	 */
	private String extractIdFromOutput(String output) {
		JSONParser parser = new JSONParser();
		try {
			JSONObject json = (JSONObject) parser.parse(output);
			return (String) ((JSONObject) json.get("network")).get("id");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return output.substring(output.lastIndexOf("id")+6, output.lastIndexOf("\", \"name"));
		return null;
	}

	@Override
	public void executeDeleteOperation(EObject element) {
		deleteAllPorts(element);
		Entity entity = (Entity) element;
		log.info("Execute Request DELETE: " + entity.getTitle());
		HttpURLConnection conn;
		if(entity.getTitle().equals("stubNetwork")){
			conn = establishConnection("http://192.168.34.1:9696/v2.0/networks/" + Provisioner.stubId,
					"DELETE", false, null, this.connection.getToken());
		}
		else{
			conn = establishConnection("http://192.168.34.1:9696/v2.0/networks/" + getActualId(entity, connection.getIdSwapList()),
				"DELETE", false, null, this.connection.getToken());
		}
		
		if(connectionSuccessful(conn)){
			this.connection.idSwapListRemove(entity);
		}
		conn.disconnect();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**Deletes all ports from the passed element in the cloud in order to allow for a clean deletion
	 * of the network entity. Should be moved to the deprovisioner class as soon as OOI network management
	 * is possible.
	 * @param element
	 */
	private void deleteAllPorts(EObject element) {
		HttpURLConnection conn = establishConnection("http://192.168.34.1:9696/v2.0/ports?fields=id",
				"GET", false, null, this.connection.getToken());
		if(connectionSuccessful(conn)){
			List<String> ports = extractPortIdsFromOutput(getOutput(conn));
			for(String port: ports){
				HttpURLConnection conn2 = establishConnection("http://192.168.34.1:9696/v2.0/ports/" + port
						+ "?fields=network_id", "GET", false, null, this.connection.getToken());
				if(connectionSuccessful(conn2)){
					String networkId =extractNwIdFromOutput(getOutput(conn2));
					if(networkId.equals(getActualId((Entity) element, connection.getIdSwapList())) ||
							networkId.equals(Provisioner.stubId)){
						log.info("Delete Port Of:" + ((Entity) element).getTitle());
						HttpURLConnection conn3 = establishConnection("http://192.168.34.1:9696/v2.0/ports/" + port,
								"DELETE", false, null, this.connection.getToken());
						connectionSuccessful(conn3);
						conn3.disconnect();
					}
				}
				conn2.disconnect();
			}
		}
		conn.disconnect();
	}

	/**Extracts and returns network ID from the output string. Should be changed so
	 * that the output is treated as json object.
	 * @param output
	 * @return
	 */
	private String extractNwIdFromOutput(String output) {
		return output.substring(output.lastIndexOf("id")+6, output.lastIndexOf("\"}"));
	}

	/**Extracts and returns port IDs from the output string. Should be changed so
	 * that the output is treated as json object.
	 * @param output
	 * @return
	 */
	private List<String> extractPortIdsFromOutput(String output) {
		List<String> ports = new ArrayList<String>();
		while(output.contains("id")){
			ports.add(output.substring(output.indexOf("id")+6, output.indexOf("\"}")));
			output = output.substring(output.indexOf("\"}")+1);
		}
		return ports;
	}

	@Override
	public void executePutOperation(EObject entity) {
		// TODO Auto-generated method stub
		
	}
}


