
public class TalkingNode {

	private TalkingNode next = null;
	private String words = "";
	private Actor who = null;
	
	public TalkingNode(Actor who, String words, TalkingNode next) {
		this.who = who;
		this.words = words;
		this.next = next;
	}
	
	public TalkingNode getNext() {
		return next;
	}
	
	public boolean hasNext() {
		if(next != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void setNext(TalkingNode next) {
		this.next = next;
	}
	
	public Actor getActor() {
		return who;
	}
	
	public String getWords() {
		return words;
	}
}
