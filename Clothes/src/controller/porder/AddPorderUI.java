package controller.porder;

import java.awt.EventQueue;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import controller.member.LoginUI;
import model.Member;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.Tool;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

import javax.swing.JScrollPane;

public class AddPorderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSpinner shirtSpinner, trousersSpinner, sneakersSpinner;
    
    private static Member member=(Member)Tool.read("member.txt");
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();
    private int shirtPrice=499,trousersPrice=650,sneakersPrice=1300;   
    private int shirtCount = 0, trousersCount = 0, sneakersCount = 0;
    private JTextField pay;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorderUI frame = new AddPorderUI();
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
	public AddPorderUI() {
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
		
		JLabel lblNewLabel = new JLabel("新增訂單");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 21));
		lblNewLabel.setBounds(154, 18, 102, 26);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 143, 168));
		panel_1.setBounds(10, 79, 416, 274);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel showMember = new JLabel(member.getName()+"您好");
		showMember.setFont(new Font("新細明體", Font.BOLD, 15));
		showMember.setBounds(29, 10, 109, 23);
		panel_1.add(showMember);
		
		JLabel lblNewLabel_1 = new JLabel("襯衫");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(39, 40, 38, 23);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("長褲");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(39, 72, 38, 23);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("球鞋");
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(39, 105, 38, 23);
		panel_1.add(lblNewLabel_1_2);
		
		
		
		
		JSpinner shirtSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		shirtSpinner.setBounds(77, 37, 40, 25);
		panel_1.add(shirtSpinner);
		
		JSpinner trousersSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		trousersSpinner.setBounds(77, 72, 40, 25);
		panel_1.add(trousersSpinner);
		
		JSpinner sneakersSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
		sneakersSpinner.setBounds(77, 105, 40, 25);
		panel_1.add(sneakersSpinner);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(158, 37, 231, 125);
		panel_1.add(scrollPane);
		
		JTextArea output_1 = new JTextArea();
		scrollPane.setViewportView(output_1);
		output_1.setEditable(false);		
				
		
		
		
		JRadioButton myMember = new JRadioButton("會員9折");
		myMember.setFont(new Font("新細明體", Font.BOLD, 15));
		myMember.setBounds(37, 140, 89, 23);
		panel_1.add(myMember);
		
		JButton btnNewButton_1 = new JButton("清除");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				shirtSpinner.setValue(0);
				trousersSpinner.setValue(0);
				sneakersSpinner.setValue(0);
				output_1.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_1.setBounds(37, 210, 85, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("列印");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
								
				try {
					output_1.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_2.setBounds(200, 241, 85, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("上一頁");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				               
				PorderMainUI porderMainUI=new PorderMainUI();
				porderMainUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_3.setBounds(316, 241, 85, 23);
		panel_1.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("支付金額");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(149, 178, 72, 24);
		panel_1.add(lblNewLabel_2);
		
		pay = new JTextField();
		pay.setBounds(220, 178, 96, 21);
		panel_1.add(pay);
		pay.setColumns(10);
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=member.getName();
				shirtCount = (int) shirtSpinner.getValue();
				trousersCount = (int) trousersSpinner.getValue();
				sneakersCount = (int) sneakersSpinner.getValue();	
				
		        int shirtTotal = shirtCount * shirtPrice;
		        int trousersTotal = trousersCount * trousersPrice;
		        int sneakersTotal = sneakersCount * sneakersPrice;
		        int total = shirtTotal + trousersTotal + sneakersTotal;
		        double memberTotal = (int)(total*0.9);
		        

		        if(shirtCount>=0 && trousersCount>=0 && sneakersCount>=0 && myMember.isSelected() )
                {               	
                	output_1.setText(showMember.getText()+",葛來美感謝您的購買:"+
                			"\n------------------------------------------------------"+
                			"\n襯衫499元"+shirtCount+"件"+"="+shirtTotal+"元"+ 
                			"\n長褲650元"+trousersCount+"件"+"="+trousersTotal+"元"+
                			"\n球鞋1300元"+sneakersCount +"雙"+"="+sneakersTotal+"元"+
                			"\n交易金額:"+total+"元"+
                			"\n會員9折:"+memberTotal+"元");
                }
                else if(shirtCount>=0 && trousersCount>=0 && sneakersCount>=0 )
                {
                	output_1.setText(showMember.getText()+",葛來美感謝您的購買:"+
                			"\n------------------------------------------------------"+
                			"\n襯衫499元"+shirtCount+"件"+"="+shirtTotal+"元"+ 
                			"\n長褲650元"+trousersCount+"件"+"="+trousersTotal+"元"+
                			"\n球鞋1300元"+sneakersCount +"雙"+"="+sneakersTotal+"元"+
                			"\n交易金額:"+total+"元");
                }
		        
		
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton.setBounds(37, 175, 85, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("找零");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=member.getName();
				int Shirt = (int) shirtSpinner.getValue();
				int Trousers = (int) trousersSpinner.getValue();
				int Sneakers = (int) sneakersSpinner.getValue();
				/*int Shirt=Integer.parseInt(shirtSpinner.getValue());
				int Trousers=Integer.parseInt(trousersSpinner.getValue());
				int Sneakers=Integer.parseInt(sneakersSpinner.getValue());*/
				String Pay = pay.getText();	
				Integer PY = new Integer(Pay);
                                
				int appleTotal = shirtCount * shirtPrice;
				int strawberryTotal = trousersCount *trousersPrice;
				int grapeTotal = sneakersCount * sneakersPrice;
				int total = appleTotal + strawberryTotal + grapeTotal;
				int memberTotal = (int)(total*0.9);
				int change=PY-total;
				int memberchange=(int) (PY-memberTotal);
				
				
				
				if(shirtCount>=0 && trousersCount>=0 && sneakersCount>=0 && myMember.isSelected() )
                {
					if(memberchange >0) 
					{
						output_1.setText(showMember.getText()+",葛來美感謝您的購買:"+
								"\n------------------------------------------------------"+
								"\n襯衫50元"+shirtCount+"件"+"="+appleTotal+"元"+ 
	                			"\n長褲150元"+trousersCount+"件"+"="+strawberryTotal+"元"+
	                			"\n球鞋120元"+sneakersCount +"雙"+"="+grapeTotal+"元"+
	                			"\n交易金額:"+total+"元"+
	                			"\n會員9折:"+memberTotal+"元"+
	                			"\n------------------------------------------------------"+
	                			"\n您支付:"+PY+"元"+
	                			"\n需找您:"+memberchange+"元"+
	                			"\n1000元:"+memberchange/1000+"張"+
	                			"\n100元:"+memberchange%1000/100+"張"+
	                			"\n10元:"+memberchange%1000%100/10+"個"+
	                			"\n1元:"+memberchange%1000%100%10+"個"
	                			);
					}
					else if(memberchange==0)
					{
						output_1.setText(showMember.getText()+",葛來美感謝您的購買:"+
								"\n------------------------------------------------------"+
								"\n襯衫50元"+shirtCount+"件"+"="+appleTotal+"元"+ 
	                			"\n長褲150元"+trousersCount+"件"+"="+strawberryTotal+"元"+
	                			"\n球鞋120元"+sneakersCount +"雙"+"="+grapeTotal+"元"+
	                			"\n交易金額:"+total+"元"+
	                			"\n會員9折:"+memberTotal+"元"+
	                			"\n------------------------------------------------------"+
	                			"\n您支付:"+PY+"元"+
	                			"\n金額剛好,無須找零,感謝您");
					}
					else if(memberchange<0)
					{
						output_1.setText(showMember.getText()+",葛來美感謝您的購買:"+
								"\n------------------------------------------------------"+
								"\n襯衫50元"+shirtCount+"件"+"="+appleTotal+"元"+ 
	                			"\n長褲150元"+trousersCount+"件"+"="+strawberryTotal+"元"+
	                			"\n球鞋120元"+sneakersCount +"雙"+"="+grapeTotal+"元"+
	                			"\n交易金額:"+total+"元"+
	                			"\n會員9折:"+memberTotal+"元"+
	                			"\n------------------------------------------------------"+
	                			"\n您支付:"+PY+"元"+
	                			"\n您支付的金額不足喔!");
					}
                	
                }
                else if(shirtCount>=0 && trousersCount>=0 && sneakersCount>=0 )
                {
                	if(change >0)
                	{
                		output_1.setText(showMember.getText()+",葛來美感謝您的購買:"+
                				"\n------------------------------------------------------"+
                				"\n襯衫50元"+shirtCount+"件"+"="+appleTotal+"元"+ 
	                			"\n長褲150元"+trousersCount+"件"+"="+strawberryTotal+"元"+
	                			"\n球鞋120元"+sneakersCount +"雙"+"="+grapeTotal+"元"+
	                			"\n交易金額:"+total+"元"+
	                			"\n------------------------------------------------------"+
	                			"\n您支付:"+PY+"元"+
	                			"\n需找您:"+change+"元"+
	                			"\n1000元:"+change/1000+"張"+
	                			"\n100元:"+change%1000/100+"張"+
	                			"\n10元:"+change%1000%100/10+"個"+
	                			"\n1元:"+change%1000%100%10+"個"
	                			);
                	}
                	else if(change==0)
                	{
                		output_1.setText(showMember.getText()+",葛來美感謝您的購買:"+
                				"\n------------------------------------------------------"+
                				"\n襯衫50元"+shirtCount+"件"+"="+appleTotal+"元"+ 
	                			"\n長褲150元"+trousersCount+"件"+"="+strawberryTotal+"元"+
	                			"\n球鞋120元"+sneakersCount +"雙"+"="+grapeTotal+"元"+
	                			"\n交易金額:"+total+"元"+
	                			"\n------------------------------------------------------"+
	                			"\n您支付:"+PY+"元"+
                				"\n金額剛好,無須找零,感謝您");
                	}
                	else if(change<0)
                	{
                		output_1.setText(showMember.getText()+",葛來美感謝您的購買:"+
                				"\n------------------------------------------------------"+
                				"\n襯衫50元"+shirtCount+"件"+"="+appleTotal+"元"+ 
	                			"\n長褲150元"+trousersCount+"件"+"="+strawberryTotal+"元"+
	                			"\n球鞋120元"+sneakersCount +"雙"+"="+grapeTotal+"元"+
	                			"\n交易金額:"+total+"元"+
	                			"\n------------------------------------------------------"+
	                			"\n您支付:"+PY+"元"+
                				"\n您支付的金額不足喔!");
                	}
                		                	
                }
			}
		});
		btnNewButton_4.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_4.setBounds(316, 177, 85, 23);
		panel_1.add(btnNewButton_4);
		
		JLabel clock = new JLabel("2025-02-11 15:36:26");
		clock.setFont(new Font("新細明體", Font.BOLD, 14));
		clock.setBounds(268, 10, 138, 19);
		panel_1.add(clock);
		
		Timer timer = new Timer(1000, e -> updateDateTime(clock));
		
		JButton btnNewButton_5 = new JButton("完成交易");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String Name=member.getName();				
				int Shirt = (int) shirtSpinner.getValue();
				int Trousers = (int) trousersSpinner.getValue();
				int Sneakers = (int) sneakersSpinner.getValue();
				
				Porder p=new Porder(Name,Shirt,Trousers,Sneakers);				
				porderserviceimpl.addPorder(p);
				
				JOptionPane.showMessageDialog(null, "完成交易,已存入管理訂單");
			}
		});
		btnNewButton_5.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_5.setBounds(230, 208, 103, 23);
		panel_1.add(btnNewButton_5);
		
		JLabel lblNewLabel_3 = new JLabel("購買明細:");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_3.setBounds(163, 14, 72, 23);
		panel_1.add(lblNewLabel_3);
		timer.start();
	}

	private Object updateDateTime(JLabel clock) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime=sdf.format(new Date());
		clock.setText(currentDateTime);
		return null;
	}
}
