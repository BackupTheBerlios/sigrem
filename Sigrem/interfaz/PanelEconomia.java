package interfaz;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import java.awt.event.*;

public class PanelEconomia extends JPanel 
{
	private JFrame formulario;

	//valores entre 0-170
	public int [] facturacion={170,130,125, 27,150, 90,134,170,120,106, 60,169};
	public int [] gastos=     {  0, 20,100, 10, 30, 34,134,  0, 36,  6, 10,150};
	public int [] balance=    {170,110, 25, 17,120, 56,  0,170, 84,100, 50, 19};
		
	public PanelEconomia()
	{
		super();
		formulario=new JFrame();
		formulario.setResizable(false);
		formulario.setLocation(210,320);
	    JPanel pbalance=dibujaBalance();
		JPanel pgrafico=dibujaGrafico(Color.BLUE, balance, "Histórico del Balance");
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,pbalance,pgrafico);
		sp.setEnabled(false);		
		sp.setDividerSize(4);
		add(sp);
		pbalance.setPreferredSize(new Dimension(625,200));				
	}
	
	public JPanel dibujaBalance()
	{
		JPanel pbal=new JPanel();
		pbal.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos económicos",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l1=new JLabel("Facturación");
		JLabel l2=new JLabel("Gastos");
		JLabel l3=new JLabel("Balance");
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
		JButton bhfac=new JButton ("Ver Histórico");
		JButton bhgas=new JButton ("Ver Histórico");
		JButton bhbal=new JButton ("Ver Histórico");
		bhbal.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
						if (!formulario.isVisible())
						{
							dibujaBal();
						}
						else
						{
							formulario.setVisible(false);
							formulario.getContentPane().removeAll();
							dibujaBal();
						}					
					
					}
				});
		bhfac.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
						if (!formulario.isVisible())
						{
							dibujaFac();
						}
						else
						{
							formulario.setVisible(false);
							formulario.getContentPane().removeAll();
							dibujaFac();
						}		
					}
				});
		bhgas.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
						if (!formulario.isVisible())
						{
							dibujaGas();
						}
						else
						{
							formulario.setVisible(false);
							formulario.getContentPane().removeAll();
							dibujaGas();
						}
					}
				});
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
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
		caja.add(p1);
		caja.add(p2);
		caja.add(p3);		
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,caja,p4);
		sp.setDividerSize(4);
		sp.setEnabled(false);
		pbal.add(sp);	
		return pbal;
	}
	
	public JPanel dibujaGrafico(Color c, int [] num, String s)
	{
		JPanel pgra=new JPanel();
		pgra.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),s,TitledBorder.LEFT,TitledBorder.TOP));
		pgra.setPreferredSize(new Dimension(625,280));
		JLabel l1=new JLabel("  0 ",SwingConstants.RIGHT);
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
		JLabel ll1=new JLabel(" ENE");
		JLabel ll2=new JLabel(" FEB");
		JLabel ll3=new JLabel(" MAR");
		JLabel ll4=new JLabel(" ABR");
		JLabel ll5=new JLabel(" MAY");
		JLabel ll6=new JLabel(" JUN");
		JLabel ll7=new JLabel(" JUL");
		JLabel ll8=new JLabel(" AGO");
		JLabel ll9=new JLabel(" SEP");
		JLabel ll10=new JLabel(" OCT");
		JLabel ll11=new JLabel(" NOV");
		JLabel ll12=new JLabel(" DIC");
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
		ll1.setPreferredSize(new Dimension(30,10));
		ll2.setPreferredSize(new Dimension(30,10));
		ll3.setPreferredSize(new Dimension(30,10));
		ll4.setPreferredSize(new Dimension(30,10));
		ll5.setPreferredSize(new Dimension(30,10));
		ll6.setPreferredSize(new Dimension(30,10));
		ll7.setPreferredSize(new Dimension(30,10));
		ll8.setPreferredSize(new Dimension(30,10));
		ll9.setPreferredSize(new Dimension(30,10));
		ll10.setPreferredSize(new Dimension(30,10));
		ll11.setPreferredSize(new Dimension(30,10));
		ll12.setPreferredSize(new Dimension(30,10));
		JLabel relleno1=new JLabel("");
		JLabel relleno2=new JLabel("");
		JLabel relleno3=new JLabel("");
		JLabel relleno4=new JLabel("");
		JLabel relleno5=new JLabel("");
		JLabel relleno6=new JLabel("");
		JLabel relleno7=new JLabel("");
		JLabel relleno8=new JLabel("");
		JLabel relleno9=new JLabel("");
		JLabel relleno10=new JLabel("");
		JLabel relleno11=new JLabel("");
		JLabel relleno12=new JLabel("");
		relleno1.setPreferredSize(new Dimension(20, 180-num[0]));
		relleno2.setPreferredSize(new Dimension(20, 180-num[1]));
		relleno3.setPreferredSize(new Dimension(20, 180-num[2]));
		relleno4.setPreferredSize(new Dimension(20, 180-num[3]));
		relleno5.setPreferredSize(new Dimension(20, 180-num[4]));
		relleno6.setPreferredSize(new Dimension(20, 180-num[5]));
		relleno7.setPreferredSize(new Dimension(20, 180-num[6]));
		relleno8.setPreferredSize(new Dimension(20, 180-num[7]));
		relleno9.setPreferredSize(new Dimension(20, 180-num[8]));
		relleno10.setPreferredSize(new Dimension(20, 180-num[9]));
		relleno11.setPreferredSize(new Dimension(20, 180-num[10]));
		relleno12.setPreferredSize(new Dimension(20, 180-num[11]));
		JTextField t1=new JTextField();
		JTextField t2=new JTextField();
		JTextField t3=new JTextField();
		JTextField t4=new JTextField();
		JTextField t5=new JTextField();
		JTextField t6=new JTextField();
		JTextField t7=new JTextField();
		JTextField t8=new JTextField();
		JTextField t9=new JTextField();
		JTextField t10=new JTextField();
		JTextField t11=new JTextField();
		JTextField t12=new JTextField();
		t1.setPreferredSize(new Dimension(20, num[0]));
		t2.setPreferredSize(new Dimension(20, num[1]));
		t3.setPreferredSize(new Dimension(20, num[2]));
		t4.setPreferredSize(new Dimension(20, num[3]));
		t5.setPreferredSize(new Dimension(20, num[4]));
		t6.setPreferredSize(new Dimension(20, num[5]));
		t7.setPreferredSize(new Dimension(20, num[6]));
		t8.setPreferredSize(new Dimension(20, num[7]));
		t9.setPreferredSize(new Dimension(20, num[8]));
		t10.setPreferredSize(new Dimension(20, num[9]));
		t11.setPreferredSize(new Dimension(20, num[10]));
		t12.setPreferredSize(new Dimension(20, num[11]));
		t1.setEditable(false);
		t2.setEditable(false);
		t3.setEditable(false);
		t4.setEditable(false);
		t5.setEditable(false);
		t6.setEditable(false);
		t7.setEditable(false);
		t8.setEditable(false);
		t9.setEditable(false);
		t10.setEditable(false);
		t11.setEditable(false);
		t12.setEditable(false);
		t1.setBackground(c);
		t2.setBackground(c);
		t3.setBackground(c);
		t4.setBackground(c);
		t5.setBackground(c);
		t6.setBackground(c);
		t7.setBackground(c);
		t8.setBackground(c);
		t9.setBackground(c);
		t10.setBackground(c);
		t11.setBackground(c);
		t12.setBackground(c);		
		Box c1=Box.createVerticalBox();
		Box c2=Box.createVerticalBox();
		Box c3=Box.createVerticalBox();
		Box c4=Box.createVerticalBox();
		Box c5=Box.createVerticalBox();
		Box c6=Box.createVerticalBox();
		Box c7=Box.createVerticalBox();
		Box c8=Box.createVerticalBox();
		Box c9=Box.createVerticalBox();
		Box c10=Box.createVerticalBox();
		Box c11=Box.createVerticalBox();
		Box c12=Box.createVerticalBox();
		Box c13=Box.createVerticalBox();		
		c1.add(relleno1);
		c1.add(t1);
		c1.add(ll1);
		c2.add(relleno2);
		c2.add(t2);
		c2.add(ll2);
		c3.add(relleno3);
		c3.add(t3);
		c3.add(ll3);
		c4.add(relleno4);
		c4.add(t4);
		c4.add(ll4);
		c5.add(relleno5);
		c5.add(t5);
		c5.add(ll5);
		c6.add(relleno6);
		c6.add(t6);
		c6.add(ll6);
		c7.add(relleno7);
		c7.add(t7);
		c7.add(ll7);
		c8.add(relleno8);
		c8.add(t8);
		c8.add(ll8);
		c9.add(relleno9);
		c9.add(t9);
		c9.add(ll9);
		c10.add(relleno10);
		c10.add(t10);
		c10.add(ll10);
		c11.add(relleno11);
		c11.add(t11);
		c11.add(ll11);
		c12.add(relleno12);
		c12.add(t12);
		c12.add(ll12);
		c13.add(l11);
		c13.add(l10);
		c13.add(l9);
		c13.add(l8);
		c13.add(l7);
		c13.add(l6);
		c13.add(l5);
		c13.add(l4);
		c13.add(l3);
		c13.add(l2);
		c13.add(l1);
		Box caja=Box.createHorizontalBox();					
		caja.add(c13);
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
		caja.add(c12);
		pgra.add(caja);		
		return pgra;
	}
	
	public void dibujaBal()
	{		
		JPanel pd=panelBal();
		formulario.getContentPane().add(pd);
		formulario.pack();
		formulario.setVisible(true);
		formulario.addWindowListener(new WindowAdapter()
		{	public void windowClosing(WindowEvent e)
			{
				formulario.setVisible(false);	
				formulario.getContentPane().removeAll();
			}
		});	
	}
	
	public JPanel panelBal() 
	{		
		formulario.setTitle("Grafico de Balance");		
		JPanel pbal=new JPanel();
		pbal=dibujaGrafico(Color.BLUE, balance, "Histórico de Balance");
		return pbal; 
	}
	
	public void dibujaFac()
	{		
		JPanel pd=panelFac();
		formulario.getContentPane().add(pd);
		formulario.pack();
		formulario.setVisible(true);
		formulario.addWindowListener(new WindowAdapter()
		{	public void windowClosing(WindowEvent e)
			{
				formulario.setVisible(false);	
				formulario.getContentPane().removeAll();
			}
		});	
	}
	
	public JPanel panelFac() 
	{		
		formulario.setTitle("Grafico de Facturación");		
		JPanel pfac=new JPanel();
		pfac=dibujaGrafico(Color.GREEN, facturacion, "Histórico de Facturación");
		return pfac; 
	}
	
	public void dibujaGas()
	{		
		JPanel pd=panelGas();
		formulario.getContentPane().add(pd);
		formulario.pack();
		formulario.setVisible(true);
		formulario.addWindowListener(new WindowAdapter()
		{	public void windowClosing(WindowEvent e)
			{
				formulario.setVisible(false);	
				formulario.getContentPane().removeAll();
			}
		});	
	}
	
	public JPanel panelGas() 
	{		
		formulario.setTitle("Grafico de Gastos");		
		JPanel pgas=new JPanel();
		pgas=dibujaGrafico(Color.RED, gastos, "Histórico de Gastos");
		return pgas; 
	}
}
