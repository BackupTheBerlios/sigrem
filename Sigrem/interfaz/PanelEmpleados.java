package interfaz;

import javax.swing.*;

import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;

public class PanelEmpleados extends JPanel 
{
	private JFrame formAlta; 
	
	private JFrame formBaja;
	
	private JFrame formRecurso;
	
	private JFrame formDescrip;
	
	private JButton bmodificar;
	
	private JButton bdespedir;	
	
	private JComboBox estado;
		
	private JComboBox perfil;
	
	public PanelEmpleados()
	{
		super();
		bmodificar=new JButton("Modificar");
		bdespedir=new JButton("Despedir");
		JPanel pempleado=dibujaEmpleado();
		pempleado.setPreferredSize(new Dimension(314,0));
		JPanel pdatos=dibujaDatos(false);
		pdatos.setPreferredSize(new Dimension(0,260));
		JPanel precursos=dibujaRecursos();
		JSplitPane sp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pempleado,pdatos);
		sp1.setDividerSize(4);
		sp1.setEnabled(false);
		JSplitPane sp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp1,precursos);
		sp2.setEnabled(false);		
		sp2.setDividerSize(4);
		add(sp2);
		formAlta=new JFrame();
		formAlta.setResizable(false);
		formAlta.setLocation(350,100);
		formBaja=new JFrame();
		formBaja.setResizable(false);
		formBaja.setLocation(350,100);
		formRecurso=new JFrame();		
		formRecurso.setResizable(false);
		formRecurso.setLocation(350,100);
		formDescrip=new JFrame();
		formDescrip.setResizable(false);
		formDescrip.setLocation(350,100);
	}
		
	public JPanel dibujaEmpleado()
	{
		JPanel pemp=new JPanel();
		pemp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del empleado",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l1=new JLabel("C�digo del empleado");
		JLabel l2=new JLabel("Perfil del empleado");
		JLabel l3=new JLabel("N�mina del empleado");
		l1.setPreferredSize(new Dimension(150,20));
		l2.setPreferredSize(new Dimension(150,20));
		l3.setPreferredSize(new Dimension(150,20));
		final JTextField t1=new JTextField("E001");
		JTextField t2=new JTextField();
		JTextField t3=new JTextField();
		t1.setPreferredSize(new Dimension(100,20));
		t2.setPreferredSize(new Dimension(100,20));
		t3.setPreferredSize(new Dimension(100,20));
		t1.setEditable(false);
		t2.setEditable(false);
		t3.setEditable(false);
		t1.setBackground(Color.WHITE);
		t2.setBackground(Color.WHITE);
		t3.setBackground(Color.WHITE);
		JButton bcontratar=new JButton ("Contratar");
		bdespedir.setEnabled(false);
		bmodificar.setEnabled(false);
		bcontratar.setPreferredSize(new Dimension(90,25));
		bmodificar.setPreferredSize(new Dimension(90,25));
		bdespedir.setPreferredSize(new Dimension(90,25));
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		p1.add(l1);
		p1.add(t1);
		p2.add(l2);
		p2.add(t2);
		p3.add(l3);
		p3.add(t3);
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
		pemp.add(sp);
		bcontratar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (!formAlta.isVisible())
				{	formAlta.getContentPane().add(panelAltaEmpleado('c',t1.getText()));
					formAlta.pack();	
					formAlta.setVisible(true);
				}
			}
		});
		bdespedir.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				int seleccion=JOptionPane.showConfirmDialog(null,"         �Desea despedir al empleado "+t1.getText()+"?","Despedir empleado",JOptionPane.YES_NO_CANCEL_OPTION,-1);
				if (seleccion==JOptionPane.YES_OPTION)
				{	
					
				}
			}
		});
		bmodificar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (!formAlta.isVisible())
				{	formAlta.getContentPane().add(panelAltaEmpleado('m',t1.getText()));
					formAlta.pack();	
					formAlta.setVisible(true);
				}
			}
		});
		return pemp;
	}
	
	public JPanel dibujaDatos(boolean editable) 
	{		
		JPanel pdat=new JPanel();
		pdat.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos personales",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l1=new JLabel("Nombre ",SwingConstants.RIGHT);
		JLabel l2=new JLabel("DNI/CIF ",SwingConstants.RIGHT);
		JLabel l3=new JLabel("Direcci�n ",SwingConstants.RIGHT);
		JLabel l4=new JLabel("C�digo postal ",SwingConstants.RIGHT);
		JLabel l5=new JLabel("Localidad ",SwingConstants.RIGHT);
		JLabel l6=new JLabel("Provincia ",SwingConstants.RIGHT);		
		JLabel l7=new JLabel("Tel�fono ",SwingConstants.RIGHT);
		JLabel l8=new JLabel("email ",SwingConstants.RIGHT);
		l1.setPreferredSize(new Dimension(80,20));
		l2.setPreferredSize(new Dimension(80,20));
		l3.setPreferredSize(new Dimension(80,20));
		l4.setPreferredSize(new Dimension(80,20));
		l5.setPreferredSize(new Dimension(80,20));
		l6.setPreferredSize(new Dimension(80,20));
		l7.setPreferredSize(new Dimension(80,20));
		l8.setPreferredSize(new Dimension(80,20));
		JLabel relleno1=new JLabel("");
		JLabel relleno2=new JLabel("");
		JLabel relleno3=new JLabel("");
		JLabel relleno4=new JLabel("");
		JLabel relleno5=new JLabel("");
		relleno1.setPreferredSize(new Dimension(100,20));
		relleno2.setPreferredSize(new Dimension(150,20));
		relleno3.setPreferredSize(new Dimension(50,20));
		relleno4.setPreferredSize(new Dimension(100,20));
		relleno5.setPreferredSize(new Dimension(20,20));		
		JTextField tnom=new JTextField();
		JTextField tdni=new JTextField();
		JTextField tdir=new JTextField();
		JTextField tcp=new JTextField();
		JTextField tloc=new JTextField();
		JTextField tpro=new JTextField();
		JTextField ttel=new JTextField();
		JTextField temail=new JTextField();		
		tnom.setPreferredSize(new Dimension(200,20));
		tdni.setPreferredSize(new Dimension(100,20));
		tdir.setPreferredSize(new Dimension(200,20));
		tcp.setPreferredSize(new Dimension(60,20));
		tloc.setPreferredSize(new Dimension(180,20));
		tpro.setPreferredSize(new Dimension(160,20));
		ttel.setPreferredSize(new Dimension(80,20));
		temail.setPreferredSize(new Dimension(80,20));
		if (!editable)
		{
			tnom.setEditable(false);
			tdni.setEditable(false);
			tdir.setEditable(false);
			tcp.setEditable(false);
			tloc.setEditable(false);
			tpro.setEditable(false);
			ttel.setEditable(false);
			temail.setEditable(false);
			tnom.setBackground(Color.WHITE);
			tdni.setBackground(Color.WHITE);
			tdir.setBackground(Color.WHITE);
			tcp.setBackground(Color.WHITE);
			tloc.setBackground(Color.WHITE);
			tpro.setBackground(Color.WHITE);
			ttel.setBackground(Color.WHITE);
			temail.setBackground(Color.WHITE);
		}
		Box c1=Box.createHorizontalBox();
		Box c2=Box.createHorizontalBox();
		Box c3=Box.createHorizontalBox();
		Box c4=Box.createHorizontalBox();
		Box c5=Box.createHorizontalBox();
		Box c6=Box.createHorizontalBox();
		Box c7=Box.createHorizontalBox();
		Box c8=Box.createHorizontalBox();
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
		c5.add(tloc);
		c6.add(l6);
		c6.add(tpro);
		c6.add(relleno3);
		c7.add(l7);
		c7.add(ttel);
		c7.add(relleno4);
		c8.add(l8);
		c8.add(temail);
		c8.add(relleno5);
		Box caja=Box.createVerticalBox();
		caja.add(c1);
		caja.add(c2);
		caja.add(c3);
		caja.add(c4);
		caja.add(c5);
		caja.add(c6);
		caja.add(c7);
		caja.add(c8);
		pdat.add(caja);
		return pdat;
	}
	
	public JPanel dibujaRecursos()
	{	
		Box tabla=Box.createVerticalBox();
		JPanel p=new JPanel();
		JLabel l1=new JLabel("C�digo",SwingConstants.CENTER);
		JLabel l2=new JLabel("Multa",SwingConstants.CENTER);
		JLabel l3=new JLabel("Estado",SwingConstants.CENTER);
		JLabel l4=new JLabel("Descripci�n",SwingConstants.CENTER);
		JLabel l5=new JLabel("",SwingConstants.CENTER);
		JLabel l6=new JLabel("",SwingConstants.CENTER);
		l1.setPreferredSize(new Dimension(130,25));
		l2.setPreferredSize(new Dimension(130,25));
		l3.setPreferredSize(new Dimension(130,25));
		l4.setPreferredSize(new Dimension(80,25));
		l5.setPreferredSize(new Dimension(25,25));
		l6.setPreferredSize(new Dimension(25,25));
		p.add(l1);
		p.add(l2);
		p.add(l3);
		p.add(l4);
		p.add(l5);
		p.add(l6);
		tabla.add(p);
		for (int i=0;i<9;i++)
		{	JPanel linea=dibujaLinea();
			tabla.add(linea);		
		}
		JScrollPane ptabla=new JScrollPane(tabla,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ptabla.setPreferredSize(new Dimension(700,200));
		JButton bcrea=new JButton("A�adir recurso");
		JPanel botonera=new JPanel();
		botonera.add(bcrea);
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,ptabla,botonera);
		sp.setEnabled(false);
		sp.setDividerSize(4);
		JPanel prec=new JPanel();
		prec.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Recursos asignados",TitledBorder.LEFT,TitledBorder.TOP));
		prec.add(sp);						
		bcrea.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (!formRecurso.isVisible())
				{	formRecurso.getContentPane().add(anadeRecurso());
					formRecurso.pack();
					formRecurso.setVisible(true);
				}
			}
		});
		return prec;		
	}
	
	public JPanel panelAltaEmpleado(char tipo,String codigo) 
	{		
		if (tipo=='c') formAlta.setTitle("Contratar empleado");
		else if (tipo=='m') formAlta.setTitle("Modificar empleado "+codigo);
		JLabel lcodigo=new JLabel("C�digo del empleado");
		JLabel lperfil=new JLabel("Perfil del empleado");
		JLabel lnomina=new JLabel("N�mina del empleado");
		String [] opciones={"Abogado","Administrativo","Procurador","Otros..."};
		perfil=new JComboBox(opciones);
		perfil.setPreferredSize(new Dimension(100,20));
		perfil.setEditable(false);
		perfil.setBackground(Color.WHITE);
		lcodigo.setPreferredSize(new Dimension(150,20));
		lperfil.setPreferredSize(new Dimension(150,20));
		lnomina.setPreferredSize(new Dimension(150,20));
		JTextField tcodigo=new JTextField();
		JTextField tperfil=new JTextField();
		JTextField tnomina=new JTextField();
		tcodigo.setPreferredSize(new Dimension(100,20));
		tnomina.setPreferredSize(new Dimension(100,20));
		tcodigo.setEditable(false);
		JPanel pcodigo=new JPanel();
		JPanel pperfil=new JPanel();
		JPanel pnomina=new JPanel();
		pcodigo.add(lcodigo);
		pcodigo.add(tcodigo);
		pperfil.add(lperfil);
		pperfil.add(perfil);
		pnomina.add(lnomina);
		pnomina.add(tnomina);
		Box caja=Box.createVerticalBox();
		caja.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del empleado",TitledBorder.LEFT,TitledBorder.TOP));
		caja.add(pcodigo);
		caja.add(pperfil);
		caja.add(pnomina);
		JPanel pdat=dibujaDatos(true);
		JPanel pbotones=new JPanel();
		JButton bacepta=new JButton ("Aceptar");
		JButton bcancela=new JButton ("Cancelar");
		pbotones.add(bacepta);
		pbotones.add(bcancela);
		JSplitPane sp1=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja,pdat);
		sp1.setDividerSize(4);
		sp1.setEnabled(false);
		JSplitPane sp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp1,pbotones);
		sp2.setDividerSize(4);
		sp2.setEnabled(false);
		JPanel pndat=new JPanel();
		pndat.add(sp2);
		bacepta.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formAlta.setVisible(false);
				formAlta.getContentPane().removeAll();
				bdespedir.setEnabled(true);
				bmodificar.setEnabled(true);
			}
		});
		bcancela.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formAlta.setVisible(false);
				formAlta.getContentPane().removeAll();
			}
		});
		return pndat;
	}
	
	public void eliminaEmpleado()
	{
		JPanel pd=panelBajaEmpleado();
		formBaja.getContentPane().add(pd);
		formBaja.pack();
		formBaja.setVisible(true);
		formBaja.addWindowListener(new WindowAdapter()
		{	public void windowClosing(WindowEvent e)
			{
				formBaja.setVisible(false);	
			}
		});
	}
	
	public JPanel panelBajaEmpleado()
	{
		formBaja.setTitle("Despidiendo empleado...");		
		JLabel lcodigo=new JLabel("C�digo del empleado");		
		lcodigo.setPreferredSize(new Dimension(150,20));		
		final JTextField tcodigo=new JTextField();		
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
		JPanel pndat=new JPanel();
		pndat.add(sp);
		bacepta.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formBaja.setVisible(false);
				int seleccion=JOptionPane.showConfirmDialog(null,"         �Desea despedir al empleado "+tcodigo.getText()+"?","Despedir empleado",JOptionPane.YES_NO_CANCEL_OPTION,-1);
				if (seleccion==JOptionPane.YES_OPTION)
				{	
					
				}
				formBaja.getContentPane().removeAll();
			}
		});
		bcancela.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formBaja.setVisible(false);
				formBaja.getContentPane().removeAll();
			}
		});
		return pndat;
	}
	
	public JPanel modificaRecurso(String codigo)
	{
		formRecurso.setTitle("Modificar estado del recurso "+codigo);		
		formRecurso.setTitle("Modificar estado de recurso "+codigo);		
		JLabel l1=new JLabel("C�digo");
		JLabel l2=new JLabel("Estado");
		String [] opciones={"Pendiente","Recurso 1�","Recurso 2�","Recurso 3�","Favorable","Perdido"};
		estado=new JComboBox(opciones);
		estado.setPreferredSize(new Dimension(100,20));
		estado.setEditable(false);
		estado.setBackground(Color.WHITE);
		l1.setPreferredSize(new Dimension(80,20));
		l2.setPreferredSize(new Dimension(80,20));
		JTextField cod=new JTextField();
		JTextField est=new JTextField();
		cod.setPreferredSize(new Dimension(100,20));		
		cod.setEditable(false);
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		p1.add(l1);
		p1.add(cod);
		p2.add(l2);
		p2.add(estado);
		Box caja=Box.createVerticalBox();
		caja.add(p1);
		caja.add(p2);
		JButton aceptar=new JButton("Aceptar");
		JButton cancelar=new JButton("Cancelar");
		JPanel botonera=new JPanel();
		botonera.add(aceptar);
		botonera.add(cancelar);
		botonera.setPreferredSize(new Dimension(300,40));
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja,botonera);
		sp.setEnabled(false);		
		sp.setDividerSize(4);
		JPanel panel=new JPanel();
		panel.add(sp);
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Modificar estado del recurso",TitledBorder.LEFT,TitledBorder.TOP));
		aceptar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formRecurso.setVisible(false);
				formRecurso.getContentPane().removeAll();
				//validar datos
				//enviar datos a Sigrem para almacenarlos en la estructura de datos
			}
		});
		cancelar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formRecurso.setVisible(false);
				formRecurso.getContentPane().removeAll();
			}
		});
		return panel;
	}
	
	public JPanel anadeRecurso()
	{
		formRecurso.setTitle("A�adir recurso");
		JLabel l1=new JLabel("C�digo");
		l1.setPreferredSize(new Dimension(80,20));
		JTextField cod=new JTextField();
		cod.setPreferredSize(new Dimension(100,20));
		JPanel p1=new JPanel();
		p1.add(l1);
		p1.add(cod);
		Box caja=Box.createVerticalBox();
		caja.add(p1);
		JButton aceptar=new JButton("Aceptar");
		JButton cancelar=new JButton("Cancelar");
		JPanel botonera=new JPanel();
		botonera.add(aceptar);
		botonera.add(cancelar);
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja,botonera);
		sp.setEnabled(false);		
		sp.setDividerSize(4);
		JPanel panel=new JPanel();
		panel.add(sp);
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"A�adir recurso al empleado",TitledBorder.LEFT,TitledBorder.TOP));
		aceptar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formRecurso.setVisible(false);
				formRecurso.getContentPane().removeAll();
				//validar datos
				//enviar datos a Sigrem para almacenarlos en la estructura de datos
			}
		});
		cancelar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formRecurso.setVisible(false);
				formRecurso.getContentPane().removeAll();
			}
		});
		return panel;
	}
	
	public JPanel pintaDescrip(String cod)
	{
		formDescrip.setTitle("Descripci�n del recurso "+cod);
		JPanel panel=new JPanel();
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		p1.add(new JLabel("Descripci�n"));
		JTextPane texto=new JTextPane();
		texto.setEditable(false);
		JScrollPane ptexto=new JScrollPane(texto,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
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
				formDescrip.setVisible(false);
				formDescrip.getContentPane().removeAll();								
			}
		});
		return panel;
	}
	
	public JPanel dibujaLinea()
	{		
		JPanel panel=new JPanel();
		final JTextField cod=new JTextField("R001");
		final JTextField exp=new JTextField();
		final JTextField bol=new JTextField();
		final JButton descrip=new JButton(new ImageIcon("interfaz/find.gif"));
		final JButton modi=new JButton(new ImageIcon("interfaz/tick.gif"));
		final JButton elim=new JButton(new ImageIcon("interfaz/del.gif"));
		cod.setEnabled(false);
		cod.setPreferredSize(new Dimension(130,25));		
		exp.setEnabled(false);
		exp.setPreferredSize(new Dimension(130,25));		
		bol.setEnabled(false);
		bol.setPreferredSize(new Dimension(130,25));		
		descrip.setPreferredSize(new Dimension(80,25));		
		modi.setPreferredSize(new Dimension (25,25));		
		elim.setPreferredSize(new Dimension (25,25));
		panel.add(cod);
		panel.add(exp);
		panel.add(bol);
		panel.add(descrip);
		panel.add(modi);
		panel.add(elim);
		descrip.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (!formDescrip.isVisible())
				{	formDescrip.getContentPane().add(pintaDescrip(cod.getText()));
					formDescrip.pack();
					formDescrip.setVisible(true);
				}
			}
		});
		modi.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{	
				if (!formRecurso.isVisible())
				{	formRecurso.getContentPane().add(modificaRecurso(cod.getText()));
					formRecurso.pack();
					formRecurso.setVisible(true);
				}		
			}
		});
		elim.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{	int seleccion=JOptionPane.showConfirmDialog(null,"        �Desea eliminar la asignaci�n del recurso "+cod.getText()+"?","Eliminar asignaci�n",JOptionPane.YES_NO_CANCEL_OPTION,-1);
				if (seleccion==JOptionPane.YES_OPTION)
				{	
				
				}
			}
		});
		return panel;
	}
}
