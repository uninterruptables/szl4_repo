package team.uninter.mordorq.gamespace;

@SuppressWarnings("serial")
public abstract class Rune extends Casted implements Injectable {

	protected Rune() {
		super();
	}

	protected Rune(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean canCastOn(TerrainGrid grid) {

		InjectionTarget target = grid.getInjectionTarget();
		if (target != null) {
			boolean ret = target.canInject(this);
			return ret;
		}
		else {
			return false;
		}
	}

	@Override
	public final void castOn(TerrainGrid grid) {
		InjectionTarget target = grid.getInjectionTarget();
		if (target != null) {
			if (target.canInject(this)) {
				target.inject(this);
			}
		}
	}
}
