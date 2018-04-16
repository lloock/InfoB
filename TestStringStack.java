/**
 * Open problems:
 * - what is meant by building test-methods
 */
public class TestStringStack{
  public static void main(String[] args) {

    String[] abc = {"A", "B", "C"};						// the values for the StringStack
    
    StringStack reference = new StringStack();			// initializing the StringStack
    for(int i = abc.length - 1; i > -1; i--) {				// for-loop to fill in the Strings onto the StringStack
      reference.push(abc[i]);
    }

    StringStack copy = new StringStack(reference);		// using the copy constructor

    System.out.println("Are the peeks of both StringStacks the same?");
    System.out.println("reference_peek = " + reference.peek());
    System.out.println("copy_peek = " + copy.peek() + "\n");

    System.out.println("When I pop one String of the copy-StringStack, does the original StringStack stay the same?");
    copy.pop();
    System.out.println("reference_peek = " + reference.peek());
    System.out.println("copy_peek = " + copy.peek() + "\n");

    copy.push("X");
    System.out.println("One element was pushed to the copy StringStack, but not to the original StringStack.");
    System.out.println("reference_peek = " + reference.peek());
    System.out.println("copy_peek = " + copy.peek() + "\n");
    
    System.out.println("Now we look at the entire StringStacks: ");
    System.out.print("reference = " + reference.peek());
    reference.pop();
    System.out.print(reference.peek());
    reference.pop();
    System.out.print(reference.peek() + "\n");
    System.out.print("copy = " + copy.peek());
    copy.pop();
    System.out.print(copy.peek());
    copy.pop();
    System.out.print(copy.peek() + "\n");
    
  }
}