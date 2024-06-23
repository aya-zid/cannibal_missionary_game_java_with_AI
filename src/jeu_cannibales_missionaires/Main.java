package jeu_cannibales_missionaires;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JButton goButton1can;
    private JButton goButton2can;
    private JButton goButton1can1miss;
    private JButton goButton1miss;
    private JButton goButton2miss;
    private JButton backButton1can;
    private JButton backButton1miss;
    private JButton backButton1can1miss;
    private JButton backButton2can;
    private JButton backButton2miss;
    private JButton solution;
    private JButton rules;
    private JPanel squarePanel;
    private int Poscan1=700,Poscan2=700,Poscan3=700,Posmiss1=700,Posmiss2=700,Posmiss3=700;
    private final int can1Y = 200, can2Y = 250, can3Y = 300, miss1Y = 400, miss2Y = 450, miss3Y = 500;
    private Ferme ferme;
    private Ouvert ouvert;
    private Operation[] operations;
    private Etat etat;
    private AGR agr;
    private Etat sol;
    private DepartUnCan go1can;
    private DepartDeuxCan go2can;
    private DepartUnCanUnMiss go1can1miss;
    private DepartUnMiss go1miss;
    private DepartDeuxMiss go2miss; 
    private RetourDeuxCan back2can;
    private RetourDeuxMiss back2miss;
    private RetourUnCanib back1can;
    private RetourUnMiss back1miss;
    private RetourUnCanUnMiss back1can1miss;
    private JLabel messageLabel;
  
    
    public Main() {
        setTitle("Move Square");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        messageLabel= new JLabel("3 Cannibals (red) ,3 Missionaries (blue), Boat is in right side ", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Serif", Font.BOLD, 16));
        messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        // Create buttons
        goButton1can = new JButton("move 1 canibal to left");
        goButton2can = new JButton("move 2 canibals to left");
        goButton1can1miss = new JButton("move 1 canibal 1 missionary to left");
        goButton1miss = new JButton("move 1 missionary to left");
        goButton2miss = new JButton("move 2 missionaries to left");
        backButton1can = new JButton("move 1 cannibal to right");
        backButton2can = new JButton("move 2 cannibals to right");
        backButton1can1miss = new JButton("move 1 cannibal 1 missionary to right");
        backButton1miss = new JButton("move 1 missionary to right");
        backButton2miss = new JButton("move 2 missionaries to right");
        solution = new JButton("solution");
        rules = new JButton("game rules");
        goButton1can.addActionListener(this);
        goButton2can.addActionListener(this);
        goButton1can1miss.addActionListener(this);
        goButton1miss.addActionListener(this);
        goButton2miss.addActionListener(this);
        backButton1can.addActionListener(this);
        backButton1miss.addActionListener(this);
        backButton1can1miss.addActionListener(this);
        backButton2can.addActionListener(this);
        backButton2miss.addActionListener(this);
        solution.addActionListener(this);
        rules.addActionListener(this);
        // Create panel for the square
        squarePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillRect(Poscan1, can1Y, 30, 30); // square size is 50x50
                g.fillRect(Poscan2, can2Y, 30, 30);
                g.fillRect(Poscan3, can3Y, 30, 30);
                g.setColor(Color.BLUE);
                g.fillRect(Posmiss1, miss1Y, 30, 30);
                g.fillRect(Posmiss2, miss2Y, 30, 30);
                g.fillRect(Posmiss3, miss3Y, 30, 30);
            }
        };
        
        // Set layout for the square panel
        squarePanel.setLayout(new BoxLayout(squarePanel, BoxLayout.Y_AXIS));

        // Add buttons to the square panel
        squarePanel.add(goButton1can);
        squarePanel.add(goButton2can);
        squarePanel.add(goButton1can1miss);
        squarePanel.add(goButton1miss);
        squarePanel.add(goButton2miss);
        squarePanel.add(backButton1can);
        squarePanel.add(backButton2can);
        squarePanel.add(backButton1can1miss);
        squarePanel.add(backButton1miss);
        squarePanel.add(backButton2miss);
        squarePanel.add(solution);
        squarePanel.add(rules);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(messageLabel, BorderLayout.NORTH);
        getContentPane().add(squarePanel, BorderLayout.CENTER);

        setVisible(true);
        go1can=new DepartUnCan();
        go2can= new DepartDeuxCan();
        go1can1miss= new DepartUnCanUnMiss();
        go1miss=new DepartUnMiss();
        go2miss = new DepartDeuxMiss();
        back2can = new RetourDeuxCan();
        back2miss= new RetourDeuxMiss ();
        back1can = new RetourUnCanib();
        back1miss = new RetourUnMiss ();
        back1can1miss = new RetourUnCanUnMiss ();
        ferme=new ListeLineaire();
        ouvert=new Fifo();
        etat=new Etat_can_miss(3,3,true);
        operations=new Operation[10];
        operations[0]=go1can;
        operations[1]=go2can;
        operations[2]=go1can1miss;
        operations[3]=go1miss;
        operations[4]=go2miss;
        operations[5]=back2can;
        operations[6]= back2miss;
        operations[7]= back1can;
        operations[8]=back1miss;
        operations[9]=back1can1miss;
        agr=new AGR(etat,ferme,ouvert,operations);
        sol=agr.explorer();
      //  System.out.println(sol);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	go1can=new DepartUnCan();go2can= new DepartDeuxCan();go1can1miss= new DepartUnCanUnMiss();go1miss=new DepartUnMiss();go2miss = new DepartDeuxMiss();back2can = new RetourDeuxCan();back2miss= new RetourDeuxMiss ();back1can = new RetourUnCanib();back1miss = new RetourUnMiss ();back1can1miss = new RetourUnCanUnMiss ();
        ferme=new ListeLineaire();ouvert=new Fifo();
        operations=new Operation[10];operations[0]=go1can;operations[1]=go2can;operations[2]=go1can1miss;operations[3]=go1miss;operations[4]=go2miss;operations[5]=back2can;operations[6]= back2miss;operations[7]= back1can;operations[8]=back1miss;operations[9]=back1can1miss;
    	Etat_can_miss newetat;
    	String tellthem;
       if (e.getSource() == goButton1can) {
         newetat=(Etat_can_miss)go1can.Action(etat);
         if(newetat!=null) {
        	 
        	 if(newetat.isBateau())
        	 tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the right side";
        	 else tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the left side";
        	 messageLabel.setText(tellthem);
        	 etat=new Etat_can_miss (newetat.getNb_miss(),newetat.getNb_can(),newetat.isBateau());
        	 agr=new AGR(etat,ferme,ouvert,operations);
        	 sol=agr.explorer();
        	 if(Poscan1==700) { Poscan1=300;}
        	 else if (Poscan2==700)Poscan2=300;
        	 else Poscan3=300;
         } else
           showMessage("Impossible move");
       }
       if (e.getSource() == goButton2can) {
           newetat=(Etat_can_miss)go2can.Action(etat);
           if(newetat!=null) {
        	   if(newetat.isBateau())
        		   tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the right side";
          	 else tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the left side";
              	 messageLabel.setText(tellthem);
          	 etat=new Etat_can_miss (newetat.getNb_miss(),newetat.getNb_can(),newetat.isBateau());
          	 agr=new AGR(etat,ferme,ouvert,operations);
          	 sol=agr.explorer();
          	 if(Poscan1==700 && Poscan2==700) { Poscan1=300;Poscan2=300;}
          	 else if (Poscan1==700 && Poscan3==700){ Poscan1=300;Poscan3=300;}
          	 else {Poscan2=300;Poscan3=300;}
           } else
             showMessage("Impossible move");
         }
       if (e.getSource() == goButton1can1miss) {
           newetat=(Etat_can_miss)go1can1miss.Action(etat);
           if(newetat!=null) {
        	   if(newetat.isBateau())
        		   tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the right side";
          	 else tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the left side";
              	 messageLabel.setText(tellthem);
          	 etat=new Etat_can_miss (newetat.getNb_miss(),newetat.getNb_can(),newetat.isBateau());
          	 agr=new AGR(etat,ferme,ouvert,operations);
          	 sol=agr.explorer();
          	 if(Poscan1==700 && Posmiss1==700) { Poscan1=300;Posmiss1=300;}
          	 else if (Poscan1==700 && Posmiss2==700){ Poscan1=300;Posmiss2=300;}
          	 else if (Poscan1==700 && Posmiss3==700){ Poscan1=300;Posmiss3=300;}
          	 else if (Poscan2==700 && Posmiss1==700){ Poscan2=300;Posmiss1=300;}
          	 else if (Poscan2==700 && Posmiss2==700){ Poscan2=300;Posmiss2=300;}
          	 else if (Poscan2==700 && Posmiss3==700){ Poscan2=300;Posmiss3=300;}
          	 else if (Poscan3==700 && Posmiss1==700){ Poscan3=300;Posmiss1=300;}
          	 else if (Poscan3==700 && Posmiss2==700){ Poscan3=300;Posmiss2=300;}
          	 else {Poscan3=300;Posmiss3=300;}
           } else
             showMessage("Impossible move");
         }
       if (e.getSource() == goButton1miss) {
           newetat=(Etat_can_miss)go1miss.Action(etat);
           if(newetat!=null) {
        	   if(newetat.isBateau())
        		   tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the right side";
          	 else tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the left side";
              	 messageLabel.setText(tellthem);
          	 etat=new Etat_can_miss (newetat.getNb_miss(),newetat.getNb_can(),newetat.isBateau());
          	 agr=new AGR(etat,ferme,ouvert,operations);
          	 sol=agr.explorer();
          	 if(Posmiss1==700) { Posmiss1=300;}
          	 else if (Posmiss2==700)Posmiss2=300;
          	 else Posmiss3=300;
           } else
             showMessage("Impossible move");
         }
         if (e.getSource() == goButton2miss) {
             newetat=(Etat_can_miss)go2miss.Action(etat);
             if(newetat!=null) {
            	 if(newetat.isBateau())
            		 tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the right side";
            	 else tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the left side";
                	 messageLabel.setText(tellthem);
            	 etat=new Etat_can_miss (newetat.getNb_miss(),newetat.getNb_can(),newetat.isBateau());
            	 agr=new AGR(etat,ferme,ouvert,operations);
            	 sol=agr.explorer();
            	 if(Posmiss1==700 && Posmiss2==700) { Posmiss1=300;Posmiss2=300;}
            	 else if (Posmiss1==700 && Posmiss3==700){ Posmiss1=300;Posmiss3=300;}
            	 else {Posmiss2=300;Posmiss3=300;}
             } else
               showMessage("Impossible move");
           }
         if (e.getSource() == backButton1can) {
             newetat=(Etat_can_miss)back1can.Action(etat);
             if(newetat!=null) {
            	 if(newetat.isBateau())
            		 tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the right side";
            	 else tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the left side";
                	 messageLabel.setText(tellthem);
            	 etat=new Etat_can_miss (newetat.getNb_miss(),newetat.getNb_can(),newetat.isBateau());
            	 agr=new AGR(etat,ferme,ouvert,operations);
            	 sol=agr.explorer();
            	 if(Poscan1==300) { Poscan1=700;}
            	 else if (Poscan2==300)Poscan2=700;
            	 else Poscan3=700;
             } else
               showMessage("Impossible move");
           }
           if (e.getSource() == backButton2can) {
               newetat=(Etat_can_miss)back2can.Action(etat);
               if(newetat!=null) {
            	   if(newetat.isBateau())
            		   tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the right side";
              	 else tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the left side";
                  	 messageLabel.setText(tellthem);
              	 etat=new Etat_can_miss (newetat.getNb_miss(),newetat.getNb_can(),newetat.isBateau());
              	 agr=new AGR(etat,ferme,ouvert,operations);
              	 sol=agr.explorer();
              	 if(Poscan1==300 && Poscan2==300) { Poscan1=700;Poscan2=700;}
              	 else if (Poscan1==300 && Poscan3==300){ Poscan1=700;Poscan3=700;}
              	 else {Poscan2=700;Poscan3=700;}
               } else
                 showMessage("Impossible move");
             }
           if (e.getSource() == backButton1can1miss) {
               newetat=(Etat_can_miss)back1can1miss.Action(etat);
               if(newetat!=null) {
            	   if(newetat.isBateau())
            		   tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the right side";
              	 else tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the left side";
                  	 messageLabel.setText(tellthem);
              	 etat=new Etat_can_miss (newetat.getNb_miss(),newetat.getNb_can(),newetat.isBateau());
              	 agr=new AGR(etat,ferme,ouvert,operations);
              	 sol=agr.explorer();
              	 if(Poscan1==300 && Posmiss1==300) { Poscan1=700;Posmiss1=700;}
              	 else if (Poscan1==300 && Posmiss2==300){ Poscan1=700;Posmiss2=700;}
              	 else if (Poscan1==300 && Posmiss3==300){ Poscan1=700;Posmiss3=700;}
              	 else if (Poscan2==300 && Posmiss1==300){ Poscan2=700;Posmiss1=700;}
              	 else if (Poscan2==300 && Posmiss2==300){ Poscan2=700;Posmiss2=700;}
              	 else if (Poscan2==300 && Posmiss3==300){ Poscan2=700;Posmiss3=700;}
              	 else if (Poscan3==300 && Posmiss1==300){ Poscan3=700;Posmiss1=700;}
              	 else if (Poscan3==300 && Posmiss2==300){ Poscan3=700;Posmiss2=700;}
              	 else {Poscan3=700;Posmiss3=700;}
               } else
                 showMessage("Impossible move");
             }
           if (e.getSource() == backButton1miss) {
               newetat=(Etat_can_miss)back1miss.Action(etat);
               if(newetat!=null) {
            	   if(newetat.isBateau())
            		   tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the right side";
              	 else tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the left side";
                  	 messageLabel.setText(tellthem);
              	 etat=new Etat_can_miss (newetat.getNb_miss(),newetat.getNb_can(),newetat.isBateau());
              	 agr=new AGR(etat,ferme,ouvert,operations);
              	 sol=agr.explorer();
              	 if(Posmiss1==300) { Posmiss1=700;}
              	 else if (Posmiss2==300)Posmiss2=700;
              	 else Posmiss3=700;
               } else
                 showMessage("Impossible move");
             }
             if (e.getSource() == backButton2miss) {
                 newetat=(Etat_can_miss)back2miss.Action(etat);
                 if(newetat!=null) {
                	 if(newetat.isBateau())
                		 tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the right side";
                	 else tellthem=newetat.getNb_can() + " Cannibals (red) ,"+ newetat.getNb_miss()+" Missionaries (blue), Boat is in the left side";
                    	 messageLabel.setText(tellthem);
                	 etat=new Etat_can_miss (newetat.getNb_miss(),newetat.getNb_can(),newetat.isBateau());
                	 agr=new AGR(etat,ferme,ouvert,operations);
                	 sol=agr.explorer();
                	 if(Posmiss1==300 && Posmiss2==300) { Posmiss1=700;Posmiss2=700;}
                	 else if (Posmiss1==300 && Posmiss3==300){ Posmiss1=700;Posmiss3=700;}
                	 else {Posmiss2=700;Posmiss3=700;}
                 } else
                   showMessage("Impossible move");
               }
       
         else if(e.getSource()==solution) 
         {
             if(sol!=null)
            	 showMessage("Solution path: " + agr.chemin(sol));
             else
            	 showMessage("no solution");
        	
         } 
         else if(e.getSource()==rules) 
         {
            	 showMessage("game mission : move all the cannibals and missionaries to the left side \n rules : \n - the number of c"
            	 		+ "annibals in each side should be less or equal to the number of missionaries \n - if the boat is in the right side u can only move individuals to the left side "
            	 		+ "\n - if the boat is in the left side u can only move individuals to the right side"
            	 		+ "\n - if u try otherwise u will get an impossible move error"
            	 		+ "\n - if u try a move that makes the number of missionaries less than the number of cannibals u will get an impossible move error "
            	 		+ "\n - if u need help click the solution button");
        	
         } 
        if( etat.equals(new Etat_can_miss(0,0,false)))
        { tellthem= "congrats u won";
            	 messageLabel.setText(tellthem);}
        // else {System.out.println("else");}
      
        squarePanel.repaint();
    }

    private void showMessage(String message) {
      
    	 JFrame messageFrame = new JFrame("Message");
         
         // Wrap the message in HTML tags to enable multiline display
         String htmlMessage = "<html><body style='width: 250px'>" + message.replaceAll("\n", "<br>") + "</body></html>";
         
         JLabel messageLabel = new JLabel(htmlMessage);
         messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
         
         // Optional: Add padding around the text
         messageLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
         
         messageFrame.getContentPane().add(new JScrollPane(messageLabel)); // Use JScrollPane for better handling of long messages
         
         messageFrame.setSize(400, 300); // Increase the size for better readability
         messageFrame.setLocationRelativeTo(null); // Center the frame on screen
        // messageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ensure the frame closes properly
         messageFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
