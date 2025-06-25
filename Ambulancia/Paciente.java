public class Paciente extends Persona {
    private String id;

    public Paciente(String nombre, String apellido, String id) {
        super(nombre, apellido);
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
