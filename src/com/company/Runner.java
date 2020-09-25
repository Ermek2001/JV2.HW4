package com.company;

public class Runner extends Thread {
    private volatile Runner runnerF;
    private volatile Runner runnerS;

    public Runner(String name) {
        super(name);
    }

    public void setRunnerF(Runner runnerF, Runner runnerS) {
        this.runnerF = runnerF;
        this.runnerS = runnerS;
    }

    @Override
    public synchronized void run() {
        cattyFuzzy();
    }

    public synchronized void cattyFuzzy() {
        System.out.println(getName() + "берет палочку");
        try {
            sleep(500);
        } catch (InterruptedException ignored) {
        }

        if (getName().equals("runner5")) {
            System.out.println(getName() + "бежит к финишу");
            try {
                sleep(500);
            } catch (InterruptedException ignored) {
            }

            System.out.println(getName() + "бежит к " + runnerS.getName());

            try {
                sleep(500);
            } catch (InterruptedException ignored) {
            }
            runnerF.start();
            try {
                runnerF.join();
            } catch (InterruptedException ignored) {
            }
        }
        if (!getName().equals("runner5")) {
            System.out.println(getName() + "берет палочку");
        }

        try {
            sleep(500);
        } catch (InterruptedException ignored) {
        }

        if (!getName().equals("runner1")) && !getName().equals("runner5")){
            System.out.println(getName() + "бежит к " + runnerS.getName());
        }
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}