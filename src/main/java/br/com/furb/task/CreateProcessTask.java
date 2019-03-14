package br.com.furb.task;

import java.util.TimerTask;

import br.com.furb.Cluster;

public class CreateProcessTask extends TimerTask {

	@Override
	public void run() {
		Cluster.getInstance().createNewProcess();
	}

}
