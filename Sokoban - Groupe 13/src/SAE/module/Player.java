package SAE.module;

import SAE.module.Movable;

public class Player extends Movable {
	public Player(int col, int lig) {
		super(col,lig);
	}

	@Override
	public void moveTo(int col, int lig) {
		//TODO : à implémeter
	}

	public Player(int col, int lig , boolean b) {
		super(col,lig,b);
	}
	public Player(Point p , boolean b) {
		super(p,b);
	}
}
