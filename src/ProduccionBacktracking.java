import java.util.ArrayList;
import java.util.List;
/*
EXPLICACION DE COMO SE PLANTEO LA SOLUCION CON BACKTRACKING
 La estrategia que se utilizó para la solución del problema con backtracking fue la siguiente:

 La estrategia utilizada para resolver el problema con backtracking se basó en generar un árbol de exploración que recorra todos los posibles conjuntos de máquinas
 cuya suma de producción total sea igual a la cantidad de piezas a fabricar.

 1. PODAS:
    El algoritmo construye las combinaciones posibles de máquinas de forma recursiva.
    Para reducir la cantidad de estados explorados, se aplicaron dos podas:

    -si la suma acumulada de piezas supera la cantidad total a fabricar, no tiene sentido seguir explorando esa rama del árbol.

    -si ya existe una solución parcial guardada y la nueva combinación requiere igual o mayor cantidad de máquinas, se descarta.

 2. CRITERIO DE SOLUCIÓN:
    Si la suma acumulada de piezas es igual a la cantidad de piezas a fabricar, se considera que se encontró una solución válida.
    Luego, se compara contra la mejor solución encontrada hasta el momento:
    - Si es la primera solución, se guarda.
    - Si usa menos máquinas que la mejor guardada, se reemplaza.
    Este criterio asegura que se guarde la solución óptima en cuanto a menor cantidad de máquinas utilizadas.

 3. EVITAR COMBINACIONES REPETITIVAS:
    Para evitar explorar permutaciones equivalentes se incorpora un parámetro `indice` en la función recursiva.
    Esto asegura que se avance hacia adelante en la lista de máquinas y no se repitan combinaciones con distinto orden pero mismo contenido.

 4. RESULTADO:
    El resultado final es la lista de máquinas que suman exactamente la cantidad de piezas a fabricar, utilizando la menor cantidad de máquinas posible.


*/

public class ProduccionBacktracking {
    private List<Maquina> maquinas;
    private int piezasTotales;
    private List<Maquina> solucion;
    private int estadosGenerados;

    public ProduccionBacktracking(List<Maquina> maquinas, int piezasTotales) {
        this.maquinas = maquinas;
        this.piezasTotales = piezasTotales;
        this.solucion = new ArrayList<>();
        this.estadosGenerados=0;
    }

    public int getEstadosGenerados() {
        return estadosGenerados;
    }

    public int getPiezasTotales() {
        return piezasTotales;
    }

    public List<Maquina> solucion(){
        List<Maquina> solParcial =  new ArrayList<>();

        backtracking(solParcial,0,0);

        return solucion;
    }

    private void backtracking(List<Maquina>solParcial,int suma, int indice){
        this.estadosGenerados++;

        if(suma==this.piezasTotales){
            if(solucion.isEmpty() || solucion.size()>solParcial.size()){
                solucion.clear();
                solucion.addAll(solParcial);
            }

        }else{

            for (int i = indice; i < maquinas.size(); i++) {
                Maquina m = maquinas.get(i);
                int nuevaSuma=suma+m.getPiezas();

                if(nuevaSuma<=this.piezasTotales && (solucion.isEmpty() || solParcial.size()+1 < solucion.size())){
                    solParcial.add(m);
                    backtracking(solParcial, suma + m.getPiezas(), i);
                    solParcial.removeLast();
                }

            }

        }
    }
}
