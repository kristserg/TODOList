import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TODOTester 
{
	@Test
	public void testOptionOne() 
	{
		Task t0 = new Task("task0", "sth0", Status.INITIAL, 2, LocalDate.now().plusDays(2));
		Task t1 = new Task("task1", "sth1", Status.IN_PROCESS, 1, LocalDate.now().plusDays(1));
		Task t2 = new Task("task2", "sth2", Status.INITIAL, 5, LocalDate.now().plusDays(6));
		Task t3 = new Task("task3", "sth3", Status.DONE, 4, LocalDate.now());
		Task t4 = new Task("task4", "sth4", Status.IN_PROCESS, 3, LocalDate.now().plusDays(4));
		Task t5 = new Task("task5", "sth5", Status.INITIAL, 1, LocalDate.now().plusDays(3));
		Task t6 = new Task("task6", "sth6", Status.IN_PROCESS, 5, LocalDate.now().plusDays(9));
		Task[] tasks = {t0, t1, t2, t3, t4, t5, t6};
		TODOList l = new TODOList(tasks);
		Boolean flag = true;
		l.orderedByPriority(flag);
		l.dueInNextThreeDays(flag);
		l.onlyInProcess(flag);
		
		assertEquals(1, t0.compareTo(t1));
		assertEquals(-1, t3.compareTo(t2));
		assertEquals(0, t1.compareTo(t5));
		assertEquals(0, t5.compareTo(t1));
		assertEquals(-1, t4.compareTo(t6));
		
		assertEquals(true, flag);
		//assertEquals(true, flag);
		//assertEquals(true, flag);
		
		//fail("Not yet implemented");
	}

}
