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
	private Sigrem controlador;
	
	private int [] facturacion;
	
	private int [] gastos;
	
	private int [] balance;
	
	private String [] mesFac;
	
	private String [] mesGas;
	
	private String [] mesBal;
	
	private int maxValorGrafico;
		
	public PanelEconomia(int grafico,Sigrem controlador,JFrame v)
	{
		super();
		this.controlador=controlador;
		this.facturacion=new int [12];
		this.gastos=new int [12];
		this.balance=new int [12];
		this.mesFac=new String [12];
		this.mesGas=new String [12];
		this.mesBal=new String [12];
		this.maxValorGrafico=1;
		JPanel pbalance=dibujaBalance();
		pbalance.setPreferredSize(new Dimension(950,322));
		JPanel pgrafico=dibujaGrafico(null,null,null);
		pgrafico.setPreferredSize(new Dimension(950,280));
		JSplitPane spx=new JSplitPane(JSplitPane.VERTICAL_SPLIT,pbalance,pgrafico);
		spx.setEnabled(false);		
		spx.setDividerSize(4);
		add(spx);
	}
	
	public void actualiza(int panel,LinkedList datos)
	{
		if (panel==2)
		{	String grafica=(String)datos.get(0);
			if (grafica.equals("gastos"))
			{	JSplitPane sp=((JSplitPane)getComponent(0));
				sp.setBottomComponent(dibujaGrafico(gastos,"Histórico de Gastos",mesGas));
			}
			else if (grafica.equals("facturacion"))
			{	JSplitPane sp=((JSplitPane)getComponent(0));
				sp.setBottomComponent(dibujaGrafico(facturacion,"Histórico de Facturación",mesFac));
				
			}
			else if (grafica.equals("balance"))
			{	JSplitPane sp=((JSplitPane)getComponent(0));
				sp.setBottomComponent(dibujaGrafico(balance,"Histórico de Balance",mesBal));
			}
		}
		else if (panel==1)
		{	String tipo=(String)datos.get(0);
			if (tipo.equals("facturacion"))
			{	facturacion=(int[])datos.get(1);
				int mes=Integer.valueOf((String)datos.get(2)).intValue();
				mesFac=dameMeses(mes);
				if (facturacion[11]>maxValorGrafico) maxValorGrafico=facturacion[11];
				JSplitPane sp=((JSplitPane)getComponent(0));
				sp.setTopComponent(dibujaBalance());
			}
			else if (tipo.equals("gastos"))
			{	gastos=(int[])datos.get(1);
				int mes=Integer.valueOf((String)datos.get(2)).intValue();
				mesGas=dameMeses(mes);
				if (gastos[11]>maxValorGrafico) maxValorGrafico=gastos[11];
				JSplitPane sp=((JSplitPane)getComponent(0));
				sp.setTopComponent(dibujaBalance());
			}
			else if (tipo.equals("balance"))
			{	balance=(int[])datos.get(1);
				int mes=Integer.valueOf((String)datos.get(2)).intValue();
				mesBal=dameMeses(mes);
				if (balance[11]>maxValorGrafico) maxValorGrafico=balance[11];
				JSplitPane sp=((JSplitPane)getComponent(0));
				sp.setTopComponent(dibujaBalance());
			}
		}
	}
		
	public String [] dameMeses(int mes)
	{
		int i=0;
		int m=mes;
		String [] vMeses=new String[12];
		String [] mesesIni={"ENE ","FEB ","MAR ","ABR ","MAY ","JUN ","JUL ","AGO ","SEP ","OCT ","NOV ","DIC "};
		while (i<12)
		{	vMeses[i]=mesesIni[m];
			if (m<11) m=m+1;
			else m=0;
			i=i+1;
		}
		return vMeses;
	}
	
	public JPanel dibujaBalance()
	{
		JPanel pbal=new JPanel();
		pbal.setPreferredSize(new Dimension(950,322));
		pbal.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Datos económicos",TitledBorder.LEFT,TitledBorder.TOP));
		JLabel l0=new JLabel("");
		JLabel l1=new JLabel("Facturación ",SwingConstants.RIGHT);
		JLabel l2=new JLabel("Gastos ",SwingConstants.RIGHT);
		JLabel l3=new JLabel("Balance ",SwingConstants.RIGHT);
		l0.setPreferredSize(new Dimension(100,10));
		l1.setPreferredSize(new Dimension(100,20));
		l2.setPreferredSize(new Dimension(100,20));
		l3.setPreferredSize(new Dimension(100,20));
		Integer gas=new Integer(gastos[11]);
		Integer fac=new Integer(facturacion[11]);
		Integer bal=new Integer(balance[11]);
		JTextField tfac=new JTextField(""+fac);
		JTextField tgas=new JTextField(""+gas);
		JTextField tbal=new JTextField(""+bal);
		tfac.setPreferredSize(new Dimension(100,20));
		tgas.setPreferredSize(new Dimension(100,20));
		tbal.setPreferredSize(new Dimension(100,20));
		tfac.setEditable(false);
		tgas.setEditable(false);
		tbal.setEditable(false);
		tgas.setForeground(Color.RED);
		tfac.setBackground(Color.WHITE);
		tgas.setBackground(Color.WHITE);
		tbal.setBackground(Color.WHITE);
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
		JPanel p0=new JPanel();
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		p0.add(l0);
		p1.add(l1);
		p1.add(tfac);
		p1.add(bhfac);
		p1.add(bfacturacion);
		p2.add(l2);
		p2.add(tgas);
		p2.add(bhgas);
		p2.add(bgastos);
		p3.add(l3);
		p3.add(tbal);
		p3.add(bhbal);
		p3.add(bbalance);
		Box caja=Box.createVerticalBox();
		caja.add(p0);
		caja.add(p1);
		caja.add(p2);
		caja.add(p3);
		caja.setPreferredSize(new Dimension(930,250));
		pbal.add(caja);
		bhfac.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				LinkedList datos=new LinkedList();
				datos.add(new String("facturacion"));
				actualiza(2,datos);
			}
		});
		bhgas.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				LinkedList datos=new LinkedList();
				datos.add(new String("gastos"));
				actualiza(2,datos);
			}
		});
		bhbal.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				LinkedList datos=new LinkedList();
				datos.add(new String("balance"));
				actualiza(2,datos);			
			}
		});
		bfacturacion.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				controlador.calculaFacturacion();
			}
		});
		bgastos.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				controlador.calculaGastos();			
			}
		});
		bbalance.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				controlador.calculaBalance();
			}
		});
		return pbal;
	}
	
	public JPanel dibujaGrafico(int[] num,String titulo,String[] vMeses)
	{
		JPanel pgra=new JPanel();
		if (titulo!=null) pgra.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),titulo,TitledBorder.LEFT,TitledBorder.TOP));
		pgra.setPreferredSize(new Dimension(950,280));
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
				if (num[i]<0)	caja.add(dibujaBarra(-((170*num[i])/maxValorGrafico),vMeses[i],Color.RED));
				else	caja.add(dibujaBarra(((170*num[i])/maxValorGrafico),vMeses[i],Color.GREEN));
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
