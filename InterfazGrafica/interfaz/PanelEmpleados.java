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
	private JFrame nemp; 
	
	public PanelEmpleados()
	{
		super();
		JPanel pempleado=dibujaEmpleado();
		JPanel pdatos=dibujaDatos();
		JScrollPane precursos=dibujaRecursos();
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
		l1.setPreferredSize(new Dimension(150,20));
		JLabel l2=new JLabel("Perfil del empleado");
		l2.setPreferredSize(new Dimension(150,20));
		JLabel l3=new JLabel("Nómina del empleado");
		l3.setPreferredSize(new Dimension(150,20));
		JTextField t1=new JTextField();
		t1.setPreferredSize(new Dimension(100,20));
		t1.setEditable(false);
		JTextField t2=new JTextField();
		t2.setPreferredSize(new Dimension(100,20));
		t2.setEditable(false);
		JTextField t3=new JTextField();
		t3.setPreferredSize(new Dimension(100,20));
		t3.setEditable(false);
		JButton bcrea=new JButton ("Crear");
		bcrea.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
						creaEmpleado();
					}
				});
		JButton belimina=new JButton ("Eliminar");
		belimina.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
						eliminaEmpleado();
					}
				});
		JButton bmodifica=new JButton ("Modificar");
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
		caja.add(p4);
		pemp.add(caja);
		return pemp;
	}
	
	public JPanel dibujaDatos() 
	{		
		JPanel pdat=new JPanel();
		pdat.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos personales",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l1=new JLabel("Nombre");
		l1.setPreferredSize(new Dimension(90,20));
		JLabel l2=new JLabel(" DNI/Pasaporte");
		l2.setPreferredSize(new Dimension(90,20));
		JLabel l3=new JLabel("Dirección");
		l3.setPreferredSize(new Dimension(90,20));
		JLabel l4=new JLabel("Población");
		l4.setPreferredSize(new Dimension(90,20));
		JLabel l5=new JLabel("Provincia");
		l5.setPreferredSize(new Dimension(90,20));
		JLabel l6=new JLabel("C. Postal");
		l6.setPreferredSize(new Dimension(90,20));
		JLabel l7=new JLabel("Teléfono");
		l7.setPreferredSize(new Dimension(90,20));
		JLabel l8=new JLabel("em@il");
		l8.setPreferredSize(new Dimension(90,20));
		JTextField t1=new JTextField();
		t1.setPreferredSize(new Dimension(200,20));
		t1.setEditable(false);
		JTextField t2=new JTextField();
		t2.setPreferredSize(new Dimension(70,20));
		t2.setEditable(false);
		JTextField t3=new JTextField();
		t3.setPreferredSize(new Dimension(170,20));
		t3.setEditable(false);
		JTextField t4=new JTextField();
		t4.setPreferredSize(new Dimension(125,20));
		t4.setEditable(false);
		JTextField t5=new JTextField();
		t5.setPreferredSize(new Dimension(120,20));
		t5.setEditable(false);
		JTextField t6=new JTextField();
		t6.setPreferredSize(new Dimension(40,20));
		t6.setEditable(false);
		JTextField t7=new JTextField();
		t7.setPreferredSize(new Dimension(70,20));
		t7.setEditable(false);
		JTextField t8=new JTextField();
		t8.setPreferredSize(new Dimension(220,20));
		t8.setEditable(false);
		JPanel pl1=new JPanel();
		JPanel pl2=new JPanel();
		JPanel pl3=new JPanel();
		JPanel pl4=new JPanel();
		JPanel pl5=new JPanel();
		JPanel pl6=new JPanel();
		JPanel pl7=new JPanel();
		JPanel pl8=new JPanel();
		JPanel pt1=new JPanel();
		JPanel pt2=new JPanel();
		JPanel pt3=new JPanel();
		JPanel pt4=new JPanel();
		JPanel pt5=new JPanel();
		JPanel pt6=new JPanel();
		JPanel pt7=new JPanel();
		JPanel pt8=new JPanel();
		pl1.add(l1);
		pt1.add(t1);
		pl2.add(l2);
		pt2.add(t2);
		pl3.add(l3);
		pt3.add(t3);
		pl4.add(l4);
		pt4.add(t4);
		pl5.add(l5);
		pt5.add(t5);
		pl6.add(l6);
		pt6.add(t6);
		pl7.add(l7);
		pt7.add(t7);
		pl8.add(l8);
		pt8.add(t8);
		Box caja1=Box.createVerticalBox();
		Box caja2=Box.createVerticalBox();
		caja2.setAlignmentX(Component.LEFT_ALIGNMENT);
		caja1.add(pl1);
		caja1.add(pl2);
		caja1.add(pl3);
		caja1.add(pl4);
		caja1.add(pl5);
		caja1.add(pl6);
		caja1.add(pl7);
		caja1.add(pl8);
		caja2.add(pt1);
		caja2.add(pt2);
		caja2.add(pt3);
		caja2.add(pt4);
		caja2.add(pt5);
		caja2.add(pt6);
		caja2.add(pt7);
		caja2.add(pt8);
		pdat.add(caja1);
		pdat.add(caja2);
		return pdat;
	}
	
	public JScrollPane dibujaRecursos()
	{
		String[] vec2={"Código","Multa","Estado","Descripción"};
		String[][] vec1=new String[10][4];
		JTable recursos=new JTable(vec1,vec2);
		recursos.setRowHeight(20);
		recursos.setEnabled(false);
		JScrollPane prec=new JScrollPane(recursos,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		prec.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Recursos asignados",TitledBorder.LEFT,TitledBorder.TOP));
		prec.setPreferredSize(new Dimension(250,200));
		return prec;
	}
	
	public void creaEmpleado()
	{
		nemp=new JFrame("Nuevo Empleado");
		JPanel pd=dibujaNuevosDatos();
		nemp.getContentPane().add(pd);
		nemp.pack();
		nemp.setLocation(100,50);
		nemp.setResizable(false);
		nemp.setVisible(true);
		nemp.addWindowListener(new WindowAdapter()
		{	public void windowClosing(WindowEvent e)
			{
				nemp.setVisible(false);	
			}
		});	
	}
	
	public JPanel dibujaNuevosDatos() 
	{		
		JPanel pdat=new JPanel();
		pdat.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos personales",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l1=new JLabel("Nombre");
		l1.setPreferredSize(new Dimension(90,20));
		JLabel l2=new JLabel(" DNI/Pasaporte");
		l2.setPreferredSize(new Dimension(90,20));
		JLabel l3=new JLabel("Dirección");
		l3.setPreferredSize(new Dimension(90,20));
		JLabel l4=new JLabel("Población");
		l4.setPreferredSize(new Dimension(90,20));
		JLabel l5=new JLabel("Provincia");
		l5.setPreferredSize(new Dimension(90,20));
		JLabel l6=new JLabel("C. Postal");
		l6.setPreferredSize(new Dimension(90,20));
		JLabel l7=new JLabel("Teléfono");
		l7.setPreferredSize(new Dimension(90,20));
		JLabel l8=new JLabel("em@il");
		l8.setPreferredSize(new Dimension(90,20));
		JTextField t1=new JTextField();
		t1.setPreferredSize(new Dimension(200,20));
		JTextField t2=new JTextField();
		t2.setPreferredSize(new Dimension(70,20));
		JTextField t3=new JTextField();
		t3.setPreferredSize(new Dimension(170,20));
		JTextField t4=new JTextField();
		t4.setPreferredSize(new Dimension(125,20));
		JTextField t5=new JTextField();
		t5.setPreferredSize(new Dimension(120,20));
		JTextField t6=new JTextField();
		t6.setPreferredSize(new Dimension(40,20));
		JTextField t7=new JTextField();
		t7.setPreferredSize(new Dimension(70,20));
		JTextField t8=new JTextField();
		t8.setPreferredSize(new Dimension(220,20));
		JPanel pl1=new JPanel();
		JPanel pl2=new JPanel();
		JPanel pl3=new JPanel();
		JPanel pl4=new JPanel();
		JPanel pl5=new JPanel();
		JPanel pl6=new JPanel();
		JPanel pl7=new JPanel();
		JPanel pl8=new JPanel();
		JPanel pt1=new JPanel();
		JPanel pt2=new JPanel();
		JPanel pt3=new JPanel();
		JPanel pt4=new JPanel();
		JPanel pt5=new JPanel();
		JPanel pt6=new JPanel();
		JPanel pt7=new JPanel();
		JPanel pt8=new JPanel();
		pl1.add(l1);
		pt1.add(t1);
		pl2.add(l2);
		pt2.add(t2);
		pl3.add(l3);
		pt3.add(t3);
		pl4.add(l4);
		pt4.add(t4);
		pl5.add(l5);
		pt5.add(t5);
		pl6.add(l6);
		pt6.add(t6);
		pl7.add(l7);
		pt7.add(t7);
		pl8.add(l8);
		pt8.add(t8);
		Box caja1=Box.createVerticalBox();
		Box caja2=Box.createVerticalBox();
		caja1.add(pl1);
		caja1.add(pl2);
		caja1.add(pl3);
		caja1.add(pl4);
		caja1.add(pl5);
		caja1.add(pl6);
		caja1.add(pl7);
		caja1.add(pl8);
		caja2.add(pt1);
		caja2.add(pt2);
		caja2.add(pt3);
		caja2.add(pt4);
		caja2.add(pt5);
		caja2.add(pt6);
		caja2.add(pt7);
		caja2.add(pt8);
		pdat.add(caja1);
		pdat.add(caja2);
		return pdat;
	}
	
	public void eliminaEmpleado()
	{
		
	}
	
	public void modificaEmpleado()
	{
	
	}
}

