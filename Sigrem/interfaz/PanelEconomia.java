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
	
	private boolean actualizadoGasto;
	
	private boolean actualizadoFacturacion;
	
	private boolean actualizadoBalance;
		
	public PanelEconomia(int grafico,Sigrem controlador,JFrame v)
	{
		super();
		actualizadoBalance=false;
		actualizadoGasto=false;
		actualizadoFacturacion=false;
		this.controlador=controlador;
		this.facturacion=new int [12];
		this.gastos=new int [12];
		this.balance=new int [12];
		this.mesFac=new String [12];
		this.mesGas=new String [12];
		this.mesBal=new String [12];
		JPanel pbalance=dibujaBalance();
		JPanel pgrafico=dibujaGrafico(null,null,null);
		JSplitPane sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT,pbalance,pgrafico);
		sp.setEnabled(false);		
		sp.setDividerSize(4);
		add(sp);
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
		{	
			String tipo=(String)datos.get(0);
			if (tipo.equals("facturacion"))
			{	facturacion=(int[])datos.get(1);
				int mes=Integer.valueOf((String)datos.get(2)).intValue();
				mesFac=dameMeses(mes);
				JSplitPane sp=((JSplitPane)getComponent(0));
				sp.setTopComponent(dibujaBalance());
			}
			else if (tipo.equals("gastos"))
			{	gastos=(int[])datos.get(1);
				int mes=Integer.valueOf((String)datos.get(2)).intValue();
				mesGas=dameMeses(mes);
				JSplitPane sp=((JSplitPane)getComponent(0));
				sp.setTopComponent(dibujaBalance());
			}
			else if (tipo.equals("balance"))
			{	balance=(int[])datos.get(1);
				int mes=Integer.valueOf((String)datos.get(2)).intValue();
				mesBal=dameMeses(mes);
				JSplitPane sp=((JSplitPane)getComponent(0));
				sp.setTopComponent(dibujaBalance());
			}					
		}
		else if (panel==3)
		{	String tipo=(String)datos.get(0);
			if (tipo.equals("facturacion"))
			{	facturacion=(int[])datos.get(1);
				int mes=Integer.valueOf((String)datos.get(2)).intValue();
				mesFac=dameMeses(mes);
				JSplitPane sp=((JSplitPane)getComponent(0));
				sp.setTopComponent(dibujaBalance());
				sp.setBottomComponent(dibujaGrafico(facturacion,"Histórico de Facturación",mesFac));
				actualizadoFacturacion=true;
			}
			else if (tipo.equals("gastos"))
			{	gastos=(int[])datos.get(1);
				int mes=Integer.valueOf((String)datos.get(2)).intValue();
				mesGas=dameMeses(mes);
				JSplitPane sp=((JSplitPane)getComponent(0));
				sp.setTopComponent(dibujaBalance());
				sp.setBottomComponent(dibujaGrafico(gastos,"Histórico de Gastos",mesGas));
				actualizadoGasto=true;
			}
			else if (tipo.equals("balance"))
			{		balance=(int[])datos.get(1);
				int mes=Integer.valueOf((String)datos.get(2)).intValue();
				mesBal=dameMeses(mes);
				JSplitPane sp=((JSplitPane)getComponent(0));
				sp.setTopComponent(dibujaBalance());
				sp.setBottomComponent(dibujaGrafico(balance,"Histórico de Balance",mesBal));
				actualizadoBalance=true;
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
		{	
			if (m<11)	m=m+1;
			else	m=0;
			vMeses[i]=mesesIni[m];
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
		int intbal=bal.intValue();
		if (intbal<0) tbal.setForeground(Color.RED);			
		tfac.setBackground(Color.WHITE);
		tgas.setBackground(Color.WHITE);
		tbal.setBackground(Color.WHITE);
		JButton bfacturacion=new JButton ("Calcular");
		bfacturacion.setToolTipText("Calcular facturación para el mes actual");
		bfacturacion.setPreferredSize(new Dimension(80,20));
		JButton bgastos=new JButton ("Calcular");
		bgastos.setToolTipText("Calcular gastos para el mes actual");
		bgastos.setPreferredSize(new Dimension(80,20));
		JButton bbalance=new JButton ("Calcular");
		bbalance.setToolTipText("Calcular balance para el mes actual");
		bbalance.setPreferredSize(new Dimension(80,20));
		JButton bhfac=new JButton (new ImageIcon("interfaz/grafico.gif"));
		bhfac.setToolTipText("Mostrar gráfico de facturación del último año");
		bhfac.setPreferredSize(new Dimension(20,20));
		JButton bhgas=new JButton (new ImageIcon("interfaz/grafico.gif"));
		bhgas.setToolTipText("Mostrar gráfico de gastos del último año");
		bhgas.setPreferredSize(new Dimension(20,20));
		JButton bhbal=new JButton (new ImageIcon("interfaz/grafico.gif"));
		bhbal.setToolTipText("Mostrar gráfico de balance del último año");
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
		caja.setPreferredSize(new Dimension(755,286));
		JLabel logo=new JLabel(new ImageIcon("interfaz/sigrem2.jpg"));
		logo.setPreferredSize(new Dimension(168,0));
		JSplitPane sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,logo,caja);
		sp.setEnabled(false);		
		sp.setDividerSize(4);
		pbal.add(sp);
		bhfac.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (!actualizadoFacturacion) 
				{
					JOptionPane.showMessageDialog(null,"Los valores del histórico no están actualizados");
				}
				else
				{	LinkedList datos=new LinkedList();
					datos.add(new String("facturacion"));
					actualiza(2,datos);
				}
			}
		});
		bhgas.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (!actualizadoGasto) 
				{
					JOptionPane.showMessageDialog(null,"Los valores del histórico no están actualizados");
				}
				else
				{	LinkedList datos=new LinkedList();
					datos.add(new String("gastos"));
					actualiza(2,datos);
				}
			}
		});
		bhbal.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				if (!actualizadoBalance) 
				{
					JOptionPane.showMessageDialog(null,"Los valores del histórico no están actualizados");
				}
				else
				{	LinkedList datos=new LinkedList();
					datos.add(new String("balance"));
					actualiza(2,datos);
				}
			}
		});
		bfacturacion.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				actualizadoFacturacion=true;
				controlador.calculaFacturacion(0);
			}
		});
		bgastos.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				actualizadoGasto=true;
				controlador.calculaGastos(0);			
			}
		});
		bbalance.addActionListener(new ActionListener()
		{	public void actionPerformed(ActionEvent e)
			{
				actualizadoBalance=true;	
				controlador.calculaBalance(0);
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
		{	int maxValorGrafico=1;
			for (int i=0;i<12;i++)
			if (num[i]<-maxValorGrafico) maxValorGrafico=-num[i];
			else if (num[i]>maxValorGrafico) maxValorGrafico=num[i];
			JLabel l1=new JLabel(" 0 ",SwingConstants.RIGHT);
			JLabel l2=new JLabel(" ",SwingConstants.RIGHT);
			JLabel l3=new JLabel(" ",SwingConstants.RIGHT);
			JLabel l4=new JLabel(" ",SwingConstants.RIGHT);
			JLabel l5=new JLabel(" ",SwingConstants.RIGHT);
			JLabel l6=new JLabel(""+maxValorGrafico/2,SwingConstants.RIGHT);
			JLabel l7=new JLabel(" ",SwingConstants.RIGHT);
			JLabel l8=new JLabel(" ",SwingConstants.RIGHT);
			JLabel l9=new JLabel(" ",SwingConstants.RIGHT);
			JLabel l10=new JLabel(" ",SwingConstants.RIGHT);
			JLabel l11=new JLabel(""+maxValorGrafico,SwingConstants.RIGHT);
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
			{
				if (num[i]<0)	caja.add(dibujaBarra(-((150*num[i])/maxValorGrafico),vMeses[i],Color.RED));
				else	caja.add(dibujaBarra(((150*num[i])/maxValorGrafico),vMeses[i],Color.GREEN));				
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
		relleno1.setPreferredSize(new Dimension(20, 160-num));
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
