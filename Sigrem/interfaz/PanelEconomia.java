package interfaz;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import main.Sigrem;

public class PanelEconomia extends JPanel 
{
	//valores entre 0-170
	public int [] facturacion={170,130,125, 27,150, 90,134,170,120,106, 60,169};
	public int [] gastos=     {  0, 20,100, 10, 30, 34,134,  0, 36,  6, 10,150};
	public int [] balance=    {170,110, 25, 17,120, 56,  0,170, 84,100, 50, 19};
	
	private Sigrem controlador;
		
	public PanelEconomia(int grafico,Sigrem controlador,JFrame v)
	{
		super();
		this.controlador=controlador;
		if (grafico==1) dibujaPaneles(Color.GREEN,facturacion,"Histórico de Facturación",1);
		else if (grafico==2) dibujaPaneles(Color.RED,gastos,"Histórico de Gastos",2);
		else if (grafico==3) dibujaPaneles(Color.BLUE,balance,"Histórico de Balance",3);
		else dibujaPaneles(null,null,null,0);
	}
	
	public void dibujaPaneles(Color c, int [] num, String s,int boton)
	{
		JPanel pbalance=dibujaBalance(boton);
		pbalance.setPreferredSize(new Dimension(724,322));
		JPanel pgrafico=dibujaGrafico(c,num,s);
		pgrafico.setPreferredSize(new Dimension(724,280));
		JSplitPane spx=new JSplitPane(JSplitPane.VERTICAL_SPLIT,pbalance,pgrafico);
		spx.setEnabled(false);		
		spx.setDividerSize(4);
		add(spx);
	}
	
	public JPanel dibujaBalance(int boton)
	{
		JPanel pbal=new JPanel();
		pbal.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos económicos",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l0=new JLabel("");
		JLabel l1=new JLabel("Facturación ",SwingConstants.RIGHT);
		JLabel l2=new JLabel("Gastos ",SwingConstants.RIGHT);
		JLabel l3=new JLabel("Balance ",SwingConstants.RIGHT);
		l0.setPreferredSize(new Dimension(100,10));
		l1.setPreferredSize(new Dimension(100,20));
		l2.setPreferredSize(new Dimension(100,20));
		l3.setPreferredSize(new Dimension(100,20));
		JTextField t1=new JTextField();
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
		JButton bactualiza=new JButton ("Actualizar");
		JButton bhfac=new JButton (new ImageIcon("interfaz/grafico.gif"));
		bhfac.setPreferredSize(new Dimension(20,20));
		JButton bhgas=new JButton (new ImageIcon("interfaz/grafico.gif"));
		bhgas.setPreferredSize(new Dimension(20,20));
		JButton bhbal=new JButton (new ImageIcon("interfaz/grafico.gif"));
		bhbal.setPreferredSize(new Dimension(20,20));
		if (boton==1) bhfac.setEnabled(false);
		else if (boton==2) bhgas.setEnabled(false);
		else if (boton==3) bhbal.setEnabled(false);
		JPanel p0=new JPanel();
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		p0.add(l0);
		p1.add(l1);
		p1.add(t1);
		p1.add(bhfac);
		p2.add(l2);
		p2.add(t2);
		p2.add(bhgas);
		p3.add(l3);
		p3.add(t3);
		p3.add(bhbal);
		p4.add(bactualiza);
		Box caja=Box.createVerticalBox();
		caja.add(p0);
		caja.add(p1);
		caja.add(p2);
		caja.add(p3);
		caja.setPreferredSize(new Dimension(700,250));
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja,p4);
		sp.setDividerSize(4);
		sp.setEnabled(false);
		pbal.add(sp);
		bhbal.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				removeAll();
				dibujaPaneles(Color.BLUE, balance, "Histórico de Balance",3);
			}
		});
		bhfac.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				removeAll();
				dibujaPaneles(Color.GREEN, facturacion, "Histórico de Facturación",1);
			}
		});
		bhgas.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				removeAll();
				dibujaPaneles(Color.RED, gastos, "Histórico de Gastos",2);
			}
		});
		return pbal;
	}
	
	public JPanel dibujaGrafico(Color c, int [] num, String s)
	{
		JPanel pgra=new JPanel();
		pgra.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),s,TitledBorder.LEFT,TitledBorder.TOP));
		pgra.setPreferredSize(new Dimension(700,250));
		if (c!=null)
		{	JLabel l1=new JLabel("  0 ",SwingConstants.RIGHT);
			JLabel l2=new JLabel(" 10 ",SwingConstants.RIGHT);
			JLabel l3=new JLabel(" 20 ",SwingConstants.RIGHT);
			JLabel l4=new JLabel(" 30 ",SwingConstants.RIGHT);
			JLabel l5=new JLabel(" 40 ",SwingConstants.RIGHT);
			JLabel l6=new JLabel(" 50 ",SwingConstants.RIGHT);
			JLabel l7=new JLabel(" 60 ",SwingConstants.RIGHT);
			JLabel l8=new JLabel(" 70 ",SwingConstants.RIGHT);
			JLabel l9=new JLabel(" 80 ",SwingConstants.RIGHT);
			JLabel l10=new JLabel(" 90 ",SwingConstants.RIGHT);
			JLabel l11=new JLabel("100 ",SwingConstants.RIGHT);
			l1.setPreferredSize(new Dimension(30,10));
			l2.setPreferredSize(new Dimension(30,10));
			l3.setPreferredSize(new Dimension(30,10));
			l4.setPreferredSize(new Dimension(30,10));
			l5.setPreferredSize(new Dimension(30,10));
			l6.setPreferredSize(new Dimension(30,10));
			l7.setPreferredSize(new Dimension(30,10));
			l8.setPreferredSize(new Dimension(30,10));
			l9.setPreferredSize(new Dimension(30,10));
			l10.setPreferredSize(new Dimension(30,10));
			l11.setPreferredSize(new Dimension(30,10));
			Box c1=Box.createVerticalBox();
			c1.add(l11);
			c1.add(l10);
			c1.add(l9);
			c1.add(l8);
			c1.add(l7);
			c1.add(l6);
			c1.add(l5);
			c1.add(l4);
			c1.add(l3);
			c1.add(l2);
			c1.add(l1);
			Box caja=Box.createHorizontalBox();				
			caja.add(c1);			
			caja.add(dibujaBarra(num[0], "  ENE", c));
			caja.add(dibujaBarra(num[1], "  FEB", c));
			caja.add(dibujaBarra(num[2], "  MAR", c));
			caja.add(dibujaBarra(num[3], "  ABR", c));
			caja.add(dibujaBarra(num[4], "  MAY", c));
			caja.add(dibujaBarra(num[5], "  JUN", c));
			caja.add(dibujaBarra(num[6], "  JUL", c));
			caja.add(dibujaBarra(num[7], "  AGO", c));
			caja.add(dibujaBarra(num[8], "  SEP", c));
			caja.add(dibujaBarra(num[9], "  OCT", c));
			caja.add(dibujaBarra(num[10], "  NOV", c));
			caja.add(dibujaBarra(num[11], "  DIC", c));
			pgra.add(caja);
		}
		return pgra;
	}
	
	public Box dibujaBarra(int num, String mes, Color c)
	{
		JLabel ll1=new JLabel(mes);
		ll1.setPreferredSize(new Dimension(30,10));
		JLabel relleno1=new JLabel("");
		relleno1.setPreferredSize(new Dimension(20, 180-num));
		JTextField t1=new JTextField();
		t1.setPreferredSize(new Dimension(20, num));
		t1.setEditable(false);
		t1.setBackground(c);
		Box c1=Box.createVerticalBox();
		c1.add(relleno1);
		c1.add(t1);
		c1.add(ll1);
		return c1;
	}
}
