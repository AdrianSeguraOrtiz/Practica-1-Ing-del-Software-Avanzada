package trabajo;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		tvp.getTaRes().setText(" ");
		
		boolean todoCorrecto = true;
		
		String secuencia = "";
		try {
			secuencia = tvp.getcSecuencia().getSelectedItem().toString().toUpperCase();
		}
		catch (NullPointerException npe) {
			tvp.getTaRes().setText("Especifique la secuencia a buscar. ");
			tvp.getcSecuencia().setBackground(Color.PINK);
			tvp.getTaRes().setBackground(Color.PINK);
			todoCorrecto = false;
		}		
		if (secuencia.equals("")) {
			tvp.getTaRes().setText("Especifique la secuencia a buscar. ");
			tvp.getcSecuencia().setBackground(Color.PINK);
			tvp.getTaRes().setBackground(Color.PINK);
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
				tvp.getTaRes().setText(tvp.getTaRes().getText() + "Especifique el porcentaje. ");
			}
			else {
				tvp.getTaRes().setText(tvp.getTaRes().getText() + "Formato del porcentaje inadecuado. ");
			}
			tvp.getTfPorcentaje().setBackground(Color.PINK);
			tvp.getTaRes().setBackground(Color.PINK);
			todoCorrecto = false;
		}
		
		if (porcentaje != -1 & (porcentaje < 0 || porcentaje > 1)) {
			tvp.getTaRes().setText(tvp.getTaRes().getText() + "Porcentaje fuera de rango. ");
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
		tvp.getTaRes().setText(tvp.getTaRes().getText() + Res);
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
