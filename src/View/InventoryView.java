/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import Controller.ProductController;
import javax.swing.JFrame;


import Model.ProductModel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class InventoryView extends javax.swing.JFrame {
    
    ArrayList<ProductModel> productList;
    
    public InventoryView() {
       
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(1112, 453);
       
       //initComponents();
       buildTable();
     
    }
  
    private void buildTable() {
		
	productList = consultProductsList();
		
	ArrayList<String> titlesList = new ArrayList<>();
		
		titlesList.add("ID");
		titlesList.add("Nombre");
		titlesList.add("Descripcion");
		titlesList.add("Cantidad en stock");
                titlesList.add("Unidad - Medida");
                titlesList.add("Fecha Caducidad");
                titlesList.add("Moficar");

				
		//se asignan las columnas al arreglo para enviarse al momento de construir la tabla
		String titles[] = new String[titlesList.size()];
                
		for (int i = 0; i < titles.length; i++) {
			titles[i] = titlesList.get(i);
		}
                
		/*obtenemos los datos de la lista y los guardamos en la matriz
		 * que luego se manda a construir la tabla
		 */
		Object[][] data = matrixData(titlesList);
                
		//creamos la tabla y enviamos la data
		DefaultTableModel model = new DefaultTableModel(data,titles);
                JTable table = new JTable(model);
                
                // crea un contenedor y agrega los componentes
                Container contentPane = getContentPane();
                contentPane.setLayout(new BorderLayout());
                contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
                //contentPane.add(searchField, BorderLayout.NORTH);

                // establece las propiedades del marco
                setSize(1000, 500);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);
                setVisible(true);
                
                table.getColumnModel().getColumn(6).setCellRenderer(new ProductUpdateButton(data));
               
    }


    private ArrayList<ProductModel> consultProductsList() {
        
        ProductController controller = new ProductController();
        
        ArrayList<ProductModel> product = controller.getProducts();
        
        return product;
    }
   
    private Object[][] matrixData(ArrayList<String> titlesList) {
                
	String informacion[][] = new String[productList.size()][titlesList.size()];
		
            for (int x = 0; x < informacion.length; x++) {
                        
		informacion[x][0] = productList.get(x).getId()+ "";
		informacion[x][1] = productList.get(x).getName()+ "";
		informacion[x][2] = productList.get(x).getDescription()+ "";
		informacion[x][3] = productList.get(x).getQuantityInStock()+ "";
                informacion[x][4] = productList.get(x).getMeasurementUnity()+ "";
                informacion[x][5] = productList.get(x).getDateExpiration()+ "";

            }
		
            return informacion;
	}
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 366, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InventoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryView().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
