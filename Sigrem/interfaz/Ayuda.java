package interfaz;

import javax.swing.*;
import main.Sigrem;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;

public class Ayuda {

	private static JTextArea salida;
	
	private static JList lista;
	
	private JFrame f1;
	
	public Ayuda()
	{
		super();
	}
	
	public void dibujaPaneles()
	{
		panel1();
	}
	
	public void panel1()
	{
		f1=new JFrame();
		String[] opciones = {"Sigrem"," + Menú"," + Gestión Contratos"," + Gestión Empleados"," + Gestión Económica"};
		lista=new JList(opciones);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		salida=new JTextArea();
		JScrollPane psalida=new JScrollPane(salida);
		psalida.setPreferredSize(new Dimension(100,100));
		f1.getContentPane().add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,lista,psalida));
		f1.setTitle("Ayuda - Sigrem");
		f1.pack();
		lista.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{
				salida.append("Hola\n");
				salida.append("Adios\n");
			}
		});
		f1.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		f1.setVisible(true);
	}
}
