package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.impl.PorderServiceImpl;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PorderManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField updateId;
	private JTextField shirt;
	private JTextField trousers;
	private JTextField sneakers;
	private JTextField delete;
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderManagerUI frame = new PorderManagerUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PorderManagerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 143, 168));
		panel.setBounds(10, 10, 416, 43);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("管理訂單");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 19));
		lblNewLabel.setBounds(152, 10, 81, 23);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 143, 168));
		panel_1.setBounds(10, 56, 416, 136);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea output = new JTextArea();
		output.setBounds(7, 27, 400, 105);
		panel_1.add(output);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(250, 143, 168));
		panel_2.setBounds(10, 197, 416, 79);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("id");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1.setBounds(102, 9, 27, 20);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("襯衫");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(96, 49, 38, 20);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("長褲");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(215, 9, 56, 20);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("球鞋");
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1_3.setBounds(215, 49, 65, 20);
		panel_2.add(lblNewLabel_1_3);
		
		updateId = new JTextField();
		updateId.setBounds(133, 10, 65, 21);
		panel_2.add(updateId);
		updateId.setColumns(10);
		
		shirt = new JTextField();
		shirt.setColumns(10);
		shirt.setBounds(133, 50, 71, 21);
		panel_2.add(shirt);
		
		trousers = new JTextField();
		trousers.setColumns(10);
		trousers.setBounds(281, 10, 71, 21);
		panel_2.add(trousers);
		
		sneakers = new JTextField();
		sneakers.setColumns(10);
		sneakers.setBounds(281, 50, 71, 21);
		panel_2.add(sneakers);
		
	
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(250, 143, 168));
		panel_3.setBounds(10, 280, 416, 63);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("id");
		lblNewLabel_1_4.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1_4.setBounds(108, 20, 27, 20);
		panel_3.add(lblNewLabel_1_4);
		
		delete = new JTextField();
		delete.setColumns(10);
		delete.setBounds(133, 19, 65, 21);
		panel_3.add(delete);
		
		
		JButton btnNewButton = new JButton("查詢");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				output.setText(porderserviceimpl.AllPorder());
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton.setBounds(5, 0, 85, 23);
		panel_1.add(btnNewButton);
		
		JLabel clock = new JLabel("2025-02-11 15:37:52");
		clock.setFont(new Font("新細明體", Font.BOLD, 14));
		clock.setBounds(269, 4, 138, 19);
		panel_1.add(clock);
		
		Timer timer = new Timer(1000, e -> updateDateTime(clock));
		timer.start();
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int Id=Integer.parseInt(updateId.getText());
				int Shirt=Integer.parseInt(shirt.getText());
				int Trousers=Integer.parseInt(trousers.getText());
				int Sneaker=Integer.parseInt(sneakers.getText());
								
				porderserviceimpl.updatePorder(Shirt, Trousers, Sneaker, Id);
								
				JOptionPane.showMessageDialog(null, "已修改,請重按查詢確認");
								
			}
		});
		btnNewButton_1.setBounds(10, 28, 85, 23);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("刪除");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Delete=Integer.parseInt(delete.getText());
				porderserviceimpl.deletePorderById(Delete);
				
				JOptionPane.showMessageDialog(null, "已刪除,請重按查詢確認");
			}
		});
		btnNewButton_2.setBounds(10, 18, 85, 23);
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("上一頁");
		btnNewButton_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PorderMainUI pordermainui=new PorderMainUI();
				pordermainui.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1.setBounds(283, 17, 85, 23);
		panel_3.add(btnNewButton_2_1);
	}

	private Object updateDateTime(JLabel clock) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime=sdf.format(new Date());
		clock.setText(currentDateTime);
		return null;
		
	}

}
