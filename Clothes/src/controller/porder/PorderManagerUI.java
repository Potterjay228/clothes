package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.PorderServiceImpl;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.Timer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;

public class PorderManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Member member=(Member)Tool.read("member.txt");
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();
	private JSpinner updateId, shirt, trousers,sneakers,delete;

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
		
		JLabel clock = new JLabel("2025-02-13 11:11:05");
		clock.setFont(new Font("新細明體", Font.BOLD, 14));
		clock.setBounds(278, 24, 138, 19);
		panel.add(clock);
		Timer timer = new Timer(1000, e -> updateDateTime(clock));
		
		JButton btnNewButton_2_1_1 = new JButton("上一頁");
		btnNewButton_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PorderMainUI pordermainui=new PorderMainUI();
				pordermainui.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1_1.setBounds(5, 5, 85, 23);
		panel.add(btnNewButton_2_1_1);
		timer.start();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 143, 168));
		panel_1.setBounds(10, 56, 416, 136);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(7, 27, 400, 105);
		panel_1.add(scrollPane);
		
		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(250, 143, 168));
		panel_2.setBounds(10, 197, 416, 79);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("id");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1.setBounds(122, 10, 27, 20);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("襯衫");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(122, 49, 38, 20);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("長褲");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(239, 10, 44, 20);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("球鞋");
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1_3.setBounds(239, 49, 44, 20);
		panel_2.add(lblNewLabel_1_3);
		
	
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(250, 143, 168));
		panel_3.setBounds(10, 280, 416, 63);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("id");
		lblNewLabel_1_4.setFont(new Font("新細明體", Font.BOLD, 17));
		lblNewLabel_1_4.setBounds(122, 20, 27, 20);
		panel_3.add(lblNewLabel_1_4);
		
		
		JButton btnNewButton = new JButton("查詢");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				output.setText(porderserviceimpl.AllPorder());
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton.setBounds(5, 5, 85, 23);
		panel_1.add(btnNewButton);
		timer.start();
		
		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int Id= (int) updateId.getValue();
				int Shirt = (int) shirt.getValue();
				int Trousers = (int) trousers.getValue();
				int Sneakers = (int) sneakers.getValue();
								
				porderserviceimpl.updatePorder(Shirt, Trousers, Sneakers, Id);
								
				JOptionPane.showMessageDialog(null, "已修改,請重按查詢確認");
								
			}
		});
		btnNewButton_1.setBounds(10, 28, 85, 23);
		panel_2.add(btnNewButton_1);
		
		updateId = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		updateId.setBounds(175, 10, 48, 22);
		panel_2.add(updateId);
		
		shirt = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		shirt.setBounds(175, 50, 48, 22);
		panel_2.add(shirt);
		
		trousers = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		trousers.setBounds(295, 10, 51, 22);
		panel_2.add(trousers);
		
		sneakers = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		sneakers.setBounds(295, 50, 51, 22);
		panel_2.add(sneakers);
		
		JButton btnNewButton_2 = new JButton("刪除");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int Delete= (int) delete.getValue();
				porderserviceimpl.deletePorderById(Delete);
				
				JOptionPane.showMessageDialog(null, "已刪除,請重按查詢確認");
			}
		});
		btnNewButton_2.setBounds(10, 18, 85, 23);
		panel_3.add(btnNewButton_2);
		
		delete = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		delete.setBounds(175, 21, 48, 22);
		panel_3.add(delete);
	}

	private Object updateDateTime(JLabel clock) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime=sdf.format(new Date());
		clock.setText(currentDateTime);
		return null;
		
	}
}
