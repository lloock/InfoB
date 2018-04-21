/**
 * Test class for testing the class Arena and if the positions and the
 * corresponding sections are correct
 * 
 * @author Louis Loock
 *
 */
public class TestArena {

	public static void main(String[] args) {
		// Initializing 24 tributes, in each section should be two
		Tribute t1_1 = new Tribute(0, 1, "t1_1");
		Tribute t1_2 = new Tribute(0.25, 1.2, "t1_2");

		Tribute t2_1 = new Tribute(0.375, 0.625, "t2_1");
		Tribute t2_2 = new Tribute(0.9, 0.8, "t2_1");

		Tribute t3_1 = new Tribute(0.25, 0.125, "t3_1");
		Tribute t3_2 = new Tribute(1.4, 0.05, "t3_1");

		Tribute t4_1 = new Tribute(1.1, 0, "t4_1");
		Tribute t4_2 = new Tribute(1.25, -0.09, "t4_1");

		Tribute t5_1 = new Tribute(0.86, -0.5, "t5_1");
		Tribute t5_2 = new Tribute(0.75, -0.6, "t5_1");

		Tribute t6_1 = new Tribute(0.36, -0.625, "t6_1");
		Tribute t6_2 = new Tribute(0.2, -1.4, "t6_1");

		Tribute t7_1 = new Tribute(0, -1, "t7_1");
		Tribute t7_2 = new Tribute(-0.1, -1.49, "t7_1");

		Tribute t8_1 = new Tribute(-0.6, -0.875, "t8_1"); 
		Tribute t8_2 = new Tribute(-0.75, -0.75, "t8_1");

		Tribute t9_1 = new Tribute(-0.65, -0.375, "t9_1"); 
		Tribute t9_2 = new Tribute(-1.325, -0.09, "t9_1");

		Tribute t10_1 = new Tribute(-1.5, 0, "t10_1");
		Tribute t10_2 = new Tribute(-1.3, 0.1, "t10_1"); 

		Tribute t11_1 = new Tribute(-0.625, 0.375, "t11_1");
		Tribute t11_2 = new Tribute(-0.75, 0.75, "t11_1");

		Tribute t12_1 = new Tribute(-0.5, 0.875, "t12_1"); 
		Tribute t12_2 = new Tribute(-0.25, 1.375, "t12_1"); 


		// Printing the results 
		// Example: t1_1 is the first tribute in section 1 and t1_2 the second tribute in section 1
		System.out.println(t1_1);
		System.out.println(t1_2 + "\n");

		System.out.println(t2_1);
		System.out.println(t2_2 + "\n");

		System.out.println(t3_1);
		System.out.println(t3_2 + "\n");

		System.out.println(t4_1);
		System.out.println(t4_2 + "\n");

		System.out.println(t5_1);
		System.out.println(t5_2 + "\n");

		System.out.println(t6_1);
		System.out.println(t6_2 + "\n");

		System.out.println(t7_1);
		System.out.println(t7_2 + "\n");

		System.out.println(t8_1);
		System.out.println(t8_2 + "\n");

		System.out.println(t9_1);
		System.out.println(t9_2 + "\n");

		System.out.println(t10_1);
		System.out.println(t10_2 + "\n");

		System.out.println(t11_1);
		System.out.println(t11_2 + "\n");

		System.out.println(t12_1);
		System.out.println(t12_2 + "\n");
	}

}
