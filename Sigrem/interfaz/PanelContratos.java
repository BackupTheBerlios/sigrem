package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import main.Sigrem;
import java.util.LinkedList;

public class PanelContratos extends JPanel
{
	private Sigrem controlador;
	
	private JDialog formAlta;
	
	private JDialog formMulta;
	
	private JDialog formDescripM;
	
	private JDialog formDescripR;
	
	private JDialog formRecurso;
	
	private JDialog formAltaRec;
	
	private JDialog formBaja;
	
	private JDialog formMod;
	
	public PanelContratos(Sigrem controlador,JFrame v)
	{
		super();
		this.controlador=controlador;
		formAlta=new JDialog(v,true);
		formAlta.setResizable(false);
		formAlta.setLocation(350,100);
		formBaja=new JDialog(v,true);
		formBaja.setResizable(false);
		formBaja.setLocation(350,100);
		formMod=new JDialog(v,true);
		formMod.setResizable(false);
		formMod.setLocation(350,100);
		formMulta=new JDialog(v,true);
		formMulta.setResizable(false);
		formMulta.setLocation(350,150);
		formDescripM=new JDialog(v,true);
		formDescripM.setResizable(false);
		formDescripM.setLocation(350,200);
		formDescripR=new JDialog(v,true);
		formDescripR.setResizable(false);
		formDescripR.setLocation(350,100);
		formRecurso=new JDialog(v,true);
		formRecurso.setResizable(false);
		formRecurso.setLocation(200,100);
		formAltaRec=new JDialog(v,true);
		formAltaRec.setResizable(false);
		formAltaRec.setLocation(350,100);
		dibujaPaneles(false);
	}
	
	public void dibujaPaneles(boolean multas)
	{
		JPanel pcontrato=dibujaContrato();
		pcontrato.setPreferredSize(new Dimension(314,0));
		JPanel pcliente=dibujaCliente();
		pcliente.setPreferredSize(new Dimension(0,260));
		JPanel pmultas=new JPanel();
		if (multas) 
		{	pmultas=dibujaMultas();}
		else
		{	pmultas.setPreferredSize(new Dimension(724,280));
			pmultas.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"",TitledBorder.LEFT,TitledBorder.TOP));		
		}
		JSplitPane sp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pcontrato,pcliente);
		sp1.setDividerSize(4);
		sp1.setEnabled(false);
		JSplitPane sp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp1,pmultas);
		sp2.setEnabled(false);		
		sp2.setDividerSize(4);
		add(sp2);		
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
		tcontrato.setEditable(false);
		tcliente.setEditable(false);
		tmatricula.setEditable(false);
		tcontrato.setBackground(Color.WHITE);
		tcliente.setBackground(Color.WHITE);
		tmatricula.setBackground(Color.WHITE);
		JButton bcrea=new JButton ("Crear");
		JButton belimcont=new JButton("Eliminar");
		JButton bmodcont=new JButton("Modificar");
		bcrea.setPreferredSize(new Dimension(90,25));
		bmodcont.setPreferredSize(new Dimension(90,25));
		belimcont.setPreferredSize(new Dimension(90,25));
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
		botonera.add(belimcont);
		botonera.add(bmodcont);
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
		bmodcont.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (!formMod.isVisible())
				{	formMod.getContentPane().add(panelMod(tcontrato.getText()));
					formMod.pack();	
					formMod.setVisible(true);
				}
			}
		});
		belimcont.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (!formBaja.isVisible())
				{	formBaja.getContentPane().add(panelBaja(tcontrato.getText()));
					formBaja.pack();	
					formBaja.setVisible(true);
				}
			}
		});
		return pco;
	}
	
	public JPanel dibujaCliente()
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
		JLabel l9=new JLabel("Contratos ",SwingConstants.RIGHT);
		l9.setPreferredSize(new Dimension(80,40));
		JTextArea conts=new JTextArea();
		conts.setEditable(false);
		conts.append("C001\n");
		conts.append("C002\n");
		conts.append("C003\n");
		conts.append("C004\n");
		JScrollPane spanel=new JScrollPane(conts,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spanel.setPreferredSize(new Dimension(20,40));
		JLabel relleno6=new JLabel("");
		relleno6.setPreferredSize(new Dimension(15,40));
		JLabel relleno7=new JLabel("");
		relleno7.setPreferredSize(new Dimension(0,10));
		JLabel relleno8=new JLabel("");
		relleno8.setPreferredSize(new Dimension(0,10));
		JButton nuevoContrato=new JButton("Nuevo Contrato");
		Box c9=Box.createHorizontalBox();
		c9.add(l9);
		c9.add(spanel);
		c9.add(relleno6);
		c9.add(nuevoContrato);
		caja.add(relleno7);
		caja.add(new JSeparator());
		caja.add(relleno8);
		caja.add(c9);
		panel.add(caja);
		nuevoContrato.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (!formAlta.isVisible())
				{	formAlta.getContentPane().add(panelAlta('n',null));
					formAlta.pack();	
					formAlta.setVisible(true);
				}
			}
		});
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
		final JTextField tcontrato=new JTextField();
		tcontrato.setEditable(false);
		final JTextField tcliente=new JTextField();
		final JTextField tmatricula=new JTextField();
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
		Box caja1=Box.createVerticalBox();
		caja1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del contrato",TitledBorder.LEFT,TitledBorder.TOP));
		caja1.add(p1);
		caja1.add(p2);
		caja1.add(p3);
		JPanel pcl=new JPanel();
		pcl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del cliente",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l9=new JLabel("Nombre ",SwingConstants.RIGHT);
		JLabel l10=new JLabel("DNI/CIF ",SwingConstants.RIGHT);
		JLabel l11=new JLabel("Dirección ",SwingConstants.RIGHT);
		JLabel l4=new JLabel("Código postal ",SwingConstants.RIGHT);
		JLabel l5=new JLabel("Localidad ",SwingConstants.RIGHT);
		JLabel l6=new JLabel("Provincia ",SwingConstants.RIGHT);		
		JLabel l7=new JLabel("Teléfono ",SwingConstants.RIGHT);
		JLabel l8=new JLabel("email ",SwingConstants.RIGHT);
		l11.setPreferredSize(new Dimension(80,20));
		l10.setPreferredSize(new Dimension(80,20));
		l9.setPreferredSize(new Dimension(80,20));
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
		final JTextField tnom=new JTextField();
		final JTextField tdni=new JTextField();
		final JTextField tdir=new JTextField();
		final JTextField tcp=new JTextField();
		final JTextField tloc=new JTextField();
		final JTextField tpro=new JTextField();
		final JTextField ttel=new JTextField();
		final JTextField temail=new JTextField();
		tnom.setPreferredSize(new Dimension(200,20));
		tdni.setPreferredSize(new Dimension(100,20));
		tdir.setPreferredSize(new Dimension(200,20));
		tcp.setPreferredSize(new Dimension(60,20));
		tloc.setPreferredSize(new Dimension(180,20));
		tpro.setPreferredSize(new Dimension(160,20));
		ttel.setPreferredSize(new Dimension(80,20));
		temail.setPreferredSize(new Dimension(80,20));
		if (tipo == 'n')
		{
			tnom.setEditable(false);
			tdni.setEditable(false);
			tdir.setEditable(false);
			tcp.setEditable(false);
			tloc.setEditable(false);
			tpro.setEditable(false);
			ttel.setEditable(false);
			temail.setEditable(false);
		}
		Box c1=Box.createHorizontalBox();
		Box c2=Box.createHorizontalBox();
		Box c3=Box.createHorizontalBox();
		Box c4=Box.createHorizontalBox();
		Box c5=Box.createHorizontalBox();
		Box c6=Box.createHorizontalBox();
		Box c7=Box.createHorizontalBox();
		Box c8=Box.createHorizontalBox();
		c1.add(l9);
		c1.add(tnom);
		c2.add(l10);
		c2.add(tdni);
		c2.add(relleno1);
		c3.add(l11);
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
		Box caja2=Box.createVerticalBox();
		caja2.add(c1);
		caja2.add(c2);
		caja2.add(c3);
		caja2.add(c4);
		caja2.add(c5);
		caja2.add(c6);
		caja2.add(c7);
		caja2.add(c8);
		pcl.add(caja2);
		JSplitPane sp1=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja1,pcl);
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
				LinkedList datoscontrato=new LinkedList();
				LinkedList datoscliente=new LinkedList();
				datoscontrato.add(tcontrato.getText());
				datoscontrato.add(tcliente.getText());
				datoscontrato.add(tmatricula.getText());
				datoscliente.add(tnom.getText());
				datoscliente.add(tdni.getText());
				datoscliente.add(tdir.getText());
				datoscliente.add(tcp.getText());
				datoscliente.add(tloc.getText());
				datoscliente.add(tpro.getText());
				datoscliente.add(ttel.getText());
				datoscliente.add(temail.getText());
				//controlador.añadirContrato(datoscontrato,datoscliente);
				removeAll();
				dibujaPaneles(true);
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
	
	public JPanel panelBaja(String codigo)
	{
		formBaja.setTitle("Eliminar contrato");		
		JLabel l=new JLabel("Introduce el código del contrato");
		final JTextField tcodigo=new JTextField(codigo);		
		tcodigo.setPreferredSize(new Dimension(100,20));		
		JPanel pcodigo=new JPanel();		
		pcodigo.add(l);
		pcodigo.add(tcodigo);	
		Box caja=Box.createVerticalBox();
		caja.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del contrato",TitledBorder.LEFT,TitledBorder.TOP));
		caja.add(pcodigo);		
		JPanel p2=new JPanel();
		JButton bacepta=new JButton ("Aceptar");
		JButton bcancela=new JButton ("Cancelar");
		p2.add(bacepta);
		p2.add(bcancela);
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja,p2);
		sp.setDividerSize(4);
		sp.setEnabled(false);
		JPanel pbaja=new JPanel();
		pbaja.add(sp);
		bacepta.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formBaja.setVisible(false);
				int seleccion=JOptionPane.showConfirmDialog(null,"           ¿Desea eliminar el contrato "+tcodigo.getText()+"?","Eliminar contrato",JOptionPane.YES_NO_CANCEL_OPTION,-1);
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
		return pbaja;
	}
	
	public JPanel panelMod(final String codigo)
	{
		formMod.setTitle("Modificar contrato");		
		JLabel l=new JLabel("Introduce el código del contrato");
		final JTextField tcodigo=new JTextField(codigo);		
		tcodigo.setPreferredSize(new Dimension(100,20));		
		JPanel pcodigo=new JPanel();		
		pcodigo.add(l);
		pcodigo.add(tcodigo);	
		Box caja=Box.createVerticalBox();
		caja.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del contrato",TitledBorder.LEFT,TitledBorder.TOP));
		caja.add(pcodigo);		
		JPanel p2=new JPanel();
		JButton bacepta=new JButton ("Aceptar");
		JButton bcancela=new JButton ("Cancelar");
		p2.add(bacepta);
		p2.add(bcancela);
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja,p2);
		sp.setDividerSize(4);
		sp.setEnabled(false);
		JPanel pmod=new JPanel();
		pmod.add(sp);
		bacepta.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formMod.setVisible(false);
				formMod.getContentPane().removeAll();
				if (!formAlta.isVisible())
				{	formAlta.getContentPane().add(panelAlta('m',codigo));
					formAlta.pack();	
					formAlta.setVisible(true);
				}
			}
		});
		bcancela.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formMod.setVisible(false);
				formMod.getContentPane().removeAll();
			}
		});
		return pmod;
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
		JButton baceptar=new JButton("Aceptar");
		JPanel botonera=new JPanel();
		botonera.add(bcrea);
		JSplitPane sp1=new JSplitPane(JSplitPane.VERTICAL_SPLIT,ptabla,botonera);
		sp1.setEnabled(false);
		sp1.setDividerSize(4);
		JPanel paceptar=new JPanel();
		paceptar.add(baceptar);
		JSplitPane sp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp1,paceptar);
		sp2.setEnabled(false);
		sp2.setDividerSize(4);
		prec.add(sp2);
		bcrea.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (!formAltaRec.isVisible())
				{	formAltaRec.getContentPane().add(panelAltaRec('c',null));
					formAltaRec.pack();
					formAltaRec.setVisible(true);
				}
			}
		});
		baceptar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formRecurso.setVisible(false);
				formRecurso.getContentPane().removeAll();			
			}
		});
		return prec;
	}
	
	public JPanel panelAltaRec(char tipo, String codigo)
	{
		if (tipo=='c') formAltaRec.setTitle("Crear recurso");
		else if (tipo=='m') formAltaRec.setTitle("Modificar recurso "+codigo);
		JLabel l1=new JLabel("Código");
		JLabel l2=new JLabel("Estado");
		JLabel l3=new JLabel("Abogado");
		l1.setPreferredSize(new Dimension(80,20));
		l2.setPreferredSize(new Dimension(80,20));
		l3.setPreferredSize(new Dimension(80,20));
		JTextField cod=new JTextField();
		cod.setEditable(false);
		JTextField est=new JTextField();
		JTextField abo=new JTextField();
		cod.setPreferredSize(new Dimension(100,20));
		est.setPreferredSize(new Dimension(100,20));
		abo.setPreferredSize(new Dimension(100,20));
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		p1.add(l1);
		p1.add(cod);
		p2.add(l2);
		p2.add(est);
		p3.add(l3);
		p3.add(abo);
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
				formAltaRec.setVisible(false);
				formAltaRec.getContentPane().removeAll();
				//validar datos
				//enviar datos a Sigrem para almacenarlos en la estructura de datos
			}
		});
		cancelar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formAltaRec.setVisible(false);
				formAltaRec.getContentPane().removeAll();
			}
		});
		return panel;
	}
	
	public JPanel dibujaLineaRecurso()
	{		
		JPanel panel=new JPanel();
		final JTextField cod=new JTextField("R001");
		cod.setEditable(false);
		cod.setBackground(Color.WHITE);
		cod.setPreferredSize(new Dimension(130,25));
		JTextField est=new JTextField();
		est.setEditable(false);
		est.setBackground(Color.WHITE);
		est.setPreferredSize(new Dimension(130,25));
		JTextField abo=new JTextField();
		abo.setEditable(false);
		abo.setBackground(Color.WHITE);
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
				if (!formAltaRec.isVisible())
				{	formAltaRec.getContentPane().add(panelAltaRec('m',cod.getText()));
					formAltaRec.pack();
					formAltaRec.setVisible(true);
				}
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
		cod.setEditable(false);
		cod.setBackground(Color.WHITE);
		cod.setPreferredSize(new Dimension(130,25));
		JTextField exp=new JTextField();
		exp.setEditable(false);
		exp.setBackground(Color.WHITE);
		exp.setPreferredSize(new Dimension(130,25));
		JTextField bol=new JTextField();
		bol.setEditable(false);
		bol.setBackground(Color.WHITE);
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