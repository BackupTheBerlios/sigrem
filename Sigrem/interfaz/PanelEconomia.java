package interfaz;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.util.LinkedList;

import main.Sigrem;

public class PanelEconomia extends JPanel 
{
	//valores entre 0-170
	//public int [] facturacion={170,130,125, 27,150, 90,134,170,120,106, 60,169};
	//public int [] gastos=     {  0, -140,-100, -127, -30, -34,-134,  0, -36,  -6, -10,-150};
	//public int [] balance=    {170,-10, 25, 17,-100, 56,  0,170, 84,100, 50, 19};
	//public String [] meses={"ENE ","FEB ","MAR ","ABR ","MAY ","JUN ","JUL ","AGO ","SEP ","OCT ","NOV ","DIC "};
	
	private int [] facturacion;
	
	private int [] gastos;
	
	private int [] balance;
	
	private int ultimoMesFac;
	
	private int ultimoMesGas;
	
	private int ultimoMesBal;
	
	private String [] mesesFac;
	
	private String [] mesesGas;
	
	private String [] mesesBal;
	
	private Sigrem controlador;
	
	private JTextField t1;
	
	private JTextField t2;
	
	private JTextField t3;
		
	public PanelEconomia(int grafico,Sigrem controlador,JFrame v)
	{
		super();
		this.controlador=controlador;
		this.facturacion=new int[12];
		this.gastos=new int[12];
		this.balance=new int[12];
		this.mesesFac=new String [12];
		this.mesesGas=new String [12];
		this.mesesBal=new String [12];
		dameMeses(this.mesesFac,0);
		dameMeses(this.mesesGas,0);
		dameMeses(this.mesesBal,0);
		if (grafico==1) dibujaPaneles(facturacion,"Histórico de Facturación",1);
		else if (grafico==2) dibujaPaneles(gastos,"Histórico de Gastos",2);
		else if (grafico==3) dibujaPaneles(balance,"Histórico de Balance",3);
		else dibujaPaneles(null,null,0);
		for(int i=0;i<12;i++)
		{
			System.out.println("fac["+i+"] "+facturacion[i]);
			System.out.println("gas["+i+"] "+gastos[i]);
			System.out.println("bal["+i+"] "+balance[i]);
		}
	}
	
	public void actualiza(int panel,LinkedList datos)
	{
		facturacion=(int[])datos.get(0);
		gastos=(int[])datos.get(1);
		balance=(int[])datos.get(2);
		String sMesActual=(String)datos.get(3);
		ultimoMesFac=Integer.valueOf(sMesActual).intValue();
		ultimoMesGas=Integer.valueOf(sMesActual).intValue();
		ultimoMesBal=Integer.valueOf(sMesActual).intValue();
		actualizaFacturacion(facturacion,ultimoMesFac);
		actualizaGastos(gastos,ultimoMesGas);
		actualizaBalance(facturacion,gastos,balance,ultimoMesFac,ultimoMesGas,ultimoMesBal);
	}
	
	public void actualizaFacturacion(int [] facturacion,int ultimoMesFac)
	{
		String st1=""+facturacion[11];
		t1.setText(st1);
		dibujaPaneles(facturacion,"Histórico de Facturación",1);
	}
	
	public void actualizaGastos(int [] gastos,int ultimoMesGas)
	{
		String st2=""+gastos[11];
		t2.setText(st2);
		dibujaPaneles(gastos,"Histórico de Gastos",2);
	}
	
	public void actualizaBalance(int [] facturacion,int [] gastos,int [] balance,int ultimoMesFac,int ultimoMesGas,int ultimoMesBal)
	{
		String st3=""+balance[11];
		t3.setText(st3);
		dibujaPaneles(balance,"Histórico de Balance",3);
	}
	
	public void dameMeses(String [] meses,int mes)
	{
		int i=0;
		int m=mes;
		String [] mesesIni={"ENE ","FEB ","MAR ","ABR ","MAY ","JUN ","JUL ","AGO ","SEP ","OCT ","NOV ","DIC "};
		while (i<12)
		{
			meses[i]=mesesIni[m];
			if (m<11) m=m+1;
			else m=0;
			i=i+1;
		}
	}
	
	public void dibujaPaneles(int [] num, String s,int boton)
	{
		JPanel pbalance=dibujaBalance(boton);
		pbalance.setPreferredSize(new Dimension(950,322));
		JPanel pgrafico=dibujaGrafico(num,s,boton);
		pgrafico.setPreferredSize(new Dimension(950,280));
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
		t1=new JTextField(facturacion[11]);
		t2=new JTextField(gastos[11]);
		t3=new JTextField(balance[11]);
		t1.setPreferredSize(new Dimension(100,20));
		t2.setPreferredSize(new Dimension(100,20));
		t3.setPreferredSize(new Dimension(100,20));
		t1.setEditable(false);
		t2.setEditable(false);
		t3.setEditable(false);
		t1.setBackground(Color.WHITE);
		t2.setBackground(Color.WHITE);
		t3.setBackground(Color.WHITE);
		JButton bfacturacion=new JButton ("Calcular");
		bfacturacion.setPreferredSize(new Dimension(80,20));
		JButton bgastos=new JButton ("Calcular");
		bgastos.setPreferredSize(new Dimension(80,20));
		JButton bbalance=new JButton ("Calcular");
		bbalance.setPreferredSize(new Dimension(80,20));
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
		p0.add(l0);
		p1.add(l1);
		p1.add(t1);
		p1.add(bhfac);
		p1.add(bfacturacion);
		p2.add(l2);
		p2.add(t2);
		p2.add(bhgas);
		p2.add(bgastos);
		p3.add(l3);
		p3.add(t3);
		p3.add(bhbal);
		p3.add(bbalance);
		Box caja=Box.createVerticalBox();
		caja.add(p0);
		caja.add(p1);
		caja.add(p2);
		caja.add(p3);
		caja.setPreferredSize(new Dimension(930,250));
		pbal.add(caja);
		bhbal.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				removeAll();
				dameMeses(mesesBal,ultimoMesBal);
				dibujaPaneles(balance, "Histórico de Balance",3);
			}
		});
		bhfac.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				removeAll();
				dameMeses(mesesBal,ultimoMesFac);
				dibujaPaneles(facturacion, "Histórico de Facturación",1);
			}
		});
		bhgas.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				removeAll();
				dameMeses(mesesBal,ultimoMesGas);
				dibujaPaneles(gastos, "Histórico de Gastos",2);
			}
		});
		bfacturacion.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				controlador.calculaFacturacion(facturacion,ultimoMesFac);
				dameMeses(mesesBal,ultimoMesFac);
			}
		});
		bgastos.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				controlador.calculaGastos(gastos,ultimoMesGas);
				dameMeses(mesesBal,ultimoMesGas);
			}
		});
		bbalance.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				controlador.calculaBalance(facturacion,gastos,balance,ultimoMesFac,ultimoMesGas,ultimoMesBal);
				dameMeses(mesesBal,ultimoMesBal);
			}
		});
		return pbal;
	}
	
	public JPanel dibujaGrafico(int [] num, String s,int boton)
	{
		JPanel pgra=new JPanel();
		pgra.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),s,TitledBorder.LEFT,TitledBorder.TOP));
		pgra.setPreferredSize(new Dimension(700,250));
		if (num!=null)
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
			Color c;
			for(int i=0;i<12;i++)
				if (boton==1)
				{
					dameMeses(mesesFac,ultimoMesFac);
					if (num[i]<0)	caja.add(dibujaBarra(-num[i],mesesFac[i],Color.RED));
					else	caja.add(dibujaBarra(num[i],mesesFac[i],Color.GREEN));
				}
				else if (boton==2)
					{
						dameMeses(mesesGas,ultimoMesGas);
						if (num[i]<0)	caja.add(dibujaBarra(-num[i],mesesGas[i],Color.RED));
						else	caja.add(dibujaBarra(num[i],mesesGas[i],Color.GREEN));
					}
					else if (boton==3)
						{
							dameMeses(mesesBal,ultimoMesBal);
							if (num[i]<0)	caja.add(dibujaBarra(-num[i],mesesBal[i],Color.RED));
							else	caja.add(dibujaBarra(num[i],mesesBal[i],Color.GREEN));
						}
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
