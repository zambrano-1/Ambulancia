public class Ambulancia {
    private String id;
    private String conductorLicencia;

    public Ambulancia(String id, String conductorLicencia) {
        this.id = id;
        this.conductorLicencia = conductorLicencia;
    }

    public String getId() {
        return id;
    }

    public String getConductorLicencia() {
        return conductorLicencia;
    }
}
