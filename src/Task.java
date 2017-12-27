import java.time.LocalDate;

public class Task implements Comparable<Task>
{
	private String header;
	private String description;
	private Status status;
	private int priority;
	private LocalDate deadline;
	
	public Task(String h, String d, Status s, int p, LocalDate dl)
	{
		this.header = h;
		this.description = d;
		this.status = s;
		this.priority = p;
		this.deadline = dl;
	}
	
	public String getHeader()
	{
		return this.header;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public Status getStatus()
	{
		return this.status;
	}
	
	public int getPriority()
	{
		return this.priority;
	}
	
	public LocalDate getDeadline()
	{
		return this.deadline;
	}
	
	public void printTask()
	{
		System.out.println(this.getHeader());
		System.out.println(this.getStatus());
		System.out.println(this.getPriority());
		System.out.println(this.getDeadline());
		System.out.println();
	}
	
	@Override
	public int compareTo(Task otherTask)
	{
		int pr1 = this.getPriority();
		int pr2 = otherTask.getPriority();
		if (pr1 > pr2)
		{
			return 1;
		}
		if (pr1 < pr2)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
}
