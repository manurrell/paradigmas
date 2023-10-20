package nemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class Instruction {
	private static ArrayList<Instruction> instruction_list=new ArrayList<>(Arrays.asList(new Comando_u(),new Comando_r(), new Comando_l(), new Comando_f(), new Comando_d(), new Comando_m()));
	public abstract void execute(Nemo nemo); 
	public abstract boolean applies(int c);
	public static void ejecutarInstrucciones(String commandos, Nemo nemo) {
			commandos.chars().forEach(comando -> instruction_list.stream()
					.filter(instructions -> instructions.applies(comando))
					.collect(Collectors.toList()).get(0).execute(nemo));
		
	}
}
