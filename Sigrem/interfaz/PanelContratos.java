package interfaz;

import java.awt.Color;
import java.util.Calendar;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import main.Sigrem;
import java.util.LinkedList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class PanelContratos extends JPanel
{
	private Sigrem controlador;
	
	private JDialog formulario;
	
	private JDialog formRecurso;
	
	private JDialog formConsulta;
		
	private LinkedList datosModificables;
	
	private JTextField codigoCliente;
	
	private JTextField codigoContrato;
	
	private Box cajaMultas;
	
	private JComboBox selector;
	
	public PanelContratos(Sigrem controlador,JFrame v)
	{
		super();
		this.controlador=controlador;
		datosModificables=new LinkedList();
		formulario=new JDialog(v,true);
		formulario.setResizable(false);
		formulario.addWindowListener(new WindowAdapter()
		{	public void windowClosing(WindowEvent e)
			{
				formulario.getContentPane().removeAll();
			}
		});	
		formRecurso=new JDialog(formulario,true);
		formRecurso.setResizable(false);
		formRecurso.addWindowListener(new WindowAdapter()
		{	public void windowClosing(WindowEvent e)
			{
				formRecurso.getContentPane().removeAll();
			}
		});
		formConsulta=new JDialog();
		formConsulta.setResizable(false);
		formConsulta.addWindowListener(new WindowAdapter()
		{	public void windowClosing(WindowEvent e)
			{
				formConsulta.getContentPane().removeAll();
			}
		});
		JPanel pcontrato=dibujaContrato(null);
		JPanel pcliente=dibujaCliente(null);
		JPanel pmultas=dibujaMultas(false,null);
		JSplitPane sp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pcontrato,pcliente);
		sp1.setDividerSize(4);
		sp1.setEnabled(false);
		JSplitPane sp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp1,pmultas);
		sp2.setEnabled(false);		
		sp2.setDividerSize(4);
		add(sp2);
		inicializaCajaMultas();
	}
	
	public void actualiza(int panel,LinkedList datos)
	{
		if (panel==1)
		{	JSplitPane sp=((JSplitPane)getComponent(0));
			((JSplitPane)sp.getComponent(0)).setLeftComponent(dibujaContrato(datos));
		}
		else if (panel==2)
		{	JSplitPane sp=((JSplitPane)getComponent(0));
			((JSplitPane)sp.getComponent(0)).setRightComponent(dibujaCliente(datos));
		}
		else if (panel==3)
		{	JSplitPane sp=((JSplitPane)getComponent(0));
			sp.setBottomComponent(dibujaMultas(true,datos));
		}
	}
	
	public void actualizaDatosModificables(LinkedList datos,boolean dibujar)
	{
		for (int i=0;i<datos.size();i++) datosModificables.addLast(datos.get(i));
		if (dibujar)
		{	formulario.getContentPane().add(panelAltaContrato('m',(String)datosModificables.get(0),datosModificables));
			formulario.pack();
			formulario.setVisible(true);
			datosModificables=new LinkedList();
		}
	}
	
	public void actualizaCajaMultas(char tipo,LinkedList datos)
	{
		if (tipo=='a')
		{	int lineas=cajaMultas.getComponentCount();
			cajaMultas.add(dibujaLineaMulta(datos),lineas-1);
		}
		else 
		{	int i=0;
			boolean esta=false;
			while((!esta) && (i<cajaMultas.getComponentCount()-1))
			{	JPanel panel=(JPanel)cajaMultas.getComponent(i);
				JTextField texto=(JTextField)panel.getComponent(0);
				String codigo=(String)datos.get(0);
				if (codigo.equals(texto.getText()))
				{	esta=true;
					cajaMultas.remove(i);
					if (tipo=='m') cajaMultas.add(dibujaLineaMulta(datos),i);	
				}
				i++;
			}			
		}		
	}
	
	public void actualizaPanelConsulta(String nombre,Vector dnis)
	{
		formConsulta.setTitle("Resultados de la consulta");
		formConsulta.setLocation(350,200);
		JLabel l1=new JLabel("Se han encontrado los siguientes clientes con nombre "+nombre);
		JLabel l2=new JLabel("Selecciona el DNI/CIF del cliente:");
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
		formConsulta.getContentPane().add(sp);
		formConsulta.pack();
		formConsulta.setVisible(true);
		dni.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				controlador.consultarClienteDni((String)dni.getSelectedItem());
				formConsulta.setVisible(false);
				formConsulta.getContentPane().removeAll();				
			}
		});
	}
	
	public void inicializaCajaMultas()
	{
		cajaMultas=Box.createVerticalBox();
		JLabel relleno=new JLabel("");
		relleno.setPreferredSize(new Dimension(20,100));
		cajaMultas.add(relleno);		
	}
	
	public JPanel dibujaContrato(LinkedList datos)
	{
		JPanel pco=new JPanel();
		pco.setPreferredSize(new Dimension(314,0));
		pco.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del contrato",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l1=new JLabel("Código del contrato");
		JLabel l2=new JLabel("Código del cliente");
		JLabel l3=new JLabel("Matrícula del vehículo");
		JLabel l4=new JLabel("Fecha de alta");		
		l1.setPreferredSize(new Dimension(150,20));
		l2.setPreferredSize(new Dimension(150,20));
		l3.setPreferredSize(new Dimension(150,20));
		l4.setPreferredSize(new Dimension(150,20));
		codigoContrato=new JTextField();
		codigoCliente=new JTextField();
		JTextField tfechaalta=new JTextField();
		JTextField tmatricula=new JTextField();
		if (datos!=null)
		{	codigoContrato.setText((String)datos.get(0));
			codigoCliente.setText((String)datos.get(1));
			tmatricula.setText((String)datos.get(2));
			tfechaalta.setText((String)datos.get(3));
		}
		codigoContrato.setPreferredSize(new Dimension(100,20));
		codigoCliente.setPreferredSize(new Dimension(100,20));
		tmatricula.setPreferredSize(new Dimension(100,20));
		tfechaalta.setPreferredSize(new Dimension(100,20));
		codigoContrato.setEditable(false);
		codigoCliente.setEditable(false);
		tfechaalta.setEditable(false);
		tmatricula.setEditable(false);
		codigoContrato.setBackground(Color.WHITE);
		codigoCliente.setBackground(Color.WHITE);
		tfechaalta.setBackground(Color.WHITE);
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
		JPanel p4=new JPanel();
		JPanel botonera=new JPanel();
		p1.add(l1);
		p1.add(codigoContrato);
		p2.add(l2);
		p2.add(codigoCliente);
		p3.add(l3);
		p3.add(tmatricula);
		p4.add(l4);
		p4.add(tfechaalta);
		botonera.add(bcrea);
		botonera.add(belimcont);
		botonera.add(bmodcont);
		Box caja=Box.createVerticalBox();
		caja.add(p1);
		caja.add(p2);
		caja.add(p3);
		caja.add(p4);
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja,botonera);
		sp.setDividerSize(4);
		sp.setEnabled(false);
		pco.add(sp);
		bcrea.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formulario.getContentPane().add(panelAltaContrato('c',null,null));
				formulario.pack();	
				formulario.setVisible(true);
			}
		});
		bmodcont.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formulario.getContentPane().add(panelMododificarContrato(codigoContrato.getText()));
				formulario.pack();	
				formulario.setVisible(true);
			}
		});
		belimcont.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formulario.getContentPane().add(panelBajaContrato(codigoContrato.getText()));
				formulario.pack();	
				formulario.setVisible(true);				
			}
		});
		return pco;
	}
	
	public JPanel dibujaCliente(final LinkedList datos)
	{
		JPanel pcl=new JPanel();
		pcl.setPreferredSize(new Dimension(0,320));
		pcl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del cliente",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l1=new JLabel("Nombre ",SwingConstants.RIGHT);
		JLabel l2=new JLabel("DNI/CIF ",SwingConstants.RIGHT);
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
		relleno5.setPreferredSize(new Dimension(20,20));
		relleno6.setPreferredSize(new Dimension(100,20));
		relleno7.setPreferredSize(new Dimension(100,20));
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
		c8.add(relleno6);
		c9.add(l9);
		c9.add(tmov);
		c9.add(relleno7);
		c10.add(l10);
		c10.add(temail);
		c10.add(relleno5);
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
		JLabel l12=new JLabel("Contratos ",SwingConstants.RIGHT);
		l12.setPreferredSize(new Dimension(80,20));
		selector=new JComboBox();
		selector.setEditable(false);
		selector.setPreferredSize(new Dimension(80,20));
		if (datos!=null)
		{	LinkedList contratos=(LinkedList)datos.get(11);
			for (int i=0;i<contratos.size();i++)
				selector.addItem((String)contratos.get(i));		
		}
		JLabel relleno9=new JLabel("");
		relleno9.setPreferredSize(new Dimension(15,20));
		JLabel relleno10=new JLabel("");
		relleno10.setPreferredSize(new Dimension(0,10));
		JLabel relleno11=new JLabel("");
		relleno11.setPreferredSize(new Dimension(0,10));
		JButton nuevoContrato=new JButton("Nuevo Contrato");
		Box c12=Box.createHorizontalBox();
		c12.add(l12);
		c12.add(selector);
		c12.add(relleno9);
		c12.add(nuevoContrato);
		caja.add(relleno10);
		caja.add(new JSeparator());
		caja.add(relleno11);
		caja.add(c12);
		pcl.add(caja);
		nuevoContrato.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (datos!=null)
				{	formulario.getContentPane().add(panelAltaContrato('n',null,datos));
					formulario.pack();
					formulario.setVisible(true);
				}
				else
				{	formulario.getContentPane().add(panelAltaContrato('c',null,datos));
					formulario.pack();	
					formulario.setVisible(true);
				}
			}
		});
		selector.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				inicializaCajaMultas();
				controlador.consultarContratoCodigo(false,false,(String)selector.getSelectedItem());
			}
		});
		return pcl;
	}

	public JPanel dibujaMultas(boolean activo,LinkedList datos)
	{
		JPanel pmul=new JPanel();
		pmul.setPreferredSize(new Dimension(950,280));
		pmul.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Multas del contrato",TitledBorder.LEFT,TitledBorder.TOP));
		if (activo)
		{	JPanel p=new JPanel();
			JLabel l1=new JLabel("Código",SwingConstants.CENTER);
			JLabel l2=new JLabel("Expediente",SwingConstants.CENTER);
			JLabel l3=new JLabel("Boletín",SwingConstants.CENTER);
			JLabel l4=new JLabel("Fecha denuncia",SwingConstants.CENTER);
			JLabel l5=new JLabel("Infracción",SwingConstants.CENTER);
			JLabel l6=new JLabel("Descripción",SwingConstants.CENTER);
			JLabel l7=new JLabel("Recursos",SwingConstants.CENTER);
			JLabel l8=new JLabel("");
			JLabel l9=new JLabel("");
			l1.setPreferredSize(new Dimension(100,20));
			l2.setPreferredSize(new Dimension(100,20));
			l3.setPreferredSize(new Dimension(100,20));
			l4.setPreferredSize(new Dimension(100,20));
			l5.setPreferredSize(new Dimension(250,20));
			l6.setPreferredSize(new Dimension(80,20));
			l7.setPreferredSize(new Dimension(80,20));
			l8.setPreferredSize(new Dimension(25,20));
			l9.setPreferredSize(new Dimension(30,20));
			p.add(l1);
			p.add(l2);
			p.add(l3);
			p.add(l4);
			p.add(l5);
			p.add(l6);
			p.add(l7);
			p.add(l8);
			p.add(l9);
			JScrollPane ptabla=new JScrollPane(cajaMultas,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			ptabla.setPreferredSize(new Dimension(930,170));
			JSplitPane sp1=new JSplitPane(JSplitPane.VERTICAL_SPLIT,p,ptabla);
			sp1.setEnabled(false);
			sp1.setDividerSize(4);
			JButton bcrea=new JButton("Añadir multa");
			JPanel botonera=new JPanel();
			botonera.add(bcrea);
			JSplitPane sp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp1,botonera);
			sp2.setEnabled(false);
			sp2.setDividerSize(4);
			pmul.add(sp2);
			bcrea.addActionListener(new ActionListener()
			{	public void actionPerformed(ActionEvent e)
				{
					formulario.getContentPane().add(panelAltaMulta('c',null,null,null));
					formulario.pack();
					formulario.setVisible(true);				
				}
			});
		}
		return pmul;
	}
	
	public JPanel dibujaRecursos(String codigo)
	{
		formulario.setTitle("Recursos de la multa "+codigo);
		formulario.setLocation(25,100);
		JPanel prec=new JPanel();
		prec.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Recursos de la multa "+codigo,TitledBorder.LEFT,TitledBorder.TOP));
		Box tabla=Box.createVerticalBox();
		JPanel p=new JPanel();
		JLabel l1=new JLabel("Código",SwingConstants.CENTER);
		JLabel l2=new JLabel("Fecha de emisión",SwingConstants.CENTER);
		JLabel l4=new JLabel("Escrito recibido",SwingConstants.CENTER);
		JLabel l5=new JLabel("Escrito presentado",SwingConstants.CENTER);
		JLabel l6=new JLabel("Estado",SwingConstants.CENTER);
		JLabel l7=new JLabel("Abogado",SwingConstants.CENTER);
		JLabel l8=new JLabel("Descripción",SwingConstants.CENTER);
		JLabel l9=new JLabel("",SwingConstants.CENTER);
		JLabel l10=new JLabel("",SwingConstants.CENTER);
		l1.setPreferredSize(new Dimension(80,20));
		l2.setPreferredSize(new Dimension(90,20));
		l4.setPreferredSize(new Dimension(190,20));
		l5.setPreferredSize(new Dimension(190,20));
		l6.setPreferredSize(new Dimension(90,20));
		l7.setPreferredSize(new Dimension(90,20));
		l8.setPreferredSize(new Dimension(80,20));
		l9.setPreferredSize(new Dimension(25,20));
		l10.setPreferredSize(new Dimension(25,20));
		p.add(l1);
		p.add(l2);
		p.add(l4);
		p.add(l5);
		p.add(l6);
		p.add(l7);
		p.add(l8);
		p.add(l9);
		p.add(l10);
		tabla.add(p);
		for (int i=0;i<9;i++)
		{	JPanel linea=dibujaLineaRecurso();
			tabla.add(linea);		
		}
		JScrollPane ptabla=new JScrollPane(tabla,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		ptabla.setPreferredSize(new Dimension(940,300));
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
				formRecurso.getContentPane().add(panelAltaRecurso('c',null));
				formRecurso.pack();
				formRecurso.setVisible(true);				
			}
		});
		baceptar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formulario.setVisible(false);
				formulario.getContentPane().removeAll();			
			}
		});
		return prec;
	}
	
	public JPanel panelAltaContrato(final char tipo,String codigo,final LinkedList datos)
	{
		if ((tipo=='c') || (tipo=='n'))
		{	formulario.setTitle("Crear contrato");}
		else if (tipo=='m') 
		{	formulario.setTitle("Modificar contrato "+codigo);}
		formulario.setLocation(350,100);
		JLabel lc1=new JLabel("* Matrícula del vehículo");
		JLabel lc2=new JLabel("Fecha de alta");
		lc1.setPreferredSize(new Dimension(150,20));
		lc2.setPreferredSize(new Dimension(150,20));
		final JTextField tfechaalta=new JTextField();
		if ((tipo=='c') || (tipo=='n'))
		{	Date hoy = new Date();
			SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
			tfechaalta.setText(formato.format(hoy));
		}
		else if (tipo=='m')
		{	tfechaalta.setText((String)datos.get(3));}
		tfechaalta.setEditable(false);
		final JTextField tmatricula=new JTextField();
		tfechaalta.setPreferredSize(new Dimension(100,20));
		tmatricula.setPreferredSize(new Dimension(100,20));
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		p1.add(lc1);
		p1.add(tmatricula);
		p2.add(lc2);
		p2.add(tfechaalta);
		Box caja1=Box.createVerticalBox();
		caja1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del contrato",TitledBorder.LEFT,TitledBorder.TOP));
		caja1.add(p1);
		caja1.add(p2);
		JPanel pcl=new JPanel();
		pcl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del cliente",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l1=new JLabel("* Nombre ",SwingConstants.RIGHT);
		JLabel l2=new JLabel("* DNI/CIF ",SwingConstants.RIGHT);
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
		relleno5.setPreferredSize(new Dimension(20,20));
		relleno6.setPreferredSize(new Dimension(100,20));
		relleno7.setPreferredSize(new Dimension(100,20));
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
			int i=0;
			if (tipo=='m')
			{	tmatricula.setText((String)datos.get(2));
				tmatricula.setEditable(false);
				i=4;
			}
			else if (tipo=='n')
			{	tdir.setEditable(false);
				tcp.setEditable(false);
				tpob.setEditable(false);
				tpro.setEditable(false);
				ttel1.setEditable(false);
				ttel2.setEditable(false);
				tmov.setEditable(false);
				temail.setEditable(false);
				tfax.setEditable(false);
			}
			tnom.setText((String)datos.get(0+i));
			tdni.setText((String)datos.get(1+i));
			tdir.setText((String)datos.get(2+i));
			tcp.setText((String)datos.get(3+i));
			tpob.setText((String)datos.get(4+i));
			tpro.setText((String)datos.get(5+i));
			ttel1.setText((String)datos.get(6+i));
			ttel2.setText((String)datos.get(7+i));
			tmov.setText((String)datos.get(8+i));
			temail.setText((String)datos.get(9+i));
			tfax.setText((String)datos.get(10+i));
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
		c8.add(relleno6);
		c9.add(l9);
		c9.add(tmov);
		c9.add(relleno7);
		c10.add(l10);
		c10.add(temail);
		c10.add(relleno5);
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
				if ((tmatricula.getText().equals("")) || (tdni.getText().equals("")) || (tnom.getText().equals("")))
				{
					JOptionPane.showMessageDialog(null,"Los campos marcados con * son obligatorios");
				}
				else
				{	LinkedList datoscontrato=new LinkedList();
					LinkedList datoscliente=new LinkedList();
					if (tipo=='c')
					{	datoscontrato.add(tmatricula.getText());
						datoscontrato.add(tfechaalta.getText());
						datoscliente.add(tnom.getText());
						datoscliente.add(tdni.getText());
						datoscliente.add(tdir.getText());
						datoscliente.add(tcp.getText());
						datoscliente.add(tpob.getText());
						datoscliente.add(tpro.getText());
						datoscliente.add(ttel1.getText());
						datoscliente.add(ttel2.getText());
						datoscliente.add(tmov.getText());
						datoscliente.add(temail.getText());
						datoscliente.add(tfax.getText());
						inicializaCajaMultas();
						controlador.añadirContrato(datoscontrato,datoscliente);
					}
					else if (tipo=='m')
					{	datoscontrato.add(datos.get(0));
						datoscontrato.add(datos.get(1));
						datoscontrato.add(datos.get(2));
						datoscontrato.add(datos.get(3));
						datoscliente.add(datos.get(4));
						datoscliente.add(datos.get(5));
						datoscliente.add(tdir.getText());
						datoscliente.add(tcp.getText());
						datoscliente.add(tpob.getText());
						datoscliente.add(tpro.getText());
						datoscliente.add(ttel1.getText());
						datoscliente.add(ttel2.getText());
						datoscliente.add(tmov.getText());
						datoscliente.add(temail.getText());
						datoscliente.add(tfax.getText());
						controlador.modificarContrato((String)datos.get(0),datoscontrato);
						controlador.modificarCliente((String)datos.get(1),datoscliente);
					}
					else if(tipo=='n')
					{	datoscontrato.add(tmatricula.getText());
						datoscontrato.add(tfechaalta.getText());
						inicializaCajaMultas();
						controlador.añadirContratoACliente(datoscontrato,codigoCliente.getText());
					}
					formulario.setVisible(false);
					formulario.getContentPane().removeAll();										
				}
			}
		});
		cancelar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formulario.setVisible(false);
				formulario.getContentPane().removeAll();
			}
		});
		return panel;
	}
	
	public JPanel panelBajaContrato(final String codigo)
	{
		formulario.setTitle("Eliminar contrato");
		formulario.setLocation(350,100);
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
				formulario.setVisible(false);
				int seleccion=JOptionPane.showConfirmDialog(null,"           ¿Desea eliminar el contrato "+tcodigo.getText()+"?","Eliminar contrato",JOptionPane.YES_NO_CANCEL_OPTION,-1);
				if (seleccion==JOptionPane.YES_OPTION)
				{	inicializaCajaMultas();
					boolean borrar;
					if (codigo.equals(tcodigo.getText())) borrar=true;
					else borrar=false;
					boolean actualizar=false;
					int i=0;
					while ((i<selector.getItemCount()) && (!actualizar)) 
					{	actualizar=codigo.equals(selector.getItemAt(i));
						i++;
					}
					controlador.eliminarContrato(borrar,actualizar,tcodigo.getText());
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
		return pbaja;
	}
	
	public JPanel panelMododificarContrato(final String codigo)
	{
		formulario.setTitle("Modificar contrato");		
		formulario.setLocation(350,100);
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
				formulario.setVisible(false);
				formulario.getContentPane().removeAll();
				controlador.consultarContratoCodigo(true,true,tcodigo.getText());
			}
		});
		bcancela.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formulario.setVisible(false);
				formulario.getContentPane().removeAll();
			}
		});
		return pmod;
	}
	
	public JPanel panelAltaMulta(final char tipo,final String codigo,String expediente,String boletin)
	{
		if (tipo=='c') formulario.setTitle("Crear multa");
		else if (tipo=='m') formulario.setTitle("Modificar multa "+codigo);
		formulario.setLocation(300,100);
		JLabel l2=new JLabel("* Expediente ",SwingConstants.RIGHT);
		JLabel l3=new JLabel("* Boletín ",SwingConstants.RIGHT);
		JLabel l4=new JLabel("Fecha denuncia ",SwingConstants.RIGHT);
		JLabel l5=new JLabel("Infracción ",SwingConstants.RIGHT);
		JLabel r1=new JLabel(" ",SwingConstants.RIGHT);
		JLabel r2=new JLabel(" ",SwingConstants.RIGHT);
		JLabel r3=new JLabel(" ",SwingConstants.RIGHT);
		JLabel r4=new JLabel(" ",SwingConstants.RIGHT);
		JLabel r5=new JLabel(" ",SwingConstants.RIGHT);
		l2.setPreferredSize(new Dimension(100,20));
		l3.setPreferredSize(new Dimension(100,20));
		l4.setPreferredSize(new Dimension(100,20));
		l5.setPreferredSize(new Dimension(100,20));
		r2.setPreferredSize(new Dimension(80,20));
		r3.setPreferredSize(new Dimension(80,20));
		r4.setPreferredSize(new Dimension(100,20));
		r5.setPreferredSize(new Dimension(100,20));
		final JTextField exp=new JTextField();
		exp.setPreferredSize(new Dimension(100,20));
		final JTextField bol=new JTextField();
		bol.setPreferredSize(new Dimension(100,20));
		final JTextField fecha=new JTextField();
		fecha.setPreferredSize(new Dimension(100,20));
		if (tipo=='m')
		{	exp.setText(expediente);
			bol.setText(boletin);
			exp.setEditable(false);
			bol.setEditable(false);			
		}
		String [] dias={"1","2","3","4","5","6","7","8","9","10","11","12","13","14",
						"15","16","17","18","19","20","21","22","23","24","25","26",
						"27","28","29","30","31"};
		String [] meses={"1","2","3","4","5","6","7","8","9","10","11","12"};
		Calendar hoy=Calendar.getInstance();
		int i=hoy.get(Calendar.YEAR);
		Integer añoactual=new Integer(i);
		Integer [] años={new Integer(i-4),new Integer(i-3),new Integer(i-2),new Integer(i-1),
						añoactual,new Integer(i+1),new Integer(i+2),new Integer(i+3),
						new Integer(i+4),new Integer(i+5),new Integer(i+6)};
		final JComboBox dia=new JComboBox(dias);
		final JComboBox mes=new JComboBox(meses);
		final JComboBox año=new JComboBox(años);
		año.setEditable(true);
		año.setPreferredSize(new Dimension(60,20));
		año.setSelectedItem(añoactual);
		ButtonGroup grupo=new ButtonGroup();
		JRadioButton rtrafico=new JRadioButton("Tráfico",true);
		JRadioButton rtransporte=new JRadioButton("Transporte");
		grupo.add(rtrafico);
		grupo.add(rtransporte);
		final JComboBox infraccion=new JComboBox();
		infraccionesTrafico(infraccion);
		infraccion.setEditable(false);
		infraccion.setPreferredSize(new Dimension(250,20));
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		JPanel p5=new JPanel();
		JPanel p6=new JPanel();
		p2.add(l2);
		p2.add(exp);
		p2.add(r2);
		p3.add(l3);
		p3.add(bol);
		p3.add(r3);
		p4.add(l4);
		p4.add(dia);
		p4.add(mes);
		p4.add(año);
		p4.add(r4);
		p5.add(l5);
		p5.add(infraccion);
		p6.add(rtrafico);
		p6.add(rtransporte);
		Box caja=Box.createVerticalBox();
		caja.add(p2);
		caja.add(p3);
		caja.add(p4);
		caja.add(p5);
		caja.add(p6);
		JPanel p7=new JPanel();
		p7.add(new JLabel("Descripción"));
		final JTextPane descrip=new JTextPane();
		JScrollPane ptexto=new JScrollPane(descrip,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
		ptexto.setPreferredSize(new Dimension(300,150));
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,p7,ptexto);
		sp.setEnabled(false);		
		sp.setDividerSize(1);
		JSplitPane sp1=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja,sp);
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
				if ((exp.getText().equals("")) || (bol.getText().equals("")))
				{
					JOptionPane.showMessageDialog(null,"Los campos marcados con * son obligatorios");
				}
				else
				{	LinkedList datos=new LinkedList();
					datos.add(exp.getText());
					datos.add(bol.getText());
					datos.add(dia.getSelectedItem()+"/"+mes.getSelectedItem()+"/"+año.getSelectedItem());
					datos.add((String)infraccion.getSelectedItem());
					datos.add(descrip.getText());
					datos.add(codigoContrato.getText());
					if (tipo=='c') 
					{	controlador.añadirMulta(codigoContrato.getText(),datos);}
					else if (tipo=='m')
					{	datos.addFirst(codigo);
						controlador.modificarMulta(codigo,datos);
					}
					formulario.setVisible(false);
					formulario.getContentPane().removeAll();
				}
			}
		});
		cancelar.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formulario.setVisible(false);
				formulario.getContentPane().removeAll();
			}
		});
		rtrafico.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				infraccion.removeAllItems();
				infraccionesTrafico(infraccion);
			}
		});
		rtransporte.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				infraccion.removeAllItems();
				infraccionesTransporte(infraccion);
			}
		});
		return panel;
	}
	
	public JPanel panelAltaRecurso(char tipo, String codigo)
	{
		if (tipo=='c') formRecurso.setTitle("Crear recurso");
		else if (tipo=='m') formRecurso.setTitle("Modificar recurso "+codigo);
		formRecurso.setLocation(300,100);
		JLabel l2=new JLabel("Fecha de emisión ",SwingConstants.RIGHT);
		JLabel l4=new JLabel("Escrito recibido ",SwingConstants.RIGHT);
		JLabel l5=new JLabel("Escrito presentado ",SwingConstants.RIGHT);
		JLabel l6=new JLabel("Estado ",SwingConstants.RIGHT);
		JLabel l7=new JLabel("Abogado ",SwingConstants.RIGHT);
		JLabel r1=new JLabel(" ",SwingConstants.RIGHT);
		JLabel r2=new JLabel(" ",SwingConstants.RIGHT);
		JLabel r3=new JLabel(" ",SwingConstants.RIGHT);
		JLabel r6=new JLabel(" ",SwingConstants.RIGHT);
		JLabel r7=new JLabel(" ",SwingConstants.RIGHT);
		l2.setPreferredSize(new Dimension(105,20));
		l4.setPreferredSize(new Dimension(100,20));
		l5.setPreferredSize(new Dimension(100,20));
		l6.setPreferredSize(new Dimension(105,20));
		l7.setPreferredSize(new Dimension(105,20));
		r1.setPreferredSize(new Dimension(150,20));
		r2.setPreferredSize(new Dimension(175,20));
		r3.setPreferredSize(new Dimension(175,20));
		r6.setPreferredSize(new Dimension(150,20));
		r7.setPreferredSize(new Dimension(150,20));
		JTextField cod=new JTextField();
		JTextField femi=new JTextField();
		Date hoy = new Date();
		SimpleDateFormat formato=new SimpleDateFormat("dd/MM/yyyy");
		femi.setText(formato.format(hoy));
		femi.setEditable(false);
		JComboBox ere=new JComboBox();
		JComboBox epr=new JComboBox();
		JComboBox est=new JComboBox();
		JTextField abo=new JTextField();
		escritoRecibido(ere);
		escritoPresentado(epr);
		estadosRecursos(est);
		cod.setEditable(false);
		cod.setPreferredSize(new Dimension(100,20));
		femi.setPreferredSize(new Dimension(75,20));
		ere.setPreferredSize(new Dimension(250,20));
		epr.setPreferredSize(new Dimension(250,20));
		est.setPreferredSize(new Dimension(100,20));
		abo.setPreferredSize(new Dimension(100,20));
		JPanel p2=new JPanel();
		JPanel p4=new JPanel();
		JPanel p5=new JPanel();
		JPanel p6=new JPanel();
		JPanel p7=new JPanel();
		p2.add(l2);
		p2.add(femi);
		p2.add(r2);
		p4.add(l4);
		p4.add(ere);
		p5.add(l5);
		p5.add(epr);
		p6.add(l6);
		p6.add(est);
		p6.add(r6);
		p7.add(l7);
		p7.add(abo);
		p7.add(r7);
		Box caja1=Box.createVerticalBox();
		caja1.add(p2);
		caja1.add(p4);
		caja1.add(p5);
		caja1.add(p6);
		caja1.add(p7);
		JPanel p8=new JPanel();
		p8.add(new JLabel("Descripción"));
		JTextPane texto=new JTextPane();
		JScrollPane ptexto=new JScrollPane(texto,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
		ptexto.setPreferredSize(new Dimension(300,150));
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,p8,ptexto);
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
	
	public JPanel dibujaLineaMulta(final LinkedList datos)
	{		
		JPanel panel=new JPanel();
		final JTextField cod=new JTextField((String)datos.get(0));
		cod.setEditable(false);
		cod.setBackground(Color.WHITE);
		cod.setPreferredSize(new Dimension(100,25));
		final JTextField exp=new JTextField((String)datos.get(1));
		exp.setEditable(false);
		exp.setBackground(Color.WHITE);
		exp.setPreferredSize(new Dimension(100,25));
		final JTextField bol=new JTextField((String)datos.get(2));
		bol.setEditable(false);
		bol.setBackground(Color.WHITE);
		bol.setPreferredSize(new Dimension(100,25));
		JTextField fecha=new JTextField((String)datos.get(3));
		fecha.setEditable(false);
		fecha.setBackground(Color.WHITE);
		fecha.setPreferredSize(new Dimension(100,25));
		JTextField infrac=new JTextField((String)datos.get(4));
		infrac.setEditable(false);
		infrac.setBackground(Color.WHITE);
		infrac.setPreferredSize(new Dimension(250,25));
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
		panel.add(fecha);
		panel.add(infrac);		
		panel.add(descrip);
		panel.add(recur);
		panel.add(mod);
		panel.add(elim);
		descrip.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formulario.getContentPane().add(panelDescripcion('m',cod.getText(),(String)datos.get(5)));
				formulario.pack();
				formulario.setVisible(true);				
			}
		});
		recur.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formulario.getContentPane().add(dibujaRecursos(cod.getText()));
				formulario.pack();
				formulario.setVisible(true);				
			}
		});
		mod.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formulario.getContentPane().add(panelAltaMulta('m',cod.getText(),exp.getText(),bol.getText()));
				formulario.pack();
				formulario.setVisible(true);				
			}
		});
		elim.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				int seleccion=JOptionPane.showConfirmDialog(null,"          ¿Desea eliminar la multa "+cod.getText()+"?","Eliminar multa",JOptionPane.YES_NO_CANCEL_OPTION,-1);
				if (seleccion==JOptionPane.YES_OPTION)
				{	controlador.eliminarMulta(cod.getText(),codigoContrato.getText());}				
			}
		});
		return panel;
	}
	
	public JPanel dibujaLineaRecurso()
	{		
		JPanel panel=new JPanel();
		final JTextField cod=new JTextField();
		JTextField femi=new JTextField();
		JTextField ere=new JTextField();
		JTextField epr=new JTextField();
		JTextField est=new JTextField();
		JTextField abo=new JTextField();
		JButton descrip=new JButton(new ImageIcon("interfaz/find.gif"));
		JButton modi=new JButton(new ImageIcon("interfaz/tick.gif"));
		JButton elim=new JButton(new ImageIcon("interfaz/del.gif"));
		cod.setEditable(false);
		femi.setEditable(false);
		ere.setEditable(false);
		epr.setEditable(false);
		est.setEditable(false);
		abo.setEditable(false);
		cod.setBackground(Color.WHITE);
		femi.setBackground(Color.WHITE);
		ere.setBackground(Color.WHITE);
		epr.setBackground(Color.WHITE);
		est.setBackground(Color.WHITE);
		abo.setBackground(Color.WHITE);
		cod.setPreferredSize(new Dimension(80,25));
		femi.setPreferredSize(new Dimension(90,25));
		ere.setPreferredSize(new Dimension(190,25));
		epr.setPreferredSize(new Dimension(190,25));
		est.setPreferredSize(new Dimension(90,25));
		abo.setPreferredSize(new Dimension(90,25));
		descrip.setPreferredSize(new Dimension(80,25));		
		modi.setPreferredSize(new Dimension (25,25));		
		elim.setPreferredSize(new Dimension (25,25));
		panel.add(cod);
		panel.add(femi);
		panel.add(ere);
		panel.add(epr);
		panel.add(est);
		panel.add(abo);
		panel.add(descrip);
		panel.add(modi);
		panel.add(elim);
		descrip.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formRecurso.getContentPane().add(panelDescripcion('r',cod.getText(),""));
				formRecurso.pack();
				formRecurso.setVisible(true);	
			}
		});
		modi.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				formRecurso.getContentPane().add(panelAltaRecurso('m',cod.getText()));
				formRecurso.pack();
				formRecurso.setVisible(true);				
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
		
	public JPanel panelDescripcion(final char tipo,String codigo,String texto)
	{
		if (tipo=='r')
		{	formRecurso.setTitle("Descripción del recurso "+codigo);
			formRecurso.setLocation(350,100);			
		}
		else if (tipo=='m')
		{	formulario.setTitle("Descripción de la multa "+codigo);
			formulario.setLocation(350,200);		
		}
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
				if (tipo=='r')
				{
					formRecurso.setVisible(false);
					formRecurso.getContentPane().removeAll();
				}
				else if (tipo=='m')
				{
					formulario.setVisible(false);
					formulario.getContentPane().removeAll();
				}
			}
		});
		return panel;
	}
	
	private void infraccionesTrafico(JComboBox infracciones)
	{
		infracciones.addItem("Adelantamiento");
		infracciones.addItem("Adel. sin visibilidad");
		infracciones.addItem("Adel. en intersección");
		infracciones.addItem("Alcoholemia");
		infracciones.addItem("Ceda el paso");
		infracciones.addItem("Cinturón de seguridad");
		infracciones.addItem("Cint. seg. menores 12 años");
		infracciones.addItem("Circ. 2 pers. en ciclomotor");
		infracciones.addItem("Circ. por carril distinto");
		infracciones.addItem("Conducción temeraria");
		infracciones.addItem("Cond. sin diligencia y precaución");
		infracciones.addItem("Carecer extintor");
		infracciones.addItem("Carecer rueda repuesto");
		infracciones.addItem("Carecer chaleco reflectante");
		infracciones.addItem("Dirección prohibida");
		infracciones.addItem("Doc. ITV no pasada");
		infracciones.addItem("Doc. ITV pasa pero circ. sin tarjeta");
		infracciones.addItem("Doc. Permiso de Circulación");
		infracciones.addItem("Doc. Permiso de Conducir");
		infracciones.addItem("Doc. Seguro obligatorio");
		infracciones.addItem("Doc.  Otros");
		infracciones.addItem("Estacionamiento indebido");
		infracciones.addItem("Estac. zona limitac. horaria");
		infracciones.addItem("Exceso de velocidad");
		infracciones.addItem("Exceso de dimensiones");
		infracciones.addItem("Giro");
		infracciones.addItem("Hablar por teléfono");
		infracciones.addItem("Incumpl. obligac. ident. conductor");
		infracciones.addItem("Luces. Mal funcionamiento");
		infracciones.addItem("Luces. No llevar repuesto");
		infracciones.addItem("Luces. No llevar en túnel");
		infracciones.addItem("Luces. Otras");
		infracciones.addItem("Marcha atrás. Maniobra prohibida");
		infracciones.addItem("Matrícula ilegible o poco visible");
		infracciones.addItem("Matrícula defectuosa");
		infracciones.addItem("Neumáticos defectuosos");
		infracciones.addItem("No hacer caso agente");
		infracciones.addItem("No ceder paso peatones");
		infracciones.addItem("Pisar línea continua");
		infracciones.addItem("Restricciones circulación");
		infracciones.addItem("Señal Stop");
		infracciones.addItem("Señal de prohibición");
		infracciones.addItem("Semáforo");
		infracciones.addItem("Otras General");
	}

	private void infraccionesTransporte(JComboBox infracciones)
	{
		infracciones.addItem("Ttes. Carecer de tarjeta");
		infracciones.addItem("Ttes. Exceder ámbito radio acción");
		infracciones.addItem("Ttes. No visado tarjeta");
		infracciones.addItem("Ttes. No cumplir requisitos tarjeta");
		infracciones.addItem("Ttes. Obstrucción labor inspectora");
		infracciones.addItem("Ttes. Manipulación tacógrafo");
		infracciones.addItem("Ttes. Inadecuado func.tacógrafo");
		infracciones.addItem("Ttes. Carecer tacógrafo o de sus elem.");
		infracciones.addItem("Ttes. Carecer hojas registro o datos");
		infracciones.addItem("Ttes. No llevar hoja  reg. en tacógrafo");
		infracciones.addItem("Ttes. Superposición disco");
		infracciones.addItem("Ttes. Exceso de peso");
		infracciones.addItem("Ttes. Carecer distintivos");
		infracciones.addItem("Ttes. Distintivos no adecuados a tarjeta");
		infracciones.addItem("Ttes. Arrendam. No llevar documentac.");
		infracciones.addItem("Ttes. .Exceso conducción");
		infracciones.addItem("Ttes. Minoración descanso");
		infracciones.addItem("Ttes. Inspección discos");
		infracciones.addItem("TMP. Carecer certific. Aprobac. del vehíc.");
		infracciones.addItem("TMP. No llevar a bordo vehic.docum.");
		infracciones.addItem("TMP. No llevar carta instrucciones");
		infracciones.addItem("TMP.Utilizar envase no homologados");
		infracciones.addItem("TMP. Carecer Consej seguridad");
		infracciones.addItem("TMP. Equipamiento vehículo");
		infracciones.addItem("TMP. Carecer de etiquetas de peligro");
		infracciones.addItem("TMP. No remitir info. anual o parte accid.");
		infracciones.addItem("TMP.Carecer certif. limpieza cisterna");
		infracciones.addItem("TMPer.Carecer certificado conformidad");
		infracciones.addItem("TMPer.No alcanzar temper. exigible");
		infracciones.addItem("TMPer.No cumplir condic. Sanidad");
		infracciones.addItem("TMPer.No llevar abordo documentac.");
		infracciones.addItem("Ttes. Otras");
	}
	
	private void escritoPresentado(JComboBox escritos)
	{
		escritos.addItem("Alegaciones Boletín");
		escritos.addItem("Alegaciones Notificación");
		escritos.addItem("Alegaciones a las Pruebas");
		escritos.addItem("Recurso Alzada");
		escritos.addItem("Recurso Reposición");
		escritos.addItem("Alegaciones Trámite Audiencia");
		escritos.addItem("Identificación Conductor");
		escritos.addItem("Escr. Subsanación de Firma");
		escritos.addItem("Solicitud Aplazam, Retirada Carné");
		escritos.addItem("Aleg. Puesta de Manifiesto(TEAR)");
		escritos.addItem("Ejec .Recurso Reposición");
		escritos.addItem("Carta Desestim. Recurso Adm.");
		escritos.addItem("Carta Desestim. Recurso Ejecut.");
		escritos.addItem("Carta Requerim. Identif. Conductor");
		escritos.addItem("Escrito Entrada Repetido");
		escritos.addItem("Sin Escrito de Salida");
		escritos.addItem("Otros");		
	}

	private void escritoRecibido(JComboBox escritos)
	{
		escritos.addItem("Boletín sin valor de notif.");
		escritos.addItem("Boletín con valor de notific");
		escritos.addItem("Notificación Denuncia");
		escritos.addItem("Remisión pruebas");
		escritos.addItem("Notificación 1ª Resolución");
		escritos.addItem("Notificación 2ª Resolución");
		escritos.addItem("Requerimiento Identificación");
		escritos.addItem("Escr. Solicitando Subsanación de Firma");
		escritos.addItem("Notif. Trámite Audiencia");
		escritos.addItem("Notificación Propuesta Resolución");
		escritos.addItem("Notificación Sobreseída");
		escritos.addItem("Notificación Retrotaida");
		escritos.addItem("Notificación Revocada");
		escritos.addItem("Orden Entrega Carné Conducir");
		escritos.addItem("Requerimiento Relación Laboral");
		escritos.addItem("Providencia de Apremio");
		escritos.addItem("Carta de Pago");
		escritos.addItem("Providencia Embargo(AYUNT)");
		escritos.addItem("Providencia embargo y acumulación");
		escritos.addItem("Diligencia Embargo(AYUNT)");
		escritos.addItem("Prelación de Bienes(AYUNT)");
		escritos.addItem("Señalamiento de Bienes(AYUNT))");
		escritos.addItem("Embargo de CC y Ahorros(AYUNT)");
		escritos.addItem("Investigación Patrimonial(AYUNT)");
		escritos.addItem("Justificante Ingreso(AYUNT)");
		escritos.addItem("Orden de ejec. de la Prov. de Embargo(AYUNT)");
		escritos.addItem("Ejec.Grúa");
		escritos.addItem("Puesta Manifiesto(TEAR)");
		escritos.addItem("Notific. Puesta Disposic. Del interesado.");
		escritos.addItem("Talón de Cargo(AETAT)");
		escritos.addItem("Diligencia de Embargo(AEAT)");
		escritos.addItem("Investigación Seguridad Social");
		escritos.addItem("Embargo Bienes Conocidos");
		escritos.addItem("Diligencia embargo(BANCO)");
		escritos.addItem("Notific.Resol.Recurso Ejecutivo");
		escritos.addItem("Otras Notificaciones");
	}
	
	private void estadosRecursos(JComboBox estado)
	{
		estado.addItem("Pendiente");
		estado.addItem("Recurso 1º");
		estado.addItem("Recurso 2º");
		estado.addItem("Recurso 3º");
		estado.addItem("Favorable");
		estado.addItem("Desfavorable");
	}
}