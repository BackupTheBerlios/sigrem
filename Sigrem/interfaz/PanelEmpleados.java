package interfaz;

import javax.swing.*;

import main.Sigrem;
import java.util.LinkedList;
import java.util.Vector;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PanelEmpleados extends JPanel 
{
	private Sigrem controlador;
	
	private JDialog formulario;
	
	private JDialog formConsulta;
	
	private Box cajaRecursos;
	
	private String empleadoMostrado;
	
	public PanelEmpleados(Sigrem controlador,JFrame v)
	{
		super();
		this.controlador=controlador;
		empleadoMostrado=new String();
		formulario=new JDialog(v,true);
		formulario.setResizable(false);
		formulario.setLocation(350,100);
		formulario.addWindowListener(new WindowAdapter()
		{	public void windowClosing(WindowEvent e)
			{
				formulario.getContentPane().removeAll();
			}
		});	
		formConsulta=new JDialog(v,true);
		formConsulta.setResizable(false);
		formConsulta.addWindowListener(new WindowAdapter()
		{	public void windowClosing(WindowEvent e)
			{
				formConsulta.getContentPane().removeAll();
			}
		});
		JPanel pempleado=dibujaEmpleado(null);
		JPanel pdatos=dibujaDatos(null);
		JPanel precursos=dibujaRecursos(false);
		JSplitPane sp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pempleado,pdatos);
		sp1.setDividerSize(4);
		sp1.setEnabled(false);
		JSplitPane sp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp1,precursos);
		sp2.setEnabled(false);		
		sp2.setDividerSize(4);
		add(sp2);				
	}
	
	public void actualiza(int panel,LinkedList datos)
	{
		if (panel==1)
		{	JSplitPane sp=((JSplitPane)getComponent(0));
			((JSplitPane)sp.getComponent(0)).setLeftComponent(dibujaEmpleado(datos));
		}
		else if (panel==2)
		{	JSplitPane sp=((JSplitPane)getComponent(0));
			((JSplitPane)sp.getComponent(0)).setRightComponent(dibujaDatos(datos));
		}
		else if (panel==3)
		{	JSplitPane sp=((JSplitPane)getComponent(0));
			if (datos!=null) sp.setBottomComponent(dibujaRecursos(true));
			else sp.setBottomComponent(dibujaRecursos(false));
		}
	}
	
	public void actualizaDatosModificables(LinkedList datos)
	{
		formulario.getContentPane().add(panelAltaEmpleado((String)datos.get(0),datos));
		formulario.pack();
		formulario.setVisible(true);
	}
	
	public void actualizaCajaRecursos(LinkedList datos)
	{
		int lineas=cajaRecursos.getComponentCount();
		cajaRecursos.add(dibujaLineaRecurso(datos),lineas-1);
	}
	
	public void actualizaPanelConsulta(String nombre,Vector dnis)
	{
		formConsulta.setTitle("Resultados de la consulta");
		formConsulta.setLocation(350,200);
		JLabel l1=new JLabel("Se han encontrado los siguientes empleados con nombre "+nombre);
		JLabel l2=new JLabel("Selecciona el DNI/CIF del empleado:");
		final JComboBox dni=new JComboBox(dnis);
		dni.setPreferredSize(new Dimension(100,20));
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		p1.add(l1);
		p2.add(l2);
		p2.add(dni);
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,p1,p2);
		sp.setEnabled(false);
		sp.setDividerSize(4);
		dni.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				controlador.consultarEmpleadoDni((String)dni.getSelectedItem());
				formConsulta.setVisible(false);
				formConsulta.getContentPane().removeAll();				
			}
		});
		formConsulta.getContentPane().add(sp);
		formConsulta.pack();
		formConsulta.setVisible(true);
	}
	
	
	public void inicializaCajaRecursos()
	{
		cajaRecursos=Box.createVerticalBox();
		JLabel relleno=new JLabel("");
		relleno.setPreferredSize(new Dimension(20,150));
		cajaRecursos.add(relleno);		
	}
	
	public void consultarAbogadoRemotamente(String codigo)
	{
		if (codigo.equals(empleadoMostrado))
		{	inicializaCajaRecursos();
			controlador.consultarEmpleadoCodigo(false,codigo);
		}
	}
	
	public JPanel dibujaEmpleado(final LinkedList datos)
	{		
		JPanel pemp=new JPanel();
		pemp.setPreferredSize(new Dimension(314,0));
		pemp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del empleado",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l1=new JLabel("Código del empleado");
		JLabel l2=new JLabel("Perfil del empleado");
		JLabel l3=new JLabel("Nómina del empleado");
		l1.setPreferredSize(new Dimension(150,20));
		l2.setPreferredSize(new Dimension(150,20));
		l3.setPreferredSize(new Dimension(150,20));
		final JTextField tcod=new JTextField();
		JTextField tper=new JTextField();
		JTextField tnom=new JTextField();
		tcod.setPreferredSize(new Dimension(100,20));
		tper.setPreferredSize(new Dimension(100,20));
		tnom.setPreferredSize(new Dimension(100,20));
		tcod.setEditable(false);
		tper.setEditable(false);
		tnom.setEditable(false);
		tcod.setBackground(Color.WHITE);
		tper.setBackground(Color.WHITE);
		tnom.setBackground(Color.WHITE);
		if (datos!=null)
		{	tcod.setText((String)datos.get(0));
			empleadoMostrado=(String)datos.get(0);
			tper.setText((String)datos.get(1));
			tnom.setText((String)datos.get(2));
		}
		JButton bcontratar=new JButton ("Contratar");
		JButton bmodificar=new JButton("Modificar");
		JButton bdespedir=new JButton("Despedir");
		bcontratar.setToolTipText("Contratar un empleado nuevo");
		bdespedir.setToolTipText("Despedir un empleado");
		bmodificar.setToolTipText("Modificar un empleado");
		bcontratar.setPreferredSize(new Dimension(90,25));
		bmodificar.setPreferredSize(new Dimension(90,25));
		bdespedir.setPreferredSize(new Dimension(90,25));
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		p1.add(l1);
		p1.add(tcod);
		p2.add(l2);
		p2.add(tper);
		p3.add(l3);
		p3.add(tnom);
		p4.add(bcontratar);
		p4.add(bdespedir);
		p4.add(bmodificar);
		Box caja=Box.createVerticalBox();
		caja.add(p1);
		caja.add(p2);
		caja.add(p3);
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja,p4);
		sp.setDividerSize(4);
		sp.setEnabled(false);
		JLabel logo=new JLabel(new ImageIcon("interfaz/sigrem2.jpg"));
		logo.setPreferredSize(new Dimension(0,150));
		JSplitPane sp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp,logo);
		sp2.setDividerSize(4);
		sp2.setEnabled(false);
		pemp.add(sp2);		
		bcontratar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formulario.getContentPane().add(panelAltaEmpleado(null,null));
				formulario.pack();	
				formulario.setVisible(true);				
			}
		});
		bdespedir.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formulario.getContentPane().add(panelBajaEmpleado(tcod.getText()));
				formulario.pack();
				formulario.setVisible(true);				
			}
		});
		bmodificar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formulario.getContentPane().add(panelModificaEmpleado(tcod.getText()));
				formulario.pack();	
				formulario.setVisible(true);
			}
		});
		return pemp;
	}
	
	public JPanel dibujaDatos(final LinkedList datos) 
	{		
		JPanel pdat=new JPanel();
		pdat.setPreferredSize(new Dimension(0,320));
		pdat.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos personales",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l1=new JLabel("Nombre ",SwingConstants.RIGHT);
		JLabel l2=new JLabel("DNI ",SwingConstants.RIGHT);
		JLabel l3=new JLabel("Dirección ",SwingConstants.RIGHT);
		JLabel l4=new JLabel("Código postal ",SwingConstants.RIGHT);
		JLabel l5=new JLabel("Población ",SwingConstants.RIGHT);
		JLabel l6=new JLabel("Provincia ",SwingConstants.RIGHT);		
		JLabel l7=new JLabel("Teléfono 1 ",SwingConstants.RIGHT);
		JLabel l8=new JLabel("Teléfono 2 ",SwingConstants.RIGHT);
		JLabel l9=new JLabel("Móvil ",SwingConstants.RIGHT);
		JLabel l10=new JLabel("em@il ",SwingConstants.RIGHT);
		JLabel l11=new JLabel("Fax ",SwingConstants.RIGHT);
		l1.setPreferredSize(new Dimension(80,20));
		l2.setPreferredSize(new Dimension(80,20));
		l3.setPreferredSize(new Dimension(80,20));
		l4.setPreferredSize(new Dimension(80,20));
		l5.setPreferredSize(new Dimension(80,20));
		l6.setPreferredSize(new Dimension(80,20));
		l7.setPreferredSize(new Dimension(80,20));
		l8.setPreferredSize(new Dimension(80,20));
		l9.setPreferredSize(new Dimension(80,20));
		l10.setPreferredSize(new Dimension(80,20));
		l11.setPreferredSize(new Dimension(80,20));
		JLabel relleno1=new JLabel("");
		JLabel relleno2=new JLabel("");
		JLabel relleno3=new JLabel("");
		JLabel relleno4=new JLabel("");
		JLabel relleno5=new JLabel("");
		JLabel relleno6=new JLabel("");
		JLabel relleno7=new JLabel("");
		JLabel relleno8=new JLabel("");
		relleno1.setPreferredSize(new Dimension(100,20));
		relleno2.setPreferredSize(new Dimension(150,20));
		relleno3.setPreferredSize(new Dimension(50,20));
		relleno4.setPreferredSize(new Dimension(100,20));
		relleno5.setPreferredSize(new Dimension(100,20));
		relleno6.setPreferredSize(new Dimension(100,20));
		relleno7.setPreferredSize(new Dimension(20,20));
		relleno8.setPreferredSize(new Dimension(80,20));
		JTextField tnom=new JTextField();
		JTextField tdni=new JTextField();
		JTextField tdir=new JTextField();
		JTextField tcp=new JTextField();
		JTextField tpob=new JTextField();
		JTextField tpro=new JTextField();
		JTextField ttel1=new JTextField();
		JTextField ttel2=new JTextField();
		JTextField tmov=new JTextField();
		JTextField temail=new JTextField();	
		JTextField tfax=new JTextField();
		tnom.setPreferredSize(new Dimension(200,20));
		tdni.setPreferredSize(new Dimension(100,20));
		tdir.setPreferredSize(new Dimension(200,20));
		tcp.setPreferredSize(new Dimension(60,20));
		tpob.setPreferredSize(new Dimension(180,20));
		tpro.setPreferredSize(new Dimension(160,20));
		ttel1.setPreferredSize(new Dimension(80,20));
		ttel2.setPreferredSize(new Dimension(80,20));
		tmov.setPreferredSize(new Dimension(80,20));
		temail.setPreferredSize(new Dimension(80,20));
		tfax.setPreferredSize(new Dimension(60,20));
		if (datos!=null)
		{	tnom.setText((String)datos.get(0));
			tdni.setText((String)datos.get(1));
			tdir.setText((String)datos.get(2));
			tcp.setText((String)datos.get(3));
			tpob.setText((String)datos.get(4));
			tpro.setText((String)datos.get(5));
			ttel1.setText((String)datos.get(6));
			ttel2.setText((String)datos.get(7));
			tmov.setText((String)datos.get(8));
			temail.setText((String)datos.get(9));
			tfax.setText((String)datos.get(10));		
		}
		tnom.setEditable(false);
		tdni.setEditable(false);
		tdir.setEditable(false);
		tcp.setEditable(false);
		tpob.setEditable(false);
		tpro.setEditable(false);
		ttel1.setEditable(false);
		ttel2.setEditable(false);
		tmov.setEditable(false);
		temail.setEditable(false);
		tfax.setEditable(false);
		tnom.setBackground(Color.WHITE);
		tdni.setBackground(Color.WHITE);
		tdir.setBackground(Color.WHITE);
		tcp.setBackground(Color.WHITE);
		tpob.setBackground(Color.WHITE);
		tpro.setBackground(Color.WHITE);
		ttel1.setBackground(Color.WHITE);
		ttel2.setBackground(Color.WHITE);
		tmov.setBackground(Color.WHITE);
		temail.setBackground(Color.WHITE);
		tfax.setBackground(Color.WHITE);
		Box c1=Box.createHorizontalBox();
		Box c2=Box.createHorizontalBox();
		Box c3=Box.createHorizontalBox();
		Box c4=Box.createHorizontalBox();
		Box c5=Box.createHorizontalBox();
		Box c6=Box.createHorizontalBox();
		Box c7=Box.createHorizontalBox();
		Box c8=Box.createHorizontalBox();
		Box c9=Box.createHorizontalBox();
		Box c10=Box.createHorizontalBox();
		Box c11=Box.createHorizontalBox();
		c1.add(l1);
		c1.add(tnom);
		c2.add(l2);
		c2.add(tdni);
		c2.add(relleno1);
		c3.add(l3);
		c3.add(tdir);
		c4.add(l4);
		c4.add(tcp);
		c4.add(relleno2);
		c5.add(l5);
		c5.add(tpob);
		c6.add(l6);
		c6.add(tpro);
		c6.add(relleno3);
		c7.add(l7);
		c7.add(ttel1);
		c7.add(relleno4);
		c8.add(l8);
		c8.add(ttel2);
		c8.add(relleno5);
		c9.add(l9);
		c9.add(tmov);
		c9.add(relleno6);
		c10.add(l10);
		c10.add(temail);
		c10.add(relleno7);
		c11.add(l11);
		c11.add(tfax);
		c11.add(relleno8);
		Box caja=Box.createVerticalBox();
		caja.add(c1);
		caja.add(c2);
		caja.add(c3);
		caja.add(c4);
		caja.add(c5);
		caja.add(c6);
		caja.add(c7);
		caja.add(c8);
		caja.add(c9);
		caja.add(c10);
		caja.add(c11);
		pdat.add(caja);
		return pdat;
	}
	
	public JPanel dibujaRecursos(boolean activo)
	{	
		JPanel prec=new JPanel();
		prec.setPreferredSize(new Dimension(950,280));
		if (activo) 
		{	prec.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),("Recursos asignados al empleado"),TitledBorder.LEFT,TitledBorder.TOP));
			Box tabla=Box.createVerticalBox();
			JPanel p=new JPanel();
			JLabel l1=new JLabel("Código",SwingConstants.CENTER);
			JLabel l2=new JLabel("Fecha de emisión",SwingConstants.CENTER);
			JLabel l3=new JLabel("Escrito recibido",SwingConstants.CENTER);
			JLabel l4=new JLabel("Escrito presentado",SwingConstants.CENTER);
			JLabel l5=new JLabel("Estado",SwingConstants.CENTER);
			JLabel l6=new JLabel("Descripción",SwingConstants.CENTER);
			JLabel l7=new JLabel("",SwingConstants.CENTER);
			JLabel l8=new JLabel("",SwingConstants.CENTER);
			l1.setPreferredSize(new Dimension(80,25));
			l2.setPreferredSize(new Dimension(90,25));
			l3.setPreferredSize(new Dimension(190,25));
			l4.setPreferredSize(new Dimension(190,25));
			l5.setPreferredSize(new Dimension(90,25));
			l6.setPreferredSize(new Dimension(80,25));
			l7.setPreferredSize(new Dimension(25,25));
			l8.setPreferredSize(new Dimension(25,25));
			p.add(l1);
			p.add(l2);
			p.add(l3);
			p.add(l4);
			p.add(l5);
			p.add(l6);
			p.add(l7);
			p.add(l8);
			JScrollPane ptabla=new JScrollPane(cajaRecursos,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			ptabla.setPreferredSize(new Dimension(930,236));
			JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,ptabla,null);
			sp.setEnabled(false);
			sp.setDividerSize(4);
			prec.add(sp);
		}
		return prec;		
	}
	
	public JPanel panelAltaEmpleado(final String codigo,final LinkedList datos) 
	{	
		if (datos==null)
		{	formulario.setTitle("Contratar empleado");}
		else 
		{	formulario.setTitle("Modificar empleado "+codigo);}
		JLabel lperfil=new JLabel("Perfil del empleado");
		JLabel lnomina=new JLabel("Nómina del empleado");
		String [] opciones={"Abogado","Administrativo"};
		lperfil.setPreferredSize(new Dimension(150,20));
		lnomina.setPreferredSize(new Dimension(150,20));
		final JComboBox perfil=new JComboBox(opciones);
		perfil.setPreferredSize(new Dimension(100,20));
		perfil.setEditable(false);
		final JTextField tnomina=new JTextField();
		tnomina.setPreferredSize(new Dimension(100,20));
		JPanel pcodigo=new JPanel();
		JPanel pperfil=new JPanel();
		JPanel pnomina=new JPanel();
		pperfil.add(lperfil);
		pperfil.add(perfil);
		pnomina.add(lnomina);
		pnomina.add(tnomina);
		Box caja1=Box.createVerticalBox();
		caja1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del empleado",TitledBorder.LEFT,TitledBorder.TOP));
		if (datos==null) caja1.add(pperfil);
		caja1.add(pnomina);
		JPanel pdat=new JPanel();
		pdat.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos personales",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l1=new JLabel("* Nombre ",SwingConstants.RIGHT);
		JLabel l2=new JLabel("* DNI ",SwingConstants.RIGHT);
		JLabel l3=new JLabel("Dirección ",SwingConstants.RIGHT);
		JLabel l4=new JLabel("Código postal ",SwingConstants.RIGHT);
		JLabel l5=new JLabel("Población ",SwingConstants.RIGHT);
		JLabel l6=new JLabel("Provincia ",SwingConstants.RIGHT);		
		JLabel l7=new JLabel("Teléfono 1 ",SwingConstants.RIGHT);
		JLabel l8=new JLabel("Teléfono 2 ",SwingConstants.RIGHT);
		JLabel l9=new JLabel("Móvil ",SwingConstants.RIGHT);
		JLabel l10=new JLabel("em@il ",SwingConstants.RIGHT);
		JLabel l11=new JLabel("Fax ",SwingConstants.RIGHT);
		l1.setPreferredSize(new Dimension(80,20));
		l2.setPreferredSize(new Dimension(80,20));
		l3.setPreferredSize(new Dimension(80,20));
		l4.setPreferredSize(new Dimension(80,20));
		l5.setPreferredSize(new Dimension(80,20));
		l6.setPreferredSize(new Dimension(80,20));
		l7.setPreferredSize(new Dimension(80,20));
		l8.setPreferredSize(new Dimension(80,20));
		l9.setPreferredSize(new Dimension(80,20));
		l10.setPreferredSize(new Dimension(80,20));
		l11.setPreferredSize(new Dimension(80,20));
		JLabel relleno1=new JLabel("");
		JLabel relleno2=new JLabel("");
		JLabel relleno3=new JLabel("");
		JLabel relleno4=new JLabel("");
		JLabel relleno5=new JLabel("");
		JLabel relleno6=new JLabel("");
		JLabel relleno7=new JLabel("");
		JLabel relleno8=new JLabel("");
		relleno1.setPreferredSize(new Dimension(100,20));
		relleno2.setPreferredSize(new Dimension(150,20));
		relleno3.setPreferredSize(new Dimension(50,20));
		relleno4.setPreferredSize(new Dimension(100,20));
		relleno5.setPreferredSize(new Dimension(100,20));
		relleno6.setPreferredSize(new Dimension(100,20));
		relleno7.setPreferredSize(new Dimension(20,20));
		relleno8.setPreferredSize(new Dimension(80,20));
		final JTextField tnom=new JTextField();
		final JTextField tdni=new JTextField();
		final JTextField tdir=new JTextField();
		final JTextField tcp=new JTextField();
		final JTextField tpob=new JTextField();
		final JTextField tpro=new JTextField();
		final JTextField ttel1=new JTextField();
		final JTextField ttel2=new JTextField();
		final JTextField tmov=new JTextField();
		final JTextField temail=new JTextField();		
		final JTextField tfax=new JTextField();
		tnom.setPreferredSize(new Dimension(200,20));
		tdni.setPreferredSize(new Dimension(100,20));
		tdir.setPreferredSize(new Dimension(200,20));
		tcp.setPreferredSize(new Dimension(60,20));
		tpob.setPreferredSize(new Dimension(180,20));
		tpro.setPreferredSize(new Dimension(160,20));
		ttel1.setPreferredSize(new Dimension(80,20));
		ttel2.setPreferredSize(new Dimension(80,20));
		tmov.setPreferredSize(new Dimension(80,20));
		temail.setPreferredSize(new Dimension(80,20));
		tfax.setPreferredSize(new Dimension(60,20));
		if (datos!=null)
		{	tnom.setEditable(false);
			tdni.setEditable(false);
			perfil.setEditable(false);
			tnom.setText((String)datos.get(1));
			tdni.setText((String)datos.get(2));
			tdir.setText((String)datos.get(3));
			tcp.setText((String)datos.get(4));
			tpob.setText((String)datos.get(5));
			tpro.setText((String)datos.get(6));
			ttel1.setText((String)datos.get(7));
			ttel2.setText((String)datos.get(8));
			tmov.setText((String)datos.get(9));
			temail.setText((String)datos.get(10));
			tfax.setText((String)datos.get(11));
			tnomina.setText((String)datos.get(12));
		}
		Box c1=Box.createHorizontalBox();
		Box c2=Box.createHorizontalBox();
		Box c3=Box.createHorizontalBox();
		Box c4=Box.createHorizontalBox();
		Box c5=Box.createHorizontalBox();
		Box c6=Box.createHorizontalBox();
		Box c7=Box.createHorizontalBox();
		Box c8=Box.createHorizontalBox();
		Box c9=Box.createHorizontalBox();
		Box c10=Box.createHorizontalBox();
		Box c11=Box.createHorizontalBox();
		c1.add(l1);
		c1.add(tnom);
		c2.add(l2);
		c2.add(tdni);
		c2.add(relleno1);
		c3.add(l3);
		c3.add(tdir);
		c4.add(l4);
		c4.add(tcp);
		c4.add(relleno2);
		c5.add(l5);
		c5.add(tpob);
		c6.add(l6);
		c6.add(tpro);
		c6.add(relleno3);
		c7.add(l7);
		c7.add(ttel1);
		c7.add(relleno4);
		c8.add(l8);
		c8.add(ttel2);
		c8.add(relleno5);
		c9.add(l9);
		c9.add(tmov);
		c9.add(relleno6);
		c10.add(l10);
		c10.add(temail);
		c10.add(relleno7);
		c11.add(l11);
		c11.add(tfax);
		c11.add(relleno8);
		Box caja2=Box.createVerticalBox();
		caja2.add(c1);
		caja2.add(c2);
		caja2.add(c3);
		caja2.add(c4);
		caja2.add(c5);
		caja2.add(c6);
		caja2.add(c7);
		caja2.add(c8);
		caja2.add(c9);
		caja2.add(c10);
		caja2.add(c11);
		pdat.add(caja2);
		JPanel pbotones=new JPanel();
		JButton bacepta=new JButton ("Aceptar");
		JButton bcancela=new JButton ("Cancelar");
		pbotones.add(bacepta);
		pbotones.add(bcancela);
		JSplitPane sp1=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja1,pdat);
		sp1.setDividerSize(4);
		sp1.setEnabled(false);
		JSplitPane sp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp1,pbotones);
		sp2.setDividerSize(4);
		sp2.setEnabled(false);
		JPanel panel=new JPanel();
		panel.add(sp2);
		bacepta.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				LinkedList datosEmpleado=new LinkedList();
				datosEmpleado.add(tnom.getText());
				datosEmpleado.add(tdni.getText());
				datosEmpleado.add(tdir.getText());
				datosEmpleado.add(tcp.getText());
				datosEmpleado.add(tpob.getText());
				datosEmpleado.add(tpro.getText());
				datosEmpleado.add(ttel1.getText());
				datosEmpleado.add(ttel2.getText());
				datosEmpleado.add(tmov.getText());
				datosEmpleado.add(temail.getText());
				datosEmpleado.add(tfax.getText());
				datosEmpleado.add(tnomina.getText());
				if ((tdni.getText().equals("")) || (tnom.getText().equals("")))
				{
					JOptionPane.showMessageDialog(null,"Los campos marcados con * son obligatorios");
				}
				else
				{	if (datos==null) controlador.contratarEmpleado((String)perfil.getSelectedItem(),datosEmpleado);
					else controlador.modificarEmpleado(codigo,datosEmpleado);
					formulario.setVisible(false);
					formulario.getContentPane().removeAll();
				}
			}
		});
		bcancela.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formulario.setVisible(false);
				formulario.getContentPane().removeAll();
			}
		});
		return panel;
	}
	
	public JPanel panelBajaEmpleado(final String codigo)
	{
		JPanel pndat=new JPanel();
		formulario.setTitle("Despedir empleado");
		JLabel lcodigo=new JLabel("Introduce el código del empleado");		
		final JTextField tcodigo=new JTextField(codigo);		
		tcodigo.setPreferredSize(new Dimension(100,20));		
		JPanel pcodigo=new JPanel();		
		pcodigo.add(lcodigo);
		pcodigo.add(tcodigo);	
		Box caja=Box.createVerticalBox();
		caja.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del empleado",TitledBorder.LEFT,TitledBorder.TOP));
		caja.add(pcodigo);		
		JPanel p2=new JPanel();
		JButton bacepta=new JButton ("Aceptar");
		JButton bcancela=new JButton ("Cancelar");
		p2.add(bacepta);
		p2.add(bcancela);
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja,p2);
		sp.setDividerSize(4);
		sp.setEnabled(false);
		pndat.add(sp);
		bacepta.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{	
				formulario.setVisible(false);
				int seleccion=JOptionPane.showConfirmDialog(null,"         ¿Desea despedir al empleado "+tcodigo.getText()+"?","Despedir empleado",JOptionPane.YES_NO_CANCEL_OPTION,-1);
				if (seleccion==JOptionPane.YES_OPTION)
				{	boolean borrar;
					if (codigo.equals(tcodigo.getText())) borrar=true;
					else borrar=false;
					controlador.despedirEmpleado(borrar,tcodigo.getText());
				}
				formulario.getContentPane().removeAll();				
			}
		});
		bcancela.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formulario.setVisible(false);
				formulario.getContentPane().removeAll();
			}
		});
		return pndat;
	}
	
	public JPanel panelModificaEmpleado(final String codigo)	
	{
		formulario.setTitle("Modificar empleado");
		JLabel lcodigo=new JLabel("Introduce el código del empleado");		
		final JTextField tcodigo=new JTextField(codigo);		
		tcodigo.setPreferredSize(new Dimension(100,20));		
		JPanel pcodigo=new JPanel();
		pcodigo.add(lcodigo);
		pcodigo.add(tcodigo);	
		Box caja=Box.createVerticalBox();
		caja.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del empleado",TitledBorder.LEFT,TitledBorder.TOP));
		caja.add(pcodigo);		
		JPanel p2=new JPanel();
		JButton bacepta=new JButton("Aceptar");
		JButton bcancela=new JButton("Cancelar");
		p2.add(bacepta);
		p2.add(bcancela);
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja,p2);
		sp.setDividerSize(4);
		sp.setEnabled(false);
		JPanel pndat=new JPanel();
		pndat.add(sp);
		bacepta.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{	
				formulario.setVisible(false);
				formulario.getContentPane().removeAll();
				controlador.consultarEmpleadoCodigo(true,tcodigo.getText());			
			}
		});
		bcancela.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formulario.setVisible(false);
				formulario.getContentPane().removeAll();
			}
		});
		return pndat;
	}

	public JPanel panelDescripcion(String cod,String texto)
	{
		formulario.setTitle("Descripción del recurso "+cod);
		JPanel panel=new JPanel();
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		p1.add(new JLabel("Descripción"));
		JTextPane descrip=new JTextPane();
		descrip.setText(texto);
		descrip.setEditable(false);
		JScrollPane ptexto=new JScrollPane(descrip,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
		ptexto.setPreferredSize(new Dimension(300,150));
		JSplitPane sp1=new JSplitPane(JSplitPane.VERTICAL_SPLIT,p1,ptexto);
		sp1.setEnabled(false);
		sp1.setDividerSize(1);
		JButton aceptar=new JButton("Aceptar");
		p2.add(aceptar);
		JSplitPane sp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp1,p2);
		sp2.setEnabled(false);
		sp2.setDividerSize(4);
		panel.add(sp2);
		aceptar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formulario.setVisible(false);
				formulario.getContentPane().removeAll();								
			}
		});
		return panel;
	}
	
	public JPanel dibujaLineaRecurso(final LinkedList datos)
	{	
		JPanel panel=new JPanel();
		final JTextField cod=new JTextField((String)datos.get(0));
		final JTextField femi=new JTextField((String)datos.get(1));
		JTextField ere=new JTextField((String)datos.get(2));
		JTextField epr=new JTextField((String)datos.get(3));
		JTextField est=new JTextField((String)datos.get(4));
		JButton descrip=new JButton(new ImageIcon("interfaz/find.gif"));
		cod.setEditable(false);
		femi.setEditable(false);
		ere.setEditable(false);
		epr.setEditable(false);
		est.setEditable(false);
		cod.setBackground(Color.WHITE);
		femi.setBackground(Color.WHITE);
		ere.setBackground(Color.WHITE);
		epr.setBackground(Color.WHITE);
		est.setBackground(Color.WHITE);
		cod.setPreferredSize(new Dimension(80,25));
		femi.setPreferredSize(new Dimension(90,25));
		ere.setPreferredSize(new Dimension(220,25));
		epr.setPreferredSize(new Dimension(220,25));
		est.setPreferredSize(new Dimension(90,25));
		descrip.setPreferredSize(new Dimension(80,25));
		panel.add(cod);
		panel.add(femi);
		panel.add(ere);
		panel.add(epr);
		panel.add(est);
		panel.add(descrip);
		descrip.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formulario.getContentPane().add(panelDescripcion(cod.getText(),(String)datos.get(6)));
				formulario.pack();
				formulario.setVisible(true);			
			}
		});
		return panel;
	}
}
