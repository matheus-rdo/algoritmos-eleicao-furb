package br.com.furb;

import java.util.Timer;

import br.com.furb.task.CreateProcessTask;

public class App {

	private static final int CREATE_PROCESS_DELAY = 30000;

	public static void main(String[] args) throws InterruptedException {
		scheduleTasks();
	}

	/**
	 * Agenda as rotinas periodicamente
	 */
	private static void scheduleTasks() {
		Timer timer = new Timer();
		timer.schedule(new CreateProcessTask(), CREATE_PROCESS_DELAY, CREATE_PROCESS_DELAY);
	}

}
