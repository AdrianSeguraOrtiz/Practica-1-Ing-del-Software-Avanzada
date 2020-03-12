package trabajo;

import java.awt.Color;
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
	
	public void actionPerformed(ActionEvent arg0) {
		
		tvp.getcSecuencia().setBackground(tvp.getcBaseDatos().getBackground());
		tvp.getTfPorcentaje().setBackground(Color.WHITE);
		tvp.getTaRes().setBackground(new Color (199, 254, 254));
		
		boolean todoCorrecto = true;
		
		String secuencia = "";
		JDialog dSecuencia = new JDialog ();
		dSecuencia.add(new JLabel ("      Especifique la secuencia a buscar. "));
		dSecuencia.setSize(250, 100);
		try {
			secuencia = tvp.getcSecuencia().getSelectedItem().toString().toUpperCase();
		}
		catch (NullPointerException npe) {
			dSecuencia.setVisible(true);
			tvp.getcSecuencia().setBackground(Color.PINK);
			tvp.getTaRes().setBackground(Color.PINK);
			todoCorrecto = false;
		}		
		if (secuencia.equals("")) {
			dSecuencia.setVisible(true);
			tvp.getcSecuencia().setBackground(Color.PINK);
			tvp.getTaRes().setBackground(Color.PINK);
			todoCorrecto = false;
		}
		else if (! buscada(secuencia)) {
			tvp.getcSecuencia().addItem(secuencia);
		}
		
		String p = null;
		float porcentaje = -1;
		JDialog dPorcentaje = new JDialog ();
		dPorcentaje.setSize(250, 100);
		try {
			p = tvp.getTfPorcentaje().getText();
			porcentaje = Float.parseFloat(p);
		}
		catch (NumberFormatException nfe) {
			if (p.equals("")) {
				dPorcentaje.add(new JLabel ("      Especifique el porcentaje. "));
				dPorcentaje.setVisible(true);
			}
			else {
				dPorcentaje.add(new JLabel ("      Formato del porcentaje inadecuado."));
				dPorcentaje.setVisible(true);
			}
			tvp.getTfPorcentaje().setBackground(Color.PINK);
			tvp.getTaRes().setBackground(Color.PINK);
			todoCorrecto = false;
		}
		
		if (porcentaje != -1 & (porcentaje < 0 || porcentaje > 1)) {
			dPorcentaje.add(new JLabel ("      Porcentaje fuera de rango."));
			dPorcentaje.setVisible(true);
			tvp.getTfPorcentaje().setBackground(Color.PINK);
			tvp.getTaRes().setBackground(Color.PINK);
			todoCorrecto = false;
		}
		
		BlastController bCnt = new BlastController();
		String Res = "";
		
		if (tvp.getRbProteinas().isSelected() & todoCorrecto) {
			try{
				Res = bCnt.blastQuery('p', tvp.getcBaseDatos().getSelectedItem().toString(), 
						tvp.getcDatosId().getSelectedItem().toString(), porcentaje, secuencia);
			} 
			catch(Exception exc){
				Res = "Error en la llamada: " + exc.toString();
			}
			tvp.getTaRes().setBackground(new Color (185, 255, 179));
		}
		else if (tvp.getRbNucleotidos().isSelected()) {
			Res = "La búsqueda de nucleótidos todavía no está implementada. ";
		}
		tvp.getTaRes().setText(Res);
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
