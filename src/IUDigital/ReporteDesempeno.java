
package IUDigital;

import java.util.List;

public class ReporteDesempeno {
    private Empleado empleado;
    private double metric1;
    private double metric2;

    public ReporteDesempeno(Empleado empleado) {
        this.empleado = empleado;
        // Aquí inicializamos las métricas de alguna forma
        this.metric1 = calcularMetric1();
        this.metric2 = calcularMetric2();
    }

    private double calcularMetric1() {
        // Lógica para calcular la primera métrica
        return Math.random() * 100; // Placeholder para una métrica real
    }

    private double calcularMetric2() {
        // Lógica para calcular la segunda métrica
        return Math.random() * 100; // Placeholder para una métrica real
    }

    public String generarReporte() {
        return "Reporte de Desempeño\n" +
                "====================\n" +
                "Empleado: " + empleado.toString() + "\n" +
                "Métrica 1: " + metric1 + "\n" +
                "Métrica 2: " + metric2 + "\n";
    }

    // Método estático para generar reportes para todos los empleados de un departamento
    public static String generarReportePorDepartamento(Departamento departamento) {
        StringBuilder sb = new StringBuilder();
        for (Empleado emp : departamento.getEmpleados()) {
            ReporteDesempeno reporte = new ReporteDesempeno(emp);
            sb.append(reporte.generarReporte()).append("\n");
        }
        return sb.toString();
    }
}
