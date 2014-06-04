import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class BlocksFrame extends JFrame implements MouseListener, MouseMotionListener {

	private BackgroundPanel backgroundPanel = new BackgroundPanel(null);
	private boolean drag = false;
	
	private JLabel playButton = new JLabel();
	private JLabel stopButton = new JLabel();
	
	private Block qa = new Block(Pattern.QUESTION_ANSWER, Actor.ROBOT);
	private Block cc = new Block(Pattern.COMMENT_COMMENT, Actor.ROBOT);
	private Block ia = new Block(Pattern.INSTRUCTION_ACTION, Actor.ROBOT);
	private Block mc = new Block(Pattern.MONOLOGUE_COMMENT, Actor.ROBOT);
	private Block m = new Block(Pattern.MONOLOGUE);
	private Block c = new Block(Pattern.COMMENT);
	
	LinkedList<Block> blocks = new LinkedList<Block>();
	LinkedList<Block> patternsToUse = new LinkedList<Block>();
	
	public BlocksFrame() {
		this.add(backgroundPanel);
		
		addButtons();
	}
	
	private void addButtons() {
		/*JTextArea ta2 = new JTextArea(5, 5);
		ta2.setEditable(true);
		//ta2.setBounds(138, 370, 97, 65);
		ta2.setBounds(420, 840, 130, 110);
		//ta2.setText("Yes, I am.");
		ta2.setBackground(new Color(220, 221, 222));
		ta2.setLineWrap(true);
		ta2.setAlignmentX(Component.CENTER_ALIGNMENT);
		ta2.setAlignmentY(Component.CENTER_ALIGNMENT);
		backgroundPanel.add(ta2);
		
		JTextArea ta3 = new JTextArea(5, 5);
		ta3.setEditable(true);
		//ta.setBounds(260, 525, 97, 65);
		ta3.setBounds(220, 590, 130, 110);
		//ta3.setText("Are you here for an\nappointment?");
		ta3.setCaretColor(new Color(220, 221, 222));
		ta3.setBackground(new Color(220, 221, 222));
		ta3.setLineWrap(true);
		ta3.setAlignmentX(Component.CENTER_ALIGNMENT);
		ta3.setAlignmentY(Component.CENTER_ALIGNMENT);
		backgroundPanel.add(ta3);
		
		JTextArea ta1 = new JTextArea(5, 5);
		ta1.setEditable(true);
		//ta.setBounds(260, 525, 97, 65);
		ta1.setBounds(580, 840, 130, 110);
		//ta1.setText("Could you tell me\nwhere to go?");
		ta1.setCaretColor(new Color(220, 221, 222));
		ta1.setBackground(new Color(220, 221, 222));
		ta1.setLineWrap(true);
		ta1.setAlignmentX(Component.CENTER_ALIGNMENT);
		ta1.setAlignmentY(Component.CENTER_ALIGNMENT);
		backgroundPanel.add(ta1);
		
		JTextArea ta4 = new JTextArea(5, 5);
		ta4.setEditable(true);
		//ta.setBounds(260, 525, 97, 65);
		ta4.setBounds(780, 590, 130, 110);
		//ta4.setText("Upstairs.");
		ta4.setCaretColor(new Color(220, 221, 222));
		ta4.setBackground(new Color(220, 221, 222));
		ta4.setLineWrap(true);
		ta4.setAlignmentX(Component.CENTER_ALIGNMENT);
		ta4.setAlignmentY(Component.CENTER_ALIGNMENT);
		backgroundPanel.add(ta4);
		
		JTextArea ta5 = new JTextArea(5, 5);
		ta5.setEditable(true);
		//ta.setBounds(260, 525, 97, 65);
		ta5.setBounds(920, 840, 130, 110);
		//ta5.setText("Thank you!");
		ta5.setCaretColor(new Color(220, 221, 222));
		ta5.setBackground(new Color(220, 221, 222));
		ta5.setLineWrap(true);
		ta5.setAlignmentX(Component.CENTER_ALIGNMENT);
		ta5.setAlignmentY(Component.CENTER_ALIGNMENT);
		backgroundPanel.add(ta5);
		
		JTextArea ta = new JTextArea(5, 5);
		ta.setEditable(true);
		//ta.setBounds(260, 525, 97, 65);
		ta.setBounds(1130, 590, 130, 110);
		//ta.setText("You're welcome.");
		ta.setCaretColor(new Color(220, 221, 222));
		ta.setBackground(new Color(220, 221, 222));
		ta.setLineWrap(true);
		ta.setAlignmentX(Component.CENTER_ALIGNMENT);
		ta.setAlignmentY(Component.CENTER_ALIGNMENT);
		backgroundPanel.add(ta);*/
		
		//playButton.setIcon(new ImageIcon("./figures/play.png"));
		playButton.setIcon(new ImageIcon("./figures/play.png"));
		backgroundPanel.add(playButton);
		playButton.setBounds(1400, 30, playButton.getIcon().getIconWidth(), playButton.getIcon().getIconHeight());
		playButton.addMouseListener(this);
		playButton.setName("play");
		//stopButton.setIcon(new ImageIcon("./figures/stop.png"));
		stopButton.setIcon(new ImageIcon("./figures/stop.png"));
		
		backgroundPanel.add(qa);
		qa.setVisible(true);
		qa.setBounds(198, 298, qa.getIcon().getIconWidth(), qa.getIcon().getIconHeight());
		qa.addMouseMotionListener(this);
		qa.addMouseListener(this);
		
		backgroundPanel.add(cc);
		cc.setVisible(true);
		cc.setBounds(433, 298, cc.getIcon().getIconWidth(), cc.getIcon().getIconHeight());
		cc.addMouseMotionListener(this);
		cc.addMouseListener(this);
		
		backgroundPanel.add(ia);
		ia.setVisible(true);
		ia.setBounds(978, 298, ia.getIcon().getIconWidth(), ia.getIcon().getIconHeight());
		ia.addMouseMotionListener(this);
		ia.addMouseListener(this);
		
		backgroundPanel.add(mc);
		mc.setVisible(true);
		mc.setBounds(703, 298, mc.getIcon().getIconWidth(), mc.getIcon().getIconHeight());
		mc.addMouseMotionListener(this);
		mc.addMouseListener(this);
		
		backgroundPanel.add(c);
		c.setVisible(true);
		c.setBounds(1215, 298, c.getIcon().getIconWidth(), c.getIcon().getIconHeight());
		c.addMouseMotionListener(this);
		c.addMouseListener(this);
		
		backgroundPanel.add(m);
		m.setVisible(true);
		m.setBounds(27, 298, m.getIcon().getIconWidth(), m.getIcon().getIconHeight());
		m.addMouseMotionListener(this);
		m.addMouseListener(this);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (drag == true) {
			JComponent jc = (JComponent) e.getSource();
			Block block = (Block) e.getSource();
			//block.setListPos(-1);
			
			if((jc.getY() + e.getY()) > 650) {
				if(block.isTop()) {
					block.setBottom();
				}
				if(block.isDouble()) {
					jc.setLocation((jc.getX() + e.getX())-20, (jc.getY() + e.getY())-290);
				}
				else {
					jc.setLocation((jc.getX() + e.getX())-20, (jc.getY() + e.getY())-25);
				}
			}
			else if((jc.getY() + e.getY()) > 400) {
				if(!block.isTop()) {
					block.setTop();
				}
				if(block.isDouble()) {
					jc.setLocation((jc.getX() + e.getX())-20, (jc.getY() + e.getY())-25);
				}
				else {
					jc.setLocation((jc.getX() + e.getX())-20, (jc.getY() + e.getY())-25);
				}
			}
			else {
				block.setNeutral();
				jc.setLocation((jc.getX() + e.getX())-20, (jc.getY() + e.getY())-25);
			}
			
			JTextArea area0 = block.getJTextArea(0);
			if(area0 != null) {
				backgroundPanel.remove(area0);
			}
			if(block.isDouble()) {
				JTextArea area1 = block.getJTextArea(1);
				if(area1 != null) {
					backgroundPanel.remove(area1);
				}
			}
			backgroundPanel.repaint();
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource() == playButton) {
			return;
		}
		
		if(((Block) e.getSource()).isNeutral()) {
			int xPos = 0;
			Block newQaBlock = new Block(Pattern.QUESTION_ANSWER);
			if(((Block) e.getSource()).getPattern() == Pattern.QUESTION_ANSWER) {
				newQaBlock = new Block(Pattern.QUESTION_ANSWER);
				xPos = 198;
			}
			else if(((Block) e.getSource()).getPattern() == Pattern.COMMENT_COMMENT) {
				newQaBlock = new Block(Pattern.COMMENT_COMMENT);
				xPos = 433;
			}
			else if(((Block) e.getSource()).getPattern() == Pattern.INSTRUCTION_ACTION) {
				newQaBlock = new Block(Pattern.INSTRUCTION_ACTION);
				xPos = 978;
			}
			else if(((Block) e.getSource()).getPattern() == Pattern.MONOLOGUE_COMMENT) {
				newQaBlock = new Block(Pattern.MONOLOGUE_COMMENT);
				xPos = 703;
			}
			else if(((Block) e.getSource()).getPattern() == Pattern.COMMENT) {
				newQaBlock = new Block(Pattern.COMMENT);
				xPos = 1215;
			}
			else if(((Block) e.getSource()).getPattern() == Pattern.MONOLOGUE) {
				newQaBlock = new Block(Pattern.MONOLOGUE);
				xPos = 27;
			}
			
			backgroundPanel.add(newQaBlock);
			newQaBlock.setVisible(true);
			newQaBlock.setBounds(xPos, 298, newQaBlock.getIcon().getIconWidth(), newQaBlock.getIcon().getIconHeight());
			newQaBlock.addMouseMotionListener(this);
			newQaBlock.addMouseListener(this);
		}
		
		if(((Block) e.getSource()).getListPos() != -1) {
			//blocks.remove(((Block) e.getSource()));
			//((Block) e.getSource()).setListPos(-1);
		}
		
		drag = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource() == playButton) {
			return;
		}
		
		//figure out where this belongs order-wise with other blocks

		if(((Block) e.getSource()).getY() > 400) {
			Block releasedBlock = (Block) e.getSource();
			int xPos = releasedBlock.getX();
			int lastPos = 0;
			int lastPixelPos = 0;
			if(blocks.isEmpty()) {
				blocks.add(releasedBlock);
				releasedBlock.setListPos(lastPos);
				if(releasedBlock.isDouble()
						|| releasedBlock.isTop()) {
					releasedBlock.setLocation(230, 500);
				}
				else {
					releasedBlock.setLocation(230, 755);
				}
				
				int y0 = 590;
				int y1 = 840;
				if(!releasedBlock.isTop()) {
					int temp = y0;
					y0 = y1;
					y1 = temp;
				}
				JTextArea area0 = releasedBlock.getJTextArea(0);
				area0.setBounds(220, y0, 130, 110);
				backgroundPanel.add(area0);
				backgroundPanel.setComponentZOrder(area0, 0);
				if(releasedBlock.isDouble()) {
					JTextArea area1 = releasedBlock.getJTextArea(1);
					area1.setBounds(420, y1, 130, 110);
					backgroundPanel.add(area1);
					backgroundPanel.setComponentZOrder(area1, 0);
				}
			}
			else {
				boolean keepLooking = true;
				for(Block block : blocks) { //corner case of being added at the end!
					if(block.getX() > xPos && keepLooking) {//((Block) e.getSource()).getX()) {
						releasedBlock.setListPos(lastPos);
						
						if(releasedBlock.isDouble()
								|| releasedBlock.isTop()) {
							releasedBlock.setLocation(230+lastPixelPos, 500); //(350*lastPos)
						}
						else {
							releasedBlock.setLocation(230+lastPixelPos, 755);
						}
						
						int y0 = 590;
						int y1 = 840;
						if(!releasedBlock.isTop()) {
							int temp = y0;
							y0 = y1;
							y1 = temp;
						}
						JTextArea area0 = releasedBlock.getJTextArea(0);
						area0.setBounds(220+lastPixelPos, y0, 130, 110);
						backgroundPanel.add(area0);
						backgroundPanel.setComponentZOrder(area0, 0);
						if(releasedBlock.isDouble()) {
							JTextArea area1 = releasedBlock.getJTextArea(1);
							area1.setBounds(230+lastPixelPos+200, y1, 130, 110);
							backgroundPanel.add(area1);
							backgroundPanel.setComponentZOrder(area1, 0);
						}
						
						lastPixelPos += (releasedBlock.getWidth() + 38);
						keepLooking = false;
					}

					lastPos++;
					
					if(keepLooking) {
						lastPixelPos += (block.getWidth() + 38);
					}
					else {
						block.setListPos(lastPos);
						
						if(block.isDouble()
								|| block.isTop()) {
							block.setLocation(230+lastPixelPos, 500); //(350*lastPos)
						}
						else {
							block.setLocation(230+lastPixelPos, 755);
						}
						
						int y0 = 590;
						int y1 = 840;
						if(!block.isTop()) {
							int temp = y0;
							y0 = y1;
							y1 = temp;
						}
						JTextArea area0 = block.getJTextArea(0);
						area0.setBounds(220+lastPixelPos, y0, 130, 110);
						backgroundPanel.add(area0);
						backgroundPanel.setComponentZOrder(area0, 0);
						if(block.isDouble()) {
							JTextArea area1 = block.getJTextArea(1);
							area1.setBounds(230+lastPixelPos+200, y1, 130, 110);
							backgroundPanel.add(area1);
							backgroundPanel.setComponentZOrder(area1, 0);
						}
						
						lastPixelPos += (block.getWidth() + 38);
					}
				}
				
				if(releasedBlock.getListPos() == -1) {
					blocks.add(lastPos, releasedBlock);
					releasedBlock.setListPos(lastPos);
					
					if(releasedBlock.isDouble()
							|| releasedBlock.isTop()) {
						releasedBlock.setLocation(230+lastPixelPos, 500); //(350*lastPos)
					}
					else {
						releasedBlock.setLocation(230+lastPixelPos, 755);
					}
					
					int y0 = 590;
					int y1 = 840;
					if(!releasedBlock.isTop()) {
						int temp = y0;
						y0 = y1;
						y1 = temp;
					}
					JTextArea area0 = releasedBlock.getJTextArea(0);
					area0.setBounds(220+lastPixelPos, y0, 130, 110);
					backgroundPanel.add(area0);
					backgroundPanel.setComponentZOrder(area0, 0);
					if(releasedBlock.isDouble()) {
						JTextArea area1 = releasedBlock.getJTextArea(1);
						area1.setBounds(230+lastPixelPos+200, y1, 130, 110);
						backgroundPanel.add(area1);
						backgroundPanel.setComponentZOrder(area1, 0);
					}
				}
				else {
					blocks.add(releasedBlock.getListPos(), releasedBlock);
				}
			}
		}
		else { //block is being taken off of the timeline
			Block toRemove = ((Block) e.getSource());
			
			int i = 0;
			int listPos = toRemove.getListPos();
			blocks.remove(listPos);
			//int width = toRemove.getWidth()+38;
			int lastPixelPos = 0;
			for(Block block : blocks) {
				if(i < listPos) {
					lastPixelPos += (block.getWidth() + 38);
				}
				else {
					if(block.isDouble()
							|| block.isTop()) {
						block.setLocation(230+lastPixelPos, 500); //(350*lastPos)
					}
					else {
						block.setLocation(230+lastPixelPos, 755);
					}
					
					int y0 = 590;
					int y1 = 840;
					if(!block.isTop()) {
						int temp = y0;
						y0 = y1;
						y1 = temp;
					}
					JTextArea area0 = block.getJTextArea(0);
					area0.setBounds(220+lastPixelPos, y0, 130, 110);
					backgroundPanel.add(area0);
					backgroundPanel.setComponentZOrder(area0, 0);
					if(block.isDouble()) {
						JTextArea area1 = block.getJTextArea(1);
						area1.setBounds(230+lastPixelPos+200, y1, 130, 110);
						backgroundPanel.add(area1);
						backgroundPanel.setComponentZOrder(area1, 0);
					}
				}
				
				i++;
			}
			
			JTextArea area0 = toRemove.getJTextArea(0);
			backgroundPanel.remove(area0);
			if(toRemove.isDouble()) {
				JTextArea area1 = toRemove.getJTextArea(1);
				backgroundPanel.remove(area1);
			}
			backgroundPanel.remove(toRemove);
			backgroundPanel.repaint();
		}
		
		System.out.println("\n\n");
		for(Block block : blocks) {
			block.printDialogue();
		}
		
		drag = false;
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(((JLabel)e.getSource()) == playButton) {
			if(((JLabel)e.getSource()).getName() == "play") {
				System.out.println("Play!");
				playButton.setIcon(new ImageIcon("./figures/stop.png"));
				playButton.setName("stop");
				InteractionBlocks.playButton(blocks);
			}
			else {
				System.out.println("Stop!");
				playButton.setIcon(new ImageIcon("./figures/play.png"));
				playButton.setName("play");
				InteractionBlocks.stopButton();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
