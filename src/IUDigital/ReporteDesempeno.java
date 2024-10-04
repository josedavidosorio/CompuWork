package IUDigital;

public class ReporteDesempeno {
    private Empleado empleado;
    private double metric1;
    private double metric2;

    public ReporteDesempeno(Empleado empleado) {
        this.empleado = empleado;
        this.metric1 = calcularMetric1();
        this.metric2 = calcularMetric2();
    }

    private double calcularMetric1() {
        return Math.random() * 100;
    }

    private double calcularMetric2() {
        return Math.random() * 100;
    }

    public String generarReporte() {
        return "Reporte de Desempeño\n" +
                "====================\n" +
                "Empleado: " + empleado.toString() + "\n" +
                "Métrica 1: " + metric1 + "\n" +
                "Métrica 2: " + metric2 + "\n";
    }

    public static String generarReportePorDepartamento(Departamento departamento) {
        StringBuilder sb = new StringBuilder();
        for (Empleado emp : departamento.getEmpleados()) {
            ReporteDesempeno reporte = new ReporteDesempeno(emp);
            sb.append(reporte.generarReporte()).append("\n");
        }
        return sb.toString();
    }
}
