package classes;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class RequisicaoHttp {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

		String url = "https://imdb-api.com/en/API/Top250Movies/k_cf2mpflg";
		new RequisicaoHttp(url);

	}

	public RequisicaoHttp(String url) {
		String retorno;
		HttpRequest request = null;
		HttpResponse<String> reponse = null;
		try {
			request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();

			HttpClient httpClient = HttpClient.newHttpClient();
			reponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String json = reponse.body();
//		String [] movieArray = json; 
		System.out.println(json);
	}
}
