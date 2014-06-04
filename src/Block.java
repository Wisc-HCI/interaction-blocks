import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class Block extends JLabel {

	private Pattern pattern = null;
	private Actor[] whoSaysWhat = new Actor[2];
	private String[] dialogue = new String[2];
	private JTextArea[] textAreas = new JTextArea[2];
	private int listPos = -1;
	private boolean top = false;
	private boolean neutral = true;
	
	public Block(Pattern pattern) {
		initializeTextAreas();
		
		this.pattern = pattern;
		if(this.pattern == Pattern.QUESTION_ANSWER) {
			ImageIcon image = new ImageIcon("./figures/qa.png");
			this.setIcon(image);
		}
		else if(this.pattern == Pattern.COMMENT_COMMENT) {
			ImageIcon image = new ImageIcon("./figures/cc.png");
			this.setIcon(image);
		}
		else if(this.pattern == Pattern.INSTRUCTION_ACTION) {
			ImageIcon image = new ImageIcon("./figures/ia.png");
			this.setIcon(image);
		}
		else if(this.pattern == Pattern.MONOLOGUE_COMMENT) {
			ImageIcon image = new ImageIcon("./figures/mc.png");
			this.setIcon(image);
		}
		else if(this.pattern == Pattern.COMMENT) {
			ImageIcon image = new ImageIcon("./figures/c.png");
			this.setIcon(image);
		}
		else if(this.pattern == Pattern.MONOLOGUE) {
			ImageIcon image = new ImageIcon("./figures/m.png");
			this.setIcon(image);
		}
		
		whoSaysWhat[0] = Actor.ROBOT;
		if(this.isDouble()) {
			whoSaysWhat[1] = Actor.HUMAN;
		}
	}
	
	public Block(Pattern pattern, Actor first) {
		initializeTextAreas();
		
		this.pattern = pattern;
		if(this.pattern == Pattern.QUESTION_ANSWER) {
			ImageIcon image = new ImageIcon("./figures/qa.png");
			this.setIcon(image);
		}
		else if(this.pattern == Pattern.COMMENT_COMMENT) {
			ImageIcon image = new ImageIcon("./figures/cc.png");
			this.setIcon(image);
		}
		else if(this.pattern == Pattern.INSTRUCTION_ACTION) {
			ImageIcon image = new ImageIcon("./figures/ia.png");
			this.setIcon(image);
		}
		else if(this.pattern == Pattern.MONOLOGUE_COMMENT) {
			ImageIcon image = new ImageIcon("./figures/mc.png");
			this.setIcon(image);
		}
		
		whoSaysWhat[0] = first;
		if(this.isDouble()) {
			if(first == Actor.HUMAN) {
				whoSaysWhat[1] = Actor.ROBOT;
			}
			else {
				whoSaysWhat[1] = Actor.HUMAN;
			}
		}
	}
	
	private void initializeTextAreas() {
		JTextArea ta0 = new JTextArea(5, 5);
		ta0.setEditable(true);
		ta0.setBounds(780, 590, 130, 110);
		ta0.setCaretColor(new Color(220, 221, 222));
		ta0.setBackground(new Color(220, 221, 222));
		ta0.setLineWrap(true);
		ta0.setAlignmentX(Component.CENTER_ALIGNMENT);
		ta0.setAlignmentY(Component.CENTER_ALIGNMENT);
		textAreas[0] = ta0;
		
		JTextArea ta1 = new JTextArea(5, 5);
		ta1.setEditable(true);
		ta1.setBounds(780, 590, 130, 110);
		ta1.setCaretColor(new Color(220, 221, 222));
		ta1.setBackground(new Color(220, 221, 222));
		ta1.setLineWrap(true);
		ta1.setAlignmentX(Component.CENTER_ALIGNMENT);
		ta1.setAlignmentY(Component.CENTER_ALIGNMENT);
		textAreas[1] = ta1;
	}
	
	public JTextArea getJTextArea(int index) {
		return textAreas[index];
	}
	
	public void setJTextArea(JTextArea textArea, int index) {
		textAreas[index] = textArea;
	}
	
	public Pattern getPattern() {
		return this.pattern;
	}
	
	public void setTop() {
		if(this.pattern == Pattern.QUESTION_ANSWER) {
			ImageIcon image = new ImageIcon("./figures/qaTop.png");
			this.setIcon(image);
			this.setSize(image.getIconWidth(), image.getIconHeight());
		}
		else if(this.pattern == Pattern.COMMENT_COMMENT) {
			ImageIcon image = new ImageIcon("./figures/ccTop.png");
			this.setIcon(image);
			this.setSize(image.getIconWidth(), image.getIconHeight());
		}
		else if(this.pattern == Pattern.INSTRUCTION_ACTION) {
			ImageIcon image = new ImageIcon("./figures/iaTop.png");
			this.setIcon(image);
			this.setSize(image.getIconWidth(), image.getIconHeight());
		}
		else if(this.pattern == Pattern.MONOLOGUE_COMMENT) {
			ImageIcon image = new ImageIcon("./figures/mcTop.png");
			this.setIcon(image);
			this.setSize(image.getIconWidth(), image.getIconHeight());
		}
		
		this.top = true;
		this.neutral = false;
		
		whoSaysWhat[0] = Actor.ROBOT;
		if(this.isDouble()) {
			whoSaysWhat[1] = Actor.HUMAN;
		}
	}
	
	public void setNeutral() {
		if(this.pattern == Pattern.QUESTION_ANSWER) {
			ImageIcon image = new ImageIcon("./figures/qa.png");
			this.setIcon(image);
			this.setSize(image.getIconWidth(), image.getIconHeight());
		}
		else if(this.pattern == Pattern.COMMENT_COMMENT) {
			ImageIcon image = new ImageIcon("./figures/cc.png");
			this.setIcon(image);
			this.setSize(image.getIconWidth(), image.getIconHeight());
		}
		else if(this.pattern == Pattern.INSTRUCTION_ACTION) {
			ImageIcon image = new ImageIcon("./figures/ia.png");
			this.setIcon(image);
			this.setSize(image.getIconWidth(), image.getIconHeight());
		}
		else if(this.pattern == Pattern.MONOLOGUE_COMMENT) {
			ImageIcon image = new ImageIcon("./figures/mc.png");
			this.setIcon(image);
			this.setSize(image.getIconWidth(), image.getIconHeight());
		}
		
		this.top = false;
		this.neutral = true;
	}
	
	public boolean isTop() {
		return this.top;
	}
	
	public boolean isNeutral() {
		return this.neutral;
	}
	
	public void setBottom() {
		if(this.pattern == Pattern.QUESTION_ANSWER) {
			ImageIcon image = new ImageIcon("./figures/qaBottom.png");
			this.setIcon(image);
			this.setSize(image.getIconWidth(), image.getIconHeight());
		}
		else if(this.pattern == Pattern.COMMENT_COMMENT) {
			ImageIcon image = new ImageIcon("./figures/ccBottom.png");
			this.setIcon(image);
			this.setSize(image.getIconWidth(), image.getIconHeight());
		}
		else if(this.pattern == Pattern.INSTRUCTION_ACTION) {
			ImageIcon image = new ImageIcon("./figures/iaBottom.png");
			this.setIcon(image);
			this.setSize(image.getIconWidth(), image.getIconHeight());
		}
		else if(this.pattern == Pattern.MONOLOGUE_COMMENT) {
			ImageIcon image = new ImageIcon("./figures/mcBottom.png");
			this.setIcon(image);
			this.setSize(image.getIconWidth(), image.getIconHeight());
		}
		
		this.top = false;
		this.neutral = false;
		
		whoSaysWhat[0] = Actor.HUMAN;
		if(this.isDouble()) {
			whoSaysWhat[1] = Actor.ROBOT;
		}
	}
	
	public void setFirst(Actor first) {
		whoSaysWhat[0] = first;
		if(this.isDouble()) {
			if(first == Actor.HUMAN) {
				whoSaysWhat[1] = Actor.ROBOT;
			}
			else {
				whoSaysWhat[1] = Actor.HUMAN;
			}
		}
	}
	
	public void setListPos(int pos) {
		this.listPos = pos;
	}
	
	public int getListPos() {
		return this.listPos;
	}
	
	public void assignDialogue(String words, int position) {
		dialogue[position] = words;
	}
	
	private void assignDialogue() {
		for(int i = 0; i < textAreas.length; i++) {
			dialogue[i] = textAreas[i].getText();
		}
	}
	
	public TalkingNode generateNodes() {
		assignDialogue();
		TalkingNode head = new TalkingNode(whoSaysWhat[0], dialogue[0], null);
		TalkingNode tail = null;
		if(this.isDouble()) {
			tail = new TalkingNode(whoSaysWhat[1], dialogue[1], null);
			head.setNext(tail);
		}
		
		return head;
	}
	
	public void printDialogue() {
		assignDialogue();
		System.out.println(dialogue[0]);
		if(this.isDouble()) {
			System.out.println(dialogue[1]);
		}
	}
	
	public boolean isDouble() {
		if(this.pattern == Pattern.QUESTION_ANSWER
				|| this.pattern == Pattern.COMMENT_COMMENT
				|| this.pattern == Pattern.INSTRUCTION_ACTION
				|| this.pattern == Pattern.MONOLOGUE_COMMENT) {
			return true;
		}
		else {
			return false;
		}
	}
}
