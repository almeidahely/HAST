package HAST;

public class Cargo {
    private int codigoCargo;
    private String nombreCargo;
    private Socio socio;

    public int getCodigoCargo() {
        return codigoCargo;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }

    public Cargo(int codigoCargo, String nombreCargo) {
        this.codigoCargo = codigoCargo;
        this.nombreCargo = nombreCargo;

    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
