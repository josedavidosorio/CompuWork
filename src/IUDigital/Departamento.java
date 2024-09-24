package IUDigital;
import java.util.ArrayList;

public class Departamento {
    private String nombre;
    private ArrayList<Empleado> empleados;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) throws Exception {
        if (empleado == null) {
            throw new Exception("Empleado no puede ser nulo");
        }
        empleados.add(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) throws Exception {
        if (!empleados.remove(empleado)) {
            throw new Exception("Empleado no encontrado en el departamento");
        }
    }

    public String mostrarEmpleados() {
        StringBuilder info = new StringBuilder("Departamento: " + nombre + "\nEmpleados:\n");
        for (Empleado emp : empleados) {
            info.append(emp.mostrarInfo()).append("\n");
        }
        return info.toString();
    }

	public Empleado[] getEmpleados() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getEmpleados'");
	}
}
