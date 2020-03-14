package trabajo;

import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import trabajo.TrabajoControlador;
import trabajo.TrabajoVistaPanel;

public class TrabajoPrincipal {
	public static void main(String[] args){
		Runnable rr = new Runnable(){
				public void run ( ) {
					
					JFrame ventana = new JFrame ("Ventana");
					
					TrabajoVistaPanel tvp = new TrabajoVistaPanel();
					TrabajoControlador tc = new TrabajoControlador(tvp);
					
					tvp.getbBuscar().addActionListener(tc);
					
					ventana.getContentPane().add(tvp);
					
					ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					ventana.pack();
					ventana.setExtendedState(Frame.MAXIMIZED_BOTH);
					ventana.setVisible(true);			
				}
		};
		SwingUtilities.invokeLater(rr);
	}
}
