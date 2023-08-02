package View;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

    ArrayList<JPanel> transitionPanels = new ArrayList<>();
    ArrayList<JLabel> transitionLabels = new ArrayList<>();

    //Machine Object
    Machine machine = null;

    //JLabels
    JLabel tapeLabel = new JLabel();
    JLabel statusLabel = new JLabel();
    JLabel stack0Label = new JLabel();
    JLabel stack1Label = new JLabel();
    JLabel automataLabel = new JLabel();
    JLabel transitionLabel = new JLabel();

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

        createJLabels();
        createTransitions(machine.getTransitions());
    }

    private void createMainWindow(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(920, 420);
        frame.getContentPane().setBackground(mainWindow);
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
        stack0Panel.setSize(354,70);
        stack0Panel.setBackground(stackComponentColor);
        stack0Panel.setLocation(530, 24);
        stack0Panel.setLayout(null);
        frame.add(stack0Panel);
        stack0Panel.setVisible(true);
    }

    private void createStack1Panel(){
        stack1Panel.setSize(354,70);
        stack1Panel.setBackground(stackComponentColor);
        stack1Panel.setLocation(530, 115);
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
            System.out.println("------------------");
            System.out.println("Button Presses: " + ++ctr + "\n");
            machine.stepSim(); //TODO: FIX THIS
            updateView();
        });
    }

    private void createTransitionPanel(){
        FlowLayout layout = new FlowLayout();
        layout.setHgap(10);
        layout.setVgap(10);
        transitionWindow.setSize(400, 420);
        transitionWindow.setBackground(textBackgroundColor);
        transitionWindow.setLayout(layout);
        transitionWindow.setVisible(true);

    }

    private void createJLabels(){
        tapeLabel.setText(machine.getTape().toString());
        tapeLabel.setLocation(5, 5);
        tapePanel.add(tapeLabel);
        tapeLabel.setSize(460, 20);
        tapeLabel.setVisible(true);

        //TODO: FIX AND SET STRING TO ACTUAL PASSED CURRENT STATE BY MACHINE OBJECT
        automataLabel.setText("Current State: A");
        automataLabel.setHorizontalAlignment(JLabel.CENTER);
        automataLabel.setLocation(5, 80);
        automataPanel.add(automataLabel);
        automataLabel.setSize(370, 20);
        automataLabel.setVisible(true);


        statusLabel.setText("Status: " + machine.getIsAccepted());
        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusLabel.setLocation(5, 5);
        statusPanel.add(statusLabel);
        statusLabel.setSize(220, 20);
        statusLabel.setVisible(true);

        stack0Label.setText("Stack 0: " + machine.getStack(0).toString());
        stack0Label.setLocation(5, 5);
        stack0Panel.add(stack0Label);
        stack0Label.setSize(350, 20);
        stack0Label.setVisible(true);

        stack1Label.setText("Stack 1: " + machine.getStack(1).toString());
        stack1Label.setLocation(5, 5);
        stack1Panel.add(stack1Label);
        stack1Label.setSize(350, 20);
        stack1Label.setVisible(true);
    }

    private void createTransitions(ArrayList<Transition> transitions){
        for (int i=0;i<transitions.size(); i ++){
            transitionPanels.add(new JPanel());
            transitionPanels.get(i).setSize(850, 30);
            transitionPanels.get(i).setPreferredSize(new Dimension(200, 30));
            transitionPanels.get(i).setBackground(Color.gray.brighter());
            transitionWindow.add(transitionPanels.get(i));

            transitionLabels.add(new JLabel(transitions.get(i).toString()));
            transitionLabels.get(i).setLocation(5, 5);

            transitionPanels.get(i).add(transitionLabels.get(i));

        }
    }

    private void updateView(){
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

        automataLabel.setText("Current State: " + machine.getCurrentState());

    }

    private void checkStatus(){
        if(statusLabel.getText() == "Status: Accepted") {
            statusPanel.setBackground(acceptColor);
        } else {
            statusPanel.setBackground(rejectColor);
        }
    }

}
