package SAE.module;

import SAE.module.Movable;

public class Player extends Movable {
	public Player(int col, int lig) {
		super(col,lig);
	}
	public Player(int col, int lig , boolean b) {
		super(col,lig,b);
	}
	public Player(Point p , boolean b) {
		super(p,b);
	}
}
