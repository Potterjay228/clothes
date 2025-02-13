package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import controller.member.LoginUI;
import model.Member;
import service.impl.PorderServiceImpl;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PorderMainUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Member member=(Member)Tool.read("member.txt");
	
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderMainUI frame = new PorderMainUI();
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
	public PorderMainUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 143, 168));
		panel.setBounds(10, 10, 416, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("葛來美服飾訂單");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 21));
		lblNewLabel.setBounds(136, 21, 159, 26);
		panel.add(lblNewLabel);
		
		JLabel clock = new JLabel("2025-02-13 10:59:23");
		clock.setFont(new Font("新細明體", Font.BOLD, 14));
		clock.setBounds(287, 38, 129, 19);
		panel.add(clock);		
		Timer timer = new Timer(1000, e -> updateDateTime(clock));
		timer.start();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 143, 168));
		panel_1.setBounds(10, 74, 416, 269);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("新增訂單");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AddPorderUI addporder=new AddPorderUI();
				addporder.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 16));
		btnNewButton.setBounds(144, 43, 109, 36);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("管理訂單");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				PorderManagerUI pordermanager=new PorderManagerUI();
				pordermanager.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 16));
		btnNewButton_1.setBounds(144, 101, 109, 36);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("離開");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.exit(0);
				
			}
		});
		btnNewButton_1_1.setFont(new Font("新細明體", Font.BOLD, 16));
		btnNewButton_1_1.setBounds(144, 160, 109, 36);
		panel_1.add(btnNewButton_1_1);
		
		JLabel marqueeLabel = new JLabel(member.getName()+"您好! 訂購請選新增訂單,查詢修改請選管理訂單! ");
		marqueeLabel.setFont(new Font("新細明體", Font.BOLD, 15));
		marqueeLabel.setBounds(25, 10, 381, 23);
		panel_1.add(marqueeLabel);
		timer.start();
		
		Thread marqueeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String text = marqueeLabel.getText();
                        marqueeLabel.setText(text.substring(1) + text.charAt(0));
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        marqueeThread.start();				
		
	}
	private Object updateDateTime(JLabel clock) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime=sdf.format(new Date());
		clock.setText(currentDateTime);
		return null;
	}
}
