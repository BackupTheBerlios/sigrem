package interfaz;

import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelContratos extends JPanel
{
	private JFrame formAlta;
	
	private JFrame formMulta;
	
	private JFrame formDescripM;
	
	private JFrame formDescripR;
	
	private JFrame formRecurso;
	
	private JButton elimcont;
	
	private JButton modcont;
	
	public PanelContratos()
	{
		super();
		modcont=new JButton("Modificar");
		elimcont=new JButton("Eliminar");
		modcont.setEnabled(false);
		elimcont.setEnabled(false);
		JPanel pcontrato=dibujaContrato();
		JPanel pcliente=dibujaCliente(false);
		JPanel pmultas=dibujaMultas();
		JSplitPane sp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pcontrato,pcliente);
		sp1.setDividerSize(4);
		sp1.setEnabled(false);
		JSplitPane sp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp1,pmultas);
		sp2.setEnabled(false);		
		sp2.setDividerSize(4);
		add(sp2);
		formAlta=new JFrame();
		formAlta.setResizable(false);
		formAlta.setLocation(350,100);
		formMulta=new JFrame();
		formMulta.setResizable(false);
		formMulta.setLocation(350,100);
		formDescripM=new JFrame();
		formDescripM.setResizable(false);
		formDescripM.setLocation(350,100);
		formDescripR=new JFrame();
		formDescripR.setResizable(false);
		formDescripR.setLocation(350,150);
		formRecurso=new JFrame();
		formRecurso.setResizable(false);
		formRecurso.setLocation(200,100);
	}
		
	public JPanel dibujaContrato()
	{
		JPanel pco=new JPanel();
		pco.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del contrato",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l1=new JLabel("Código del contrato");
		JLabel l2=new JLabel("Matrícula del vehículo");
		JLabel l3=new JLabel("Código del cliente");
		l1.setPreferredSize(new Dimension(150,20));
		l2.setPreferredSize(new Dimension(150,20));
		l3.setPreferredSize(new Dimension(150,20));
		final JTextField tcontrato=new JTextField();
		JTextField tcliente=new JTextField();
		JTextField tmatricula=new JTextField();
		tcontrato.setPreferredSize(new Dimension(100,20));
		tcliente.setPreferredSize(new Dimension(100,20));
		tmatricula.setPreferredSize(new Dimension(100,20));
		tcontrato.setEnabled(false);
		tcliente.setEnabled(false);
		tmatricula.setEnabled(false);
		JButton bcrea=new JButton ("Crear");
		bcrea.setPreferredSize(new Dimension(90,25));
		modcont.setPreferredSize(new Dimension(90,25));
		elimcont.setPreferredSize(new Dimension(90,25));
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel botonera=new JPanel();
		p1.add(l1);
		p1.add(tcontrato);
		p2.add(l2);
		p2.add(tmatricula);
		p3.add(l3);
		p3.add(tcliente);
		botonera.add(bcrea);
		botonera.add(modcont);
		botonera.add(elimcont);
		Box caja=Box.createVerticalBox();
		caja.add(p1);
		caja.add(p2);
		caja.add(p3);
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja,botonera);
		sp.setDividerSize(4);
		sp.setEnabled(false);
		pco.add(sp);
		bcrea.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (!formAlta.isVisible())
				{	formAlta.getContentPane().add(panelAlta('c',null));
					formAlta.pack();	
					formAlta.setVisible(true);
				}
			}
		});
		modcont.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (!formAlta.isVisible())
				{	formAlta.getContentPane().add(panelAlta('m',tcontrato.getText()));
					formAlta.pack();	
					formAlta.setVisible(true);
				}
			}
		});
		elimcont.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		return pco;
	}
	
	public JPanel dibujaCliente(boolean editable)
	{
		JPanel panel=new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del cliente",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l1=new JLabel("Nombre ",SwingConstants.RIGHT);
		JLabel l2=new JLabel("DNI/CIF ",SwingConstants.RIGHT);
		JLabel l3=new JLabel("Dirección ",SwingConstants.RIGHT);
		JLabel l4=new JLabel("Código postal ",SwingConstants.RIGHT);
		JLabel l5=new JLabel("Localidad ",SwingConstants.RIGHT);
		JLabel l6=new JLabel("Provincia ",SwingConstants.RIGHT);		
		JLabel l7=new JLabel("Teléfono ",SwingConstants.RIGHT);
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
		{	tnom.setEnabled(false);
			tdni.setEnabled(false);
			tdir.setEnabled(false);
			tcp.setEnabled(false);
			tloc.setEnabled(false);
			tpro.setEnabled(false);
			ttel.setEnabled(false);
			temail.setEnabled(false);
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
		panel.add(caja);
		return panel;
	}

	public JPanel dibujaMultas()
	{
		JPanel pmul=new JPanel();
		pmul.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Multas del contrato",TitledBorder.LEFT,TitledBorder.TOP));
		Box tabla=Box.createVerticalBox();
		JPanel p=new JPanel();
		JLabel l1=new JLabel("Código",SwingConstants.CENTER);
		JLabel l2=new JLabel("Expediente",SwingConstants.CENTER);
		JLabel l3=new JLabel("Boletín",SwingConstants.CENTER);
		JLabel l4=new JLabel("Descripción",SwingConstants.CENTER);
		JLabel l5=new JLabel("Recursos",SwingConstants.CENTER);
		JLabel l6=new JLabel("");
		JLabel l7=new JLabel("");
		l1.setPreferredSize(new Dimension(130,25));
		l2.setPreferredSize(new Dimension(130,25));
		l3.setPreferredSize(new Dimension(130,25));
		l4.setPreferredSize(new Dimension(80,25));
		l5.setPreferredSize(new Dimension(80,25));
		l6.setPreferredSize(new Dimension(25,25));
		l7.setPreferredSize(new Dimension(25,25));
		p.add(l1);
		p.add(l2);
		p.add(l3);
		p.add(l4);
		p.add(l5);
		p.add(l6);
		p.add(l7);
		tabla.add(p);
		for (int i=0;i<9;i++)
		{	JPanel linea=dibujaLineaMulta();
			tabla.add(linea);		
		}
		JScrollPane ptabla=new JScrollPane(tabla,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ptabla.setPreferredSize(new Dimension(700,200));
		JButton bcrea=new JButton("Añadir multa");
		JPanel botonera=new JPanel();
		botonera.add(bcrea);
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,ptabla,botonera);
		sp.setEnabled(false);
		sp.setDividerSize(4);
		pmul.add(sp);
		bcrea.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (!formMulta.isVisible())
				{	formMulta.getContentPane().add(panelMulta('c',null));
					formMulta.pack();
					formMulta.setVisible(true);
				}
			}
		});
		return pmul;
	}
	
	public JPanel panelAlta(char tipo,String codigo)
	{
		if (tipo=='c') formAlta.setTitle("Crear contrato");
		else if (tipo=='m') formAlta.setTitle("Modificar contrato "+codigo);
		JLabel l1=new JLabel("Código del contrato");
		JLabel l2=new JLabel("Matrícula del vehículo");
		JLabel l3=new JLabel("Código del cliente");
		l1.setPreferredSize(new Dimension(150,20));
		l2.setPreferredSize(new Dimension(150,20));
		l3.setPreferredSize(new Dimension(150,20));
		JTextField tcontrato=new JTextField();
		tcontrato.setEditable(false);
		JTextField tcliente=new JTextField();
		JTextField tmatricula=new JTextField();
		tcontrato.setPreferredSize(new Dimension(100,20));
		tcliente.setPreferredSize(new Dimension(100,20));
		tmatricula.setPreferredSize(new Dimension(100,20));
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		p1.add(l1);
		p1.add(tcontrato);
		p2.add(l2);
		p2.add(tmatricula);
		p3.add(l3);
		p3.add(tcliente);
		Box caja=Box.createVerticalBox();
		caja.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del contrato",TitledBorder.LEFT,TitledBorder.TOP));
		caja.add(p1);
		caja.add(p2);
		caja.add(p3);
		JPanel pcl=dibujaCliente(true);
		JSplitPane sp1=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja,pcl);
		sp1.setEnabled(false);		
		sp1.setDividerSize(4);
		JButton aceptar=new JButton("Aceptar");
		JButton cancelar=new JButton("Cancelar");
		JPanel botonera=new JPanel();
		botonera.add(aceptar);
		botonera.add(cancelar);
		JSplitPane sp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp1,botonera);
		sp2.setEnabled(false);		
		sp2.setDividerSize(4);
		JPanel panel=new JPanel();
		panel.add(sp2);
		aceptar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formAlta.setVisible(false);
				formAlta.getContentPane().removeAll();
				modcont.setEnabled(true);
				elimcont.setEnabled(true);
				//validar datos
				//enviar datos a Sigrem para almacenarlos en la estructura de datos
				//cargar contrato en el panel
			}
		});
		cancelar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formAlta.setVisible(false);
				formAlta.getContentPane().removeAll();
			}
		});
		return panel;
	}
		
	public JPanel panelMulta(char tipo,String codigo)
	{
		if (tipo=='c') formMulta.setTitle("Crear multa");
		else if (tipo=='m') formMulta.setTitle("Modificar multa "+codigo);
		JLabel l1=new JLabel("Código");
		JLabel l2=new JLabel("Expediente");
		JLabel l3=new JLabel("Boletín");
		l1.setPreferredSize(new Dimension(80,20));
		l2.setPreferredSize(new Dimension(80,20));
		l3.setPreferredSize(new Dimension(80,20));
		JTextField cod=new JTextField();
		cod.setEditable(false);
		JTextField exp=new JTextField();
		JTextField bol=new JTextField();
		cod.setPreferredSize(new Dimension(100,20));
		exp.setPreferredSize(new Dimension(100,20));
		bol.setPreferredSize(new Dimension(100,20));
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		p1.add(l1);
		p1.add(cod);
		p2.add(l2);
		p2.add(exp);
		p3.add(l3);
		p3.add(bol);
		Box caja1=Box.createVerticalBox();
		caja1.add(p1);
		caja1.add(p2);
		caja1.add(p3);
		JPanel p4=new JPanel();
		p4.add(new JLabel("Descripción"));
		JTextPane texto=new JTextPane();
		JScrollPane ptexto=new JScrollPane(texto,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
		ptexto.setPreferredSize(new Dimension(300,150));
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,p4,ptexto);
		sp.setEnabled(false);		
		sp.setDividerSize(1);
		JSplitPane sp1=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja1,sp);
		sp1.setEnabled(false);		
		sp1.setDividerSize(4);
		JButton aceptar=new JButton("Aceptar");
		JButton cancelar=new JButton("Cancelar");
		JPanel botonera=new JPanel();
		botonera.add(aceptar);
		botonera.add(cancelar);
		JSplitPane sp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp1,botonera);
		sp2.setEnabled(false);		
		sp2.setDividerSize(4);
		JPanel panel=new JPanel();
		panel.add(sp2);
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos de la multa",TitledBorder.LEFT,TitledBorder.TOP));
		aceptar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formMulta.setVisible(false);
				formMulta.getContentPane().removeAll();
				//validar datos
				//enviar datos a Sigrem para almacenarlos en la estructura de datos
			}
		});
		cancelar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formMulta.setVisible(false);
				formMulta.getContentPane().removeAll();
			}
		});
		return panel;
	}
	
	public JPanel panelDescripM(String codigo)
	{
		formDescripM.setTitle("Descripción de la multa "+codigo);
		JPanel panel=panelDescrip('m');
		return panel;
	}
	
	public JPanel panelDescripR(String codigo)
	{
		formDescripR.setTitle("Descripción del recurso "+codigo);
		JPanel panel=panelDescrip('r');
		return panel;
	}
	
	public JPanel panelDescrip(final char tipo)
	{
		JPanel panel=new JPanel();
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		p1.add(new JLabel("Descripción"));
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
				if (tipo=='m')
				{	formDescripM.setVisible(false);
					formDescripM.getContentPane().removeAll();
				}
				else if (tipo=='r')
				{	formDescripR.setVisible(false);
					formDescripR.getContentPane().removeAll();
				}
			}
		});
		return panel;
	}
	
	public JPanel panelRecurso(String codigo)
	{
		formRecurso.setTitle("Recursos de la multa "+codigo);
		JPanel prec=new JPanel();
		prec.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Recursos de la multa "+codigo,TitledBorder.LEFT,TitledBorder.TOP));
		Box tabla=Box.createVerticalBox();
		JPanel p=new JPanel();
		JLabel l1=new JLabel("Código",SwingConstants.CENTER);
		JLabel l2=new JLabel("Estado",SwingConstants.CENTER);
		JLabel l3=new JLabel("Abogado",SwingConstants.CENTER);
		JLabel l4=new JLabel("Descripción",SwingConstants.CENTER);
		JLabel l5=new JLabel("");
		JLabel l6=new JLabel("");
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
		{	JPanel linea=dibujaLineaRecurso();
			tabla.add(linea);
		}
		JScrollPane ptabla=new JScrollPane(tabla,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ptabla.setPreferredSize(new Dimension(600,200));
		JButton bcrea=new JButton("Añadir recurso");
		JPanel botonera=new JPanel();
		botonera.add(bcrea);
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,ptabla,botonera);
		sp.setEnabled(false);
		sp.setDividerSize(4);
		prec.add(sp);
		bcrea.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
			
			}
		});
		return prec;
	}
	
	public JPanel dibujaLineaRecurso()
	{		
		JPanel panel=new JPanel();
		final JTextField cod=new JTextField("R001");
		cod.setEnabled(false);
		cod.setPreferredSize(new Dimension(130,25));
		JTextField est=new JTextField();
		est.setEnabled(false);
		est.setPreferredSize(new Dimension(130,25));
		JTextField abo=new JTextField();
		abo.setEnabled(false);
		abo.setPreferredSize(new Dimension(130,25));
		JButton descrip=new JButton(new ImageIcon("interfaz/find.gif"));
		descrip.setPreferredSize(new Dimension(80,25));
		JButton mod=new JButton(new ImageIcon("interfaz/tick.gif"));
		mod.setPreferredSize(new Dimension(25,25));
		JButton elim=new JButton(new ImageIcon("interfaz/del.gif"));
		elim.setPreferredSize(new Dimension(25,25));
		panel.add(cod);
		panel.add(est);
		panel.add(abo);
		panel.add(descrip);
		panel.add(mod);
		panel.add(elim);
		descrip.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (!formDescripR.isVisible())
				{	formDescripR.getContentPane().add(panelDescripR(cod.getText()));
					formDescripR.pack();
					formDescripR.setVisible(true);
				}
			}
		});
		mod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		elim.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				int seleccion=JOptionPane.showConfirmDialog(null,"         ¿Desea eliminar el recurso "+cod.getText()+"?","Eliminar recurso",JOptionPane.YES_NO_CANCEL_OPTION,-1);
				if (seleccion==JOptionPane.YES_OPTION)
				{	//eliminar multa
					//borrar el panel de multas
					//llamar a dibujaMulta()
				}				
			}
		});
		return panel;
	}
	
	public JPanel dibujaLineaMulta()
	{		
		JPanel panel=new JPanel();
		final JTextField cod=new JTextField("M001");
		cod.setEnabled(false);
		cod.setPreferredSize(new Dimension(130,25));
		JTextField exp=new JTextField();
		exp.setEnabled(false);
		exp.setPreferredSize(new Dimension(130,25));
		JTextField bol=new JTextField();
		bol.setEnabled(false);
		bol.setPreferredSize(new Dimension(130,25));
		JButton descrip=new JButton(new ImageIcon("interfaz/find.gif"));
		descrip.setPreferredSize(new Dimension(80,25));
		JButton recur=new JButton("Ver");
		recur.setPreferredSize(new Dimension(80,25));
		JButton mod=new JButton(new ImageIcon("interfaz/tick.gif"));
		mod.setPreferredSize(new Dimension(25,25));
		JButton elim=new JButton(new ImageIcon("interfaz/del.gif"));
		elim.setPreferredSize(new Dimension(25,25));
		panel.add(cod);
		panel.add(exp);
		panel.add(bol);
		panel.add(descrip);
		panel.add(recur);
		panel.add(mod);
		panel.add(elim);
		descrip.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (!formDescripM.isVisible())
				{	formDescripM.getContentPane().add(panelDescripM(cod.getText()));
					formDescripM.pack();
					formDescripM.setVisible(true);
				}
			}
		});
		recur.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (!formRecurso.isVisible())
				{	formRecurso.getContentPane().add(panelRecurso(cod.getText()));
					formRecurso.pack();
					formRecurso.setVisible(true);
				}
			}
		});
		mod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (!formMulta.isVisible())
				{	formMulta.getContentPane().add(panelMulta('m',cod.getText()));
					formMulta.pack();
					formMulta.setVisible(true);
				}
			}
		});
		elim.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				int seleccion=JOptionPane.showConfirmDialog(null,"          ¿Desea eliminar la multa "+cod.getText()+"?","Eliminar multa",JOptionPane.YES_NO_CANCEL_OPTION,-1);
				if (seleccion==JOptionPane.YES_OPTION)
				{	//eliminar multa
					//borrar el panel de multas
					//llamar a dibujaMulta()
				}				
			}
		});
		return panel;
	}
}