package l4;

public class Criptografar {

    public static String criptografar(String mens) {
        char ascii;
        char x, y;
        int chave = 3;
        String frase = "";
        while (chave >= 26) {
            chave = chave - 26;
        }
        for (int i = 0; i < mens.length(); i++) {
            if (mens.charAt(i) >= 97 && mens.charAt(i) <= 122) {//letrans minusculas de acordo com a tabela ASCII
                if ((int) (mens.charAt(i) + chave) > 122) {
                    x = (char) (mens.charAt(i) + chave);
                    y = (char) (x - 122);
                    ascii = (char) (96 + y);
                    frase = frase + ascii;
                } else {
                    ascii = (char) (mens.charAt(i) + chave);
                    frase = frase + ascii;

                }
            }
            if (mens.charAt(i) >= 65 && mens.charAt(i) <= 90) {
                if (mens.charAt(i) + chave > 90) {
                    x = (char) (mens.charAt(i) + chave);
                    y = (char) (x - 90);
                    ascii = (char) (64 + y);
                    frase = frase + ascii;
                } else {
                    ascii = (char) (mens.charAt(i) + chave);
                    frase = frase + ascii;
                }
            }
        }
		return frase;
    }
}