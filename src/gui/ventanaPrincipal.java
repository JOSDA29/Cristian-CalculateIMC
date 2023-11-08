package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import clases.Logica;
import clases.ModeladoDatos;
import objetos.PersonaVO;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class ventanaPrincipal implements ActionListener{

	public JFrame frame;
	private JTextField txtDocumento;
	private JTextField txtNombre;
	private JTextField txtEdad;
	private JTextField txtPeso;
	private JTextField txtTalla;
	private JScrollPane areaResultado;
	private JButton btnCalcularIMC;
	private JButton btnCalcularPromedio;
	private JButton btnRegistrar;
	private JButton btnListaPersonas;
	private JTextArea txtArea;
	
	Border bordeError = BorderFactory.createLineBorder(Color.red, 2);
	Border bordeCorrecto = BorderFactory.createLineBorder(Color.black, 2);

	Logica logica = new Logica();
	ModeladoDatos modeloDatos = new ModeladoDatos();
	
	public ventanaPrincipal() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 222, 179));
		frame.setBounds(100, 100, 818, 532);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel etiTitulo = new JLabel("CALCULO IMC");
		etiTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		etiTitulo.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 48));
		etiTitulo.setBounds(239, 40, 325, 32);
		frame.getContentPane().add(etiTitulo);
		
		JLabel lblDatosBasicos = new JLabel("Datos Basicos");
		lblDatosBasicos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDatosBasicos.setBounds(32, 91, 120, 25);
		frame.getContentPane().add(lblDatosBasicos);
		
		JLabel lblDatosIMC = new JLabel("Datos IMC");
		lblDatosIMC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDatosIMC.setBounds(32, 164, 120, 25);
		frame.getContentPane().add(lblDatosIMC);
		
		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDocumento.setBounds(32, 122, 82, 25);
		frame.getContentPane().add(lblDocumento);
		
		txtDocumento = new JTextField();
		txtDocumento.setBounds(116, 125, 106, 20);
		frame.getContentPane().add(txtDocumento);
		txtDocumento.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(244, 122, 82, 25);
		frame.getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(305, 125, 300, 20);
		frame.getContentPane().add(txtNombre);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEdad.setBounds(627, 122, 82, 25);
		frame.getContentPane().add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setColumns(10);
		txtEdad.setBounds(670, 125, 106, 20);
		frame.getContentPane().add(txtEdad);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPeso.setBounds(32, 197, 82, 25);
		frame.getContentPane().add(lblPeso);
		
		txtPeso = new JTextField();
		txtPeso.setColumns(10);
		txtPeso.setBounds(116, 200, 106, 20);
		frame.getContentPane().add(txtPeso);
		
		txtTalla = new JTextField();
		txtTalla.setColumns(10);
		txtTalla.setBounds(305, 200, 106, 20);
		frame.getContentPane().add(txtTalla);
		
		JLabel lblTalla = new JLabel("Talla:");
		lblTalla.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTalla.setBounds(244, 197, 82, 25);
		frame.getContentPane().add(lblTalla);
		
		JLabel etiResultado = new JLabel("Resultados");
		etiResultado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		etiResultado.setBounds(32, 229, 120, 25);
		frame.getContentPane().add(etiResultado);
		
		btnListaPersonas = new JButton("Registros");
		btnListaPersonas.setForeground(Color.WHITE);
		btnListaPersonas.setBackground(Color.BLACK);
		btnListaPersonas.setBounds(626, 432, 150, 30);
		btnListaPersonas.addActionListener(this);
		frame.getContentPane().add(btnListaPersonas);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(Color.BLACK);
		btnRegistrar.setBounds(466, 432, 150, 30);
		btnRegistrar.addActionListener(this);
		frame.getContentPane().add(btnRegistrar);
		
		btnCalcularPromedio = new JButton("Calcular Promedio");
		btnCalcularPromedio.setForeground(Color.WHITE);
		btnCalcularPromedio.setBackground(Color.BLACK);
		btnCalcularPromedio.setBounds(306, 432, 150, 30);
		btnCalcularPromedio.addActionListener(this);
		frame.getContentPane().add(btnCalcularPromedio);
		
		btnCalcularIMC = new JButton("Calcular IMC");
		btnCalcularIMC.setForeground(Color.WHITE);
		btnCalcularIMC.setBackground(Color.BLACK);
		btnCalcularIMC.setBounds(147, 432, 150, 30);
		btnCalcularIMC.addActionListener(this);
		frame.getContentPane().add(btnCalcularIMC);
		
		txtArea = new JTextArea();
		txtArea.setLineWrap(true);
		
		areaResultado = new JScrollPane();
		areaResultado.setBounds(32, 265, 744, 150);
		areaResultado.setViewportView(txtArea);
		frame.getContentPane().add(areaResultado);
	}
	
	public int comprobarCampos() {
		int bandera=0;
		String adv= "Digite datos numerico";
		
		try {
			int documento= Integer.parseInt(txtDocumento.getText());
		} catch (Exception e) {
			txtDocumento.setBorder(bordeError);
			txtArea.setText(adv);
			txtArea.setForeground(Color.red);
			bandera=1;
		}

		try {
			int edad= Integer.parseInt(txtEdad.getText());
		} catch (Exception e) {
			txtEdad.setBorder(bordeError);
			txtArea.setText(adv);
			txtArea.setForeground(Color.red);
			bandera=1;
		}
		
		try {
			double peso = Double.parseDouble(txtPeso.getText());
		} catch (Exception e) {
			txtPeso.setBorder(bordeError);
			txtArea.setText(adv);
			txtArea.setForeground(Color.red);
			bandera=1;
		}
		
		try {
			double talla= Double.parseDouble(txtTalla.getText());
		} catch (Exception e) {
			txtTalla.setBorder(bordeError);
			txtArea.setText(adv);
			txtArea.setForeground(Color.red);
			bandera=1;
		}
		return bandera;
	}
	
	public void revisarCampos() {
		txtNombre.setBorder(bordeCorrecto);
		txtDocumento.setBorder(bordeCorrecto);
		txtEdad.setBorder(bordeCorrecto);
		txtPeso.setBorder(bordeCorrecto);
		txtTalla.setBorder(bordeCorrecto);
		txtArea.setText("");
		txtArea.setForeground(Color.black);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = null;
		int bandera= 0;
		
		if (e.getSource() == btnCalcularIMC) {
			bandera = comprobarCampos();			
			if (bandera == 0) {
				revisarCampos();
				
				double imc = logica.calcularIMC(Double.parseDouble(txtPeso.getText()), Double.parseDouble(txtTalla.getText()));
				String conclusion= logica.conclusionIMC(imc);
				
				msg = "———————————————————————————————————————————————\n";
				msg += "<<CALCULO IMC>>\n";
				msg += "Documento: "+Integer.parseInt(txtDocumento.getText())+"\n";
				msg += "Nombre: "+txtNombre.getText()+" \n";
				msg += "IMC: "+imc+"\n";
				msg += "Conclusion: "+conclusion+"\n";
				msg += "———————————————————————————————————————————————\n\n";
				txtArea.setText(msg);
			}
			
		} else if (e.getSource() == btnRegistrar){
			bandera = comprobarCampos();			
			if (bandera == 0) {
				revisarCampos();
				
				double imc = logica.calcularIMC(Double.parseDouble(txtPeso.getText()), Double.parseDouble(txtTalla.getText()));
				String conclusion= logica.conclusionIMC(imc);
				
				PersonaVO persona = new PersonaVO();
				persona.setDocumento(Integer.parseInt(txtDocumento.getText()));
				persona.setNombre(txtNombre.getText());
				persona.setEdad(Integer.parseInt(txtEdad.getText()));
				persona.setPeso(Double.parseDouble(txtPeso.getText()));
				persona.setTalla(Double.parseDouble(txtTalla.getText()));
				persona.setImc(imc);
				persona.setConclusion(conclusion);
				
				msg = modeloDatos.registrarPersonas(persona);
				txtArea.setText(msg);
			}
			
		} else if (e.getSource() == btnCalcularPromedio){
			msg = modeloDatos.consultarPromedioPersonas();
			txtArea.setText(msg);
			
		} else if (e.getSource() == btnListaPersonas){
			msg = modeloDatos.consultarListadoPersonas();
			txtArea.setText(msg);	
		}	
	}
}
