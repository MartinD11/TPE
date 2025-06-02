import java.io.*;
import java.util.*;

public class LectorArchivo {
    public static int piezasTotales;
    public static List<Maquina> leerArchivo(String ruta) throws IOException {
        List<Maquina> maquinas = new ArrayList<>();
        InputStream inputStream = LectorArchivo.class.getClassLoader().getResourceAsStream(ruta);
        if (inputStream == null) {
            throw new FileNotFoundException("No se encontró el archivo: " + ruta);
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        piezasTotales = Integer.parseInt(br.readLine().trim());

        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            String nombre = partes[0].trim();
            int piezas = Integer.parseInt(partes[1].trim());
            maquinas.add(new Maquina(nombre, piezas));
        }

        br.close();
        return maquinas;
    }
}

