package br.com.furb.model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.furb.Cluster;

public class SystemProcess {

	private int id;

	public SystemProcess(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void requestToCoordinator() {
		if (!Cluster.getInstance().getCoordinator().isPresent()) {
			startElection();
		}
	}

	private void startElection() {
		List<SystemProcess> processes = Cluster.getInstance().getProcesses();
		processes.stream().forEach(p -> System.out.print(p.toString() + ","));
		List<SystemProcess> biggerProcesses = processes.stream().filter(p -> p.id > this.id)
				.collect(Collectors.toList());
		if (biggerProcesses.isEmpty()) {
			Cluster.getInstance().setCoordinator(Optional.of(this));
		} else {
			biggerProcesses.stream().forEach(process -> process.startElection());
		}
	}

	@Override
	public String toString() {
		return "[ID:" + id + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SystemProcess other = (SystemProcess) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
