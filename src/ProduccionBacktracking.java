import java.util.ArrayList;
import java.util.List;
/*
EXPLICACION DE COMO SE PLANTEO LA SOLUCION CON BACKTRACKING
 La estrategia que se utilizó para la solución del problema con backtracking fue la siguiente:

 primero se realizó un árbol de exploración con los estados posibles que se iban encontrando y si existía una posible poda para mejorar el rendimiento del algoritmo.
 Se llego a la conclusión que la poda consiste en que, si la suma de las piezas de las maquinas que se agregan a la posible solución, sobrepasa la cantidad de piezas
 totales a fabricar, quiere decir que ya no tiene sentido seguir probando por ahí.(adjuntamos una imagen del arbol de exploracion para ver los estados)

 Luego a la hora del código lo que se planteo fue tener en cuenta el llevar una suma de las piezas y que se vayan comparando con las piezas totales
 y con esto lográbamos la poda.

 Por otro lado, si las piezas totales eran iguales a la suma, entendíamos que era una posible solución parcial, entonces comparábamos si la solución parcial implicaba menos
 maquinas que la solución óptima que ya habíamos encontrado, de ser así entonces reemplazábamos la solución con solución parcial.

 Por último, para ir agregando las maquinas como posible solución, las recorrimos y tuvimos en cuenta el llevar un índice para no repetir combinaciones que eran innecesarias
 ya que se diferenciaban con otras por el orden de las maquinas, pero al final representaban lo misma, de esta manera conseguimos generar muchísimos menos estados para que
 el algoritmo tenga una menor complejidad computacional.

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

    public List<Maquina> solucion(){
        List<Maquina> solParcial =  new ArrayList<>();

        backtracking(solParcial,0,0);

        return solucion;
    }

    private void backtracking(List<Maquina>solParcial,int suma, int indice){
        this.estadosGenerados++;
        if(suma>this.piezasTotales){
            return;
        }

        if(suma==this.piezasTotales){
            if(solucion.isEmpty() || solucion.size()>solParcial.size()){
                solucion.clear();
                solucion.addAll(solParcial);
            }
            return;
        }


        for (int i = indice; i <maquinas.size() ; i++) {
            Maquina m = maquinas.get(i);

            solParcial.add(m);
            backtracking(solParcial,suma + m.getPiezas(),i);
            solParcial.removeLast();

        }

    }
}
