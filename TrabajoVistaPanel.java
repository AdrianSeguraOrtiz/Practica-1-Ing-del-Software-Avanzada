package trabajo;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;

public class TrabajoVistaPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lBaseDatos;
	private JComboBox <String> cBaseDatos;
	private JLabel lDatosId;
	private JComboBox <String> cDatosId;
	private JRadioButton rbProteinas;
	private JRadioButton rbNucleotidos;
	private JLabel lSelecciona;
	private JComboBox <String> cSecuencia;
	private JLabel lSecuencia;
	private JTextField tfPorcentaje;
	private JLabel lPorcentaje;
	private JButton bBuscar;
	private JTextArea taRes;
	private JScrollPane spRes;
	
	public TrabajoVistaPanel() {
		
		this.setBackground(new Color(246, 212, 255));
		
		JPanel p0 = new JPanel();
		p0.setBackground(Color.getHSBColor(0, 100, 100));
		p0.setLayout(new GridLayout( 2 , 1 ) ) ;
		
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
		
		JPanel p1 = new JPanel();
		p1.setBackground(Color.getHSBColor(0, 100, 100));
		p1.setLayout(new GridLayout( 3 , 1 ) ) ;
		
		lSelecciona = new JLabel("¿Qué quieres buscar?       ");
		
		rbProteinas = new JRadioButton("Proteínas");
		rbProteinas.setSelected(true);
		rbNucleotidos = new JRadioButton("Nucleótidos");
		rbNucleotidos.setSelected(false);
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rbProteinas);
		grupo.add(rbNucleotidos);
		rbProteinas.setBackground(Color.getHSBColor(0, 100, 100));
		rbNucleotidos.setBackground(Color.getHSBColor(0, 100, 100));
		
		p1.add(lSelecciona);
		p1.add(rbProteinas);
		p1.add(rbNucleotidos);
			
		JPanel p2 = new JPanel();
		p2.setBackground(Color.getHSBColor(0, 100, 100));
		p2.setLayout(new GridLayout( 2 , 1 ) ) ;
		
		lSecuencia = new JLabel("Introduce secuencia de búsqueda           ");
		
		cSecuencia = new JComboBox <String>();
		cSecuencia.setEditable(true);
		
		p2.add(lSecuencia);
		p2.add(cSecuencia);
		
		JPanel p3 = new JPanel();
		p3.setBackground(Color.getHSBColor(0, 100, 100));
		p3.setLayout(new GridLayout( 2 , 1 ) ) ;
		
		lPorcentaje = new JLabel("Introduce porcentaje (0.0 - 1.0)       " );
		
		tfPorcentaje = new JTextField ();
		
		p3.add(lPorcentaje);
		p3.add(tfPorcentaje);
		
		bBuscar = new JButton("Buscar");
				
		taRes = new JTextArea(30, 70);
		taRes.setEditable(false);
		taRes.setBackground(new Color (199, 254, 254));
		spRes = new JScrollPane(taRes);
		
		JPanel pRelleno1 = new JPanel();
		pRelleno1.setBackground(new Color(246, 212, 255));
		pRelleno1.setSize(20, 10);
		
		JPanel pRelleno2 = new JPanel();
		pRelleno2.setBackground(new Color(246, 212, 255));
		pRelleno2.setSize(20, 10);
		
		JPanel pRelleno3 = new JPanel();
		pRelleno3.setBackground(new Color(246, 212, 255));
		pRelleno3.setSize(20, 10);
		
		JPanel pRelleno4 = new JPanel();
		pRelleno4.setBackground(new Color(246, 212, 255));
		pRelleno4.setSize(20, 10);
		
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

	public JLabel getlSecuencia() {
		return lSecuencia;
	}
	
}
