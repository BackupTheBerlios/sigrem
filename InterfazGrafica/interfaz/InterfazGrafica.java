package interfaz;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InterfazGrafica 
{
	private JFrame ventana;
	
	private JTabbedPane panelVistas;
	
	public InterfazGrafica()
	{
		ventana=new JFrame("Sigrem");
		panelVistas=new JTabbedPane(JTabbedPane.BOTTOM);
		panelVistas.addTab("Gestión Contratos",new PanelContratos());
		panelVistas.addTab("Gestión Empleados",new PanelEmpleados());
		panelVistas.addTab("Gestión Económica",new PanelEconomia());
		ventana.getContentPane().add(panelVistas);
		ventana.setJMenuBar(setMenu());
		ventana.pack();
		ventana.setLocation(100,50);
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
		JMenuItem mec=new JMenuItem("Eliminar contrato");
		JMenuItem mce=new JMenuItem("Contratar empleado");
		mce.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
						PanelEmpleados p=new PanelEmpleados();
						p.creaEmpleado();
					}
				});
		JMenuItem mee=new JMenuItem("Despedir empleado");
		mee.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
					PanelEmpleados p=new PanelEmpleados();
					p.eliminaEmpleado();
					}
				});
		JMenuItem salir=new JMenuItem("Salir");
		JMenuItem acercade=new JMenuItem("Acerca de");
		m1.add(mcc);
		m1.add(mec);
		m1.add(new JSeparator());
		m1.add(mce);
		m1.add(mee);
		m1.add(new JSeparator());
		m1.add(salir);
		JMenuItem modc=new JMenuItem("Modificar contrato");
		JMenuItem mode=new JMenuItem("Modificar empleado");
		m2.add(modc);
		m2.add(mode);
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
}