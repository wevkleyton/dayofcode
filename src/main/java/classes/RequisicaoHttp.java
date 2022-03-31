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

		String url = "https://imdb-api.com/en/API/Top250Movies/KAY_URL";
		new RequisicaoHttp(url);

	}

	public RequisicaoHttp(String url) {
		String retorno;
		HttpRequest request = null;
		HttpResponse<String> reponse = null;
		try {
			request = HttpRequest.newBuilder().uri(new URI(url)).header("Content-Type", "text/plain;charset=UTF-8")
					.GET().build();

			HttpClient httpClient = HttpClient.newHttpClient();
			reponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<String> lista = new ArrayList<String>();
		lista.add(reponse.body());
		System.out.println(lista);
	}
}
