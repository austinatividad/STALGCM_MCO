package View;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

import Inputs.*;
import Machine.*;

public class View {
    //List of Colors
    static Color mainWindow = new Color(217,217,217);
    static Color componentColor = new Color(255,255,255);
    static Color textBackgroundColor = new Color(217,217,217);
    static Color stackComponentColor = new Color(255,249,193);
    static Color transitionComponentColor = new Color(239,239,239);
    static Color transitionHighlightedColor = new Color(226,255,252);
    static Color transitionCurrentColor = new Color(255, 226, 250);
    static Color acceptColor = new Color(000,255,000);
    static Color rejectColor = new Color(255, 000, 000);

    private int ctr = 0;

    //JFrame Components
    static JFrame frame = new JFrame("2-Stack Pushdown Automata");

    //JPanels
    static JPanel mainPanel = new JPanel();
    static JPanel tapePanel = new JPanel();
    static JPanel automataPanel = new JPanel();

    static JPanel statusPanel = new JPanel();
    static JPanel stack0Panel = new JPanel();
    static JPanel stack1Panel = new JPanel();
    static JButton stepButton = new JButton("NEXT STEP");
    static JFrame transitionWindow = new JFrame("Transition List");
    static JPanel stepCountPanel = new JPanel();
    static JPanel tapeIndexPanel = new JPanel();
    static JPanel transitionLogPanel = new JPanel();


    ArrayList<JPanel> transitionPanels = new ArrayList<>();
    ArrayList<JLabel> transitionLabels = new ArrayList<>();

    //Machine Object
    public Machine machine = null;

    //JLabels
    JLabel tapeLabel = new JLabel();
    JLabel statusLabel = new JLabel();
    JLabel stack0Label = new JLabel();
    JLabel stack1Label = new JLabel();
    JLabel automataLabel = new JLabel();
    JLabel transitionLabel = new JLabel();
    JLabel stepCountLabel = new JLabel();

    JLabel tapeIndexLabel = new JLabel();

    JLabel transitionLogLabel = new JLabel();



    public View(Machine machine) {
        this.machine = machine;
        initializeComponents();



    }


    private void initializeComponents(){
        createMainWindow();
        createMainPanel();
        createTapePanel();
        createAutomataPanel();
        createStatusPanel();
        createStack0Panel();
        createStack1Panel();
        createStepButton();
        createTransitionPanel();
        createStepCountPanel();
        createTapeIndexPanel();
        createTransitionLogPanel();

        createJLabels();
        createTransitions(machine.getTransitions());


        frame.revalidate();
        frame.repaint();

        transitionWindow.revalidate();
        transitionWindow.repaint();
    }

    private void createMainWindow(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(920, 390);
        frame.getContentPane().setBackground(mainWindow);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    private void createMainPanel(){
        mainPanel.setSize(488,306);
        mainPanel.setBackground(componentColor);
        mainPanel.setLocation(24, 24);

        mainPanel.setLayout(null);
        frame.add(mainPanel);
        mainPanel.setVisible(true);
    }

    private void createTapePanel(){
        tapePanel.setSize(469, 31);
        tapePanel.setBackground(textBackgroundColor);
        tapePanel.setLocation(10,10);
        tapePanel.setLayout(null);
        mainPanel.add(tapePanel);
        tapePanel.setVisible(true);
    }

    private void createAutomataPanel(){
        automataPanel.setSize(379, 184);
        automataPanel.setBackground(textBackgroundColor);
        automataPanel.setLocation(56, 60);
        automataPanel.setLayout(null);
        mainPanel.add(automataPanel);
        automataPanel.setVisible(true);
    }

    private void createStatusPanel(){
        statusPanel.setSize(233, 32);
        statusPanel.setBackground(textBackgroundColor);
        statusPanel.setLocation(129, 260);
        statusPanel.setLayout(null);
        mainPanel.add(statusPanel);
        statusPanel.setVisible(true);
    }

    private void createStack0Panel(){
        stack0Panel.setSize(354,40);
        stack0Panel.setBackground(stackComponentColor);
        stack0Panel.setLocation(530, 24);
        stack0Panel.setLayout(null);
        frame.add(stack0Panel);
        stack0Panel.setVisible(true);
    }

    private void createStack1Panel(){
        stack1Panel.setSize(354,40);
        stack1Panel.setBackground(stackComponentColor);
        stack1Panel.setLocation(530, 74);
        stack1Panel.setLayout(null);
        frame.add(stack1Panel);
        stack1Panel.setVisible(true);
    }

    private void createStepButton(){
        stepButton.setLocation(530, 285);
        stepButton.setSize(354, 32);
        stepButton.setBackground(componentColor);
        stepButton.setLayout(null);
        frame.add(stepButton);
        stepButton.setVisible(true);

        stepButton.addActionListener(e -> {
            try {
                machine.stepSim();
            } catch(Error err) {
                JOptionPane.showMessageDialog(frame, "Simulation has Ended. String Rejected.");
                stepButton.setEnabled(false);
            }
            try {
                updateView();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Simulation has Ended. String Rejected.");
                stepButton.setEnabled(false);
            }

            if(machine.getIsAccepted() == "Accepted") {
                JOptionPane.showMessageDialog(frame, "Simulation has Ended. String Accepted.");
                stepButton.setText("Restart Software to Simulate Again");
                stepButton.setEnabled(false);
            }

        });
    }

    private void createTransitionPanel(){
        FlowLayout layout = new FlowLayout();
        layout.setHgap(10);
        layout.setVgap(10);
        transitionWindow.setSize(280, 390);
        transitionWindow.getContentPane().setBackground(mainWindow);
        transitionWindow.setLayout(layout);
        transitionWindow.setLocation(frame.getX() + frame.getWidth(), frame.getY());
        transitionWindow.setVisible(true);

    }

    private void createStepCountPanel(){
        stepCountPanel.setSize(160, 26);
        stepCountPanel.setBackground(componentColor);
        stepCountPanel.setLocation(530, 123);
        stepCountPanel.setLayout(null);
        frame.add(stepCountPanel);
        stepCountPanel.setVisible(true);

        stepCountLabel.setText("Step Count: " + machine.getStepCount());
        stepCountLabel.setHorizontalAlignment(JLabel.CENTER);
        stepCountLabel.setLocation(0, 3);
        stepCountPanel.add(stepCountLabel);
        stepCountLabel.setSize(160, 20);
        stepCountLabel.setVisible(true);

    }

    private void createTapeIndexPanel(){
        tapeIndexPanel.setSize(160, 26);
        tapeIndexPanel.setBackground(componentColor);
        tapeIndexPanel.setLocation(724, 123);
        tapeIndexPanel.setLayout(null);
        frame.add(tapeIndexPanel);
        tapeIndexPanel.setVisible(true);

        tapeIndexLabel.setText(machine.getTape().currentIndex());
        tapeIndexLabel.setHorizontalAlignment(JLabel.CENTER);
        tapeIndexLabel.setLocation(0, 3);
        tapeIndexPanel.add(tapeIndexLabel);
        tapeIndexLabel.setSize(160, 20);
        tapeIndexLabel.setVisible(true);


    }

    private void createTransitionLogPanel(){

        stepButton.setLocation(530, 285);
        stepButton.setSize(354, 32);


        transitionLogPanel.setSize(354, 110);
        transitionLogPanel.setBackground(componentColor);
        transitionLogPanel.setLocation(530, 160);
        transitionLogPanel.setLayout(null);
        frame.add(transitionLogPanel);
        transitionLogPanel.setVisible(true);

        transitionLogLabel.setLocation(5, 0);
        transitionLogPanel.add(transitionLogLabel);
        transitionLogLabel.setSize(349, 110);
        transitionLogLabel.setVisible(true);
    }

    private void createJLabels(){
        tapeLabel.setText(machine.getTape().toString());
        tapeLabel.setLocation(5, 5);
        tapePanel.add(tapeLabel);
        tapeLabel.setSize(460, 20);
        tapeLabel.setVisible(true);

        //TODO: FIX AND SET STRING TO ACTUAL PASSED CURRENT STATE BY MACHINE OBJECT
        automataLabel.setText("<html>" +
                "<body style=''>" +
                "<center>" +
                "Make sure that /inputs/testing.txt is <br>" +
                "already set to your formal definition.<br><br>" +
                "Please refer to README.md for " +
                "the formal definition.<br><br>" +
                "Click NEXT STEP to start the simulation." +
                "</center>" +
                "</body>" +
                "</html>");
        automataLabel.setHorizontalAlignment(JLabel.CENTER);
        automataLabel.setLocation(5, 40);
        automataPanel.add(automataLabel);
        automataLabel.setSize(370, 100);
        automataLabel.setVisible(true);


        statusLabel.setText("Status: " + machine.getIsAccepted());
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusLabel.setLocation(5, 5);
        statusPanel.add(statusLabel);
        statusLabel.setSize(220, 20);
        statusLabel.setVisible(true);

        stack0Label.setText("Stack 0: " + machine.getStack(0).toString());
        stack0Label.setLocation(5, 8);
        stack0Panel.add(stack0Label);
        stack0Label.setSize(350, 20);
        stack0Label.setVisible(true);

        stack1Label.setText("Stack 1: " + machine.getStack(1).toString());
        stack1Label.setLocation(5, 8);
        stack1Panel.add(stack1Label);
        stack1Label.setSize(350, 20);
        stack1Label.setVisible(true);
    }

    private void createTransitions(ArrayList<Transition> transitions){
        for (int i=0;i<transitions.size(); i ++){
            transitionPanels.add(new JPanel());
            transitionPanels.get(i).setSize(200, 30);
            transitionPanels.get(i).setPreferredSize(new Dimension(200, 30));
            transitionPanels.get(i).setBackground(transitionComponentColor);
            transitionWindow.add(transitionPanels.get(i));

            transitionLabels.add(new JLabel(transitions.get(i).toString()));
            transitionLabels.get(i).setLocation(5, 5);

            transitionPanels.get(i).add(transitionLabels.get(i));

        }
    }

    private void updateView(){
        System.out.println("TransitionLog: ");
        System.out.println(machine.getTransitionLog());
        System.out.println("update all texts");
        tapeLabel.setText(machine.getTape().toString());

        statusLabel.setText("Status: " + machine.getIsAccepted());
        //testing
        //statusLabel.setText("Status: Accepted");
        checkStatus();

        stack0Label.setText("Stack 0: " + machine.getStack(0).toString());

        //testing
        //stack0Label.setText("Stack 0: XXXXXXZ");
        stack1Label.setText("Stack 1: " + machine.getStack(1).toString());
        //testing
        //stack1Label.setText("Stack 1: XXXXXXZ");

        stepCountLabel.setText("Step Count: " + machine.getStepCount());
        automataLabel.setText(machine.getCurrentState());

        tapeIndexLabel.setText(machine.getTape().currentIndex());

        transitionLogLabel.setText(
                "<html>"+
                        "<body style='width:auto'>"+
                        machine.getTransitionLog()+
                        "</body>"+
                "</html>"
        );

        highlightTransitions();
        checkstate();

    }

    private void checkStatus(){
        if(Objects.equals(statusLabel.getText(), "Status: Rejected")) {
            statusPanel.setBackground(rejectColor);
        } else {
            statusPanel.setBackground(acceptColor);
        }
    }

    private void highlightTransitions(){
        ArrayList<String> cur_transitions;
        cur_transitions = machine.getStateStackTransitions();

        for (int i=0;i<transitionPanels.size(); i ++){
            if (cur_transitions.contains(transitionLabels.get(i).getText())){
                transitionPanels.get(i).setBackground(transitionHighlightedColor);
            } else {
                transitionPanels.get(i).setBackground(transitionComponentColor);
            }
        }

        Transition current_transition = machine.getStateStacks().getStack().transition;
        System.out.println(current_transition.toString());

        for (int i=0;i<transitionPanels.size(); i ++){
            if (current_transition.toString().equals(transitionLabels.get(i).getText())){
                transitionPanels.get(i).setBackground(transitionCurrentColor);
            }
        }

        }

    private void checkstate(){
        if (automataLabel.getText().contains("Initial")) {
            automataLabel.setForeground(Color.CYAN.darker());
        } else if (automataLabel.getText().contains("Final")) {
            if(machine.getIsAccepted() == "Accepted"){
                automataLabel.setForeground(acceptColor.darker());
            } else {
                automataLabel.setForeground(rejectColor.darker());
            }

        } else {
            automataLabel.setForeground(Color.black);
        }
    }

}
