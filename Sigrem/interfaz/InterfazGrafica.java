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
	
	private Sigrem controlador;
	
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
		{	ex.printStackTrace();}
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
		formayuda.setLocation(150,50);
//		formayuda.setPreferredSize(new Dimension(500,400));
		
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
				System.out.println("El programa Sigrem ha terminado");
				System.exit(0);
			}
		});	
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
		if (pestaña==1) pcontratos.actualiza(panel,datos);
		else if (pestaña==2){} //pempleados.actualiza(panel,datos);
		else if (pestaña==3) {}//peconomia.actualiza(panel,datos);
	}
	
	public void actualizaVistaMensaje(String mensaje)
	{
		JOptionPane.showMessageDialog(null,mensaje,"Sigrem",-1);
	}
	
	public void actualizaVistaDatos(int pestaña,LinkedList datos,boolean dibujar)
	{
		if (pestaña==1) pcontratos.actualizaDatosModificables(datos,dibujar);
		else if (pestaña==2){} //pempleados.actualizaDatosModificables(panel,datos);
	}
	
	public JMenuBar setMenu()
	{
		JMenuBar menu=new JMenuBar();
		JMenu m1=new JMenu("Archivo");
		JMenu m3=new JMenu("Herramientas");
		JMenu m4=new JMenu("Acerca de");
		JMenuItem guardar=new JMenuItem("Guardar datos");
		JMenuItem salir=new JMenuItem("Salir");
		JMenuItem ayuda=new JMenuItem("Ayuda");
		JMenuItem acercade=new JMenuItem("Acerca de");
		m1.add(guardar);
		m1.addSeparator();
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
				System.out.println("El programa Sigrem ha terminado");
				System.exit(0);				
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
					controlador.consultarContratoMatricula(valor);
				}
			}
		});
		clcod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				String valor=JOptionPane.showInputDialog(null,"Introduce el código del cliente","Consultar cliente",-1);
				if (valor!=null)
				{	panelVistas.setSelectedIndex(0);
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
					controlador.consultarClienteNombre(valor);
				}
			}
		});
		emcod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			String valor=JOptionPane.showInputDialog(null,"Introduce el código del empleado","Consultar empleado",-1);
			if (valor!=null)
			{	
				panelVistas.setSelectedIndex(1);
			}
			}
		});
		emdni.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				String valor=JOptionPane.showInputDialog(null,"Introduce el DNI del empleado","Consultar empleado",-1);
				if (valor!=null)
				{	
					panelVistas.setSelectedIndex(1);
				}
			}
		});
		emnom.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				String valor=JOptionPane.showInputDialog(null,"Introduce el nombre del empleado","Consultar empleado",-1);
				if (valor!=null)
				{	
					panelVistas.setSelectedIndex(1);
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
				}
			}
		});
		fac.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.remove(2);
				peconomia=new PanelEconomia(1,controlador,ventana);
				panelVistas.addTab("Gestión Económica",peconomia);
				panelVistas.setSelectedIndex(2);
				
			}
		});
		gas.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.remove(2);
				peconomia=new PanelEconomia(2,controlador,ventana);
				panelVistas.addTab("Gestión Económica",peconomia);
				panelVistas.setSelectedIndex(2);
			}
		});
		bal.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.remove(2);
				peconomia=new PanelEconomia(3,controlador,ventana);
				panelVistas.addTab("Gestión Económica",peconomia);
				panelVistas.setSelectedIndex(2);
			}
		});
		guardar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				guardar();				
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
		if (npanel==0)	panel0();		
		else
			if (npanel==1)	panel1();
			else 
				if (npanel==2) panel2();
				else formayuda.getContentPane().removeAll();
				
	}
	
	public void panel0()
	{		
		salida=new JTextArea();
		psalida=new JScrollPane(salida);
		psalida.setEnabled(false);
		psalida.setPreferredSize(new Dimension(500,400));
		String[] opciones = {"Sigrem"," + Menú"," + Gestión Contratos"," + Gestión Empleados"," + Gestión Económica"};
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
				if(lista.getSelectedIndex()==1)	
				{
					dibujaAyuda(1);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu.txt"));
					}
					catch(FileNotFoundException e)
					{}
					
				}
				else
					if(lista.getSelectedIndex()==2)
					{
						dibujaAyuda(2);
						try
						{
							fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos.txt"));
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
	
	public void panel1()
	{		
		salida=new JTextArea();
		psalida=new JScrollPane(salida);
		psalida.setEnabled(false);
		psalida.setPreferredSize(new Dimension(500,400));
		String[] opciones = {"Sigrem"," -  Menú","    + Archivo","    + Herramientas","    + Acerca de"," + Gestión Contratos"," + Gestión Empleados"," + Gestión Económica"};
		lista=new JList(opciones);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setPreferredSize(new Dimension(150,400));
		JSplitPane sp2=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,lista,psalida);
		sp2.setEnabled(false);
		formayuda.getContentPane().add(sp2);
		formayuda.setTitle("Ayuda - Sigrem");
		formayuda.pack();
		lista.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent ev)
			{
				psalida.removeAll();
				salida.removeAll();
				if(lista.getSelectedIndex()==1)	
				{
					dibujaAyuda(0);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else
					if(lista.getSelectedIndex()==5)
					{
						dibujaAyuda(2);
						try
						{
							fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos.txt"));
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
	
	public void panel2()
	{		
		salida=new JTextArea();
		psalida=new JScrollPane(salida);
		psalida.setEnabled(false);
		psalida.setPreferredSize(new Dimension(500,400));
		String[] opciones = {"Sigrem"," + Menú"," -  Gestión Contratos","    + Datos del Contrato","    + Datos del Cliente","    + Multas del Contrato"," + Gestión Empleados"," + Gestión Económica"};
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
				if(lista.getSelectedIndex()==1) 
				{
					dibujaAyuda(1);
					try
					{
						fd = new BufferedReader (new FileReader ("interfaz/ayuda_menu.txt"));
					}
					catch(FileNotFoundException e)
					{}					
				}
				else
					if(lista.getSelectedIndex()==2)	
					{
						dibujaAyuda(0);
						try
						{
							fd = new BufferedReader (new FileReader ("interfaz/ayuda_contratos.txt"));
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