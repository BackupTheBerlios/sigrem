package interfaz;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;


public class PanelEconomia extends JPanel 
{
	public JFrame formulario;
	
	public PanelEconomia()
	{
		super();
		formulario=new JFrame();
		formulario.setResizable(false);
		formulario.setLocation(350,100);
		JPanel pbalance=dibujaBalance();
		JPanel pgrafico=dibujaGrafico();
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,pbalance,pgrafico);
		sp.setEnabled(false);		
		sp.setDividerSize(4);
		add(sp);
		Dimension d=new Dimension(650,200);
		pbalance.setPreferredSize(d);
	}
	
	public JPanel dibujaBalance()
	{
		JPanel pbal=new JPanel();
		pbal.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos económicos",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l1=new JLabel("Facturación");
		JLabel l2=new JLabel("Gastos");
		JLabel l3=new JLabel("Balance");
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
		JButton bactualiza=new JButton ("Actualizar");
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
		p4.add(bactualiza);
		Box caja=Box.createVerticalBox();
		caja.add(p1);
		caja.add(p2);
		caja.add(p3);
		
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja,p4);
		sp.setDividerSize(4);
		sp.setEnabled(false);
		pbal.add(sp);
				
		return pbal;
	}
	
	public JPanel dibujaGrafico()
	{
		JPanel pgra=new JPanel();
		pgra.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Histórico del Balance",TitledBorder.LEFT,TitledBorder.TOP));
		
		return pgra;
	}
}
