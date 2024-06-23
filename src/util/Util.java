package util;

import java.util.Scanner;

public class Util {

    /**
     * Metodo para "limpar" o console
     */
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Faz o sistema esperar os segundos informados no parametro.
     * @param segundos
     */
    public static void esperar(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {

        }
    }

    /**
     * Para o fluxo para exibição no console.
     * @param text
     */
    public static void paraFluxo(String text){
        System.out.print("\n\nPressione enter para " + text);
        new Scanner(System.in).nextLine();
        clear();
    }
}
