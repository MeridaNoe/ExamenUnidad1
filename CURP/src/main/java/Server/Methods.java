package Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Methods {
    public static String generate(String Nombre, String primer_Ape, String segundoApe,String sexo, String estado ,String anio, String mes, String dia) {

        char caracter_0 = primer_Ape.charAt(0);
        char caracter_1 = primer_Ape.charAt(1);
        char caracter_2 = segundoApe.charAt(0);
        char caracter_3 = Nombre.charAt(0);
        char cracter_4 = anio.charAt(2);
        char caracter_5 = anio.charAt(3);
        char caracter_6 = mes.charAt(0);
        char cracter_7 = mes.charAt(1);
        char caracter_8 = dia.charAt(0);
        char caracter_9 = dia.charAt(1);
        char caracter_10 = sexo.charAt(0);
        char caracter_11 = estado.charAt(0);
        char caracter_12 = estado.charAt(1);
        char caracter_13 = ' ';
        char caracter_14 = ' ';
        char caracter_15 = ' ';
        char[] ap1 = primer_Ape.toCharArray();
        for (int i = 1; i < ap1.length; i++) {
            String aux = ap1[i] + "";
            if (!aux.equals("a") && !aux.equals("e") && !aux.equals("i") && !aux.equals("o") && !aux.equals("u")){
                caracter_13 = aux.charAt(0);
                break;
            }
        }
        char[] ap2 = segundoApe.toCharArray();
        for (int i = 1; i < ap2.length; i++) {
            String aux = ap2[i] + "";
            if (!aux.equals("a") && !aux.equals("e") && !aux.equals("i") && !aux.equals("o") && !aux.equals("u")){
                caracter_14 = aux.charAt(0);
                break;
            }
        }
        char[] nom = Nombre.toCharArray();
        for (int i = 1; i < nom.length; i++) {
            String aux = nom[i] + "";
            if (!aux.equals("a") && !aux.equals("e") && !aux.equals("i") && !aux.equals("o") && !aux.equals("u")){
                caracter_15 = aux.charAt(0);
                break;
            }
        }
        Random random = new Random();
        String alAzar = "";
        String random1 = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String random2 = "0123456789";
        alAzar = random1.charAt(random.nextInt(random1.length())) + "" + random2.charAt(random.nextInt(random2.length()));

        String CURP = ""+
                Character.toUpperCase(caracter_0) + Character.toUpperCase(caracter_1) + Character.toUpperCase(caracter_2) +
                Character.toUpperCase(caracter_3) + Character.toUpperCase(cracter_4) + Character.toUpperCase(caracter_5) +
                Character.toUpperCase(caracter_6) + Character.toUpperCase(cracter_7) + Character.toUpperCase(caracter_8) +
                Character.toUpperCase(caracter_9) + Character.toUpperCase(caracter_10) + Character.toUpperCase(caracter_11)+
                Character.toUpperCase(caracter_12) + Character.toUpperCase(caracter_13) + Character.toUpperCase(caracter_14) +
                Character.toUpperCase(caracter_15) + alAzar;

        return CURP;
    }


}
