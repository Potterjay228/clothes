package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.porder.PorderMainUI;
import model.Member;
import service.impl.MemberServiceImpl;
import util.Tool;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 143, 168));
		panel.setBounds(10, 10, 416, 75);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("葛來美服飾登入系統");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 21));
		lblNewLabel.setBounds(106, 27, 203, 26);
		panel.add(lblNewLabel);
		
		JLabel clock = new JLabel("2025-02-13 11:13:30");
		clock.setFont(new Font("新細明體", Font.BOLD, 14));
		clock.setBounds(278, 56, 138, 19);
		panel.add(clock);
		Timer timer = new Timer(1000, e -> updateDateTime(clock));
		timer.start();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 143, 168));
		panel_1.setBounds(10, 95, 416, 248);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("帳號:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1.setBounds(93, 52, 51, 23);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("密碼");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(93, 98, 51, 23);
		panel_1.add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setBounds(142, 54, 96, 21);
		panel_1.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(142, 100, 96, 21);
		panel_1.add(password);
		password.setColumns(10);
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Username=username.getText();
				String Password=password.getText();
				
				Member member=new MemberServiceImpl().Login(Username, Password);
				
				if(member!=null)
				{
					JOptionPane.showMessageDialog(null, "登入成功，"+member.getName()+"歡迎光臨");
					Tool.save(member,"member.txt");
					PorderMainUI pordermainui=new PorderMainUI();
					pordermainui.setVisible(true);
					dispose();
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "請輸入正確的帳號和密碼");
				}
				
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton.setBounds(92, 159, 85, 27);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				AddMemberUI addMemberUI=new AddMemberUI();
				addMemberUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_1.setBounds(187, 159, 85, 27);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("離開");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.exit(0);
			}
		});
		btnNewButton_1_1.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(280, 159, 85, 27);
		panel_1.add(btnNewButton_1_1);
		timer.start();
	}
	
	private Object updateDateTime(JLabel clock) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime=sdf.format(new Date());
		clock.setText(currentDateTime);
		return null;
	}
}
