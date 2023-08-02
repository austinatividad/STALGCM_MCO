package View;
import javax.swing.*;
import java.awt.*;
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
    static JPanel transitionPanel = new JPanel();

    //Machine Object
    Machine machine = null;
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
    }

    private void createMainWindow(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(920, 650);
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
    }

    private void createTransitionPanel(){
        transitionPanel.setLocation(24,372);
        transitionPanel.setSize(860, 200);
        transitionPanel.setLayout(null);
        transitionPanel.setBackground(componentColor);
        frame.add(transitionPanel);
        transitionPanel.setVisible(true);

    }

    private void createJLabels(){
        JLabel tapeLabel = new JLabel(machine.getTape().toString());
        tapeLabel.setLocation(5, 5);
        tapePanel.add(tapeLabel);
        tapeLabel.setSize(460, 20);
        tapeLabel.setVisible(true);

        JLabel statusLabel = new JLabel("Status: " + machine.getIsAccepted());
    }


}
