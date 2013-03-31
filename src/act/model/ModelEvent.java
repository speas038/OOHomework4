package act.model;
import java.awt.event.ActionEvent;

public class ModelEvent extends ActionEvent {
	private static final long serialVersionUID = 1L;
	private int amount;
	public ModelEvent(Object obj, int id, String message, int amount){
		super(obj, id, message);
		this.amount = amount;
	}
	public int getAmount(){return amount;}
}
