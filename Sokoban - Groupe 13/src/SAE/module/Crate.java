package SAE.module;

public class Crate extends Movable {
	public Crate(int col, int lig) {
		super(col,lig);
	}

	@Override
	public void moveTo(int col, int lig) {
		//TODO : à implémeter
	}

	@Override
	public void moveTo(Point p) {

	}

	public Crate(int col, int lig , boolean b) {
		super(col,lig,b);
	}
	public Crate(Point p , boolean b){
		super(p);
		super.setImmutable(b);
	}
}
