package interfaz;

import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.awt.GridLayout;

public class PanelContratos extends JPanel
{
	private JFrame formAlta;
	
	private JFrame formMulta;
	
	private JButton elimcont;
	
	private JButton modcont;
	
	public PanelContratos()
	{
		super();
		modcont=new JButton ("Modificar");
		elimcont=new JButton ("Eliminar");
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
	}
		
	public JPanel dibujaContrato()
	{
		JPanel pco=new JPanel();
		pco.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del contrato",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l1=new JLabel("C�digo del contrato");
		JLabel l2=new JLabel("Matr�cula del veh�culo");
		JLabel l3=new JLabel("C�digo del cliente");
		l1.setPreferredSize(new Dimension(150,20));
		l2.setPreferredSize(new Dimension(150,20));
		l3.setPreferredSize(new Dimension(150,20));
		JTextField tcontrato=new JTextField();
		JTextField tcliente=new JTextField();
		JTextField tmatricula=new JTextField();
		tcontrato.setPreferredSize(new Dimension(100,20));
		tcliente.setPreferredSize(new Dimension(100,20));
		tmatricula.setPreferredSize(new Dimension(100,20));
		tcontrato.setEnabled(false);
		tcliente.setEnabled(false);
		tmatricula.setEnabled(false);
		JButton bcrea=new JButton ("Crear");
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
				{	formAlta.getContentPane().add(panelAlta());
					formAlta.pack();	
					formAlta.setVisible(true);
				}
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
	/*	int f=8;
		int c=5;
		JPanel tabla=new JPanel(new GridLayout(f,c));
		tabla.add(new JLabel("C�digo",SwingConstants.CENTER));
		tabla.add(new JLabel("Expediente",SwingConstants.CENTER));
		tabla.add(new JLabel("Bolet�n",SwingConstants.CENTER));
		tabla.add(new JLabel("Descripci�n",SwingConstants.CENTER));
		tabla.add(new JLabel("Recursos",SwingConstants.CENTER));
		for (int i=1;i<f;i++)
			for (int j=0;j<c;j++)
			{	if (j<3)
				{	JTextField texto=new JTextField();
					texto.setEnabled(false);
					texto.setPreferredSize(new Dimension(70,20));
					tabla.add(texto);
				}
				else
				{	JButton boton=new JButton("Ver");
					boton.setPreferredSize(new Dimension(30,20));
					tabla.add(boton);					
				}
			}
		JScrollPane ptabla=new JScrollPane(tabla,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ptabla.setPreferredSize(new Dimension(600,200));
		JButton bcrea=new JButton("A�adir");
		JButton bmod=new JButton("Modifica");
		JButton belim=new JButton("Eliminar");
		bcrea.setPreferredSize(new Dimension(85,25));
		bmod.setPreferredSize(new Dimension(85,25));
		belim.setPreferredSize(new Dimension(85,25));
		JPanel botonera=new JPanel();
		botonera.add(bcrea);
		botonera.add(bmod);
		botonera.add(belim);
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,ptabla,botonera);
		sp.setEnabled(false);
		sp.setDividerSize(4);
		JPanel pmul=new JPanel();
		pmul.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Multas del contrato",TitledBorder.LEFT,TitledBorder.TOP));
		pmul.add(sp);		
*/
		Box tabla=Box.createVerticalBox();
		JPanel p=new JPanel();
		JLabel l1=new JLabel("C�digo",SwingConstants.CENTER);
		JLabel l2=new JLabel("Expediente",SwingConstants.CENTER);
		JLabel l3=new JLabel("Bolet�n",SwingConstants.CENTER);
		JLabel l4=new JLabel("Descripci�n",SwingConstants.CENTER);
		JLabel l5=new JLabel("Recursos",SwingConstants.CENTER);
	//	JLabel l1=new JLabel("C�digo");
	//	JLabel l2=new JLabel("Expediente");
	//	JLabel l3=new JLabel("Bolet�n");
	//	JLabel l4=new JLabel("Descripci�n");
	//	JLabel l5=new JLabel("Recursos");
		l1.setPreferredSize(new Dimension(130,25));
		l2.setPreferredSize(new Dimension(130,25));
		l3.setPreferredSize(new Dimension(130,25));
		l4.setPreferredSize(new Dimension(80,25));
		l5.setPreferredSize(new Dimension(80,25));
		p.add(l1);
		p.add(l2);
		p.add(l3);
		p.add(l4);
		p.add(l5);
		tabla.add(p);
		for (int i=0;i<9;i++)
		{	JPanel linea=dibujaLinea();
			tabla.add(linea);		
		}
		JScrollPane ptabla=new JScrollPane(tabla,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ptabla.setPreferredSize(new Dimension(600,200));
		JButton bcrea=new JButton("A�adir");
		JButton bmod=new JButton("Modifica");
		JButton belim=new JButton("Eliminar");
		bcrea.setPreferredSize(new Dimension(85,25));
		bmod.setPreferredSize(new Dimension(85,25));
		belim.setPreferredSize(new Dimension(85,25));
		JPanel botonera=new JPanel();
		botonera.add(bcrea);
		botonera.add(bmod);
		botonera.add(belim);
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,ptabla,botonera);
		sp.setEnabled(false);
		sp.setDividerSize(4);
		JPanel pmul=new JPanel();
		pmul.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Multas del contrato",TitledBorder.LEFT,TitledBorder.TOP));
		pmul.add(sp);
		bcrea.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (!formMulta.isVisible())
				{	formMulta.getContentPane().add(panelMulta());
					formMulta.pack();
					formMulta.setVisible(true);
				}
			}
		});
		return pmul;
	}
	
	public JPanel panelAlta()
	{
		formAlta.setTitle("Crear contrato");
		JLabel l1=new JLabel("C�digo del contrato");
		JLabel l2=new JLabel("Matr�cula del veh�culo");
		JLabel l3=new JLabel("C�digo del cliente");
		l1.setPreferredSize(new Dimension(150,20));
		l2.setPreferredSize(new Dimension(150,20));
		l3.setPreferredSize(new Dimension(150,20));
		JTextField tcontrato=new JTextField();
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
				formMulta.setVisible(false);
				formMulta.getContentPane().removeAll();
			}
		});
		return panel;
	}
	
	public JPanel dibujaLinea()
	{		
		JPanel panel=new JPanel();
		final JButton selec=new JButton();
		selec.setPreferredSize(new Dimension (25,25));
		final JTextField cod=new JTextField();
		cod.setEnabled(false);
		cod.setPreferredSize(new Dimension(130,25));
		final JTextField exp=new JTextField();
		exp.setEnabled(false);
		exp.setPreferredSize(new Dimension(130,25));
		final JTextField bol=new JTextField();
		bol.setEnabled(false);
		bol.setPreferredSize(new Dimension(130,25));
		final JButton descrip=new JButton("Ver");
		descrip.setPreferredSize(new Dimension(80,25));
		final JButton recur=new JButton("Ver");
		recur.setPreferredSize(new Dimension(80,25));
//		panel.add(selec);
		panel.add(cod);
		panel.add(exp);
		panel.add(bol);
		panel.add(descrip);
		panel.add(recur);
		selec.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{	
				
		
			}
		});
		return panel;
	}
	
	public JPanel panelMulta()
	{
		formMulta.setTitle("Crear multa");
		JLabel l1=new JLabel("C�digo");
		JLabel l2=new JLabel("Expediente");
		JLabel l3=new JLabel("Bolet�n");
		l1.setPreferredSize(new Dimension(80,20));
		l2.setPreferredSize(new Dimension(80,20));
		l3.setPreferredSize(new Dimension(80,20));
		JTextField cod=new JTextField();
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
		p4.add(new JLabel("Descripci�n"));
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
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos de lla multa",TitledBorder.LEFT,TitledBorder.TOP));
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
}