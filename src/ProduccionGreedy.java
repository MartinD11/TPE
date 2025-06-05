import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
