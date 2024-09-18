package IUDigital;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String id;
    private String nombre;
    private List<Empleado> empleados;
    private static final int MAX_EMPLEADOS = 6; // Límite de empleados por departamento

    public Departamento(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public boolean agregarEmpleado(Empleado empleado) {
        if (empleados.size() < MAX_EMPLEADOS) {
            empleados.add(empleado);
            empleado.setDepartamentoId(this.id);
            return true;  // Se agregó el empleado con éxito
        } else {
            return false; // No se puede agregar más empleados
        }
    }

    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
        empleado.setDepartamentoId(null);
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", empleados=" + empleados +
                '}';
    }
}
