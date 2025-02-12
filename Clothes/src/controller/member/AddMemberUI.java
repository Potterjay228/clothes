package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.porder.PorderMainUI;
import model.Member;
import service.impl.MemberServiceImpl;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField phone;
	private JTextField mobile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberUI frame = new AddMemberUI();
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
	public AddMemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(250, 143, 168));
		panel.setBounds(10, 10, 416, 59);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("註冊新會員");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 21));
		lblNewLabel.setBounds(140, 18, 123, 29);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 143, 168));
		panel_1.setBounds(10, 79, 416, 264);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(62, 19, 45, 20);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號:");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(62, 49, 45, 20);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("密碼:");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(62, 79, 45, 20);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("地址:");
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(62, 109, 45, 20);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("電話:");
		lblNewLabel_1_4.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(62, 139, 45, 20);
		panel_1.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("手機:");
		lblNewLabel_1_5.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1_5.setBounds(62, 169, 45, 20);
		panel_1.add(lblNewLabel_1_5);
		
		name = new JTextField();
		name.setBounds(108, 19, 96, 21);
		panel_1.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(108, 49, 96, 21);
		panel_1.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(108, 79, 96, 21);
		panel_1.add(password);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(108, 109, 96, 21);
		panel_1.add(address);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(108, 139, 96, 21);
		panel_1.add(phone);
		
		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBounds(108, 169, 96, 21);
		panel_1.add(mobile);
		
		JLabel lblNewLabel_3 = new JLabel("英文字母和數字,6至8字");
		lblNewLabel_3.setForeground(new Color(255, 255, 0));
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 13));
		lblNewLabel_3.setBounds(214, 52, 170, 15);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("只能數字,7至9字");
		lblNewLabel_4.setForeground(new Color(255, 255, 0));
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 13));
		lblNewLabel_4.setBounds(214, 82, 138, 15);
		panel_1.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Username=username.getText();
				String Password=password.getText();
				if(new MemberServiceImpl().isUsernameBeenUse(Username))
				{
					JOptionPane.showMessageDialog(null, "帳號重複註冊");
				}
				else if(isValidUsername(Username) && isValidPassword(Password)) {
					
					String Name=name.getText();										
					String Address=address.getText();
					String Phone=phone.getText();
					String Mobile=mobile.getText();
					
					Member member=new Member(Name,Username,Password,Address,Phone,Mobile);
					
					new MemberServiceImpl().addMember(member);
															
                    JOptionPane.showMessageDialog(null, "註冊成功,請重新登入");
                    
                    LoginUI loginUI=new LoginUI();
                    loginUI.setVisible(true);
					dispose();
                } 
				else
				{
					JOptionPane.showMessageDialog(null, "請依照規則輸入帳號密碼");
				}
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_1.setBounds(62, 211, 85, 27);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("回登入");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				LoginUI loginUI=new LoginUI();
                loginUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_1.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(185, 213, 85, 27);
		panel_1.add(btnNewButton_1_1);
		
		JLabel clock = new JLabel("2025-02-11 17:00:01");
		clock.setFont(new Font("新細明體", Font.BOLD, 14));
		clock.setBounds(268, 10, 138, 19);
		panel_1.add(clock);
		
		Timer timer = new Timer(1000, e -> updateDateTime(clock));
		timer.start();
	}
	
	private Object updateDateTime(JLabel clock) {
		
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentDateTime=sdf.format(new Date());
			clock.setText(currentDateTime);
			return null;
		}
	

	private boolean isValidUsername(String Username) {
        String regex = "^[a-zA-Z0-9]{6,8}$"; // 字符串长度大于5小于9，且只能包含字母和数字
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Username);
        return matcher.matches();
    }
    
    // 正则表达式验证密码
    private boolean isValidPassword(String Password) {
        String regex = "^[0-9]{7,9}$"; // 密码长度大于6小于10，且只能包含数字
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(Password);
        return matcher.matches();
    }

}
