public class Maquina implements Comparable<Maquina> {
    String nombre;
    int piezas;

    public Maquina(String nombre, int piezas) {
        this.nombre = nombre;
        this.piezas = piezas;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPiezas() {
        return piezas;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int compareTo(Maquina o) {
        return o.getPiezas()-this.getPiezas();
    }
}
