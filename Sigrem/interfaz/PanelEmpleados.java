package interfaz;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;



public class PanelEmpleados extends JPanel 
{
	public JFrame formulario; 
	
	public PanelEmpleados()
	{
		super();
		formulario=new JFrame();
		formulario.setResizable(false);
		formulario.setLocation(350,100);
		JPanel pempleado=dibujaEmpleado();
		JPanel pdatos=dibujaDatos(false);
		JPanel precursos=dibujaRecursos();
		JSplitPane sp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pempleado,pdatos);
		sp1.setDividerSize(4);
		sp1.setEnabled(false);
		JSplitPane sp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp1,precursos);
		sp2.setEnabled(false);		
		sp2.setDividerSize(4);
		add(sp2);
	}
		
	public JPanel dibujaEmpleado()
	{
		JPanel pemp=new JPanel();
		pemp.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del empleado",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l1=new JLabel("Código del empleado");
		JLabel l2=new JLabel("Perfil del empleado");
		JLabel l3=new JLabel("Nómina del empleado");
		l1.setPreferredSize(new Dimension(150,20));
		l2.setPreferredSize(new Dimension(150,20));
		l3.setPreferredSize(new Dimension(150,20));
		JTextField t1=new JTextField();
		JTextField t2=new JTextField();
		JTextField t3=new JTextField();
		t1.setPreferredSize(new Dimension(100,20));
		t2.setPreferredSize(new Dimension(100,20));
		t3.setPreferredSize(new Dimension(100,20));
		t1.setEditable(false);
		t2.setEditable(false);
		t3.setEditable(false);
		t1.setBackground(Color.YELLOW);
		t2.setBackground(Color.YELLOW);
		t3.setBackground(Color.YELLOW);
		JButton bcrea=new JButton ("Crear");
		JButton belimina=new JButton ("Eliminar");
		JButton bmodifica=new JButton ("Modificar");
		belimina.setEnabled(false);
		bmodifica.setEnabled(false);
		bcrea.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
						creaEmpleado();
					}
				});
		belimina.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
						eliminaEmpleado();
					}
				});
		bmodifica.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
						modificaEmpleado();
					}
				});
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
		p4.add(bcrea);
		p4.add(belimina);
		p4.add(bmodifica);
		Box caja=Box.createVerticalBox();
		caja.add(p1);
		caja.add(p2);
		caja.add(p3);
		
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja,p4);
		sp.setDividerSize(4);
		sp.setEnabled(false);
		pemp.add(sp);
				
		return pemp;
	}
	
	public JPanel dibujaDatos(boolean editable) 
	{		
		JPanel pdat=new JPanel();
		pdat.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos personales",TitledBorder.LEFT,TitledBorder.TOP));
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
		{
			tnom.setEditable(false);
			tdni.setEditable(false);
			tdir.setEditable(false);
			tcp.setEditable(false);
			tloc.setEditable(false);
			tpro.setEditable(false);
			ttel.setEditable(false);
			temail.setEditable(false);
			tnom.setBackground(Color.YELLOW);
			tdni.setBackground(Color.YELLOW);
			tdir.setBackground(Color.YELLOW);
			tcp.setBackground(Color.YELLOW);
			tloc.setBackground(Color.YELLOW);
			tpro.setBackground(Color.YELLOW);
			ttel.setBackground(Color.YELLOW);
			temail.setBackground(Color.YELLOW);
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
		int f=8;
		int c=4;
		JPanel tabla=new JPanel(new GridLayout(f,c));
		tabla.add(new JLabel("Código",SwingConstants.CENTER));
		tabla.add(new JLabel("Multa",SwingConstants.CENTER));
		tabla.add(new JLabel("Estado",SwingConstants.CENTER));
		tabla.add(new JLabel("Descripción",SwingConstants.CENTER));
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
		JButton bcrea=new JButton("Añadir");
		JButton bmod=new JButton("Modificar");
		JButton belim=new JButton("Eliminar");
		bcrea.setPreferredSize(new Dimension(90,25));
		bmod.setPreferredSize(new Dimension(90,25));
		belim.setPreferredSize(new Dimension(90,25));
		JPanel botonera=new JPanel();
		botonera.add(bcrea);
		botonera.add(bmod);
		botonera.add(belim);
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,ptabla,botonera);
		sp.setEnabled(false);
		sp.setDividerSize(4);
		JPanel prec=new JPanel();
		prec.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Recursos asignados",TitledBorder.LEFT,TitledBorder.TOP));
		prec.add(sp);		
		return prec;		
	}
	
	public void creaEmpleado()
	{		
		JPanel pd=panelAltaEmpleado();
		formulario.getContentPane().add(pd);
		formulario.pack();
		formulario.setVisible(true);
		formulario.addWindowListener(new WindowAdapter()
		{	public void windowClosing(WindowEvent e)
			{
				formulario.setVisible(false);	
			}
		});	
	}
	
	public JPanel panelAltaEmpleado() 
	{		
		formulario.setTitle("Nuevo empleado");
		JLabel lcodigo=new JLabel("Código del empleado");
		JLabel lperfil=new JLabel("Perfil del empleado");
		JLabel lnomina=new JLabel("Nómina del empleado");
		lcodigo.setPreferredSize(new Dimension(150,20));
		lperfil.setPreferredSize(new Dimension(150,20));
		lnomina.setPreferredSize(new Dimension(150,20));
		JTextField tcodigo=new JTextField();
		JTextField tperfil=new JTextField();
		JTextField tnomina=new JTextField();
		tcodigo.setPreferredSize(new Dimension(100,20));
		tperfil.setPreferredSize(new Dimension(100,20));
		tnomina.setPreferredSize(new Dimension(100,20));
		JPanel pcodigo=new JPanel();
		JPanel pperfil=new JPanel();
		JPanel pnomina=new JPanel();
		pcodigo.add(lcodigo);
		pcodigo.add(tcodigo);
		pperfil.add(lperfil);
		pperfil.add(tperfil);
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
		bacepta.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
						formulario.setVisible(false);
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
		JSplitPane sp1=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja,pdat);
		sp1.setDividerSize(4);
		sp1.setEnabled(false);
		JSplitPane sp2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sp1,pbotones);
		sp2.setDividerSize(4);
		sp2.setEnabled(false);
		JPanel pndat=new JPanel();
		pndat.add(sp2);
		return pndat;
	}
	
	public void eliminaEmpleado()
	{
		JPanel pd=panelBajaEmpleado();
		formulario.getContentPane().add(pd);
		formulario.pack();
		formulario.setVisible(true);
		formulario.addWindowListener(new WindowAdapter()
		{	public void windowClosing(WindowEvent e)
			{
				formulario.setVisible(false);	
			}
		});
	}
	
	public JPanel panelBajaEmpleado()
	{
		formulario.setTitle("Despidiendo empleado...");
		
		JLabel lcodigo=new JLabel("Código del empleado");
		
		lcodigo.setPreferredSize(new Dimension(150,20));
		
		JTextField tcodigo=new JTextField();
		
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
		bacepta.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
						formulario.setVisible(false);
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
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja,p2);
		sp.setDividerSize(4);
		sp.setEnabled(false);
		JPanel pndat=new JPanel();
		pndat.add(sp);
		return pndat;
	}
	
	public void modificaEmpleado()
	{
	
	}
}

