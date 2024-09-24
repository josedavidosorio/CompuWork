package IUDigital;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Departamento dptoVentas = new Departamento("Ventas");

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Eliminar empleado");
            System.out.println("3. Mostrar empleados");
            System.out.println("4. Generar reporte de desempeño");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Agregar empleado
                    System.out.print("Ingrese nombre del empleado: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese ID del empleado: ");
                    String id = scanner.nextLine();
                    System.out.print("Ingrese tipo (Permanente/Temporal): ");
                    String tipo = scanner.nextLine();
                    try {
                        Empleado nuevoEmpleado = new Empleado(nombre, id, tipo);
                        dptoVentas.agregarEmpleado(nuevoEmpleado);
                        System.out.println("Empleado agregado.");
                    } catch (Exception e) {
                        System.out.println("Error al agregar empleado: " + e.getMessage());
                    }
                    break;

                case 2:
                    // Eliminar empleado
                    System.out.print("Ingrese ID del empleado a eliminar: ");
                    String idEliminar = scanner.nextLine();
                    Empleado empleadoAEliminar = null;
                    for (Empleado emp : dptoVentas.getEmpleados()) {
                        if (emp.getId().equals(idEliminar)) {
                            empleadoAEliminar = emp;
                            break;
                        }
                    }
                    try {
                        if (empleadoAEliminar != null) {
                            dptoVentas.eliminarEmpleado(empleadoAEliminar);
                            System.out.println("Empleado eliminado.");
                        } else {
                            System.out.println("Empleado no encontrado.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al eliminar empleado: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Mostrar empleados
                    System.out.println(dptoVentas.mostrarEmpleados());
                    break;

                case 4:
                    // Generar reporte de desempeño
                    System.out.print("Ingrese ID del empleado para generar reporte: ");
                    String idReporte = scanner.nextLine();
                    Empleado empleadoReporte = null;
                    for (Empleado emp : dptoVentas.getEmpleados()) {
                        if (emp.getId().equals(idReporte)) {
                            empleadoReporte = emp;
                            break;
                        }
                    }
                    if (empleadoReporte != null) {
                        System.out.print("Ingrese desempeño (1-100): ");
                        int desempeño = scanner.nextInt();
                        try {
                            ReporteDesempeño reporte = new ReporteDesempeño(empleadoReporte, desempeño);
                            System.out.println(reporte.generarReporte());
                        } catch (Exception e) {
                            System.out.println("Error al generar reporte: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }
                    break;

                case 5:
                    // Salir
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
