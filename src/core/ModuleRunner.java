package core;

import java.util.ArrayList;
import java.util.List;

import module.Problem5;

public class ModuleRunner 
{
	List<Module> modules;
	
	public ModuleRunner()
	{
		modules = new ArrayList<Module>();
		//modules.add(new Problem1());
		//modules.add(new Problem2());
		//modules.add(new Problem3());
		//modules.add(new Problem4());
		modules.add(new Problem5());
	}
	
	public void start()
	{	
		long time;
		for(Module module : modules)
		{
			System.out.println("***** " + module.getClass().getSimpleName() + " *****");
			time = System.currentTimeMillis();
			module.run();
			System.out.println("Time: " + (System.currentTimeMillis() - time)/1000 + "s");
			System.out.println();
		}
	}
}
