package com.company;

public class Main {

    public static void main(String[] args) {
        Runner runner1 = new Runner("runner1");
        Runner runner2 = new Runner("runner2");
        Runner runner3 = new Runner("runner3");
        Runner runner4 = new Runner("runner4");
        Runner runner5 = new Runner("runner5");

        runner1.setRunnerFS(runner2,runner5);
        runner2.setRunnerFS(runner3,runner1);
        runner3.setRunnerFS(runner4,runner2);
        runner4.setRunnersFS(runner5,runner3);
        runner5.setRunnerFS(runner1,runner4);

        runner1.start();



    }
}
