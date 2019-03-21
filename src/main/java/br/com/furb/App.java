package br.com.furb;

import java.util.Timer;

import br.com.furb.task.CheckCoordinatorTask;
import br.com.furb.task.CreateProcessTask;
import br.com.furb.task.DesactivateCoordinatorTask;
import br.com.furb.task.DesactivateProcessTask;

public class App {

	private static final int CREATE_PROCESS_DELAY = 3000;
	private static final int DESACTIVATE_COORDINATOR_DELAY = 10000;
	private static final int DESACTIVATE_PROCESS_DELAY = 8000;
	private static final int CHECK_COORDINATOR_DELAY = 2500;

	public static void main(String[] args) throws InterruptedException {
		scheduleTasks();
	}

	/**
	 * Agenda as rotinas periodicas
	 */
	private static void scheduleTasks() {
		Timer timer = new Timer();
		timer.schedule(new CreateProcessTask(), CREATE_PROCESS_DELAY, CREATE_PROCESS_DELAY);
		timer.schedule(new DesactivateCoordinatorTask(), DESACTIVATE_COORDINATOR_DELAY, DESACTIVATE_COORDINATOR_DELAY);
		timer.schedule(new DesactivateProcessTask(), DESACTIVATE_PROCESS_DELAY, DESACTIVATE_PROCESS_DELAY);
		timer.schedule(new CheckCoordinatorTask(), CHECK_COORDINATOR_DELAY, CHECK_COORDINATOR_DELAY);
	}

}
