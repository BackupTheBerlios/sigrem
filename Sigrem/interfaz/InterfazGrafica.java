package interfaz;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.filechooser.FileFilter;
import java.io.*;

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
	
	private JFileChooser selec;
	
	private JFrame formSigrem;
	
	private JFrame formacercade;
	
	public InterfazGrafica()
	{
		ventana=new JFrame("Sigrem");
		formSigrem=new JFrame();
		formSigrem.setResizable(false);
		formSigrem.setUndecorated(true);		
		formSigrem.setLocation(250,150);
//		pantallaInicio();
		formacercade=new JFrame();
		formacercade.setResizable(false);
		formacercade.setUndecorated(true);		
//		formacercade.setAlwaysOnTop(true);
		formacercade.setLocation(350,250);
		panelVistas=new JTabbedPane(JTabbedPane.BOTTOM);
		panelVistas.addTab("Gestión Contratos",new PanelContratos());
		panelVistas.addTab("Gestión Empleados",new PanelEmpleados());
		panelVistas.addTab("Gestión Económica",new PanelEconomia(0));
		selec=new JFileChooser(new File(System.getProperty("user.dir")));
		selec.setFileSelectionMode(JFileChooser.FILES_ONLY);
		selec.setFileFilter(new Filtro());
		ventana.getContentPane().add(panelVistas);
		ventana.setJMenuBar(setMenu());
		ventana.pack();
		ventana.setLocation(150,50);
		ventana.setResizable(false);
		ventana.addWindowListener(new WindowAdapter()
		{	public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});	
	}
	
	private void cargar()
	{
		try
		{	if (selec.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
			{	File f=selec.getSelectedFile();
				String nombre=f.getName();
				BufferedReader entrada=new BufferedReader(new FileReader(nombre));
				String text=new String();
				while ((text=entrada.readLine())!=null)
				{		}
			}
		}
		catch (Exception ex)
		{	JOptionPane.showMessageDialog(null,"Error al cargar","Sigrem",-1);}
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
	
	public JMenuBar setMenu()
	{
		JMenuBar menu=new JMenuBar();
		JMenu m1=new JMenu("Archivo");
		JMenu m3=new JMenu("Herramientas");
		JMenu m4=new JMenu("Acerca de");
		JMenuItem cargar=new JMenuItem("Cargar datos");
		JMenuItem guardar=new JMenuItem("Guardar datos");
		JMenuItem salir=new JMenuItem("Salir");
		JMenuItem ayuda=new JMenuItem("Ayuda");
		JMenuItem acercade=new JMenuItem("Acerca de");
		m1.add(cargar);
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
				System.exit(0);				
			}
		});
		acercade.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				acercade();
			}
		});			
		ccod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				String valor=JOptionPane.showInputDialog(null,"Introduce el código del contrato","Consultar contrato",-1);
				if (valor!=null)
				{	
					panelVistas.setSelectedIndex(0);
				}
			}
		});
		cmat.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{	
				String valor=JOptionPane.showInputDialog(null,"Introduce la matrícula del vehículo","Consultar contrato",-1);
				if (valor!=null)
				{	
					panelVistas.setSelectedIndex(0);
				}
			}
		});
		clcod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				String valor=JOptionPane.showInputDialog(null,"Introduce el código del cliente","Consultar cliente",-1);
				if (valor!=null)
				{	
					panelVistas.setSelectedIndex(0);
				}
			}
		});
		cldni.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				String valor=JOptionPane.showInputDialog(null,"Introduce el DNI/CIF del cliente","Consultar cliente",-1);
				if (valor!=null)
				{	
					panelVistas.setSelectedIndex(0);
				}
			}
		});
		clnom.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				String valor=JOptionPane.showInputDialog(null,"Introduce el nombre del cliente","Consultar cliente",-1);
				if (valor!=null)
				{	
					panelVistas.setSelectedIndex(0);
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
				panelVistas.addTab("Gestión Económica",new PanelEconomia(1));
				panelVistas.setSelectedIndex(2);
				
			}
		});
		gas.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.remove(2);
				panelVistas.addTab("Gestión Económica",new PanelEconomia(2));
				panelVistas.setSelectedIndex(2);
			}
		});
		bal.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.remove(2);
				panelVistas.addTab("Gestión Económica",new PanelEconomia(3));
				panelVistas.setSelectedIndex(2);
			}
		});
		cargar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				cargar();		
			}
		});
		guardar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				guardar();
			}
		});
		return menu;	
	}
	
	public void pantallaInicio()
	{	
		formSigrem.setTitle("SIGREM");
		JButton b=new JButton(new ImageIcon("interfaz/sigrem.jpg"));
		b.setPreferredSize(new Dimension(570,350));
		formSigrem.getContentPane().add(b);
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
		formSigrem.setVisible(false);
	}
	
	public void acercade()
	{		
		formacercade.setTitle("Acerca de... SIGREM");
		JButton b=new JButton(new ImageIcon("interfaz/sigrem.gif"));
		b.setPreferredSize(new Dimension(290,180));
		formacercade.getContentPane().add(b);
		formacercade.pack();	
		formacercade.setVisible(true);
		b.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formacercade.setVisible(false);
			}
		});
	}
}