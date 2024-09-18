public class Main {
    public static void main(String[] args) {
        // Creación de empleados
        Empleado empleado1 = new Empleado("1", "Juan", "Perez");
        Empleado empleado2 = new Empleado("2", "Ana", "Gomez");
        Empleado empleado3 = new Empleado("3", "Luis", "Ramirez");
        Empleado empleado4 = new Empleado("4", "Maria", "Lopez");
        Empleado empleado5 = new Empleado("5", "Carlos", "Martinez");
        Empleado empleado6 = new Empleado("6", "Laura", "Diaz");

        // Creación del departamento
        Departamento departamento = new Departamento("D1", "Recursos Humanos");

        // Asignación de empleados al departamento (con límite de 5 empleados)
        departamento.agregarEmpleado(empleado1);
        departamento.agregarEmpleado(empleado2);
        departamento.agregarEmpleado(empleado3);
        departamento.agregarEmpleado(empleado4);
        departamento.agregarEmpleado(empleado5);

        // Intentar agregar un sexto empleado (sin lanzar excepción, solo imprimir mensaje)
        if (!departamento.agregarEmpleado(empleado6)) {
            System.out.println("No se pudo agregar al empleado " + empleado6.getNombre() + ": el departamento ya tiene el máximo de empleados.");
        }

        // Creación de reportes de desempeño
        ReporteDesempenio reporte1 = new ReporteDesempenio(empleado1, "Excelente", "Gran desempeño en el último trimestre.");
        ReporteDesempenio reporte2 = new ReporteDesempenio(empleado2, "Bueno", "Buen desempeño, pero con áreas de mejora.");

        // Imprimir información del departamento y reportes
        System.out.println(departamento);
        System.out.println(reporte1);
        System.out.println(reporte2);
    }
}
