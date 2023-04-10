/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import javax.swing.table.TableCellRenderer;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

class ProductUpdateButton extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, ActionListener {

    private JButton boton;
    private int fila;
    private JTable tabla;
    private JLabel etiqueta;
    private int selectedRow;
    private Object[][] data;

    public ProductUpdateButton(/*int selectedRow*/ Object[][] data) {
        boton = new JButton();
        //boton.addActionListener(this);
        //this.selectedRow = selectedRow;
        this.data = data;
        boton.addActionListener(this);
    }

    @Override
    public Object getCellEditorValue() {
        return true;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        Object[] rowdata = data[row];
        boton.setText("Actualizar " + rowdata[0]);
        
        String valorCadena = rowdata[0].toString(); // Convertir a cadena de texto
        int valorEntero = Integer.parseInt(valorCadena); 
        
        selectedRow = valorEntero;
        //int selectedId = (int) rowdata[0].getValueAt(tabla.getSelectedRow(), 0);
        if (isSelected) {
            
            
           /* etiqueta = new JLabel(valorEntero);
            add(etiqueta);*/
        UpdateProductView nuevaVentana = new UpdateProductView(selectedRow);
        nuevaVentana.setSize(400, 300);
        nuevaVentana.setVisible(true);
        
            
            
        /*boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tabla.getSelectedRow();
                if (filaSeleccionada != -1) {
                    int id = (int) tabla.getValueAt(filaSeleccionada, 0);
                    UpdateProductView nuevaVentana = new UpdateProductView(id);
                    nuevaVentana.setVisible(true);
                }
            }
        });*/
    
        };

    return boton;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        //System.out.print(boton);
        fila = row;
        tabla = table;
        return boton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Código para editar el registro seleccionado
        //int selectedId = (int) tabla.getValueAt(tabla.getSelectedRow(), 0);
       /* UpdateProductView nuevaVentana = new UpdateProductView();
        nuevaVentana.setSize(400, 300);
        nuevaVentana.setVisible(true);*/
    }

    private void add(int etiqueta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
