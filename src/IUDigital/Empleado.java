package IUDigital;
public class Empleado {
    private String nombre;
    private String id;
    private String tipo; // permanente o temporal

    public Empleado(String nombre, String id, String tipo) {
        this.nombre = nombre;
        this.id = id;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String mostrarInfo() {
        return "Empleado: " + nombre + ", ID: " + id + ", Tipo: " + tipo;
    }
}
