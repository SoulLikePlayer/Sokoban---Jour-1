package SAE.module;

/**
 * This class manages everything related to the player movements
 */
public class Crate extends Movable {
	public Crate(int col, int lig) {
		super(col,lig);
	}

	@Override

	public void moveTo(int col, int lig) throws IllegalAccessException {
		if (getImmutable() == true) {
			throw new IllegalAccessException("La caisse ne peut pas être bougée");
		} else {
			position = new Point(col, lig);
		}
	}

	@Override
	public void moveTo(Point p){
		position = p ;
	}



	public Crate(int col, int lig , boolean b) {
		super(col,lig,b);
	}
	public Crate(Point p , boolean b){
		super(p);
		super.setImmutable(b);
	}
}
