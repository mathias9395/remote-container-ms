package dk.dtu.management.view;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicArrowButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

import dk.dtu.management.controller.ClientViewStatusController;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ClientViewStatusView extends JFrame{
	
	private ClientViewStatusController controller;
	private JLabel tempField;
	private JLabel humidityField;
	private JLabel pressureField;
	private static BasicArrowButton back;
	private JPanel Tpanel;
	private JPanel Hpanel;
	private JPanel Ppanel;

	public ClientViewStatusView(ClientViewStatusController clientViewStatusController) {
		this.controller = clientViewStatusController;
		initGUI();
	}
	
	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Journey Status");
		setPreferredSize(new Dimension(1200,450));
		
		//labels
		
		JLabel tempLabel = new JLabel("Temperature:");
		JLabel humidityLabel= new JLabel("Humidity:");
		JLabel pressureLabel = new JLabel("Pressure:");
		JLabel timeLabel = new JLabel("Time:");
		JLabel locationLabel = new JLabel("Location:");
		JLabel statusLabel = new JLabel("Journey status:");
			
		JLabel tempField = new JLabel(controller.getTemperature());
		JLabel humidityField = new JLabel(controller.getHumidity());
		JLabel pressureField = new JLabel(controller.getPressure());
		JLabel locationField = new JLabel(controller.getLocation());
		JLabel timeField = new JLabel(controller.getTime());
		JLabel statusField = new JLabel(controller.getStatus());
		
		//////////////TEMP/////////////
		
		Tpanel = new JPanel();
		
		Tpanel.setLayout(null);
		
		Tpanel.setBounds(0,100, 400, 300);
		
		XYDataset dt = tempDataSet();
        
        JFreeChart chart = ChartFactory.createXYLineChart("Temperature",
                "time", "K", dt , PlotOrientation.VERTICAL, true, true,
                false);
        XYPlot plot = (XYPlot) chart.getPlot();
        ValueAxis range = plot.getDomainAxis();
        range.setVisible(false);
        
        
        ChartPanel ct = new ChartPanel(chart);
        
        ct.setChart(chart);
        ct.setBounds(0, 0, 400, 300);
        
        Tpanel.add(ct);	
		
		getContentPane().add(Tpanel);
		
		////////////HUMIDITY////////////
		

		Hpanel = new JPanel();
		
		Hpanel.setLayout(null);
		
		Hpanel.setBounds(400,100,400, 300);
		
		XYDataset dh = humidityDataSet();
        
        JFreeChart charthum = ChartFactory.createXYLineChart("Humidity",
                "time", "%", dh , PlotOrientation.VERTICAL, true, true,
                false);
        
        XYPlot plothum = (XYPlot) charthum.getPlot();
        ValueAxis rangehum = plothum.getDomainAxis();
        rangehum.setVisible(false);
        ChartPanel ch = new ChartPanel(charthum);

        ch.setChart(charthum);
        ch.setForeground(Color.cyan);
        ch.setBounds(0, 0, 400, 300);
        
        Hpanel.add(ch);	
		
		getContentPane().add(Hpanel);
		
		////////////PRESSURE//////////////
		


		Ppanel = new JPanel();
		
		Ppanel.setLayout(null);
		
		Ppanel.setBounds(800,100, 400, 300);
		
		XYDataset dp = pressureDataSet();
        
        JFreeChart chartpress = ChartFactory.createXYLineChart("Pressure",
                "time", "hPa", dp , PlotOrientation.VERTICAL, true, true,
                false);
        
        XYPlot plotpress = (XYPlot) chartpress.getPlot();
        ValueAxis rangepress = plotpress.getDomainAxis();
        rangepress.setVisible(false);
        ChartPanel cp = new ChartPanel(chartpress);

        cp.setChart(chartpress);
        cp.setForeground(Color.blue);
        cp.setBounds(0, 0, 400, 300);
        
        Ppanel.add(cp);	
		
		getContentPane().add(Ppanel);
		
		/////////////////////////////////
		
		//buttons
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.returnDashboard(); 
			}
		});
		
		setLayout(null);
		tempLabel.setBounds(70, 20, 140, 20);
		add(tempLabel);
		tempField.setBounds(170, 20, 140, 20);
		add(tempField);
		humidityLabel.setBounds(70, 40, 140, 20);
		add(humidityLabel);
		humidityField.setBounds(170, 40, 140, 20);
		add(humidityField);
		pressureLabel.setBounds(70, 60, 140, 20);
		add(pressureLabel);
		pressureField.setBounds(170, 60, 140, 20);
		add(pressureField);
		timeLabel.setBounds(900, 20, 140, 20);
		add(timeLabel);
		timeField.setBounds(1000, 20, 180, 20);
		add(timeField);
		locationLabel.setBounds(900, 40, 140, 20);
		add(locationLabel);
		locationField.setBounds(1000, 40, 140, 20);
		add(locationField);
		statusLabel.setBounds(900, 60, 140, 20);
		add(statusLabel);
		statusField.setBounds(1000, 60, 140, 20);
		add(statusField);
		
		// BACK button
		
		back = new BasicArrowButton(BasicArrowButton.WEST);
		back.addActionListener(e -> {
			controller.returnDashboard();
		});
		
		back.setBounds(0,0,20,20);
		add(back);
		
		///
		
		setVisible(true);
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	private XYDataset tempDataSet() {

        DefaultXYDataset ds = new DefaultXYDataset();

        double[][] data1 = { controller.timeList(), controller.tempList() };

        ds.addSeries("temperature evolution", data1);

        return ds;
    }
	
	private XYDataset pressureDataSet() {
		
		DefaultXYDataset ds = new DefaultXYDataset();

        double[][] data2 = { controller.timeList(), controller.pressureList() };

        ds.addSeries("pressure evolution", data2);

        return ds;
	}
	
	private XYDataset humidityDataSet() {
		
		DefaultXYDataset ds = new DefaultXYDataset();

        double[][] data3 = {controller.timeList() , controller.humidityList()};
        
        ds.addSeries("humidity evolution", data3);

        return ds;
	}
	
	
}
	