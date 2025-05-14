import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversorMoneda {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

            String continuar= "si";
            while (continuar.equals("si")) {
                try{
                System.out.println("""
                        +++++++++++++++++++++++++++++++++++++++++++++++++
                                Bienvenido/a al conversor de monedas
                                Elija una opcion:
                                1) Dólar ====> Peso Argentino.
                                2) Peso Argentino====> Dólar.
                                3) Dólar====> Real Brasileño.
                                4) Real Brasileño====> Dólar.
                                5) Dólar====> Peso Colombiano.
                                6) Peso Colombiano====> Dólar.
                                7) Salir.
                        """);
                    int opcion = scanner.nextInt();
                    if(opcion==7){
                        System.out.println("Gracias por utilizar el programa, hasta luego...");
                        break;
                    }
                    String base= OpcionesConversor.monedaBase(opcion);
                    String target = OpcionesConversor.MonedaAConvertir(opcion);
                   if (base.equals(null)|| target.equals(null)) {
                        System.out.println("Opcion inválida, intente nuevamente");
                   } else {
                        System.out.println("Ingresa el valor que deseas convertir");
                        double cantidad = scanner.nextDouble();

                        ConsultarRate nuevaConsulta = new ConsultarRate();
                        RespuestaRate nuevaRespuesta = nuevaConsulta.ObtenerRate(base);
                       double tasa = nuevaRespuesta.conversion_rates().get(target);
                        double total = cantidad * tasa;
                        System.out.println("El valor de " + cantidad + " " + base + " corresponde al valor final de ==> " + total + " " + target);
                    }

                } catch (InputMismatchException e){
            System.out.println("Entrada inválida. Por favor, ingrese un número válido.\n");
            scanner.nextLine();
                }catch (Exception e){
                    System.out.println("Ocurrio un error " +e.getMessage());
                    scanner.nextLine();
                }

            }//fin while






    }
}
