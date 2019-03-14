package br.com.furb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.furb.model.SystemProcess;

public class Cluster {

	private static Cluster instance;

	private List<SystemProcess> processes;

	private Cluster() {
		this.processes = new ArrayList<>();
	}

	public static Cluster getInstance() {
		return instance == null ? instance = new Cluster() : instance;
	}

	public void createNewProcess() {
		SystemProcess process = generateNewProcess();
		this.processes.add(process);
	}

	private SystemProcess generateNewProcess() {
		SystemProcess process = new SystemProcess(new Random().nextInt(100));
		boolean exists = processes.stream().filter(p -> p.equals(process)).findAny().isPresent();
		if (exists)
			return generateNewProcess();

		return process;

	}

}
