package HAST;

public class Cuota {

    private int codigoSocio;
    private String franjaEdad;
    private double precio;

    public Cuota(int codigoSocio, String franjaEdad, double precio) {
        this.codigoSocio = codigoSocio;
        this.franjaEdad = franjaEdad;
        this.precio = precio;
    }

    public int getCodigoSocio() {
        return codigoSocio;
    }

    public String getFranjaEdad() {
        return franjaEdad;
    }

    public double getPrecio() {
        return precio;
    }
}
