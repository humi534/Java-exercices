
class Main {
  public static void main(String[] args) {

    Stack<Integer> myIntStack = new Stack<>();
    
    try {
		myIntStack.pop();
	} catch (StackEmptyException e) {
		System.out.println(e.getMessage());
	}
    
    try{
    	myIntStack.push(5);
    	myIntStack.push(4);
    	myIntStack.push(3);
    	myIntStack.push(2);
    	myIntStack.push(1);
    	myIntStack.push(0);
    }
    catch (StackFullException e){
        System.out.println(e.getMessage());
    }
    finally {
    	System.out.println(myIntStack.toString());
    }
    

    Stack<String> myStringStack = new Stack<>();
    try{
        myStringStack.push("bonjour");
        myStringStack.push("tout");
        myStringStack.push("le");
        myStringStack.push("monde");
        myStringStack.push("!");
        myStringStack.push("message de trop");
    }
    catch (StackFullException e){
        System.out.println(e.toString());
    }
    finally {
    	System.out.println(myStringStack.toString());
    }
    
    
    
	try {
		String lastword;
		lastword = myStringStack.pop();
		System.out.println("last word removed : " + lastword);
	} catch (StackEmptyException e) {
		System.out.println(e.getMessage());
	}
    System.out.println(myStringStack.toString());
    
   
  }
}