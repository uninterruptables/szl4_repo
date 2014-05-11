package team.uninter.mordorq.core;

import team.uninter.mordorq.gamespace.MordorFrame;

public class GameMain {

	public static final String SCENE_DESC = "resources/descriptors/scene.dsc";

	public static void main(String[] args) {
		try {
			MordorFrame.newInstance(SCENE_DESC);
		} catch (Exception e) {
			System.out.println("in MordorQuest main: " + e.getClass().getName() + ": " + e.getMessage());
		}
	}
}
