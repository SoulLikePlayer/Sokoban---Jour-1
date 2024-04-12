package SAE.module;

import SAE.module.Movable;

/**
 * This class manages everything related to the player movements
 */
public class Player extends Movable {

	/**
	 *
	 * @param col The goal column
	 * @param lig The goal line
	 */
	@Override
	public void moveTo(int col, int lig) {

	}

	@Override
	public void moveTo(Point p) {

	}

	public Player(int col, int lig ) {
		super(col,lig);
	}

	public Player(int col, int lig , boolean b) {
		super(col,lig,b);
	}

	public Player(Point p , boolean b) {
		super(p);
		super.setImmutable(b);
	}
}
