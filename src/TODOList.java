import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TODOList
{
	private Task[] tasks;
	
	TODOList(Task[] t)
	{
		this.tasks = t;
	}
	
	private void sortTasks()
	{
		Arrays.sort(tasks);
	}
	
	public void orderedByPriority(Boolean fl)
	{
		this.sortTasks();
		for (int i = 0; i < tasks.length; i++)
		{
			tasks[i].printTask();
			fl = false;
		}
	}
	
	public void onlyInProcess(Boolean flag)
	{
		this.sortTasks();
		for (int i = 0; i < tasks.length; i++)
		{
			if(tasks[i].getStatus() == Status.IN_PROCESS)
			{
				tasks[i].printTask();
				flag = false;
			}
		}
	}
	
	public void dueInNextThreeDays(Boolean flag)
	{
		this.sortTasks();
		for (int i = 0; i < tasks.length; i++)
		{
			if(tasks[i].getStatus() == Status.DONE)
			{
				continue;
			}
			else
			{
				LocalDate now = LocalDate.now().plusDays(4);
				if(tasks[i].getDeadline().isBefore(now))
				{
					tasks[i].printTask();
					flag = false;
				}
			}
		}
	}
	
	private void exit()
	{
		System.exit(0);
	}
	
	private void communicate()
	{
		System.out.println("Choose an option: ");
		System.out.println("1) Every task sorted by priority");
		System.out.println("2) Tasks with a status IN_PROGRESS");
		System.out.println("3) Tasks which end in three days");
		System.out.println("4) Exit");
		System.out.println("Your choice is: ");
	}
	
	public void chooseCommands(Boolean flag)
	{
		Scanner scanner = new Scanner(System.in);
		int numOpt = 0;
		while(true)
		{
			communicate();
			try
			{
				numOpt = scanner.nextInt();
			}
			catch(InputMismatchException ex)
			{
				System.err.println("That is not a number: " + ex.getMessage());
				chooseCommands(flag);
			}
			
			switch(numOpt)
			{
			case 1 : orderedByPriority(flag); break;
			case 2 : onlyInProcess(flag); break;
			case 3 : dueInNextThreeDays(flag); break;
			case 4 : exit(); break;
			default : System.out.println("No such command!"); break;
			}
		}
	}
	
	public static void main(String[] args) 
	{
		Task t0 = new Task("task0", "sth0", Status.INITIAL, 2, LocalDate.now().plusDays(2));
		Task t1 = new Task("task1", "sth1", Status.IN_PROCESS, 1, LocalDate.now().plusDays(1));
		Task t2 = new Task("task2", "sth2", Status.INITIAL, 5, LocalDate.now().plusDays(6));
		Task t3 = new Task("task3", "sth3", Status.DONE, 4, LocalDate.now());
		Task t4 = new Task("task4", "sth4", Status.IN_PROCESS, 3, LocalDate.now().plusDays(4));
		Task t5 = new Task("task5", "sth5", Status.INITIAL, 1, LocalDate.now().plusDays(3));
		Task t6 = new Task("task6", "sth6", Status.IN_PROCESS, 5, LocalDate.now().plusDays(9));
		Boolean flag = true;
		Task[] tasks = {t0, t1, t2, t3, t4, t5, t6};
		TODOList l = new TODOList(tasks);
		l.chooseCommands(flag);
	}
}
