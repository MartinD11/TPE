import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* EXPLICACION DE COMO SE PLANTEO LA RESOLUCION CON GREEDY:
* A la hora de solucionar el problema mediante greedy pensamos en la mejor forma de ordenar las maquinas para que al momento de seleccionar los candidatos,
*  se pueda seleccionar la menor cantidad posibles de máquinas, por lo tanto, decidimos que la mejor manera era hacerlo ordenando a los candidatos(maquinas)
*  de mayor a menor (cantidad de piezas que producen).
   Luego recorrimos los candidatos e íbamos sumando la cantidad de piezas, si esta daba mayor la cantidad de piezas a fabricar, se descartaba el candidato
*  actual y pasábamos al siguiente y repetíamos al proceso hasta dar con la solución adecuada o tal vez no. En este caso que fue con el ejemplo que nos dieron
*  en la consigna, logramos llegar a una solución óptima como también se logro en backtracking y lo que si podemos notar es que se generan muchísimos menos
*  estados en greedy, teniendo una complejidad computacional mucho menor a backtracking como era de esperarse.
* */

public class ProduccionGreedy {
    private List<Maquina> maquinas;
    private int piezasTotales;
    private List<Maquina> solucion;
    private int estadosGenerados;

    public ProduccionGreedy(List<Maquina> maquinas, int piezasTotales ) {
        this.maquinas = maquinas;
        this.piezasTotales = piezasTotales;
        this.solucion = new ArrayList<>();
        this.estadosGenerados =0;
    }

    public int getEstadosGenerados() {
        return estadosGenerados;
    }

    public List<Maquina> solucionGreedy(){
        Collections.sort(maquinas);
        int sumaPiezas=0;

        while(sumaPiezas<piezasTotales && !maquinas.isEmpty()){
            this.estadosGenerados++;
            Maquina m = maquinas.get(0);
            if((sumaPiezas+m.getPiezas()) <= piezasTotales){
                solucion.add(m);
                sumaPiezas+=m.getPiezas();
            }else{
                maquinas.remove(m);
            }
        }

        if(sumaPiezas==piezasTotales){
            return solucion;
        }else{
            return null;
        }
    }

}
