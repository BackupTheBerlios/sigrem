package interfaz;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfazGrafica 
{
	private JFrame ventana;
	
	private JTabbedPane panelVistas;
	
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
		formacercade.setAlwaysOnTop(true);
		formacercade.setLocation(350,250);
		
		panelVistas=new JTabbedPane(JTabbedPane.BOTTOM);
		panelVistas.addTab("Gesti�n Contratos",new PanelContratos());
		panelVistas.addTab("Gesti�n Empleados",new PanelEmpleados());
		panelVistas.addTab("Gesti�n Econ�mica",new PanelEconomia());
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
	
	public JMenuBar setMenu()
	{
		JMenuBar menu=new JMenuBar();
		JMenu m1=new JMenu("Archivo");
		JMenu m2=new JMenu("Edici�n");
		JMenu m3=new JMenu("Herramientas");
		JMenu m4=new JMenu("Acerca de");
		
		JMenuItem mac=new JMenuItem("Abrir datos");
		JMenuItem mgc=new JMenuItem("Guardar datos");
		JMenuItem mgg=new JMenuItem("Guardar datos como");
		JMenuItem mcc=new JMenuItem("Crear contrato");
		JMenuItem mec=new JMenuItem("Eliminar contrato");
		JMenuItem mce=new JMenuItem("Contratar empleado");
		JMenuItem mee=new JMenuItem("Despedir empleado");
		JMenuItem salir=new JMenuItem("Salir");
		JMenuItem acercade=new JMenuItem("Acerca de");
		
		m1.add(mac);
		m1.add(mgc);
		m1.add(mgg);
		
		/*m1.add(mcc);
		m1.add(mec);
		m1.add(new JSeparator());
		m1.add(mce);
		m1.add(mee);*/
		
		m1.add(new JSeparator());
		m1.add(salir);
		JMenuItem modc=new JMenuItem("Modificar contrato");
		JMenuItem mode=new JMenuItem("Modificar empleado");
		m2.add(modc);
		m2.add(mode);
		JMenu consul=new JMenu("Consultar");
		JMenu cont=new JMenu("Contrato");
		JMenuItem ccod=new JMenuItem("Por c�digo");
		JMenuItem cmat=new JMenuItem("Por matr�cula");
		cont.add(ccod);
		cont.add(cmat);
		JMenu cli=new JMenu("Cliente");
		JMenuItem clcod=new JMenuItem("Por c�digo");
		JMenuItem cldni=new JMenuItem("Por DNI");
		JMenuItem clnom=new JMenuItem("Por nombre");
		cli.add(clcod);
		cli.add(cldni);
		cli.add(clnom);
		JMenu emp=new JMenu("Empleado");
		JMenuItem emcod=new JMenuItem("Por c�digo");
		JMenuItem emdni=new JMenuItem("Por DNI");
		JMenuItem emnom=new JMenuItem("Por nombre");
		emp.add(emcod);
		emp.add(emdni);
		emp.add(emnom);
		JMenu mult=new JMenu("Multa");
		JMenuItem mcod=new JMenuItem("Por c�digo");
		JMenuItem mexp=new JMenuItem("Por expediente");
		JMenuItem mbol=new JMenuItem("Por bolet�n");
		mult.add(mcod);
		mult.add(mexp);
		mult.add(mbol);
		JMenu rec=new JMenu("Recurso");
		JMenuItem rcod=new JMenuItem("Por c�digo");
		rec.add(rcod);
		JMenu adm=new JMenu("Administraci�n");
		JMenuItem fac=new JMenuItem("Facturaci�n");
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
		m4.add(acercade);
		menu.add(m1);
		menu.add(m2);
		menu.add(m3);
		menu.add(m4);
		mcc.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(0);
			}
		});
		mec.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(0);
			}
		});
		mce.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(1);
			}
		});
		mee.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(1);
			}
		});
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
		modc.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(0);
			}
		});
		mode.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(1);
			}
		});
		ccod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(0);
			}
		});
		cmat.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(0);
			}
		});
		clcod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(0);
			}
		});
		cldni.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(0);
			}
		});
		clnom.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(0);
			}
		});
		emcod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(1);
			}
		});
		emdni.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(1);
			}
		});
		emnom.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(1);
			}
		});
		mcod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(0);
			}
		});
		mexp.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(0);
			}
		});
		mbol.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(0);
			}
		});
		rcod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(0);
			}
		});
		fac.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(2);
			}
		});
		gas.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(2);
			}
		});
		bal.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(2);
			}
		});
		return menu;	
	}
	
	public void activa()
	{
		ventana.setVisible(true);
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