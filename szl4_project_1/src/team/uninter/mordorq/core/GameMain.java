package team.uninter.mordorq.core;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import team.uninter.mordorq.gamespace.MordorFrame;

public class GameMain {

	public static final String LOG4J_PROPS = "resources/configs/log4j.properties";
	public static final String SCENE_DESC = "resources/descriptors/scene.dsc";
	private static Logger logger = Logger.getLogger(GameMain.class);

	public static void main(String[] args) {
		PropertyConfigurator.configure(LOG4J_PROPS);
		logger.debug("logger configured..");

		try {
			MordorFrame.newInstance(SCENE_DESC);
		} catch (Exception e) {
			System.out.println("in MordorQuest main: " + e.getClass().getName() + ": " + e.getMessage());
			e.printStackTrace();
		}
	}
}
