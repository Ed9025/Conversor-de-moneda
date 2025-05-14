import java.util.Map;

public record RespuestaRate(String base_code, Map<String,Double>conversion_rates) {
}
