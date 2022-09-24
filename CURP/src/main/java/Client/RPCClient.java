package Client;

import Server.*;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class RPCClient {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws MalformedURLException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        int op;
        Scanner sc = new Scanner(System.in);

            System.out.println("CREACION DE CURP");
            System.out.println("\n ELIJA UNA OPCION");
            System.out.println("1. Matricular una persona");
            System.out.println("2. Consultar los datos de una persona");
            op = sc.nextInt();
            switch (op) {

                case 1:
                    System.out.println("Escriba su Nombre: ");
                    String Nombre = sc.next();
                    System.out.println("Escriba su Primer apellido: ");
                    String primer_Ape = sc.next();
                    System.out.println("Segundo apellido: ");
                    String segundo_Ape = sc.next();
                    System.out.println("Escriba tu Sexo: ");
                    String sexo = sc.next();
                    System.out.println("Escriba la CLave del Estado donde Provienes: " +
                            "Aguascalientes(AS)," +
                            "Baja California(BC)," +
                            "Baja California Sur(BS)," +
                            "Campeche (CC)," +
                            "Chiapas (CC)," +
                            "Chihuahua (CH)," +
                            "Ciudad de México (CDMX)," +
                            "Coahuila (CL)," +
                            "Colima (CM)," +
                            "Durango (DG)," +
                            "Guanajuato (GT)," +
                            "Guerrero (GR)," +
                            "Hidalgo (HG)," +
                            "Jalisco (JC)," +
                            "México(MX)," +
                            "Michoacán (MN)," +
                            "Morelos (MS)," +
                            "Nayarit (NT)," +
                            "Nuevo León (NL)," +
                            "Oaxaca (OC)," +
                            "Puebla (PL)," +
                            "Querétaro (QO)," +
                            "Quintana Roo (QR)," +
                            "San Luis Potosí (SP)," +
                            "Sinaloa (SL)," +
                            "Sonora (SR)," +
                            "Tabasco (TC)," +
                            "Tamaulipas (TS)," +
                            "Tlaxcala (TX)," +
                            "Veracruz (VZ)," +
                            "Yucatán (YC)," +
                            "Zacatecas (ZS).");

                    String estado = sc.next();
                    System.out.println("Escriba su año de nacimiento: ");
                    String anio = sc.next();
                    System.out.println("Escriba su Mes de nacimiento solo ds caracteres: ");
                    String mes = sc.next();
                    System.out.println("Escriba su dia de nacimiento solo dos caracteres: ");
                    String dia = sc.next();

                    String CURP = Methods.generate(Nombre, primer_Ape, segundo_Ape, sexo, estado, anio, mes, dia);
                    String Fecha_Nac = " " + dia + "-" + mes + "-" + anio;

                    System.out.println(CURP);

                    String SQL = "INSERT INTO Datos (Nombre, Primer_Ape, Segundo_Ape, Sexo, Estado_Nac, Fecha_Nac, CURP) values('" + CURP + "','" + Nombre + "','" + primer_Ape + "','" + segundo_Ape + "','" + sexo + "','" + estado + "','" + Fecha_Nac + "')";
                    Connection conn = null;

                    try {
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CURP", "root", "");
                        Statement statement = conn.createStatement();
                        int x = statement.executeUpdate(SQL);
                        if (x == 1) {
                            System.out.println("Exitosamente matriculdo");
                        } else
                            System.out.println("¿Que paso master?");
                        conn.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    System.out.println("CONUSLTAR SUS DATOS");
                    System.out.println("\nEscriba su CURP");
                    String curp = sc.next();

                    String SQL2 = "SELECT * FROM Datos where Nombre = '" + curp + "'";
                    try {
                        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CURP", "root", "");
                        Statement statement = conn.createStatement();
                        ResultSet rs = statement.executeQuery(SQL2);
                        while (rs.next()) {
                            String Nombre1 = rs.getString("Nombre");
                            String primer_Ape1 = rs.getString("Primer_Ape");
                            String segundo_Ape2 = rs.getString("Segundo_Ape");
                            String sexo1 = rs.getString("Sexo");
                            String estado1 = rs.getString("Estado_Nac");
                            String Fecha_Nac1 = rs.getString("Fecha_Nac");
                            String CURP1 = rs.getString("CURP");

                            System.out.format("%s, %s, %s, %s, %s, %s, %s", Nombre1, primer_Ape1, segundo_Ape2, sexo1, estado1, Fecha_Nac1, CURP1);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
            }



        }
    }

