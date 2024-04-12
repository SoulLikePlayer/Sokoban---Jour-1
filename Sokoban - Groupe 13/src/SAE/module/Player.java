package SAE.module;

import SAE.module.Movable;

public class Player extends Movable {

	@Override
	public void moveTo(int col, int lig) {

	}

	@Override
	public void moveTo(Point p) {

	}


	public Player(int col, int lig , boolean b) {
		super(col,lig,b);
	}

	public Player(Point p , boolean b) {
		super(p);
		super.setImmutable(b);
	}
}
