import java.util.ArrayList;
import java.util.List;

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

//        for (Maquina m:this.maquinas){
//            solParcial.add(m);
//            backtracking(solParcial,suma + m.getPiezas());//genera 1189 estados
//            solParcial.removeLast();
//        }

        for (int i = indice; i <maquinas.size() ; i++) {
            Maquina m = maquinas.get(i);

            solParcial.add(m);
            backtracking(solParcial,suma + m.getPiezas(),i);
            //backtracking(solParcial,suma + m.getPiezas(),indice + i);
            solParcial.removeLast();

        }

    }
}
