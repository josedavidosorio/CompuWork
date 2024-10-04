package IUDigital;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nombre;
    private List<Empleado> empleados;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public String mostrarEmpleados() {
        StringBuilder sb = new StringBuilder("Empleados en " + nombre + ":\n");
        for (Empleado emp : empleados) {
            sb.append(emp).append("\n");
        }
        return sb.toString();
    }
}
