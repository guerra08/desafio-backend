package app;

public class App {
    public static void main(String[] args) throws Exception {
        Processing p = new Processing();
        long startTime = System.nanoTime();
        
        p.countAmount("001ç1234567891234çDiegoç50000 001ç3245678865434çRenatoç40000.99 002ç2345675434544345çJose da SilvaçRural 002ç2345675433444345çEduardo PereiraçRural 003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego");
        
        long endTime = System.nanoTime();

        long totalTime = endTime-startTime;

        System.out.println(totalTime);
    }
}