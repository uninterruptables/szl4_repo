package team.uninter.mordorq.core;

import java.io.IOException;

import team.uninter.mordorq.prototype.Prototype;

public class PrototypeMain {

	public static void main(String[] args) {
		try{
			Prototype proto = new Prototype();
			proto.run();
		}catch(IOException e){
			System.out.println("in prototype main: "+e.getClass().getName()+": "+e.getMessage());
		}
	}
}
