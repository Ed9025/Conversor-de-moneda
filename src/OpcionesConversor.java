public class OpcionesConversor {
    public static String monedaBase(int opcion){
         return switch (opcion){
            case 1,3,5-> "USD";
            case 2->"ARS";
           case 4-> "BRL";
           case 6->"COP";
           default-> "Opción inválida";
       };
    }

    public static String MonedaAConvertir(int opcion){
        return switch (opcion){
            case 1-> "ARS";
            case 2,4,6->"USD";
            case 3-> "BRL";
            case 5->"COP";
            default-> "Opción inválida";
        };
    }
}
