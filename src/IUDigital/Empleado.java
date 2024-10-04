package IUDigital;

public class Empleado {
    private String nombre;
    private String id;
    private String tipo;

    public Empleado(String nombre, String id, String tipo) {
        this.nombre = nombre;
        this.id = id;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
