
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
	El algoritmo consiste en obtener una lista de maquinas cuya totalidad de produccion sea menor o igual a la cantidad de piezas a fabricar;
	Comienza ordenando la lista dadad por el usuario
	Selecciona la primera maquina de la lista cuya capacidad sea la mas alta. Luego comprueba que la capacidad de la maquina seleccionada sea menor o igual a la cantidad de piezas
	a fabricar, si es menor o igual y no supera la capidad total de maquinas en produccion se la agrega a la lista solucion

	Metricas: Cantidad de maquinas como posible resultado

	Consideraciones: Puede haber casos donde la totalidad de produccion de el conjunto solucion  tenga una diferencia considerable con la cantidad de piezas a fabricar:
	Por ejemplo: cant piezas a fabricar 12;
				 Lista de maquinas dada:
				 Maquina 1 <Capacidad 3>
				 Maquina 2 <Capacidad 2>
				 Maquina 3 <Capacidad 1>

				 Total solucion = M1 + M2 + M3 = 6;
				 Tenemos una diferencia de piezas sin fabricar de 6
	Consideramos que el algoritmo puede dar como valido un conjunto solucion menor a la cantidad de piezas a fabricar;


	*/

    public LinkedList<Maquina> SolucionGreedy(List<Maquina> maquinas){
        Collections.sort(maquinas);
        int total = 0; // Total de capacidades de maquinas
        while(!maquinas.isEmpty()){
            this.estadosGenerados++;
            Maquina maquina = maquinas.removeFirst();
            if(total + maquina.getPiezas() <= piezas){
                Solucion.add(maquina);
                total += maquina.getPiezas();
                this.CantMaquinas++;
            }
        }
        if(total <= piezas){ //Existe Solucion
            return this.Solucion;
        }else{
            return null;
        }
    }

    public int getMetricas(){
        return this.CantMaquinas;
    }

    public int getEstadosGenerados(){
        return this.estadosGenerados;
    }

}
