package interfaz;

import javax.swing.*;
import java.util.LinkedList;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import javax.swing.JList;
import java.util.Vector;
import main.Sigrem;

class Filtro extends FileFilter
{
	public Filtro() 
	{	super();}
	
	public boolean accept(File f)
	{
		String nombre=f.getName();
		return nombre.substring(Math.max(nombre.length()-4,0)).equals(".xml");
	}
	public String getDescription()
	{
		return "Ficheros de datos (*.xml)";
	}
}

public class InterfazGrafica 
{
	private JFrame ventana;
	
	private JTabbedPane panelVistas;
	
	private PanelContratos pcontratos;
	
	private PanelEmpleados pempleados;
	
	private PanelEconomia peconomia;
	
	private JFileChooser selec;
	
	private JDialog formSigrem;
	
	private JDialog formacercade;
	
	private JFrame formayuda;
	
	private static JTextArea salida;
	
	private JScrollPane psalida;
	
	private static JList lista;
	
	private BufferedReader fd;
	
	private String linea;
	
	final private Sigrem controlador;
	
	public InterfazGrafica(Sigrem controlador)
	{		
		ventana=new JFrame("Sigrem");
		this.controlador=controlador;
		//cambiamos el Look&Feel al de Windows
		int lf=2;
		if (lf>=UIManager.getInstalledLookAndFeels().length) lf=0;
		UIManager.LookAndFeelInfo lfinfo=UIManager.getInstalledLookAndFeels()[lf];
		try
		{	UIManager.setLookAndFeel(lfinfo.getClassName());}
		catch (Exception ex)
		{	lfinfo=UIManager.getInstalledLookAndFeels()[0];
			try
			{	UIManager.setLookAndFeel(lfinfo.getClassName());}
			catch (Exception ex1)
			{ex.printStackTrace();}
		}
		SwingUtilities.updateComponentTreeUI(ventana);
		ventana.pack();
		//Look&Feel cambiado
		//Pantalla de Inicio		
/*		formSigrem=new JDialog();
		formSigrem.setResizable(false);
		formSigrem.setUndecorated(true);		
		formSigrem.setLocation(250,150);
		formSigrem.getContentPane().add(pantallaInicio());
		formSigrem.pack();
		formSigrem.setVisible(true);
		try
		{
	    	Thread.sleep(2000);
	    }
	    catch(InterruptedException e)
	    {
	    	System.out.println("Sleep Interrupted");
	    }		
		formSigrem.setVisible(false);*/
		//Pantalla de Inicio mostrada
		formacercade=new JDialog(ventana,true);
		formacercade.setResizable(false);
		formacercade.setUndecorated(true);		
		formacercade.setLocation(350,250);
		formayuda=new JFrame();
		formayuda.setResizable(false);
		formayuda.setLocation(60,80);
		panelVistas=new JTabbedPane(JTabbedPane.BOTTOM);
		pcontratos=new PanelContratos(this.controlador,ventana);
		pempleados=new PanelEmpleados(this.controlador,ventana);
		peconomia=new PanelEconomia(0,this.controlador,ventana);
		panelVistas.addTab("Gestión Contratos",pcontratos);
		panelVistas.addTab("Gestión Empleados",pempleados);
		panelVistas.addTab("Gestión Económica",peconomia);
		selec=new JFileChooser(new File(System.getProperty("user.dir")));
		selec.setFileSelectionMode(JFileChooser.FILES_ONLY);
		selec.setFileFilter(new Filtro());
		ventana.getContentPane().add(panelVistas);
		ventana.setJMenuBar(setMenu());
		ventana.pack();
		ventana.setLocation(25,30);
		ventana.setResizable(false);
		ventana.addWindowListener(new WindowAdapter()
		{	public void windowClosing(WindowEvent e)
			{
				acabarAplicacion();				
			}
		});	
	}
		
	public void acabarAplicacion()
	{
		controlador.desactiva();
		System.out.println("El programa Sigrem ha terminado");
		System.exit(0);
	}
	
	private void guardar()
	{
		try
		{	if (selec.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
			{	String nombre=selec.getSelectedFile().getName();
				if (nombre.substring(Math.max(nombre.length()-4,0)).equals(".xml"))
				{	nombre=nombre.substring(0,nombre.length()-4);}
				PrintWriter ficheroSal=new PrintWriter(new BufferedWriter(new FileWriter(nombre+".xml")));
				ficheroSal.println("Esto es una prueba");
				ficheroSal.close();
			}
		}
		catch (Exception ex)
		{	JOptionPane.showMessageDialog(null,"Error al guardar","Sigrem",-1);}		
	}
	
	public void activa()
	{
		ventana.setVisible(true);
	}
	
	public void actualizaVista(int pestaña,int panel,LinkedList datos)
	{
		if (pestaña==1)	pcontratos.actualiza(panel,datos);
		else if (pestaña==2) pempleados.actualiza(panel,datos);
			else if (pestaña==3) peconomia.actualiza(panel,datos);
	}
	
	public void actualizaVistaMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null,mensaje,"Sigrem",-1);
	}
	
	public void actualizaVistaDatos(int pestaña,LinkedList datos,boolean dibujar)
	{
		if (pestaña==1) pcontratos.actualizaDatosModificables(datos,dibujar);
		else if (pestaña==2){pempleados.actualizaDatosModificables(datos);}
	}
	
	public void actualizaVistaConsulta(int pestaña,String nombre,Vector dnis)
	{
		if (pestaña==1) pcontratos.actualizaPanelConsulta(nombre,dnis);
		else if (pestaña==2){pempleados.actualizaPanelConsulta(nombre,dnis);}
	}
	
	public void actualizarVistaConsultaAbogado(String codigo)
	{
		pempleados.consultarAbogadoRemotamente(codigo);
	}
	
	public void actualizaVistaCaja(int panel,char caja,char tipo,LinkedList datos)
	{
		if (panel==1)
		{	if (caja=='m') pcontratos.actualizaCajaMultas(tipo,datos);
			else if (caja=='r') pcontratos.actualizaCajaRecursos(tipo,datos);
		}
		else
		{	pempleados.actualizaCajaRecursos(datos);}			
	}
	
	public void actualizaVistaAbogados(Vector listaAbogados)
	{
		pcontratos.actualizaListaAbogados(listaAbogados);
	}
	
	public void muestraPanelRecursos(String codmulta)
	{
		pcontratos.muestraPanelRecursos(codmulta);
	}
	
	public JMenuBar setMenu()
	{
		JMenuBar menu=new JMenuBar();
		JMenu m1=new JMenu("Archivo");
		JMenu m3=new JMenu("Herramientas");
		JMenu m4=new JMenu("Acerca de");
		JMenuItem salir=new JMenuItem("Salir");
		JMenuItem ayuda=new JMenuItem("Ayuda");
		JMenuItem acercade=new JMenuItem("Acerca de");
		m1.add(salir);
		JMenu consul=new JMenu("Consultar");
		JMenu cont=new JMenu("Contrato");
		JMenuItem ccod=new JMenuItem("Por código");
		JMenuItem cmat=new JMenuItem("Por matrícula");
		cont.add(ccod);
		cont.add(cmat);
		JMenu cli=new JMenu("Cliente");
		JMenuItem clcod=new JMenuItem("Por código");
		JMenuItem cldni=new JMenuItem("Por DNI");
		JMenuItem clnom=new JMenuItem("Por nombre");
		cli.add(clcod);
		cli.add(cldni);
		cli.add(clnom);
		JMenu emp=new JMenu("Empleado");
		JMenuItem emcod=new JMenuItem("Por código");
		JMenuItem emdni=new JMenuItem("Por DNI");
		JMenuItem emnom=new JMenuItem("Por nombre");
		emp.add(emcod);
		emp.add(emdni);
		emp.add(emnom);
		JMenu mult=new JMenu("Multa");
		JMenuItem mcod=new JMenuItem("Por código");
		JMenuItem mexp=new JMenuItem("Por expediente");
		JMenuItem mbol=new JMenuItem("Por boletín");
		mult.add(mcod);
		mult.add(mexp);
		mult.add(mbol);
		JMenu rec=new JMenu("Recurso");
		JMenuItem rcod=new JMenuItem("Por código");
		rec.add(rcod);
		JMenu adm=new JMenu("Administración");
		JMenuItem fac=new JMenuItem("Facturación");
		JMenuItem gas=new JMenuItem("Gastos");
		JMenuItem bal=new JMenuItem("Balance");
		adm.add(fac);
		adm.add(gas);
		adm.add(bal);
		consul.add(cont);
		consul.add(cli);
		consul.add(emp);
		consul.add(mult);
		consul.add(rec);
		m3.add(consul);
		m3.add(adm);
		m4.add(ayuda);
		m4.addSeparator();
		m4.add(acercade);
		menu.add(m1);
		menu.add(m3);
		menu.add(m4);
		salir.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{	
				acabarAplicacion();		
			}
		});
		acercade.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formacercade.getContentPane().add(panelacercade());
				formacercade.pack();	
				formacercade.setVisible(true);				
			}
		});			
		ccod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				String valor=JOptionPane.showInputDialog(null,"Introduce el código del contrato","Consultar contrato",-1);
				if (valor!=null)
				{	panelVistas.setSelectedIndex(0);
					pcontratos.inicializaCajaMultas();
					controlador.consultarContratoCodigo(false,true,valor);			
				}
			}
		});
		cmat.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{	
				String valor=JOptionPane.showInputDialog(null,"Introduce la matrícula del vehículo","Consultar contrato",-1);
				if (valor!=null)
				{	panelVistas.setSelectedIndex(0);
					pcontratos.inicializaCajaMultas();
					controlador.consultarContratoMatricula(true,valor);
				}
			}
		});
		clcod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				String valor=JOptionPane.showInputDialog(null,"Introduce el código del cliente","Consultar cliente",-1);
				if (valor!=null)
				{	panelVistas.setSelectedIndex(0);
					pcontratos.inicializaCajaMultas();
					controlador.consultarClienteCodigo(false,true,valor);
				}
			}
		});
		cldni.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				String valor=JOptionPane.showInputDialog(null,"Introduce el DNI/CIF del cliente","Consultar cliente",-1);
				if (valor!=null)
				{	panelVistas.setSelectedIndex(0);
					pcontratos.inicializaCajaMultas();
					controlador.consultarClienteDni(valor);
				}
			}
		});
		clnom.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				String valor=JOptionPane.showInputDialog(null,"Introduce el nombre del cliente","Consultar cliente",-1);
				if (valor!=null)
				{	panelVistas.setSelectedIndex(0);
					pcontratos.inicializaCajaMultas();
					controlador.consultarClienteNombre(valor);
				}
			}
		});
		emcod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				String valor=JOptionPane.showInputDialog(null,"Introduce el código del empleado","Consultar empleado",-1);
				if (valor!=null)
				{	panelVistas.setSelectedIndex(1);
					pempleados.inicializaCajaRecursos();
					controlador.consultarEmpleadoCodigo(false,valor);
				}
			}
		});
		emdni.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				String valor=JOptionPane.showInputDialog(null,"Introduce el DNI del empleado","Consultar empleado",-1);
				if (valor!=null)
				{	panelVistas.setSelectedIndex(1);
					pempleados.inicializaCajaRecursos();
					controlador.consultarEmpleadoDni(valor);
				}
			}
		});
		emnom.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				String valor=JOptionPane.showInputDialog(null,"Introduce el nombre del empleado","Consultar empleado",-1);
				if (valor!=null)
				{	panelVistas.setSelectedIndex(1);
					pempleados.inicializaCajaRecursos();
					controlador.consultarEmpleadoNombre(valor);
				}
			}
		});
		mcod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				String valor=JOptionPane.showInputDialog(null,"Introduce el código de la multa","Consultar multa",-1);
				if (valor!=null)
				{	
					panelVistas.setSelectedIndex(0);
					pcontratos.inicializaCajaMultas();
					controlador.consultarMultaCodigo(valor);
				}
			}
		});
		mexp.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				String valor=JOptionPane.showInputDialog(null,"Introduce el expediente de la multa","Consultar multa",-1);
				if (valor!=null)
				{	
					panelVistas.setSelectedIndex(0);
					pcontratos.inicializaCajaMultas();
					controlador.consultarMultaExpediente(valor);
				}
			}
		});
		mbol.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				String valor=JOptionPane.showInputDialog(null,"Introduce el boletín de la multa","Consultar multa",-1);
				if (valor!=null)
				{	
					panelVistas.setSelectedIndex(0);
					pcontratos.inicializaCajaMultas();
					controlador.consultarMultaBoletin(valor);
				}
			}
		});
		rcod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				String valor=JOptionPane.showInputDialog(null,"Introduce el código del recurso","Consultar recurso",-1);
				if (valor!=null)
				{	
					panelVistas.setSelectedIndex(0);
					pcontratos.inicializaCajaMultas();
					pcontratos.inicializaCajaRecursos();
					controlador.consultarRecursoCodigo(valor);
				}
			}
		});
		fac.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(2);
				controlador.calculaFacturacion(1);
			}
		});
		gas.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(2);
				controlador.calculaGastos(1);
			}
		});
		bal.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(2);
				controlador.calculaBalance(1);
			}
		});
		ayuda.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formayuda.getContentPane().removeAll();
				dibujaAyuda(0);
				formayuda.setVisible(true);							
			}
		});
		return menu;	
	}
	
	public JButton pantallaInicio()
	{	
		JButton b=new JButton(new ImageIcon("interfaz/sigrem.jpg"));
		b.setPreferredSize(new Dimension(570,355));
		b.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formSigrem.setVisible(false);
				formSigrem.getContentPane().removeAll();
			}
		});
		return b;
	}
	
	public JPanel panelacercade()
	{		
		JPanel pad=new JPanel();
		formacercade.setTitle("Acerca de... SIGREM");
		JButton b=new JButton(new ImageIcon("interfaz/sigrem.gif"));
		b.setPreferredSize(new Dimension(290,180));
		formacercade.getContentPane().add(b);
		formacercade.pack();	
		b.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formacercade.setVisible(false);
				formacercade.getContentPane().removeAll();
			}
		});
		pad.add(b);
		return pad;
	}
	
	public void dibujaAyuda(int npanel)
	{		
		formayuda.getContentPane().removeAll();
		if (npanel==0)	panel(0);		
		else if (npanel==1)	panel(1);
		else if (npanel==2) panel(2);
		else if (npanel==3) panel(3);
		else if (npanel==4) panel(4);
		else if (npanel==5) panel(5);
		else if (npanel==6) panel(6);
		else if (npanel==7) panel(7);
		else if (npanel==8) panel(8);
		else if (npanel==9) panel(9);
		else if (npanel==10) panel(10);
		else if (npanel==11) panel(11);
		else if (npanel==12) panel(12);
		else if (npanel==13) panel(13);
		else if (npanel==14) panel(14);
		else if (npanel==15) panel(15);
		else panel(0);
	}

	public void panel(final int opcion)
	{	
		String[] opciones=new String[16];
		salida=new JTextArea();
		psalida=new JScrollPane(salida);
		psalida.setEnabled(false);
		psalida.setPreferredSize(new Dimension(500,400));
		String[] opciones0 = {"Sigrem"," + Menú"," + Gestión Contratos"," + Gestión Empleados"," + Gestión Económica"};
		String[] opciones1 = {"Sigrem"," -  Menú","     > Archivo","     > Herramientas","     > Acerca de"," + Gestión Contratos"," + Gestión Empleados"," + Gestión Económica"};
		String[] opciones2 = {"Sigrem"," + Menú"," -  Gestión Contratos","     > Datos del Contrato","     > Datos del Cliente","     > Multas del Contrato"," + Gestión Empleados"," + Gestión Económica"};
		String[] opciones3 = {"Sigrem"," + Menú"," + Gestión Contratos"," -  Gestión Empleados","     > Datos del empleado","     > Datos personales","     > Recursos asignados"," + Gestión Económica"};
		String[] opciones4 = {"Sigrem"," + Menú"," + Gestión Contratos"," + Gestión Empleados"," -  Gestión Económica","     > Datos económicos","     > Históricos"};
		String[] opciones5 = {"Sigrem"," -  Menú","     > Archivo","     > Herramientas","     > Acerca de"," -  Gestión Contratos","     > Datos del Contrato","     > Datos del Cliente","     > Multas del Contrato"," + Gestión Empleados"," + Gestión Económica"};
		String[] opciones6 = {"Sigrem"," -  Menú","     > Archivo","     > Herramientas","     > Acerca de"," + Gestión Contratos"," -  Gestión Empleados","     > Datos del empleado","     > Datos personales","     > Recursos asignados"," + Gestión Económica"};
		String[] opciones7 = {"Sigrem"," + Menú"," -  Gestión Contratos","     > Datos del Contrato","     > Datos del Cliente","     > Multas del Contrato"," -  Gestión Empleados","     > Datos del empleado","     > Datos personales","     > Recursos asignados"," + Gestión Económica"};
		String[] opciones8 = {"Sigrem"," -  Menú","     > Archivo","     > Herramientas","     > Acerca de"," + Gestión Contratos"," + Gestión Empleados"," -  Gestión Económica","     > Datos económicos","     > Históricos"};
		String[] opciones9 = {"Sigrem"," + Menú"," -  Gestión Contratos","     > Datos del Contrato","     > Datos del Cliente","     > Multas del Contrato"," + Gestión Empleados"," -  Gestión Económica","     > Datos económicos","     > Históricos"};
		String[] opciones10= {"Sigrem"," + Menú"," + Gestión Contratos"," -  Gestión Empleados","     > Datos del empleado","     > Datos personales","     > Recursos asignados"," -  Gestión Económica","     > Datos económicos","     > Históricos"};
		String[] opciones11= {"Sigrem"," -  Menú","     > Archivo","     > Herramientas","     > Acerca de"," -  Gestión Contratos","     > Datos del Contrato","     > Datos del Cliente","     > Multas del Contrato"," -  Gestión Empleados","     > Datos del empleado","     > Datos personales","     > Recursos asignados"," + Gestión Económica"};
		String[] opciones12= {"Sigrem"," -  Menú","     > Archivo","     > Herramientas","     > Acerca de"," -  Gestión Contratos","     > Datos del Contrato","     > Datos del Cliente","     > Multas del Contrato"," + Gestión Empleados"," -  Gestión Económica","     > Datos económicos","     > Históricos"};
		String[] opciones13= {"Sigrem"," -  Menú","     > Archivo","     > Herramientas","     > Acerca de"," + Gestión Contratos"," -  Gestión Empleados","     > Datos del empleado","     > Datos personales","     > Recursos asignados"," -  Gestión Económica","     > Datos económicos","     > Históricos"};
		String[] opciones14= {"Sigrem"," + Menú"," -  Gestión Contratos","     > Datos del Contrato","     > Datos del Cliente","     > Multas del Contrato"," -  Gestión Empleados","     > Datos del empleado","     > Datos personales","     > Recursos asignados"," -  Gestión Económica","     > Datos económicos","     > Históricos"};
		String[] opciones15= {"Sigrem"," -  Menú","     > Archivo","     > Herramientas","     > Acerca de"," -  Gestión Contratos","     > Datos del Contrato","     > Datos del Cliente","     > Multas del Contrato"," -  Gestión Empleados","     > Datos del empleado","     > Datos personales","     > Recursos asignados"," -  Gestión Económica","     > Datos económicos","     > Históricos"};
		if (opcion==0) opciones=opciones0;
		else if (opcion==1) opciones=opciones1;
		else if (opcion==2) opciones=opciones2;
		else if (opcion==3) opciones=opciones3;
		else if (opcion==4) opciones=opciones4;
		else if (opcion==5) opciones=opciones5;
		else if (opcion==6) opciones=opciones6;
		else if (opcion==7) opciones=opciones7;
		else if (opcion==8) opciones=opciones8;
		else if (opcion==9) opciones=opciones9;
		else if (opcion==10) opciones=opciones10;
		else if (opcion==11) opciones=opciones11;
		else if (opcion==12) opciones=opciones12;
		else if (opcion==13) opciones=opciones13;
		else if (opcion==14) opciones=opciones14;
		else if (opcion==15) opciones=opciones15;
		else opciones=opciones0;					
		lista=new JList(opciones);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setPreferredSize(new Dimension(150,400));
		JSplitPane sp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,lista,psalida);
		sp1.setEnabled(false);
		formayuda.getContentPane().add(sp1);
		formayuda.setTitle("Ayuda - Sigrem");
		formayuda.pack();
		lista.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent ev)
			{
				psalida.removeAll();
				salida.removeAll();
				if (lista.getSelectedValue().equals("Sigrem"))
				{
					dibujaAyuda(opcion);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_sigrem.txt"));
					}
					catch(FileNotFoundException e)
					{}
				}
				else if((lista.getSelectedValue().equals(" + Menú"))&&(opcion==0))	
				{
					dibujaAyuda(1);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Contratos"))&&(opcion==0))
				{
					dibujaAyuda(2);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Empleados"))&&(opcion==0))
				{
					dibujaAyuda(3);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_empleados.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Económica"))&&(opcion==0))  
				{
					dibujaAyuda(4);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_economia.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Menú"))&&(opcion==1))	
				{
					dibujaAyuda(0);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Contratos"))&&(opcion==1))
				{
					dibujaAyuda(5);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Empleados"))&&(opcion==1))
				{
					dibujaAyuda(6);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_empleados.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Económica"))&&(opcion==1))  
				{
					dibujaAyuda(8);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_economia.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Menú"))&&(opcion==2))	
				{
					dibujaAyuda(5);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Contratos"))&&(opcion==2))
				{
					dibujaAyuda(0);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Empleados"))&&(opcion==2))
				{
					dibujaAyuda(7);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_empleados.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Económica"))&&(opcion==2))  
				{
					dibujaAyuda(9);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_economia.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Menú"))&&(opcion==3))	
				{
					dibujaAyuda(6);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Contratos"))&&(opcion==3))
				{
					dibujaAyuda(7);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Empleados"))&&(opcion==3))
				{
					dibujaAyuda(0);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_empleados.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Económica"))&&(opcion==3))  
				{
					dibujaAyuda(10);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_economia.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Menú"))&&(opcion==4))	
				{
					dibujaAyuda(8);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Contratos"))&&(opcion==4))
				{
					dibujaAyuda(9);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Empleados"))&&(opcion==4))
				{
					dibujaAyuda(10);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_empleados.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Económica"))&&(opcion==4))  
				{
					dibujaAyuda(0);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_economia.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Menú"))&&(opcion==5))	
				{
					dibujaAyuda(2);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Contratos"))&&(opcion==5))
				{
					dibujaAyuda(1);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Empleados"))&&(opcion==5))
				{
					dibujaAyuda(11);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_empleados.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Económica"))&&(opcion==5))  
				{
					dibujaAyuda(12);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_economia.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Menú"))&&(opcion==6))	
				{
					dibujaAyuda(3);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Contratos"))&&(opcion==6))
				{
					dibujaAyuda(11);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Empleados"))&&(opcion==6))
				{
					dibujaAyuda(1);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_empleados.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Económica"))&&(opcion==6))  
				{
					dibujaAyuda(13);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_economia.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Menú"))&&(opcion==7))	
				{
					dibujaAyuda(11);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Contratos"))&&(opcion==7))
				{
					dibujaAyuda(3);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Empleados"))&&(opcion==7))
				{
					dibujaAyuda(2);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_empleados.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Económica"))&&(opcion==7))  
				{
					dibujaAyuda(14);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_economia.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Menú"))&&(opcion==8))	
				{
					dibujaAyuda(4);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Contratos"))&&(opcion==8))
				{
					dibujaAyuda(12);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Empleados"))&&(opcion==8))
				{
					dibujaAyuda(13);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_empleados.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Económica"))&&(opcion==8))  
				{
					dibujaAyuda(1);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_economia.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Menú"))&&(opcion==9))	
				{
					dibujaAyuda(12);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Contratos"))&&(opcion==9))
				{
					dibujaAyuda(4);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Empleados"))&&(opcion==9))
				{
					dibujaAyuda(14);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_empleados.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Económica"))&&(opcion==9))  
				{
					dibujaAyuda(2);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_economia.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Menú"))&&(opcion==10))	
				{
					dibujaAyuda(13);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Contratos"))&&(opcion==10))
				{
					dibujaAyuda(14);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Empleados"))&&(opcion==10))
				{
					dibujaAyuda(4);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_empleados.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Económica"))&&(opcion==10))  
				{
					dibujaAyuda(3);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_economia.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Menú"))&&(opcion==11))	
				{
					dibujaAyuda(7);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Contratos"))&&(opcion==11))
				{
					dibujaAyuda(6);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Empleados"))&&(opcion==11))
				{
					dibujaAyuda(5);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_empleados.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Económica"))&&(opcion==11))  
				{
					dibujaAyuda(15);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_economia.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Menú"))&&(opcion==12))	
				{
					dibujaAyuda(9);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Contratos"))&&(opcion==12))
				{
					dibujaAyuda(8);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Empleados"))&&(opcion==12))
				{
					dibujaAyuda(15);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_empleados.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Económica"))&&(opcion==12))  
				{
					dibujaAyuda(5);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_economia.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Menú"))&&(opcion==13))	
				{
					dibujaAyuda(10);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Gestión Contratos"))&&(opcion==13))
				{
					dibujaAyuda(15);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Empleados"))&&(opcion==13))
				{
					dibujaAyuda(8);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_empleados.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Económica"))&&(opcion==13))  
				{
					dibujaAyuda(6);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_economia.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" + Menú"))&&(opcion==14))	
				{
					dibujaAyuda(15);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Contratos"))&&(opcion==14))
				{
					dibujaAyuda(10);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Empleados"))&&(opcion==14))
				{
					dibujaAyuda(9);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_empleados.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Económica"))&&(opcion==14))  
				{
					dibujaAyuda(7);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_economia.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Menú"))&&(opcion==15))	
				{
					dibujaAyuda(14);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Contratos"))&&(opcion==15))
				{
					dibujaAyuda(13);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Empleados"))&&(opcion==15))
				{
					dibujaAyuda(12);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_empleados.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if((lista.getSelectedValue().equals(" -  Gestión Económica"))&&(opcion==15))  
				{
					dibujaAyuda(11);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_economia.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if(lista.getSelectedValue().equals("     > Archivo"))	
				{
					dibujaAyuda(opcion);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu1.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if(lista.getSelectedValue().equals("     > Herramientas"))
				{
					dibujaAyuda(opcion);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu2.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if(lista.getSelectedValue().equals("     > Acerca de"))
				{
					dibujaAyuda(opcion);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu3.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if(lista.getSelectedValue().equals("     > Datos del Contrato"))  
				{
					dibujaAyuda(opcion);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos1.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if(lista.getSelectedValue().equals("     > Datos del Cliente"))	
				{
					dibujaAyuda(opcion);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos2.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if(lista.getSelectedValue().equals("     > Multas del Contrato"))
				{
					dibujaAyuda(opcion);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos3.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if(lista.getSelectedValue().equals("     > Datos del empleado"))
				{
					dibujaAyuda(opcion);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_empleados1.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if(lista.getSelectedValue().equals("     > Datos personales"))  
				{
					dibujaAyuda(opcion);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_empleados2.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if(lista.getSelectedValue().equals("     > Recursos asignados"))	
				{
					dibujaAyuda(opcion);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_empleados3.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if(lista.getSelectedValue().equals("     > Datos económicos"))
				{
					dibujaAyuda(opcion);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_economia1.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else if(lista.getSelectedValue().equals("     > Históricos"))
				{
					dibujaAyuda(opcion);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_economia2.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}														
				try
				{
					if (fd!=null)
					{
						while((linea=fd.readLine())!=null)
						{
							salida.append(linea+"\n");						
						}
						fd.close();
					}
				}
				catch(IOException e)
				{}							
			}
		});		
	}	
}