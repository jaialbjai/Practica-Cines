// package pruebas.p4.cines;

import java.io.*;
//Esta línea importa todas las clases del paquete java.io, que proporciona clases para manejar entrada y salida de datos.

public class Lectura {

    public static void main(String[] args) {
        ProcessBuilder pb;
        Process pr;

        ProcessBuilder pb2;
        Process pr2;
// Se declaran cuatro variables: pb, pr, pb2 y pr2

        BufferedReader reader = null;
        InputStreamReader isr = null;
        String pelicula;
// Se declaran variables para leer la entrada del usuario (reader y isr) y
// una variable pelicula para almacenar la película que el usuario desea buscar

        // Se inicia un bloque de código try, que manejará las excepciones que puedan ocurrir durante la ejecución del programa.
        try{
            System.out.print("Indique una película a buscar:");
            //Se imprime un mensaje solicitando al usuario que ingrese el nombre de una película.
            isr = new InputStreamReader(System.in);

            reader = new BufferedReader(isr);

            pelicula = reader.readLine();
            // Se crea un InputStreamReader (isr) para leer la entrada del usuario desde System.in.
            // Luego, se crea un BufferedReader (reader) para leer líneas de texto desde isr.
            // Finalmente, se lee la línea ingresada por el usuario y se almacena en la variable pelicula.

            System.out.println("\nSe separa en ficheros las películas...");
            // Se imprime un mensaje indicando que se están separando las películas en archivos.

            pb = new ProcessBuilder ("java", "src/SeparaCines.java", args[0]);
            // Se crea un ProcessBuilder (pb) para ejecutar un proceso que separará las películas en archivos.
            // Se especifica que se ejecutará el comando java con el archivo SeparaCines.java ubicado en la carpeta src.

            pb.redirectError(new File("errores.txt"));
            // Se redirigen los errores estándar del proceso a un archivo llamado errores.txt

            pr = pb.start();
            // Se inicia el proceso utilizando el ProcessBuilder pb.


            System.out.println("\nBuscando la película " + pelicula.toUpperCase() + "...");
            // Se imprime un mensaje indicando que se está buscando la película ingresada por el usuario.

            pb2 = new ProcessBuilder ("java", "src/BuscaPelicula.java", pelicula, args[0]);
            // Se crea otro ProcessBuilder (pb2) para ejecutar un proceso que buscará la película ingresada por el usuario.
            // Se especifica que se ejecutará el comando java con el archivo BuscaPelicula.java ubicado en la carpeta src,
            // y se pasa el nombre de la película como argumento.

            pb2.redirectError(new File("errores2.txt"));
            // Se redirigen los errores estándar del segundo proceso a un archivo llamado errores2.txt.

            pb2.redirectOutput(new File("salida2.txt"));
            // Se redirige la salida estándar del segundo proceso a un archivo llamado salida2.txt.

            pr2 = pb2.start();
            // Se inicia el segundo proceso utilizando el ProcessBuilder pb2.

            pr.waitFor();
            pr2.waitFor();
            // El programa espera a que ambos procesos finalicen su ejecución antes de continuar.
        } // Fin del bloque try

        catch (Exception ex){
            ex.printStackTrace();
            // Se captura cualquier excepción que ocurra durante la ejecución
            // del programa y se imprime el rastreo de la pila de la excepción.
        } // Fin del método main.

    } // Fin de la clase Lectura.

}
