package Client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.stream.Stream;


public class client {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        String modelo, marca, color,NoSerie;
        int opc = 0;

        while (opc != 3) {
            System.out.println("MENU");
            System.out.println("Seleccione una opción...");
            System.out.println("1. Registrar datos de una persona");
            System.out.println("2. Consultar datos  ");
            System.out.println("3. Salir");
            opc = s.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("REGISTRAR COCHE");
                    System.out.println("Coloca el Modelo del coche: ");
                    modelo = s.next();
                    System.out.println("Coloca la marca del coche:");
                    marca = s.next();
                    System.out.println("Coloca el color del coche:");
                    color = s.next();
                    System.out.println("Coloca el numero de serie:");
                    NoSerie = s.next();

                    //Ejecución del método en el servidor.
                    System.out.println("El coche es: "+marca+modelo+color+NoSerie);
                    Object [] data = {modelo, marca, color, NoSerie};
                    String response = (String) client.execute("Metodos.insertar", data);
                    System.out.println(response);
                    break;
                case 2:
                    System.out.println("Consultar datos del coche");
                    System.out.println("Coloca el Numero de Serie del coche que vas a buscar:");
                    String numero = s.next();

                    String query = "";
                    //Ejecución del método en el servidor.
                    Object[] data2 = {numero};
                    String response1 = (String) client.execute("Metodos.consulta", data2);
                    System.out.println(response1);
                    break;

                case 3:
                    System.out.println("Gracias por usar mi proyecto xd");
                    break;
                default:
                    System.err.println("Opcion invalida");
            }
        }


    }



}
