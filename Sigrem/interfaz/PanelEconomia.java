package interfaz;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import java.awt.event.*;

public class PanelEconomia extends JPanel 
{
	public JFrame formulario;
	
	//valores entre 0-300
	public int [] facturacion={130,300,127,300,300,234,253,220,276,156,179,270};
	public int [] gastos=     {130,300,127,300,300,234,253,220,276,156,179,270};
	public int [] balance=    { 20,180,  7,290,  0,100,100,160, 46,100, 79,155};
		
	public PanelEconomia()
	{
		super();
		formulario=new JFrame();
		formulario.setResizable(false);
		formulario.setLocation(350,100);
		JPanel pbalance=dibujaBalance();
		JPanel pgrafico=dibujaGrafico(Color.BLUE, balance, "Histórico del Balance");
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,pbalance,pgrafico);
		sp.setEnabled(false);		
		sp.setDividerSize(4);
		add(sp);
		Dimension d=new Dimension(625,200);
		pbalance.setPreferredSize(d);				
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
						dibujaBal();
					}
				});
		bhfac.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
						dibujaFac();
					}
				});
		bhgas.addActionListener(new ActionListener()
				{	public void actionPerformed(ActionEvent e)
					{
						dibujaGas();
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
		JLabel l1=new JLabel("ENERO ",SwingConstants.RIGHT);
		JLabel l2=new JLabel("FEBRERO ",SwingConstants.RIGHT);
		JLabel l3=new JLabel("MARZO ",SwingConstants.RIGHT);
		JLabel l4=new JLabel("ABRIL ",SwingConstants.RIGHT);
		JLabel l5=new JLabel("MAYO ",SwingConstants.RIGHT);
		JLabel l6=new JLabel("JUNIO ",SwingConstants.RIGHT);
		JLabel l7=new JLabel("JULIO ",SwingConstants.RIGHT);
		JLabel l8=new JLabel("AGOSTO ",SwingConstants.RIGHT);
		JLabel l9=new JLabel("SEPTIEMBRE ",SwingConstants.RIGHT);
		JLabel l10=new JLabel("OCTUBRE ",SwingConstants.RIGHT);
		JLabel l11=new JLabel("NOVIEMBRE ",SwingConstants.RIGHT);
		JLabel l12=new JLabel("DICIEMBRE ",SwingConstants.RIGHT);
		JLabel l13=new JLabel("0     10     20     30     40     50     60     70     80     90     100");
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
		l12.setPreferredSize(new Dimension(80,20));
		l13.setPreferredSize(new Dimension(300,20));
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
		JLabel relleno13=new JLabel("                         ",SwingConstants.RIGHT);
		relleno1.setPreferredSize(new Dimension(300-num[0],20));
		relleno2.setPreferredSize(new Dimension(300-num[1],20));
		relleno3.setPreferredSize(new Dimension(300-num[2],20));
		relleno4.setPreferredSize(new Dimension(300-num[3],20));
		relleno5.setPreferredSize(new Dimension(300-num[4],20));
		relleno6.setPreferredSize(new Dimension(300-num[5],20));
		relleno7.setPreferredSize(new Dimension(300-num[6],20));
		relleno8.setPreferredSize(new Dimension(300-num[7],20));
		relleno9.setPreferredSize(new Dimension(300-num[8],20));
		relleno10.setPreferredSize(new Dimension(300-num[9],20));
		relleno11.setPreferredSize(new Dimension(300-num[10],20));
		relleno12.setPreferredSize(new Dimension(300-num[11],20));
		relleno13.setPreferredSize(new Dimension(80,20));						
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
		t1.setPreferredSize(new Dimension(balance[0],20));
		t2.setPreferredSize(new Dimension(balance[1],20));
		t3.setPreferredSize(new Dimension(balance[2],20));
		t4.setPreferredSize(new Dimension(balance[3],20));
		t5.setPreferredSize(new Dimension(balance[4],20));
		t6.setPreferredSize(new Dimension(balance[5],20));
		t7.setPreferredSize(new Dimension(balance[6],20));
		t8.setPreferredSize(new Dimension(balance[7],20));
		t9.setPreferredSize(new Dimension(balance[8],20));
		t10.setPreferredSize(new Dimension(balance[9],20));
		t11.setPreferredSize(new Dimension(balance[10],20));
		t12.setPreferredSize(new Dimension(balance[11],20));
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
		Box c12=Box.createHorizontalBox();
		Box c13=Box.createHorizontalBox();		
		c1.add(l1);
		c1.add(t1);
		c1.add(relleno1);
		c2.add(l2);
		c2.add(t2);
		c2.add(relleno2);
		c3.add(l3);
		c3.add(t3);
		c3.add(relleno3);
		c4.add(l4);
		c4.add(t4);
		c4.add(relleno4);
		c5.add(l5);
		c5.add(t5);
		c5.add(relleno5);
		c6.add(l6);
		c6.add(t6);
		c6.add(relleno6);
		c7.add(l7);
		c7.add(t7);
		c7.add(relleno7);
		c8.add(l8);
		c8.add(t8);
		c8.add(relleno8);
		c9.add(l9);	
		c9.add(t9);
		c9.add(relleno9);
		c10.add(l10);
		c10.add(t10);
		c10.add(relleno10);
		c11.add(l11);
		c11.add(t11);
		c11.add(relleno11);
		c12.add(l12);
		c12.add(t12);
		c12.add(relleno12);
		c13.add(relleno13);
		c13.add(l13);		
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
		caja.add(c12);
		caja.add(c13);		
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
