public class Conductor extends Persona {
    private String licencia;

    public Conductor(String nombre, String apellido, String licencia) {
        super(nombre, apellido);
        this.licencia = licencia;
    }

    public String getLicencia() {
        return licencia;
    }
}
