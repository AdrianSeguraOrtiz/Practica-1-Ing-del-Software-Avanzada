package trabajo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JLabel;
import blast.BlastController;

public class TrabajoControlador implements ActionListener {

	private TrabajoVistaPanel tvp;
	
	public TrabajoControlador(TrabajoVistaPanel tvp) {
		this.tvp = tvp;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		tvp.reiniciarVentana();
		boolean todoCorrecto = true;
		
		String secuencia = "";
		try {
			secuencia = tvp.getcSecuencia().getSelectedItem().toString().toUpperCase();
		}
		catch (NullPointerException npe) {
			mostrarError("      Especifique la secuencia a buscar. ");
			tvp.coloreaErrorSecuencia();
			todoCorrecto = false;
		}		
		if (todoCorrecto & secuencia.equals("")) {
			mostrarError("      Especifique la secuencia a buscar. ");
			tvp.coloreaErrorSecuencia();
			todoCorrecto = false;
		}
		else if (! buscada(secuencia)) {
			tvp.getcSecuencia().addItem(secuencia);
		}
		
		String p = null;
		float porcentaje = -1;
		try {
			p = tvp.getTfPorcentaje().getText();
			porcentaje = Float.parseFloat(p);
		}
		catch (NumberFormatException nfe) {
			if (p.equals("")) {
				mostrarError("      Especifique el porcentaje. ");
			}
			else {
				mostrarError("      Formato del porcentaje inadecuado.");
			}
			tvp.coloreaErrorPorcentaje();
			todoCorrecto = false;
		}

		if (porcentaje != -1 & (porcentaje < 0 || porcentaje > 1)) {
			mostrarError("      Porcentaje fuera de rango.");
			tvp.coloreaErrorPorcentaje();
			todoCorrecto = false;
		}
		
		BlastController bCnt = new BlastController();
		String Res = "";
		
		if (tvp.getRbProteinas().isSelected() & todoCorrecto) {
			try{
				Res = bCnt.blastQuery('p', tvp.getcBaseDatos().getSelectedItem().toString(), 
						tvp.getcDatosId().getSelectedItem().toString(), porcentaje, secuencia);
				tvp.coloreaAciertoBusqueda();
			} 
			catch(Exception exc){
				mostrarError( "Error en la llamada: " + exc.toString());
				tvp.coloreaErrorBusqueda();
			}
		}
		else if (tvp.getRbNucleotidos().isSelected()) {
			Res = "La búsqueda de nucleótidos todavía no está implementada. ";
		}
		tvp.getTaRes().setText(Res);
	}
	
	private void mostrarError (String s) {
		JDialog d = new JDialog ();
		d.add(new JLabel (s));
		d.setSize(250, 100);
		d.setVisible(true);
	}

	private boolean buscada(String s) {
		boolean res = false;
		for (int i = 0; i < tvp.getcSecuencia().getItemCount(); i++) {
			if (tvp.getcSecuencia().getItemAt(i).equals(s)){
				res = true;
			}
		}
		return res;
	}
}
