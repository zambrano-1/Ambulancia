public class Ambulancia {
    private String id;
    private int recorridoTotal = 0;
    private int numeroRecorridos = 0;

    public Ambulancia(String id) {
        this.id = id;
    }

    public void agregarRecorrido(int distancia) {
        // Asegúrate de que no exceda los límites
        if (recorridoTotal + distancia <= 400 && numeroRecorridos < 8) {
            recorridoTotal += distancia;
            numeroRecorridos++;
        } else {
            System.out.println("Límite de recorrido alcanzado.");
        }
    }

    public int getRecorridoTotal() {
        return recorridoTotal;
    }

    public int getNumeroRecorridos() {
        return numeroRecorridos;
    }
}
