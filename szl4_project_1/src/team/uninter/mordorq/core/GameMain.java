package team.uninter.mordorq.core;

import team.uninter.mordorq.gamespace.MordorFrame;

public class GameMain {

	public static void main(String[] args) {
		try{
			MordorFrame frame = MordorFrame.newInstance();
		}catch(Exception e){
			System.out.println("in MordorQuest main: "+e.getClass().getName()+": "+e.getMessage());
		}
	}
}
