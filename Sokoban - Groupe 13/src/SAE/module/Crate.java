package SAE.module;

public class Crate extends Movable {
	public Crate(int col, int lig) {
		super(col,lig);
	}
	public Crate(int col, int lig , boolean b) {
		super(col,lig,b);
	}
	public Crate(Point p , boolean b) {
		super(p,b);
	}
}