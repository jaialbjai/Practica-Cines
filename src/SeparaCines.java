 // package pruebas.p4.cines;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
// Estas líneas importan las clases necesarias del paquete java.io,
// que se utilizan para manejar la entrada y salida de datos.

public class SeparaCines {
    public static void main(String args[]){

        String fichero = args[0];
        // Se declara una variable fichero que almacena el nombre del archivo de entrada,
        // que se pasa como argumento al programa.

        FileReader fr = null;
        BufferedReader br = null;

        String linea;
        String[] parts = new String[100];

        String cabecera;
        FileWriter fw = null;
        // Se declaran variables para leer el archivo de entrada (fr y br),
        // para almacenar cada línea del archivo (linea),
        // para dividir cada línea en partes (parts),
        // para almacenar la cabecera del archivo (cabecera),
        // y para escribir en archivos de salida (fw).


        try{
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);

            cabecera = br.readLine();
            // Se crea un FileReader (fr) para leer el archivo especificado en fichero.
            // Luego, se crea un BufferedReader (br) para leer líneas de texto desde fr.
            // Se lee la primera línea del archivo y se almacena en cabecera.

            while ((linea = br.readLine()) != null){
                // Se inicia un bucle while que se ejecuta mientras hay líneas por leer en el archivo.
                parts = linea.split("#");
                // Se divide la línea actual en partes utilizando el carácter # como delimitador y se almacenan en el array parts.
                fw = new FileWriter(parts[0].trim()+".txt");
                // Se crea un FileWriter (fw) para escribir en un archivo con el nombre
                // especificado en la primera parte de la línea actual
                // (después de eliminar los espacios en blanco) con la extensión .txt.
                fw.write(cabecera+"\n");
                fw.write(linea);
                fw.close();
                // Se escribe la cabecera en el archivo de salida, seguida de la línea actual, y luego se cierra el archivo.
            } // Fin del bucle while.

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                br.close();
                fr.close();
            }catch(IOException e){
                e.printStackTrace();

                // Se captura cualquier excepción que ocurra durante la ejecución del programa y
                // se imprime el rastreo de la pila de la excepción. Además, se cierran los objetos BufferedReader
                // y FileReader en el bloque finally,
                // asegurando que se cierren correctamente incluso si ocurre una excepción durante la ejecución del programa.
            }

        }

    }
}
