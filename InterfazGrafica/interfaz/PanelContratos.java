package interfaz;

import java.awt.Dimension;
import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelContratos extends JPanel
{
	public PanelContratos()
	{
		super();
		JPanel pcontrato=dibujaContrato();
		JPanel pcliente=dibujaCliente();
		JScrollPane pmultas=dibujaMultas();
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
		JTextField tcontrato=new JTextField();
		JTextField tcliente=new JTextField();
		JTextField tmatricula=new JTextField();
		tcontrato.setPreferredSize(new Dimension(100,20));
		tcliente.setPreferredSize(new Dimension(100,20));
		tmatricula.setPreferredSize(new Dimension(100,20));
		tcontrato.setEditable(false);
		tcliente.setEditable(false);
		tmatricula.setEditable(false);
		JButton bcrea=new JButton ("Crear");
		JButton belimina=new JButton ("Eliminar");
		JButton bmodifica=new JButton ("Modificar");
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		p1.add(l1);
		p1.add(tcontrato);
		p2.add(l2);
		p2.add(tmatricula);
		p3.add(l3);
		p3.add(tcliente);
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
		pco.add(sp);
		return pco;
	}
	
	public JPanel dibujaCliente()
	{
		JPanel pcl=new JPanel();
		pcl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos del cliente",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l1=new JLabel("Nombre");
		JLabel l2=new JLabel("DNI/CIF");
		JLabel l3=new JLabel("Dirección");
		JLabel l4=new JLabel("Código postal");
		JLabel l5=new JLabel("Localidad");
		JLabel l6=new JLabel("Provincia");		
		JLabel l7=new JLabel("Teléfono");
		JTextField tnom=new JTextField();
		JTextField tdni=new JTextField();
		JTextField tdir=new JTextField();
		JTextField tcp=new JTextField();
		JTextField tloc=new JTextField();
		JTextField tpro=new JTextField();
		JTextField ttel=new JTextField();
		tnom.setPreferredSize(new Dimension(180,20));
		tdni.setPreferredSize(new Dimension(100,20));
		tdir.setPreferredSize(new Dimension(200,20));
		tcp.setPreferredSize(new Dimension(60,20));
		tloc.setPreferredSize(new Dimension(200,20));
		tpro.setPreferredSize(new Dimension(200,20));
		ttel.setPreferredSize(new Dimension(80,20));
		tnom.setEditable(false);
		tdni.setEditable(false);
		tdir.setEditable(false);
		tcp.setEditable(false);
		tloc.setEditable(false);
		tpro.setEditable(false);
		ttel.setEditable(false);
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		JPanel p5=new JPanel();
		JPanel p6=new JPanel();
		JPanel p7=new JPanel();
		p1.add(l1);
		p1.add(tnom);
		p2.add(l2);
		p2.add(tdni);
		p3.add(l3);
		p3.add(tdir);
		p4.add(l4);
		p4.add(tcp);
		p5.add(l5);
		p5.add(tloc);
		p6.add(l6);
		p6.add(tpro);
		p7.add(l7);
		p7.add(ttel);
		Box caja=Box.createVerticalBox();
		caja.add(p1);
		caja.add(p2);
		caja.add(p3);
		caja.add(p4);
		caja.add(p5);
		caja.add(p6);
		caja.add(p7);
		pcl.add(caja);
		return pcl;
	}
	
	public JScrollPane dibujaMultas()
	{
		String[] vec2={"Código","Expediente","Boletín","Descripción","Recursos"};
		String[][] vec1=new String[10][5];
		JTable multas=new JTable(vec1,vec2);
		multas.setRowHeight(20);
		JScrollPane pmul=new JScrollPane(multas,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		pmul.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Multas del contrato",TitledBorder.LEFT,TitledBorder.TOP));
		pmul.setPreferredSize(new Dimension(250,200));
		return pmul;
	}
}
