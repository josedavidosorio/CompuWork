package IUDigital;
public class ReporteDesempeño {
    private Empleado empleado;
    private int desempeño; // valor de 1 a 100

    public ReporteDesempeño(Empleado empleado, int desempeño) throws Exception {
        if (desempeño < 1 || desempeño > 100) {
            throw new Exception("Desempeño debe estar entre 1 y 100");
        }
        this.empleado = empleado;
        this.desempeño = desempeño;
    }

    public String generarReporte() {
        return "Reporte de Desempeño para " + empleado.getNombre() + ": " + desempeño + "/100";
    }
}
