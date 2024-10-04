package IUDigital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {
    private Departamento dptoVentas;

    public MainGUI() {
        dptoVentas = new Departamento("Ventas");
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Gestión de Empleados");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JButton addButton = new JButton("Agregar empleado");
        JButton deleteButton = new JButton("Eliminar empleado");
        JButton showButton = new JButton("Mostrar empleados");
        JButton reportButton = new JButton("Generar reporte de desempeño");
        JButton exitButton = new JButton("Salir");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmployee();
            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEmployees();
            }
        });

        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateReport();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(showButton);
        panel.add(reportButton);
        panel.add(exitButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void addEmployee() {
        String nombre = JOptionPane.showInputDialog("Ingrese nombre del empleado:");
        String id = JOptionPane.showInputDialog("Ingrese ID del empleado:");
        String tipo = JOptionPane.showInputDialog("Ingrese tipo (Permanente/Temporal):");
        try {
            Empleado nuevoEmpleado = new Empleado(nombre, id, tipo);
            dptoVentas.agregarEmpleado(nuevoEmpleado);
            JOptionPane.showMessageDialog(null, "Empleado agregado.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar empleado: " + e.getMessage());
        }
    }

    private void deleteEmployee() {
        String idEliminar = JOptionPane.showInputDialog("Ingrese ID del empleado a eliminar:");
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
                JOptionPane.showMessageDialog(null, "Empleado eliminado.");
            } else {
                JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar empleado: " + e.getMessage());
        }
    }

    private void showEmployees() {
        JOptionPane.showMessageDialog(null, dptoVentas.mostrarEmpleados());
    }

    private void generateReport() {
        String idReporte = JOptionPane.showInputDialog("Ingrese ID del empleado para generar reporte:");
        Empleado empleado = null;
        for (Empleado emp : dptoVentas.getEmpleados()) {
            if (emp.getId().equals(idReporte)) {
                empleado = emp;
                break;
            }
        }
        if (empleado != null) {
            final ReporteDesempeno reporte = new ReporteDesempeno(empleado);
            JOptionPane.showMessageDialog(null, reporte.generarReporte());
        } else {
            JOptionPane.showMessageDialog(null, "Empleado no encontrado.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainGUI::new);
    }
}
