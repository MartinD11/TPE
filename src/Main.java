import java.io.IOException;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        List<Maquina> maquinas = LectorArchivo.leerArchivo("maquinas.txt");
        int piezasTotales = LectorArchivo.piezasTotales;

        ProduccionBacktracking backtracking = new ProduccionBacktracking(maquinas, piezasTotales);
        List<Maquina> solucion = backtracking.solucion();

        System.out.println("Solución Backtracking:");
        if (solucion != null) {
            System.out.println();
            for (Maquina m : solucion) {
                System.out.print(m + " ");
            }
            System.out.println("\nActivaciones: " + solucion.size());
            System.out.println("\nEstados generados: " + backtracking.getEstadosGenerados());
        } else {
            System.out.println("No hay solución con backtracking.");
        }
    }
    }
