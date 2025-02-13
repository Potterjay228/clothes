package controller.porder;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.Tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Color;
import java.awt.Font;

public class AddPorderUI extends JFrame {
    private JTextArea output_1;
    private JTextArea payback;
    private JSpinner shirtSpinner, trousersSpinner, sneakersSpinner;
    private int shirtPrice=499,trousersPrice=650,sneakersPrice=1300;
    private JTextField pay;
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private int shirtCount = 0, trousersCount = 0, sneakersCount = 0;
    private static Member member=(Member)Tool.read("member.txt");
	private static PorderServiceImpl porderserviceimpl=new PorderServiceImpl();
	private JTextField textField;
	

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
        panel.setBounds(10, 66, 100, 277);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("襯衫");
        lblNewLabel.setBounds(18, 59, 31, 18);
        lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 15));
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("長褲");
        lblNewLabel_1.setBounds(18, 95, 31, 18);
        lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 15));
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("球鞋");
        lblNewLabel_2.setBounds(18, 133, 31, 18);
        lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 15));
        panel.add(lblNewLabel_2);

        // Initialize the spinners correctly
        shirtSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        shirtSpinner.setBounds(56, 55, 35, 26);
        panel.add(shirtSpinner);

        trousersSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        trousersSpinner.setBounds(56, 90, 35, 26);
        panel.add(trousersSpinner);

        sneakersSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sneakersSpinner.setBounds(56, 127, 35, 26);
        panel.add(sneakersSpinner);
        
        JLabel lblNewLabel_4 = new JLabel(member.getName()+"您好");
        lblNewLabel_4.setBounds(10, 10, 90, 25);
        panel.add(lblNewLabel_4);
        
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
        btnNewButton_1.setBounds(10, 186, 85, 23);
        panel.add(btnNewButton_1);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(250, 143, 168));
        panel_1.setBounds(113, 66, 313, 277);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        // Initialize resultArea properly
        output_1 = new JTextArea();
        output_1.setBounds(10, 43, 161, 145);
        panel_1.add(output_1);
        output_1.setEditable(false);
        
        JLabel lblNewLabel_3 = new JLabel("購買明細");
        lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 16));
        lblNewLabel_3.setBounds(23, 20, 80, 23);
        panel_1.add(lblNewLabel_3);
        
        JLabel lblNewLabel_2_1 = new JLabel("支付金額");
        lblNewLabel_2_1.setFont(new Font("新細明體", Font.BOLD, 15));
        lblNewLabel_2_1.setBounds(29, 201, 72, 24);
        panel_1.add(lblNewLabel_2_1);
        
        pay = new JTextField();
        pay.setColumns(10);
        pay.setBounds(100, 200, 87, 21);
        panel_1.add(pay);
        
       
        
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
        btnNewButton_2.setBounds(53, 236, 85, 23);
        panel_1.add(btnNewButton_2);
        
        
        
        JTextArea payback = new JTextArea();
        payback.setBounds(179, 43, 124, 145);
        panel_1.add(payback);
        payback.setEditable(false);
        
        JButton backButton = new JButton("確認支付");
        backButton.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {

				String Pay = pay.getText();	
				Integer PY = new Integer(Pay);
                                
				shirtCount = (int) shirtSpinner.getValue();
				trousersCount = (int) trousersSpinner.getValue();
				sneakersCount = (int) sneakersSpinner.getValue();	
				
		        int shirtTotal = shirtCount * shirtPrice;
		        int trousersTotal = trousersCount * trousersPrice;
		        int sneakersTotal = sneakersCount * sneakersPrice;
		        int total = shirtTotal + trousersTotal + sneakersTotal;				
				int change=PY-total;

	
                if(shirtCount>=0 && trousersCount>=0 && sneakersCount>=0 )
                {
                	if(change >0)
                	{
                		payback.setText(
	                			"您支付:"+PY+"元"+
	                			"\n需找您:"+change+"元"+
	                			"\n1000元:"+change/1000+"張"+
	                			"\n100元:"+change%1000/100+"張"+
	                			"\n10元:"+change%1000%100/10+"個"+
	                			"\n1元:"+change%1000%100%10+"個"
	                			);
                	}
                	else if(change==0)
                	{
                		payback.setText(
	                			"您支付:"+PY+"元"+
                				"\n金額剛好,無須找零,感謝您");
                	}
                	else if(change<0)
                	{
                		payback.setText(
	                			"您支付:"+PY+"元"+
                				"\n您支付的金額不足喔!");
                	}
                }
        	}
        });
        backButton.setFont(new Font("新細明體", Font.BOLD, 13));
        backButton.setBounds(192, 199, 91, 23);
        panel_1.add(backButton);
        
        JButton btnNewButton_5 = new JButton("完成交易");
        btnNewButton_5.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		String Name=member.getName();				
				int Shirt = (int) shirtSpinner.getValue();
				int Trousers = (int) trousersSpinner.getValue();
				int Sneakers = (int) sneakersSpinner.getValue();

				if(Shirt==0 && Trousers==0 && Sneakers==0) {
					
					JOptionPane.showMessageDialog(null, "請先購買商品");
				}
				else {
					Porder p=new Porder(Name,Shirt,Trousers,Sneakers);
					porderserviceimpl.addPorder(p);
					JOptionPane.showMessageDialog(null, "完成交易,已存入管理訂單");
				}
	
        		
        	}
        });
        btnNewButton_5.setFont(new Font("新細明體", Font.BOLD, 15));
        btnNewButton_5.setBounds(166, 236, 103, 23);
        panel_1.add(btnNewButton_5);
        
        JLabel lblNewLabel_3_1 = new JLabel("找零");
        lblNewLabel_3_1.setFont(new Font("新細明體", Font.BOLD, 16));
        lblNewLabel_3_1.setBounds(186, 20, 80, 23);
        panel_1.add(lblNewLabel_3_1);
        
        
        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(250, 143, 168));
        panel_2.setBounds(10, 10, 416, 51);
        contentPane.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel_5 = new JLabel("新增訂單");
        lblNewLabel_5.setBounds(159, 10, 86, 26);
        lblNewLabel_5.setForeground(Color.WHITE);
        lblNewLabel_5.setFont(new Font("新細明體", Font.BOLD, 21));
        panel_2.add(lblNewLabel_5);
        
        JLabel clock = new JLabel("2025-02-13 11:15:56");
        clock.setFont(new Font("新細明體", Font.BOLD, 14));
        clock.setBounds(287, 32, 129, 19);
        panel_2.add(clock);
        Timer timer = new Timer(1000, e -> updateDateTime(clock));
        
        JButton btnNewButton_3_1 = new JButton("上一頁");
        btnNewButton_3_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
        		PorderMainUI porderMainUI=new PorderMainUI();
				porderMainUI.setVisible(true);
				dispose();
        	}
        });
        btnNewButton_3_1.setFont(new Font("新細明體", Font.BOLD, 15));
        btnNewButton_3_1.setBounds(5, 5, 85, 23);
        panel_2.add(btnNewButton_3_1);
		timer.start();
                       
        shirtSpinner.addChangeListener(e -> updateTotal());
        trousersSpinner.addChangeListener(e -> updateTotal());
        sneakersSpinner.addChangeListener(e -> updateTotal());
                                
    }
    	
	private Object updateDateTime(JLabel clock) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentDateTime=sdf.format(new Date());
		clock.setText(currentDateTime);
		return null;
	}

	private void updateTotal() {
    	//String Name=member.getName();
		shirtCount = (int) shirtSpinner.getValue();
		trousersCount = (int) trousersSpinner.getValue();
		sneakersCount = (int) sneakersSpinner.getValue();	
		
        int shirtTotal = shirtCount * shirtPrice;
        int trousersTotal = trousersCount * trousersPrice;
        int sneakersTotal = sneakersCount * sneakersPrice;
        int total = shirtTotal + trousersTotal + sneakersTotal;
        
        output_1.setText(member.getName()+"葛來美感謝您的購買:"+
    			"\n------------------------------------------------------"+
    			"\n襯衫499元"+shirtCount+"件"+"="+shirtTotal+"元"+ 
    			"\n長褲650元"+trousersCount+"件"+"="+trousersTotal+"元"+
    			"\n球鞋1300元"+sneakersCount +"雙"+"="+sneakersTotal+"元"+
    			"\n交易金額:"+total+"元");
    }
}
