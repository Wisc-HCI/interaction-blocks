import java.util.LinkedList;
import java.util.Random;

import javax.swing.JFrame;

import com.aldebaran.proxy.*;

public class InteractionBlocks {

	private static boolean robotConnected = false;
	
	private static String naoIP = "192.168.1.103";
	private static int port = 9559;
	
	private static boolean keepGoing = true;
	private static float lastConf = -1;
	
	private static ALMemoryProxy memory = null;
	private static ALSpeechRecognitionProxy recog = null;
	private static ALTextToSpeechProxy tts = null;
	private static ALAudioDeviceProxy audioDevice = null;
	//private static ALLedsProxy leds = null;
	private static ALMotionProxy motion = null;
	
	public static void main(String[] args) {
		
		/*leds.setIntensity("AllLeds", 0);
		leds.setIntensity("ChestLeds", 0);
		leds.setIntensity("EarLeds", 0);
		leds.off("AllLeds");*/
		
		if(robotConnected) {
			initializeProxies();
		}
		
		BlocksFrame frame = new BlocksFrame();
		frame.setVisible(true);
		frame.setSize(1600, 1000);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//figure out way to keep nodes ordered
		//then pass nodes into compileDialogue()
		LinkedList<Block> blocks = new LinkedList<Block>();
		Block b0 = new Block(Pattern.COMMENT, Actor.HUMAN);
		b0.assignDialogue("Excuse me.", 0);
		Block b1 = new Block(Pattern.QUESTION_ANSWER, Actor.ROBOT);
		b1.assignDialogue("Are you here for an appointment?", 0);
		b1.assignDialogue("Yes, I am.", 1);
		Block b2 = new Block(Pattern.QUESTION_ANSWER, Actor.HUMAN);
		b2.assignDialogue("Could you tell me where to go?", 0);
		b2.assignDialogue("Upstairs.", 1);
		Block b3 = new Block(Pattern.COMMENT, Actor.HUMAN);
		b3.assignDialogue("Thank you!", 0);
		Block b4 = new Block(Pattern.COMMENT, Actor.ROBOT);
		b4.assignDialogue("You're welcome!", 0);
		blocks.add(b0);
		blocks.add(b1);
		blocks.add(b2);
		blocks.add(b3);
		blocks.add(b4);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//playButton(blocks);
	}
	
	private static void initializeProxies() {
		memory = new ALMemoryProxy(naoIP, port);
		recog = new ALSpeechRecognitionProxy(naoIP, port);
		tts = new ALTextToSpeechProxy(naoIP, port);
		audioDevice = new ALAudioDeviceProxy(naoIP, port);
		//leds = new ALLedsProxy(naoIP, port);
		motion = new ALMotionProxy(naoIP, port);
	}
	
	public static void stopButton() {
		if(robotConnected) {
			keepGoing = false;
		}
	}
	
	public static void playButton(LinkedList<Block> blocks) {
		TalkingNode head = compileDialogue(blocks);
		interactWithRobot(head);
	}
	
	private static TalkingNode compileDialogue(LinkedList<Block> blocks) {
		TalkingNode head = null;
		TalkingNode last = null;
		for(Block block : blocks) {
			TalkingNode top = block.generateNodes();
			if(head == null) {
				head = top;
			}
			else {
				last.setNext(top);
			}
			if(top.hasNext()) {
				last = top.getNext();
			}
			else {
				last = top;
			}
		}
				
		return head;
	}
	
	private static void interactWithRobot(TalkingNode head) {
		keepGoing = true;
		while(keepGoing && robotConnected) {
			Actor who = head.getActor();
			String words = head.getWords();
			Variant names  = new Variant(new String[] {"HeadPitch" });
			Random rand = new Random();
			//Variant angles = new Variant(new float[] { -0.5f, 0.5f, 0.0f });
			Variant angles = new Variant(new float[] { rand.nextFloat()/3, rand.nextFloat()/3});
			Variant times  = new Variant(new float[] {	0.25f, 0.75f});
			
			/*float[] position = motion.getPosition("Head", 2, false);
			for(float val : position) {
				System.out.println(val);
			}*/
			if(who == Actor.ROBOT) {
				//have the robot TTS this
				System.out.println("Robot says: " + words);
				audioDevice.setOutputVolume(80);
				tts.say(words);

				motion.setStiffnesses(new Variant(new String[] {"HeadPitch"}), new Variant(new float[] {1.0f}));
				motion.angleInterpolation(names, angles, times, true);
				motion.setStiffnesses(new Variant(new String[] {"HeadPitch"}), new Variant(new float[] {0.0f}));
			}
			else {
				lastConf = -1;
				String[] vocab = {words}; //add string we need to recognize
				audioDevice.setOutputVolume(0);
				try {
					recog.unsubscribe("WordRecognized");
				} catch (Exception e) {
				}
				
				recog.setAudioExpression(true);
				recog.setVisualExpression(false);
				recog.setVocabulary(vocab, true);
				
				recog.subscribe("WordRecognized");
				
				System.out.println("Human expected to say: " + words);
				
				//have the robot wait for the human response
				while(keepGoing) {
					Variant wordsSaid = memory.getData("WordRecognized");
					String word = (String)wordsSaid.getElement(0).toString();
					float percent = (float)wordsSaid.getElement(1).toFloat();
					if(percent > .2) {
						System.out.println("Word: " + word + "\t\tConfidence: " + percent + "\t\tLast Confidence: " + lastConf);
					}
					if(word.equals(words) && lastConf != percent && percent > .39) {
						lastConf = percent;
						recog.unsubscribe("WordRecognized");
						System.out.println("Next...");
						break;
					}
				}
			}
			
			if(!head.hasNext()) {
				//maybe change button from stop back to play?
				break;
			}
			
			head = head.getNext();
		}
	}
}
