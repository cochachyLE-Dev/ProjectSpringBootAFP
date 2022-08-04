package pe.com.bootcamp.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import com.google.gson.Gson;

import pe.com.bootcamp.domain.entities.AuthenticationResponse;
import pe.com.bootcamp.domain.entities.Person.CreateRequest;
import pe.com.bootcamp.domain.entities.Person.CreateResponse;
import pe.com.bootcamp.domain.entities.Person.DeleteByIdentNumberResponse;
import pe.com.bootcamp.domain.entities.Person.FindAllResponse;
import pe.com.bootcamp.domain.entities.Person.FindByIdentNumberResponse;
import pe.com.bootcamp.domain.entities.Person.UpdateRequest;
import pe.com.bootcamp.domain.entities.Person.UpdateResponse;

public class AFPClientService implements IAFPClientService {

	private String ApiHost = "http://localhost:8084";
	
	@Override
	public AuthenticationResponse Authorization(String user, String password) {
		
		AuthenticationResponse result = new AuthenticationResponse();
		try {
		    HttpClient client = HttpClient.newHttpClient();
	
		    HttpRequest request = HttpRequest.newBuilder()
		        .uri(URI.create(ApiHost + "/authenticate"))
		        .header("Content-Type", "application/json")
		        .header("Accept", "application/json")
		        .POST(HttpRequest.BodyPublishers.ofString(Serialize(user)))
		        .build();
	
		    CompletableFuture<HttpResponse<String>> completableFuture =
		        client.sendAsync(request, HttpResponse.BodyHandlers.ofString());
		    completableFuture
		        .thenApplyAsync(HttpResponse::headers)
		        .thenAcceptAsync(System.out::println);
		    
		    HttpResponse<String> response = completableFuture.join();
	
		    if(response.statusCode() == 200) {	    	
		    	result = Deserialize(response.body(),AuthenticationResponse.class);	    		 		    	
		    }
		}catch (Exception e) {
			result.setToken(null);
		}
		return result;
	}

	@Override
	public CreateResponse create(CreateRequest person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FindAllResponse findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FindByIdentNumberResponse findByIdentNumber(String identNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateResponse update(UpdateRequest person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteByIdentNumberResponse deleteByIdentNumber(String identNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	private static String Serialize(Object src) {
		return new Gson().toJson(src);
	}
	private static <T> T Deserialize(String data, Class<T> classOfT) {		
		return new Gson().fromJson(data, classOfT);
	}	
}
