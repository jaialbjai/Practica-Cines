 // package pruebas.p4.cines;

import java.io.*;


public class BuscaPelicula {
    public static void main (String args[]){

        String linea = new String();
        FileReader fr;
        BufferedReader br;

        String cabecera;
        String[] parts = new String [100];
        boolean encontrado = false;

        String pelicula = args[0].toUpperCase();
        String fichero = args[1];
        // Se declaran varias variables que se utilizarán en el programa:
        // linea, fr, br, cabecera, parts, encontrado, pelicula y fichero.
        // pelicula y fichero se inicializan con los argumentos pasados al programa en la línea de comandos,
        // y pelicula se convierte a mayúsculas para que la búsqueda sea insensible a mayúsculas y minúsculas.

        System.out.println ("La película " + pelicula + " se encuentra en los siguientes cines:");
        // Se imprime un mensaje indicando que se va a buscar la película especificada en los cines.

        try{
            fr = new FileReader (fichero);
            br = new BufferedReader(fr);
        // Se crea un FileReader (fr) para leer el contenido del archivo especificado en fichero,
        // y se envuelve en un BufferedReader (br) para leer líneas de texto de manera eficiente.

            cabecera = br.readLine();
           // Se lee la primera línea del archivo, que se asume que contiene la cabecera

            while ((linea = br.readLine())!=null){
                // Se inicia un bucle while que se ejecuta mientras haya más líneas en el archivo.
                parts = linea.split("#");
                // Se divide la línea actual en partes utilizando el caracter # como delimitador
                // y se almacena en el arreglo parts.

                if (parts[1].trim().toUpperCase().equals(pelicula)
                        || parts[2].trim().toUpperCase().equals(pelicula)
                        || parts[3].trim().toUpperCase().equals(pelicula)
                        || parts[4].trim().toUpperCase().equals(pelicula)){
                    encontrado = true;
                    System.out.println(parts[0].trim());
                    // Se compara cada parte de la línea con la película buscada (pelicula).
                    // Si alguna de las partes coincide con la película,
                    // se establece la variable encontrado en true y se imprime el nombre del cine (parts[0]).
                }

            }
            if (!encontrado){
                System.out.println("Película descatalogada");
            } // Después de salir del bucle, se verifica si la película fue encontrada en algún cine.
            // Si no se encontró, se imprime un mensaje indicando que la película está descatalogada.

        }
        catch(Exception ex){
            ex.printStackTrace();
        } // Se captura cualquier excepción que ocurra durante la ejecución del programa
        // y se imprime el rastreo de la pila de la excepción.
    }
}
