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
	private JFrame formSigrem;
	
	private JTabbedPane panelVistas;
	
	public InterfazGrafica()
	{
		ventana=new JFrame("Sigrem");
		
		pantallaInicio(0);		
		
		panelVistas=new JTabbedPane(JTabbedPane.BOTTOM);
		panelVistas.addTab("Gestión Contratos",new PanelContratos());
		panelVistas.addTab("Gestión Empleados",new PanelEmpleados());
		panelVistas.addTab("Gestión Económica",new PanelEconomia());
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
		JMenu m2=new JMenu("Edición");
		JMenu m3=new JMenu("Herramientas");
		JMenu m4=new JMenu("Acerca de");
		JMenuItem mcc=new JMenuItem("Crear contrato");
		mcc.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(0);
			}
		});
		JMenuItem mec=new JMenuItem("Eliminar contrato");
		mec.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(0);
			}
		});
		JMenuItem mce=new JMenuItem("Contratar empleado");
		mce.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				panelVistas.setSelectedIndex(1);
			}
		});
		JMenuItem mee=new JMenuItem("Despedir empleado");
		mee.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(1);
			PanelEmpleados p=new PanelEmpleados();
			p.eliminaEmpleado();
			}
		});
		JMenuItem salir=new JMenuItem("Salir");
		JMenuItem acercade=new JMenuItem("Acerca de");
		acercade.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			pantallaInicio(1);
			}
		});			
		m1.add(mcc);
		m1.add(mec);
		m1.add(new JSeparator());
		m1.add(mce);
		m1.add(mee);
		m1.add(new JSeparator());
		m1.add(salir);
		JMenuItem modc=new JMenuItem("Modificar contrato");
		modc.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(0);
			}
		});
		JMenuItem mode=new JMenuItem("Modificar empleado");
		mode.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(1);
			}
		});
		m2.add(modc);
		m2.add(mode);
		JMenu consul=new JMenu("Consultar");
		JMenu cont=new JMenu("Contrato");
		JMenuItem ccod=new JMenuItem("Por código");
		ccod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(0);
			}
		});
		JMenuItem cmat=new JMenuItem("Por matrícula");
		cmat.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(0);
			}
		});
		cont.add(ccod);
		cont.add(cmat);
		JMenu cli=new JMenu("Cliente");
		JMenuItem clcod=new JMenuItem("Por código");
		clcod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(0);
			}
		});
		JMenuItem cldni=new JMenuItem("Por DNI");
		cldni.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(0);
			}
		});
		JMenuItem clnom=new JMenuItem("Por nombre");
		clnom.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(0);
			}
		});
		cli.add(clcod);
		cli.add(cldni);
		cli.add(clnom);
		JMenu emp=new JMenu("Empleado");
		JMenuItem emcod=new JMenuItem("Por código");
		emcod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(1);
			}
		});
		JMenuItem emdni=new JMenuItem("Por DNI");
		emdni.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(1);
			}
		});
		JMenuItem emnom=new JMenuItem("Por nombre");
		emnom.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(1);
			}
		});
		emp.add(emcod);
		emp.add(emdni);
		emp.add(emnom);
		JMenu mult=new JMenu("Multa");
		JMenuItem mcod=new JMenuItem("Por código");
		mcod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(0);
			}
		});
		JMenuItem mexp=new JMenuItem("Por expediente");
		mexp.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(0);
			}
		});
		JMenuItem mbol=new JMenuItem("Por boletín");
		mbol.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(0);
			}
		});
		mult.add(mcod);
		mult.add(mexp);
		mult.add(mbol);
		JMenu rec=new JMenu("Recurso");
		JMenuItem rcod=new JMenuItem("Por código");
		rcod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(0);
			}
		});
		rec.add(rcod);
		JMenu adm=new JMenu("Administración");
		JMenuItem fac=new JMenuItem("Facturación");
		fac.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(2);
			}
		});
		JMenuItem gas=new JMenuItem("Gastos");
		gas.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(2);
			}
		});
		JMenuItem bal=new JMenuItem("Balance");
		bal.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			panelVistas.setSelectedIndex(2);
			}
		});
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
		salir.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		return menu;	
	}
	
	public void activa()
	{
		ventana.setVisible(true);
	}
	
	public void pantallaInicio(int i)
	{
		formSigrem=new JFrame();
		formSigrem.setResizable(false);
		formSigrem.setUndecorated(true);
		formSigrem.setVisible(true);
		formSigrem.setAlwaysOnTop(true);
		JButton b;		
		if (i==0) 
			{
			b=new JButton(new ImageIcon("interfaz/sigrem3.gif"));
			b.setPreferredSize(new Dimension(570,350));
			formSigrem.setLocation(250,150);
			formSigrem.getContentPane().add(b);
			formSigrem.pack();			
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
		else 
		{
			b=new JButton(new ImageIcon("interfaz/sigrem2.gif"));
			b.setPreferredSize(new Dimension(290,180));
			formSigrem.setLocation(350,250);
			formSigrem.getContentPane().add(b);
			formSigrem.pack();			
			b.addActionListener(new ActionListener()
			{	public void actionPerformed(ActionEvent e)
				{
					formSigrem.setVisible(false);
				}
			});
		}		
		
		
				
		
		
	}
}