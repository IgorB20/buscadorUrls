/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package buscapadraoweb;

import buscaweb.CapturaRecursosWeb;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static java.util.Map.entry;
/**
 *
 * @author Santiago
 */
public class Main {

    // busca char em vetor e retorna indice
    public static int get_char_ref (char[] vet, char ref ){
        for (int i=0; i<vet.length; i++ ){
            if (vet[i] == ref){
                return i;
            }
        }
        return -1;
    }

    // busca string em vetor e retorna indice
    public static int get_string_ref (String[] vet, String ref ){
        for (int i=0; i<vet.length; i++ ){
            if (vet[i].equals(ref)){
                return i;
            }
        }
        return -1;
    }



    //retorna o próximo estado, dado o estado atual e o símbolo lido
    public static int proximo_estado(String[] alfabeto, int[][] matriz,int estado_atual,char simbolo){
        int simbol_indice = get_string_ref(alfabeto, String.valueOf(simbolo));
        if (simbol_indice != -1){
            return matriz[estado_atual][simbol_indice];
        }else{
            return -1;
        }
    }

    /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //instancia e usa objeto que captura código-fonte de páginas Web
        CapturaRecursosWeb crw = new CapturaRecursosWeb();
        crw.getListaRecursos().add("https://univali.br/");
        ArrayList<String> listaCodigos = crw.carregarRecursos();

        String codigoHTML = listaCodigos.get(0);

        //mapa do alfabeto
        // char[] alfabeto = new char[10];

        String[] ABC = {
                "a",
                "b",
                "c",
                "d",
                "e",
                "f",
                "g",
                "h",
                "i",
                "j",
                "k",
                "l",
                "m",
                "n",
                "o",
                "p",
                "q",
                "r",
                "s",
                "t",
                "u",
                "v",
                "w",
                "x",
                "y",
                "z",
                "0",
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9"
        };

        String[] alfabeto = {
                "a",
                "b",
                "c",
                "d",
                "e",
                "f",
                "g",
                "h",
                "i",
                "j",
                "k",
                "l",
                "m",
                "n",
                "o",
                "p",
                "q",
                "r",
                "s",
                "t",
                "u",
                "v",
                "w",
                "x",
                "y",
                "z",
                "A",
                "B",
                "C",
                "D",
                "E",
                "F",
                "G",
                "H",
                "I",
                "J",
                "K",
                "L",
                "M",
                "N",
                "O",
                "P",
                "Q",
                "R",
                "S",
                "T",
                "U",
                "V",
                "W",
                "X",
                "Y",
                "Z",
                "/",
                "-",
                ":",
                ".",
                "?",
                "&",
                "=",
                "_",
                "@",
                "+",
                ";",
                "%",
                "0",
                "1",
                "2",
                "3",
                "4",
                "5",
                "6",
                "7",
                "8",
                "9"
        };

        //mapa de estados
        String[] estados = {"q0", "q1", "q2", "q3", "q4", "q5", "q6", "q7", "q8", "q9", "q10", "q11", "q12"};

        String estado_inicial = "q0";

        //estados finais
        String[] estados_finais = {"q11", "q12"};

        //tabela de transição de AFD para reconhecimento números de dois dígitos
        int[][] matriz = new int[estados.length][alfabeto.length];

        //transições dos estados
        for(String estado : estados){
            int currentStateIndex = get_string_ref(estados, estado);

            switch (estado){
                case "q0":
                    for(String letra : alfabeto){
                        if(letra == "h"){
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = get_string_ref(estados, "q1");
                        }else{
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = -1;
                        }
                    }
                    break;
                case "q1":
                    for(String letra : alfabeto){
                        if(letra == "t"){
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = get_string_ref(estados, "q2");
                        }else{
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = -1;
                        }
                    }
                    break;

                case "q2":
                    for(String letra : alfabeto){
                        if(letra == "t"){
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = get_string_ref(estados, "q3");
                        }else{
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = -1;
                        }
                    }
                    break;

                case "q3":
                    for(String letra : alfabeto){
                        if(letra == "p"){
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = get_string_ref(estados, "q4");
                        }else{
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = -1;
                        }
                    }
                    break;

                case "q4":
                    for(String letra : alfabeto){
                        if(letra == "s"){
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = get_string_ref(estados, "q5");
                        }else if(letra == ":"){
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = get_string_ref(estados, "q6");
                        } else{
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = -1;
                        }
                    }
                    break;

                case "q5":
                    for(String letra : alfabeto){
                        if(letra == ":"){
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = get_string_ref(estados, "q6");
                        }else{
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = -1;
                        }
                    }
                    break;

                case "q6":
                    for(String letra : alfabeto){
                        if(letra == "/"){
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = get_string_ref(estados, "q7");
                        }else{
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = -1;
                        }
                    }
                    break;
                case "q7":
                    for(String letra : alfabeto){
                        if(letra == "/"){
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = get_string_ref(estados, "q8");
                        }else{
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = -1;
                        }
                    }
                    break;

                case "q8":
                    for(String letra : alfabeto){
                        if(java.util.Arrays.asList(ABC).indexOf(letra) > -1){
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = get_string_ref(estados, "q9");
                        }else{
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = -1;
                        }
                    }
                    break;

                case "q9":
                    for(String letra : alfabeto){
                        if(java.util.Arrays.asList(ABC).indexOf(letra) > -1){
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = get_string_ref(estados, "q9");
                        }else if(letra == "." || letra == "-"){
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = get_string_ref(estados, "q10");
                        } else{
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = -1;
                        }
                    }
                    break;

                case "q10":
                    for(String letra : alfabeto){
                        if(java.util.Arrays.asList(ABC).indexOf(letra) > -1){
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = get_string_ref(estados, "q11");
                        }else{
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = -1;
                        }
                    }
                    break;

                case "q11":
                    for(String letra : alfabeto){
                        if(java.util.Arrays.asList(ABC).indexOf(letra) > -1){
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = get_string_ref(estados, "q11");
                        }else if(letra == "." || letra == "-"){
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = get_string_ref(estados, "q10");
                        }else if(letra == "/"){
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = get_string_ref(estados, "q12");
                        } else{
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = -1;
                        }
                    }
                    break;

                case "q12":
                    for(String letra : alfabeto){
                        if(java.util.Arrays.asList(alfabeto).indexOf(letra) > -1){
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = get_string_ref(estados, "q12");
                        }else{
                            matriz[currentStateIndex][get_string_ref(alfabeto, letra)] = -1;
                        }
                    }
                    break;
            }

        }

        int estado = get_string_ref (estados, estado_inicial);
        int estado_anterior = -1;
        ArrayList<String> palavras_reconhecidas = new ArrayList();

        String palavra = "";

        //varre o código-fonte de um código
        for (int i=0; i<codigoHTML.length(); i++){

            estado_anterior = estado;
            estado = proximo_estado(alfabeto, matriz, estado, codigoHTML.charAt(i));
            //se o não há transição
            if (estado == -1){
                //pega estado inicial
                estado = get_string_ref(estados, estado_inicial);
                // se o estado anterior foi um estado final
                if (get_string_ref(estados_finais, estados[estado_anterior]) != -1){
                    //se a palavra não é vazia adiciona palavra reconhecida
                    if ( ! palavra.equals("")){
                        palavras_reconhecidas.add(palavra);
                    }
                    // se ao analisar este caracter não houve transição
                    // teste-o novamente, considerando que o estado seja inicial
                    i--;
                }
                //zera palavra
                palavra = "";

            }else{
                //se houver transição válida, adiciona caracter a palavra
                palavra += codigoHTML.charAt(i);
            }
        }


        //foreach no Java para exibir todas as palavras reconhecidas
        for (String p: palavras_reconhecidas){
            System.out.println (p);
        }


    }



}
