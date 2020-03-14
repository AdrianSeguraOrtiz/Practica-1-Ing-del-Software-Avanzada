package trabajo;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.*;

public class TrabajoVistaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lBaseDatos;
	private JComboBox <String> cBaseDatos;
	private JLabel lDatosId;
	private JComboBox <String> cDatosId;
	private JLabel lSelecciona;
	private JRadioButton rbProteinas;
	private JRadioButton rbNucleotidos;
	private JLabel lSecuencia;
	private JComboBox <String> cSecuencia;
	private JLabel lPorcentaje;
	private JTextField tfPorcentaje;
	private JButton bBuscar;
	private JTextArea taRes;
	private JScrollPane spRes;

	private JPanel p0;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private JPanel pRelleno1;
	private JPanel pRelleno2;
	private JPanel pRelleno3;
	private JPanel pRelleno4;
	
	private static Color LILA_PASTEL = new Color (246, 212, 255);
	private static Color AMARILLO_PLATANO = Color.getHSBColor(0, 100, 100);
	private static Color CELESTE = new Color (199, 254, 254);
	private static Color VERDE_ACIERTO = new Color (185, 255, 179);
	
	public TrabajoVistaPanel() {
		
		p0 = new JPanel();
		p0.setLayout(new GridLayout( 2 , 2 ) ) ;
		
		lBaseDatos = new JLabel("Elije la base de datos:    ");
		cBaseDatos = new JComboBox <String> ();
		cBaseDatos.addItem("yeast.aa");
		
		lDatosId = new JLabel("Elije los identificadores:    ");
		cDatosId = new JComboBox <String> ();
		cDatosId.addItem("yeast.aa.indexs");
		
		p0.add(lBaseDatos);
		p0.add(cBaseDatos);
		p0.add(lDatosId);
		p0.add(cDatosId);
		
		p1 = new JPanel();
		p1.setLayout(new GridLayout( 3 , 1 ) ) ;
		
		lSelecciona = new JLabel("¿Qué quieres buscar?       ");
		
		rbProteinas = new JRadioButton("Proteínas");
		rbProteinas.setSelected(true);
		rbNucleotidos = new JRadioButton("Nucleótidos");
		rbNucleotidos.setSelected(false);
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rbProteinas);
		grupo.add(rbNucleotidos);
		
		p1.add(lSelecciona);
		p1.add(rbProteinas);
		p1.add(rbNucleotidos);
			
		p2 = new JPanel();
		p2.setLayout(new GridLayout( 2 , 1 ) ) ;
		
		lSecuencia = new JLabel("Introduce secuencia de búsqueda           ");
		
		cSecuencia = new JComboBox <String>();
		cSecuencia.setEditable(true);
		
		p2.add(lSecuencia);
		p2.add(cSecuencia);
		
		p3 = new JPanel();
		p3.setLayout(new GridLayout( 2 , 1 ) ) ;
		
		lPorcentaje = new JLabel("Introduce porcentaje (0.0 - 1.0)       " );
		
		tfPorcentaje = new JTextField ();
		
		p3.add(lPorcentaje);
		p3.add(tfPorcentaje);
		
		bBuscar = new JButton("Buscar");
				
		taRes = new JTextArea(30, 70);
		taRes.setEditable(false);
		spRes = new JScrollPane(taRes);
		
		pRelleno1 = new JPanel();
		pRelleno1.setSize(20, 10);
		
		pRelleno2 = new JPanel();
		pRelleno2.setSize(20, 10);
		
		pRelleno3 = new JPanel();
		pRelleno3.setSize(20, 10);
		
		pRelleno4 = new JPanel();
		pRelleno4.setSize(20, 10);
		
		iniciarColoresFondo();
		
		this.add(p0);
		this.add(pRelleno1);
		this.add(p1);
		this.add(pRelleno2);
		this.add(p2);
		this.add(pRelleno3);
		this.add(p3);
		this.add(pRelleno4);
		this.add(bBuscar);
		this.add(spRes);
	}
	
	public void iniciarColoresFondo() {
		Component elementosAmarillos [] = {p0, p1, rbProteinas, rbNucleotidos, p2, p3};
		ponerColor (elementosAmarillos, AMARILLO_PLATANO);
		
		Component elementosLilas [] = {pRelleno1, pRelleno2, pRelleno3, pRelleno4};
		ponerColor (elementosLilas, LILA_PASTEL);	
		this.setBackground(LILA_PASTEL);
		
		taRes.setBackground(CELESTE);
	}
	
	private void ponerColor (Component [] elementos, Color c) {
		for (Component e : elementos) {
			e.setBackground(c);
		}
	}
	
	public void reiniciarVentana() {
		cSecuencia.setBackground(cBaseDatos.getBackground());
		tfPorcentaje.setBackground(Color.WHITE);
		taRes.setBackground(CELESTE);
	}
	
	public void coloreaErrorSecuencia() {
		Component elementos [] = {taRes, cSecuencia};
		ponerColor(elementos, Color.PINK);
	}
	
	public void coloreaErrorPorcentaje() {
		Component elementos [] = {taRes, tfPorcentaje};
		ponerColor(elementos, Color.PINK);
	}
	
	public void coloreaAciertoBusqueda() {
		taRes.setBackground(VERDE_ACIERTO);
	}
	
	public void coloreaErrorBusqueda() {
		taRes.setBackground(Color.PINK);
	}

	public JRadioButton getRbProteinas() {
		return rbProteinas;
	}

	public JRadioButton getRbNucleotidos() {
		return rbNucleotidos;
	}

	public JComboBox<String> getcSecuencia() {
		return cSecuencia;
	}

	public JTextField getTfPorcentaje() {
		return tfPorcentaje;
	}

	public JButton getbBuscar() {
		return bBuscar;
	}

	public JTextArea getTaRes() {
		return taRes;
	}

	public JComboBox<String> getcBaseDatos() {
		return cBaseDatos;
	}

	public JComboBox<String> getcDatosId() {
		return cDatosId;
	}
	
}
