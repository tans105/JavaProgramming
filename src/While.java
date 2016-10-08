class While implements Runnable 
{ 
    int x = 0, y = 0; 
    int addX() {x++; return x;} 
    int addY() {y++; return y;} 
    public void run() { 
    for(int i = 0; i < 10; i++) 
        System.out.println(addX() + " " + addY()); 
} 
    public static void main(String args[]) 
    { 
        While run1 = new While(); 
        While run2 = new While(); 
        Thread t1 = new Thread(run1); 
        Thread t2 = new Thread(run2); 
        t1.start(); 
        t2.start(); 
    } 
}