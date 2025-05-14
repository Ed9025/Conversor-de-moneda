import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarRate {
    public RespuestaRate ObtenerRate(String base){
        String url = "https://v6.exchangerate-api.com/v6/e08e38c548377bcb0d47c3f8/latest/"+base;

        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            Gson gson = new Gson();
            RespuestaRate respuestaRate = gson.fromJson(json,RespuestaRate.class);
            return respuestaRate;
        } catch (Exception e) {
            System.out.println("No fue posible conectar con la API: "+e.getMessage());
            return null;
        }
    }
}
