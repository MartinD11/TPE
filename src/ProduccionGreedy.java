
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ProduccionGreedy {
    private int piezas;
    private LinkedList<Maquina> Solucion;
    private int CantMaquinas;
    private int estadosGenerados;

    public ProduccionGreedy(int piezas){
        this.piezas = piezas;
        this.Solucion = new LinkedList<Maquina>();
        this.CantMaquinas = 0;
        this.estadosGenerados=0;
    }
	/*
	  EXPLICACION DE COMO SE PLANTEO LA SOLUCION CON BACKTRACKING
      La estrategia que se utilizó para la solución del problema con greedy fue la siguiente:

    ORDENAMIENTO DE LAS MÁQUINAS:
    *primero lo que tuvimos en cuenta a la hora de plantear la solucion del problema, fue en que orden ibamos a ordenar las maquinas.
    decidimos que lo mejor, era ordenarlas de mayor a menor(por cantidad de piezas). ya que el objetivo es obtener la menor secuencia de maquinas y el arrancar con un numero
    alto, nos da mejores chances de obtener el resultado esperado.

    *luego de ordenar las maquinas de mayor a menor, declaramos una variable total la cual nos va a ayudar a llevar la cuenta de las piezas.
    al entrar al while lo que hacemos es preguntar por el indice para que no se exceda de los limites y preguntamos si aun no es solucion, el cual es un metodo que compara
    el total con la cantidad de piezas.
    mientras la condicion del while se cumpla, obtenemos una maquina y preguntamos en el if, si el nuevototal(nos sirve para dejar mas limpio el if) es menor/igual a la cantidad
    de piezas. de ser asi, se agrega la maquina al arreglo solucion y se actualiza el total

    *entonces por ultimo preguntamos si es solucion y de serlo, retornamos la lista solucion con las maquinas seleccionadas por el algortirmo. de lo contrario
    devolvemos una lista vacia, dando a entender que no se logro llegar a una solucion.

    NOTA:
    El algoritmo no garantiza encontrar solución en todos los casos, ya que no prueba todas las combinaciones posibles, sino que elige siempre la mejor opción "local" en cada paso.
    Sin embargo, es muy eficiente en tiempo y genera pocos estados, lo que lo hace ideal para casos en los que no se necesita una solución óptima garantizada.

	*/

    public LinkedList<Maquina> SolucionGreedy(List<Maquina> maquinas){
        Collections.sort(maquinas);
        int total = 0; // Total de capacidades de maquinas
        int indice=0;


        while(indice<maquinas.size() && !esSolucion(total)){
            //this.estadosGenerados++;
            Maquina maquina = maquinas.get(indice);

            int nuevoTotal= total+ maquina.getPiezas();

            if(nuevoTotal<=this.piezas){
                this.estadosGenerados++;
                Solucion.add(maquina);
                total += maquina.getPiezas();
                this.CantMaquinas++;

            }else{
                indice++;
            }
        }

        if(esSolucion(total)){ //Existe Solucion
            return this.Solucion;
        }else{
            return new LinkedList<>();
        }
    }

    public int getMetricas(){
        return this.CantMaquinas;
    }

    public int getEstadosGenerados(){
        return this.estadosGenerados;
    }

    public boolean esSolucion(int total){
        return this.piezas==total;
    }

    public int getPiezas() {
        return piezas;
    }
}
